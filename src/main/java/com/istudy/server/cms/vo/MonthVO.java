package com.istudy.server.cms.vo;

import com.istudy.server.common.vo.CMSVO;

public class MonthVO extends CMSVO{
	private String monthId;
	private String monthName;
	private String activate;
	public String getMonthId() {
		return monthId;
	}
	public void setMonthId(String monthId) {
		this.monthId = monthId;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	public String getActivate() {
		return activate;
	}
	public void setActivate(String activate) {
		this.activate = activate;
	}
}
