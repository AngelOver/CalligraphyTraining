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
import com.stylefeng.guns.modular.system.model.Course;
import com.stylefeng.guns.modular.calligraphy.service.ICourseService;

/**
 * 成长历程控制器
 *
 * @author fengshuonan
 * @Date 2018-06-02 20:42:21
 */
@Controller
@RequestMapping("/course")
public class CourseController extends BaseController {

    private String PREFIX = "/calligraphy/course/";

    @Autowired
    private ICourseService courseService;

    /**
     * 跳转到成长历程首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "course.html";
    }

    /**
     * 跳转到添加成长历程
     */
    @RequestMapping("/course_add")
    public String courseAdd() {
        return PREFIX + "course_add.html";
    }

    /**
     * 跳转到修改成长历程
     */
    @RequestMapping("/course_update/{courseId}")
    public String courseUpdate(@PathVariable Integer courseId, Model model) {
        Course course = courseService.selectById(courseId);
        model.addAttribute("item",course);
        LogObjectHolder.me().set(course);
        return PREFIX + "course_edit.html";
    }

    /**
     * 获取成长历程列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
   		Page<Course> page = new PageFactory<Course>().defaultPage();
   		page = this.courseService.selectPage(page);
   		PageInfoBT<Course> pageInfoBT= this.packForBT(page);
        return pageInfoBT;
    }

    /**
     * 新增成长历程
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Course course) {
        courseService.insert(course);
        return SUCCESS_TIP;
    }

    /**
     * 删除成长历程
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer courseId) {
        courseService.deleteById(courseId);
        return SUCCESS_TIP;
    }

    /**
     * 修改成长历程
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Course course) {
        courseService.updateById(course);
        return SUCCESS_TIP;
    }

    /**
     * 成长历程详情
     */
    @RequestMapping(value = "/detail/{courseId}")
    @ResponseBody
    public Object detail(@PathVariable("courseId") Integer courseId) {
        return courseService.selectById(courseId);
    }
}
