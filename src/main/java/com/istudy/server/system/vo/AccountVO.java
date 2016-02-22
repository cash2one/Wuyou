package com.istudy.server.system.vo;

public class AccountVO {

	private String username;
	private String password;
	private String account_desc;
	private String enterpriseID;
	private String actionURL;
	public String getActionURL() {
		return actionURL;
	}
	public void setActionURL(String actionURL) {
		this.actionURL = actionURL;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount_desc() {
		return account_desc;
	}
	public void setAccount_desc(String account_desc) {
		this.account_desc = account_desc;
	}
	public String getEnterpriseID() {
		return enterpriseID;
	}
	public void setEnterpriseID(String enterpriseID) {
		this.enterpriseID = enterpriseID;
	}
	public AccountVO(){
		
	}
}
