package com.istudy.server.system.controller;

import static com.istudy.server.common.constants.ResultInfoConstants.CODE_SUCCESS;
import static com.istudy.server.common.constants.ResultInfoConstants.DESC_SUCCESS;

import java.util.HashMap;
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
import com.istudy.server.system.facade.EnterpriseFacade;
import com.istudy.server.system.vo.EnterpriseVO;

@Controller
@RequestMapping("/enterprise/")
public class EnterpriseController extends CMSController{

	private static final Log LOG = LogFactory.getLog(EnterpriseController.class);
	
	@Autowired
	private EnterpriseFacade enterpriseFacade;
	
	@RequestMapping(value="getAllEnterprise")
	public ModelAndView getAllEnterprise(){
		Map<String, Object> map = this.enterpriseFacade.initEnterpriseInfo();
		return new ModelAndView("cms/enterprise_list",map);
	}
	
	@RequestMapping(value="getEnterpriseById",method=RequestMethod.GET)
	@NotNull({"enterpriseID"})
	public ModelAndView getEnterpriseById(@RequestParam("enterpriseID") String enterpriseID){
		Map<String, Object> result = this.enterpriseFacade.initEnterpriseInfoByID(enterpriseID);
		List<String> list = this.enterpriseFacade.getFooterInfo();
		result.put("footerList", list);
		return new ModelAndView("cms/addOrModEnterprise",result);
	}
	
	@RequestMapping(value="getAddEnterprisePage",method=RequestMethod.GET)
	public ModelAndView getAddEnterprisePage(){
		List<String> list = this.enterpriseFacade.getFooterInfo();
		Map<String, Object> footerList = new HashMap<String, Object>();
		footerList.put("footerList", list);
		return new ModelAndView("cms/addOrModEnterprise", footerList);
	}
	
	@RequestMapping(value = "delEnterprise", method = RequestMethod.POST)
	@NotNull({"enterpriseIDs"})
	public @ResponseBody ResultVO delEnterprise(@RequestParam("enterpriseIDs") String enterpriseIDs){
		String[] enterpriseIds = enterpriseIDs.split(",");
		for(String enterpriseID : enterpriseIds){
			LogUtils.log("EnterpriseController.delEnterprise start.enterpriseID:"+enterpriseID);
			this.enterpriseFacade.delEnterpriseInfo(enterpriseID);
			LogUtils.log("EnterpriseController.delEnterprise end.");
		}
		return super.success();
	}
	
	@RequestMapping(value = "modiEnterpriseInfo", method = RequestMethod.POST)
	@Validation({
			@ValidatingField(name = "enterpriseVo.enterpriseName"),
			@ValidatingField(name = "enterpriseVo.enterpriseID"),
			@ValidatingField(name = "enterpriseVo.enterpriseDesc"),
			@ValidatingField(name = "enterpriseVo.enterpriseHeader"),
			@ValidatingField(name = "enterpriseVo.enterpriseFooter"),
			@ValidatingField(name = "enterpriseVo.vendorType")})
	public @ResponseBody
	CMSVO modiMinisiteInfo(EnterpriseVO enterpriseVo) {
		LogUtils.log("EnterpriseController.modiEnterpriseInfo start");
		this.enterpriseFacade.modifyEnterpriseInfo(enterpriseVo);
		if (LOG.isInfoEnabled()) {
			LOG.info("modiEnterpriseInfo:" + enterpriseVo);
		}
		LogUtils.log("EnterpriseController.modiEnterpriseInfo end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "saveEnterpriseInfo", method = RequestMethod.POST)
	@Validation({
			@ValidatingField(name = "enterpriseVo.enterpriseName"),
			@ValidatingField(name = "enterpriseVo.enterpriseDesc"),
			@ValidatingField(name = "enterpriseVo.vendorType")})
	public @ResponseBody
	CMSVO saveMinisiteInfo(EnterpriseVO enterpriseVo) {
		LogUtils.log("EnterpriseController.saveEnterpriseInfo start");
		enterpriseVo.setEnterpriseID(CommonUtils.uuid());
		this.enterpriseFacade.saveEnterpriseInfo(enterpriseVo);
		if (LOG.isInfoEnabled()) {
			LOG.info("saveEnterpriseInfo:" + enterpriseVo);
		}
		LogUtils.log("EnterpriseController.saveEnterpriseInfo end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
}
