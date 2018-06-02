package com.stylefeng.guns.modular.calligraphy.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.stylefeng.guns.core.common.constant.factory.PageFactory;
import com.stylefeng.guns.core.page.PageInfoBT;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.SubjectCateory;
import com.stylefeng.guns.modular.calligraphy.service.ISubjectCateoryService;

/**
 * 课程分类管理控制器
 *
 * @author fengshuonan
 * @Date 2018-06-02 20:44:20
 */
@Controller
@RequestMapping("/subjectCateory")
public class SubjectCateoryController extends BaseController {

    private String PREFIX = "/calligraphy/subjectCateory/";

    @Autowired
    private ISubjectCateoryService subjectCateoryService;

    /**
     * 跳转到课程分类管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "subjectCateory.html";
    }

    /**
     * 跳转到添加课程分类管理
     */
    @RequestMapping("/subjectCateory_add")
    public String subjectCateoryAdd() {
        return PREFIX + "subjectCateory_add.html";
    }

    /**
     * 跳转到修改课程分类管理
     */
    @RequestMapping("/subjectCateory_update/{subjectCateoryId}")
    public String subjectCateoryUpdate(@PathVariable Integer subjectCateoryId, Model model) {
        SubjectCateory subjectCateory = subjectCateoryService.selectById(subjectCateoryId);
        model.addAttribute("item",subjectCateory);
        LogObjectHolder.me().set(subjectCateory);
        return PREFIX + "subjectCateory_edit.html";
    }

    /**
     * 获取课程分类管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
   		Page<SubjectCateory> page = new PageFactory<SubjectCateory>().defaultPage();
   		page = this.subjectCateoryService.selectPage(page);
   		PageInfoBT<SubjectCateory> pageInfoBT= this.packForBT(page);
        return pageInfoBT;
    }

    /**
     * 新增课程分类管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(SubjectCateory subjectCateory) {
        subjectCateoryService.insert(subjectCateory);
        return SUCCESS_TIP;
    }

    /**
     * 删除课程分类管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer subjectCateoryId) {
        subjectCateoryService.deleteById(subjectCateoryId);
        return SUCCESS_TIP;
    }

    /**
     * 修改课程分类管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(SubjectCateory subjectCateory) {
        subjectCateoryService.updateById(subjectCateory);
        return SUCCESS_TIP;
    }

    /**
     * 课程分类管理详情
     */
    @RequestMapping(value = "/detail/{subjectCateoryId}")
    @ResponseBody
    public Object detail(@PathVariable("subjectCateoryId") Integer subjectCateoryId) {
        return subjectCateoryService.selectById(subjectCateoryId);
    }
}
