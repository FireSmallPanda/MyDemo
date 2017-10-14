package cn.danywer.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class PropertiesUtil {
    public static void main(String[] args) throws IOException {

        System.out.println(load("error_CN.properties", "SY0000"));
    }

    /**
     * 取配置文件的属性
     *
     * @param path 配置文件名字
     * @param code 配置
     * @return
     */
    public static String load(String path, String code) {
//        // 获取参数
//        Properties props = new Properties();
//        // Resource resource = new ClassPathResource(path);
//        String pz = ""; // 是否开启
//        InputStream in;
//        try {
//            props.load(new InputStreamReader(Object.class.getResourceAsStream("/" + path), "UTF-8"));
//            pz = props.get(code).toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Properties props = new Properties();
        try {
            props.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String h = props.getProperty(code);
        return h;

    }


}
