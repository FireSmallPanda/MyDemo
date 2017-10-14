package cn.danywer.service.impl;

import cn.danywer.dao.StudentDao;
import cn.danywer.model.Student;
import cn.danywer.model.utils.ResultVo;
import cn.danywer.service.StudentService;
import org.springframework.stereotype.Service;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songl on 2017/8/8.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    public Boolean addStudent(Student student) {
        return studentDao.insert(student);
    }

    public Boolean deleteStudentById(Integer id) {
        Student student = new Student();
        student.setId(id);
        return studentDao.delete(student);
    }

    public Boolean updateStudentById(Student student) {
        return studentDao.update(student);
    }

    public ResultVo findAllStudent(Student student) {
        ResultVo resultVo = new ResultVo();
        List<Student> list = studentDao.select(student);
        if (list.size() > 0) {
            resultVo.setResult(list);
            resultVo.isSuccess(true);
        } else {
            resultVo.setMessage("没有找到相关信息");
        }
        return resultVo;
    }
}