package com.stone.learn.springdatajpa.repository;

import com.stone.learn.springdatajpa.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/8/7
 **/
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
