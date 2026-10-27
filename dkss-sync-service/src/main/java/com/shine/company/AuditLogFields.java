package com.shine.company;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

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
 * @since 2025/9/3 10:55
 */
@Data
@Component
@RequiredArgsConstructor
public class AuditLogFields {
    @Value("${sync.auditLog.field.id}")
    private String id;

    @Value("${sync.auditLog.field.appName}")
    private String appName;

    @Value("${sync.auditLog.field.module}")
    private String module;

    @Value("${sync.auditLog.field.subModule}")
    private String subModule;

    @Value("${sync.auditLog.field.action}")
    private String action;

    @Value("${sync.auditLog.field.operation}")
    private String operation;

    @Value("${sync.auditLog.field.detail}")
    private String detail;

    @Value("${sync.auditLog.field.userName}")
    private String userName;

    @Value("${sync.auditLog.field.createBy}")
    private String createBy;

    @Value("${sync.auditLog.field.createTime}")
    private String createTime;

    @Value("${sync.auditLog.field.ip}")
    private String ip;

    @Value("${sync.auditLog.field.duration}")
    private String duration;

    @Value("${sync.auditLog.field.result}")
    private String result;

    @Value("${sync.auditLog.field.securityLevel}")
    private String securityLevel;

    private List<String> field = CollectionUtil.newArrayList();
    private List<String> content = CollectionUtil.newArrayList();

    public void init() {
        // 清理之前的信息
        field.clear();
        content.clear();

        // 此处逻辑顺序要和AuditLogSync.java中的顺序一致
        addFiled(id);
        addFiled(appName);
        addFiled(module);
        addFiled(subModule);
        addFiled(action);
        addFiled(operation);
        addFiled(detail);
        addFiled(userName);
        addFiled(createBy);
        addFiled(createTime);
        addFiled(ip);
        addFiled(duration);
        addFiled(result);
        addFiled(securityLevel);
    }

    public String getFieldNames() {
        return StrUtil.join(",", field);
    }

    public String getFieldContent() {
        return StrUtil.join(",", content);
    }

    private void addFiled(String name) {
        if (StrUtil.isNotBlank(name)) {
            field.add(name);
            content.add("?");
        }
    }
}
