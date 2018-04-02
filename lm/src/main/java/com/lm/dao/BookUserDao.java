package com.lm.dao;

import com.lm.pojo.Book;
import com.lm.pojo.BookUser;

import java.util.List;

public class BookUserDao {
    public int delBorrow(Integer userid){
        int count = 0;
        try {
            BookUserMapper mapper = MybatisSessionFactory.getSession().getMapper(BookUserMapper.class);
            count = mapper.delBorrow(userid);
            MybatisSessionFactory.getSession().commit();
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return count;
    }

    public BookUser find(String account,String password){
        BookUser bookuser = null;
        try {
            BookUserMapper mapper = MybatisSessionFactory.getSession().getMapper(BookUserMapper.class);
            bookuser = mapper.login(account, password);
        }finally {
            MybatisSessionFactory.closeSession();
        }
        return bookuser;
    }
//查询所有
    public List<BookUser> find() {
        List<BookUser> bookUsers = null;
        try {
            BookUserMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookUserMapper.class);
            bookUsers = mapper.find();
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return bookUsers;
    }

//根据id查询
public BookUser findById(Integer id) {
    BookUser bookUser = null;
    try {
        BookUserMapper mapper =
                MybatisSessionFactory.getSession().getMapper(BookUserMapper.class);
        bookUser = mapper.findById(id);
    } finally {
        MybatisSessionFactory.closeSession();
    }
    return bookUser;
}
//增加
public int add(BookUser bookUser) {
    int count = 0;
    try {
        BookUserMapper mapper =
                MybatisSessionFactory.getSession().getMapper(BookUserMapper.class);
        count = mapper.add(bookUser);
        MybatisSessionFactory.getSession().commit();
    } finally {
        MybatisSessionFactory.closeSession();
    }
    return count;
}
    //s修改
    public int modify(BookUser bookUser) {
        int count = 0;
        try {
            BookUserMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookUserMapper.class);
            count = mapper.modify(bookUser);
            // 当多个操作时都成功则提交
            MybatisSessionFactory.getSession().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 当有异常时则回滚
            MybatisSessionFactory.getSession().rollback();

        } finally {
            MybatisSessionFactory.closeSession();
        }
        return count;
    }

    //删除
    public int remove(Integer id) {
        int count = 0;
        try {
            BookUserMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookUserMapper.class);
            count = mapper.remove(id);
            MybatisSessionFactory.getSession().commit();
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return count;
    }

    public BookUser checkAccount(String account){
        BookUser bookUser = null;
        try {
            BookUserMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookUserMapper.class);
            bookUser = mapper.checkAccount(account);
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return bookUser;
    }

    public BookUser find(String account){
        BookUser bookUser=null;
        try{
            BookUserMapper mapper=MybatisSessionFactory.getSession().getMapper(BookUserMapper.class);
            bookUser=mapper.findByAccount(account);
        }finally {
            MybatisSessionFactory.closeSession();
        }
        return bookUser;
    }

    public BookUser checkLCard(String library_card){
        BookUser bookUser = null;
        try {
            BookUserMapper mapper =
                    MybatisSessionFactory.getSession().getMapper(BookUserMapper.class);
            bookUser = mapper.checkLCard(library_card);
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return bookUser;
    }







}
