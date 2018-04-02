package com.lm.dao;

import com.lm.pojo.Book;
import com.lm.pojo.BookBorrow;
import com.lm.pojo.Borrow;

import java.util.List;

public interface BookBorrowMapper {
    List<BookBorrow> findBook(Integer user_id);

    List<Borrow> findBorrow();
}
