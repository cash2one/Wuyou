package com.istudy.server.system.facade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.istudy.server.system.service.AccountService;
import com.istudy.server.system.vo.AccountVO;
import com.istudy.server.system.vo.ActionVO;

@Service
public class AccountFacade {

	@Autowired
	private AccountService accountService;
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, Object> initAccountInfo(){
		final List<AccountVO> rs = this.accountService.getAllAccount();
		return new HashMap<String,Object>(){

			private static final long serialVersionUID = -8915292239247541672L;

			{
				put("result",rs);
			}};
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, Object> initAccountInfoByID(String username){
		final AccountVO vo = this.accountService.getAccountInfoById(username); 
		return new HashMap<String, Object>(){
			private static final long serialVersionUID = 7534007723784077449L;
		{
			put("result",vo);
		}};
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public ActionVO getActionByUsername(AccountVO accountVo){
		return this.accountService.getActionByUsername(accountVo);
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void modifyAccountInfo(AccountVO accountVo){
		this.accountService.modifyAccountInfo(accountVo);
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void delAccountInfo(String username){
		this.accountService.deleteAccountInfo(username);
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void modPassword(AccountVO accountVo){
		this.accountService.modPassword(accountVo);
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void delAccount2Role(String username){
		this.accountService.deleteAccount2Role(username);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public int saveAccountInfo(AccountVO accountVo){
		AccountVO vo = this.accountService.getAccountInfoById(accountVo.getUsername());
		if(null!=vo){
			return 1;
		}else{
			this.accountService.saveAccountInfo(accountVo);
			return 0;
		}
	}
}
