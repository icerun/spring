package com.lxm.spring.designmodel.simples.event;

import com.lxm.spring.designmodel.simples.enums.TaskStatus;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/18 23:35
 * @Version 1.0
 */
public class TaskEventTest {
	public static void main(String[] args) {
		//事件
		Task task = new Task("邮箱名称", TaskStatus.SUCCESS);
		//事件结束事件
		TaskFinishEvent taskFinishEvent = new TaskFinishEvent(task);
		//事件监听器
		TaskFinishEventListener taskFinishEventListener = new EmailEventListener();
		//自定义事件容器
		TaskFinishEventPublisher publisher = new TaskFinishEventPublisher();
		//注册监听器
		publisher.register(taskFinishEventListener);
		//发布事件
		publisher.publishEvent(taskFinishEvent);

	}

}
