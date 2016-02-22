package com.istudy.server.xxt.vo;

import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.vo.TaskNameViewVO;

public class HisTaskVO extends TaskNameViewVO{
	private String id              ;
	private String taskName            ;
	private String minisiteId     ;
	private String msgDetails          ;
	private String activeDate     ;
	private String createDate     ;
	private String updateDate     ;
	private String sendTime;
	private String sendType;
	private String sendStatus;
	private String type;	//类型(0发全班 , 1:发个人，)
	private String sendUsers;
	private String taskId;
	private String userId;
	private String amountUsers;
	private String miniType;
	private String remark;
	private String miniUrl;
	private String teaCity;
	private String failedUsers;
	private String sendNames;
	private String syncStatus;
	private String smssn;
	private String subjectType;
	private String teaName;
	private String schoolName;
	
	public String getSendNames() {
		return sendNames;
	}

	public void setSendNames(String sendNames) {
		this.sendNames = sendNames;
	}

	public String getFailedUsers() {
		return failedUsers;
	}

	public void setFailedUsers(String failedUsers) {
		this.failedUsers = failedUsers;
	}

	public String getTeaCity() {
		return teaCity;
	}

	public void setTeaCity(String teaCity) {
		this.teaCity = teaCity;
	}

	public String getMiniUrl() {
		return miniUrl;
	}

	public void setMiniUrl(String miniUrl) {
		this.miniUrl = miniUrl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTypeInfo(){
		if (CommonUtils.isNull(type)) {
			return "";
		}else if(type.equals("0")){
			return "发全班";
		} 
		return "发个人";
	}
	
	public String getSendStatusInfo(){
		if (CommonUtils.isNull(sendStatus)) {
			return "";
		}
		switch (Integer.parseInt(sendStatus)) {
			case 0:
				return "待发送";
			case 1:
				return "发送中";
			case 2:
				return "已发送";
			case 3:
				return "发送成功";
			case 4:
				return "发送失败";
			default:
				return "";
		}
	}
	
	public String getMiniType() {
		return miniType;
	}
	public void setMiniType(String miniType) {
		this.miniType = miniType;
	}
	public String getTypeName(){
		return CommonUtils.getTypeName(miniType);
	};
	public String getAmountUsers() {
		return amountUsers;
	}
	public void setAmountUsers(String amountUsers) {
		this.amountUsers = amountUsers;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getMinisiteId() {
		return minisiteId;
	}
	public void setMinisiteId(String minisiteId) {
		this.minisiteId = minisiteId;
	}
	public String getMsgDetails() {
		return msgDetails;
	}
	public void setMsgDetails(String msgDetails) {
		this.msgDetails = msgDetails;
	}
	public String getActiveDate() {
		return activeDate;
	}
	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public String getSendStatus() {
		return sendStatus;
	}
	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSendUsers() {
		return sendUsers;
	}
	public void setSendUsers(String sendUsers) {
		this.sendUsers = sendUsers;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}

	public String getSmssn() {
		return smssn;
	}

	public void setSmssn(String smssn) {
		this.smssn = smssn;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
}
