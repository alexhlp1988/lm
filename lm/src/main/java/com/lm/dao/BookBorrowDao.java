package com.lm.dao;

import com.lm.pojo.Book;
import com.lm.pojo.BookBorrow;
import com.lm.pojo.Borrow;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookBorrowDao {
    public List<BookBorrow> findBook(Integer user_id){
        List<BookBorrow> books = null;
        try{
            BookBorrowMapper mapper=MybatisSessionFactory.getSession().getMapper(BookBorrowMapper.class);
            books=mapper.findBook(user_id);
        }finally {
            MybatisSessionFactory.closeSession();
        }
        return books;
    }
    public List<Borrow> findBorrow(){
        List<Borrow> borrows = null;
        try{
            BookBorrowMapper mapper=MybatisSessionFactory.getSession().getMapper(BookBorrowMapper.class);
            borrows=mapper.findBorrow();
        }finally {
            MybatisSessionFactory.closeSession();
        }
        return borrows;
    }
}

