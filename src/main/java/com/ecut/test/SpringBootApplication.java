package com.ecut.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;


/**
 * @author Amy
 * @date 2019-07-04 18:27
 * @description: spring boot启动类
 */
@Controller
@org.springframework.boot.autoconfigure.SpringBootApplication
@ServletComponentScan
public class SpringBootApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootApplication.class, args);
    }

}
