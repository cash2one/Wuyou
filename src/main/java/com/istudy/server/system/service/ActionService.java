package com.istudy.server.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.istudy.server.common.service.BaseService;
import com.istudy.server.system.vo.ActionVO;

@Service
public class ActionService extends BaseService{

	public List<ActionVO> getAllActions() {
		return this.baseDAO.selectList();
	}
	
	public ActionVO getActionInfoById(String actionID){
		return this.baseDAO.selectOne(actionID);
	}
	
	public void saveActionInfo(ActionVO actioVo){
		this.baseDAO.insert(actioVo);
	}
	
	public void modifyActionInfo(ActionVO actionVo){
		this.baseDAO.update(actionVo);
	}
	
	public void deleteActionInfo(String actionID){
		this.baseDAO.delete(actionID);
	}
	
	public ActionVO getActionInfoByURL(String actionURL){
		return this.baseDAO.selectOne(actionURL);
	}
}
