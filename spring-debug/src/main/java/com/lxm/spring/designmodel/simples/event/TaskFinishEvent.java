package com.lxm.spring.designmodel.simples.event;

import java.util.EventObject;

/**
 * @Description 任务结束事件
 * @Author shenshixi
 * @Date 2022/1/18 23:16
 * @Version 1.0
 */
public class TaskFinishEvent extends EventObject {
	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 5516075349220653480L;

	public TaskFinishEvent(Object source) {
		super(source);
	}

}
