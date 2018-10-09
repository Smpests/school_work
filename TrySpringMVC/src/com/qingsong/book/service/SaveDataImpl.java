package com.qingsong.book.service;

import com.qingsong.book.mapper.BookMapper;
import com.qingsong.book.model.BookModel;
import org.apache.log4j.Logger;

import javax.annotation.Resource;

/**
 * @author qingsong
 * created at 2018/4/20
 */
public class SaveDataImpl implements SaveData<BookModel>{
    protected final Logger logger = Logger.getLogger(this.getClass());
    /**
     * studentMapper接口
     */
    @Resource
    protected BookMapper bookMapper;
    public SaveDataImpl() {
        System.out.println("PersistService调用无参构造方法");
    }

    @Override
    public void addBook(BookModel bookModel) {
        if (bookModel != null)
            bookMapper.addBook(bookModel);
    }

    @Override
    public void delBookById(Integer id) {
        try {
            bookMapper.delBookById(id);
        } catch (Exception e) {
            logger.error("Error",e);
        }
    }

    @Override
    public void updateBookPrice(Integer price, Integer id) {
        if (price >= 0)
            bookMapper.updateBookPrice(price,id);
    }
}
