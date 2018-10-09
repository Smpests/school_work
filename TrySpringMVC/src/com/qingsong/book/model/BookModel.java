package com.qingsong.book.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 * @author qingsong
 * created at 2018/4/19
 */
public class BookModel implements Serializable{
    /**
     *数据库标号
     */
    private Integer id;
    /**
     * 书名
     */
    private String name;
    /**
     * 上架时间
     */
    private Date grounding_date;
    /**
     * 价格
     */
    private Integer price;
    /**
     * 余量  默认为1
     */
    private Integer allowance;
    /**
     * 作者
     */
    private String author;
    /**
     * 简介  默认为空
     */
    private String generalize;
    /**
     * 出版社
     */
    private String press;
    /**
     * 书籍类型
     */
    private String book_type;
    /**
     * 备注（求购信息） 默认为空
     */
    private String comments;
    public BookModel() {
    }
    public BookModel(String name,String grouding_date,Integer price,String author,String press,String book_type) throws ParseException{
        this.name = name;
        this.grounding_date = new Date(new  SimpleDateFormat("yyyy-MM-dd").parse(grouding_date).getTime());
        this.price = price;
        this.author = author;
        this.press = press;
        this.book_type = book_type;
    }
    public BookModel(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Date getGrounding_date() {
        return grounding_date;
    }

    public Integer getAllowance() {
        return allowance;
    }

    public Integer getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getId() {
        return id;
    }

    public String getGeneralize() {
        return generalize;
    }

    public String getComments() {
        return comments;
    }

    public String getPress() {
        return press;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAllowance(Integer allowance) {
        this.allowance = allowance;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setGeneralize(String generalize) {
        this.generalize = generalize;
    }

    public void setGrounding_date(Date grounding_date) {
        this.grounding_date = grounding_date;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }
}
