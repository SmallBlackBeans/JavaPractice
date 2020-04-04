package com.hanxiaocu.jwt.service;


import com.hanxiaocu.jwt.pojo.UserInfo;
import com.hanxiaocu.jwt.pojo.UserRole;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Levin
 * @date 2017-08-15.
 */
@Service
public class UserRoleService {

    public List<UserRole> getRoleByUser(UserInfo user) {
        if ("test".equals(user.getUserName())) {
            //@see ExpressionUrlAuthorizationConfigurer  private static String hasAnyRole(String... authorities) 带 ROLE_
            return Lists.newArrayList(new UserRole("ROLE_ADMIN"));
        }
        return null;
    }
}
