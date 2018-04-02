package com.lm.pojo;

import java.io.Serializable;
import java.util.Date;

public class BookWarningBack implements Serializable {
    private String isbn;
    private String bookname;//书名
    private String account;//读者名称
    private String cardtype;//证件类型
    private String card_id;//证件号
    private String username;//读者真是姓名
    private String email;
    private String phone;
    private String usertype;//读者类型
    private Date borrow_date;//借书日期
    private Date expire_date;//到期日期

    public BookWarningBack() {

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
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

    @Override
    public String toString() {
        return "BookWarningBack{" +
                "isbn=" + isbn +
                ", bookname='" + bookname + '\'' +
                ", account='" + account + '\'' +
                ", cardtype='" + cardtype + '\'' +
                ", card_id='" + card_id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", usertype='" + usertype + '\'' +
                ", borrow_date=" + borrow_date +
                ", expire_date=" + expire_date +
                '}';
    }
}
