package com.qingsong.book.service;

/**
 * @author qingsong
 * created at 2018/4/20
 */
public interface SaveData<T> {
    /**
     * 添加新书
     *
     * @param t 书类型
     */
    public void addBook(T t);

    /**
     * 修改书的价格
     *
     * @param price  价格
     * @param id    主键
     */
    public void updateBookPrice(Integer price, Integer id);

    /**
     * 删除指定书籍
     *
     * @param id 主键
     */
    public void delBookById(Integer id);
}