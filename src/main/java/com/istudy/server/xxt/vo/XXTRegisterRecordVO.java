package com.istudy.server.xxt.vo;

public class XXTRegisterRecordVO {

	private String id;
	private String phone;//校讯通手机号
	private String stuUserName;//学生姓名
	private String schoolId;//学校ID
	private String schoolName;//学校名称
	private Integer gradeId;//年级ID
	private String gradeName;//年级名称
	private String classId;//班级ID
	private String className;//班级名称
	private Integer studentId;//学生ID
	private String parentId;//家长ID
	private String parUserName;//家长姓名
	
	private Integer status;//状态 0.未注册成功 1.已注册成功 2.已作废
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStuUserName() {
		return stuUserName;
	}
	public void setStuUserName(String stuUserName) {
		this.stuUserName = stuUserName;
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
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
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
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParUserName() {
		return parUserName;
	}
	public void setParUserName(String parUserName) {
		this.parUserName = parUserName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
