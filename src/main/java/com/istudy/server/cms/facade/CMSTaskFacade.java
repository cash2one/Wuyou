package com.istudy.server.cms.facade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.istudy.server.cms.service.CMSLogService;
import com.istudy.server.cms.service.CMSTaskService;
import com.istudy.server.cms.service.CityService;
import com.istudy.server.cms.service.GradeService;
import com.istudy.server.cms.service.MinisiteService;
import com.istudy.server.cms.service.SchoolService;
import com.istudy.server.cms.vo.CMSTaskVO;
import com.istudy.server.cms.vo.CityVO;
import com.istudy.server.cms.vo.DeleteTaskVO;
import com.istudy.server.cms.vo.GradeVO;
import com.istudy.server.cms.vo.LogVO;
import com.istudy.server.cms.vo.MinisiteVO;
import com.istudy.server.cms.vo.SchoolVO;
import com.istudy.server.common.constants.IstudyConstants;
import com.istudy.server.common.constants.XXTConstants;
import com.istudy.server.xxt.service.XXTWSService;

@Service("cmsTaskFacade")
@SuppressWarnings("serial")
public class CMSTaskFacade {
	@Autowired
	private CMSTaskService cmsTaskService;

	@Autowired
	private MinisiteService minisiteService;

	@Autowired
	private GradeService gradeService;

	@Autowired
	private CityService cityService;
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private XXTWSService xxtwsService;
	
	@Autowired
	private CMSLogService cmsLogService;
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, ?> initPushTaskPageData(String minisiteId) {
		final MinisiteVO mini = this.minisiteService
				.getBasicMinisiteInfoById(minisiteId);
		final List<GradeVO> grades = this.gradeService.getAllGradeInfo();
		final List<CityVO> citys = this.cityService.getAllCitys();
		final List<SchoolVO> schools = this.schoolService.getAllSchools();
		return new HashMap<String, Object>() {
			{
				put("minisite", mini);
				put("grades", grades);
				put("citys", citys);
				put("schools",schools);
				put("xxtImgRelativePath", XXTConstants.XXT_APP_PUBLIC_ACCOUNT_THUMB_IMG_PATH);
				put("istudyImgRelativePath", IstudyConstants.ISTUDY_APP_THUMB_IMG_PATH);
			}
		};
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, ?> initModiTaskPageData(String taskId) {
		final List<GradeVO> grades = this.gradeService.getAllGradeInfo();
		final List<CityVO> citys = this.cityService.getAllCitys();
		final List<SchoolVO> schools = this.schoolService.getAllSchools();
		final CMSTaskVO task = this.cmsTaskService.getCMSTaskInfoById(taskId);
		return new HashMap<String, Object>() {
			{
				put("grades", grades);
				put("citys", citys);
				put("task", task);
				put("schools",schools);
			}
		};
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void saveTaskInfo(CMSTaskVO task, HttpServletRequest req){
		//String userName = (String) req.getSession().getAttribute("username");
		String subjectType="";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LogVO log = this.cmsLogService.getRoleNameByUserName(task.getCreator());
		log.setActiveDate(df.format(new Date()));
		log.setIp(getClientIp(req));
		log.setRoleName(log.getAccountDesc());

			this.cmsTaskService.saveTaskInfo(task);
			if(task.getSubjectType().equals("1")){
				subjectType="家长会";
			}else{
				subjectType="分享";
			}
			log.setLogInfo("<p style='display: none;'>IP地址：[" + log.getIp() + "] 用户" + log.getUserName() + " [" + log.getEnterpriseName() + "] 在" + log.getActiveDate() + "</p>添加一条" + subjectType + "校讯通PC推送任务成功,任务标题：【 " + task.getTaskName()+"】 ");		
			this.cmsLogService.saveLogByActive(log);
		
		
	}
			

		
	
	
	@Transactional(rollbackFor=Exception.class) 
	public void modiTaskInfo(CMSTaskVO task){
		this.cmsTaskService.modiTaskInfo(task);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void delTaskInfo(String id, HttpServletRequest req){
		String userName = (String) req.getSession().getAttribute("username");
		CMSTaskVO cmsTaskVO = this.cmsTaskService.getCMSTaskInfoById(id);
		this.cmsTaskService.delCMSTaskByID(id);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LogVO log = this.cmsLogService.getRoleNameByUserName(userName);
		log.setActiveDate(df.format(new Date()));
		log.setIp(getClientIp(req));
		log.setRoleName(log.getAccountDesc());
		log.setLogInfo("<p style='display: none;'>IP地址：[" + log.getIp() + "] 用户" + log.getEnterpriseName() + " [" + log.getRoleName() + "] 在" + log.getActiveDate() + "</p>删除任务标题：【 " + cmsTaskVO.getTaskName()+"】成功 ");		
		this.cmsLogService.saveLogByActive(log);
	}

	
	/*****************推送校讯通APP公共账号相关************************/
	@Transactional(rollbackFor=Exception.class)
	public void saveTaskInfoForXXT(CMSTaskVO task) {
		this.cmsTaskService.saveTaskInfoForXXT(task);
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void modiTaskInfoForXXT(CMSTaskVO task){
		this.cmsTaskService.modiTaskInfoForXXT(task);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void delTaskInfoForXXT(String id){
		this.cmsTaskService.delCMSTaskForXXTByID(id);
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, ?> initModiTaskPageDataForXXT(String taskId) {
		final List<GradeVO> grades = this.gradeService.getAllGradeInfo();
		final List<CityVO> citys = this.cityService.getAllCitys();
		final CMSTaskVO task = this.cmsTaskService.getCMSTaskInfoForXXTById(taskId);
		return new HashMap<String, Object>() {
			{
				put("grades", grades);
				put("citys", citys);
				put("task", task);
			}
		};
	}
	
	
	/*****************推送爱学网APP相关************************/
	@Transactional(rollbackFor=Exception.class)
	public void saveTaskInfoForIstudy(CMSTaskVO task) {
		this.cmsTaskService.saveTaskInfoForIstudy(task);
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void modiTaskInfoForIstudy(CMSTaskVO task){
		this.cmsTaskService.modiTaskInfoForIstudy(task);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void delTaskInfoForIstudy(String id){
		this.cmsTaskService.delCMSTaskForIstudyByID(id);
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, ?> initModiTaskPageDataForIstudy(String taskId) {
		final List<GradeVO> grades = this.gradeService.getAllGradeInfo();
		final List<CityVO> citys = this.cityService.getAllCitys();
		final CMSTaskVO task = this.cmsTaskService.getCMSTaskInfoForIstudyById(taskId);
		return new HashMap<String, Object>() {
			{
				put("grades", grades);
				put("citys", citys);
				put("task", task);
			}
		};
	}
	
	
	/*****************推送校园+APP相关
	 * @param req ************************/
	@Transactional(rollbackFor=Exception.class)
	public void saveTaskInfoForXiaoyuan(CMSTaskVO task, HttpServletRequest req) {
			this.cmsTaskService.saveTaskInfoForXiaoyuan(task);
			String subjectType="";
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			LogVO log = this.cmsLogService.getRoleNameByUserName(task.getCreator());
			log.setActiveDate(df.format(new Date()));
			log.setIp(getClientIp(req));
			log.setRoleName(log.getAccountDesc());
			if(task.getSubjectType().equals("1")){
				subjectType="家长会";
			}else{
				subjectType="分享";
			}
			log.setLogInfo("<p style='display: none;'>IP地址：[" + log.getIp() + "] 用户" + log.getUserName() + " [" + log.getEnterpriseName() + "] 在" + log.getActiveDate() + "</p>添加一条" + subjectType + "校园+APP推送任务成功,任务标题：【 " + task.getTaskName()+"】 ");		
			this.cmsLogService.saveLogByActive(log);
	}
	
	@Transactional(rollbackFor=Exception.class) 
	public void modiTaskInfoForXiaoyuan(CMSTaskVO task){
		this.cmsTaskService.modiTaskInfoForXiaoyuan(task);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void delTaskInfoForXiaoyuan(String id){
		this.cmsTaskService.delCMSTaskForXiaoyuanByID(id);
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, ?> initModiTaskPageDataForXiaoyuan(String taskId) {
		final List<GradeVO> grades = this.gradeService.getAllGradeInfo();
		final List<CityVO> citys = this.cityService.getAllCitys();
		final CMSTaskVO task = this.cmsTaskService.getCMSTaskInfoForXiaoyuanById(taskId);
		return new HashMap<String, Object>() {
			{
				put("grades", grades);
				put("citys", citys);
				put("task", task);
			}
		};
	}

	public Map<String, ?> showDeleteTaskList(String id) {
		// TODO Auto-generated method stub
		final CMSTaskVO task = this.cmsTaskService.getCMSTaskInfoById(id);
		
		final List<DeleteTaskVO> dtv1 = this.cmsTaskService.getDeleteTaskList(task);
		final List<GradeVO> grades = this.gradeService.getAllGradeInfo();
		final List<CityVO> citys = this.cityService.getAllCitys();
		final List<SchoolVO> schools = this.schoolService.getAllSchools();
		return new HashMap<String, Object>() {
			{
				put("task", task);
				put("msg", dtv1);
				put("grades", grades);
				put("citys", citys);
				put("schools",schools);
			}
		};
		
	}

	public void deleteCMSTaskByMsgId(CMSTaskVO dtv, HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.xxtwsService.deleteCMSTaskByMsgId(dtv);
		/*String[] ids = dtv.getMsgId().split(",");
		for(int i=0;i<ids.length;i++){
			this.xxtwsService.deleteCMSTaskByMsgId(ids[i]);
		}*/
		String userName = (String) req.getSession().getAttribute("username");
		CMSTaskVO cmsTaskVO = this.cmsTaskService.getCMSTaskInfoById(dtv.getId());
		String subjectType="";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LogVO log = this.cmsLogService.getRoleNameByUserName(userName);
		log.setActiveDate(df.format(new Date()));
		log.setIp(getClientIp(req));
		log.setRoleName(log.getAccountDesc());
		log.setLogInfo("<p style='display: none;'>IP地址：[" + log.getIp() + "] 用户" + log.getUserName() + " [" + log.getEnterpriseName() + "] 在" + log.getActiveDate() + "</p>删除任务标题：【 " + cmsTaskVO.getTaskName()+"】成功 ");		
		this.cmsLogService.saveLogByActive(log);
		
	}

	@Transactional(rollbackFor=Exception.class)
	public void setTop(String id, HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.cmsTaskService.setTop(id);
		String userName = (String) req.getSession().getAttribute("username");
		CMSTaskVO cmsTaskVO = this.cmsTaskService.getCMSTaskInfoById(id);
		String subjectType="";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LogVO log = this.cmsLogService.getRoleNameByUserName(userName);
		log.setActiveDate(df.format(new Date()));
		log.setIp(getClientIp(req));
		log.setRoleName(log.getAccountDesc());
		log.setLogInfo("<p style='display: none;'>IP地址：[" + log.getIp() + "] 用户" + log.getUserName() + " [" + log.getEnterpriseName() + "] 在" + log.getActiveDate() + "</p>置顶 任务标题：【 " + cmsTaskVO.getTaskName()+"】成功 ");		
		this.cmsLogService.saveLogByActive(log);
	}

	@Transactional(rollbackFor=Exception.class)
	public void removeTop(String id, HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.cmsTaskService.removeTop(id);
		String userName = (String) req.getSession().getAttribute("username");
		CMSTaskVO cmsTaskVO = this.cmsTaskService.getCMSTaskInfoById(id);
		String subjectType="";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LogVO log = this.cmsLogService.getRoleNameByUserName(userName);
		log.setActiveDate(df.format(new Date()));
		log.setIp(getClientIp(req));
		log.setRoleName(log.getAccountDesc());
		log.setLogInfo("<p style='display: none;'>IP地址：[" + log.getIp() + "] 用户" + log.getUserName() + " [" + log.getEnterpriseName() + "] 在" + log.getActiveDate() + "</p>取消置顶 任务标题：【 " + cmsTaskVO.getTaskName()+"】成功 ");		
		this.cmsLogService.saveLogByActive(log);
	}
	
	private String getClientIp(HttpServletRequest req){
	       String ip = req.getHeader("x-forwarded-for"); 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = req.getHeader("Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = req.getHeader("WL-Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = req.getRemoteAddr(); 
	       } 
	       return ip; 
		}	
	
}
