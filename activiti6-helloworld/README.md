# activiti6-helloworld
activiti6-helloworld
可以有多个方式运行 helloworld体验工作流程序
1，直接idea或eclipse运行DemoMain.main()方法
2，通过maven方式打包,然后使用java -jar命令运行
    打包：_mvn package_
    运行命令：  _java -jar target/activiti6-helloworld-1.0-SNAPSHOT.jar_


**运行效果**

启动我们的程序
流程引擎名称default,版本6.0.0.4
流程定义文件 [二级审批流程] , 流程ID [second_approve:1:4]
启动流程 [second_approve]
待处理任务数量 [1]
待处理任务 [填写审批信息]
请输入 申请信息 ？
test
您输入的内容是 [test]
请输入 申请人姓名 ？
jimmy
您输入的内容是 [wjm]
请输入 提交时间 ？ 格式 （yyyy-MM-dd）
2018-01-01
您输入的内容是 [2018-01-01]
请输入 确认申请 ？
y
您输入的内容是 [y]
待处理任务数量 [1]
待处理任务 [主管审批]
请输入 主管审批结果 ？
y
您输入的内容是 [y]
请输入 主管备注 ？
tltestnote
您输入的内容是 [test]
待处理任务数量 [1]
待处理任务 [人事审批]
请输入 人事审批结果 ？
y
您输入的内容是 [y]
请输入 人事审批备注 ？
hrtestnote
您输入的内容是 [test]
结束我们的程序