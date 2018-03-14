package com.example.demo.controller;

import com.example.demo.properties.GirlProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.example.demo.controller
 * @Author: helishi
 * @CreateDate: 2017/12/6
 * @Description: 与yml配置文件搭配取值
 */
@RestController
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${context}")
    private String context;
    //自动注入girl信息类
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        logger.info("进入方法+++++++say");
        return "Hello springBoot!";
    }
    //获取配置yml中的字段值（age: 22），结合@Value注解
    @RequestMapping(value = "/cup",method = RequestMethod.GET)
    public String cupSize(){
        logger.info("进入方法+++++++cupSize");
        return  cupSize + age;
    }
    //在配置中使用配置信息（context: "cupSize: ${cupSize},age:${age}"）
    @RequestMapping(value = "/context",method = RequestMethod.GET)
    public String context(){
        logger.info("进入方法+++++++context");
        return  context;
    }
    //通过对象来获取其属性值（配置文件+bean类，注意注解）
    @RequestMapping(value = "/girlInfo",method = RequestMethod.GET)
    public String getGirlInfo(){
        logger.info("进入方法+++++++getGirlInfo");
        return  girlProperties.getName()+girlProperties.getAge();
    }


}
