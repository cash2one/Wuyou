package com.istudy.server.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istudy.server.cms.vo.UERegisterVO;
import com.istudy.server.common.dao.BaseDAO;
import com.istudy.server.common.service.BaseService;

@Service("ueService")
public class UEService extends BaseService{
	
	@Autowired
	private BaseDAO baseDao;
	
	public void saveUERegister(UERegisterVO vo){
		baseDao.insert(vo);
	}
}
