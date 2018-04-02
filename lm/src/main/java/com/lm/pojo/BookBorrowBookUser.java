package com.lm.pojo;

import java.io.Serializable;
import java.util.Date;

public class BookBorrowBookUser implements Serializable{
    private static final long serialVersionUID = 4270504553722056900L;
    private Integer id;
    private Integer book_id;
    private Integer user_id;
    private Integer is_back;
    private String isbn;
    private String library_card;
    private String bookname;
    private String account;
    private String username;
    private Date borrow_date;
    private Date expire_date;
    private String manager;
    private Date back_date;

    public BookBorrowBookUser() {
    }

    public Date getBack_date() {
        return back_date;
    }

    public void setBack_date(Date back_date) {
        this.back_date = back_date;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
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

    public Integer getIs_back() {
        return is_back;
    }

    public void setIs_back(Integer is_back) {
        this.is_back = is_back;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLibrary_card() {
        return library_card;
    }

    public void setLibrary_card(String library_card) {
        this.library_card = library_card;
    }

    @Override
    public String toString() {
        return "BookBorrowBookUser{" +
                "id=" + id +
                ", book_id=" + book_id +
                ", user_id=" + user_id +
                ", is_back=" + is_back +
                ", isbn='" + isbn + '\'' +
                ", library_card='" + library_card + '\'' +
                ", bookname='" + bookname + '\'' +
                ", account='" + account + '\'' +
                ", username='" + username + '\'' +
                ", borrow_date=" + borrow_date +
                ", expire_date=" + expire_date +
                ", manager='" + manager + '\'' +
                ", back_date=" + back_date +
                '}';
    }
}
