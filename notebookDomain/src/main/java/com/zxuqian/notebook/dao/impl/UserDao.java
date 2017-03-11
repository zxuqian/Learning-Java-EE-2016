package com.zxuqian.notebook.dao.impl;

import com.zxuqian.notebook.dao.IUserDao;
import com.zxuqian.notebook.domain.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by zxuqian on 2/28/17.
 */
public class UserDao implements IUserDao, Serializable {


    private EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public User getUserById(Long id) {
        return this.entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = this.entityManager.createNamedQuery(
                "getAllUsersQuery", User.class).getResultList();
        return userList;
    }

    @Override
    public Long addUser(User user) {
        this.entityManager.persist(user);
        return user.getId();
    }

    @Override
    public void deleteUser(User user) {
        user = this.entityManager.merge(user);
        this.entityManager.remove(user);

    }
}
