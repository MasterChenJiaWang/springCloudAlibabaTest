package com.daren.chen.provider1.service.impl;

import com.daren.chen.provider1.entity.Student;
import com.daren.chen.provider1.mapper.StudentMapper;
import com.daren.chen.provider1.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chendaren
 * @since 2020-06-12
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
