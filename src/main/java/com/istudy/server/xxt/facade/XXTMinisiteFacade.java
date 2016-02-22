package com.istudy.server.xxt.facade;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.jaxrs.ext.form.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.istudy.server.common.constants.XXTConstants;
import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.utils.HttpUtils;
import com.istudy.server.common.utils.JsonUtils;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.vo.ResultVO;
import com.istudy.server.xxt.service.XXTMinisiteService;
import com.istudy.server.xxt.service.XXTRegisterService;
import com.istudy.server.xxt.vo.BookVO;
import com.istudy.server.xxt.vo.QuesVO;
import com.istudy.server.xxt.vo.ReportInputVO;
import com.istudy.server.xxt.vo.ReportResultVO;
import com.istudy.server.xxt.vo.ReportResultVO.Report;
import com.istudy.server.xxt.vo.ReportResultVO.ScoreDict;
import com.istudy.server.xxt.vo.ReportResultVO.ScoreSpace;
import com.istudy.server.xxt.vo.ReportResultVO.StudentInfo;
import com.istudy.server.xxt.vo.XXTRegisterRecordVO;
import com.istudy.server.xxt.vo.XXTRegisterRequestVO;
import com.istudy.server.xxt.vo.XXTRegisterResultVO;
import com.istudy.server.xxt.vo.XXTSubjectChooseAccount;
import com.mysql.jdbc.StringUtils;

@Service("xxtMinisiteFacade")
public class XXTMinisiteFacade {
	
	@Autowired
	private XXTRegisterService xxtRegisterService;
	
	@Autowired
	private XXTMinisiteService XXTMinisiteService;
	
	@Transactional(rollbackFor=Exception.class)
	public boolean checkIfRegisteredSuccess(String phone){
		List<XXTRegisterRecordVO> recordList = xxtRegisterService.findRegisterRecord(phone);
		boolean successFlag = false;
		if(recordList.size() > 0){
			for(XXTRegisterRecordVO item : recordList){
				Integer status = item.getStatus();
				if(status == 0){
					xxtRegisterService.invalidRegisterRecord(item.getId());
				}else if(status == 1){
					successFlag = true;
				}
			}
		}
		return successFlag;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public XXTRegisterRecordVO authValid(String phone, String stuName){
		//LogUtils.L.info("请求校讯通身份验证接口:"+);
		//TODO CMSS验证接口
		//LogUtils.L.info("请求校讯通身份验证接口返回:");
		XXTRegisterRecordVO record = new XXTRegisterRecordVO();
		record.setPhone(phone);
		record.setStuUserName(stuName);
		//record.setSchoolName("测试中学");
		//record.setGradeId(12);
		xxtRegisterService.saveRegisterRecord(record);
		return record;
		
	}
	
	@Transactional(rollbackFor=Exception.class)
	public ResultVO register(XXTRegisterRecordVO record){
		XXTRegisterRequestVO requestVO = new XXTRegisterRequestVO();
		requestVO.setMobile(record.getPhone());
		requestVO.setTrueName(record.getStuUserName());
		//requestVO.setGrade(record.getGradeId() + "");
		//requestVO.setSchool(record.getSchoolName());
		
		Form body = requestVO.getParamForm();
		LogUtils.L.info("请求广一模预告注册接口:"+body);
		String reponseString = HttpUtils.doPost(XXTConstants.XXT_MOCKEXAM_REGISTER_SYSTEM_URL , "",body , String.class);
		LogUtils.L.info("请求广一模预告注册接口返回:" + reponseString);
		
		if(StringUtils.isNullOrEmpty(reponseString)){
			return new ResultVO("-1","注册请求失败");
		}
		XXTRegisterResultVO result = JsonUtils.toObj(reponseString, XXTRegisterResultVO.class);
		if("1".equals(result.getCode()) || "2".equals(result.getCode())){
			xxtRegisterService.updateRegisterRecordStatus(record.getId());
			
			return new ResultVO(result.getCode(),null);
		}else{
			return new ResultVO("-1",result.getMsg());
		}
		
	}
	
	
	/********** 一模分析报告 
	 * @param model *********/
	public ResultVO matcher(ReportInputVO inputVo, Model model){
		Form body = inputVo.getMatcherForm();
		
		LogUtils.L.info("请求一模分析报告匹配接口:"+body);
		try {
			long begin = System.currentTimeMillis();
			String reponseString = HttpUtils.doPost(XXTConstants.XXT_MOCKEXAM_REPORT_SYSTEM_URL , "",body , String.class);
			LogUtils.L.info("请求一模分析报告匹配接口返回:" + reponseString);
			long cost = System.currentTimeMillis() - begin;
			if(StringUtils.isNullOrEmpty(reponseString)){
				return new ResultVO("-1","学生考号、姓名匹配失败！");
			}
			ReportResultVO result = JsonUtils.toObj(reponseString, ReportResultVO.class);
			String code = result.getCode();
			if("0".equals(code)){
				model.addAttribute("cost", "-cost" + cost);
				model.addAttribute("ticketNo", inputVo.getTicketNo());
				arrangeResult(result, model);
				return new ResultVO("0", null);
			}else{
				return new ResultVO("1", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.L.info("请求一模分析报告匹配接口异常:"+e.getMessage());
			return new ResultVO("-1","学生考号、姓名匹配过程发生错误！"); 
		}
	}


	public ResultVO createReportByScore(ReportInputVO inputVo, Model model) {
		
		Form body = inputVo.getNoMatcherScoreForm();
		
		LogUtils.L.info("请求一模分析报告手动提交成绩接口:"+body);
		try {
			long begin = System.currentTimeMillis();
			String reponseString = HttpUtils.doPost(XXTConstants.XXT_MOCKEXAM_REPORT_SYSTEM_URL , "",body , String.class);
			LogUtils.L.info("请求一模分析报告手动提交成绩接口返回:" + reponseString);
			long cost = System.currentTimeMillis() - begin;
			if(StringUtils.isNullOrEmpty(reponseString)){
				return new ResultVO("-1","手动提交成绩失败！");
			}
			ReportResultVO result = JsonUtils.toObj(reponseString, ReportResultVO.class);
			String code = result.getCode();
			if("0".equals(code)){
				model.addAttribute("cost", "-cost" + cost);
				model.addAttribute("ticketNo", inputVo.getTicketNo());
				arrangeResult(result, model);
				return new ResultVO("0", null);
			}else{
				return new ResultVO("1", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.L.info("请求一模分析报告手动提交成绩接口异常:"+e.getMessage());
			return new ResultVO("-1","请求一模分析报告手动提交成绩接口过程发生错误！"); 
		}
	}
	
	private void arrangeResult(ReportResultVO result, Model model) {
		List<Report> rpts = result.getResult();
		for(Report rpt : rpts){
			List<StudentInfo> report1 = rpt.getReport1();
			List<ScoreSpace> report2 = rpt.getReport2();
			List<ScoreDict> report3 = rpt.getReport3();
			if(report1 != null){
				arrangeStudentInfo(model, report1);
			}
			
			else if(report2 != null){
				model.addAttribute("scoreSpace", report2);
				arrangeTotalScore(report2, model);
			}
			
			else if(report3 != null){
				arrangeScoreInfo(model, report3);
			}
		}
	}

	private void arrangeTotalScore(List<ScoreSpace> report2, Model model) {
		for(ScoreSpace ss : report2){
			if("12".equals(ss.getSubject_id())){
				ss.setPoint(CommonUtils.formatFloatString(ss.getPoint()));
				model.addAttribute("totalScore", ss);
				break;
			}
		}
	}

	private void arrangeScoreInfo(Model model, List<ScoreDict> report3) {
		sortScoreBySubject(model, report3);
		sortScoreByPoint(model, report3);
	}
	
	private void arrangeStudentInfo(Model model, List<StudentInfo> report1) {
		for(StudentInfo stuInfo : report1){
			Map<String,String> studentMap = new HashMap<String,String>();
			studentMap.put("schoolName", stuInfo.getSchool_name());
			studentMap.put("studentName", stuInfo.getStudent_name());
			studentMap.put("studyType", stuInfo.getStudy_type());
			studentMap.put("studyTypeName", stuInfo.getSubject_name());
			studentMap.put("ticketNo", stuInfo.getTicket_no());
			model.addAttribute("studentMap", studentMap);
		}
	}
	
	

	private void sortScoreByPoint(Model model, List<ScoreDict> report3) {
		List<ScoreDict> subjectList = new ArrayList<ScoreDict>();
		subjectList.addAll(report3);
		Collections.sort(subjectList, new Comparator<ScoreDict>(){
			@Override
			public int compare(ScoreDict o1, ScoreDict o2) {
				String orderPoint1 = o1.getOrder_point();
				String orderPoint2 = o2.getOrder_point();
				try {
					int result = Double.compare(Double.parseDouble(orderPoint2), Double.parseDouble(orderPoint1));
					return result;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return 0;
			}
		});
		model.addAttribute("subjectList", subjectList);
	}

	private void sortScoreBySubject(Model model, List<ScoreDict> report3) {
		List<ScoreDict> scoreList = new ArrayList<ScoreDict>();
		scoreList.addAll(report3);
		Collections.sort(scoreList, new Comparator<ScoreDict>() {
			@Override
			public int compare(ScoreDict o1, ScoreDict o2) {
				String id1 = o1.getSubject_id();
				String id2 = o2.getSubject_id();
				try {
					int result = Integer.compare(Integer.parseInt(id1), Integer.parseInt(id2));
					return result;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return 0;
			};
		});
		for(ScoreDict sd : scoreList){
			sd.setMy_point(CommonUtils.formatFloatString(sd.getMy_point()));
		}
		model.addAttribute("scoreList", scoreList);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public synchronized XXTSubjectChooseAccount getSubjectChooseSubscribeAccount(String phone, String uuid){
		XXTSubjectChooseAccount acct = XXTMinisiteService.nextSubjectChooseSubscribeAccount();
		if(acct != null){
			acct.setPhone(phone);
			acct.setUuid(uuid);
			acct.setState(1);
			XXTMinisiteService.saveSubjectChooseSubscribeAccount(acct);
		}
		return acct;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void saveSubjectChooseSubscribe(XXTSubjectChooseAccount acct){
		XXTMinisiteService.saveSubjectChooseSubscribe(acct);
	}
	
	@Transactional(readOnly=true)
	public boolean hasSubjectChooseSubscribeAccount() {
		return XXTMinisiteService.hasSubjectChooseSubscribeAccount();
	}

	public void saveInputIntoCookie(ReportInputVO inputVo,
			HttpServletResponse res) {
		try {
			Cookie cTicketName = new Cookie("ticketNo", inputVo.getTicketNo());
			Cookie cName = new Cookie("realName", URLEncoder.encode(inputVo.getRealName(),"GBK"));
			cTicketName.setPath("/");
			cName.setPath("/");
			cTicketName.setMaxAge(365 * 24 * 3600);
			cName.setMaxAge(365 * 24 * 3600);
			res.addCookie(cTicketName);
			res.addCookie(cName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getRealNameFromCookie(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if("realName".equals(cookie.getName())){
					try {
						return URLDecoder.decode(cookie.getValue(),"GBK");
					} catch (Exception e) {
					}
				}
			}
		}
		return null;
	}
	
	public void saveAccount2Cookie(String username,String password,
			HttpServletResponse res) {
		try {
			Cookie cUsername = new Cookie("cms_wlfk_username", username);
			Cookie cPassword = new Cookie("cms_wlfk_pwd", password);
			cUsername.setPath("/");
			cPassword.setPath("/");
			cUsername.setMaxAge(365 * 24 * 3600);
			cPassword.setMaxAge(365 * 24 * 3600);
			res.addCookie(cUsername);
			res.addCookie(cPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BookVO bookByPhone(String phone) {
		// TODO Auto-generated method stub
		Form test = new Form();
		String response;
		String uri = "http://isa.istudy.com.cn/common/api/xxt_register.asp";
		String resourceUrl = "";
		test.set("mobile", phone);
		test.set("school", "asd");
		test.set("grade", "12");
		test.set("trueName", "0");
		test.set("motivation", "7");
		test.set("flag", "1");
		test.set("user_ip", "0");
		response = HttpUtils.doPost(uri,resourceUrl,test,String.class);
		BookVO b = JsonUtils.toObj(response, BookVO.class);
		System.out.println(b.getMsg()+","+b.getMotivation_status()+","+b.getU_pwd());
		return b;
	}


	public BookVO bookById(String userid, String cityId, String userIp) {
		Form test = new Form();
		String response;
		String uri = "http://isa.istudy.com.cn/common/api/xxt_reg.asp";
		String resourceUrl = "";
		test.set("user_id", userid);
		test.set("city_id", cityId);
		test.set("school", "");
		test.set("grade", "12");
		test.set("trueName", "0");
		test.set("motivation", "7");
		test.set("flag", "1");
		test.set("user_ip", userIp);
		response = HttpUtils.doPost(uri,resourceUrl,test,String.class);
		BookVO b = JsonUtils.toObj(response, BookVO.class);
		System.out.println(b.getMsg()+","+b.getMotivation_status()+","+b.getU_pwd());
		return b;
	}

	public void saveQues(QuesVO qv) {
		// TODO Auto-generated method stub
		this.XXTMinisiteService.saveQues(qv);
	}

	
}
