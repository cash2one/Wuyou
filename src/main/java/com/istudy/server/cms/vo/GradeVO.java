package com.istudy.server.cms.vo;

import com.istudy.server.common.utils.JsonUtils;

public class GradeVO {
	private String id;
	private String gradeNO ;
	private String gradeName;
	private String  activate;
	
	public String getActivate() {
		return activate;
	}
	public void setActivate(String activate) {
		this.activate = activate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGradeNO() {
		return gradeNO;
	}
	public void setGradeNO(String gradeNO) {
		this.gradeNO = gradeNO;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	@Override
	public String toString() {
		return JsonUtils.toString(this);
	}
	
}
