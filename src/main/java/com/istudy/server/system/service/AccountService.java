package com.istudy.server.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.istudy.server.common.service.BaseService;
import com.istudy.server.system.vo.AccountVO;
import com.istudy.server.system.vo.ActionVO;

@Service
public class AccountService extends BaseService{

	public List<AccountVO> getAllAccount() {
		return this.baseDAO.selectList();
	}
	
	public AccountVO getAccountInfoById(String username){
		return this.baseDAO.selectOne(username);
	}
	
	public void saveAccountInfo(AccountVO accountVo){
		this.baseDAO.insert(accountVo);
	}
	
	public void modifyAccountInfo(AccountVO accountVo){
		this.baseDAO.update(accountVo);
	}
	
	public void deleteAccountInfo(String username){
		this.baseDAO.delete(username);
	}
	
	public void deleteAccount2Role(String username){
		this.baseDAO.delete(username);
	}
	
	public ActionVO getActionByUsername(AccountVO accountVo){
		return this.baseDAO.selectOne(accountVo);
	}
	
	public void modPassword(AccountVO accountVo){
		this.baseDAO.update(accountVo);
	}
}
