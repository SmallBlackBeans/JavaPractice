package com.hanxiaocu.repositories.jpa.dao;

import com.hanxiaocu.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/11/7
 */
public interface UserDao extends PagingAndSortingRepository<User, Long> {

    @Override
    Optional<User> findById(Long id);


    //使用自动命名规则进行查询服务
    List<User> findByCodeAndName(String code, String name);


    //使用@Query 查询 自定义sql 编写
    //nativeQuery=true 正常的sql语法
    //负责hsql语法
    //占位符为：?+具体的参数索引值
    @Query(value = "select * from user where code = ?1",nativeQuery = true)
    List<User> queryByCode(String code);

    //分页
    Page<User> findByCode(String code, Pageable pageable);







}
