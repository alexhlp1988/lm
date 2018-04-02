package com.lm.dao;

import com.lm.pojo.BookBorrowBookUser;

import java.util.ArrayList;
import java.util.List;

public class BookBorrowBookUserDao {
    public int modify(BookBorrowBookUser bookBorrowBookUser) {
        int count = 0;
        try {
            BookBorrowBookUserMapper bookBorrowBookUserMapper = MybatisSessionFactory.getSession().getMapper(BookBorrowBookUserMapper.class);
            count = bookBorrowBookUserMapper.updatebookborrowbookuser(bookBorrowBookUser);
            MybatisSessionFactory.getSession().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return count;
    }

    public List<BookBorrowBookUser> find() {
        List<BookBorrowBookUser> bookBorrowBookUsers = new ArrayList<>();
        try {
            BookBorrowBookUserMapper mapper = MybatisSessionFactory.getSession().getMapper(BookBorrowBookUserMapper.class);
            bookBorrowBookUsers = mapper.find();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return bookBorrowBookUsers;
    }
}
