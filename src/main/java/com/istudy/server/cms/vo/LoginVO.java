package com.istudy.server.cms.vo;

import com.istudy.server.common.utils.JsonUtils;

public class LoginVO {
	private String id;
	private String userName;
	private String password;
	private String accountDesc;
	private String roleId;
	private String realName;
	private String power;
	private String roleName;
	private String vendorType;
	private String enterpriseID;
	private String enterpriseHeader;
	private String enterpriseFooter;
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
	public String getEnterpriseID() {
		return enterpriseID;
	}
	public void setEnterpriseID(String enterpriseID) {
		this.enterpriseID = enterpriseID;
	}
	public String getVendorType() {
		return vendorType;
	}
	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	@Override
	public String toString() {
		return JsonUtils.toString(this);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountDesc() {
		return accountDesc;
	}
	public void setAccountDesc(String accountDesc) {
		this.accountDesc = accountDesc;
	}
	
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

	
}
