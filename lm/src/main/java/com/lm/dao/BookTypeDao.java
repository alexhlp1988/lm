package com.lm.dao;

import com.lm.pojo.BookType;

import java.util.List;

public class BookTypeDao {
    //判断类别下有没有书
    public int checkBookCount(String book_type){
        int count = 0;
        try {
            BookTypeMapper mapper = MybatisSessionFactory.getSession().getMapper(BookTypeMapper.class);
            count = mapper.checkBookCount(book_type);
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return count;
    }

    //根据id查询
    public BookType findById(Integer id){
        BookType bookType =null;
        try {
            BookTypeMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookTypeMapper.class);
            bookType = mapper.findById(id);
        }finally {
            MybatisSessionFactory.closeSession();
        }
         return bookType;
    }
    //查询所有
   public List<BookType> find(){
       List<BookType> bookTypes = null;
       try {
           BookTypeMapper mapper =
                   MybatisSessionFactory.getSession().getMapper(BookTypeMapper.class);
           bookTypes = mapper.find();
       }finally {
           MybatisSessionFactory.closeSession();
       }
       return bookTypes;
   }
    //增加
    public  int add(BookType bookType){
         int count = 0;
         try {
             BookTypeMapper mapper =
                     MybatisSessionFactory.getSession().getMapper(BookTypeMapper.class);
             count = mapper.add(bookType);
             MybatisSessionFactory.getSession().commit();
         }finally {
             MybatisSessionFactory.closeSession();
         }
         return count;

    }
    //修改
    public  int modify(BookType bookType){
        int count = 0;
        try {
            BookTypeMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookTypeMapper.class);
            count = mapper.modify(bookType);
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
    public  int remove(Integer id){
        int count = 0;
        try {
            BookTypeMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookTypeMapper.class);
            count = mapper.remove(id);
            MybatisSessionFactory.getSession().commit();
        }finally {
            MybatisSessionFactory.closeSession();
        }
        return count;

    }






}
