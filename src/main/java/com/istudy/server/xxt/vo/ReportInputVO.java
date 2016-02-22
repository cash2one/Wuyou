package com.istudy.server.xxt.vo;

import org.apache.cxf.jaxrs.ext.form.Form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.vo.CMSVO;

public class ReportInputVO extends CMSVO{

	private String ticketNo;
	private String realName;
	private String studyType;
	private String userIP;
	
	private Float yuwen;
	private Float shuxue;
	private Float yingyu;
	private Float wuli;
	private Float huaxue;
	private Float dili;
	private Float lishi;
	private Float zhengzhi;
	private Float shengwu;
	
	@JsonIgnore
	public Form getMatcherForm(){
		Form body = new Form();
		body.set("TicketNo", CommonUtils.nullToEmpty(this.getTicketNo()));
		body.set("RealName", CommonUtils.nullToEmpty(this.getRealName()));
		body.set("StudyType", CommonUtils.nullToEmpty(this.getStudyType()));
		body.set("Score", this.getScoreAsString());
		body.set("UserIP", CommonUtils.nullToEmpty(this.getUserIP()));
		return body;
	}
	
	@JsonIgnore
	public Form getNoMatcherScoreForm(){
		return getMatcherForm();
		/*Form body = new Form();
		body.set("TicketNo", CommonUtils.nullToEmpty(this.getTicketNo()));
		body.set("RealName", CommonUtils.nullToEmpty(this.getRealName()));
		body.set("StudyType", this.getStudyType());
		body.set("Score", this.getScoreAsString());
		body.set("UserIP", CommonUtils.nullToEmpty(this.getUserIP()));
		return body;*/
	}
	
	@JsonIgnore
	public String getScoreAsString(){
		StringBuilder score = new StringBuilder();
		score.append(scoreToStr(yuwen)).append(",");
		score.append(scoreToStr(shuxue)).append(",");
		score.append(scoreToStr(yingyu)).append(",");
		score.append(scoreToStr(wuli)).append(",");
		score.append(scoreToStr(huaxue)).append(",");
		score.append(scoreToStr(dili)).append(",");
		score.append(scoreToStr(lishi)).append(",");
		score.append(scoreToStr(zhengzhi)).append(",");
		score.append(scoreToStr(shengwu));
		return score.toString();
	}
	
	
	public String getTicketNo() {
		return ticketNo;
	}



	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}



	public String getRealName() {
		return realName;
	}



	public void setRealName(String realName) {
		this.realName = realName;
	}



	public String getStudyType() {
		return studyType;
	}



	public void setStudyType(String studyType) {
		this.studyType = studyType;
	}



	public String getUserIP() {
		return userIP;
	}



	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}



	public Float getYuwen() {
		return yuwen;
	}
	
	public String getYuwenAsString() {
		return CommonUtils.formatFloatString(getYingyu());
	}



	public void setYuwen(Float yuwen) {
		this.yuwen = yuwen;
	}



	public Float getShuxue() {
		return shuxue;
	}
	
	public String getShuxueAsString() {
		return CommonUtils.formatFloatString(getShuxue());
	}

	public void setShuxue(Float shuxue) {
		this.shuxue = shuxue;
	}



	public Float getYingyu() {
		return yingyu;
	}

	public String getYingyuAsString() {
		return CommonUtils.formatFloatString(getYingyu());
	}


	public void setYingyu(Float yingyu) {
		this.yingyu = yingyu;
	}



	public Float getWuli() {
		if("1".equals(this.getStudyType())){
			return null;
		}
		return wuli;
	}
	
	public String getWuliAsString() {
		return CommonUtils.formatFloatString(getWuli());
	}


	public void setWuli(Float wuli) {
		this.wuli = wuli;
	}

	

	public Float getHuaxue() {
		if("1".equals(this.getStudyType())){
			return null;
		}
		return huaxue;
	}
	
	public String getHuaxueAsString() {
		return CommonUtils.formatFloatString(getHuaxue());
	}



	public void setHuaxue(Float huaxue) {
		this.huaxue = huaxue;
	}



	public Float getDili() {
		if("2".equals(this.getStudyType())){
			return null;
		}
		return dili;
	}
	
	public String getDiliAsString() {
		return CommonUtils.formatFloatString(getDili());
	}



	public void setDili(Float dili) {
		this.dili = dili;
	}



	public Float getLishi() {
		if("2".equals(this.getStudyType())){
			return null;
		}
		return lishi;
	}

	public String getLishiAsString() {
		return CommonUtils.formatFloatString(getLishi());
	}


	public void setLishi(Float lishi) {
		this.lishi = lishi;
	}



	public Float getZhengzhi() {
		if("2".equals(this.getStudyType())){
			return null;
		}
		return zhengzhi;
	}


	public String getZhengzhiAsString() {
		return CommonUtils.formatFloatString(getZhengzhi());
	}

	public void setZhengzhi(Float zhengzhi) {
		this.zhengzhi = zhengzhi;
	}



	public Float getShengwu() {
		if("1".equals(this.getStudyType())){
			return null;
		}
		return shengwu;
	}

	public String getShengwuAsString() {
		return CommonUtils.formatFloatString(getShengwu());
	}

	public void setShengwu(Float shengwu) {
		this.shengwu = shengwu;
	}


	private String scoreToStr(Float score){
		String res = CommonUtils.formatFloatString(score + "");
		return res == null ? "0" : res;
	}
}
