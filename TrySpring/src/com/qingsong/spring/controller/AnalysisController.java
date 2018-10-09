package com.qingsong.spring.controller;

import com.qingsong.spring.dao.MyDBImpl;
import com.qingsong.spring.model.Keyword;
import com.qingsong.spring.model.MyRegex;
import com.qingsong.spring.model.MySymbol;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.SQLException;
import java.util.*;

/**
 * @author qingsong
 * created at 2018/4/12
 */
@Controller
public class AnalysisController {
    @RequestMapping("/home")
    public String getHome() {
        return "index";
    }
    @RequestMapping("/analysis")
    public ModelAndView analysis(HttpServletRequest request) throws SQLException,IOException {
        ModelAndView mav = new ModelAndView("result");
        List<String> result = new ArrayList<>();
        List<String> error = new ArrayList<>();
        List<MySymbol> symbols = new ArrayList<>();
        File file = new File("E:\\mProject\\TrySpring\\web\\user-files\\" + request.getParameter("file"));
        if (!file.exists()) {
            //文件不存在
            mav.addObject("message","E:\\mProject\\TrySpring\\web\\user-files\\" + request.getParameter("file") + "不存在");
        } else {
            //Version 1.0，不判断语义语法 关键字1，标识符2，运算符3，常数4，界符5
            Map<String,Keyword> keyword = new HashMap<>(initResource());
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String stringLine;
            int row,col = 0;
            char ch;
            for (row = 1;(stringLine = bufferedReader.readLine()) != null;row++) {
                stringLine = MyRegex.replaceAllComplexSymbol(stringLine);
                String[] strs = MyRegex.split(stringLine,MyRegex.SPILIT_SYMBOL);
                for (int i = 0;i < strs.length;i++) {
                    if (strs[i].equals(""))
                        col++;
                    else if (MyRegex.execRegex(strs[i],MyRegex.ALL_LETTER)) {
                        if (keyword.containsKey(strs[i])) {
                            result.add("(" + keyword.get(strs[i]).getSeedCode() + ",'" + strs[i] + "')");
                            col+=strs[i].length();
                        }
                        else {
                            addToSymbols(strs[i],symbols);
                            result.add("(2" + "," + symbols.size() + ")");
                            col+=strs[i].length();
                        }
                    }
                    else if (MyRegex.execRegex(strs[i],MyRegex.ALL_NUMBER)) {
                        result.add("(4" + ",'" + strs[i] + "')");
                        col+=strs[i].length();
                    }
                    else if (MyRegex.execRegex(strs[i], MyRegex.LETTER_AND_NUMBER)) {
                        addToSymbols(strs[i],symbols);
                        result.add("(2" + "," + symbols.size() + ")");
                        col+=strs[i].length();
                    }
                    else if (MyRegex.execRegex(strs[i],MyRegex.BORDER_SYMBOL)) {
                        result.add("(5" + ",'" + strs[i] + "')");
                        col+=strs[i].length();
                    } else if (MyRegex.execRegex(strs[i], MyRegex.OPERATOR)) {
                        result.add("(3" + ",'" + strs[i] + "')");
                        col+=strs[i].length();
                    } else {
                        error.add("第" + row + "行" + col + "列: " + "在" + "'" + strs[i] + "'附近有错误，无法解析的字符");
                    }
                }
                col = 0;
            }
            mav.addObject("result",result);
            mav.addObject("symbols",symbols);
            mav.addObject("error",error);
        }
        return mav;
    }
    private Map<String,Keyword> initResource() throws SQLException{
        MyDBImpl db = new MyDBImpl();
        return db.getAllKeyword();
    }
    private boolean addToSymbols(String str,List<MySymbol> list) {
        for (MySymbol item:list
             ) { if (item.getName().equals(str))
                    return false;
        }
        list.add(new MySymbol(str,String.valueOf(list.size() + 1)));
        return true;
    }
}
