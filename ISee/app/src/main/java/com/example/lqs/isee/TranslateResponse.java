package com.example.lqs.isee;

import java.util.List;

/**
 * Created by lqs on 2017/11/21.
 */

public class TranslateResponse {
    String from;
    String to;
    List<MyResult> trans_result;
    class MyResult {
        String src;
        String dst;
        //目前只需要获取翻译结果dst
        public String getDst() {
            return dst;
        }
    }
    public List<MyResult> getTrans_result() {
        return trans_result;
    }
}
