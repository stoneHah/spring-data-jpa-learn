package com.stone.learn.springdatajpa.repository;

import com.stone.learn.springdatajpa.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/8/7
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddUser(){
        User user = new User("aa@stone.com","Jane","Slav");
        userRepository.save(user);

        user = new User("bbac@stone.com","Stone","Slav");
        userRepository.save(user);

        user = new User("bbac@stone.com","Jone","Yueh");
        userRepository.save(user);
    }

    @Test
    public void testFindById() {
        Optional<User> optional = userRepository.findById(9l);
//        optional.get()
    }

    @Test
    public void testGetAllUser(){
        Iterable<User> iterable = userRepository.findAll();
        iterable.forEach(u -> System.out.println(u.toString()));
    }

    @Test
    public void testDeleteByEntity(){
        User entity = new User();
        entity.setId(11l);

        userRepository.delete(entity);
    }

    @Test
    public void testDeleteByLastName(){
        long result = userRepository.deleteByLastName("Slav");
        System.out.println(result);
    }

    @Test
    public void testDeleteByLastNameLike(){
        long result = userRepository.deleteByLastNameLike("Yue");
        System.out.println(result);
    }

    @Test
    public void testCountByLastName(){
        long count = userRepository.countByLastName("Slav");
        System.out.println("last name eq Slav:" + count);
    }

    @Test
    public void testFetchUsers(){
        List<User> users = userRepository.fetchAllUser();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testFindByLastName(){
        User user = userRepository.findByLastName("yueh");
        System.out.println(user.toString());
    }

}
