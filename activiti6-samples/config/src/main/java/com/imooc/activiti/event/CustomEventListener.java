package com.imooc.activiti.event;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.ActivitiEventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 流程event
 *
 * @author jimmy
 **/
public class CustomEventListener implements ActivitiEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomEventListener.class);

    @Override
    public void onEvent(ActivitiEvent event) {
        ActivitiEventType eventType = event.getType();

        if(ActivitiEventType.CUSTOM.equals(eventType)){
            LOGGER.info("监听到自定义事件 {} \t {}",eventType,event.getProcessInstanceId());
        }
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }
}
