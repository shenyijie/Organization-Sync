package com.shine.company;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Map;

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
 *
 * @author Shine
 * @since 2025/7/18 18:50
 */
@Data
@Slf4j
public class UserInfo {
    private Long userId;
    private String account;
    private String password;
    private String name;
    private String email;
    private String thirdId;
    private Integer securityLevel;

    private String orgCodeRaw;
    private String orgNameRaw;

    private String deptCode;

    // 最小部门的id
    private String groupId = null;

    // 最大部门的id
    private String firstGroupId = null;

    // 部门的层级关系（从小到大，方便分析）
    Map<String, String> groupRelationMap =  MapUtil.newHashMap();

    // 部门的层级关系（从大到小，方便添加）
    Map<String, String> groupChildMap =  MapUtil.newHashMap();

    // 部门名称
    Map<String, String> groupNameMap =  MapUtil.newHashMap();

    // 存放添加到Xpros的id信息
    Map<String, Long> groupIdMap =  MapUtil.newHashMap();

    // 角色id
    private String roleId = null;

    // xpros的角色id
    private Long xprosRoleId = null;

    private HashSet<Long> xprosRoleIds = CollectionUtil.newHashSet();

    // 角色名称
    private String roleName = null;

    // jpass的菜单key
    HashSet<String> menuKeys = CollectionUtil.newHashSet();

    private boolean success = true;
    private String failReason;

    public void addGroupId(String groupId, Long xprosId) {
        groupIdMap.put(groupId, xprosId);
    }

    public void addGroup(String groupId, String name, String childGroupId) {
        if (ObjectUtil.isNull(childGroupId)) {
            // 防止用户只有1个部门
            firstGroupId = groupId;
        } else {
            groupRelationMap.put(childGroupId, groupId);
        }
        groupNameMap.put(groupId, name);
    }

    public void addMenuKey(String menuKey) {
        menuKeys.add(menuKey);
    }

    public void clearMenuKey() {
        menuKeys.clear();
    }

    /**
     * 分析部门由上至下的关系，因为同步到Xpros需要先拿到父级部门id才能去添加子集的部门id
     */
    public void analysisGroup() {
        log.info("组织关系为：{}", groupRelationMap);
        for (Map.Entry<String, String> entry : groupRelationMap.entrySet()) {
            String groupId = entry.getKey();
            String parentId = entry.getValue();
            groupChildMap.put(parentId, groupId);
            if (!groupRelationMap.containsKey(parentId)) {
                firstGroupId = parentId;
            }
        }
    }

    public String getChildGroupId(String groupId) {
        return groupChildMap.get(groupId);
    }

    public String getGroupName(String groupId) {
        return groupNameMap.get(groupId);
    }

    public Long getXprosGroupId(String groupId) {
        return groupIdMap.get(groupId);
    }

    public boolean hasGroup() {
        if (StrUtil.isBlank(groupId) || StrUtil.equals(groupId, "0")) {
            return false;
        } else {
            return groupNameMap.containsKey(groupId);
        }
    }

    public boolean hasParentGroup(String currentGroupId) {
        return groupNameMap.containsKey(currentGroupId);
    }

    public boolean hasChildGroup(String currentGroupId) {
        return groupChildMap.containsKey(currentGroupId);
    }

    public boolean hasMenuKeys() {
        return ObjectUtil.isNotEmpty(menuKeys);
    }

    public boolean hasXprosGroup(String currentGroupId) {
        return groupIdMap.containsKey(currentGroupId);
    }

    public boolean hasXprosRole() {
        return ObjectUtil.isNotNull(xprosRoleId);
    }

    public void setFail(String failReason) {
        setSuccess(false);
        log.error(failReason);
        setFailReason(failReason);
    }

    public void setXprosRoleId(Long xprosRoleId) {
        this.xprosRoleId = xprosRoleId;
        xprosRoleIds.add(xprosRoleId);
    }
}
