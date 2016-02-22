package com.istudy.server.cms.vo;

public class RoleVO {
	private String id;
	private String roleName;
	private String rolePower;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String name) {
		this.roleName = name;
	}
	public String getRolePower() {
		return rolePower;
	}
	public void setRolePower(String rolePower) {
		this.rolePower = rolePower;
	}

}
