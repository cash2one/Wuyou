package com.istudy.server.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.istudy.server.cms.vo.LogVO;
import com.istudy.server.common.service.BaseService;

@Service
public class CMSLogService extends BaseService{

	public void saveLogByActive(LogVO log){
		this.baseDAO.insert(log);
		
	}
	
	public LogVO getRoleNameByUserName(String userName){
		return this.baseDAO.selectOne(userName);
	}
}
