package com.istudy.server.xxt.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.istudy.server.common.vo.CMSVO;

public class ReportResultVO extends CMSVO{

	private String code;
	
	@JsonProperty(value = "UserType")
	private String userType;
	
	private List<Report> result;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	public static class Report{
		List<StudentInfo> report1;
		List<ScoreSpace> report2;
		List<ScoreDict> report3;
		public List<StudentInfo> getReport1() {
			return report1;
		}
		public void setReport1(List<StudentInfo> report1) {
			this.report1 = report1;
		}
		public List<ScoreSpace> getReport2() {
			return report2;
		}
		public void setReport2(List<ScoreSpace> report2) {
			this.report2 = report2;
		}
		public List<ScoreDict> getReport3() {
			return report3;
		}
		public void setReport3(List<ScoreDict> report3) {
			this.report3 = report3;
		}
		
		
	}
	
	public static class StudentInfo {
		private String student_name;
		private String ticket_no;
		private String school_name;
		private String study_type;
		private String subject_name;
		public String getStudent_name() {
			return student_name;
		}
		public void setStudent_name(String student_name) {
			this.student_name = student_name;
		}
		public String getTicket_no() {
			return ticket_no;
		}
		public void setTicket_no(String ticket_no) {
			this.ticket_no = ticket_no;
		}
		public String getSchool_name() {
			return school_name;
		}
		public void setSchool_name(String school_name) {
			this.school_name = school_name;
		}
		public String getStudy_type() {
			return study_type;
		}
		public void setStudy_type(String study_type) {
			this.study_type = study_type;
		}
		public String getSubject_name() {
			return subject_name;
		}
		public void setSubject_name(String subject_name) {
			this.subject_name = subject_name;
		}
	}
	
	public static class ScoreSpace{
		private String subject_id;
		private String point;
		private String student_count;//学生人数
		private String rank_percentage;//我超过广东省的考生
		private String exam_grade;
		private String exam_subject;
		private String ordernum;
		public String getSubject_id() {
			return subject_id;
		}
		public void setSubject_id(String subject_id) {
			this.subject_id = subject_id;
		}
		public String getPoint() {
			return point;
		}
		public void setPoint(String point) {
			this.point = point;
		}
		public String getStudent_count() {
			return student_count;
		}
		public void setStudent_count(String student_count) {
			this.student_count = student_count;
		}
		public String getRank_percentage() {
			return rank_percentage;
		}
		public void setRank_percentage(String rank_percentage) {
			this.rank_percentage = rank_percentage;
		}
		public String getExam_grade() {
			return exam_grade;
		}
		public void setExam_grade(String exam_grade) {
			this.exam_grade = exam_grade;
		}
		public String getExam_subject() {
			return exam_subject;
		}
		public void setExam_subject(String exam_subject) {
			this.exam_subject = exam_subject;
		}
		public String getOrdernum() {
			return ordernum;
		}
		public void setOrdernum(String ordernum) {
			this.ordernum = ordernum;
		}
	}
	
	public static class ScoreDict{
		private String subject_id;
		private String my_point;
		private String exam_subject;
		private String tongfen_point;//同分数段的学生分数
		private String cha_tongfen_point;//与同分数段分数的差距分数
		private String target_point;//目标分数段
		private String order_point;//用来排序的
		public String getSubject_id() {
			return subject_id;
		}
		public void setSubject_id(String subject_id) {
			this.subject_id = subject_id;
		}
		public String getMy_point() {
			return my_point;
		}
		public void setMy_point(String my_point) {
			this.my_point = my_point;
		}
		public String getExam_subject() {
			return exam_subject;
		}
		public void setExam_subject(String exam_subject) {
			this.exam_subject = exam_subject;
		}
		public String getTongfen_point() {
			return tongfen_point;
		}
		public void setTongfen_point(String tongfen_point) {
			this.tongfen_point = tongfen_point;
		}
		public String getCha_tongfen_point() {
			return cha_tongfen_point;
		}
		public void setCha_tongfen_point(String cha_tongfen_point) {
			this.cha_tongfen_point = cha_tongfen_point;
		}
		public String getTarget_point() {
			return target_point;
		}
		public void setTarget_point(String target_point) {
			this.target_point = target_point;
		}
		public String getOrder_point() {
			return order_point;
		}
		public void setOrder_point(String order_point) {
			this.order_point = order_point;
		}
	}

	public List<Report> getResult() {
		return result;
	}

	public void setResult(List<Report> result) {
		this.result = result;
	}
}
