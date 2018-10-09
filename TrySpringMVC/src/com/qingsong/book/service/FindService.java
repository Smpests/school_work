package com.qingsong.book.service;

import java.util.List;

/**
 * @author qingsong
 * created at 2018/4/20
 */
public interface FindService<T> {
    /**
     *
     * @param id
     *            需要查询的id
     * @return 返回指定书的信息
     */
    public T findBookById(Integer id);

    /**
     * 查询所有书籍信息
     *
     * @return 返回所有书籍信息的集合
     */
    public List<T> getAllBook();

    /**
     * 指定类型查询书籍信息
     *
     * @return 返回指定类型的书籍集合
     */
    public List<T> findBookByType(String book_type);
}
