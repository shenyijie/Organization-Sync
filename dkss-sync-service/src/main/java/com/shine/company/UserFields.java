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
public class UserFields {
    @Value("${sync.login.userField.userId}")
    private String userId;

    @Value("${sync.login.userField.userNo}")
    private String userNo;

    @Value("${sync.login.userField.email}")
    private String email;

    @Value("${sync.login.userKey}")
    private String userKey;

    @Value("${sync.login.userField.securityLevel}")
    private String securityLevel;

    @Value("${sync.login.userField.name}")
    private String name;

    public String init() {
        // 清理之前的信息
        List<String> fields = CollectionUtil.newArrayList();

        fields.add(userId);
        fields.add(userNo);
        fields.add(email);
        fields.add(securityLevel);
        fields.add(name);
        return StrUtil.join(",", fields);
    }
}
