package com.stylefeng.guns.modular.calligraphy.service.impl;

import com.stylefeng.guns.modular.system.model.Message;
import com.stylefeng.guns.modular.system.dao.MessageMapper;
import com.stylefeng.guns.modular.calligraphy.service.IMessageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 报名表 服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-06-02
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

}
