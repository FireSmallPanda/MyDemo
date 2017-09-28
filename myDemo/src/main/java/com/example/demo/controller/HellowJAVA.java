package com.example.demo.controller;

import com.example.demo.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/boot")
public class HellowJAVA {


    @Value("${age}")
    private int age;
    @Autowired
    private Emp emp;

    /**
     * boot试列请求
     *
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = {"/hellow","/aaa"})
    @ResponseBody
    public Emp getSession(HttpServletRequest request, HttpServletResponse response, Integer id) {

        System.out.println("您配置文件的年龄是"+age);
        System.out.println("Id:"+id);
        // 返回配置文件
        return emp;

    }
    @PostMapping(value="/hellowPost")
    @ResponseBody
    public Emp hellowPost(HttpServletRequest request, HttpServletResponse response) {

        System.out.print("(Post)您配置文件的年龄是"+age);

        // 返回配置文件
        return emp;

    }

}
