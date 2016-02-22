package com.istudy.server.cms.vo;

import java.util.ArrayList;
import java.util.List;

public class IstudyContentVO {

	private String type; //类型
	
	private String title; //标题
	
	private String content; //文章内容
	
	private List<String> areaIds = new ArrayList<String>();//地区代码
	
	private List<String> gradeIds = new ArrayList<String>();//年级ID
	
	private String thumb;//小图地址
	
	private String url;//minisiteUrl

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getAreaIds() {
		return areaIds;
	}

	public void setAreaIds(List<String> areaIds) {
		this.areaIds = areaIds;
	}

	public List<String> getGradeIds() {
		return gradeIds;
	}

	public void setGradeIds(List<String> gradeIds) {
		this.gradeIds = gradeIds;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
