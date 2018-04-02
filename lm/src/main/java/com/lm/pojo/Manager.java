package com.lm.pojo;

import java.io.Serializable;

public class Manager implements Serializable {
    private static final long serialVersionUID = 8784908495151937204L;
    private Integer id;
    private String mname;
    private String password;
    private String rights;

    public Manager() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }
}
