package com.istudy.server.cms.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istudy.server.cms.service.IStudyMinisiteService;
import com.istudy.server.cms.vo.PrepExamSubscribeVo;

@Service("iStudyMinisiteFacade")
public class IStudyMinisiteFacade {

	@Autowired
	private IStudyMinisiteService iStudyMinisiteService;
	
	public void savePrepExamSubscribe(PrepExamSubscribeVo vo){
		
	}
}
