package com.istudy.server.cms.vo;

import java.util.Date;

public class UERegisterVO {

	private Integer id;
	
	private String name;
	
	private String birthYear;
	
	private Gender gender;
	
	private Identity identity;
	
	private String school;
	
	private String grade;
	
	private String subject;
	
	private String phone;
	
	private String email;

	private String uuid;
	
	private Date createDate;
	
	private String addr;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public Gender getGender() {
		return gender;
	}
	
	public Integer getGenderValue() {
		return gender.ordinal();
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public void setGender(Integer value) {
		if(value == null){
			this.gender = null;
		}else{
			this.gender = Gender.values()[value];
		}
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	
	public Integer getIdentityValue() {
		return identity.ordinal();
	}

	public void setIdentity(Integer value) {
		if(value == null){
			this.identity = null;
		}else{
			this.identity = Identity.values()[value];
		}
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public enum Gender{
		MALE("男"),
		FEMALE("女");
		
		private String disname;
		private Gender(String disname) {
			this.disname = disname;
		}
		
		public String getName(){
			return this.name();
		}
		
		public String getDisName(){
			return this.disname;
		}
	}
	
	public enum Identity{
		CLZ_MASTER("班主任"),
		TEACHER("任课老师"),
		PARENT("家长");
		
		private String disname;
		private Identity(String disname) {
			this.disname = disname;
		}
		
		public String getName(){
			return this.name();
		}
		
		public String getDisName(){
			return this.disname;
		}
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
