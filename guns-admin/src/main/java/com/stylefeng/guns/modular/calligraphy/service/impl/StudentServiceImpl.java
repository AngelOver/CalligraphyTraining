package com.stylefeng.guns.modular.calligraphy.service.impl;

import com.stylefeng.guns.modular.system.model.Student;
import com.stylefeng.guns.modular.system.dao.StudentMapper;
import com.stylefeng.guns.modular.calligraphy.service.IStudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学员表 服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-06-02
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
