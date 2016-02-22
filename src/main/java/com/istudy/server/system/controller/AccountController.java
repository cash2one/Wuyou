package com.istudy.server.system.controller;

import static com.istudy.server.common.constants.ResultInfoConstants.CODE_SUCCESS;
import static com.istudy.server.common.constants.ResultInfoConstants.DESC_SUCCESS;

import java.util.HashMap;
import java.util.Map;


















import javax.servlet.http.HttpServletRequest;

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
import com.istudy.server.common.utils.EncryptionUtils;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.validate.annotation.NotNull;
import com.istudy.server.common.validate.annotation.ValidatingField;
import com.istudy.server.common.validate.annotation.Validation;
import com.istudy.server.common.vo.CMSVO;
import com.istudy.server.common.vo.ResultVO;
import com.istudy.server.system.facade.AccountFacade;
import com.istudy.server.system.vo.AccountVO;

@Controller
@RequestMapping("/accounts/")
public class AccountController extends CMSController{

	private static final Log LOG = LogFactory.getLog(AccountController.class);
	
	@Autowired
	private AccountFacade accountFacade;
	
	@RequestMapping(value="getAllAccount")
	public ModelAndView getAllAccount(){
		Map<String, Object> map = this.accountFacade.initAccountInfo();
		return new ModelAndView("cms/enterprise_list",map);
	}
	
	@RequestMapping(value="getAccountById",method=RequestMethod.GET)
	@NotNull({"username"})
	public ModelAndView getEnterpriseById(@RequestParam("username") String username,@RequestParam("enterpriseID") String enterpriseID,
			@RequestParam("enterprise_Name") String enterprise_Name){
		Map<String, Object> result = this.accountFacade.initAccountInfoByID(username);
		result.put("enterpriseID", enterpriseID);
		try {
			enterprise_Name = new String(enterprise_Name.getBytes("ISO-8859-1"), "UTF-8");
		} catch (Exception e) {
			
		}
		result.put("enterprise_Name", enterprise_Name);
		return new ModelAndView("cms/addOrModAccount",result);
	}
	
	@RequestMapping(value="getAddAccountPage",method=RequestMethod.GET)
	public ModelAndView getAddAccountPage(@RequestParam("enterpriseID") String enterpriseID,
			@RequestParam("enterprise_Name") String enterprise_Name){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("enterpriseID", enterpriseID);
		try {
			enterprise_Name = new String(enterprise_Name.getBytes("ISO-8859-1"), "UTF-8");
		} catch (Exception e) {
			
		}
		result.put("enterprise_Name", enterprise_Name);
		return new ModelAndView("cms/addOrModAccount", result);
	}
	
	@RequestMapping(value = "delAccount", method = RequestMethod.POST)
	@NotNull({"usernameStr"})
	public @ResponseBody ResultVO delEnterprise(@RequestParam("usernameStr") String usernameStr){
		String[] enterpriseIds = usernameStr.split(",");
		for(String username : enterpriseIds){
			LogUtils.log("AccountController.delAccount start.username:"+username);
			this.accountFacade.delAccount2Role(username);
			this.accountFacade.delAccountInfo(username);
			LogUtils.log("AccountController.delAccount end.");
		}
		return super.success();
	}
	
	@RequestMapping(value = "modiAccount", method = RequestMethod.POST)
	@Validation({
			@ValidatingField(name = "accountVo.username", max = 50),
			@ValidatingField(name = "accountVo.password", max = 50),
			@ValidatingField(name = "accountVo.account_desc", max = 500),
			@ValidatingField(name = "accountVo.enterpriseID", max = 32)})
	public @ResponseBody
	CMSVO modiAccountInfo(AccountVO accountVo) {
		LogUtils.log("AccountController.modiAccountInfo start");
		String password = accountVo.getPassword();
		accountVo.setPassword(EncryptionUtils.md5(password));
		this.accountFacade.modifyAccountInfo(accountVo);
		if (LOG.isInfoEnabled()) {
			LOG.info("modiAccountInfo:" + accountVo);
		}
		LogUtils.log("AccountController.modiAccountInfo end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "modPassword", method = RequestMethod.POST)
	public @ResponseBody
	CMSVO savePassword(@RequestParam("oldPassword") String oldPassword, @RequestParam("confirmPassword") String 
			confirmPassword, HttpServletRequest req) {
		LogUtils.log("AccountController.saveAccountInfo start");
		confirmPassword = EncryptionUtils.md5(confirmPassword);
		oldPassword = EncryptionUtils.md5(oldPassword);
		String username = (String)req.getSession().getAttribute("username");
		Map<String, Object> map = this.accountFacade.initAccountInfoByID(username);
		AccountVO old = (AccountVO)map.get("result");
		if(!old.getPassword().equals(oldPassword)){
			return new ResultVO("10002", "旧密码错误");
		}
		AccountVO acv = new AccountVO();
		acv.setUsername(username);
		acv.setPassword(confirmPassword);
		this.accountFacade.modPassword(acv);
		if (LOG.isInfoEnabled()) {
			LOG.info("saveAccountInfo:" + oldPassword);
		}
		LogUtils.log("AccountController.saveAccountInfo end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value="getModPasswordPage",method=RequestMethod.GET)
	public ModelAndView getModPasswordPage(){
		return new ModelAndView("cms/modPassword");
	}
	
	@RequestMapping(value = "saveAccountInfo", method = RequestMethod.POST)
	@Validation({
			@ValidatingField(name = "accountVo.username", max = 50),
			@ValidatingField(name = "accountVo.password", max = 50),
			@ValidatingField(name = "accountVo.account_desc", max = 50),
			@ValidatingField(name = "accountVo.enterpriseID", max = 50)})
	public @ResponseBody
	CMSVO saveAccountInfo(AccountVO accountVo) {
		LogUtils.log("AccountController.saveAccountInfo start");
		String password = accountVo.getPassword();
		password = EncryptionUtils.md5(password);
		accountVo.setPassword(password);
		int result = this.accountFacade.saveAccountInfo(accountVo);
		if (LOG.isInfoEnabled()) {
			LOG.info("saveAccountInfo:" + accountVo);
		}
		LogUtils.log("AccountController.saveAccountInfo end");
		if(1==result){	
			return new ResultVO(CODE_SUCCESS, "已存在该账户名");
		}
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
}
