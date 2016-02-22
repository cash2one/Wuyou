package com.istudy.server.system.facade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.istudy.server.system.service.RoleService;
import com.istudy.server.system.vo.ActionVO;
import com.istudy.server.system.vo.RoleVO;

@Service
public class RoleFacade {

	@Autowired
	private RoleService roleService;
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, Object> initRoleInfo(){
		final List<RoleVO> rs = this.roleService.getAllRoles();
		return new HashMap<String,Object>(){

			private static final long serialVersionUID = -8915292239247541672L;

			{
				put("result",rs);
			}};
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, Object> initRoleInfoByID(String roleID){
		final RoleVO vo = this.roleService.getRoleInfoById(roleID); 
		return new HashMap<String, Object>(){
			private static final long serialVersionUID = 7534007723784077449L;
		{
			put("result",vo);
		}};
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, Object> initRoleInfoByUsername(String username){
		final List<RoleVO> vo = this.roleService.getRoleInfoByUsername(username); 
		return new HashMap<String, Object>(){
			private static final long serialVersionUID = 7534007723784077449L;
			{
				put("result",vo);
			}};
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public RoleVO checkRoleByUsername(RoleVO roleVo){
		final RoleVO vo = this.roleService.checkRoleByUsername(roleVo); 
		return vo;
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public RoleVO checkRoleByActionID(RoleVO roleVo){
		final RoleVO vo = this.roleService.checkActionByRoleID(roleVo);
		return vo;
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public List<ActionVO> getActionInfoByRoleId(String roleID){
		return this.roleService.getActionInfoByRoleId(roleID);
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void modifyEnterpriseInfo(RoleVO roleVo){
		this.roleService.modifyRoleInfo(roleVo);
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void linkAccount2Role(RoleVO roleVo){
		this.roleService.saveAccount2RoleInfo(roleVo);
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void delRoleInfo(String roleID){
		this.roleService.deleteRoleInfo(roleID);
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void linkRole2Action(RoleVO roleVo){
		this.roleService.linkRole2Action(roleVo);
	}

	@Transactional(rollbackFor=Exception.class) 
	public void removeRoleWAction(RoleVO roleVo){
		this.roleService.removeRoleWAction(roleVo);
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void removeRole2Action(String roleID){
		this.roleService.removeRole2Action(roleID);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void saveRoleInfo(RoleVO roleVo){
		this.roleService.saveRoleInfo(roleVo);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void removeAccount2Role(RoleVO roleVo){
		this.roleService.removeAccount2Role(roleVo);
	}
}
