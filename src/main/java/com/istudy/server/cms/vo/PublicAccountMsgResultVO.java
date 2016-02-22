package com.istudy.server.cms.vo;

import com.istudy.server.common.vo.CMSVO;

public class PublicAccountMsgResultVO extends CMSVO{
	private String state;
	private String msg;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
