package com.lm.dao;

import com.lm.pojo.BookBorrowBookUser;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookBorrowBookUserMapper {
    @Update("UPDATE BORROW set IS_BACK=#{is_back},manager=#{manager} where id =" +
            "(SELECT id FROM BORROW WHERE BOOK_ID = " +
            "(select id from book where ISBN = #{isbn}) and USER_ID = " +
            "(select id from BOOK_USER where LIBRARY_CARD=#{library_card}))")
    int updatebookborrowbookuser(BookBorrowBookUser bookBorrowBookUser);
    @Select("select b.isbn isbn,b.name bookname,br.borrow_date borrow_date,br.expire_date expire_date,br.manager manager,br.is_back is_back,br.back_date back_date,\n" +
            " bu.account account,bu.name username,bu.library_card library_card  FROM BOOK b,BORROW br,BOOK_USER bu WHERE b.id = br.BOOK_ID\n" +
            "and bu.ID = br.USER_ID")
    List<BookBorrowBookUser> find();
}
