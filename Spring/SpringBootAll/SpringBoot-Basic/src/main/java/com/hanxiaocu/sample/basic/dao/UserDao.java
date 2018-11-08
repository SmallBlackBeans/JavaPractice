package com.hanxiaocu.sample.basic.dao;

import com.hanxiaocu.sample.basic.domain.PO.User;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/23 10:50 AM
 */
@Repository //声明此类是一个数据库或者其他 NoSQL 出问类
public class UserDao implements CrudDao<User, String>{

}
