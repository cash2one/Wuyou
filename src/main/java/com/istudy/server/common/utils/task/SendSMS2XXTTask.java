package com.istudy.server.common.utils.task;

import java.util.List;
import java.util.TimerTask;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.form.Form;

import com.istudy.server.cms.vo.CMSTaskVO;
import com.istudy.server.common.constants.XXTConstants;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.xxt.service.XXTTaskService;
import com.istudy.server.xxt.service.XXTWSService;
import com.istudy.server.xxt.vo.HisTaskVO;

public class SendSMS2XXTTask extends TimerTask {
	private XXTTaskService xxtTaskService;
	
	private XXTWSService xxtWSService;
	
	public SendSMS2XXTTask(XXTTaskService xxtTaskService,
			XXTWSService xxtWSService) {
		super();
		this.xxtTaskService = xxtTaskService;
		this.xxtWSService = xxtWSService;
	}
	
	@Override
	public void run() {
		LogUtils.log("SendSMS2XXTTask run start.");
		try {
			//该逻辑已改为嵌套Iframe实现数据显示，不推送
			
//			//推荐任务列表推送到校讯通
//			List<CMSTaskVO> cmsTask = this.xxtTaskService.getCMSTaskByStatus2(XXTConstants.QUERY_SEND_SMS_INTERVAL_TIME);
//			for(CMSTaskVO task1 : cmsTask){
//				if(("1").equals(task1.getRule())){
//					//如果仅按学校推送的逻辑
//					List<String> failedSchools = this.xxtWSService.sendOemSchMessage(task1);
//					if(failedSchools.isEmpty()){
//						this.xxtTaskService.modCMSTaskStatusInfo(task1);
//					}else{
//						task1.setFailedSchoolIds(failedSchools.toString().replaceAll("[\\s\\[\\]]", ""));
//						this.xxtTaskService.updateFailedSchools(task1);
//					}
//				}
//				else if(("2").equals(task1.getRule())){
//					//仅按年级推送的逻辑
//					List<String> faileds = this.xxtWSService.sendArticle2XXT(task1);
//					if(faileds.isEmpty()){
//						this.xxtTaskService.modCMSTaskStatusInfo(task1);
//					}else{
//						task1.setFailedGrades(faileds.toString().replaceAll("[\\s\\[\\]]", ""));
//						this.xxtTaskService.updateFailedGrades(task1);
//					}
//				}
//				else{
//					//按年级城市学校推送
//					List<String> failedSchools = this.xxtWSService.sendOemArticle2XXT(task1);
//					if(failedSchools.isEmpty()){
//						this.xxtTaskService.modCMSTaskStatusInfo(task1);
//					}else{
//						task1.setFailedSchoolIds(failedSchools.toString().replaceAll("[\\s\\[\\]]", ""));
//						this.xxtTaskService.updateFailedSchools(task1);
//					}
//				}
//				//仅按年级推送的逻辑
//				/*List<String> faileds = this.xxtWSService.sendArticle2XXT(task1);
//				if(faileds.isEmpty()){
//					this.xxtTaskService.modCMSTaskStatusInfo(task1);
//				}else{
//					task1.setFailedGrades(faileds.toString().replaceAll("[\\s\\[\\]]", ""));
//					this.xxtTaskService.updateFailedGrades(task1);
//				}*/
//				
//				
//				
//				//如果仅按学校推送的逻辑
//				/*List<String> failedSchools = this.xxtWSService.sendOemSchMessage(task1);
//				if(failedSchools.isEmpty()){
//					this.xxtTaskService.modCMSTaskStatusInfo(task1);
//				}else{
//					task1.setFailedSchoolIds(failedSchools.toString().replaceAll("[\\s\\[\\]]", ""));
//					this.xxtTaskService.updateFailedSchools(task1);
//				}*/
//			}
			
			List<HisTaskVO> tasks = this.xxtTaskService.getCMSTaskByStatus(XXTConstants.QUERY_SEND_SMS_INTERVAL_TIME);
			for(HisTaskVO task : tasks){
				try{
					this.xxtTaskService.modHisTaskStatusInfo1(task);
					if(XXTConstants.SEND_SMS_STATUS_FAILED.equals(task.getSendStatus())){
						task.setSendUsers(task.getFailedUsers());
					}
					List<String> faileds = this.xxtWSService.sendSysSms(task);
					if(faileds.isEmpty()){
						task.setSendStatus(XXTConstants.SEND_SMS_STATUS_SUCCESS);
						task.setFailedUsers(null);
						
					}else{
						task.setSendStatus(XXTConstants.SEND_SMS_STATUS_FAILED);
						task.setFailedUsers(faileds.toString().replaceAll("[\\s\\[\\]]", ""));
					}
					this.xxtTaskService.modHisTaskStatusInfo(task);
				}catch (Exception e){
					LogUtils.L.error(e);
				}
				
			}
		} catch (Exception e) {
			LogUtils.L.error(e);
		}
		LogUtils.log("SendSMS2XXTTask run end.");
	}
}
