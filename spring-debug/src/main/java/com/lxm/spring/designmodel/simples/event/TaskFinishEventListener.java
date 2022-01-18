package com.lxm.spring.designmodel.simples.event;

import java.util.EventListener;

/**
 * @Description 任务结束事件监听器
 * @Author shenshixi
 * @Date 2022/1/18 23:17
 * @Version 1.0
 */
public interface TaskFinishEventListener extends EventListener {
	/**
	 * 开启任务
	 *
	 * @param taskFinishEvent
	 */
	void onTaskFinish(TaskFinishEvent taskFinishEvent);
}
