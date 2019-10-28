package com.imooc.activiti.springboot.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimmy
 **/
@RestController
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        return "Hello World!";
    }
}
