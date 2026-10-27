package com.shine.company;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

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
 * @since 2025/9/2 15:08
 */
@Data
@Slf4j
public class DBConnection {
    private String jdbcUrl;
    private String user;
    private String password;
    private String schema;
    private String table;

    private boolean success = true;
    private String message;

    public DBConnection(String jdbcUrl, String user, String password) {
        this.jdbcUrl = jdbcUrl;
        this.user = user;
        this.password = password;
    }
}
