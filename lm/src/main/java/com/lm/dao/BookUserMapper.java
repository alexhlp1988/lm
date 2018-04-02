package com.lm.dao;

import com.lm.pojo.BookUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookUserMapper {
    @Delete("delete borrow where user_id = #{userid}")
    int delBorrow(Integer userid);

    @Select("select id,account,password,usertype,name,sex," +
            "library_card,cardtype,card_id,phone,email,reg_date,manager,back_up from book_user where id=#{id}")
    BookUser findById(Integer id);

    @Select("select id,account,password,usertype,name,sex, library_card," +
            "cardtype,card_id,phone,email,reg_date,manager,back_up from book_user ")
    List<BookUser> find();

    @Insert("insert into book_user (id,account,password,usertype,name,sex," +
            " library_card,cardtype,card_id,phone,email,reg_date,manager,back_up) " +
            " values(seq_bookuser.nextval,#{account},#{password},#{usertype},#{name},#{sex}," +
            "#{library_card},#{cardtype},#{card_id},#{phone},#{email},#{reg_date},#{manager},#{back_up})")
    int add(BookUser bookUser);

    @Update("update book_user set usertype=#{usertype},name=#{name},sex=#{sex}," +
            " cardtype=#{cardtype},card_id=#{card_id} where id=#{id}")
    int modify(BookUser bookUser);

    @Delete("delete from book_user where id=#{id}")
    int remove(Integer id);

    BookUser login(@Param("account") String account, @Param("password") String password);

    @Select("select id,account,password,usertype,name,sex,library_card,cardtype," +
            "card_id,phone,email,reg_date,manager,back_up from book_user where" +
            " account=#{account}")
    BookUser checkAccount(String account);

    @Select("select id,account,password,usertype,name,sex,ibrary_card,cardtype,card_id,phone,email," +
            "reg_date,manager,back_up from book_user where account=#{account}")
    BookUser findByAccount(String account);

    @Select("select id,account,password,usertype,name,sex,library_card,cardtype," +
            "card_id,phone,email,reg_date,manager,back_up from book_user where library_card=#{library_card}")
    BookUser checkLCard(String library_card);
}
