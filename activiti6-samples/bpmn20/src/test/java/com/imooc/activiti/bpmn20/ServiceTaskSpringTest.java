package com.imooc.activiti.bpmn20;

import com.google.common.collect.Maps;
import com.imooc.activiti.example.MyJavaBean;
import com.imooc.activiti.example.MyJavaDelegate;
import org.activiti.engine.ActivitiEngineAgenda;
import org.activiti.engine.ManagementService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author jimmy
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:activiti-context.xml")
public class ServiceTaskSpringTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceTaskSpringTest.class);

    @Resource
    @Rule
    public ActivitiRule activitiRule;

    @Test
    @Deployment(resources = {"my-process-servicetask4.bpmn20.xml"})
    public void testServiceTask() {
//        myJavaDelegate
        ProcessInstance processInstance = activitiRule.getRuntimeService().startProcessInstanceByKey("my-process");
        List<HistoricActivityInstance> activityInstances = activitiRule.getHistoryService().createHistoricActivityInstanceQuery().orderByHistoricActivityInstanceEndTime().asc().list();
        for (HistoricActivityInstance activityInstance : activityInstances) {
            LOGGER.info("activity = {}", activityInstance);
        }
    }

    @Test
    @Deployment(resources = {"my-process-servicetask4.bpmn20.xml"})
    public void testServiceTask2() {
//        myJavaDelegate
        Map<String, Object> variables = Maps.newHashMap();
        MyJavaDelegate myJavaDelegate = new MyJavaDelegate();
        LOGGER.info("myJavaDelegate = {}", myJavaDelegate);
        variables.put("myJavaDelegate", myJavaDelegate);
        ProcessInstance processInstance = activitiRule.getRuntimeService()
                .startProcessInstanceByKey("my-process", variables);
        List<HistoricActivityInstance> activityInstances = activitiRule.getHistoryService().createHistoricActivityInstanceQuery().orderByHistoricActivityInstanceEndTime().asc().list();
        for (HistoricActivityInstance activityInstance : activityInstances) {
            LOGGER.info("activity = {}", activityInstance);
        }
    } @Test
    @Deployment(resources = {"my-process-servicetask5.bpmn20.xml"})
    public void testServiceTask5() {
//        myJavaDelegate
        Map<String, Object> variables = Maps.newHashMap();
        MyJavaBean myJavaBean = new MyJavaBean("TEST");
        LOGGER.info("myJavaBean = {}", myJavaBean);
        variables.put("myJavaBean", myJavaBean);
        ProcessInstance processInstance = activitiRule.getRuntimeService()
                .startProcessInstanceByKey("my-process", variables);
        List<HistoricActivityInstance> activityInstances = activitiRule.getHistoryService().createHistoricActivityInstanceQuery().orderByHistoricActivityInstanceEndTime().asc().list();
        for (HistoricActivityInstance activityInstance : activityInstances) {
            LOGGER.info("activity = {}", activityInstance);
        }
    }


}

