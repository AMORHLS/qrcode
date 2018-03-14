package com.example.demo.controller;

import com.example.demo.Bean.Girl;
import com.example.demo.repository.GirlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @Package: com.example.demo.controller
 * @Author: helishi
 * @CreateDate: 2017/12/6
 * @Description:
 */
@RestController
public class GirlController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private GirlRepository girlRepository;

    /**
     * 查询list
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }
    /**
     * 新增
     */
   /* @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize")String cupSize,
                          @RequestParam("age")Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }*/
   //新增方法演化
    @PostMapping(value = "/girls")
    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult){
        //Girl girl = new Girl();
        //如果有异常信息，则打印  并返回空值
        if (bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return girlRepository.save(girl);
    }

}
