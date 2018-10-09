package com.qingsong.book.mapper;

import com.qingsong.book.model.BookModel;
import com.qingsong.book.model.MemoryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qingsong
 * created at 2018/4/19
 */
public interface BookMapper {
    /**
     *
     * @param book
     */
    void addBook(BookModel book);

    /**
     *
     * @param id
     */
    void delBookById(int id);

    /**
     *
     * @param price
     * @param id
     */
    void updateBookPrice(@Param("price") int price, @Param("id") int id);

    /**
     *
     * @param id
     * @return  返回指定ID的书籍相关信息
     */
    BookModel findBookById(int id);

    /**
     *
     * @return  返回书库中所有书的信息集合
     */
    List<BookModel> getAllBook();

    /**
     *
     * @param book_type
     * @return 返回书库中指定类型的书籍集合
     */
    List<BookModel> findBookByType(String book_type);
    /**
     * 定时插入当前内存值
     */
    void addMemory(MemoryModel memoryModel);
}
