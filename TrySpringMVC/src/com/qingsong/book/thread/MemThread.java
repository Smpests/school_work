package com.qingsong.book.thread;

import com.qingsong.book.mapper.BookMapper;
import com.qingsong.book.model.MemoryModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qingsong
 * created at 2018/4/19
 */
public class MemThread extends Thread {
    private static final Logger logger = Logger.getLogger(MemThread.class);
    @Autowired
    BookMapper bookMapper;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                MemoryModel memoryModel = new MemoryModel();
                memoryModel.setMaxMemory((int) (Runtime.getRuntime().maxMemory() / 1024 / 1024));
                memoryModel.setTotalMemory((int) (Runtime.getRuntime().totalMemory() / 1024 / 1024));
                memoryModel.setFreeMemory((int) (Runtime.getRuntime().freeMemory() / 1024 / 1024));
                bookMapper.addMemory(memoryModel);
                logger.info("记录一次内存信息");
            } catch (InterruptedException e) {
                logger.error("ERROR", e);
            }
        }
    }

    public BookMapper getBookMapper() {
        return bookMapper;
    }

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

}