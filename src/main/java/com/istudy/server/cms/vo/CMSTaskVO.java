package com.istudy.server.cms.vo;

import java.util.List;

import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.vo.TaskNameViewVO;

public class CMSTaskVO extends TaskNameViewVO{
	private String id              ;
	private String taskName            ;
	private String minisiteId     ;
	private String miniDetails;
	private String miniShortDetails;
	private String miniTitle;
	private String msgDetails          ;
	private String remark          ;
	private String schools         ;
	private String grades          ;
	private String subject         ;
	private String types           ;
	private String activeDate     ;
	private String validDate;
	private String createDate     ;
	private String updateDate     ;
	private String miniUrl	;
	private String type;
	private String citys;
	private String newsThumbImg;
	private String sendPublicStatus;
	private String subjectType; //0  1
	private String creator;
	private String creatorEntId;
	private String schoolIds;
	private String failedSchoolIds;
	private String rule;  // 1城市+学校   2城市+年级    3城市+学校+年级
	private String failedGrades;
	private String msgId;
	private String reason;
	private String faqs;
	private String shareType;//分享类型
	private String sortDate;//置顶时间戳
	
	public String getMiniTitle() {
		return miniTitle;
	}
	public void setMiniTitle(String miniTitle) {
		this.miniTitle = miniTitle;
	}
	public String getSendPublicStatus() {
		return sendPublicStatus;
	}
	public void setSendPublicStatus(String sendPublicStatus) {
		this.sendPublicStatus = sendPublicStatus;
	}
	public String getNewsThumbImg() {
		return newsThumbImg;
	}
	public void setNewsThumbImg(String newsThumbImg) {
		this.newsThumbImg = newsThumbImg;
	}

	public String getCitys() {
		return citys;
	}

	public void setCitys(String citys) {
		this.citys = citys;
	}

	public String getTypeName(){
		return CommonUtils.getTypeName(type);
	};
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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

	public String getMiniDetails() {
		return miniDetails;
	}
	public void setMiniDetails(String miniDetails) {
		this.miniDetails = miniDetails;
	}
	public String getMsgDetails() {
		return msgDetails;
	}


	public void setMsgDetails(String msgDetails) {
		this.msgDetails = msgDetails;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getSchools() {
		return schools;
	}


	public void setSchools(String schools) {
		this.schools = schools;
	}


	public String getGrades() {
		return grades;
	}


	public void setGrades(String grades) {
		this.grades = grades;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getTypes() {
		return types;
	}


	public void setTypes(String types) {
		this.types = types;
	}

	public String getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public String getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}


	public String getMiniUrl() {
		return miniUrl;
	}


	public void setMiniUrl(String miniUrl) {
		this.miniUrl = miniUrl;
	}
	

	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public List<String> getCityIdList(){
		return CommonUtils.spliteStringToList(getCitys());
	}
	
	public List<String> getGradeIdList(){
		return CommonUtils.spliteStringToList(getGrades());
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public String getSchoolIds() {
		return schoolIds;
	}
	public void setSchoolIds(String schoolIds) {
		this.schoolIds = schoolIds;
	}
	public String getFailedSchoolIds() {
		return failedSchoolIds;
	}
	public void setFailedSchoolIds(String failedSchoolIds) {
		this.failedSchoolIds = failedSchoolIds;
	}
	public String getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}
	public String getFailedGrades() {
		return failedGrades;
	}
	public void setFailedGrades(String failedGrades) {
		this.failedGrades = failedGrades;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getMiniShortDetails() {
		return miniShortDetails;
	}
	public void setMiniShortDetails(String miniShortDetails) {
		this.miniShortDetails = miniShortDetails;
	}
	public String getFaqs() {
		return faqs;
	}
	public void setFaqs(String faqs) {
		this.faqs = faqs;
	}
	public String getShareType() {
		return shareType;
	}
	public void setShareType(String shareType) {
		this.shareType = shareType;
	}
	public String getCreatorEntId() {
		return creatorEntId;
	}
	public void setCreatorEntId(String creatorEntId) {
		this.creatorEntId = creatorEntId;
	}
	public String getSortDate() {
		return sortDate;
	}
	public void setSortDate(String sortDate) {
		this.sortDate = sortDate;
	}
	
}
