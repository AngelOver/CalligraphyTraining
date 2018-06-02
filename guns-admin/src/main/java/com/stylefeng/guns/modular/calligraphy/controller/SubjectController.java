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
import com.stylefeng.guns.modular.system.model.Subject;
import com.stylefeng.guns.modular.calligraphy.service.ISubjectService;

/**
 * 课程管理控制器
 *
 * @author fengshuonan
 * @Date 2018-06-02 20:43:49
 */
@Controller
@RequestMapping("/subject")
public class SubjectController extends BaseController {

    private String PREFIX = "/calligraphy/subject/";

    @Autowired
    private ISubjectService subjectService;

    /**
     * 跳转到课程管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "subject.html";
    }

    /**
     * 跳转到添加课程管理
     */
    @RequestMapping("/subject_add")
    public String subjectAdd() {
        return PREFIX + "subject_add.html";
    }

    /**
     * 跳转到修改课程管理
     */
    @RequestMapping("/subject_update/{subjectId}")
    public String subjectUpdate(@PathVariable Integer subjectId, Model model) {
        Subject subject = subjectService.selectById(subjectId);
        model.addAttribute("item",subject);
        LogObjectHolder.me().set(subject);
        return PREFIX + "subject_edit.html";
    }

    /**
     * 获取课程管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
   		Page<Subject> page = new PageFactory<Subject>().defaultPage();
   		page = this.subjectService.selectPage(page);
   		PageInfoBT<Subject> pageInfoBT= this.packForBT(page);
        return pageInfoBT;
    }

    /**
     * 新增课程管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Subject subject) {
        subjectService.insert(subject);
        return SUCCESS_TIP;
    }

    /**
     * 删除课程管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer subjectId) {
        subjectService.deleteById(subjectId);
        return SUCCESS_TIP;
    }

    /**
     * 修改课程管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Subject subject) {
        subjectService.updateById(subject);
        return SUCCESS_TIP;
    }

    /**
     * 课程管理详情
     */
    @RequestMapping(value = "/detail/{subjectId}")
    @ResponseBody
    public Object detail(@PathVariable("subjectId") Integer subjectId) {
        return subjectService.selectById(subjectId);
    }
}
