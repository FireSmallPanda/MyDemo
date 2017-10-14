package cn.danywer.controller.student;

import cn.danywer.model.Student;
import cn.danywer.model.utils.ResultVo;
import cn.danywer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/studentApi/")
public class StudentAction {

    @Autowired
    public StudentService studentService;
    //添加@ResponseBody直接返回json数据
    @RequestMapping("findAllStudentInfo")
    public @ResponseBody ResultVo findAllStudentInfo (@RequestParam("id") String id){
        Student student=new Student();
        //在此我就不做过多验证判断
        if ("0".equals(id)){student=null;}
        else {student.setId(new Integer(id));}
        return studentService.findAllStudent(student);
    }
}
