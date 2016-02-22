package com.istudy.server.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.istudy.server.cms.vo.PrepExamSubscribeVo;
import com.istudy.server.common.dao.BaseDAO;

@Service("iStudyMinisiteService")
public class IStudyMinisiteService {

	@Autowired
	private BaseDAO baseDao;
	
	@Transactional(readOnly=true)
	public void savePrepExamSubscribe(PrepExamSubscribeVo vo){
		baseDao.insert(vo);
	}
	
	@Transactional(readOnly=true)
	public boolean checkPrepExamSubscribeUnique(String phone){
		Integer count = baseDao.selectOne(phone);
		return count == 0;
	}
}
