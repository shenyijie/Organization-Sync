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
public class GroupMenuFields {
    @Value("${sync.login.roleMenuField.menuId}")
    private String menuId;

    @Value("${sync.login.roleMenuField.menuKey}")
    private String menuKey;

    @Value("${sync.login.roleMenuField.roleId}")
    private String roleId;

    public String init() {
        // 清理之前的信息
        List<String> fields = CollectionUtil.newArrayList();

        fields.add(menuId);
        fields.add(menuKey);
        return StrUtil.join(",", fields);
    }
}
