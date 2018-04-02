package com.lm.pojo;

import java.io.Serializable;
import java.util.Date;

public class BookUser implements Serializable {
    private static final long serialVersionUID = -3847014101943570674L;
    private Integer id;
    private String account;
    private String password;
    private String usertype;
    private String name;
    private String sex;
    private String library_card;
    private String cardtype;
    private String card_id;
    private String phone;
    private String email;
    private Date reg_date;
    private String manager;
    private String back_up;

    public BookUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLibrary_card() {
        return library_card;
    }

    public void setLibrary_card(String library_card) {
        this.library_card = library_card;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getBack_up() {
        return back_up;
    }

    public void setBack_up(String back_up) {
        this.back_up = back_up;
    }

    @Override
    public String toString() {
        return "BookUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", usertype='" + usertype + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", library_card='" + library_card + '\'' +
                ", cardtype='" + cardtype + '\'' +
                ", card_id='" + card_id + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", reg_date=" + reg_date +
                ", manager='" + manager + '\'' +
                ", back_up='" + back_up + '\'' +
                '}';
    }
}
