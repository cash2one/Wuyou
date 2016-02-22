package com.istudy.server.common.vo;

import java.util.HashMap;
import java.util.Map;

import com.istudy.server.common.utils.JsonUtils;

public class ResultVO extends CMSVO{
	private String code;
	private String desc;
	
	public ResultVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultVO(String code, String desc) {
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
	
	@SuppressWarnings("serial")
	public static Map<String,String> getResultMap(final String code,final String desc){
		return new HashMap<String,String>(){
		{put("code", code);put("desc", desc);}};
	}
	
	@Override
	public String toString() {
		return JsonUtils.toString(this);
	}
	
}
