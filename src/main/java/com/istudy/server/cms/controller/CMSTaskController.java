package com.istudy.server.cms.controller;

import static com.istudy.server.common.constants.ResultInfoConstants.CODE_SUCCESS;
import static com.istudy.server.common.constants.ResultInfoConstants.DESC_SUCCESS;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.istudy.server.cms.facade.CMSTaskFacade;
import com.istudy.server.cms.service.GradeService;
import com.istudy.server.cms.vo.CMSTaskVO;
import com.istudy.server.cms.vo.LoginVO;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.vo.ResultVO;

@Controller
@RequestMapping("/cmsTask")
public class CMSTaskController extends CMSController{

	private static final Log LOG = LogFactory.getLog(CMSTaskController.class);

	@Autowired
	private CMSTaskFacade cmsTaskFacade;
	
	@Autowired
	private GradeService gradeService;

	@RequestMapping(value = "/showPushTaskMainPage", method = RequestMethod.GET)
	public String showPushTaskMainPage(
			@RequestParam("minisiteId") String minisiteId, Model model) {
		model.addAllAttributes(this.cmsTaskFacade
				.initPushTaskPageData(minisiteId));
		return "/cms/push_task_info_main";
	}
	
	@RequestMapping(value = "/showPushTaskPage", method = RequestMethod.GET)
	public ModelAndView showPushTaskPage(
			@RequestParam("minisiteId") String minisiteId) {
		LogUtils.log("CMSTaskController.showPushTaskPage start");
		Map<String, ?> param = this.cmsTaskFacade
				.initPushTaskPageData(minisiteId);
		if (LOG.isInfoEnabled()) {
			LOG.info("CMSTaskController.showPushTaskPage param:" + param);
		}
		LogUtils.log("CMSTaskController.showPushTaskPage end");
		return new ModelAndView("/cms/push_task_info", param);
	}
	
	
	@RequestMapping(value = "/showModiTaskPage", method = RequestMethod.GET)
	public ModelAndView showModiTaskPage(String taskId){
		LogUtils.log("CMSTaskController.showModiTaskPage start,"+taskId);
		Map<String, ?> param = this.cmsTaskFacade.initModiTaskPageData(taskId);
		LogUtils.log("CMSTaskController.showModiTaskPage end ,"+param);
		return new ModelAndView("/cms/modi_task_info", param);
	}
	
	@RequestMapping(value = "/saveTaskInfo", method = RequestMethod.POST)
	public @ResponseBody
	ResultVO saveTaskInfo(CMSTaskVO task, HttpServletRequest req) {
		LogUtils.log("CMSTaskController.saveTaskInfo start");
		setTaskCreator(task, req);
		this.cmsTaskFacade.saveTaskInfo(task,req);
		//task.setSourceType("1");
		//this.cmsTaskFacade.saveTaskInfoForXiaoyuan(task);
		LogUtils.log("CMSTaskController.saveTaskInfo end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}

	@RequestMapping(value = "/modiTaskInfo", method = RequestMethod.POST)
	public @ResponseBody
	ResultVO modiTaskInfo(CMSTaskVO task) {
		LogUtils.log("CMSTaskController.modiTaskInfo start" + task);
		this.cmsTaskFacade.modiTaskInfo(task);
		LogUtils.log("CMSTaskController.modiTaskInfo end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "/deleteCMSTask", method = RequestMethod.POST)
	public @ResponseBody
	ResultVO deleteCMSTask(CMSTaskVO task, HttpServletRequest req) {
		LogUtils.log("CMSTaskController.deleteCMSTask start");
		this.cmsTaskFacade.delTaskInfo(task.getId(),req);
		LogUtils.log("CMSTaskController.deleteCMSTask end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "/showDeleteTaskList", method = RequestMethod.GET)
	public ModelAndView showDeleteTaskList(String id) {
		LogUtils.log("CMSTaskController.showDeleteTaskList start");
		Map<String, ?> param = this.cmsTaskFacade.showDeleteTaskList(id);
		LogUtils.log("CMSTaskController.showDeleteTaskList end" + param);
		return new ModelAndView("/cms/delete_task_info",param);
	}
	
	
	@RequestMapping(value = "/deleteCMSTaskByMsgId", method = RequestMethod.POST)
	public @ResponseBody
	ResultVO deleteCMSTaskByMsgId(CMSTaskVO dtv, HttpServletRequest req) {
		LogUtils.log("CMSTaskController.deleteCMSTaskByMsgId start"+ dtv);
		this.cmsTaskFacade.deleteCMSTaskByMsgId(dtv,req);
		LogUtils.log("CMSTaskController.deleteCMSTaskByMsgId end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "/setTop", method = RequestMethod.POST)
	public @ResponseBody
	ResultVO setTop(String id, HttpServletRequest req) {
		LogUtils.log("CMSTaskController.setTop start"+ id);
		this.cmsTaskFacade.setTop(id,req);
		LogUtils.log("CMSTaskController.setTop end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "/removeTop", method = RequestMethod.POST)
	public @ResponseBody
	ResultVO removeTop(String id, HttpServletRequest req) {
		LogUtils.log("CMSTaskController.setTop start"+ id);
		this.cmsTaskFacade.removeTop(id,req);
		LogUtils.log("CMSTaskController.setTop end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	
	
	
	/*****************推送校讯通APP公共账号相关************************/
	@RequestMapping(value = "/showPushTaskPageForXXT", method = RequestMethod.GET)
	public ModelAndView showPushTaskPageForXXT(
			@RequestParam("minisiteId") String minisiteId) {
		LogUtils.log("CMSTaskController.showPushTaskPageForXXT start");
		Map<String, ?> param = this.cmsTaskFacade
				.initPushTaskPageData(minisiteId);
		if (LOG.isInfoEnabled()) {
			LOG.info("CMSTaskController.showPushTaskPageForXXT param:" + param);
		}
		LogUtils.log("CMSTaskController.showPushTaskPageForXXT end");
		return new ModelAndView("/cms/push_task_info_for_xxt", param);
	}
	
	@RequestMapping(value = "/saveTaskInfoForXXT", method = RequestMethod.POST)
	public @ResponseBody
	ResultVO saveTaskInfoForXXT(CMSTaskVO task, HttpServletRequest req) {
		LogUtils.log("CMSTaskController.saveTaskInfoForXXT start");
		setTaskCreator(task, req);
		this.cmsTaskFacade.saveTaskInfoForXXT(task);
		LogUtils.log("CMSTaskController.saveTaskInfoForXXT end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "/showModiTaskPageForXXT", method = RequestMethod.GET)
	public ModelAndView showModiTaskPageForXXT(String taskId){
		LogUtils.log("CMSTaskController.showModiTaskPageForXXT start,"+taskId);
		Map<String, ?> param = this.cmsTaskFacade.initModiTaskPageDataForXXT(taskId);
		LogUtils.log("CMSTaskController.showModiTaskPageForXXT end ,"+param);
		return new ModelAndView("/cms/modi_task_info_for_xxt", param);
	}
	
	@RequestMapping(value = "/modiTaskInfoForXXT", method = RequestMethod.POST)
	public @ResponseBody
	ResultVO modiTaskInfoForXXT(CMSTaskVO task) {
		LogUtils.log("CMSTaskController.modiTaskInfoForXXT start");
		this.cmsTaskFacade.modiTaskInfoForXXT(task);
		LogUtils.log("CMSTaskController.modiTaskInfoForXXT end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "/deleteCMSTaskForXXT", method = RequestMethod.POST)
	public @ResponseBody
	ResultVO deleteCMSTaskForXXT(CMSTaskVO task) {
		LogUtils.log("CMSTaskController.deleteCMSTaskForXXT start");
		this.cmsTaskFacade.delTaskInfoForXXT(task.getId());
		LogUtils.log("CMSTaskController.deleteCMSTaskForXXT end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	
	
	/*****************推送爱学网APP相关************************/
	@RequestMapping(value = "/showPushTaskPageForIstudy", method = RequestMethod.GET)
	public ModelAndView showPushTaskPageForIstudy(
			@RequestParam("minisiteId") String minisiteId) {
		LogUtils.log("CMSTaskController.showPushTaskPageForIstudy start");
		Map<String, ?> param = this.cmsTaskFacade
				.initPushTaskPageData(minisiteId);
		if (LOG.isInfoEnabled()) {
			LOG.info("CMSTaskController.showPushTaskPageForIstudy param:" + param);
		}
		LogUtils.log("CMSTaskController.showPushTaskPageForIstudy end");
		return new ModelAndView("/cms/push_task_info_for_istudy", param);
	}
	
	@RequestMapping(value = "/saveTaskInfoForIstudy", method = RequestMethod.POST)
	public @ResponseBody
	ResultVO saveTaskInfoForIstudy(CMSTaskVO task, HttpServletRequest req) {
		LogUtils.log("CMSTaskController.saveTaskInfoForIstudy start");
		setTaskCreator(task, req);
		this.cmsTaskFacade.saveTaskInfoForIstudy(task);
		LogUtils.log("CMSTaskController.saveTaskInfoForIstudy end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "/showModiTaskPageForIstudy", method = RequestMethod.GET)
	public ModelAndView showModiTaskPageForIstudy(String taskId){
		LogUtils.log("CMSTaskController.showModiTaskPageForIstudy start,"+taskId);
		Map<String, ?> param = this.cmsTaskFacade.initModiTaskPageDataForIstudy(taskId);
		LogUtils.log("CMSTaskController.showModiTaskPageForIstudy end ,"+param);
		return new ModelAndView("/cms/modi_task_info_for_istudy", param);
	}
	
	@RequestMapping(value = "/modiTaskInfoForIstudy", method = RequestMethod.POST)
	public @ResponseBody
	ResultVO modiTaskInfoForIstudy(CMSTaskVO task) {
		LogUtils.log("CMSTaskController.modiTaskInfoForIstudy start");
		this.cmsTaskFacade.modiTaskInfoForIstudy(task);
		LogUtils.log("CMSTaskController.modiTaskInfoForIstudy end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "/deleteCMSTaskForIstudy", method = RequestMethod.POST)
	public @ResponseBody
	ResultVO deleteCMSTaskForIstudy(CMSTaskVO task) {
		LogUtils.log("CMSTaskController.deleteCMSTaskForIstudy start");
		this.cmsTaskFacade.delTaskInfoForIstudy(task.getId());
		LogUtils.log("CMSTaskController.deleteCMSTaskForIstudy end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}

	private void setTaskCreator(CMSTaskVO task, HttpServletRequest req) {
		HttpSession session = req.getSession();
		LoginVO user = (LoginVO)session.getAttribute("user");
		task.setCreator(user.getUserName());
		task.setCreatorEntId(user.getEnterpriseID());
	}
	
	/*****************推送校园+APP相关************************/
	@RequestMapping(value = "/showPushTaskPageForXiaoyuan", method = RequestMethod.GET)
	public ModelAndView showPushTaskPageForXiaoyuan(
			@RequestParam("minisiteId") String minisiteId) {
		LogUtils.log("CMSTaskController.showPushTaskPageForXiaoyuan start");
		Map<String, ?> param = this.cmsTaskFacade
				.initPushTaskPageData(minisiteId);
		if (LOG.isInfoEnabled()) {
			LOG.info("CMSTaskController.showPushTaskPageForXiaoyuan param:" + param);
		}
		LogUtils.log("CMSTaskController.showPushTaskPageForXiaoyuan end");
		return new ModelAndView("/cms/push_task_info_for_xiaoyuan", param);
	}
	
	@RequestMapping(value = "/saveTaskInfoForXiaoyuan", method = RequestMethod.POST)
	public @ResponseBody
	ResultVO saveTaskInfoForXiaoyuan(CMSTaskVO task, HttpServletRequest req) {
		LogUtils.log("CMSTaskController.saveTaskInfoForXiaoyuan start");
		setTaskCreator(task, req);
		this.cmsTaskFacade.saveTaskInfoForXiaoyuan(task,req);
		LogUtils.log("CMSTaskController.saveTaskInfoForXiaoyuan end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "/showModiTaskPageForXiaoyuan", method = RequestMethod.GET)
	public ModelAndView showModiTaskPageForXiaoyuan(String taskId){
		LogUtils.log("CMSTaskController.showModiTaskPageForIstudy start,"+taskId);
		Map<String, ?> param = this.cmsTaskFacade.initModiTaskPageDataForXiaoyuan(taskId);
		LogUtils.log("CMSTaskController.showModiTaskPageForIstudy end ,"+param);
		return new ModelAndView("/cms/modi_task_info_for_xiaoyuan", param);
	}
	
	@RequestMapping(value = "/modiTaskInfoForXiaoyuan", method = RequestMethod.POST)
	public @ResponseBody
	ResultVO modiTaskInfoForXiaoyuan(CMSTaskVO task) {
		LogUtils.log("CMSTaskController.modiTaskInfoForXiaoyuan start");
		this.cmsTaskFacade.modiTaskInfoForXiaoyuan(task);
		LogUtils.log("CMSTaskController.modiTaskInfoForXiaoyuan end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}
	
	@RequestMapping(value = "/deleteCMSTaskForXiaoyuan", method = RequestMethod.POST)
	public @ResponseBody
	ResultVO deleteCMSTaskForXiaoyuan(CMSTaskVO task) {
		LogUtils.log("CMSTaskController.deleteCMSTaskForXiaoyuan start");
		this.cmsTaskFacade.delTaskInfoForXiaoyuan(task.getId());
		LogUtils.log("CMSTaskController.deleteCMSTaskForXiaoyuan end");
		return new ResultVO(CODE_SUCCESS, DESC_SUCCESS);
	}


}
