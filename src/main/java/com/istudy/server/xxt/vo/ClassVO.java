package com.istudy.server.xxt.vo;

import java.util.List;

import com.istudy.server.common.vo.CMSVO;

public class ClassVO extends CMSVO implements Comparable<ClassVO>{
	private String id;
	private String classId;
	private String className;
	private String gradeId;
	private String gradeName;
	private String bank;
	private String classType;
	private String schoolId;
	private String cityId;
	
	private List<StudentVO> students;
	private List<TeacherVO> teachers;
	
	public ClassVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClassVO(String classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public List<StudentVO> getStudents() {
		return students;
	}
	public void setStudents(List<StudentVO> students) {
		this.students = students;
	}
	public List<TeacherVO> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<TeacherVO> teachers) {
		this.teachers = teachers;
	}
	
	
	@Override
	public int compareTo(ClassVO o) {
		if(bank != null && o != null){
			int res = 0;
			try {
				int bank1 = Integer.parseInt(bank);
				int bank2 = Integer.parseInt(o.getBank());
				res = Integer.compare(bank1, bank2);
			} catch (Exception e) {
			}
			
			if(res == 0 && classId != null){
				try {
					int classId1 = Integer.parseInt(classId);
					int classId2 = Integer.parseInt(o.getClassId());
					res = Integer.compare(classId1,classId2);
				} catch (Exception e) {
				}
			}
			return res;
		}
		return 0;
	}
	
}
