package com.shine.company;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.shine.company.api.UserSyncService;
import com.shine.entity.*;
import com.shine.mapper.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * ━━━━━━━━━佛祖保佑━━━━━━━━━━━
 *                  ,;,,;
 *                ,;;' (    社
 *      ___      ,;;' ' \   会
 *    /'  '\'~~'~' \ /'\.)  主
 * ,;(      )     /  |.     义
 *,;' \    /-.,,(   ) \     码
 *     ) /       ) / )|     农
 *     ||        ||  \\
 *    (_\       (_\  (_\
 * ━━━━━━━━━永无BUG━━━━━━━━━━━━
 * 用户登录时加载用户相关的数据信息
 *
 * @author Shine
 * @since 2025/9/4 13:47
 */
@DubboService
@Component
@Slf4j
@RequiredArgsConstructor
public class UserSyncServiceImpl implements UserSyncService {
    private final SystemUserMapper userMapper;
    private final SystemDepartmentMapper departmentMapper;
    private final UserFields userFields;
    private final UserRelationFields userRelationFields;
    private final UserGroupFields userGroupFields;
    private final UserBindMapper userBindMapper;
    private final GroupMenuFields groupMenuFields;
    private final SystemMenuFields systemMenuFields;
    private final FunctionPermissionMapper permissionMapper;
    private final SystemRoleMapper systemRoleMapper;
    private final RolePermissionMapper rolePermissionMapper;

    @Value("${sync.login.url}")
    private String url;

    @Value("${sync.login.username}")
    private String username;

    @Value("${sync.login.password}")
    private String password;

    @Value("${sync.login.userSchema}")
    private String userSchema;

    @Value("${sync.login.systemSchema}")
    private String systemSchema;

    @Value("${sync.login.userTable}")
    private String userTable;

    @Value("${sync.login.userRelationTable}")
    private String userRelationTable;

    @Value("${sync.login.userGroupTable}")
    private String userGroupTable;

    @Value("${sync.login.groupMenuTable}")
    private String groupMenuTable;

    @Value("${sync.login.systemMenuTable}")
    private String systemMenuTable;

    @Value("${sync.login.userKey}")
    private String userKey;

    @Value("${sync.login.defaultPass}")
    private String defaultPass;

    private static final String USER_BELONG = "GROUP-USER-BELONG";

    @Override
    public Long syncUserInfo(String user) {
        if (StrUtil.isBlank(user)) {
            log.warn("需要同步的用户信息为空");
            return null;
        }
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // 1. 获取用户信息
            UserInfo userInfo = handleUserInfo(connection, user);
            if (Objects.isNull(userInfo)) {
                return null;
            }

            // 2. 获取用户的组织、角色关联信息
            handleUserGroup(connection, userInfo);

            // 3. 获取用户的角色信息
            handleUserRole(connection, userInfo);

            return userInfo.getUserId();
        } catch (SQLException e) {
            log.error("加载用户信息出错：", e);
        }
        return null;
    }

    /**
     * group代表是十所jpass的信息，department表示是xpros的信息
     */
    @SuppressWarnings("ReassignedVariable")
    private void handleAddDepartments(UserInfo userInfo) {
        if (!userInfo.hasGroup()) {
            log.error("用户 {} 没有有效的部门信息，跳过部门同步", userInfo.getAccount());
        }

        userInfo.analysisGroup();
        String firstGroup = userInfo.getFirstGroupId();
        handleDepartmentAdd(userInfo, firstGroup, userInfo.getGroupName(firstGroup), -1L);
        String currentGroup = firstGroup;
        while (userInfo.hasChildGroup(currentGroup)) {
            if (!userInfo.hasXprosGroup(currentGroup)) {
                // 有可能父级没有添加成功，此时直接失败
                log.warn("未能查询到 {} {} xpros对应的Id", currentGroup, userInfo.getGroupName(currentGroup));
                break;
            }
            String childGroupId = userInfo.getChildGroupId(currentGroup);
            handleDepartmentAdd(userInfo, childGroupId, userInfo.getGroupName(childGroupId), userInfo.getXprosGroupId(currentGroup));
            currentGroup = childGroupId;
        }
    }

    /**
     * 绑定用户和部门的关系
     */
    private void handleBindGroup(UserInfo userInfo) {
        UserBindEntity bindEntity = userBindMapper.getDepartmentByUser(userInfo.getUserId());
        Long departmentId = userInfo.getXprosGroupId(userInfo.getGroupId());
        log.info("正在绑定用户和组在关系：{} {} {}", userInfo.getAccount(), userInfo.getGroupId(), departmentId);
        if (ObjectUtil.isNull(bindEntity)) {
            syncGroupBind(userInfo, departmentId, "DEPARTMENT");
        } else {
            log.info("用户 {}，之前组织为 {}，更新为 {}", userInfo.getAccount(), bindEntity.getBindId(), departmentId);
            if (!departmentId.equals(bindEntity.getBindId())) {
                log.info("正在更新用户 {} 组织信息为：{}", userInfo.getAccount(), departmentId);
                userBindMapper.delete(bindEntity);
                syncGroupBind(userInfo, departmentId,"DEPARTMENT");
            }
        }
    }

    /**
     * 绑定用户和角色的关系
     */
    private void handleBindRole(UserInfo userInfo) {
        if (!userInfo.hasXprosRole()) {
            return;
        }
        Long roleId = userInfo.getXprosRoleId();
        UserBindEntity bindEntity = userBindMapper.getRoleByBind(userInfo.getUserId(), roleId);
        if (ObjectUtil.isNull(bindEntity)) {
            syncGroupBind(userInfo, roleId,"ROLE");
        }
    }

    /**
     * 加载jpass用户信息并同步到xpros数据库，返回用户信息方便
     */
    private UserInfo handleUserInfo(Connection connection, String user) throws SQLException {
        log.info("加载用户 {} 的信息至xpros", user);
        String sql = StrUtil.format("select {} from {}.{} where {}=?", userFields.init(), userSchema, userTable, userKey, user);
        log.info(sql);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user);
        ResultSet resultSet = preparedStatement.executeQuery();
        UserInfo userInfo;
        if (resultSet.next()) {
            userInfo = new UserInfo();
            userInfo.setAccount(resultSet.getString(userFields.getUserNo()));
            userInfo.setPassword(defaultPass);
            userInfo.setName(resultSet.getString(userFields.getName()));
            userInfo.setEmail(resultSet.getString(userFields.getEmail()));
            userInfo.setThirdId(resultSet.getString(userFields.getUserId()));
            // 20251013: 版本密级还未适配，先固定为0
            userInfo.setSecurityLevel(0);
            // userInfo.setSecurityLevel(resultSet.getInt(userFields.getSecurityLevel()));
            log.info("用户「{} {}」信息分析同步成功", userInfo.getAccount(), userInfo.getName());
            handleUserAdd(userInfo);
        } else {
            log.warn("需要同步的用户 {}，信息查询为空", user);
            return null;
        }
        return userInfo;
    }

    /**
     * 加载jpass用户组织信息并同步到xpros数据库
     */
    private void handleUserGroup(Connection connection, UserInfo userInfo) throws SQLException {
        log.info("加载用户 {} 的组织信息至xpros", userInfo.getName());
        String sql = StrUtil.format("select {} from {}.{} where {}='1' and {}=? and {}='{}'", userRelationFields.init(), userSchema, userRelationTable, userRelationFields.getDimension(), userRelationFields.getUserId(), userRelationFields.getRealType(), USER_BELONG);
        log.info(sql);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userInfo.getThirdId());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            // 组织Id
            handleGroup(connection, userInfo, resultSet.getString(userRelationFields.getBindId()), null);

            // 同步部门信息
            handleAddDepartments(userInfo);

            // 绑定用户和部门的关系
            if (userInfo.hasXprosGroup(userInfo.getGroupId())) {
                handleBindGroup(userInfo);
            }
        } else {
            log.warn("需要同步的用户 {}，组织信息为空", userInfo.getAccount());
        }
    }

    private void handleUserRole(Connection connection, UserInfo userInfo) throws SQLException {
        log.info("加载用户 {} 的角色信息至xpros", userInfo.getName());
        String sql = StrUtil.format("select {} from {}.{} where {}='2' and {}=?", userRelationFields.init(), userSchema, userRelationTable, userRelationFields.getDimension(), userRelationFields.getUserId());
        log.info(sql);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userInfo.getThirdId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            // 角色Id
            handleRole(connection, userInfo, resultSet.getString(userRelationFields.getBindId()));
            // 绑定用户和部门的关系
            handleBindRole(userInfo);
            // 清空权限Key
            userInfo.clearMenuKey();
        }

        // 清理未绑定的角色关系
        log.info("清理用户 {} 和以下角色绑定 {}，未关联的角色将被解绑", userInfo.getName(), userInfo.getXprosRoleIds());
        userBindMapper.deleteRolesNotInBinds(userInfo.getUserId(), userInfo.getXprosRoleIds());
    }

    /**
     * 加载部门信息
     */
    private void handleGroup(Connection connection, UserInfo userInfo, String groupId, String childGroup) throws SQLException {
        String sql = StrUtil.format("select {} from {}.{} where {}=?", userGroupFields.init(), userSchema, userGroupTable, userGroupFields.getId());
        log.info(sql);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, groupId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            if (ObjectUtil.isNull(childGroup)) {
                userInfo.setGroupId(groupId);
            }
            String groupName = resultSet.getString(userGroupFields.getName());
            String parentId = resultSet.getString(userGroupFields.getParentId());
            log.info("查询到的组织信息为：{}, {}", groupName, parentId);
            userInfo.addGroup(groupId, groupName, childGroup);

            if (StrUtil.isNotBlank(parentId) && !StrUtil.equals(parentId, "0")) {
                // 存在父节点
                handleGroup(connection, userInfo, parentId, groupId);
            }
        } else {
            log.warn("用户 {} 需要同步的组织 {}，查询信息为空", userInfo.getAccount(), groupId);
        }
    }

    /**
     * 处理角色信息
     */
    @SuppressWarnings("ReassignedVariable")
    private void handleRole(Connection connection, UserInfo userInfo, String roleId) throws SQLException {
        log.info("分析用的角色配置：{}, {}", userInfo.getAccount(), roleId);
        String sql = StrUtil.format("select {} from {}.{} where {}=?", userGroupFields.init(), userSchema, userGroupTable, userGroupFields.getId());
        log.info(sql);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, roleId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String roleName = resultSet.getString(userGroupFields.getName());
            userInfo.setRoleId(roleId);
            userInfo.setRoleName(roleName);
            log.info("查询到的角色名为：{}，{}", roleId, roleName);

            // 查询角色关联的菜单id
            handleRoleMenu(connection, userInfo);

            if (!userInfo.hasMenuKeys()) {
                // 该角色没有对应的菜单选项，角色信息不配置
                return;
            }

            // 获取jpass菜单对应的xpros key id（创建角色需要）
            List<FunctionPermissionEntity> permissionEntities = permissionMapper.getByKeys(userInfo.getMenuKeys());
            List<Long> permissionIds = CollectionUtil.newArrayList();
            if (ObjectUtil.isNotEmpty(permissionEntities)) {
                permissionEntities.forEach(permissionEntity -> permissionIds.add(permissionEntity.getId()));
            }

            // 创建（或更新角色）角色
            SystemRoleEntity roleEntity = systemRoleMapper.getByName(userInfo.getRoleName());
            Collections.sort(permissionIds);
            Long time = System.currentTimeMillis();
            String newPermission = JSONUtil.toJsonStr(CollectionUtil.newArrayList());
            if (ObjectUtil.isNull(roleEntity)) {
                // 还没有对应的角色实体
                roleEntity = new SystemRoleEntity();
                roleEntity.setId(IdUtil.getSnowflakeNextId());
                roleEntity.setCompanyId(Constant.COMPANY_ID);
                roleEntity.setDefaultRoleId(Constant.DEFAULT_ROLE_ID);
                roleEntity.setName(userInfo.getRoleName());
                roleEntity.setPermissionList(newPermission);
                roleEntity.setCreatorId(Constant.ROOT_ID);
                roleEntity.setCreateTime(time);
                roleEntity.setUpdaterId(Constant.ROOT_ID);
                roleEntity.setUpdateTime(time);
                roleEntity.setRemark(roleId);
                systemRoleMapper.insertSelective(roleEntity);
            }

            // 处理角色和id的关系
            handleRolePermission(roleEntity.getId(), permissionIds);

            userInfo.setXprosRoleId(roleEntity.getId());
        } else {
            log.warn("用户 {} 需要同步的角色 {}，查询信息为空", userInfo.getAccount(), roleId);
        }
    }

    /**
     * 加载角色对应的菜单信息
     */
    private void handleRoleMenu(Connection connection, UserInfo userInfo) throws SQLException {
        String sql = StrUtil.format("select {} from {}.{} where {}=?", groupMenuFields.init(), userSchema, groupMenuTable, groupMenuFields.getRoleId());
        log.info(sql);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userInfo.getRoleId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            handleMenu(userInfo, resultSet.getString(groupMenuFields.getMenuKey()));
        }
        log.info("查询到的管理菜单Key为：{}", userInfo.getMenuKeys());
    }

    private void handleRolePermission(Long roleId, List<Long> permissionIds) {
        log.info("处理Xpros角色和权限的绑定关系：{}，{}", roleId, permissionIds);

        // 1. 获取当前角色已经绑定的权限
        List<RolePermissionEntity> permissionEntities = rolePermissionMapper.getByRoleId(roleId);
        HashSet<Long> oldSet = CollectionUtil.newHashSet();
        if (ObjectUtil.isNotEmpty(permissionEntities)) {
            // 1.1. 清理没有关联的旧权限
            HashSet<RolePermissionEntity> deleteSet = CollectionUtil.newHashSet();

            permissionEntities.forEach(permissionEntity -> {
               if (permissionIds.contains(permissionEntity.getPermissionId())) {
                   oldSet.add(permissionEntity.getPermissionId());
               } else {
                   log.info("角色 {} 删除权限 {} ", roleId, permissionEntity.getPermissionId());
                   deleteSet.add(permissionEntity);
               }
            });
            deleteSet.forEach(rolePermissionMapper::delete);
        }

        // 2. 添加不存在的角色权限
        Long time = System.currentTimeMillis();
        for (Long permissionId : permissionIds) {
            if (!oldSet.contains(permissionId)) {
                log.info("角色 {} 增加权限 {} ", roleId, permissionId);
                RolePermissionEntity rpEntity = new RolePermissionEntity();
                rpEntity.setPermissionId(permissionId);
                rpEntity.setRoleId(roleId);
                rpEntity.setCreateTime(time);
                rpEntity.setUpdateTime(time);
                rolePermissionMapper.insertSelective(rpEntity);
            }
        }
    }

    /**
     * 加载菜单对应的key
     */
    private void handleMenu(UserInfo userInfo, String menuKey) {
        if (Constant.containsMenuKey(menuKey)) {
            userInfo.addMenuKey(Constant.getMenuKey(menuKey));
        }
    }

    /**
     * 向xpros数据库中添加用户信息
     */
    @SuppressWarnings("ReassignedVariable")
    private void handleUserAdd(UserInfo userInfo) {
        log.info("向Xpros同步用户信息：{}", userInfo.getAccount());
        SystemUserEntity userEntity = userMapper.getUserEntity(userInfo.getAccount());
        Long time = System.currentTimeMillis();
        if (Objects.isNull(userEntity)) {
            userEntity = new SystemUserEntity();
            userEntity.setId(IdUtil.getSnowflakeNextId());
            userEntity.setCompanyId(Constant.COMPANY_ID);
            userEntity.setAccount(userInfo.getAccount());
            userEntity.setPassword(userInfo.getPassword());
            userEntity.setName(userInfo.getName());
            userEntity.setEmail(userInfo.getEmail());
            userEntity.setCreatorId(Constant.ROOT_ID);
            userEntity.setCreateTime(time);
            userEntity.setUpdaterId(Constant.ROOT_ID);
            userEntity.setUpdateTime(time);
            userEntity.setSecretLevel(userInfo.getSecurityLevel());
            userEntity.setThirdId(userInfo.getThirdId());
            userMapper.insertSelective(userEntity);
        } else {
            boolean userChanged = false;
            if (!StrUtil.equals(userEntity.getName(), userInfo.getName())) {
                userChanged = true;
                userEntity.setName(userInfo.getName());
            }
            if (!StrUtil.equals(userEntity.getEmail(), userInfo.getEmail())) {
                userChanged = true;
                userEntity.setEmail(userInfo.getEmail());
            }
            if (!NumberUtil.equals(userEntity.getSecretLevel(), userInfo.getSecurityLevel())) {
                userChanged = true;
                userEntity.setSecretLevel(userInfo.getSecurityLevel());
            }
            if (userChanged) {
                userEntity.setUpdaterId(Constant.ROOT_ID);
                userEntity.setUpdateTime(time);
                userMapper.update(userEntity);
            }
        }
        userInfo.setUserId(userEntity.getId());
    }

    /**
     * 向xpros数据库中添加部门信息
     */
    @SuppressWarnings("ReassignedVariable")
    private void handleDepartmentAdd(UserInfo userInfo, String groupId, String groupName, Long parentId) {
        log.info("正在向Xpros添加组织信息：{} {} {} {}", userInfo.getAccount(), groupId, groupName, parentId);
        SystemDepartmentEntity departmentEntity = departmentMapper.getByThirdId(groupId);
        if (Objects.isNull(departmentEntity)) {
            // 查询为空
            userInfo.addGroupId(groupId, departmentMapper.insertNew(groupId, groupName, parentId));
        } else {
            boolean deptChanged = false;
            Long time = System.currentTimeMillis();
            if (!StrUtil.equals(departmentEntity.getName(), groupName)) {
                deptChanged = true;
                departmentEntity.setName(groupName);
            }
            if (!NumberUtil.equals(parentId, departmentEntity.getParentId())) {
                departmentEntity.setParentId(parentId);
                deptChanged = true;
            }
            if (deptChanged) {
                departmentEntity.setUpdaterId(com.shine.Constant.ROOT_ID);
                departmentEntity.setUpdateTime(time);
                departmentMapper.update(departmentEntity);
            }
            userInfo.addGroupId(groupId, departmentEntity.getId());
        }
    }

    private void syncGroupBind(UserInfo userInfo, Long bindId, String bindType) {
        Long time = System.currentTimeMillis();
        UserBindEntity bindEntity = new UserBindEntity();
        bindEntity.setUserId(userInfo.getUserId());
        bindEntity.setBindId(bindId);
        bindEntity.setBindType(bindType);
        bindEntity.setCreateTime(time);
        bindEntity.setUpdateTime(time);
        userBindMapper.insertSelective(bindEntity);
    }
}
