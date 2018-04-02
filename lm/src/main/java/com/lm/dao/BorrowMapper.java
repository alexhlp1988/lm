package com.lm.dao;

import com.lm.pojo.Borrow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BorrowMapper {
    Borrow findBorrow(@Param("user_id") Integer user_id, @Param("book_id") Integer book_id);

    @Update("UPDATE BORROW SET IS_BACK=#{is_back} WHERE book_id=#{book_id} and user_id=#{user_id}")
    int modify(Borrow borrow);

    @Insert("insert into borrow(id,book_id,user_id,borrow_date,expire_date,back_date,is_back,manager) " +
            "values(seq_borrow.nextval,${book_id},#{user_id},#{borrow_date},#{expire_date},#{back_date},#{is_back},#{manager})")
    int addBorrow(Borrow borrow);
}
