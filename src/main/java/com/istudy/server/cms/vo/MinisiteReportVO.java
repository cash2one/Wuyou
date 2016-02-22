package com.istudy.server.cms.vo;

import com.istudy.server.common.vo.CMSVO;

public class MinisiteReportVO extends CMSVO{

	
	private String taskName;
	private String minisiteId;
	private String miniTitle;
	private String miniUrl;
	private String subjectType;
	private String grades;
	
	private String createDate;
	private String creator;
	private String creatorEntId;
	
	private long teacherActiveCount;
	private long teacherPushCount;
	private long teacherPushMsgTotal;
	private long parentEnterCount;
	
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getMinisiteId() {
		return minisiteId;
	}
	public void setMinisiteId(String minisiteId) {
		this.minisiteId = minisiteId;
	}
	public String getMiniTitle() {
		return miniTitle;
	}
	public void setMiniTitle(String miniTitle) {
		this.miniTitle = miniTitle;
	}
	public String getMiniUrl() {
		return miniUrl;
	}
	public void setMiniUrl(String miniUrl) {
		this.miniUrl = miniUrl;
	}
	public String getGrades() {
		return grades;
	}
	public void setGrades(String grades) {
		this.grades = grades;
	}
	public long getTeacherActiveCount() {
		return teacherActiveCount;
	}
	public void setTeacherActiveCount(long teacherActiveCount) {
		this.teacherActiveCount = teacherActiveCount;
	}
	public long getTeacherPushCount() {
		return teacherPushCount;
	}
	public void setTeacherPushCount(long teacherPushCount) {
		this.teacherPushCount = teacherPushCount;
	}
	public long getTeacherPushMsgTotal() {
		return teacherPushMsgTotal;
	}
	public void setTeacherPushMsgTotal(long teacherPushMsgTotal) {
		this.teacherPushMsgTotal = teacherPushMsgTotal;
	}
	public long getParentEnterCount() {
		return parentEnterCount;
	}
	public void setParentEnterCount(long parentEnterCount) {
		this.parentEnterCount = parentEnterCount;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreatorEntId() {
		return creatorEntId;
	}
	public void setCreatorEntId(String creatorEntId) {
		this.creatorEntId = creatorEntId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}
}
