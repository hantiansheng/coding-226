package com.imooc.activiti.example;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * test
 *
 * @author jimmy
 **/
public class MyJavaDelegate implements JavaDelegate, Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyJavaDelegate.class);

    @Override
    public void execute(DelegateExecution execution) {
        LOGGER.info("run my java delegate {}", this);
    }
}
