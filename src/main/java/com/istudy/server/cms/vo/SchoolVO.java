package com.istudy.server.cms.vo;

import com.istudy.server.common.utils.JsonUtils;

public class SchoolVO {
	private String id;
	private String schoolId ;
	private String schoolName;
	private String  schoolCity;
	
	
	@Override
	public String toString() {
		return JsonUtils.toString(this);
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getSchoolId() {
		return schoolId;
	}


	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}


	public String getSchoolName() {
		return schoolName;
	}


	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}


	public String getSchoolCity() {
		return schoolCity;
	}


	public void setSchoolCity(String schoolCity) {
		this.schoolCity = schoolCity;
	}
	
}
