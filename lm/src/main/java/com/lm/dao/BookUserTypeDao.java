package com.lm.dao;

import com.lm.pojo.BookUserType;

import java.util.List;

public class BookUserTypeDao {

    //根据id查询
    public BookUserType findById(Integer id){
        BookUserType bookUserType =null;
        try {
            BookUserTypeMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookUserTypeMapper.class);
            bookUserType = mapper.findById(id);
        }finally {
            MybatisSessionFactory.closeSession();
        }
        return bookUserType;
    }
    //查询所有
    public List<BookUserType> find(){
        List<BookUserType>  bookUserTypes = null;
        try {
            BookUserTypeMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookUserTypeMapper.class);
            bookUserTypes = mapper.find();
        }finally {
            MybatisSessionFactory.closeSession();
        }
        return bookUserTypes;
    }
    //增加
    public  int add(BookUserType bookUserType){
        int count = 0;
        try {
            BookUserTypeMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookUserTypeMapper.class);
            count = mapper.add(bookUserType);
            MybatisSessionFactory.getSession().commit();
        }finally {
            MybatisSessionFactory.closeSession();
        }
        return count;

    }
    //修改
    public  int modify(BookUserType bookUserType){
        int count = 0;
        try {
            BookUserTypeMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookUserTypeMapper.class);
            count = mapper.modify(bookUserType);
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
            BookUserTypeMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookUserTypeMapper.class);
            count = mapper.remove(id);
            MybatisSessionFactory.getSession().commit();
        }finally {
            MybatisSessionFactory.closeSession();
        }
        return count;

    }









}
