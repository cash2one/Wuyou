package com.istudy.server.xxt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istudy.server.common.dao.BaseDAO;
import com.istudy.server.common.service.BaseService;
import com.istudy.server.xxt.vo.XXTRegisterRecordVO;

@Service("xxtRegisterService")
public class XXTRegisterService extends BaseService{

	@Autowired
	private BaseDAO baseDao;
	
	public void saveRegisterRecord(XXTRegisterRecordVO xxtAuthValidRecordVO){
		baseDao.insert(xxtAuthValidRecordVO);
	}
	
	public void updateRegisterRecordStatus(String id){
		baseDao.update(id);
	}
	
	public void invalidRegisterRecord(String id){
		baseDao.update(id);
	}
	
	public List<XXTRegisterRecordVO> findRegisterRecord(String phone){
		return baseDao.selectList(phone);
	}
}
