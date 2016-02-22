package com.istudy.server.cms.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.istudy.server.cms.facade.CMSManageFacade;
import com.istudy.server.cms.service.CMSRoleService;
import com.istudy.server.cms.vo.LoginVO;
import com.istudy.server.cms.vo.RoleVO;
import com.istudy.server.common.utils.EncryptionUtils;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.validate.annotation.NotNull;
import com.istudy.server.common.vo.ResultVO;
import com.istudy.server.common.web.BaseController;

@Controller
@RequestMapping("/cmsmanage/")
public class CMSManageController extends CMSController{
	
	private static final Log LOG = LogFactory.getLog(CMSManageController.class);

	@Autowired
	private CMSManageFacade cmsManageFacade;
	
	@RequestMapping(value = "showRegisterPage1", method = RequestMethod.GET)
	public String showRegisterPage1(){
		return "cms/register";
	}
	
	@RequestMapping(value = "showRegisterPage")
	public ModelAndView showRegisterPage(){
		LogUtils.log("CMSManageController.showRegisterPage start");
		final List<RoleVO> role = this.cmsManageFacade.getRoleInfo();
		LogUtils.log("CMSManageController.showRegisterPage end");
		return new ModelAndView("cms/register",new HashMap<String,Object>() {
			{
				put("role", role);
			}
		});
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@NotNull({"login.userName","login.password"})
	public @ResponseBody ResultVO register( LoginVO login,HttpServletRequest req,HttpServletResponse res) {
		LogUtils.log("CMSManageController.register start");
		login.setPassword(EncryptionUtils.md5(login.getPassword()));
		this.cmsManageFacade.register(login);
		LogUtils.log("CMSManageController.register end");
		return success();  
	}
}
