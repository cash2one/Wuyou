package com.istudy.server.cms.vo;

import com.istudy.server.common.vo.CMSVO;


public class IstudyResultVO extends CMSVO{

	private String code;
	
	private String desc;
	

	public IstudyResultVO() {
		super();
	}

	public IstudyResultVO(String code, String desc) {
		super();
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
