package com.qingsong.spring.model;

/**
 * @author qingsong
 * created at 2018/4/12
 */
public class Keyword {
    private int id;
    private String name;
    private int seedCode;
    public Keyword() {}
    public Keyword(String name,int seedCode) {
        this.name = name;
        this.seedCode = seedCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeedCode() {
        return seedCode;
    }

    public void setSeedCode(int seedCode) {
        this.seedCode = seedCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
