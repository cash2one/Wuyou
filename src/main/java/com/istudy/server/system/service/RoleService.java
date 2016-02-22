package com.istudy.server.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.istudy.server.common.service.BaseService;
import com.istudy.server.system.vo.ActionVO;
import com.istudy.server.system.vo.RoleVO;

@Service
public class RoleService extends BaseService{

	public List<RoleVO> getAllRoles() {
		return this.baseDAO.selectList();
	}
	
	public RoleVO getRoleInfoById(String roleID){
		return this.baseDAO.selectOne(roleID);
	}
	
	public void saveRoleInfo(RoleVO roleVo){
		this.baseDAO.insert(roleVo);
	}
	
	public void modifyRoleInfo(RoleVO roleVo){
		this.baseDAO.update(roleVo);
	}
	
	public RoleVO checkActionByRoleID(RoleVO roleVo){
		return this.baseDAO.selectOne(roleVo);
	}
	
	public void deleteRoleInfo(String roleID){
		this.baseDAO.delete(roleID);
	}
	
	public List<RoleVO> getRoleInfoByUsername(String username){
		return this.baseDAO.selectList(username);
	}
	
	public void saveAccount2RoleInfo(RoleVO roleVo){
		this.baseDAO.insert(roleVo);
	}
	
	public RoleVO checkRoleByUsername(RoleVO roleVo){
		return this.baseDAO.selectOne(roleVo);
	}
	
	public void removeAccount2Role(RoleVO roleVo){
		this.baseDAO.delete(roleVo);
	}
	
	public void removeRole2Action(String roleID){
		this.baseDAO.delete(roleID);
	}
	
	public List<ActionVO> getActionInfoByRoleId(String roleID){
		return this.baseDAO.selectList(roleID);
	}
	
	public void removeRoleWAction(RoleVO roleVo){
		this.baseDAO.delete(roleVo);
	}
	
	public void linkRole2Action(RoleVO roleVo){
		this.baseDAO.insert(roleVo);
	}
}
