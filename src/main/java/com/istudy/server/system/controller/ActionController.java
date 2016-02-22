package com.istudy.server.system.controller;

import static com.istudy.server.common.constants.ResultInfoConstants.CODE_SUCCESS;
import static com.istudy.server.common.constants.ResultInfoConstants.DESC_SUCCESS;

import java.util.Map;















import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.istudy.server.cms.controller.CMSController;
import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.validate.annotation.NotNull;
import com.istudy.server.common.validate.annotation.ValidatingField;
import com.istudy.server.common.validate.annotation.Validation;
import com.istudy.server.common.vo.CMSVO;
import com.istudy.server.common.vo.ResultVO;
import com.istudy.server.system.facade.ActionFacade;
import com.istudy.server.system.vo.ActionVO;

@Controller
@RequestMapping("/actions/")
public class ActionController extends CMSController{

	private static final Log LOG = LogFactory.getLog(ActionController.class);
	
	@Autowired
	private ActionFacade actionFacade;
	
	@RequestMapping(value="getAllActions")
	public ModelAndView getAllActions(){
		Map<String, Object> map = this.actionFacade.initActionInfo();
		return new ModelAndView("cms/action_list",map);
	}
	
	@RequestMapping(value="getActionById",method=RequestMethod.GET)
	@NotNull({"actionID"})
	public ModelAndView getActionById(@RequestParam("actionID") String actionID){
		Map<String, Object> result = this.actionFacade.initActionInfoByID(actionID);
		return new ModelAndView("cms/addOrModAction",result);
	}
	
	@RequestMapping(value="getAddActionPage",method=RequestMethod.GET)
	public ModelAndView getAddActionPage(){
		return new ModelAndView("cms/addOrModAction");
	}
	
	@RequestMapping(value = "delAction", method = RequestMethod.POST)
	@NotNull({"actionIDs"})
	public @ResponseBody ResultVO delAction(@RequestParam("actionIDs") String actionIDs){
		String[] actionIds = actionIDs.split(",");
		for(String actionID : actionIds){
			LogUtils.log("ActionController.delAction start.actionID:"+actionID);
			this.actionFacade.delActionInfo(actionID);
			LogUtils.log("ActionController.delAction end.");
		}
		return super.success();
	}
	
	@RequestMapping(value = "modiActionInfo", method = RequestMethod.POST)
	@Validation({
			@ValidatingField(name = "actionVo.actionName", max = 255),
			@ValidatingField(name = "actionVo.actionDesc", max = 300),
			@ValidatingField(name = "actionVo.actionID", max = 300),
			@ValidatingField(name = "actionVo.actionURL", max = 300)})
	public @ResponseBody
	CMSVO modiActionInfo(ActionVO actionVo) {
		LogUtils.log("ActionController.modiActionInfo start");
		this.actionFacade.modifyActionInfo(actionVo);
		if (LOG.isInfoEnabled()) {
			LOG.info("modiActionInfo:" + actionVo);
		}
		LogUtils.log("ActionController.modiActionInfo end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "saveActionInfo", method = RequestMethod.POST)
	@Validation({
			@ValidatingField(name = "actionVo.actionName", max = 255),
			@ValidatingField(name = "actionVo.actionDesc", max = 300),
			@ValidatingField(name = "actionVo.actionURL", max = 300)})
	public @ResponseBody
	CMSVO saveActionInfo(ActionVO actionVo) {
		LogUtils.log("ActionController.saveActionInfo start");
		actionVo.setActionID(CommonUtils.uuid());
		this.actionFacade.saveActionInfo(actionVo);
		if (LOG.isInfoEnabled()) {
			LOG.info("saveActionInfo:" + actionVo);
		}
		LogUtils.log("ActionController.saveActionInfo end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
}
