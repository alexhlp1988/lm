package com.lm.pojo;

import java.io.Serializable;

public class BookUserType implements Serializable {
    private static final long serialVersionUID = 2681799628690796546L;

    private Integer id;
    private String typename;
    private Integer book_count;

    public BookUserType() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getBook_count() {
        return book_count;
    }

    public void setBook_count(Integer book_count) {
        this.book_count = book_count;
    }
}
