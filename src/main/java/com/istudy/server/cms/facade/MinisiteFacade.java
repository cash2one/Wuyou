package com.istudy.server.cms.facade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.istudy.server.cms.service.MonthService;
import com.istudy.server.cms.vo.CityVO;
import com.istudy.server.cms.vo.FaqsVO;
import com.istudy.server.cms.vo.GradeVO;
import com.istudy.server.cms.vo.LogVO;
import com.istudy.server.cms.vo.MinisiteVO;
import com.istudy.server.cms.vo.MonthVO;
import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.utils.JsonUtils;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.vo.PagingVO;
import com.istudy.server.xxt.service.XXTTaskService;

@Service
public class MinisiteFacade {

	@Autowired
	private MinisiteService minisiteService;
	
	@Autowired
	private GradeService gradeService;

	@Autowired
	private CityService cityService;
	
	@Autowired
	private MonthService monthService; 
	
	@Autowired
	private CMSTaskService cmsTaskService;
	
	@Autowired
	private XXTTaskService xxtTaskService;
	
	@Autowired
	private CMSLogService cmsLogService;
	
	@Transactional(rollbackFor=Exception.class)
	public void saveMinisiteInfo(MinisiteVO minisiteVO, String path, HttpServletRequest req) {
		String userName = minisiteVO.getCreator();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LogVO log = this.cmsLogService.getRoleNameByUserName(userName);
		log.setActiveDate(df.format(new Date()));
		log.setIp(getClientIp(req));
		log.setRoleName(log.getAccountDesc());
		String subjectType="";
		if(minisiteVO.getSubjectType().equals("1")){
			subjectType = "家长会主题";
		}else{
			subjectType = "无忧分享主题";
		}
		this.minisiteService.saveMinisiteInfo(minisiteVO);
		this.minisiteService.createTemplatePage(minisiteVO, path);
		log.setLogInfo("<p style='display: none;'>IP地址：[" + log.getIp() + "] 用户" + log.getUserName() + " [" + log.getEnterpriseName() + "] 在" + log.getActiveDate() + "</p>添加" + subjectType + "【" + minisiteVO.getTitle() + "】成功");		
		this.cmsLogService.saveLogByActive(log);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void modiMinisiteInfo(MinisiteVO minisiteVO, String path, HttpServletRequest req) {
		String userName = minisiteVO.getUpdator();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LogVO log = this.cmsLogService.getRoleNameByUserName(userName);
		log.setActiveDate(df.format(new Date()));
		log.setIp(getClientIp(req));
		log.setRoleName(log.getAccountDesc());
		String subjectType="";
		if(minisiteVO.getSubjectType().equals("1")){
			subjectType = "家长会主题";
		}else{
			subjectType = "无忧分享主题";
		}
		String oldUrl = minisiteVO.getMiniUrl();
		this.minisiteService.modiMinisiteInfo(minisiteVO);
		//修改minisite时继续使用原有JSP
		//this.minisiteService.delTemplatePage(path, oldUrl);
		this.minisiteService.createTemplatePage(minisiteVO, path);
		log.setLogInfo("<p style='display: none;'>IP地址：[" + log.getIp() + "] 用户" + log.getUserName() + " [" + log.getEnterpriseName() + "] 在" + log.getActiveDate() + "</p>编辑" + subjectType + "【" + minisiteVO.getTitle() + "】成功");
		this.cmsLogService.saveLogByActive(log);
		LogUtils.L.info("原先的模板ID："+oldUrl+",新模板ID："+minisiteVO.getMiniUrl());
	}

	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public MinisiteVO getMinisiteInfoById(String minisiteId) {
		return this.minisiteService.getMinisiteInfoById(minisiteId);
	}
	
	@SuppressWarnings("serial")
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String,?> iniMinisiteInfo(String minisiteId){
		Map<String,Object> map1 = new HashMap<String, Object>();
		MinisiteVO mini= null;
		if(!CommonUtils.isNull(minisiteId)){
			mini = this.minisiteService
					.getMinisiteInfoById(minisiteId);
			
			List<FaqsVO> faqs1 = new ArrayList<FaqsVO>();
			if(!CommonUtils.isNull(mini.getFaqs())){
				faqs1.addAll(Arrays.asList(JsonUtils.toObj(mini.getFaqs(), FaqsVO[].class)));
				if(faqs1.size()<3){
					int a = 3 - faqs1.size();
					for(int i = 0;i<a;i++){
						FaqsVO fv = new FaqsVO();
						faqs1.add(fv);
					}
				}
				map1.put("faqs", faqs1);
			}else{
				for(int i = 0;i<3;i++){
					FaqsVO fv = new FaqsVO();
					faqs1.add(fv);
				}
				map1.put("faqs", faqs1);
			}
			
			
		}
		final Map<String,Object> map = map1;
		
		
		final MinisiteVO mini_ = mini;
		final List<GradeVO> grades = this.gradeService.getAllGradeInfo();
		final List<MonthVO> months = monthService.getAllActivateMonths();
		
/*		map.put("minisite", mini_);
		map.put("grades", grades);
		map.put("months", months);*/
		return new HashMap<String, Object>() {
			{
				putAll(map);
				put("minisite", mini_);
				put("grades", grades);
				put("months", months);
			}
		};
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void delMinisite(String minisiteId,String path, HttpServletRequest req){
		//查询minisite
		/*MinisiteVO minisite = this.minisiteService.getMinisiteInfoById(minisiteId);
		if(!minisite.getType().equals("0")){
			//删除miniUrl页面
			this.minisiteService.delMinisitePage(minisite.getMiniUrl(), path);
			//删除图片
			this.minisiteService.delImg(minisite.getImgUrl());
		}*/
		String userName = (String) req.getSession().getAttribute("username");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LogVO log = this.cmsLogService.getRoleNameByUserName(userName);
		log.setActiveDate(df.format(new Date()));
		log.setIp(getClientIp(req));
		log.setRoleName(log.getAccountDesc());
		MinisiteVO mini= null;
		String subjectType="";
		if(!CommonUtils.isNull(minisiteId)){
			mini = this.minisiteService
					.getMinisiteInfoById(minisiteId);
		}
		if(mini.getSubjectType().equals("1")){
			subjectType = "家长会主题";
		}else{
			subjectType = "无忧分享主题";
		}
		//删除minisite表
		this.minisiteService.delSoftMinisiteById(minisiteId);
		//删除task表
		this.cmsTaskService.delCMSTaskByMinisiteID(minisiteId);
		//删除老师发送记录表
		//this.xxtTaskService.delHisTaskByMinisiteID(minisiteId);
		log.setLogInfo("<p style='display: none;'>IP地址：[" + log.getIp() + "] 用户" + log.getUserName() + " [" + log.getEnterpriseName() + "] 在" + log.getActiveDate() + "</p>删除" + subjectType + "【" + mini.getTitle() + "】成功");		
		this.cmsLogService.saveLogByActive(log);
	}

	public void saveFaqs(MinisiteVO minisiteVO, HttpServletRequest req) {
		// TODO Auto-generated method stub
		String userName = (String) req.getSession().getAttribute("username");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LogVO log = this.cmsLogService.getRoleNameByUserName(userName);
		log.setActiveDate(df.format(new Date()));
		log.setIp(getClientIp(req));
		log.setRoleName(log.getAccountDesc());
		
		this.minisiteService.saveFaqs(minisiteVO);
		log.setLogInfo("<p style='display: none;'>IP地址：[" + log.getIp() + "] 用户" + log.getUserName() + " [" + log.getEnterpriseName() + "] 在" + log.getActiveDate() + "</p>编辑家长会【" + minisiteVO.getTitle() + "】的FAQ成功");		
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
