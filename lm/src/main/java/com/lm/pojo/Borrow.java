package com.lm.pojo;

import java.io.Serializable;
import java.util.Date;

public class Borrow implements Serializable {
    private static final long serialVersionUID = -6124001846274662329L;
    private Integer id;
    private Integer book_id;
    private Integer user_id;
    private Date borrow_date;
    private Date expire_date;
    private Date back_date;
    private Integer is_back;
    private String manager;

    public Borrow() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public Date getBack_date() {
        return back_date;
    }

    public void setBack_date(Date back_date) {
        this.back_date = back_date;
    }

    public Integer getIs_back() {
        return is_back;
    }

    public void setIs_back(Integer is_back) {
        this.is_back = is_back;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
