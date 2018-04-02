package com.lm.dao;

import com.lm.pojo.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookMapper {

    @Delete("delete borrow where book_id = #{bookid}")
    int delBorrow(Integer bookid);

    @Select("select id ,isbn,name,author,publisher,price,sign_date," +
            "manager,amount,book_type from book where isbn = #{isbn}")
    Book checkIsbn(String isbn);

    @Select("select id ,isbn,name,author,publisher,price,sign_date," +
            " manager,amount,book_type from book where id=#{id}")
    Book detail(Integer id);

    @Select("select id,isbn,name,author,publisher,price,sign_date," +
            " manager,amount,book_type from book")
    List<Book> find();

    @Insert("insert into book(id,isbn,name,author,publisher,price,sign_date, manager,amount,book_type)" +
            " values(seq_book.nextval,#{isbn},#{name},#{author},#{publisher},#{price},sysdate,#{manager},#{amount},#{book_type})")
    int add(Book book);

    @Update("update book  set isbn=#{isbn},name=#{name},author=#{author}," +
            "publisher=#{publisher},price=#{price},sign_date=#{sign_date}, manager=#{manager},amount=#{amount},book_type=#{book_type} where id=#{id}")
    int modify(Book book);

    @Delete("delete from book where id=#{id}")
    int remove(Integer id);

}
