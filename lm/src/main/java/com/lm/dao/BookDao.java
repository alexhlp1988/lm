package com.lm.dao;

import com.lm.pojo.Book;

import java.util.List;

public class BookDao {
    //级联删除借书表
    public int delBorrow(Integer bookid){
        int count = 0;
        try {
            BookMapper mapper = MybatisSessionFactory.getSession().getMapper(BookMapper.class);
            count = mapper.delBorrow(bookid);
            MybatisSessionFactory.getSession().commit();
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return count;
    }

    //检查ISBN唯一
    public Book checkIsbn(String isbn) {
        Book book = null;
        try {
            BookMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookMapper.class);
            book = mapper.checkIsbn(isbn);
        }finally {
            MybatisSessionFactory.closeSession();
        }
        return book;
    }

    //根据id查询
    public Book detail(Integer id){
        Book book = null;
        try {
            BookMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookMapper.class);
            book = mapper.detail(id);
        }finally {
            MybatisSessionFactory.closeSession();
        }
        return book;
    }



    //查询所有
    public List<Book> find(){
        List<Book> books = null;
        try {
            BookMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookMapper.class);
            books = mapper.find();
        }finally {
            MybatisSessionFactory.closeSession();
        }
        return books;
    }
    //增加
    public int  add(Book book){
        int count = 0;
        try {
            BookMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookMapper.class);
            count = mapper.add(book);
            MybatisSessionFactory.getSession().commit();
        }finally {
            MybatisSessionFactory.closeSession();
        }
       return count;
    }


    //修改
    public int  modify(Book book){
        int count = 0;
        try {
            BookMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookMapper.class);
            count = mapper.modify(book);
            MybatisSessionFactory.getSession().commit();
        }catch (Exception e){
            //当有异常时则回滚
            MybatisSessionFactory.getSession().rollback();
        }finally {
            MybatisSessionFactory.closeSession();
        }
        return count;
    }

    //删除
    public int  remove(Integer id){
        int count = 0;
        try {
            BookMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookMapper.class);
            count = mapper.remove(id);
            MybatisSessionFactory.getSession().commit();
        }finally {
            MybatisSessionFactory.closeSession();
        }
        return count;
    }









}
