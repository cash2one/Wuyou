package com.istudy.server.system.vo;

public class EnterpriseVO {

	private String enterpriseID;
	private String enterpriseName;
	private String enterpriseDesc;
	private String vendorType;
	private String enterpriseHeader;//页眉
	private String enterpriseFooter;//页脚
	private String footerId;
	public String getFooterId() {
		return footerId;
	}
	public void setFooterId(String footerId) {
		this.footerId = footerId;
	}
	public String getEnterpriseHeader() {
		return enterpriseHeader;
	}
	public void setEnterpriseHeader(String enterpriseHeader) {
		this.enterpriseHeader = enterpriseHeader;
	}
	public String getEnterpriseFooter() {
		return enterpriseFooter;
	}
	public void setEnterpriseFooter(String enterpriseFooter) {
		this.enterpriseFooter = enterpriseFooter;
	}
	public String getVendorType() {
		return vendorType;
	}
	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
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
	public String getEnterpriseDesc() {
		return enterpriseDesc;
	}
	public void setEnterpriseDesc(String enterpriseDesc) {
		this.enterpriseDesc = enterpriseDesc;
	}
	public EnterpriseVO(){
		
	}
}
