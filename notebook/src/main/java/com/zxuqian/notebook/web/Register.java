package com.zxuqian.notebook.web;

import com.zxuqian.notebook.domain.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by zxuqian on 2/21/17.
 */
@ManagedBean
@RequestScoped
public class Register {


    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String register() {

        return "register_response";
    }
}
