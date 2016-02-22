package com.istudy.server.common.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.istudy.server.common.utils.CommonUtils;

public class PagingVO extends CMSVO{
	private int pageIndex;	//当前页
	
	private int startIndex;	//起始位置
	
	private int pageSize=CommonUtils.getPagingSize();	//每页条数
	
	private int amount;		//总页数
	
	private long size;		//总记录数
	
	private Map<String,Object> param = new HashMap<String,Object>();	//参数
	
	private List<?> result;

	private String what;	
	
	private String enterpriseName;
	
	private String enterpriseID;
	
	private String enterprise_Name;

	public String getEnterprise_Name() {
		return enterprise_Name;
	}

	public void setEnterprise_Name(String enterprise_Name) {
		this.enterprise_Name = enterprise_Name;
	}

	public String getEnterpriseID() {
		return enterpriseID;
	}

	public void setEnterpriseID(String enterpriseID) {
		this.enterpriseID = enterpriseID;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public PagingVO() {
	}

	public PagingVO(String what) {
		super();
		this.what = what;
	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public int getStartIndex() {
		if(pageIndex<=1){
			return 0;
		}
		startIndex = (pageIndex-1)*pageSize;
		return startIndex;
	}

	public int getAmount() {
		amount = (int) Math.ceil((float)size/this.pageSize);
		return amount;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public Map<String, Object> getParam() {
		return param;
	}

	public void setParam(Map<String, Object> param) {
		this.param = param;
	}

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<?> result) {
		this.result = result;
	}
	
}
