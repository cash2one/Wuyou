package com.istudy.server.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.istudy.server.common.web.CommonController;

@Controller
@RequestMapping("/cms/")
public class CMSController extends CommonController{
	
	@RequestMapping(value="main", method = RequestMethod.GET)
	public String showMain(){
		return "cms/main";
	}
	
	@RequestMapping(value="manage", method = RequestMethod.GET)
	public String showManage(){
		return "cms/manage";
	}
	
	@Override
	public String getRootPath() {
		return "cms/";
	}
}
