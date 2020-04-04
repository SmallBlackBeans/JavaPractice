package com.hanxiaocu.sample.jpa.repository;

import com.hanxiaocu.sample.jpa.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/25 6:05 PM
 */
@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {

    ////基于方法名查询
    public User findByName(String name);


    //int updateById(User user);

    //Page<User> findByLastname(String lastname, Pageable pageable);
    //
    ////联合查询
    //List<User> findByLastnameAndFirstAndName(String lastname, String firstname);
    //
    //
    //List<User> findDistinctUserByLastnameOrFirstname(String lastname, String firstname);
    //
    //public User findByNameLike(String name);
    //
    ////public User findByAgeNotIn(Collection age);
    //
    ////JPQL 查询
    //@Query("select u from User u where u.name=?1 and u.department.id=?2")
    //public User findUser(String name,Integer departmentId);
    //
    ////SQL查询
    //@Query(value = "select * from user where name=?1 and department_id=?2",nativeQuery = true)
    //public User nativeQuery(String name,Integer departmentId);
    //
    ////命名参数
    //@Query(value = "select * from user where name=:name and department_id=:departmentId",nativeQuery = true)
    //public User nativeQuery2(String name,Integer departmentId);
    //
    //
    ////对于非实体返回结果，只能用Object[]接收
    //@Query(value = "select department_id,count (*) from user group by department_id",nativeQuery = true)
    //public List<Object[]> queryUserCont();//返回String 和 BigInteger类型
    //
    //@Query(value = "select u from User u where u.department.id=?1")
    //public Page<User> queryUsers(Integer departmentId, Pageable pageable);
    //
    ////更新、删除语句 必须搭配@modifying
    //@Modifying
    //@Query("update User u set u.name= ?1 where u.id = ?2")
    //int updateName(String name, Integer id);

}
