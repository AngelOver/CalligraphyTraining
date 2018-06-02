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
import com.stylefeng.guns.modular.system.model.Message;
import com.stylefeng.guns.modular.calligraphy.service.IMessageService;

/**
 * 报名管理控制器
 *
 * @author fengshuonan
 * @Date 2018-06-02 20:43:12
 */
@Controller
@RequestMapping("/message")
public class MessageController extends BaseController {

    private String PREFIX = "/calligraphy/message/";

    @Autowired
    private IMessageService messageService;

    /**
     * 跳转到报名管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "message.html";
    }

    /**
     * 跳转到添加报名管理
     */
    @RequestMapping("/message_add")
    public String messageAdd() {
        return PREFIX + "message_add.html";
    }

    /**
     * 跳转到修改报名管理
     */
    @RequestMapping("/message_update/{messageId}")
    public String messageUpdate(@PathVariable Integer messageId, Model model) {
        Message message = messageService.selectById(messageId);
        model.addAttribute("item",message);
        LogObjectHolder.me().set(message);
        return PREFIX + "message_edit.html";
    }

    /**
     * 获取报名管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
   		Page<Message> page = new PageFactory<Message>().defaultPage();
   		page = this.messageService.selectPage(page);
   		PageInfoBT<Message> pageInfoBT= this.packForBT(page);
        return pageInfoBT;
    }

    /**
     * 新增报名管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Message message) {
        messageService.insert(message);
        return SUCCESS_TIP;
    }

    /**
     * 删除报名管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer messageId) {
        messageService.deleteById(messageId);
        return SUCCESS_TIP;
    }

    /**
     * 修改报名管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Message message) {
        messageService.updateById(message);
        return SUCCESS_TIP;
    }

    /**
     * 报名管理详情
     */
    @RequestMapping(value = "/detail/{messageId}")
    @ResponseBody
    public Object detail(@PathVariable("messageId") Integer messageId) {
        return messageService.selectById(messageId);
    }
}
