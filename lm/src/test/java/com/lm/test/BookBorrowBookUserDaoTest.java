package com.lm.test;

import com.lm.dao.BookBorrowBookUserDao;
import com.lm.pojo.BookBorrowBookUser;
import org.junit.Before;
import org.junit.Test;

public class BookBorrowBookUserDaoTest {
    private BookBorrowBookUserDao dao;

    @Test
    public void update(){
        BookBorrowBookUser bookBorrowBookUser = new BookBorrowBookUser();
        bookBorrowBookUser.setIsbn("1111111111111");
        bookBorrowBookUser.setLibrary_card("34534534656478");
        bookBorrowBookUser.setIs_back(0);
        bookBorrowBookUser.setManager("admin");
        int count = dao.modify(bookBorrowBookUser);
        if (count>0) {
            System.out.println("OK");
        } else {
            System.out.println("fail");
        }
    }

    @Before
    public void init(){
        dao = new BookBorrowBookUserDao();
    }
}
