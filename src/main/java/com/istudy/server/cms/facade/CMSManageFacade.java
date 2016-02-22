package com.istudy.server.cms.facade;

import static com.istudy.server.common.constants.ResultInfoConstants.CODE_USER_NOT_EXIST_FAILED;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.istudy.server.cms.service.CMSManageService;
import com.istudy.server.cms.service.CMSRoleService;
import com.istudy.server.cms.vo.LoginVO;
import com.istudy.server.cms.vo.RoleVO;
import com.istudy.server.common.exception.CMSException;
import com.istudy.server.common.exception.ResultException;
@Service("cmsManageFacade")
public class CMSManageFacade {

	@Autowired
	private CMSManageService cmsManageService;
	
	@Autowired
	private CMSRoleService cmsRoleService;
	
	@Transactional(rollbackFor=Exception.class)
	public void register(LoginVO login) {
		// TODO Auto-generated method stub
		LoginVO user = this.cmsManageService.getUserByName(login.getUserName());
		if(user!=null){
			throw new ResultException(CODE_USER_NOT_EXIST_FAILED);
		}
		else{
			this.cmsManageService.register(login);
		}
			
	}

/*	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, ?> getRoleInfo() {
		// TODO Auto-generated method stub
		final List<RoleVO> role = this.cmsRoleService.getRoleInfo();
		return new HashMap<String, Object>() {
			{
				put("role", role);
			}
		};
	}*/
	
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public List<RoleVO> getRoleInfo() {
		// TODO Auto-generated method stub
		return this.cmsRoleService.getRoleInfo();
	}


	

}
