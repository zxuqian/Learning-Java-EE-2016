package com.zxuqian.notebook.dao;

import com.zxuqian.notebook.domain.User;

import java.util.List;

/**
 * Created by zxuqian on 2/28/17.
 */
public interface IUserDao {

    User getUserById(Long id);

    List<User> getAllUsers();

    Long addUser(User user);

    void deleteUser(User user);
}
