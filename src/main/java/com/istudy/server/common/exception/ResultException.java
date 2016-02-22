package com.istudy.server.common.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ResultException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private static final Log LOG = LogFactory.getLog(ResultException.class);
	
	private String code;
	
	private boolean isRedirect;
	
	private String url;
	
	private String sourceUrl;
	
	public ResultException(String code){
		this.code = code;
		if(LOG.isErrorEnabled()){
			LOG.error("返回异常 ， code："+code);
		}
	}
	
	public ResultException(String code,String msg){
		super(msg);
		this.code = code;
		if(LOG.isErrorEnabled()){
			LOG.error("返回异常 ， code："+code+",msg:"+msg);
		}
	}
	
	public ResultException(String code,boolean isRedirect,String url,String sourceUrl){
		if(LOG.isErrorEnabled()){
			LOG.error("返回异常 ， code："+code);
		}
		this.isRedirect = isRedirect;
		this.code = code;
		this.url = url;
		this.sourceUrl = sourceUrl;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
}
