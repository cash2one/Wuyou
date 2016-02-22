package com.istudy.server.xxt.vo;

public class ClickInfo {
	
	private String idtype;
	
	private String channel;
	
	private String type;
	
	private String action;
	
	private String postId;

	public ClickInfo(){
		
	}
	
	public ClickInfo(String idtype,String channel,String type,String action,String postId){
		this.idtype=idtype;
		this.channel = channel;
		this.type = type;
		this.action = action;
		this.postId = postId;
	}
	
	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}
	
	
	

	

}
