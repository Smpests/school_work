package com.qingsong.spring.dao;

import com.qingsong.spring.model.Keyword;

import java.sql.SQLException;
import java.util.Map;

/**
 * @author qingsong
 * created at 2018/4/12
 */
public interface MyDBInterface {
    //获取全部关键字保留字，运算符以及分隔符（简称为Keyword）
    Map<String,Keyword> getAllKeyword() throws SQLException;
    //获取查询到的Keyword
    Map<Integer,Keyword> getCheckedKeyword() throws SQLException;
    //查询是否存在于Keyword表中
    boolean checkInTable(String name) throws SQLException;
}
