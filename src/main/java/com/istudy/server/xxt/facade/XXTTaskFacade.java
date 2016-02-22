package com.istudy.server.xxt.facade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.istudy.server.cms.service.CMSTaskService;
import com.istudy.server.cms.vo.CMSTaskVO;
import com.istudy.server.common.constants.XXTConstants;
import com.istudy.server.common.exception.CMSException;
import com.istudy.server.common.protocol.ws.xxt.vo.ChkOauth;
import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.xxt.service.XXTTaskService;
import com.istudy.server.xxt.service.XXTWSService;
import com.istudy.server.xxt.vo.ClassVO;
import com.istudy.server.xxt.vo.HisTaskVO;
import com.istudy.server.xxt.vo.KeyVO;
import com.istudy.server.xxt.vo.SchoolVO;
import com.istudy.server.xxt.vo.StudentVO;
import com.istudy.server.xxt.vo.TeacherVO;
import com.istudy.server.xxt.vo.XXTGetTasksParamVO;
import com.istudy.server.xxt.vo.XXTTeacherAuthVO;

@Service("xxtTaskFacade")
public class XXTTaskFacade {

	@Autowired
	private XXTTaskService xxtTaskService;

	@Autowired
	private CMSTaskService cmsTaskService;

	@Autowired
	private XXTWSService xxtWSService;

	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public List<HisTaskVO> getTaskTitleList(XXTGetTasksParamVO param) {
		return xxtTaskService.getTaskTitleList(param);
	}

	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public Map<String, ?> iniSendTaskInfo(String userId, String taskId,String cityId,String token, String schoolId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 任务信息
		XXTGetTasksParamVO gtp = new XXTGetTasksParamVO();
		final CMSTaskVO taskInfo = this.cmsTaskService.getCMSXXTTaskInfoById(taskId);
		resultMap.put("task", taskInfo);

		if(userId == null || cityId == null){
			gtp = this.xxtWSService.getMessagebyToken(token,gtp);
			userId = gtp.getUserId();
			cityId = gtp.getCityId();
		}
		resultMap.put("userId", userId);
		resultMap.put("cityId", cityId);
		resultMap.put("miniUri", taskInfo.getMiniUrl());
		
		LogUtils.L.info("XXTTaskFacade.iniSendTaskInfo" + taskInfo);
		List<ClassVO> classes = Collections.emptyList();
		
		try {
			classes = this.xxtWSService.getClassesByTeacher(userId);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				LogUtils.L.error("获取老师关联的班级失败，重试一次！");
				classes = this.xxtWSService.getClassesByTeacher(userId);
			} catch (Exception e2) {
				e.printStackTrace();
			}
		}
		
		//还是获取不到年级则根据资源显示所有对应的班级
		if(classes.isEmpty()){
			List<ClassVO> allClzList = null;
			try {
				allClzList = this.xxtWSService.getClassesBySchoolId(schoolId);
			} catch (Exception e) {
				e.printStackTrace();
				LogUtils.L.error("获取全校班级失败，重试一次！");
				try {
					allClzList = this.xxtWSService.getClassesBySchoolId(schoolId);
				} catch (Exception e2) {
					e.printStackTrace();
				}
			}
			
			if(allClzList != null){
				classes = new ArrayList<ClassVO>();
				List<String> grades = taskInfo.getGradeIdList();
				for(ClassVO allClz : allClzList){
					if(grades.contains(allClz.getBank())){
						classes.add(allClz);
					}
				}
			}
		}
		
		Collections.sort(classes);
		
		// 班级下学生信息
		for(ClassVO c : classes){
			try {
				List<StudentVO> ss = this.xxtWSService.getStudentParentByClass(c.getClassId(),cityId);
				c.setStudents(ss);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		resultMap.put("classes", classes);
		try {
		TeacherVO teacher = this.xxtWSService.getTeachersById(cityId, userId);
		SchoolVO school = this.xxtWSService.getSchoolById(teacher.getSchoolId());
		resultMap.put("teacher", teacher);
		resultMap.put("school", school);
		}catch(Exception e){
			e.printStackTrace();
		}
	
			List<KeyVO> key = new ArrayList<KeyVO>();
			KeyVO k = new KeyVO();
			k.setCityId(cityId);
			k.setUserId(userId);
			key = this.xxtTaskService.getKeyByCityUserId(k);
			resultMap.put("key", key);
		
		

		return resultMap;
	}
	
	@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public HisTaskVO getHisTaskVOById(String id){
		return this.xxtTaskService.getHisTaskVOById(id);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void saveTeacherSendMsgInfo(HisTaskVO task){
		task.setType("1");
		String amount[] =task.getSendNames().split(",");
		task.setAmountUsers(String.valueOf(amount.length));
		if(XXTConstants.SEND_TYPE_NOW.equals(task.getSendType())){
			task.setSendTime(CommonUtils.getDate(new Date(), CommonUtils.SIMPLE_DATE_FORMAT));
		}
		this.xxtTaskService.saveTeacherSendMsgInfo(task);
		System.out.println("---------------------------"+task.getId()+"----------------------------------");
		//及时发送
		//取不到task的id
		//if(XXTConstants.SEND_TYPE_NOW.equals(task.getSendType())){
		//	String smssn = this.xxtWSService.sendSysSms(task);
			//System.out.println("---------------------"+smssn+","+task.getId()+"---------------------------");
			//this.xxtTaskService.modHisTaskStatusInfo(task,smssn);
			//发送到功能账号上
		//}
	}

	public void updateKeyUser(KeyVO key) {
		// TODO Auto-generated method stub
		this.xxtTaskService.updateKeyUser(key);
	}

	public List<KeyVO> getKeyByCityUserId(KeyVO key) {
		// TODO Auto-generated method stub
		return this.xxtTaskService.getKeyByCityUserId(key);
	}

	public void initTask4pcList(String token, Model model){
		XXTTeacherAuthVO teacher = null;
		try {
			teacher = xxtWSService.getTeacherAuthByToken(token);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return;
		}
		//test
		/*XXTTeacherAuthVO teacher = new XXTTeacherAuthVO();
		teacher.setUserId("1935291");
		teacher.setCityId("gz");
		teacher.setGrades(Arrays.asList("1","2","3","12"));
		teacher.setSchoolId("169055");*/
		if(teacher != null){
			model.addAttribute("teacher", teacher);
			if(!CommonUtils.isNull(teacher.getRoleName()) 
					&& !CommonUtils.isNull(XXTConstants.XXT_ROLENAME_REGEX)){
				Pattern pattern = Pattern.compile(XXTConstants.XXT_ROLENAME_REGEX, Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(teacher.getRoleName());
				model.addAttribute("isManager", matcher.matches());
			}
			
			List<CMSTaskVO> tasks = this.xxtTaskService.getXXTTask4pcByTeacher(teacher);
			model.addAttribute("tasks", tasks);
		}
	}
}
