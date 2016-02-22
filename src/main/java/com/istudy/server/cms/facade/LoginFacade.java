package com.istudy.server.cms.facade;

import static com.istudy.server.common.constants.ResultInfoConstants.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.istudy.server.cms.service.CMSLogService;
import com.istudy.server.cms.service.LoginService;
import com.istudy.server.cms.vo.LogVO;
import com.istudy.server.cms.vo.LoginVO;
import com.istudy.server.common.exception.ResultException;
import com.istudy.server.common.utils.CommonUtils;

@Service
public class LoginFacade {
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private CMSLogService cmsLogService;
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public boolean isRegister( String userName){
		return this.loginService.isRegister(userName); 
	}
	
/*	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public void login(LoginVO login, HttpServletRequest req){
		LoginVO user = this.loginService.login(login);
		if(user==null||CommonUtils.isNull(user.getUserName())){
			throw new ResultException(CODE_USER_NOT_EXIST_FAILED);
		}
		if(!user.getPassword().equals(login.getPassword())){
			throw new ResultException(CODE_USER_NOT_EXIST_FAILED);
		}
		req.getSession().setAttribute("power", user.getPower());
	}*/
	

	@Transactional(rollbackFor=Exception.class)
	public LoginVO login(LoginVO login, HttpServletRequest req){
		LoginVO user = this.loginService.login_account(login);
		if(user==null||CommonUtils.isNull(user.getUserName())){
			throw new ResultException(CODE_USER_NOT_EXIST_FAILED);
		}
		if(!user.getPassword().equals(login.getPassword())){
			throw new ResultException(CODE_PASSWORD_FAILED);
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LogVO log = this.cmsLogService.getRoleNameByUserName(login.getUserName());
		log.setActiveDate(df.format(new Date()));
		log.setIp(getClientIp(req));
		log.setRoleName(log.getAccountDesc());
		log.setLogInfo("<p style='display: none;'>IP地址：[" + log.getIp() + "] 用户" + log.getUserName() + " [" + log.getEnterpriseName() + "] 在" + log.getActiveDate() + "</p>成功登陆系统");		
		this.cmsLogService.saveLogByActive(log);
		return user;
	}
	
	private String getClientIp(HttpServletRequest req){
	       String ip = req.getHeader("x-forwarded-for"); 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = req.getHeader("Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = req.getHeader("WL-Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = req.getRemoteAddr(); 
	       } 
	       return ip; 
		}	

}
