package com.hibernate.test;

import com.hibernate.test.dao.UserDao;
import com.hibernate.test.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class Application {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        UserDao userDao = new UserDao(sessionFactory);

        // Create new User

//        User user1 = User.builder()
//                .id(1L)
//                .name("Andrey")
//                .surname("Borisov")
//                .age(19)
//                .build();
//
//        userDao.create(user1);

        // Get user by id

        Optional<User> user = userDao.read(1L);
        User userFromDb;

        if (user.isPresent()) {
            userFromDb = user.get();
            System.out.println(userFromDb);
        }


    }
}
