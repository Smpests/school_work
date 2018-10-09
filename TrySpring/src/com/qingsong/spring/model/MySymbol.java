package com.qingsong.spring.model;


/**
 * @author qingsong
 * created at 2018/4/18
 */
public class MySymbol {
    private String name;
    private String address;
    public MySymbol(String name,String address) {
        this.name = name;
        this.address = address;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
