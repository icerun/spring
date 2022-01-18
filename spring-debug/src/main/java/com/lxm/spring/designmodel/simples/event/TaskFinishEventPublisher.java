package com.lxm.spring.designmodel.simples.event;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 自定义容器发布器
 * @Author shenshixi
 * @Date 2022/1/18 23:22
 * @Version 1.0
 */
public class TaskFinishEventPublisher {

	private List<TaskFinishEventListener> listeners = new ArrayList<>();

	/**
	 * 注册监听器
	 *
	 * @param listener
	 */
	public synchronized void register(TaskFinishEventListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	/**
	 * 从容器中移除监听器
	 *
	 * @param listener
	 */
	public void removeListener(TaskFinishEventListener listener) {
		listeners.remove(listener);
	}

	/**
	 * 发布事件
	 */
	public void publishEvent(TaskFinishEvent taskFinishEvent){
		for (TaskFinishEventListener listener : listeners) {
			listener.onTaskFinish(taskFinishEvent);
		}
	}

}
