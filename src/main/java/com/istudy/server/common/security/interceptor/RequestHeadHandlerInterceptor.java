package com.istudy.server.common.security.interceptor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.servlet.ModelAndView;

import com.istudy.server.common.security.BaseHandlerInterceptor;

public class RequestHeadHandlerInterceptor extends BaseHandlerInterceptor{

	/**
	 * 
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("-----------preHandle--------------");
		@SuppressWarnings("unchecked")
		Enumeration<String> hns = request.getHeaderNames();
		
		while (hns.hasMoreElements()) {
			String hn = hns.nextElement();
			System.out.println(hn+":"+request.getHeader(hn));
		}
		
		return true;
	}

	/**
	 * 
	 */
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("-----------postHandle--------------");
	}

	/**
	 * 
	 */
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//System.out.println(IOUtils.paserToString(request.getInputStream()));
		System.out.println("--------------afterCompletion---------");
	}

}
