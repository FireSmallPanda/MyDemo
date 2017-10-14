package cn.danywer.test;

import cn.danywer.model.Student;
import cn.danywer.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songl on 2017/8/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:config/applicationContext.xml")
public class ServiceTest {
//    @Resource
//    private StudentService studentService;
//
//    @Test
//    public void addTest() throws Exception {
//        Student student = new Student(); //
//        student.setId(new Integer("1"));
//        student.setName("王同学");
//        student.setSex("男");
//        student.setAddress("北京");
//        System.out.println(studentService.addStudent(student));
//    }
//
//    @Test
//    public void deleteTest() throws Exception {
//        System.out.println(studentService.deleteStudentById(1));
//    }
//
//    @Test
//    public void updateTest() throws Exception {
//        Student student = new Student();
//        student.setId(new Integer("4"));
//        student.setAddress("台湾");
//        System.out.println(studentService.updateStudentById(student));
//    }
//
//    @Test
//    public void select() throws Exception {
//        Student student = new Student();
//        student.setId(new Integer("1"));
//        List<Student> list = studentService.findAllStudent(null);
//        for (Student s : list) {
//            System.out.println(s.toString());
//        }
//    }
//
//
//    public void main(String[] args) throws Exception {
//        this.addTest();
//
//
//    }
}
