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
import com.stylefeng.guns.modular.system.model.SubjectStuAction;
import com.stylefeng.guns.modular.calligraphy.service.ISubjectStuActionService;

/**
 * 学员选课管理控制器
 *
 * @author fengshuonan
 * @Date 2018-06-02 20:47:59
 */
@Controller
@RequestMapping("/subjectStuAction")
public class SubjectStuActionController extends BaseController {

    private String PREFIX = "/calligraphy/subjectStuAction/";

    @Autowired
    private ISubjectStuActionService subjectStuActionService;

    /**
     * 跳转到学员选课管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "subjectStuAction.html";
    }

    /**
     * 跳转到添加学员选课管理
     */
    @RequestMapping("/subjectStuAction_add")
    public String subjectStuActionAdd() {
        return PREFIX + "subjectStuAction_add.html";
    }

    /**
     * 跳转到修改学员选课管理
     */
    @RequestMapping("/subjectStuAction_update/{subjectStuActionId}")
    public String subjectStuActionUpdate(@PathVariable Integer subjectStuActionId, Model model) {
        SubjectStuAction subjectStuAction = subjectStuActionService.selectById(subjectStuActionId);
        model.addAttribute("item",subjectStuAction);
        LogObjectHolder.me().set(subjectStuAction);
        return PREFIX + "subjectStuAction_edit.html";
    }

    /**
     * 获取学员选课管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
   		Page<SubjectStuAction> page = new PageFactory<SubjectStuAction>().defaultPage();
   		page = this.subjectStuActionService.selectPage(page);
   		PageInfoBT<SubjectStuAction> pageInfoBT= this.packForBT(page);
        return pageInfoBT;
    }

    /**
     * 新增学员选课管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(SubjectStuAction subjectStuAction) {
        subjectStuActionService.insert(subjectStuAction);
        return SUCCESS_TIP;
    }

    /**
     * 删除学员选课管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer subjectStuActionId) {
        subjectStuActionService.deleteById(subjectStuActionId);
        return SUCCESS_TIP;
    }

    /**
     * 修改学员选课管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(SubjectStuAction subjectStuAction) {
        subjectStuActionService.updateById(subjectStuAction);
        return SUCCESS_TIP;
    }

    /**
     * 学员选课管理详情
     */
    @RequestMapping(value = "/detail/{subjectStuActionId}")
    @ResponseBody
    public Object detail(@PathVariable("subjectStuActionId") Integer subjectStuActionId) {
        return subjectStuActionService.selectById(subjectStuActionId);
    }
}
