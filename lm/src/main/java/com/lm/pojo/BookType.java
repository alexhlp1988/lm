package com.lm.pojo;

import java.io.Serializable;

public class BookType implements Serializable {
    private static final long serialVersionUID = 533343722249073930L;

    private Integer id;
    private String typename;

    public BookType() {

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
}
