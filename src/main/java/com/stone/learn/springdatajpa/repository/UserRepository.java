package com.stone.learn.springdatajpa.repository;

import com.stone.learn.springdatajpa.entity.Customer;
import com.stone.learn.springdatajpa.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/8/7
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    long deleteByLastName(String lastName);

    @Transactional
    long deleteByLastNameLike(String lastName);

    long countByLastName(String lastName);

    User findByLastName(String lastName);

    @Query("from User")
    List<User> fetchAllUser();

    @Query("select lastName from User u")
    List<String> findLastNames();

    @Query("select u from User u")
    List<User> findByUserPageableJpql(Pageable pageable);

    @Query(value = "select * from user",nativeQuery = true)
    List<User> findByUserPageableNative(Pageable pageable);

    @Query(value = "select * from user ORDER BY :sort",nativeQuery = true)
    List<User> findByUserSortNative(@Param("sort") String sort);


    @Query("update User u set u.lastName=:lastName where u.id=:userId")
    int updateLastName(@Param("userId") int userId, @Param("lastName") String lastName);

}
