package com.istudy.server.cms.vo;

import java.util.List;

import com.istudy.server.common.vo.CMSVO;

public class PublicAccountMsgVO extends CMSVO{
	private String service_code;
	private String public_id;
	private String msg_type;
	private String area;
	private String gradeId;
	private List<PublicAccountMsgContentVO> contents;
	
	public PublicAccountMsgVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PublicAccountMsgVO(String service_code, String public_id,
			String msg_type, String area, String grade,
			List<PublicAccountMsgContentVO> contents) {
		super();
		this.service_code = service_code;
		this.public_id = public_id;
		this.msg_type = msg_type;
		this.area = area;
		this.gradeId = grade;
		this.contents = contents;
	}

	public String getService_code() {
		return service_code;
	}
	public void setService_code(String service_code) {
		this.service_code = service_code;
	}
	public String getPublic_id() {
		return public_id;
	}
	public void setPublic_id(String public_id) {
		this.public_id = public_id;
	}
	public String getMsg_type() {
		return msg_type;
	}
	public void setMsg_type(String msg_type) {
		this.msg_type = msg_type;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public List<PublicAccountMsgContentVO> getContents() {
		return contents;
	}

	public void setContents(List<PublicAccountMsgContentVO> contents) {
		this.contents = contents;
	}


	
	
}
