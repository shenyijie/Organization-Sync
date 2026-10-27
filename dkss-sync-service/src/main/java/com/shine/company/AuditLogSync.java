package com.shine.company;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.shine.entity.SystemUserEntity;
import com.shine.entity.UserOperationLogEntity;
import com.shine.mapper.SystemUserMapper;
import com.shine.mapper.UserOperationLogMapper;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static cn.hutool.core.date.DatePattern.NORM_DATETIME_PATTERN;
import static com.shine.entity.table.UserOperationLogDef.USER_OPERATION_LOG;

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
 * @since 2025/9/2 10:39
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class AuditLogSync {
    private final UserOperationLogMapper logMapper;
    private final AuditLogFields auditLogFields;
    private final SystemUserMapper userMapper;

    @Value("${sync.auditLog.url}")
    private String url;

    @Value("${sync.auditLog.username}")
    private String username;

    @Value("${sync.auditLog.password}")
    private String password;

    @Value("${sync.auditLog.schema}")
    private String schema;

    @Value("${sync.auditLog.table}")
    private String table;

    @SuppressWarnings("ReassignedVariable")
    @Scheduled(cron = "${sync.auditLog.cron}")
    public void sync() {
        // 20251013：十所现场的机器时间不一致性，将时间提前8小时，防止服务器时区超前导致无数据
        long endTime = DateUtil.beginOfHour(DateUtil.date()).getTime() - 7 * 24 * 60 * 60 * 1000;
        long startTime = endTime - 60 * 60 * 1000L;

        QueryWrapper queryWrapper = QueryWrapper
                .create()
                .select()
                .where(USER_OPERATION_LOG.CREATE_TIME.ge(startTime))
                .and(USER_OPERATION_LOG.CREATE_TIME.lt(endTime));
        List<UserOperationLogEntity> logEntities = logMapper.selectListByQuery(queryWrapper);
        if (ObjectUtil.isEmpty(logEntities)) {
            log.info("开始审计日志导入任务，日志时间范围为：{} 至 {}，所需导入日志为空。", getDate(startTime), getDate(endTime));
            return;
        }
        log.info("开始审计日志导入任务，日志时间范围为：{} 至 {}，共计 {} 个日志。", getDate(startTime), getDate(endTime), logEntities.size());
        auditLogFields.init();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = StrUtil.format("insert into {}.{} ({}) values({})", schema, table, auditLogFields.getFieldNames(), auditLogFields.getFieldContent());
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);

            Map<String, SystemUserEntity> userEntityMap = MapUtil.newHashMap();

            for (int i = 0; i < logEntities.size(); i++) {
                UserOperationLogEntity logEntity = logEntities.get(i);
                String account = logEntity.getUserName();
                SystemUserEntity userEntity;
                if (userEntityMap.containsKey(account)) {
                    userEntity = userEntityMap.get(account);
                } else {
                    userEntity = userMapper.getUserEntity(account);
                    userEntityMap.put(account, userEntity);
                }

                int j = 1;
                // 此处逻辑顺序要和SyncFields.java中的顺序一致
                preparedStatement.setString(j++, String.valueOf(logEntity.getId()));
                preparedStatement.setString(j++, "XPROS");
                preparedStatement.setString(j++, logEntity.getFunModulesName());
                preparedStatement.setString(j++, logEntity.getFunModulesName());
                preparedStatement.setString(j++, logEntity.getOperationType());
                preparedStatement.setString(j++, logEntity.getOperationType());
                preparedStatement.setString(j++, logEntity.getBehavior());
                preparedStatement.setString(j++, logEntity.getNickName());
                preparedStatement.setString(j++, logEntity.getUserName());
                preparedStatement.setString(j++, DateUtil.format(DateUtil.date(logEntity.getCreateTime()), NORM_DATETIME_PATTERN));
                preparedStatement.setString(j++, logEntity.getIp());
                preparedStatement.setString(j++, "1000");
                preparedStatement.setString(j++, "操作成功");
                preparedStatement.setString(j++, String.valueOf(userEntity.getSecretLevel()));
                if (ObjectUtil.isNotNull(userEntity)) {
                    preparedStatement.setString(j, userEntity.getThirdId());
                } else {
                    preparedStatement.setString(j, null);
                }
                preparedStatement.addBatch();

                if (i % 100 == 0) {
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            preparedStatement.executeBatch();
            connection.commit();
            preparedStatement.clearBatch();
            log.info("日志导入完成");
        } catch (SQLException e) {
            log.error("写入审计出错：{}", e.getMessage());
        }
    }

    private String getDate(Long datetime) {
        return DateUtil.format(DateUtil.date(datetime), NORM_DATETIME_PATTERN);
    }
}
