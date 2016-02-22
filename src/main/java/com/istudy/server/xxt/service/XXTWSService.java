package com.istudy.server.xxt.service;

import static com.istudy.server.common.utils.CommonUtils.PROPERTIES;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istudy.server.cms.service.CMSLogService;
import com.istudy.server.cms.service.CMSTaskService;
import com.istudy.server.cms.vo.CMSTaskVO;
import com.istudy.server.cms.vo.DeleteTaskVO;
import com.istudy.server.cms.vo.LogVO;
import com.istudy.server.common.constants.CMSConstants;
import com.istudy.server.common.constants.XXTConstants;
import com.istudy.server.common.exception.CMSException;
import com.istudy.server.common.protocol.ws.xxt.Response;
import com.istudy.server.common.protocol.ws.xxt.XXTServiceMain;
import com.istudy.server.common.protocol.ws.xxt.vo.ChkOauth;
import com.istudy.server.common.protocol.ws.xxt.vo.ChkParentHfResponse;
import com.istudy.server.common.protocol.ws.xxt.vo.QryBaseDataResponse;
import com.istudy.server.common.protocol.ws.xxt.vo.QryBaseDataResponse.ClassList;
import com.istudy.server.common.protocol.ws.xxt.vo.QryBaseDataResponse.ClassList.ClassEntity;
import com.istudy.server.common.protocol.ws.xxt.vo.QryBaseDataResponse.ParentList;
import com.istudy.server.common.protocol.ws.xxt.vo.QryBaseDataResponse.ParentList.ParentEntity;
import com.istudy.server.common.protocol.ws.xxt.vo.QryBaseDataResponse.SchoolEntity;
import com.istudy.server.common.protocol.ws.xxt.vo.QryBaseDataResponse.StudentEntity;
import com.istudy.server.common.protocol.ws.xxt.vo.QryBatchClassResponse;
import com.istudy.server.common.protocol.ws.xxt.vo.QryClassStudentResponse;
import com.istudy.server.common.protocol.ws.xxt.vo.QryClassStudentResponse.StudentInfo;
import com.istudy.server.common.protocol.ws.xxt.vo.QryClassTeacherResponse;
import com.istudy.server.common.protocol.ws.xxt.vo.QryClassTeacherResponse.Relations.ClassTeacherRelation;
import com.istudy.server.common.protocol.ws.xxt.vo.QryClassTeacherResponse.Relations.ClassTeacherRelation.SubjectList;
import com.istudy.server.common.protocol.ws.xxt.vo.QryClassTeacherResponse.Relations.ClassTeacherRelation.SubjectList.Subject;
import com.istudy.server.common.protocol.ws.xxt.vo.QrySchoolResponse;
import com.istudy.server.common.protocol.ws.xxt.vo.QrySchoolTeacherResponse;
import com.istudy.server.common.protocol.ws.xxt.vo.QrySchoolTeacherResponse.Relations.SchoolTeacherRelation;
import com.istudy.server.common.protocol.ws.xxt.vo.QryStuPrtByClassResponse;
import com.istudy.server.common.protocol.ws.xxt.vo.QryStuPrtByClassResponse.StudentList;
import com.istudy.server.common.protocol.ws.xxt.vo.QryStudentParentResponse;
import com.istudy.server.common.protocol.ws.xxt.vo.QryStudentParentResponse.Relations.StudentParentRelation;
import com.istudy.server.common.protocol.ws.xxt.vo.QryTeacherInfoResponse;
import com.istudy.server.common.protocol.ws.xxt.vo.SendOEMResult;
import com.istudy.server.common.protocol.ws.xxt.vo.SendSingleSMSResponse;
import com.istudy.server.common.protocol.ws.xxt.vo.SendSysSmsResponse;
import com.istudy.server.common.protocol.ws.xxt.vo.XXTWSRequestBody;
import com.istudy.server.common.protocol.ws.xxt.vo.XXTWSRequestBody.SmsList;
import com.istudy.server.common.protocol.ws.xxt.vo.XXTWSRequestBody.SmsList.SmsEntity;
import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.utils.HttpUtils;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.xxt.vo.ClassVO;
import com.istudy.server.xxt.vo.HisTaskVO;
import com.istudy.server.xxt.vo.ParentVO;
import com.istudy.server.xxt.vo.SchoolVO;
import com.istudy.server.xxt.vo.StudentVO;
import com.istudy.server.xxt.vo.SubjectVO;
import com.istudy.server.xxt.vo.TeacherVO;
import com.istudy.server.xxt.vo.XXTGetTasksParamVO;
import com.istudy.server.xxt.vo.XXTTeacherAuthVO;


@Service("xxtWSService")
public class XXTWSService {
	
	@Autowired
	private XXTTaskService xxtTaskService;
	
	@Autowired
	private CMSLogService cmsLogService;
	
	public static final String CHK_OAUTH="CHK_OAUTH"; //用户单点登录(教师、家长、学生)
	public static final String QRY_TOWN="QRY_TOWN"; //获取地市所有镇区信息接口
	public static final String QRY_BATCH_SCHOOL="QRY_BATCH_SCHOOL"; //获取镇区所有学校信息接口
	public static final String QRY_BATCH_CLASS="QRY_BATCH_CLASS"; //获取学校所有班级信息接口
	public static final String QRY_SCHOOL_TEACHER="QRY_SCHOOL_TEACHER"; //获取学校所有教师信息接口
	public static final String QRY_CLASS_STUDENT="QRY_CLASS_STUDENT"; //获取某班级所有学生信息接口
	public static final String QRY_CLASS_TEACHER="QRY_CLASS_TEACHER"; //获取班级与教师关系信息接口
	public static final String QRY_STUPRT_BY_CLASS="QRY_STUPRT_BY_CLASS"; //批量获取某班学生及家长信息接口
	public static final String QRY_SCHOOL="QRY_SCHOOL"; //获取某个学校信息接口
	public static final String QRY_CLASS="QRY_CLASS"; //获取某个班级信息接口
	public static final String QRY_TEACHER_INFO="QRY_TEACHER_INFO"; //获取教师用户信息接口
	public static final String QRY_PARENT_INFO="QRY_PARENT_INFO"; //获取家长用户信息接口
	public static final String QRY_STUDENT_INFO="QRY_STUDENT_INFO"; //获取学生用户信息接口
	public static final String QRY_TOWN_UPDATE="QRY_TOWN_UPDATE"; //获取镇区变更、增量数据接口
	public static final String QRY_SCHOOL_UPDATE="QRY_SCHOOL_UPDATE"; //获取学校变更、增量数据接口
	public static final String QRY_CLASS_UPDATE="QRY_CLASS_UPDATE"; //获取班级变更、增量数据接口
	public static final String QRY_CLASS_TEACHER_UPDATE="QRY_CLASS_TEACHER_UPDATE"; //获取教师与班级关系的增量数据接口
	public static final String QRY_CLASS_STUDENT_UPDATE="QRY_CLASS_STUDENT_UPDATE"; //获取班级对应学生增量数据接口
	public static final String SEND_SYS_PUBLIC_MESSAGE="SEND_SYS_PUBLIC_MESSAGE"; //向某用户推送应用消息接口
	public static final String SEND_SYS_SCH_MESSAGE="SEND_SYS_SCH_MESSAGE"; //批量向某学校推送应用消息接口
	public static final String SEND_SYS_GRP_MESSAGE="SEND_SYS_GRP_MESSAGE"; //批量向某年级推送应用消息接口
	public static final String SEND_SYS_CLS_MESSAGE="SEND_SYS_CLS_MESSAGE"; //批量向某班级推送应用消息接口
	public static final String SEND_SINGLE_SMS="SEND_SINGLE_SMS"; //单个短信发送接口
	public static final String SEND_BATCH_SMS="SEND_BATCH_SMS"; //批量短信发送接口
	public static final String QRY_SMS_RESULT="QRY_SMS_RESULT"; //查询短信发送状态结果接口
	public static final String QRY_WEIBO_MSG="QRY_WEIBO_MSG"; //获取家校圈微博记录接口
	public static final String QRY_COMMENT_WEIBO_MSG="QRY_COMMENT_WEIBO_MSG"; //获取家校圈微博评论信息接口
	public static final String QRY_PRAISE_WEIBO_MSG="QRY_PRAISE_WEIBO_MSG"; //获取家校圈微博赞明细信息接口
	public static final String ADD_WEIBO_MSG="ADD_WEIBO_MSG"; //家校圈微博发布接口
	public static final String SHARE_WEIBO_MSG="SHARE_WEIBO_MSG"; //家校圈微博分享发布接口
	public static final String ADD_COMMENT_WEIBO_MSG="ADD_COMMENT_WEIBO_MSG"; //家校圈微博评论接口
	public static final String ADD_PRAISE_WEIBO_MSG="ADD_PRAISE_WEIBO_MSG"; //家校圈微博赞接口
	public static final String QRY_PACKAGE_INFO="QRY_PACKAGE_INFO"; //查询营销方案信息接口（本应用+套餐）
	public static final String PRT_SEND_COMFIRM_SMS="PRT_SEND_COMFIRM_SMS"; //家长订购业务二次确认短信接口
	public static final String QRY_ORDER="QRY_ORDER"; //查询家长用户订购业务情况接口
	public static final String QRY_CHG_MAIN="QRY_CHG_MAIN"; //业务订购概要变更日志接口
	public static final String QRY_CHG_DETAIL="QRY_CHG_DETAIL"; //业务订购明细变更日志接口
	public static final String QRY_STU_SCORE="QRY_STU_SCORE"; //获取学生成绩接口
	public static final String SEND_BATCH_KQ="SEND_BATCH_KQ"; //考勤信息批量推送接口
	public static final String SEND_BATCH_DEALRECORD="SEND_BATCH_DEALRECORD"; //消费信息批量推送接口
	
	public static final String SEND_OEM_SCH_MESSAGE="SEND_OEM_SCH_MESSAGE";
	
	//old interfaces wait for modify
	public static final String QRY_STUDENT_PARENT = "QRY_STUDENT_PARENT";//学生和家长的关系
	public static final String QRY_BASEINFO = "QRY_BASEINFO";//
	public static final String CHK_PARENT_HF = "CHK_PARENT_HF";//
	public static final String QRY_BASEDATA = "QRY_BASEDATA";
	public static final String SEND_SYS_SMS = "SEND_SYS_SMS";//短信群发
	
	public static final String SMS_RESULT_SUCCESS = "1";	//发送短信返回成功
	public static final String SMS_MAX_SIZE = PROPERTIES.getProperty("send.sms.max.student.size");	//单笔发送最大个数
	
	/**
	 * 根据老师ID查询所在班级的集合
	 * 
	 * @param rb
	 * @return
	 */
	public List<ClassVO> getClassesByTeacher(String userId){
		XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setTeacherId(userId);
		QryClassTeacherResponse o = doRequest(QRY_CLASS_TEACHER, rb, QryClassTeacherResponse.class);
		List<com.istudy.server.common.protocol.ws.xxt.vo.QryClassTeacherResponse.Relations> rs = o.getRelations();
		List<ClassVO> classes = new ArrayList<ClassVO>();
		for(com.istudy.server.common.protocol.ws.xxt.vo.QryClassTeacherResponse.Relations r : rs){
			List<ClassTeacherRelation> trs = r.getClassTeacherRelation();
			for(ClassTeacherRelation ctr : trs){
				classes.add(new ClassVO(ctr.getClassId(), ctr.getClassName()));
			}
		}
		return classes;
	}
	
	/**
	 * 根据班级ID查询学生集合
	 * 
	 * @param classId
	 * @param cityId
	 * @return
	 */
	public List<StudentVO> getStudentsByClass(String classId,String cityId){
		List<StudentVO> students = new ArrayList<StudentVO>();
		XXTWSRequestBody rb = new XXTWSRequestBody(cityId,classId,null);
		QryClassStudentResponse o = doRequest(QRY_CLASS_STUDENT, rb, QryClassStudentResponse.class);
		
		List<StudentInfo> rs = o.getStudentInfo();
		for(StudentInfo std : rs){
			StudentVO vo = new StudentVO(std.getStudentId(), std.getUserName());
			vo.setClassId(std.getClassId());
			vo.setClassName(std.getClassName());
			vo.setGradeId(std.getGradeId());
			vo.setGradeName(std.getGradeName());
			vo.setLoginName(std.getLoginName());
			vo.setStudentSeq(std.getStudentSeq());
			vo.setCityId(cityId);
			
			students.add(vo);
		}

		return students;
	}
	
	/**
	 * 根据学生ID查询学生基本信息
	 * 
	 * @param rb
	 * @return
	 */
	public StudentVO getStudentInfoById(String studentId, String cityId){
		XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setStudentId(studentId);
		rb.setCityId(cityId);
		QryBaseDataResponse o = doRequest(QRY_BASEDATA, rb, QryBaseDataResponse.class);
		
		List<Object> schoolEntityOrStudentEntityOrClassList = o.getSchoolEntityOrStudentEntityOrClassList();
		StudentVO vo = new StudentVO();
		for(Object obj : schoolEntityOrStudentEntityOrClassList){
			if(obj instanceof StudentEntity){
				StudentEntity student = (StudentEntity)obj;
				vo.setStudentId(student.getStudentId());
				vo.setStudentSeq(student.getStudentSeq());
				vo.setStudentName(student.getUserName());
				vo.setLoginName(student.getLoginName());
				vo.setHeadImage(student.getHeadImage());
				vo.setEmail(student.getEMail());
				vo.setCityId(cityId);
			}else if(obj instanceof SchoolEntity){
				SchoolEntity school = (SchoolEntity)obj;
				vo.setAreaId(school.getAreaId());
				vo.setAreaName(school.getAreaName());
				vo.setSchoolId(school.getSchoolId());
				vo.setSchoolName(school.getSchoolName());
				vo.setSection(school.getSection());
				vo.setTownId(school.getTownId());
				vo.setTownName(school.getTownName());
			}else if(obj instanceof ClassList){
				ClassList classList = (ClassList)obj;
				List<ClassEntity> classEntities = classList.getClassEntity();
				for(ClassEntity clz : classEntities){
					vo.setClassId(vo.getClassId() == null ? clz.getClassId() : (vo.getClassId() + "," + clz.getClassId()));
					vo.setClassName(vo.getClassName() == null ? clz.getClassName() : (vo.getClassName() + "," + clz.getClassName()));
					vo.setClassType(vo.getClassType() == null ? clz.getClassType() :(vo.getClassType() + "," + clz.getClassType()));
					vo.setGradeId(vo.getGradeId() == null ? clz.getGradeId() :(vo.getGradeId() + "," + clz.getGradeId()));
					vo.setGradeName(vo.getGradeName() == null ? clz.getGradeName() :(vo.getGradeName() + "," + clz.getGradeName()));
					vo.setClassSchoolId(vo.getClassSchoolId() == null ? clz.getSchoolId() :(vo.getClassSchoolId() + "," + clz.getSchoolId()));
					vo.setBank(vo.getBank() == null ? clz.getBank() : (vo.getBank() + "," + clz.getBank()));
				}
			}else if(obj instanceof ParentList){
				ParentList parentList = (ParentList)obj;
				List<ParentEntity> parentEntities = parentList.getParentEntity();
				List<ParentVO> parentVOs = vo.getParents();
				for(ParentEntity parent : parentEntities){
					ParentVO parentVO = new ParentVO();
					parentVO.setParentId(parent.getParentId());
					parentVO.setParentName(parent.getParUserName());
					parentVO.setStudentId(studentId);
					parentVO.setParentLoginName(parent.getParLoginName());
					parentVO.setEmail(parent.getParEMail());
					parentVO.setHeadImg(parent.getParHeadImage());
					parentVO.setCityId(cityId);
					
					parentVOs.add(parentVO);
				}
			}
		}
		return vo;
	}
	
	/**
	 * 根据班级ID查询学生集合
	 * 
	 * @param classId
	 * @param cityId
	 * @return
	 */
	public List<StudentVO> getStudentParentByClass(String classId,String cityId){
		List<StudentVO> students = new ArrayList<StudentVO>();
		XXTWSRequestBody rb = new XXTWSRequestBody(cityId,classId,null);
		QryStuPrtByClassResponse o = doRequest(QRY_STUPRT_BY_CLASS, rb, QryStuPrtByClassResponse.class);
		
		List<StudentList> studentLists = o.getStudentList();
		for(StudentList studentList : studentLists){
			List<StudentList.StudentEntity> studentEntities = studentList.getStudentEntity();
			for(StudentList.StudentEntity std : studentEntities){
				StudentVO vo = new StudentVO(std.getStudentId(), std.getUserName());
				vo.setLoginName(std.getLoginName());
				vo.setStudentSeq(std.getStudentSeq());
				vo.setCityId(cityId);
				
				List<ParentVO> parents = vo.getParents();
				List<StudentList.StudentEntity.ParentList> parentLists = std.getParentList();
				for(StudentList.StudentEntity.ParentList parentList : parentLists){
					List<StudentList.StudentEntity.ParentList.ParentEntity> parentEntities = parentList.getParentEntity();
					for(StudentList.StudentEntity.ParentList.ParentEntity parentEntity : parentEntities){
						ParentVO parent = new ParentVO();
						
						parent.setCityId(cityId);
						parent.setParentId(parentEntity.getParentId());
						parent.setHeadImg(parentEntity.getParHeadImage());
						parent.setParentLoginName(parentEntity.getParLoginName());
						parent.setParentName(parentEntity.getParUserName());
						
						parents.add(parent);
					}
				}
				
				students.add(vo);
			}
		}
		return students;
	}
	
	/**
	 * 根据学生ID查询所在班级
	 * 
	 * @param rb
	 * @return
	 */
	public ClassVO getClassByStudentId(String studentId, String cityId){
		XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setStudentId(studentId);
		rb.setCityId(cityId);
		QryClassStudentResponse o = doRequest(QRY_CLASS_STUDENT, rb, QryClassStudentResponse.class);
		
		/*List<Relations> relations = o.getRelations();
		if(relations.size() > 0){
			Relations rela = relations.get(0);
			List<ClassStudentRelation> classStudentRelation = rela.getClassStudentRelation();
			if(classStudentRelation.size() > 0){
				ClassStudentRelation relation = classStudentRelation.get(0);
				System.out.println(relation);
			}
		}*/
		
		return null;
	}
	
	//通过学校推送OEM信息到校讯通平台
	public List<String> sendOemSchMessage(CMSTaskVO task1){
		List<String> failedList = new ArrayList<>();
		
		XXTWSRequestBody rb = new XXTWSRequestBody();
		
		String schoolIds = task1.getFailedSchoolIds();
		if(CommonUtils.isNull(schoolIds)){
			schoolIds = task1.getSchoolIds();
		}
		
		if(task1.getSubjectType().equalsIgnoreCase("0")){
			if(!CommonUtils.isNull(task1.getShareType())){
				rb.setTitle(task1.getShareType());
			}else{
				rb.setTitle("家长无忧");
			}
			
		}else{
			rb.setTitle("三分钟家长会");
			
			
		}
		String msgId;
		String[] schools = CommonUtils.delHeadAndLashChar(schoolIds).split(",");
		
		String url1 = CMSConstants.DOMAIN_NAME + "xxtTask/showTaskPage.do?taskId="+ task1.getId();
		rb.setMessageType("1");
		rb.setUserType("1");
		
		rb.setMessageURL(url1);
		rb.setMessageContent(task1.getMiniTitle());
		rb.setIsOauth("1");
		rb.setValidDate(task1.getValidDate());
		for(int i = 0 ; i < schools.length ; i++){
			String citySchoolId = schools[i];
			String[] ids = citySchoolId.split("\\|");
			
			try {
				rb.setCityId(ids[1]);
				rb.setSchoolId(ids[0]);
				msgId=ids[1]+"_"+ids[0]+"_"+task1.getId();
				rb.setOthMsgId(msgId);
				task1.setMsgId(msgId);
				SendOEMResult result = doRequest(SEND_OEM_SCH_MESSAGE, rb, SendOEMResult.class);
				if("200".equals(result.getResult())){
					this.xxtTaskService.updateCMSTaskInfo(task1);
					continue;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			failedList.add(schools[i]);
		}
		LogVO log = new LogVO();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		log.setActiveDate(df.format(new Date()));
		log.setUserName("system");
		log.setEnterpriseName("system");
		log.setIp("");
		log.setLogInfo("【" + task1.getTaskName() + "】【" + task1.getMiniTitle() + "】推送到校讯通成功");
		this.cmsLogService.saveLogByActive(log);
		return failedList;
	}
	
	//发送推荐任务到校讯通
	public List<String> sendArticle2XXT(CMSTaskVO task1) {
		List<String> failedGrades = new ArrayList<String>();
		
		XXTWSRequestBody rb = new XXTWSRequestBody();
		String msgId;
		String url1 = CMSConstants.DOMAIN_NAME + "xxtTask/showTaskPage.do?taskId="+ task1.getId();
		rb.setMessageType("1");
		rb.setUserType("1");
		//rb.setGradeId("");
		if(task1.getSubjectType().equalsIgnoreCase("0")){
			if(!CommonUtils.isNull(task1.getShareType())){
				rb.setTitle(task1.getShareType());
			}else{
				rb.setTitle("家长无忧");
			}
		}else{
			
			rb.setTitle("三分钟家长会");
		}
		rb.setMessageURL(url1);
		rb.setMessageContent(task1.getMiniTitle());
		rb.setIsOauth("1");
		rb.setValidDate(task1.getValidDate());
		
		String fgrades = task1.getFailedGrades();
		if(CommonUtils.isNull(fgrades)){
			String[] citys = CommonUtils.delHeadAndLashChar(task1.getCitys()).split(",");
			String[] grades = CommonUtils.delHeadAndLashChar(task1.getGrades()).split(",");
			
			for(int i = 0 ; i < citys.length ; i++){
				rb.setCityId(citys[i]);
				for( int j = 0 ; j < grades.length ; j++){
					rb.setBank(grades[j]);
					try {
						msgId=citys[i]+"_"+grades[j]+"_"+task1.getId();
						rb.setOthMsgId(msgId);
						task1.setMsgId(msgId);
						SendOEMResult result = doRequest("SEND_OEM_GRP_MESSAGE", rb, SendOEMResult.class);
						if("200".equals(result.getResult())){
							this.xxtTaskService.updateCMSTaskInfo(task1);
							continue;
						}	
					} catch (Exception e) {
						e.printStackTrace();
					}
					failedGrades.add(citys[i] + "|" + grades[j]);
				}
			}
			LogVO log = new LogVO();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			log.setActiveDate(df.format(new Date()));
			log.setUserName("system");
			log.setEnterpriseName("system");
			log.setIp("");
			log.setLogInfo("【" + task1.getTaskName() + "】【" + task1.getMiniTitle() + "】推送到校讯通成功");
			this.cmsLogService.saveLogByActive(log);
		}else{
			String[] cityGrades = fgrades.split(",");
			for(String cityGrade : cityGrades){
				String[] ids = cityGrade.split("\\|");
				try {
					rb.setCityId(ids[0]);
					rb.setBank(ids[1]);
					SendOEMResult result = doRequest("SEND_OEM_GRP_MESSAGE", rb, SendOEMResult.class);
					if("200".equals(result.getResult())){
						continue;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				failedGrades.add(cityGrade);
			}
		}
		
		
	    return failedGrades;
	}
	
	//发送推荐任务到校讯通school|city|grade
		public List<String> sendOemArticle2XXT(CMSTaskVO task1) {
			List<String> failedSchoolIds = new ArrayList<String>();
			XXTWSRequestBody rb = new XXTWSRequestBody();
			String url1 = CMSConstants.DOMAIN_NAME + "xxtTask/showTaskPage.do?taskId="+ task1.getId();
			rb.setMessageType("1");
			rb.setUserType("1");
			String schoolIds = task1.getFailedSchoolIds();
			String taskSchoolIds = task1.getSchoolIds();
			//rb.setGradeId("");
			if(task1.getSubjectType().equalsIgnoreCase("0")){
				if(!CommonUtils.isNull(task1.getShareType())){
					rb.setTitle(task1.getShareType());
				}else{
					rb.setTitle("家长无忧");
				}
				
			}else{
				rb.setTitle("三分钟家长会");
			}
			String[] grades = CommonUtils.delHeadAndLashChar(task1.getGrades()).split(",");
			
			rb.setMessageURL(url1);
			rb.setMessageContent(task1.getMiniTitle());
			rb.setIsOauth("1");
			rb.setValidDate(task1.getValidDate());
			
			
			if(CommonUtils.isNull(schoolIds)){
				String[] schools = CommonUtils.delHeadAndLashChar(taskSchoolIds).split(",");
				for(int i = 0 ; i < grades.length ; i++){
					for(int j = 0 ; j < schools.length ; j++){
						String schoolIdCity = schools[j];
						String[] ids = schoolIdCity.split("\\|");
						
						try {
							rb.setBank(grades[i]);
							rb.setCityId(ids[1]);
							if(CommonUtils.isNull(ids[0])){
								rb.setSchoolId(null);
							}else{
								rb.setSchoolId(ids[0]);
							}
							String msgId = ids[1]+"_"+ids[0]+"_"+grades[i]+"_"+task1.getId();
							rb.setOthMsgId(msgId);
							SendOEMResult result = doRequest("SEND_OEM_GRP_MESSAGE", rb, SendOEMResult.class);
							if("200".equals(result.getResult())){
								//update msgId
								task1.setMsgId(msgId);
								this.xxtTaskService.updateCMSTaskInfo(task1);
								continue;
							}							
						} catch (Exception e) {
							e.printStackTrace();
						}
						failedSchoolIds.add(schools[j]+"|"+grades[i]);
					}
					
					
					
					
					
				}
				LogVO log = new LogVO();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				log.setActiveDate(df.format(new Date()));
				log.setUserName("system");
				log.setEnterpriseName("system");
				log.setIp("");
				log.setLogInfo("【" + task1.getTaskName() + "】【" + task1.getMiniTitle() + "】推送到校讯通成功");
				this.cmsLogService.saveLogByActive(log);
/*				String[] citys = CommonUtils.delHeadAndLashChar(task1.getCitys()).split(",");
				String[] grades = CommonUtils.delHeadAndLashChar(task1.getGrades()).split(",");*/
				
				
				/*for(int i = 0 ; i < citys.length ; i++){
					rb.setCityId(citys[i]);
					for( int j = 0 ; j < grades.length ; j++){
						rb.setBank(grades[j]);
						try {
							SendOEMResult result = doRequest("SEND_OEM_GRP_MESSAGE", rb, SendOEMResult.class);
							if("200".equals(result.getResult())){
								continue;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						failedGrades.add(citys[i] + "|" + grades[j]);
					}
				}*/
			}else{
				String[] schools = schoolIds.split(",");
				for(int i=0;i<schools.length;i++){
					
					String[] ids = schools[i].split("\\|");
					
					// schoolId|cityId|gradeId
					
					try{
						rb.setBank(ids[2]);
						rb.setCityId(ids[1]);
						if(CommonUtils.isNull(ids[0])){
							rb.setSchoolId(null);
						}else{
							rb.setSchoolId(ids[0]);
						}
						String msgId = ids[1]+"_"+ids[0]+"_"+ids[2]+"_"+task1.getId();
						rb.setOthMsgId(msgId);
						SendOEMResult result = doRequest("SEND_OEM_GRP_MESSAGE", rb, SendOEMResult.class);
						if("200".equals(result.getResult())){
							//update msgId
							task1.setMsgId(msgId);
							this.xxtTaskService.updateCMSTaskInfo(task1);
							continue;
						}
						
					}catch(Exception e){
						e.printStackTrace();
					}
					
					failedSchoolIds.add(schools[i]);
				}
				
				/*String[] cityGrades = fgrades.split(",");
				for(String cityGrade : cityGrades){
					String[] ids = cityGrade.split("\\|");
					try {
						rb.setCityId(ids[0]);
						rb.setBank(ids[1]);
						SendOEMResult result = doRequest("SEND_OEM_GRP_MESSAGE", rb, SendOEMResult.class);
						if("200".equals(result.getResult())){
							continue;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					failedGrades.add(cityGrade);
				}*/
			}
			
			
		    return failedSchoolIds;
		}
		
		
	
	public List<String> sendSysSms(HisTaskVO task){
		XXTWSRequestBody rb = new XXTWSRequestBody();
		//rb.setSmsTargetSeq("859518");
		rb.setCityId(task.getTeaCity());
		rb.setUserType("3");
		rb.setSmsType("1");

		String[] users = null;
		String failedUsers = task.getFailedUsers();
		if(CommonUtils.isNull(failedUsers)){
			users = task.getSendUsers().split(",");
		}else{
			users = failedUsers.split(",");
		}
		//预览地址
		//String readUrl = CMSConstants.DOMAIN_NAME+XXTConstants.MINISITE_URL_TAILS+
		//		task.getMiniUrl();
		//生成带统计的长地址
		//String longUrl = CMSConstants.DOMAIN_NAME+"/xxM/"+task.getTeaCity()+"/"+users[0]+"/99/"+task.getMiniUrl();
		//短消息
		//rb.setSmsContent(task.getMsgDetails()+" 链接:" + CMSConstants.DOMAIN_NAME+XXTConstants.MINISITE_URL_TAILS+
		//		task.getMiniUrl());
		/*if(XXTConstants.SEND_CLASS.equals(task.getType())){//发班级
			return sendSysSmsByClass(rb,users);
		}else*/ 
		if(XXTConstants.SEND_STUDENT.equals(task.getType())){
			return sendSysSmsByStudents(rb,users,task);
		}else{
			LogUtils.L.error("发送对象为空!");
			return null;
		}
	}
	 
	public String sendSysSmsByClass(XXTWSRequestBody rb,String[] users){
		rb.setSmsType("1");
		String failedUsers = "";
		for(String c: users){
			if(!CommonUtils.isNull(c)){
				rb.setSmsTargetSeq(c);
			}
			Response res = null;
			try {
				res = XXTServiceMain.requestXXT(SEND_SYS_SMS,rb.toXML());
			} catch (CMSException e) {
				//失败
				failedUsers+=c+",";
				continue;
			}
			String body = res.getBody();
			XXTServiceMain.parseToBean(body,SendSysSmsResponse.class);
		}
		return failedUsers;
	}
	
	public List<String> sendSysSmsByStudents(XXTWSRequestBody rb, String[] users,
			HisTaskVO task) {
		List<String> failUsers = new ArrayList<String>();
		int pageSize = XXTConstants.SEND_SMS_MAX_STUDENT_SIZE;
		int pageNum = users.length / pageSize;
		// SEND_SMS_MAX_STUDENT_SIZE
		if(users.length %  pageSize!= 0){
			pageNum++;
		}
		for (int j = 0; j < pageNum; j++) {

			long time = System.currentTimeMillis();
			SmsList list = new SmsList();

			List<String> currUsers = new ArrayList<String>();
			for (int i = j * pageSize; i < Math.min(j * pageSize + pageSize,
					users.length); i++) {
				currUsers.add(users[i]);
				
				String[] ids = users[i].split("\\|");
				SmsEntity entity = new SmsEntity();

				// String random = "5";
				// 短信唯一标识
				entity.setOthSmsId(time + "" + i);

				// 发送目标，用户id
				entity.setSmsTargetSeq(ids[0]);

				// 生成带统计的长地址
				String longUrl = CMSConstants.DOMAIN_NAME + "/xxtM/"
						+ task.getTeaCity() + "/" + ids[1] + "/99/"
						+ task.getMiniUrl() + ".do";

				// 生成短链接
				String shortUrl = createShortUrl(longUrl);

				// 设置短信内容，添加短链接
				entity.setSmsContent("【"
						+ CommonUtils.nullToEmpty(task.getSchoolName()) + "】"
						+ CommonUtils.nullToEmpty(ids[2]) + "家长，你好！"
						+ task.getMsgDetails() + " 手机打开:" + shortUrl + "【"
						+ CommonUtils.nullToEmpty(task.getTeaName()) + "老师】");

				list.getSmsEntity().add(entity);
			}

			rb.getSmsList().add(list);
			Response res = null;
			System.out.println(rb.toXML());

			SendSingleSMSResponse res1 = null;
			try {

				res = XXTServiceMain.requestXXT("SEND_SINGLE_SMS", rb.toXML());

			} catch (Exception e) {
				e.printStackTrace();
				failUsers.addAll(currUsers);
				continue;
			}

			String body = res.getBody();
			res1 = XXTServiceMain
					.parseToBean(body, SendSingleSMSResponse.class);
			task.setSmssn(res1.getSmsSn());
			this.xxtTaskService.updateXXTSmsSnInfo(task);
		}
		/*for (int i = 0; i < users.length; i++) {

			String[] ids = users[i].split("\\|");
			SmsEntity entity = new SmsEntity();
			int j = i + 1;

			// String random = "5";
			// 短信唯一标识
			entity.setOthSmsId(time + "" + j);

			// 发送目标，用户id
			entity.setSmsTargetSeq(ids[0]);

			// 生成带统计的长地址
			String longUrl = CMSConstants.DOMAIN_NAME + "/xxtM/"
					+ task.getTeaCity() + "/" + ids[1] + "/99/"
					+ task.getMiniUrl() + ".do";

			// 生成短链接
			String shortUrl = createShortUrl(longUrl);

			// 设置短信内容，添加短链接
			entity.setSmsContent("【"
					+ CommonUtils.nullToEmpty(task.getSchoolName()) + "】"
					+ CommonUtils.nullToEmpty(ids[2]) + "家长，你好！"
					+ task.getMsgDetails() + " 点击:" + shortUrl + "【"
					+ CommonUtils.nullToEmpty(task.getTeaName()) + "老师】");

			list.getSmsEntity().add(entity);
		}
		rb.getSmsList().add(list);
		Response res = null;
		System.out.println(rb.toXML());
		
		SendSingleSMSResponse res1 = null;
		res = XXTServiceMain.requestXXT("SEND_SINGLE_SMS", rb.toXML());

		String body = res.getBody();
		res1 = XXTServiceMain.parseToBean(body, SendSingleSMSResponse.class);
		smssn = res1.getSmsSn();*/
		return failUsers;

		// tar+=users[i]+",";
		/*
		 * if((i+1)%CommonUtils.parseInt(SMS_MAX_SIZE)==0||(i+1)==users.length){
		 * tar = CommonUtils.delLastChar(tar); rb.setSmsTargetSeq(tar); Response
		 * res = null; try { res =
		 * XXTServiceMain.requestXXT(SEND_SYS_SMS,rb.toXML()); } catch
		 * (CMSException e) { //失败 failedUsers+=tar+","; continue; } String body
		 * = res.getBody();
		 * XXTServiceMain.parseToBean(body,SendSysSmsResponse.class); tar = "";
		 * } } return failedUsers;
		 */
	}
	
	/**
	 * 根据学生ID查询学生和家长关系
	 * @param cityId
	 * @param studentId
	 * @return
	 */
	public StudentVO getStudentParentRelaById(String cityId, String studentId){
		QryStudentParentResponse rela = this.getStudentParentRela(cityId, studentId, null);
		List<QryStudentParentResponse.Relations> relations = rela.getRelations();
		StudentVO vo = new StudentVO();
		List<ParentVO> parents = vo.getParents();
		for(QryStudentParentResponse.Relations relation : relations){
			List<StudentParentRelation> parentRelations = relation.getStudentParentRelation();
			for(StudentParentRelation parentRelation : parentRelations){
				vo.setStudentId(studentId);
				vo.setLoginName(parentRelation.getStuLoginName());
				vo.setStudentName(parentRelation.getStuUserName());
				vo.setCityId(cityId);
				
				ParentVO parentVo = new ParentVO();
				parentVo.setParentId(parentRelation.getParentId());
				parentVo.setParentLoginName(parentRelation.getParLoginName());
				parentVo.setParentName(parentRelation.getParUserName());
				parentVo.setStudentId(studentId);
				parentVo.setCityId(cityId);
				parentVo.setHeadImg(parentRelation.getParHeadImage());
				parentVo.setEmail(parentRelation.getParEMail());
				
				parents.add(parentVo);
			}
		}
		
		return vo;
	}
	
	/**
	 * 根据学生ID或家长ID查询学生和家长关系
	 * 
	 * @param 
	 * @return
	 */
	public QryStudentParentResponse getStudentParentRela(String cityId,String studentId, String parentId){
		XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setCityId(cityId);
		rb.setStudentId(studentId);
		rb.setParentId(parentId);
		return doRequest(QRY_STUDENT_PARENT, rb, QryStudentParentResponse.class);
	}
	
	public Map<String, List<ClassVO>> getGradeGroupBySchoolId(String schoolId){
		List<ClassVO> clzz = getClassesBySchoolId(schoolId);
		if(clzz == null || clzz.isEmpty()){
			return Collections.emptyMap();
		}
		Map<String, List<ClassVO>> res = new TreeMap<String, List<ClassVO>>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				try {
					int i1 = Integer.parseInt(o1);
					int i2 = Integer.parseInt(o2);
					return Integer.compare(i1, i2);
				} catch (Exception e) {
				}
				return (o1 == null || o2 == null) ? 0 : o1.compareTo(o2);
			}
		});
		
		for(ClassVO vo : clzz){
			List<ClassVO> clist = res.get(vo.getGradeId());
			if(clist == null){
				clist = new ArrayList<ClassVO>();
				res.put(vo.getGradeId(), clist);
			}
			clist.add(vo);
		}
		
		return res;
	}
	
	public List<ClassVO> getClassesBySchoolId(String schoolId){
		return getClassesBySchoolId(schoolId, null);
	}
	
	public List<ClassVO> getClassesBySchoolId(String schoolId, String cityId){
		XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setSchoolId(schoolId);
		QryBatchClassResponse classResponse = doRequest(QRY_BATCH_CLASS ,rb, QryBatchClassResponse.class);
		
		List<ClassVO> list = new ArrayList<ClassVO>();
		List<QryBatchClassResponse.ClassList> classList = classResponse.getClassList();
		for(QryBatchClassResponse.ClassList classes : classList){
			List<QryBatchClassResponse.ClassList.ClassEntity> classEntities = classes.getClassEntity();
			for(QryBatchClassResponse.ClassList.ClassEntity classEntity : classEntities){
				ClassVO vo = new ClassVO();
				//BeanUtils.copyProperties(classEntity, vo);
				vo.setBank(classEntity.getBank());
				vo.setClassId(classEntity.getClassId());
				vo.setClassName(classEntity.getClassName());
				vo.setClassType(classEntity.getClassType());
				vo.setGradeId(classEntity.getGradeId());
				vo.setGradeName(classEntity.getGradeName());
				vo.setSchoolId(schoolId);
				vo.setCityId(cityId);
				
				list.add(vo);
			}
		}
		
		return list;
	}
	
	/**
	 * 根据学校查询所有老师
	 * 
	 * @param rb
	 * @return
	 */
	public List<TeacherVO> getTeachersBySchool(String schoolId, String cityId){
		XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setSchoolId(schoolId);
		QrySchoolTeacherResponse o = doRequest(QRY_SCHOOL_TEACHER, rb, QrySchoolTeacherResponse.class);
		List<QrySchoolTeacherResponse.Relations> rs = o.getRelations();
		List<TeacherVO> teachers = new ArrayList<TeacherVO>();
		for(QrySchoolTeacherResponse.Relations r : rs){
			List<SchoolTeacherRelation> trs = r.getSchoolTeacherRelation();
			for(SchoolTeacherRelation str : trs){
				TeacherVO vo = new TeacherVO();
				
				vo.setEmail(str.getEMail());
				vo.setHeadImage(str.getHeadImage());
				vo.setLoginName(str.getLoginName());
				vo.setSchoolId(str.getSchoolId());
				vo.setTeacherId(str.getTeacherId());
				vo.setTeacherName(str.getUserName());
				vo.setCityId(cityId);
				
				teachers.add(vo);
			}
		}
		return teachers;
	}
	
	public List<TeacherVO> getTeachersBySchool(String schoolId){
		return getTeachersBySchool(schoolId, null);
	}
	
	
	public List<TeacherVO> getTeachersByClassId(String classId){
		XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setClassId(classId);
		QryClassTeacherResponse o = doRequest(QRY_CLASS_TEACHER, rb, QryClassTeacherResponse.class);
		List<com.istudy.server.common.protocol.ws.xxt.vo.QryClassTeacherResponse.Relations> rs = o.getRelations();
		List<TeacherVO> teachers = new ArrayList<TeacherVO>();
		for(com.istudy.server.common.protocol.ws.xxt.vo.QryClassTeacherResponse.Relations r : rs){
			List<ClassTeacherRelation> trs = r.getClassTeacherRelation();
			for(ClassTeacherRelation ctr : trs){
				TeacherVO vo = new TeacherVO();
				vo.setTeacherId(ctr.getTeacherId());
				vo.setTeacherName(ctr.getUserName());
				vo.setLoginName(ctr.getLoginName());
				vo.setEmail(ctr.getEMail());
				vo.setClassId(classId);
				
				List<SubjectList> slist = ctr.getSubjectList();
				if(slist != null && !slist.isEmpty()){
					List<SubjectVO> list = new ArrayList<SubjectVO>();
					
					List<SubjectList> subjectLists = ctr.getSubjectList();
					for(SubjectList subjectList : subjectLists){
						for(Subject subject : subjectList.getSubject()){
							SubjectVO subvo = new SubjectVO(subject.getSubjectId(), subject.getSubjectName());
							list.add(subvo);
						}
					}
					
					vo.setSubjects(list);
				}
				
				teachers.add(vo);
			}
		}
		return teachers;
	}
	
	public TeacherVO getTeachersById(String cityId, String teacherId){
		XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setCityId(cityId);
		rb.setUserId(teacherId);
		QryTeacherInfoResponse o = doRequest(QRY_TEACHER_INFO, rb, QryTeacherInfoResponse.class);
		
		TeacherVO vo = new TeacherVO();
		vo.setTeacherId(o.getUserId());
		vo.setTeacherName(o.getUserName());
		vo.setLoginName(o.getLoginName());
		vo.setSex(o.getSex());
		vo.setCityId(cityId);
		vo.setSchoolId(o.getSchoolId());
		vo.setRoleId(o.getRoleId());
		vo.setRoleName(o.getRoleName());
		
		return vo;
	}
	
	public SchoolVO getSchoolById(String schoolId){
		XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setSchoolId(schoolId);
		QrySchoolResponse o = doRequest(QRY_SCHOOL, rb, QrySchoolResponse.class);
		
		SchoolVO vo = new SchoolVO();
		vo.setAreaId(o.getAreaId());
		vo.setAreaName(o.getAreaName());
		vo.setCityId(o.getCityId());
		vo.setSchoolId(o.getSchoolId());
		vo.setSchoolName(o.getSchoolName());
		vo.setSection(o.getSection());
		vo.setTownId(o.getTownId());
		vo.setTownName(o.getTownName());
		
		return vo;
	}
	
	/**
	 * 通过手机号和学生姓名验证
	 * @param phone
	 * @param stuName
	 * @return
	 */
	public StudentVO checkParentHf(String phone, String stuName){
		XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setPhone(phone);
		rb.setStuUserName(stuName);
		ChkParentHfResponse res = doRequest(CHK_PARENT_HF, rb, ChkParentHfResponse.class);
		StudentVO vo = new StudentVO();
		BeanUtils.copyProperties(res, vo, "parents");
		vo.setStudentName(res.getStuUserName());
		
		ParentVO pvo = new ParentVO();
		pvo.setParentId(res.getParentId());
		pvo.setParentName(res.getParUserName());
		vo.getParents().add(pvo);
		
		return vo;
	}

	private <T> T doRequest(String method, XXTWSRequestBody rb, Class<T> clz) {
		Response res = XXTServiceMain.requestXXT(method ,rb.toXML());
		String body = res.getBody();
		return XXTServiceMain.parseToBean(body,clz);
	}
	
	public String createShortUrl(String url){
		String requestUrl = "http://api.t.sina.com.cn/short_url/shorten.json?source=1146580825&url_long=" + url.toString();
		String rs = HttpUtils.doGet(requestUrl, "", String.class);
		Matcher mc = Pattern.compile("\\[\\{\"url_short\":\"([^\"]+)").matcher(rs);
		if(mc.find()){
		return mc.group(1);
		}else{
			return url;
		}

	
	}
	
	public static void main(String[] args) {
		System.out.println(3%3);
/*		广州市：广州市第17中学（39443）、广州市第113中学（38290）


		佛山市：顺德华侨中学（41536）


		东莞市：东莞南城高级中学（123814）


		河源市：河源中学（87855）


		揭阳市：揭阳华侨中学（28452）


		肇庆市：端州中学（32436）、四会华侨中学（32597）*/
		
		XXTWSRequestBody rb = new XXTWSRequestBody();
		
		rb.setSchoolId("32597");
		
		Response res = null;
		
		QrySchoolResponse res1 = null;
		
		
		res = XXTServiceMain.requestXXT(QRY_SCHOOL, rb.toXML());
		
		String body = res.getBody();
		
		res1 = XXTServiceMain.parseToBean(body,QrySchoolResponse.class);
		
		System.out.println(res);
		System.out.println(res1.getAreaName()+","+res1.getSchoolName()+","+res1.getTownName());
		

		/*String url1 = CMSConstants.DOMAIN_NAME + "xxtTask/showTaskPage.do?taskId=153";
		rb.setMessageType("1");
		rb.setUserType("1");
		rb.setTitle("家长无忧");
		rb.setMessageURL(url1);
		rb.setMessageContent("");
		rb.setIsOauth("1");
		rb.setValidDate("2014-06-26 09:00:00");
		SendOEMResult result = doRequest("SEND_OEM_GRP_MESSAGE", rb, SendOEMResult.class);
		res = XXTServiceMain.requestXXT(QRY_SCHOOL, rb.toXML());
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*String driver = "com.mysql.jdbc.Driver";
		
		String url = "jdbc:mysql://10.0.0.170:3306/istudy_cms_dev?useUnicode=true&amp;characterEncoding=utf8&amp;autoReconnect=true&amp;failOverReadOnly=false";
		
		String user = "istudy";

		String password = "istudy";
		
		try {

			// 加载驱动程序

			Class.forName(driver);

			// 连续数据库

			Connection conn = DriverManager.getConnection(url, user, password);

			if(!conn.isClosed())

			System.out.println("Succeeded connecting to the Database!");

			// statement用来执行SQL语句

			Statement statement = conn.createStatement();

			// 要执行的SQL语句

			String sql = "select * from cms_login_info";
			
			ResultSet rs = statement.executeQuery(sql);
			
			System.out.println("-----------------");
			
			System.out.println("执行结果如下所示:");  
			
			System.out.println("-----------------");
			while(rs.next()) {
			System.out.println(rs.getString(2));
			}
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}*/
		
		
	}


	public XXTGetTasksParamVO getMessagebyToken(String token, XXTGetTasksParamVO gtp) {
		// TODO Auto-generated method stub
		XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setToken(token);
		ChkOauth res = doRequest(CHK_OAUTH,rb,ChkOauth.class);
		gtp.setUserId(res.getUserId());
		gtp.setCityId(res.getCityId());
		return gtp;
	}

	public void deleteCMSTaskByMsgId(CMSTaskVO dtv) {
		// TODO Auto-generated method stub
		XXTWSRequestBody rb = new XXTWSRequestBody();
		//rb.setOthMsgId(dtv.getMsgId());
		List<String> msgIdList = new ArrayList<String>();
		rb.setReason(dtv.getReason());
		String[] msgId = dtv.getMsgId().split(",");
		for(int i = 0 ; i < msgId.length ; i++){
			String[] ids = msgId[i].split("_");
			if(!ids[0].equals("del")){
				rb.setOthMsgId(msgId[i]);
				try{
					SendOEMResult result = doRequest("DEL_OEM_MESSAGE", rb, SendOEMResult.class);
					if("200".equals(result.getResult())){
						String mid = "del_" + msgId[i];
						msgIdList.add(mid);
						continue;
						//update msgId
						
					}else{
						
						msgIdList.add(msgId[i]);
						continue;
					}
				}catch(Exception e){
					e.printStackTrace();
					msgIdList.add(msgId[i]);
					continue;
				}
			}
		}
		dtv.setMsgId(CommonUtils.delHeadAndLashChar(msgIdList.toString()).replace(" ", ""));
		this.xxtTaskService.updateCMSTaskInfo1(dtv);
		
		
		
	}

	public ChkOauth chkOAuth(String token) {
		XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setToken(token);
		return doRequest(CHK_OAUTH,rb,ChkOauth.class);
	}
	
	public XXTTeacherAuthVO getTeacherAuthByToken(String token){
		ChkOauth auth = null;
		try {
			auth = chkOAuth(token);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.L.error("通过Token查询登陆身份信息失败，重试一次！");
			auth = chkOAuth(token);
		}
		
		if(!"1".equals(auth.getRoleType())){
			return null;
		}
		XXTTeacherAuthVO vo = new XXTTeacherAuthVO();
		vo.setCityId(auth.getCityId());
		vo.setUserId(auth.getUserId());
		vo.setUserName(auth.getUserName());
		vo.setRoleType(auth.getRoleType());
		vo.setSchoolId(auth.getSchoolId());
		
		TeacherVO teacherBaseInfo = null;
		try {
			teacherBaseInfo = getTeachersById(auth.getCityId(), auth.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.L.error("获取老师基本信息失败，重试一次！");
			teacherBaseInfo = getTeachersById(auth.getCityId(), auth.getUserId());
		}
		
		vo.setRoleId(teacherBaseInfo.getRoleId());
		vo.setRoleName(teacherBaseInfo.getRoleName());
		
		List<String> grades = new ArrayList<String>();
		vo.setGrades(grades);
		
		List<ClassVO> teaClzList = null;
		try {
			teaClzList = getClassesByTeacher(auth.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.L.error("通过老师获取班级信息失败，重试一次！");
			try {
				teaClzList = getClassesByTeacher(auth.getUserId());
			} catch (Exception e2) {
				LogUtils.L.error("老师["+auth.getUserId()+"]获取不到任何班级");
			}
		}
		
		if(!CommonUtils.isNull(teaClzList)){
			List<ClassVO> allClzList = null;
			try {
				allClzList = getClassesBySchoolId(auth.getSchoolId());
			} catch (Exception e) {
				e.printStackTrace();
				LogUtils.L.error("通过学校获取班级信息失败，重试一次！");
				allClzList = getClassesBySchoolId(auth.getSchoolId());
			}
			
			for(ClassVO clz : allClzList){
				for(ClassVO teaClz : teaClzList){
					if(clz.getClassId().equals(teaClz.getClassId())){
						String bank = clz.getBank();
						if(!grades.contains(bank)){
							grades.add(bank);
						}
					}
				}
			}
		}
		
		
		
		
		return vo;
	}

}
