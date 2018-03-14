package com.example.demo.repository;

import com.example.demo.Bean.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Package: com.example.demo.Bean
 * @Author: helishi
 * @CreateDate: 2017/12/6
 * @Description:
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
}
