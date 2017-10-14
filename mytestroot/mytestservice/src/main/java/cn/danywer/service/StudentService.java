package cn.danywer.service;

import cn.danywer.model.Student;
import cn.danywer.model.utils.ResultVo;

import java.util.List;

/**
 * 学生业务层
 */
public interface StudentService {

    /**
     * 添加学生
     * @param student
     * @return
     */
    Boolean addStudent(Student student);

    /**
     * 根据ID删除学生
     * @param id
     * @return
     */
    Boolean deleteStudentById(Integer id);

    /**
     * 根据ID修改学生信息
     * @param student
     * @return
     */
    Boolean updateStudentById(Student student);

    /**
     * 按条件查找所有学生
     * @param student
     * @return
     */
//修改之处
    ResultVo findAllStudent(Student student);



}
