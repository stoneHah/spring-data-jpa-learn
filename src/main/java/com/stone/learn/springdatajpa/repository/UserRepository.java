package com.stone.learn.springdatajpa.repository;

import com.stone.learn.springdatajpa.entity.Customer;
import com.stone.learn.springdatajpa.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/8/7
 **/
public interface UserRepository extends CrudRepository<User, Long> {

    @Transactional
    long deleteByLastName(String lastName);

    @Transactional
    long deleteByLastNameLike(String lastName);

    long countByLastName(String lastName);

    User findByLastName(String lastName);

    @Query("from User")
    List<User> fetchAllUser();
}
