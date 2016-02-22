package com.istudy.server.cms.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.istudy.server.cms.facade.LoginFacade;
import com.istudy.server.cms.vo.LoginVO;
import com.istudy.server.common.utils.EncryptionUtils;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.validate.annotation.NotNull;
import com.istudy.server.common.vo.ResultVO;
import com.istudy.server.common.web.BaseController;


@Controller
@RequestMapping("/login/")
public class LoginController extends BaseController{

	@Autowired
	private LoginFacade loginFacade;

/*	@RequestMapping(value = "login", method = RequestMethod.POST)
	@NotNull({"login.userName","login.password"})
	public @ResponseBody ResultVO login( LoginVO login,HttpServletRequest req,HttpServletResponse res) {
		login.setPassword(EncryptionUtils.md5(login.getPassword()));
		this.loginFacade.login(login,req);
		req.getSession().setAttribute(req.getSession().getId(), login.getUserName());
		return success();  
	}*/
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@NotNull({"login.userName","login.password"})
	public @ResponseBody ResultVO login( LoginVO login,HttpServletRequest req,HttpServletResponse res) {
		login.setPassword(EncryptionUtils.md5(login.getPassword()));
		//this.loginFacade.login(login,req);
		LoginVO afterLogin = this.loginFacade.login(login,req);
		req.getSession().setAttribute("username", login.getUserName());
		req.getSession().setAttribute("user", afterLogin);
		req.getSession().setAttribute("enterpriseFooter", afterLogin.getEnterpriseFooter());
		return success();  
	}
	
	@RequestMapping(value = "showLoginPage", method = RequestMethod.GET)
	public String showLoginPage(){
		return "cms/login";
	}
	
	@RequestMapping(value="showError")
	public String showErrorPage(){
		return "cms/error";
	}
	
/*	@RequestMapping(value = "unlogin", method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ResultVO unlogin(HttpServletRequest req){
		HttpSession session = req.getSession();
		String id = session.getId();
		LogUtils.L.info("LoginController.unlogin start, session id:"+id + "  power"+ session.getAttribute("power"));
		String userName = (String) session.getAttribute(id);
		session.removeAttribute(id);
		session.removeAttribute("power");
		LogUtils.L.info("LoginController.unlogin end, userName:"+userName);
		return super.success();
	}*/
	
	@RequestMapping(value = "unlogin", method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody ResultVO unlogin(HttpServletRequest req){
		HttpSession session = req.getSession();
		String id = session.getId();
		LogUtils.L.info("LoginController.unlogin start, session id:"+id);
		String userName = (String) session.getAttribute(id);
		session.invalidate();
		LogUtils.L.info("LoginController.unlogin end, userName:"+userName);
		return super.success();
	}
}
