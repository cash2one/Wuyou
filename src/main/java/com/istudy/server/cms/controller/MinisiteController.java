package com.istudy.server.cms.controller;

import static com.istudy.server.common.constants.ResultInfoConstants.CODE_SUCCESS;
import static com.istudy.server.common.constants.ResultInfoConstants.DESC_SUCCESS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.istudy.server.cms.facade.MinisiteFacade;
import com.istudy.server.cms.vo.LoginVO;
import com.istudy.server.cms.vo.MinisiteVO;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.validate.annotation.NotNull;
import com.istudy.server.common.validate.annotation.ValidatingField;
import com.istudy.server.common.validate.annotation.Validation;
import com.istudy.server.common.vo.CMSVO;
import com.istudy.server.common.vo.PagingVO;
import com.istudy.server.common.vo.ResultVO;
import com.istudy.server.common.web.CommonController;

@Controller
@RequestMapping("/minisite/")
public class MinisiteController extends CMSController{

	private static final Log LOG = LogFactory.getLog(MinisiteController.class);

	@Autowired
	private MinisiteFacade minisiteFacade;

	@RequestMapping(value = "addResoucePage", method = RequestMethod.GET)
	public ModelAndView showAddMinisiteInfoPage() {
		return new ModelAndView("cms/add_minisite_and_msg_info",
				this.minisiteFacade.iniMinisiteInfo(null));
	}

	@RequestMapping(value = "saveMinisiteInfo", method = RequestMethod.POST)
	@Validation({
			@ValidatingField(name = "minisiteVO.taskName", max = 255, notNull = true),
			@ValidatingField(name = "minisiteVO.msgDetails", max = 300),
			@ValidatingField(name = "minisiteVO.remark", max = 255),
			@ValidatingField(name = "minisiteVO.title", max = 255),
			@ValidatingField(name = "minisiteVO.videoUrl") })
	public @ResponseBody
	CMSVO saveMinisiteInfo(MinisiteVO minisiteVO, HttpServletRequest req) {
		LogUtils.log("MinisiteController.saveMinisiteInfo start"+minisiteVO.getSubjectType()+minisiteVO.getShortDetails());
		setCreator(minisiteVO, req);
		HttpSession session = req.getSession(); 
		String path = session.getServletContext().getRealPath("/");
		String enterpriseFooter = (String) session.getAttribute("enterpriseFooter");
		minisiteVO.setFooterType(enterpriseFooter);
		this.minisiteFacade.saveMinisiteInfo(minisiteVO, path,req);
		if (LOG.isInfoEnabled()) {
			LOG.info("saveMinisiteInfo:" + minisiteVO);
		}
		LogUtils.log("MinisiteController.saveMinisiteInfo end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}

	private void setCreator(MinisiteVO minisiteVO, HttpServletRequest req) {
		HttpSession session = req.getSession();
		LoginVO user = (LoginVO)session.getAttribute("user");
		minisiteVO.setCreator(user.getUserName());
		minisiteVO.setCreatorEntId(user.getEnterpriseID());
	}

	@RequestMapping(value = "showModiMinisitePage", method = RequestMethod.GET)
	public ModelAndView showModiMinisitePage(String minisiteId) {
		LogUtils.log("MinisiteController.showModiMinisitePage start "+minisiteId);
		final Map<String, ?> mini = this.minisiteFacade
				.iniMinisiteInfo(minisiteId);
		LogUtils.log("MinisiteController.showModiMinisitePage end "+mini);
		return new ModelAndView("cms/modi_minisite_and_msg_info", mini);
	}
	
	@RequestMapping(value = "modiMinisiteInfo", method = RequestMethod.POST)
	@Validation({
			@ValidatingField(name = "minisiteVO.taskName", max = 255, notNull = true),
			@ValidatingField(name = "minisiteVO.msgDetails", max = 300),
			@ValidatingField(name = "minisiteVO.remark", max = 255),
			@ValidatingField(name = "minisiteVO.title", max = 255),
			@ValidatingField(name = "minisiteVO.videoUrl") })
	public @ResponseBody
	CMSVO modiMinisiteInfo(MinisiteVO minisiteVO, HttpServletRequest req) {
		LogUtils.log("MinisiteController.saveMinisiteInfo start");
		HttpSession session = req.getSession();
		String updator = (String)session.getAttribute("username");
		minisiteVO.setUpdator(updator);
		String path = session.getServletContext().getRealPath("/");
		String enterpriseFooter = (String) session.getAttribute("enterpriseFooter");
		minisiteVO.setFooterType(enterpriseFooter);
		this.minisiteFacade.modiMinisiteInfo(minisiteVO, path,req);
		if (LOG.isInfoEnabled()) {
			LOG.info("saveMinisiteInfo:" + minisiteVO);
		}
		LogUtils.log("MinisiteController.saveMinisiteInfo end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}

	@RequestMapping(value = "delMinisite", method = RequestMethod.POST)
	@NotNull({"minisiteId"})
	public @ResponseBody ResultVO delMinisite(@RequestParam("minisiteId") String minisiteId, HttpServletRequest req){
		LogUtils.log("MinisiteController.delMinisite start.minisiteId:"+minisiteId);
		String path = req.getSession().getServletContext().getRealPath("/");
		this.minisiteFacade.delMinisite(minisiteId, path,req);
		LogUtils.log("MinisiteController.delMinisite end.");
		return super.success();
	}
	
	@RequestMapping(value = "saveFaqs", method = RequestMethod.POST)
	public @ResponseBody ResultVO saveFaqs(MinisiteVO minisiteVO, HttpServletRequest req){
		LogUtils.log("MinisiteController.saveFaqs start.");
		this.minisiteFacade.saveFaqs(minisiteVO,req);
		LogUtils.log("MinisiteController.saveFaqs end.");
		return super.success();
	}
	
	//showFaqPage
	@RequestMapping(value = "showFaqPage", method = RequestMethod.GET)
	public ModelAndView showFaqPage(String minisiteId) {
		LogUtils.log("MinisiteController.showModiMinisitePage start "+minisiteId);
		final Map<String, ?> mini = this.minisiteFacade
				.iniMinisiteInfo(minisiteId);
		LogUtils.log("MinisiteController.showModiMinisitePage end "+mini);
		return new ModelAndView("cms/save_faq_info", mini);
	}
	
}
