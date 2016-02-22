package com.istudy.server.xxt.vo;

import java.util.ArrayList;
import java.util.List;

import com.istudy.server.common.vo.CMSVO;

public class StudentVO extends CMSVO{
	
	private int id;
	
	private String studentId;
	private String studentName;
	
	private String loginName; 
	private String headImage;
	private String email;
	private String schoolId;
	private String schoolName;
	private String section;
	
	private String cityId;
	private String areaId;
	private String areaName;
	private String townId;
	private String townName;
	private String gradeId;
	private String gradeName;
	private String bank;
	private String classId;
	private String className;
	private String classType;
	private String classSchoolId;
	private String studentSeq;
	
	private List<ParentVO> parents = new ArrayList<ParentVO>();
	
	public String getParentIds(){
		if(!parents.isEmpty()){
			StringBuilder ids = new StringBuilder(parents.get(0).getParentId() + "|" + studentId + "|" + studentName);
			for(int i = 1; i < parents.size(); i++){
				ids.append(",").append(parents.get(i).getParentId()).append("|").append(studentId).append("|").append(studentName);
			}
			return ids.toString();
		}
		return null;
	}
	
	public StudentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getClassSchoolId() {
		return classSchoolId;
	}


	public void setClassSchoolId(String classSchoolId) {
		this.classSchoolId = classSchoolId;
	}


	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	
	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public StudentVO(String studentId, String realName) {
		super();
		this.studentId = studentId;
		this.studentName = realName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}
	
	public String getRealName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStudentSeq() {
		return studentSeq;
	}

	public void setStudentSeq(String studentSeq) {
		this.studentSeq = studentSeq;
	}

	public List<ParentVO> getParents() {
		return parents;
	}

	public void setParents(List<ParentVO> parents) {
		this.parents = parents;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getTownId() {
		return townId;
	}

	public void setTownId(String townId) {
		this.townId = townId;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}
	
	
}
