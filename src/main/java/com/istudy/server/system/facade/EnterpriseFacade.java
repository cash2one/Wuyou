package com.istudy.server.system.facade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.istudy.server.system.service.EnterpriseService;
import com.istudy.server.system.vo.EnterpriseVO;

@Service
public class EnterpriseFacade {

	@Autowired
	private EnterpriseService enterpriseService;
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, Object> initEnterpriseInfo(){
		final List<EnterpriseVO> rs = this.enterpriseService.getAllEnterprise();
		return new HashMap<String,Object>(){

			private static final long serialVersionUID = -8915292239247541672L;

			{
				put("result",rs);
			}};
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, Object> initEnterpriseInfoByID(String enterpriseID){
		final EnterpriseVO vo = this.enterpriseService.getEnterpriseInfoById(enterpriseID); 
		return new HashMap<String, Object>(){
			private static final long serialVersionUID = 7534007723784077449L;
		{
			put("result",vo);
		}};
	}
	
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public List<String> getFooterInfo(){
		return this.enterpriseService.getFooterInfo();
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void modifyEnterpriseInfo(EnterpriseVO enterpriseVo){
		this.enterpriseService.modifyEnterpriseInfo(enterpriseVo);
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void delEnterpriseInfo(String enterpriseID){
		this.enterpriseService.deleteAccountByEnterpriseID(enterpriseID);
		this.enterpriseService.deleteEnterpriseInfo(enterpriseID);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void saveEnterpriseInfo(EnterpriseVO enterpriseVo){
		this.enterpriseService.saveEnterpriseInfo(enterpriseVo);
	}
}
