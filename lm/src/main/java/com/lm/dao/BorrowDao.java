package com.lm.dao;

import com.lm.pojo.Borrow;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BorrowDao {


    public Borrow findBorrow(Integer user_id,Integer book_id){
        Borrow borrow =null;
        try{
            BorrowMapper mapper=MybatisSessionFactory.getSession().getMapper(BorrowMapper.class);
            borrow=mapper.findBorrow(user_id,book_id);
        }finally {
           MybatisSessionFactory.closeSession();
        }

        return borrow;

    }
    public int modify(Borrow borrow){
        int count=0;
        try{
            BorrowMapper mapper=MybatisSessionFactory.getSession().getMapper(BorrowMapper.class);
            count = mapper.modify(borrow);
            MybatisSessionFactory.getSession().commit();
        }finally {
            MybatisSessionFactory.closeSession();
        }
        return count;
    }

    public int add(Borrow borrow){
        int count=0;
        try {
            BorrowMapper mapper = MybatisSessionFactory.getSession().getMapper(BorrowMapper.class);
            count = mapper.addBorrow(borrow);
            MybatisSessionFactory.getSession().commit();
        } finally {
            MybatisSessionFactory.closeSession();
        }
        return count;
    }
}
