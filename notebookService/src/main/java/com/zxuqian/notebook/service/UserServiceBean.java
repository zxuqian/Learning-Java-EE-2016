package com.zxuqian.notebook.service;

import com.zxuqian.notebook.dao.IUserDao;
import com.zxuqian.notebook.dao.impl.UserDao;
import com.zxuqian.notebook.domain.User;
import com.zxuqian.notebook.service.client.IUserServiceLocal;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by zxuqian on 2/28/17.
 */

@Stateful
public class UserServiceBean implements IUserServiceLocal {

    @PersistenceContext
    private EntityManager entityManager;

    private IUserDao userDao;

    @PostConstruct
    private void init() {
        this.userDao = new UserDao(entityManager);
    }

    public User getUserById(Long id) {
        return this.userDao.getUserById(id);
    }

    public List<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }

    public Long addUser(User user) {
        return this.userDao.addUser(user);
    }

    public void deleteUser(User user) {
        this.userDao.deleteUser(user);
    }
}
