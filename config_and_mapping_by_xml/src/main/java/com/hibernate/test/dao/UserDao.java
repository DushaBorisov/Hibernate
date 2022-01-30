package com.hibernate.test.dao;

import com.hibernate.test.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class UserDao {

    private final SessionFactory factory;

    public UserDao(final SessionFactory factory) {
        this.factory = factory;
    }

    public void create(User testUser) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(testUser);
            session.getTransaction().commit();
        }
    }

    public Optional<User> read(Long key) {
        try (final Session session = factory.openSession()) {
            User result = session.get(User.class, key);
            return Optional.ofNullable(result);
        }
    }

    public void update(User user) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }
    }

    public void delete(User user) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }
    }
}
