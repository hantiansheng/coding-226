package com.imooc.activiti.delegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试
 *
 * @author jimmy
 **/
public class HelloBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloBean.class);
    public void sayHello(){
        LOGGER.info("sayHello");
    }
}
