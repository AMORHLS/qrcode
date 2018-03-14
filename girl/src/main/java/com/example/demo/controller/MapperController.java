package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Package: com.example.demo.controller
 * @Author: helishi
 * @CreateDate: 2017/12/6
 * @Description: @RestController和@RequestMappering注解的使用
 */
//@Controller和@ResponseBody结合相当于@RestController注解
@Controller
@ResponseBody
@RequestMapping("/mapper")
public class MapperController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    //@PathVariable取URL中的值
    @RequestMapping(value = {"/{id}/test","/test/{id}"},method = RequestMethod.GET)
    public String test(@PathVariable(value = "id")Integer id){
        logger.info("进入test方法");
        return "id:"+id;
    }
    //请求方式为get方式的mappering  id默认值：defaultValue = "0"
    @GetMapping("/test2")
    public String test2(@RequestParam(value = "id",required = false,defaultValue = "0")Integer myId){
        return "myId:"+myId;
    }
}
