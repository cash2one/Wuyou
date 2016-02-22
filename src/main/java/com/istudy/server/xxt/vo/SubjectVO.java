package com.istudy.server.xxt.vo;

import com.istudy.server.common.vo.CMSVO;

public class SubjectVO extends CMSVO {

	private int id;
	
	private String subjectId;
	
	private String subjectName;

	public SubjectVO(String subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
}
