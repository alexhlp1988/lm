package com.lm.dao;

import com.lm.pojo.BookWarningBack;

import java.util.ArrayList;
import java.util.List;

public class BookWarningBackDao {
    public List<BookWarningBack> finddate() {
        List<BookWarningBack> bookWarningBack = new ArrayList<>();
        try {
            BookWarningBackMapper mapper = MybatisSessionFactory.getSession().getMapper(BookWarningBackMapper.class);
            bookWarningBack = mapper.finddate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return bookWarningBack;
    }
}
