package com.istudy.server.cms.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.istudy.server.cms.vo.RoleVO;
import com.istudy.server.cms.vo.LoginVO;
import com.istudy.server.common.service.BaseService;
@Service("cmsManageService")
public class CMSManageService extends BaseService{

	public void register(LoginVO login) {
		// TODO Auto-generated method stub
		this.baseDAO.insert(login);
	}

	public LoginVO getUserByName(String userName) {
		// TODO Auto-generated method stub
		return this.baseDAO.selectOne();
	}

}
