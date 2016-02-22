package com.istudy.server.common.utils.task;

import java.util.List;
import java.util.TimerTask;

import com.istudy.server.cms.service.CMSTaskService;
import com.istudy.server.cms.vo.CMSTaskVO;
import com.istudy.server.common.constants.XXTConstants;
import com.istudy.server.common.utils.LogUtils;

public class SendNews2XXTAppPublicAccountTask extends TimerTask{

	private CMSTaskService cmsTaskService;
	
	public SendNews2XXTAppPublicAccountTask(CMSTaskService cmsTaskService) {
		super();
		this.cmsTaskService = cmsTaskService;
	}

	@Override
	public void run() {
		LogUtils.log("SendNews2XXTAppPublicAccountTask run start.");
		List<CMSTaskVO> tasks = this.cmsTaskService.getWillSendXXTPublicAccount(XXTConstants.XXT_APP_PUBLIC_ACCOUNT_INTERVAL_TIME);
		for(CMSTaskVO task : tasks){
			try{
				this.cmsTaskService.sendSource2xxtAppSystem(task);
			}catch(Exception e){
				LogUtils.L.error(e+","+task);
			}
		}
		LogUtils.log("SendNews2XXTAppPublicAccountTask run end.");
	}

}
