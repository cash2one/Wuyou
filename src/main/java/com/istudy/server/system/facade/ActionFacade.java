package com.istudy.server.system.facade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.istudy.server.system.service.ActionService;
import com.istudy.server.system.vo.ActionVO;

@Service
public class ActionFacade {

	@Autowired
	private ActionService actionService;
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, Object> initActionInfo(){
		final List<ActionVO> rs = this.actionService.getAllActions();
		return new HashMap<String,Object>(){

			private static final long serialVersionUID = -8915292239247541672L;

			{
				put("result",rs);
			}};
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, Object> initActionInfoByID(String actionID){
		final ActionVO vo = this.actionService.getActionInfoById(actionID);
		return new HashMap<String, Object>(){
			private static final long serialVersionUID = 7534007723784077449L;
		{
			put("result",vo);
		}};
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public ActionVO initActionByURL(String actionURL){
		return this.actionService.getActionInfoByURL(actionURL);
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void modifyActionInfo(ActionVO actionVo){
		this.actionService.modifyActionInfo(actionVo);
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void delActionInfo(String actionID){
		this.actionService.deleteActionInfo(actionID);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void saveActionInfo(ActionVO actionVo){
		this.actionService.saveActionInfo(actionVo);
	}
}
