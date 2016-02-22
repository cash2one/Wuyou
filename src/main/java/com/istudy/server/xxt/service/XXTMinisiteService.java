package com.istudy.server.xxt.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istudy.server.common.dao.BaseDAO;
import com.istudy.server.common.service.BaseService;
import com.istudy.server.xxt.vo.QuesVO;
import com.istudy.server.xxt.vo.XXTSubjectChooseAccount;

@Service("xxtMinisiteService")
public class XXTMinisiteService extends BaseService{

	@Autowired
	private BaseDAO baseDao;
	
	public XXTSubjectChooseAccount nextSubjectChooseSubscribeAccount(){
		return baseDAO.selectOne();
	}
	
	public boolean hasSubjectChooseSubscribeAccount(){
		Integer count = baseDAO.selectOne();
		return count > 0;
	}
	
	public void saveSubjectChooseSubscribeAccount(XXTSubjectChooseAccount acct){
		baseDao.insert(acct);
	}

	public void saveSubjectChooseSubscribe(XXTSubjectChooseAccount acct) {
		baseDao.insert(acct);
	}

	public void saveQues(QuesVO qv) {
		baseDao.insert(qv);
	}
}
