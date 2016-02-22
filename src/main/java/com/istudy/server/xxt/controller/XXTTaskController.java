package com.istudy.server.xxt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.validate.annotation.NotNull;
import com.istudy.server.common.validate.annotation.ValidatingField;
import com.istudy.server.common.validate.annotation.Validation;
import com.istudy.server.common.vo.ResultVO;
import com.istudy.server.common.web.CommonController;
import com.istudy.server.xxt.facade.XXTTaskFacade;
import com.istudy.server.xxt.vo.HisTaskVO;
import com.istudy.server.xxt.vo.KeyVO;
import com.istudy.server.xxt.vo.XXTGetTasksParamVO;

@Controller
@RequestMapping("/xxtTask")
public class XXTTaskController extends CommonController{

	private static final Log LOG = LogFactory.getLog(XXTTaskController.class);

	@Autowired
	private XXTTaskFacade xxtTaskFacade;

	@RequestMapping(value = "/showTaskListPage", method = RequestMethod.GET)
	@NotNull({ "param.userId", "param.teacherRole", "param.cityId",
			"param.gradeId", "param.schoolId" })
	@Validation({ @ValidatingField(format = "5", name = "param.teacherRole") })
	public ModelAndView showTaskTitleListPage(final XXTGetTasksParamVO param) {
		LOG.info("XXTTaskController.showTaskTitleListPage start param: " + param);
		final List<HisTaskVO> tasks = this.xxtTaskFacade.getTaskTitleList(param);
		Map<String, Object> rs = new HashMap<String, Object>();
		rs.put("tasks", tasks);
		CommonUtils.beanAppendMap(param, rs);
		LOG.info("XXTTaskController.showTaskTitleListPage end result: " + rs);
		return new ModelAndView("xxt/xxt_task_list", rs);
	}
	
	/*@RequestMapping(value="/getRecPaging",method=RequestMethod.GET)
	@NotNull({ "param.userId", "param.teacherRole", "param.cityId", "param.gradeId"})
	@Validation({ @ValidatingField(format = "5", name = "param.teacherRole") })
	public ModelAndView showRecPaging(final XXTGetTasksParamVO param ){
		LogUtils.log("XXTTaskController.showRecPaging start "+param);
		String target = param.getTarget();
		PagingVO paging = new PagingVO(target);
		CommonUtils.beanAppendMap(param, paging.getParam());
		@SuppressWarnings("unchecked")
		Map<String, Object> rs =  this.getBaseFacade().initPaging(paging);
		rs.putAll(paging.getParam());
		LogUtils.log("XXTTaskController.showRecPaging end "+paging);
		return new ModelAndView(getRootPath()+target,rs);
	}*/
	
	@RequestMapping(value = "/showTaskPage", method = RequestMethod.GET)
	//@NotNull({"taskId","UserId","CityId"})
	public ModelAndView showTaskPage(@RequestParam(value="taskId") String taskId,
			@RequestParam(value="userId",required=false) String userId,
			@RequestParam(value="cityId",required=false) String cityId,
			@RequestParam(value="schoolId",required=false) String schoolId,
			@RequestParam(value="Token",required=false) String token){
		LogUtils.log("XXTTaskController.showTaskInfo start");		
		Map<String,?> result = this.xxtTaskFacade.iniSendTaskInfo(userId, taskId,cityId,token,schoolId);
		LogUtils.log("XXTTaskController.showTaskInfo end"+result);
		return new ModelAndView("xxt/xxt_task_info",result);
	}
	
	@RequestMapping(value = "/showHisTaskPage", method = RequestMethod.GET)
	@NotNull({"id"})
	public ModelAndView showHisTaskPage(@RequestParam("id") String id){
		LogUtils.log("XXTTaskController.showTaskInfo start,"+id);
		final HisTaskVO task = this.xxtTaskFacade.getHisTaskVOById(id);
		LogUtils.log("XXTTaskController.showTaskInfo end");
		return new ModelAndView(this.getRootPath()+"xxt_task_his_info",new HashMap<String,Object>(){{
			this.put("task", task);
		}});
	}
	
	@RequestMapping(value = "/saveTeacherSendMsg", method = RequestMethod.POST)
	@NotNull({"task.type","task.msgDetails",
		"task.sendUsers","task.sendType","task.userId","task.taskId"})
	@Validation({@ValidatingField(name = "task.msgDetails",charMax=200)})
	public @ResponseBody ResultVO saveTeacherSendMsgInfo(HisTaskVO task){
		LogUtils.log("XXTTaskController.saveTeacherSendMsgInfo start,"+task);
		this.xxtTaskFacade.saveTeacherSendMsgInfo(task);
		LogUtils.log("XXTTaskController.saveTeacherSendMsgInfo end,"+task);
		return success();
	}
	
	@RequestMapping(value="getUserKey", method = RequestMethod.POST)
	public @ResponseBody List<KeyVO> getUserKey(KeyVO key){
		LogUtils.log("XXTTaskController.getUserKey start,"+key);
		this.xxtTaskFacade.updateKeyUser(key);
		List<KeyVO> kl = new ArrayList<KeyVO>(); 
		kl = this.xxtTaskFacade.getKeyByCityUserId(key);
		LogUtils.log("XXTTaskController.getUserKey start,"+kl);
		return kl;
		
	}
	
	@RequestMapping(value="task4pc", method = RequestMethod.GET)
	public String task4pc(@RequestParam("Token") String token, Model model){
		xxtTaskFacade.initTask4pcList(token, model);
		return "xxt/xxt_task_for_pc";
	}
	
	@RequestMapping(value="task4pcMore", method = RequestMethod.GET)
	public String task4pc(@RequestParam Map<String,Object> param, Model model){
		model.addAllAttributes(param);
		return "xxt/xxt_task_for_pc_more";
	}
	
	@Override
	public String getRootPath() {
		return "xxt/";
	}
	
}
