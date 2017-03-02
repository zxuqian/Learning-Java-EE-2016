package com.zxuqian.notebook.web;

import com.zxuqian.notebook.domain.User;
import com.zxuqian.notebook.service.client.IUserServiceLocal;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by zxuqian on 2/21/17.
 */
@ManagedBean
@RequestScoped
public class UserBackBean implements Serializable {

    private Logger logger = Logger.getLogger(UserBackBean.class.getCanonicalName());

    //@PersistenceContext(unitName = "notebookDomain")
    //private EntityManager entityManager;

    @EJB
    private IUserServiceLocal userService;

    private List<User> users;

    private User user;

    public UserBackBean() {
        this.user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(User user) {
        this.users.add(user);
    }

    public String register() {
        this.userService.addUser(this.user);
        return this.getAllUsers();
    }

    public String getAllUsers() {
        this.users = this.userService.getAllUsers();

        return "user_list";
    }
}
