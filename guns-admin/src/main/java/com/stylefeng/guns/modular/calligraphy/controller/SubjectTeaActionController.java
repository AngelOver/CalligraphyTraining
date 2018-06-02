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
import com.stylefeng.guns.modular.system.model.SubjectTeaAction;
import com.stylefeng.guns.modular.calligraphy.service.ISubjectTeaActionService;

/**
 * 教师课程管理控制器
 *
 * @author fengshuonan
 * @Date 2018-06-02 20:49:21
 */
@Controller
@RequestMapping("/subjectTeaAction")
public class SubjectTeaActionController extends BaseController {

    private String PREFIX = "/calligraphy/subjectTeaAction/";

    @Autowired
    private ISubjectTeaActionService subjectTeaActionService;

    /**
     * 跳转到教师课程管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "subjectTeaAction.html";
    }

    /**
     * 跳转到添加教师课程管理
     */
    @RequestMapping("/subjectTeaAction_add")
    public String subjectTeaActionAdd() {
        return PREFIX + "subjectTeaAction_add.html";
    }

    /**
     * 跳转到修改教师课程管理
     */
    @RequestMapping("/subjectTeaAction_update/{subjectTeaActionId}")
    public String subjectTeaActionUpdate(@PathVariable Integer subjectTeaActionId, Model model) {
        SubjectTeaAction subjectTeaAction = subjectTeaActionService.selectById(subjectTeaActionId);
        model.addAttribute("item",subjectTeaAction);
        LogObjectHolder.me().set(subjectTeaAction);
        return PREFIX + "subjectTeaAction_edit.html";
    }

    /**
     * 获取教师课程管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
   		Page<SubjectTeaAction> page = new PageFactory<SubjectTeaAction>().defaultPage();
   		page = this.subjectTeaActionService.selectPage(page);
   		PageInfoBT<SubjectTeaAction> pageInfoBT= this.packForBT(page);
        return pageInfoBT;
    }

    /**
     * 新增教师课程管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(SubjectTeaAction subjectTeaAction) {
        subjectTeaActionService.insert(subjectTeaAction);
        return SUCCESS_TIP;
    }

    /**
     * 删除教师课程管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer subjectTeaActionId) {
        subjectTeaActionService.deleteById(subjectTeaActionId);
        return SUCCESS_TIP;
    }

    /**
     * 修改教师课程管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(SubjectTeaAction subjectTeaAction) {
        subjectTeaActionService.updateById(subjectTeaAction);
        return SUCCESS_TIP;
    }

    /**
     * 教师课程管理详情
     */
    @RequestMapping(value = "/detail/{subjectTeaActionId}")
    @ResponseBody
    public Object detail(@PathVariable("subjectTeaActionId") Integer subjectTeaActionId) {
        return subjectTeaActionService.selectById(subjectTeaActionId);
    }
}
