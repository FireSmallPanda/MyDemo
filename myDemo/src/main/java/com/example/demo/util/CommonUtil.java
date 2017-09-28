package com.example.demo.util;

public class CommonUtil {


    public static void checkAge(Integer age)throws Exception{
        if(!(age>18)){
            throw new Exception("您未满18岁");
        }
    }
}
