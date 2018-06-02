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
import com.stylefeng.guns.modular.system.model.Student;
import com.stylefeng.guns.modular.calligraphy.service.IStudentService;

/**
 * 学员管理控制器
 *
 * @author fengshuonan
 * @Date 2018-06-02 20:44:50
 */
@Controller
@RequestMapping("/student")
public class StudentController extends BaseController {

    private String PREFIX = "/calligraphy/student/";

    @Autowired
    private IStudentService studentService;

    /**
     * 跳转到学员管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "student.html";
    }

    /**
     * 跳转到添加学员管理
     */
    @RequestMapping("/student_add")
    public String studentAdd() {
        return PREFIX + "student_add.html";
    }

    /**
     * 跳转到修改学员管理
     */
    @RequestMapping("/student_update/{studentId}")
    public String studentUpdate(@PathVariable Integer studentId, Model model) {
        Student student = studentService.selectById(studentId);
        model.addAttribute("item",student);
        LogObjectHolder.me().set(student);
        return PREFIX + "student_edit.html";
    }

    /**
     * 获取学员管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
   		Page<Student> page = new PageFactory<Student>().defaultPage();
   		page = this.studentService.selectPage(page);
   		PageInfoBT<Student> pageInfoBT= this.packForBT(page);
        return pageInfoBT;
    }

    /**
     * 新增学员管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Student student) {
        studentService.insert(student);
        return SUCCESS_TIP;
    }

    /**
     * 删除学员管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer studentId) {
        studentService.deleteById(studentId);
        return SUCCESS_TIP;
    }

    /**
     * 修改学员管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Student student) {
        studentService.updateById(student);
        return SUCCESS_TIP;
    }

    /**
     * 学员管理详情
     */
    @RequestMapping(value = "/detail/{studentId}")
    @ResponseBody
    public Object detail(@PathVariable("studentId") Integer studentId) {
        return studentService.selectById(studentId);
    }
}
