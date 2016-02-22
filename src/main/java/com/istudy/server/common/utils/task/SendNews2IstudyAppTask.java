package com.istudy.server.common.utils.task;

import java.util.List;
import java.util.TimerTask;

import com.istudy.server.cms.service.CMSTaskService;
import com.istudy.server.cms.vo.CMSTaskVO;
import com.istudy.server.common.constants.IstudyConstants;
import com.istudy.server.common.utils.LogUtils;

public class SendNews2IstudyAppTask extends TimerTask {

	private CMSTaskService cmsTaskService;
	
	public SendNews2IstudyAppTask(CMSTaskService cmsTaskService) {
		super();
		this.cmsTaskService = cmsTaskService;
	}


	@Override
	public void run() {
		LogUtils.log("SendNews2IstudyAppTask run start.");
		List<CMSTaskVO> tasks = this.cmsTaskService.getWillSendIstudyTasks(IstudyConstants.ISTUDY_APP_INTERVAL_TIME);
		try {
			this.cmsTaskService.sendSource2IstudyApp(tasks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LogUtils.log("SendNews2IstudyAppTask run end.");
	}

}
