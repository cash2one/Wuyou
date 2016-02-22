package com.istudy.server.common.utils.task;

import java.util.List;
import java.util.TimerTask;

import com.istudy.server.cms.service.CMSTaskService;
import com.istudy.server.cms.vo.CMSTaskVO;
import com.istudy.server.common.constants.IstudyConstants;
import com.istudy.server.common.constants.XXTConstants;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.xxt.service.XXTTaskService;
import com.istudy.server.xxt.service.XXTWSService;
import com.istudy.server.xxt.vo.HisTaskVO;

public class SendArticle2IstudyAppTask extends TimerTask {

	private XXTTaskService xxtTaskService;
	
	private CMSTaskService cmsTaskService;
	
	public SendArticle2IstudyAppTask(XXTTaskService xxtTaskService,
			CMSTaskService cmsTaskService) {
		super();
		this.xxtTaskService = xxtTaskService;
		this.cmsTaskService = cmsTaskService;
	}


	@Override
	public void run() {
		LogUtils.log("SendArticle2IstudyAppTask run start.");
		try {
			//1.将文章内容推送至校园＋
			List<CMSTaskVO> tasks = this.cmsTaskService.getWillSendXiaoyuanTasks(IstudyConstants.ISTUDY_APP_INTERVAL_TIME);
			try {
				this.cmsTaskService.sendArticle2IstudyApp(tasks);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//2.将校讯通老师信息同步推送至校园＋
			List<HisTaskVO> syncTasks = this.xxtTaskService.getWillSyncIstudyArticleTasks(XXTConstants.QUERY_SEND_SMS_INTERVAL_TIME);
			try {
				this.xxtTaskService.syncArticleSendStatus2IstudyApp(syncTasks);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//3.推送文章预告
			List<CMSTaskVO> noticeNasks = this.cmsTaskService.getWillSendXiaoyuanNoticeTasks(IstudyConstants.ISTUDY_APP_INTERVAL_TIME);
			try {
				this.cmsTaskService.sendArticleNotice2IstudyApp(noticeNasks);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			LogUtils.L.error(e);
		}
		LogUtils.log("SendArticle2IstudyAppTask run end.");
	}

}
