package com.istudy.server.cms.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.istudy.server.cms.service.UEService;
import com.istudy.server.cms.vo.UERegisterVO;

@Service("ueFacade")
public class UEFacade {
	
	@Autowired
	private UEService ueService;
	
	@Transactional(rollbackFor=Exception.class)
	public void saveUERegister(UERegisterVO vo){
		ueService.saveUERegister(vo);
	}
}
