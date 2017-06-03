package com.zxuqian.notebook.web;

import com.zxuqian.notebook.domain.User;
import com.zxuqian.notebook.service.client.IUserServiceLocal;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
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

    public void userNameChanged(ValueChangeEvent event) {
        if(null != event.getNewValue()) {
            logger.info("Entering user name changed listener: " + event.getNewValue());
        }

    }

    public void increaseClickCounts(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        Object obj = context.getExternalContext().getSessionMap().get("count");
        if(obj != null) {
            Integer count = (Integer) obj;
            count++;
            context.getExternalContext().getSessionMap().put("count", count);
        } else {
            context.getExternalContext().getSessionMap().put("count", 1);
        }

    }
}
