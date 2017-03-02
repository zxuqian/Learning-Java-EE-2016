package com.zxuqian.notebook.service.client;

import com.zxuqian.notebook.domain.User;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by zxuqian on 3/1/17.
 */
public interface IUserService {

    User getUserById(Long id);

    List<User> getAllUsers();

    Long addUser(User user);

    void deleteUser(User user);
}
