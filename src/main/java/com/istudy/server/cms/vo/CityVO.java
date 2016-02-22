package com.istudy.server.cms.vo;

import com.istudy.server.common.utils.JsonUtils;

public class CityVO {
	private String id;
	private String cityId;
	private String cityName;
	private String provinceId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	@Override
	public String toString() {
		return JsonUtils.toString(this);
	}
	
}
