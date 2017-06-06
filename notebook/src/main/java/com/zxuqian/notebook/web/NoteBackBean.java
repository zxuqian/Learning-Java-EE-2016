package com.zxuqian.notebook.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ManagedBean
@RequestScoped
public class NoteBackBean {

    private String name;
    private String email;
    private String note;
    private String categoryName;

    private List<String> categories = new ArrayList<>();

    public static final String CATEGORY_SESSION_KEY = "category";

    //private static final Logger log = Logger.getLogger(Note.class.getCanonicalName());

    public void addCategory() {
        categories.add(categoryName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<String> getCategories() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
        if(sessionMap.get(CATEGORY_SESSION_KEY) == null) {
            sessionMap.put(CATEGORY_SESSION_KEY, categories);
        } else {
            categories = (List<String>)sessionMap.get(CATEGORY_SESSION_KEY);
        }
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}