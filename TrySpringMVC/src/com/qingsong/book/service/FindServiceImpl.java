package com.qingsong.book.service;

import com.qingsong.book.mapper.BookMapper;
import com.qingsong.book.model.BookModel;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qingsong
 * created at 2018/4/20
 */
public class FindServiceImpl implements FindService<BookModel> {
    protected final Logger logger = Logger.getLogger(this.getClass());
    /**
     * studentMapper接口
     */
    @Resource
    protected BookMapper bookMapper;
    @Override
    public BookModel findBookById(Integer id) {
        try {
            return bookMapper.findBookById(id);
        } catch (Exception e) {
            logger.error("ERROR", e);
            return null;
        }
    }

    @Override
    public List<BookModel> getAllBook() {
        try {
            // 凡是和中间件交互的地方务必加上try catch,例如db,mq,cache
            List<BookModel> list = bookMapper.getAllBook();
            logger.info("业务方法执行完毕");
            return list;
        } catch (Exception e) {
            logger.error("ERROR", e);
            return null;
        }
    }

    @Override
    public List<BookModel> findBookByType(String book_type) {
        try {
            // 凡是和中间件交互的地方务必加上try catch,例如db,mq,cache
            List<BookModel> list = bookMapper.findBookByType(book_type);
            logger.info("业务方法执行完毕");
            return list;
        } catch (Exception e) {
            logger.error("ERROR", e);
            return null;
        }
    }
}
