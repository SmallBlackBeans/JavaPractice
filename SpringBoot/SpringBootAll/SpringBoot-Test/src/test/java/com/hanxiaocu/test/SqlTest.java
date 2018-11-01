package com.hanxiaocu.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

// import javax.transaction.Transactional;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("mybatis")
// @Transactional
public class SqlTest {

    // @Autowired
    // @Qualifier("userRepository")
    // UserService userService;
    //
    // @Test
    // @Sql({"user.sql"})
    // public void updateNameTest() {
    //     User user = new User();
    //     user.setId(1);
    //     user.setName("hanxiaocu");
    //
    //     boolean success = userService.updateUser(user);
    //     assertTrue(success);
    // }

}
