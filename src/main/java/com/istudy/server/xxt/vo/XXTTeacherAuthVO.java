package com.istudy.server.xxt.vo;

import java.util.List;

import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.vo.CMSVO;

public class XXTTeacherAuthVO extends CMSVO {

	private String cityId;
	private String userId;
	private String userName;
	private String roleType;
	
	private String roleId;
	private String roleName;
	
	private String schoolId;
	private List<String> grades;
	
	public String getGradesAsString(){
		if(CommonUtils.isNull(grades)){
			return null;
		}
		return grades.toString().replaceAll("[\\[\\s\\]]", "");
	}
	
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public List<String> getGrades() {
		return grades;
	}
	public void setGrades(List<String> grades) {
		this.grades = grades;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
