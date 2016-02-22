package com.istudy.server.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.istudy.server.common.service.BaseService;
import com.istudy.server.system.vo.EnterpriseVO;

@Service
public class EnterpriseService extends BaseService{

	public List<EnterpriseVO> getAllEnterprise() {
		return this.baseDAO.selectList();
	}
	
	public EnterpriseVO getEnterpriseInfoById(String enterpriseID){
		return this.baseDAO.selectOne(enterpriseID);
	}
	
	public List<String> getFooterInfo(){
		return this.baseDAO.selectList();
	}
	
	public void saveEnterpriseInfo(EnterpriseVO enterpriseVo){
		this.baseDAO.insert(enterpriseVo);
	}
	
	public void modifyEnterpriseInfo(EnterpriseVO enterpriseVo){
		this.baseDAO.update(enterpriseVo);
	}
	
	public void deleteEnterpriseInfo(String enterpriseID){
		this.baseDAO.delete(enterpriseID);
	}
	
	public void deleteAccountByEnterpriseID(String enterpriseID){
		this.baseDAO.delete(enterpriseID);
	}
}
