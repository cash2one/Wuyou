package com.istudy.server.common.web.context;

import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.istudy.server.common.service.ContextInitFacade;
import com.istudy.server.common.utils.LogUtils;

public class SystemContextLoaderListener extends ContextLoaderListener {
	private ApplicationContext app;  
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		LogUtils.L.info("-------------------Istudy context initialize start-----------------------");
		app = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		ContextInitFacade contextInitFacade = (ContextInitFacade)app.getBean("contextInitFacade");
/*		contextInitFacade.initSendSMS2XXTTask();
		contextInitFacade.initSendNews2XXTAppPublicAccountTask();*/
			//contextInitFacade.initSendNews2IstudyTask();
		//contextInitFacade.initSendArticle2IstudyTask();
		LogUtils.L.info("-------------------Istudy context initialize end-------------------------");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}
	
	
}
