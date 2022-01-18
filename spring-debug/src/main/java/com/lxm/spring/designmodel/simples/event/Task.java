package com.lxm.spring.designmodel.simples.event;

import com.lxm.spring.designmodel.simples.enums.TaskStatus;

/**
 * @Description 任务
 * @Author shenshixi
 * @Date 2022/1/18 23:14
 * @Version 1.0
 */
public class Task {
	private String name;
	private TaskStatus taskStatus;

	public Task(String name, TaskStatus taskStatus) {
		this.name = name;
		this.taskStatus = taskStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}
}
