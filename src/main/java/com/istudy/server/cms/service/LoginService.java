package com.istudy.server.cms.service;

import org.springframework.stereotype.Service;

import com.istudy.server.cms.vo.LoginVO;
import com.istudy.server.common.service.BaseService;

@Service
public class LoginService extends BaseService{
	public boolean isRegister(String userName){
		return this.baseDAO.selectOne(userName);
	}
	
	public LoginVO login(LoginVO login){
		return this.baseDAO.selectOne(login);
	}
	
	public LoginVO login_account(LoginVO login){
		return this.baseDAO.selectOne(login);
	}
}
