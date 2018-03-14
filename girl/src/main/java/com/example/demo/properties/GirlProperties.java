package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Package: com.example.demo.Bean
 * @Author: helishi
 * @CreateDate: 2017/12/6
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private String name;
    private Integer age;
    private String cupSize;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}
