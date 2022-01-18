package com.lxm.spring.designmodel.simples.event;

/**
 * @Description
 * @Author shenshixi
 * @Date 2022/1/18 23:20
 * @Version 1.0
 */
public class EmailEventListener implements TaskFinishEventListener{

	/**
	 * 开启任务
	 *
	 * @param taskFinishEvent
	 */
	@Override
	public void onTaskFinish(TaskFinishEvent taskFinishEvent) {
		System.out.println("发送邮件：" + "task===>"+ taskFinishEvent);
	}
}
