package com.lm.test;

import com.lm.dao.BookTypeDao;
import org.junit.Before;
import org.junit.Test;

public class BookTypeDaoTest {
    BookTypeDao dao;
    @Test
    public void checkbc(){
        int count = dao.checkBookCount("Java");
        System.out.println(count);
    }
    @Before
    public void init() {
        dao = new BookTypeDao();
    }
}
