package com.lm.dao;

import com.lm.pojo.BookUserType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookUserTypeMapper {
    //根据id查询
    @Select("select id,typename,book_count from book_usertype where id=#{id}")
    BookUserType findById(Integer id);

    @Select("select id,typename,book_count from book_usertype")
    List<BookUserType> find();

    @Insert("insert into book_usertype(id,typename,book_count)" +
            " values(seq_usertype.nextval,#{typename},#{book_count})")
    int add(BookUserType bookUserType);

    @Update("update book_usertype set typename=#{typename},book_count=#{book_count} where id=#{id}")
    int modify(BookUserType bookUserType);

    @Delete("delete from book_usertype where id=#{id}")
    int remove(Integer id);

}
