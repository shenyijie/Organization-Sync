package com.shine.company;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("local")
class ApplicationTests {
    @Autowired
    private UserSyncServiceImpl userSync;

    @Test
    void userLoadTest() {
        userSync.syncUserInfo("JiaMin.Chen");
    }
}
