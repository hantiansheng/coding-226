package com.imooc.activiti.delegate;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * test
 *
 * @author jimmy
 **/
public class MDCErrorDelegage implements JavaDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(MDCErrorDelegage.class);

    @Override
    public void execute(DelegateExecution execution) {
        LOGGER.info("run MDCErrorDelegage");
        throw new RuntimeException("only test");
    }
}
