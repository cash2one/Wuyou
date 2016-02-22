package com.istudy.server.common.service;

import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istudy.server.cms.service.CMSTaskService;
import com.istudy.server.common.constants.IstudyConstants;
import com.istudy.server.common.constants.XXTConstants;
import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.utils.task.SendArticle2IstudyAppTask;
import com.istudy.server.common.utils.task.SendNews2IstudyAppTask;
import com.istudy.server.common.utils.task.SendNews2XXTAppPublicAccountTask;
import com.istudy.server.common.utils.task.SendSMS2XXTTask;
import com.istudy.server.xxt.service.XXTTaskService;
import com.istudy.server.xxt.service.XXTWSService;

@Service("contextInitFacade")
public class ContextInitFacade {
	@Autowired
	private ContextService contextService;
	
	@Autowired
	private XXTTaskService xxtTaskService;
	
	@Autowired
	private XXTWSService xxtWSService;
	
	@Autowired
	private CMSTaskService cmsTaskService;
	
	public void initSendSMS2XXTTask(){
		Timer sendSMS2XXTTaskTimer = new Timer();	
		//t.schedule(new SendSMS2XXTTask(xxtTaskService, xxtWSService), 1000,1*60*1000);
		sendSMS2XXTTaskTimer.schedule(new SendSMS2XXTTask(xxtTaskService, xxtWSService), 3000,CommonUtils.parseInt(XXTConstants.SEND_SMS_INTERVAL_TIME)*60*1000);
	}
	
	public void initSendNews2XXTAppPublicAccountTask(){
		Timer sendNews2XXTAppPublicAccountTimer = new Timer();	
		sendNews2XXTAppPublicAccountTimer.schedule(
				new SendNews2XXTAppPublicAccountTask(cmsTaskService), 5000,CommonUtils.parseInt(XXTConstants.XXT_APP_PUBLIC_ACCOUNT_TASK_INTERVAL_TIME)*60*1000);
	}
	
	public void initSendNews2IstudyTask() {
		Timer sender = new Timer();
		sender.schedule(
				new SendNews2IstudyAppTask(cmsTaskService),
				7000,
				CommonUtils.parseInt(IstudyConstants.ISTUDY_APP_TASK_INTERVAL_TIME) * 60 * 1000);
	}
	
	public void initSendArticle2IstudyTask() {
		Timer sender = new Timer();
		sender.schedule(
				new SendArticle2IstudyAppTask(xxtTaskService, cmsTaskService),
				9000,
				CommonUtils.parseInt(IstudyConstants.ISTUDY_APP_TASK_INTERVAL_TIME) * 60 * 1000);
	}
}
