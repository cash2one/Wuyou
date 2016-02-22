package com.istudy.server.system.controller;

import static com.istudy.server.common.constants.ResultInfoConstants.CODE_SUCCESS;
import static com.istudy.server.common.constants.ResultInfoConstants.DESC_SUCCESS;

import java.util.List;
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
import com.istudy.server.system.facade.RoleFacade;
import com.istudy.server.system.vo.ActionVO;
import com.istudy.server.system.vo.RoleVO;

@Controller
@RequestMapping("/roles/")
public class RoleController extends CMSController{

	private static final Log LOG = LogFactory.getLog(RoleController.class);
	
	@Autowired
	private RoleFacade roleFacade;
	
	@Autowired
	private ActionFacade actionFacade;
	
	@RequestMapping(value="getAllRoles")
	public ModelAndView getAllRoles(){
		Map<String, Object> map = this.roleFacade.initRoleInfo();
		return new ModelAndView("cms/role_list",map);
	}
	
	@RequestMapping(value="getRoleById",method=RequestMethod.GET)
	@NotNull({"roleID"})
	public ModelAndView getRoleById(@RequestParam("roleID") String roleID){
		Map<String, Object> result = this.roleFacade.initRoleInfoByID(roleID);
		return new ModelAndView("cms/addOrModRole",result);
	}
	
	@RequestMapping(value="getAddRolePage",method=RequestMethod.GET)
	public ModelAndView getAddRolePage(){
		return new ModelAndView("cms/addOrModRole");
	}
	
	@RequestMapping(value = "delRole", method = RequestMethod.POST)
	@NotNull({"roleIDs"})
	public @ResponseBody ResultVO delEnterprise(@RequestParam("roleIDs") String roleIDs){
		String[] roleIds = roleIDs.split(",");
		for(String roleID : roleIds){
			LogUtils.log("RoleController.delRole start.roleID:"+roleID);
			this.roleFacade.removeRole2Action(roleID);
			this.roleFacade.delRoleInfo(roleID);
			LogUtils.log("RoleController.delRole end.");
		}
		return super.success();
	}
	
	@RequestMapping(value = "modiRoleInfo", method = RequestMethod.POST)
	@Validation({
			@ValidatingField(name = "roleVo.roleName", max = 255),
			@ValidatingField(name = "roleVo.roleID", max = 300),
			@ValidatingField(name = "roleVo.roleDesc", max = 300)})
	public @ResponseBody
	CMSVO modiRoleInfo(RoleVO roleVo) {
		LogUtils.log("RoleController.modiRoleInfo start");
		this.roleFacade.modifyEnterpriseInfo(roleVo);
		if (LOG.isInfoEnabled()) {
			LOG.info("modiRoleInfo:" + roleVo);
		}
		LogUtils.log("RoleController.modiRoleInfo end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "saveRoleInfo", method = RequestMethod.POST)
	@Validation({
			@ValidatingField(name = "roleVo.roleName", max = 255),
			@ValidatingField(name = "roleVo.roleDesc", max = 300)})
	public @ResponseBody
	CMSVO saveMinisiteInfo(RoleVO roleVo) {
		LogUtils.log("RoleController.saveRoleInfo start");
		roleVo.setRoleID(CommonUtils.uuid());
		this.roleFacade.saveRoleInfo(roleVo);
		if (LOG.isInfoEnabled()) {
			LOG.info("saveRoleInfo:" + roleVo);
		}
		LogUtils.log("RoleController.saveRoleInfo end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	/*
	 * 一键设置所有功能给角色
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "oneKeyRole2Action", method = RequestMethod.POST)
	@NotNull({"roleID"})
	@Validation({
			@ValidatingField(name = "roleVo.roleID")})
	public @ResponseBody
	CMSVO oneKeyRole2Action(RoleVO roleVo) {
		LogUtils.log("RoleController.oneKeyAccount2Role start");
		Map<String, Object> map = this.actionFacade.initActionInfo();
		List<ActionVO> list = (List<ActionVO>) map.get("result");
		for(ActionVO ac : list){
			roleVo.setActionID(ac.getActionID());
			RoleVO v = this.roleFacade.checkRoleByActionID(roleVo);
			if(null == v){
				this.roleFacade.linkRole2Action(roleVo);
			}
		}
		if (LOG.isInfoEnabled()) {
			LOG.info("oneKeyAccount2Role:" + roleVo);
		}
		LogUtils.log("RoleController.oneKeyAccount2Role end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "linkAccount2Role", method = RequestMethod.POST)
	@NotNull({"roleID"})
	@Validation({
			@ValidatingField(name = "roleVo.roleID"),
			@ValidatingField(name = "roleVo.usernmae")})
	public @ResponseBody
	CMSVO linkAccount2Role(RoleVO roleVo) {
		LogUtils.log("RoleController.linkAccount2Role start");
		String roleIDStr = roleVo.getRoleID();
		String[] roleIDs = roleIDStr.split(",");
		for(String roleID : roleIDs){
			roleVo.setRoleID(roleID);
			RoleVO v = this.roleFacade.checkRoleByUsername(roleVo);
			if(null == v){
				this.roleFacade.linkAccount2Role(roleVo);
			}
		}
		if (LOG.isInfoEnabled()) {
			LOG.info("linkAccount2Role:" + roleVo);
		}
		LogUtils.log("RoleController.linkAccount2Role end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "linkRole2Action", method = RequestMethod.POST)
	@NotNull({"roleID"})
	@Validation({
			@ValidatingField(name = "roleVo.roleID"),
			@ValidatingField(name = "roleVo.actionID")})
	public @ResponseBody
	CMSVO linkRole2Action(RoleVO roleVo) {
		LogUtils.log("RoleController.linkRole2Action start");
		String actionStr = roleVo.getActionID();
		String[] actionIDs = actionStr.split(",");
		for(String actionID : actionIDs){
			roleVo.setActionID(actionID);
			RoleVO v = this.roleFacade.checkRoleByActionID(roleVo);
			if(null == v){
				this.roleFacade.linkRole2Action(roleVo);
			}
		}
		if (LOG.isInfoEnabled()) {
			LOG.info("linkRole2Action:" + roleVo);
		}
		LogUtils.log("RoleController.linkRole2Action end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "removeAccount2Role", method = RequestMethod.POST)
	@NotNull({"roleID"})
	@Validation({
			@ValidatingField(name = "roleVo.roleID"),
			@ValidatingField(name = "roleVo.usernmae")})
	public @ResponseBody
	CMSVO removeAccount2Role(RoleVO roleVo) {
		LogUtils.log("RoleController.removeAccount2Role start");
		String roleIDStr = roleVo.getRoleID();
		String[] roleIDs = roleIDStr.split(",");
		for(String roleID : roleIDs){
			roleVo.setRoleID(roleID);
			this.roleFacade.removeAccount2Role(roleVo);
		}
		if (LOG.isInfoEnabled()) {
			LOG.info("removeAccount2Role:" + roleVo);
		}
		LogUtils.log("RoleController.removeAccount2Role end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "removeRole2Action", method = RequestMethod.POST)
	@NotNull({"roleID"})
	@Validation({
			@ValidatingField(name = "roleVo.roleID"),
			@ValidatingField(name = "roleVo.actionID")})
	public @ResponseBody
	CMSVO removeRole2Action(RoleVO roleVo) {
		LogUtils.log("RoleController.removeRole2Action start");
		String actionIDStr = roleVo.getActionID();
		String[] actionIDs = actionIDStr.split(",");
		for(String actionID : actionIDs){
			roleVo.setActionID(actionID);
			this.roleFacade.removeRoleWAction(roleVo);
		}
		if (LOG.isInfoEnabled()) {
			LOG.info("removeRole2Action:" + roleVo);
		}
		LogUtils.log("RoleController.removeRole2Action end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
}
