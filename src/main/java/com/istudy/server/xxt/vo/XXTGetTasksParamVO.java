package com.istudy.server.xxt.vo;

import com.istudy.server.common.utils.JsonUtils;

public class XXTGetTasksParamVO {

	private String userId;
	
	private String sbujectIds;
	
	private String schoolId;
	
	private String gradeId;
	
	private String teacherRole;
	
	private String cityId;

	private String target;
	
	private String token;
	
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSbujectIds() {
		return sbujectIds;
	}

	public void setSbujectIds(String sbujectIds) {
		this.sbujectIds = sbujectIds;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getTeacherRole() {
		return teacherRole;
	}

	public void setTeacherRole(String teacherRole) {
		this.teacherRole = teacherRole;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return JsonUtils.toString(this);
	}
	
	
	
}
