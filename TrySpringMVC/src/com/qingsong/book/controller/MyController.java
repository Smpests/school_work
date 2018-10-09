package com.qingsong.book.controller;

import com.qingsong.book.model.BookModel;
import com.qingsong.book.service.FindService;
import com.qingsong.book.service.SaveData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author qingsong
 * created at 2018/4/20
 */
@Controller
public class MyController {
    Logger logger = Logger.getLogger(this.getClass());
    @Autowired()
    @Qualifier("findServiceImpl")
    FindService<BookModel> findServiceImpl;

    @Autowired()
    @Qualifier("saveDataImpl")
    SaveData<BookModel> saveDataImpl;
    @RequestMapping("/home")
    public String home() {
        return "index";
    }
    /**
     * 查询所有书籍信息
     *
     * @param 模型数据
     * @return ModelAndView
     */
    @RequestMapping("/all")
    public String list(Map<String, Object> map) {
        logger.info("开始调用all");
        // 查询所有书目信息
        map.put("all",findServiceImpl.getAllBook());
        return "list";
    }
    /**
     * 进入新增页面
     *
     * @param 模型数据
     * @return ModelAndView
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Map<String, Object> map) {
        map.put("book",new BookModel());
        return "add";
    }
    /**
     * 确认新增书籍信息
     *
     * @param book  要添加的书类型
     * @return ModelAndView
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(BookModel book) {
        saveDataImpl.addBook(book);
        return "redirect:/all";
    }

    /**
     * 删除书籍信息
     *
     * @param id
     *            书籍编号
     * @return ModelAndView
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        logger.info("删除" + id);
        // 删除指定id的书籍信息
        saveDataImpl.delBookById(id);
        return "redirect:/all";
    }
    /**
     *
     * @param id
     *            编号
     * @param map
     *            隐式模型数据
     * @return
     */
    @RequestMapping(value = "/change/{id}", method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
        // 要开始修改
        map.put("book",findServiceImpl.findBookById(id));
        return "change";
    }

    /**
     *
     * @param price     价格
     * @param id       指定id
     * @return
     */
    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String update(Integer price,Integer id) {
        // 修改提交
        saveDataImpl.updateBookPrice(price,id);
        return "redirect:/all";
    }
}
