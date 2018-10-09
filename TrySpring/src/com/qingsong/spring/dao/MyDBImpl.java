package com.qingsong.spring.dao;

import com.qingsong.spring.model.Keyword;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qingsong
 * created at 2018/4/12
 */
public class MyDBImpl implements MyDBInterface{
    //加载驱动程序
    private String driverName="com.mysql.jdbc.Driver";
    //数据库信息
    private String userName="root";
    //密码
    private String userPasswd="187233315142";
    //数据库名
    private String dbName="statement_analysis";
    //表名
    private String tableName="keyword";
    //将数据库信息字符串连接成为一个完整的url（也可以直接写成url， 分开写是明了可维护性强
    private Connection conn;
    //private Statement statement;
    private ResultSet rs;
    private PreparedStatement preparedStatement;  //可防sql注入
    private Map<Integer,Keyword> checkedMap;

    private String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
    public MyDBImpl() {
        try {
            Class.forName(driverName).newInstance();
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Map<String,Keyword> getAllKeyword() throws SQLException{
        Map<String,Keyword> map = new HashMap<>();
        String sql = "SELECT * FROM " + tableName;
        preparedStatement = conn.prepareStatement(sql);
        rs = preparedStatement.executeQuery();
        while (rs.next()) {
            map.put(rs.getString(2),new Keyword(rs.getString(2),rs.getInt(3)));
        }
        return map;
    }
    @Override
    public Map<Integer,Keyword> getCheckedKeyword() throws SQLException{
        return checkedMap;
    }
    @Override
    public boolean checkInTable(String name) throws SQLException{
        String sql = "SELECT * FROM "+ tableName + " WHERE name=?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,name);
        rs = preparedStatement.executeQuery();
        if (rs.next()) {
            checkedMap.put(rs.getInt(1),new Keyword(rs.getString(2),rs.getInt(3)));
            return true;
        }
        return false;
    }
}
