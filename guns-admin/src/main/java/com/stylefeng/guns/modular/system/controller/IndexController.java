package com.stylefeng.guns.modular.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.SqlRunner;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.annotion.BussinessLog;
import com.stylefeng.guns.core.common.annotion.Permission;
import com.stylefeng.guns.core.common.constant.Const;
import com.stylefeng.guns.core.common.constant.factory.PageFactory;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.system.model.OperationLog;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.IIndexService;
import com.stylefeng.guns.modular.system.service.ILoginLogService;
import com.stylefeng.guns.modular.system.service.IUserService;
import com.stylefeng.guns.modular.system.warpper.LogWarpper;
import com.stylefeng.guns.modular.system.warpper.NoticeWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 公用方法的控制器
 *
 * @author fengshuonan
 * @Date 2017年4月5日 19:45:36
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {

    private static String PREFIX = "/system/index/";

    @Autowired
    private IIndexService indexService; 
    
    @Autowired
    private IUserService userService;
    
    /**
     * 获取通知列表
     */
    @RequestMapping(value = "/getStatistics")
    @ResponseBody
    public Object getStatistics(){
    	//取得用户注册总人数
    	
    	//取得计划总数
    	
    	//取得 当前用户计划总数
    	
    	// 取得当前用户便签总数
    	Map<String ,Object> map = indexService.getStatistics();
    	 return JSONObject.toJSON(map);
    }
    
    
    
    /**
     * 重置链接
     */
    @RequestMapping(value = "/updateLinkCode")
    @ResponseBody
    public Object updateLinkCode(){
    	 User user = this.userService.selectById(ShiroKit.getUser().getId());
    	 user.setLinkcode(UUID.randomUUID().toString().replace("-", ""));
    	 userService.updateById(user);
    	 return JSONObject.toJSON( ApiTip.ok(user.getLinkcode()));
    }
    
    
    
    /**
     * 重置链接
     */
    @RequestMapping(value = "/admin_updateLinkCode")
    @ResponseBody
    public Object updateLinkCode(int id){
    	 User user = this.userService.selectById(id);
    	 user.setLinkcode(UUID.randomUUID().toString().replace("-", ""));
    	 userService.updateById(user);
    	 return JSONObject.toJSON( ApiTip.ok(user.getLinkcode()));
    }
    

}
