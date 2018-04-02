package com.lm.dao;

import com.lm.pojo.BookWarningBack;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookWarningBackMapper {

//    @Select("select b.isbn isbn,b.name bookname,bu.account account,bu.cardtype cardtype,bu.card_id card_id,bu.name username,\n" +
//            "    bu.email email,bu.phone phone,bu.usertype usertype,br.borrow_date borrow_date,br.expire_date expire_date\n" +
//            "    from book b,book_user bu,borrow br where br.book_id=b.id and br.user_id=bu.id")
    List<BookWarningBack> finddate();
}
