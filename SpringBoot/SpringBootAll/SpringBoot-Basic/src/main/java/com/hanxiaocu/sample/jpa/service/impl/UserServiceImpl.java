package com.hanxiaocu.sample.jpa.service.impl;

import com.hanxiaocu.sample.basic.service.CreditUserService;
import com.hanxiaocu.sample.jpa.Entity.Department;
import com.hanxiaocu.sample.jpa.Entity.User;
import com.hanxiaocu.sample.jpa.repository.UserRepository;
import com.hanxiaocu.sample.jpa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/25
 */
@Service("userRepository")
@Transactional
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CreditUserService creditUserService;

    @Autowired
    UserRepository userDao;

    @Autowired
    EntityManager em;

    public Integer addUser(User user) {
        userDao.save(user);//插入
        Integer id = user.getId();
        user.setName("hanxiaocu");
        userDao.save(user);//更新
        return id;
    }

    public List<User> getUsersSortById() {
        //默认升序
        //Sort sort = new Sort(Sort.Direction.DESC, "id");
        Sort sort = Sort.by(Sort.Order.asc("id"), Sort.Order.desc("name"));
        return userDao.findAll(sort);
    }

    public List<User> getAllUser(int page, int size) {
        PageRequest pageable  = PageRequest.of(page, size);
        Page<User>  pageObj   = userDao.findAll(pageable);
        long        total     = pageObj.getTotalElements();//总数
        int         totalPage = pageObj.getTotalPages();
        return pageObj.getContent();
    }

    public Page<User> queryUser2(Integer departmentId, Pageable pageable) {
        StringBuilder       sb    = new StringBuilder("from User u where 1=1");
        Map<String, Object> paras = new HashMap<String, Object>();
        if (departmentId != null) {
            sb.append("and u.department.id=:deptId");
            paras.put("deptId", departmentId);
        }

        long count = getQueryCount(sb, paras);
        if (count == 0) {
            return new PageImpl<>(Collections.<User>emptyList(), pageable, 0);
        }

        List list = getQueryResult(sb, paras, pageable);
        Page ret  = new PageImpl(list, pageable, count);
        return ret;
    }

    private List getQueryResult(StringBuilder sb, Map<String, Object> paras, Pageable pageable) {
        Query query = em.createQuery("select u " + sb.toString());
        setQueryParameter(query, paras);
        query.setFirstResult((int) pageable.getOffset());//设置查询的起始位置
        query.setMaxResults(pageable.getPageNumber());//设置此次查询想要的数量
        List list = query.getResultList();
        return list;
    }

    private long getQueryCount(StringBuilder sb, Map<String, Object> paras) {
        Query query = em.createQuery("select count(1)" + sb.toString());
        setQueryParameter(query, paras);
        Number number = (Number) query.getSingleResult();
        return number.longValue();
    }

    private void setQueryParameter(Query query, Map<String, Object> paras) {
        for (Map.Entry<String, Object> entry : paras.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }

    //Example查询
    public List<User> getByExample(String name) {
        User       user       = new User();
        Department department = new Department();
        user.setName(name);
        department.setId(1);
        user.setDepartment(department);
        //以name开头的用户
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith().ignoreCase());

        Example<User> example = Example.of(user, matcher);
        List<User>    list    = userDao.findAll(example);
        return list;
    }

    @Override
    public int getCredit(int userId) {
        return creditUserService.getUserCredit(userId);
    }

    @Override
    public boolean updateUser(User user) {
        //int ret = userDao.updateById(user);
        return true;
    }
}
