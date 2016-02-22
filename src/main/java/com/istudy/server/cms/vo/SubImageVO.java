package com.istudy.server.cms.vo;

import org.springframework.web.multipart.MultipartFile;

import com.istudy.server.common.vo.CMSVO;

/**
 * 用于推送任务时提交图片数据时数据值对象
 * @author yangwenjie
 *
 */
public class SubImageVO extends CMSVO{

	private MultipartFile file;
	
	private int x1;
	
	private int y1;
	
	private int x2;
	
	private int y2;
	
	private int width;
	
	private int height;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
