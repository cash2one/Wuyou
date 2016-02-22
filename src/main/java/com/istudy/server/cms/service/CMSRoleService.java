package com.istudy.server.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.istudy.server.cms.vo.RoleVO;
import com.istudy.server.common.service.BaseService;

@Service
public class CMSRoleService extends BaseService{

	public List<RoleVO> getRoleInfo() {
		// TODO Auto-generated method stub
		return this.baseDAO.selectList();
	}
}
