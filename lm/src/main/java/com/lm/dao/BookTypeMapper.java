package com.lm.dao;

import com.lm.pojo.BookType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookTypeMapper {

    //根据id查询
    @Select("select id,typename from booktype where id=#{id}")
    BookType findById(Integer id);

    @Select("select count(id) from book where book_type = #{book_type}")
    int checkBookCount(String book_type);

    @Select("select id,typename from booktype")
    List<BookType> find();

    @Insert("insert into booktype(id,typename) values(seq_booktype.nextval,#{typename})")
    int add(BookType bookType);

    @Update("update booktype set typename=#{typename} where id=#{id}")
    int modify(BookType bookType);

    @Delete("delete from booktype where id=#{id}")
    int remove(Integer id);
}
