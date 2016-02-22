package com.istudy.server.xxt.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.validate.annotation.ValidatingField;
import com.istudy.server.common.validate.annotation.Validation;
import com.istudy.server.common.vo.ResultVO;
import com.istudy.server.xxt.facade.MinisiteUserActionStatFacade;
import com.istudy.server.xxt.facade.XXTMinisiteFacade;
import com.istudy.server.xxt.vo.AutoRptVO;
import com.istudy.server.xxt.vo.BookVO;
import com.istudy.server.xxt.vo.QuesVO;
import com.istudy.server.xxt.vo.ReportInputVO;
import com.istudy.server.xxt.vo.UserActionRecordPhoneRelaVO;
import com.istudy.server.xxt.vo.XXTRegisterRecordVO;
import com.istudy.server.xxt.vo.XXTSubjectChooseAccount;

@Controller
@RequestMapping("/xxtM/")
public class XXTMnisiteController {
	@Autowired
	private XXTMinisiteFacade xxtMinisiteFacade;
	
	@Autowired
	private MinisiteUserActionStatFacade minisiteUserActionStatFacade;
	
	@RequestMapping(value = "{uri}", method = RequestMethod.GET)
	public String showMinistePageShort(@PathVariable("uri") String uri) {
		return "xxt/minisite/" + uri;
	}
	
	@RequestMapping(value = "mPage", method = RequestMethod.GET)
	public ModelAndView previewMinisitePage(String uri,final String previewSms){
		return new ModelAndView("xxt/minisite/" + uri,new HashMap<String, Object>() {
			{
				put("previewSms", previewSms);
			}
		});
		
	}
	
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}", method = RequestMethod.GET)
	public String showMinistePageWithUserInfo(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
		model.addAttribute("catalog", "xxtM");
		model.addAttribute("userid", userid);
		return "xxt/minisite/" + miniUri;
	}
	
/*	@RequestMapping(value = "mPage", method = RequestMethod.GET)
	public String showMinistePage(String uri) {
		return "xxt/minisite/" + uri;
	}*/

	@RequestMapping(value = "showScoreReport1", method = RequestMethod.GET)
	public ModelAndView showScoreReport1(final String sId) {
		return new ModelAndView("xxt/xxt_score_analyse_report1", new HashMap<String, Object>() {
			{
				put("sId", sId);
			}
		});
	}

	@RequestMapping(value = "showScoreReport2", method = RequestMethod.GET)
	public ModelAndView showScoreReport2(final String sId, final String type) {
		return new ModelAndView("xxt/xxt_score_analyse_report2", new HashMap<String, Object>() {
			{
				put("sId", sId);
				put("type", type);
			}
		});
	}
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public void test(HttpServletResponse res){
		try {
			res.sendRedirect("/www.bing.com");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "showMockExamNoticePage", method = RequestMethod.GET)
	public String showMockExamNotice() {
		return "xxt/xxt_mock_exam_analyse_subject_notice";
	}
	
	@RequestMapping(value = "showMockExamAuthValidPage", method = RequestMethod.GET)
	public String showMockExamAuthValidPage() {
		return "xxt/xxt_mock_exam_auth_valid";
	}
	
	@Validation({
		@ValidatingField(name = "phoneNum", max = 11, notNull = true),
		@ValidatingField(name = "stuName", max = 32, notNull = true)})
	@RequestMapping(value = "mockExamRegister", method = RequestMethod.POST)
	public ModelAndView mockExamRegister(
			@RequestParam("phoneNum") String phoneNum,
			@RequestParam("stuName") String stuName,
			HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("xxt/xxt_mock_exam_subscribe_result");
		mav.addObject("name", stuName);
		XXTRegisterRecordVO recordVO = null;
		if(xxtMinisiteFacade.checkIfRegisteredSuccess(phoneNum)){
			mav.addObject("result", new ResultVO("1",null));
			return mav;
		}
		/*
		 * 暂时不进行验证，接口未到位
		 * try {
			recordVO = xxtRegisterFacade.authValid(phoneNum, stuName);
		} catch (CMSException e) {
			e.printStackTrace();
			mav.addObject("result", new ResultVO("-1", "注册验证过程出错！" + e.getMessage()));
			return mav;
		}*/
		
		recordVO = new XXTRegisterRecordVO();
		recordVO.setPhone(phoneNum);
		recordVO.setStuUserName(stuName);
		ResultVO result = xxtMinisiteFacade.register(recordVO);
		if(!"-1".equals(result.getCode())){
			//记录用户行为对应的手机号
			UserActionRecordPhoneRelaVO relaVO = new UserActionRecordPhoneRelaVO();
			relaVO.setPhone(phoneNum);
			minisiteUserActionStatFacade.addRecordPhoneRela(relaVO, req);
		}
		mav.addObject("result", result);
		return mav;
	}
	
	@RequestMapping(value = "showMockExamPublishTimePage", method = RequestMethod.GET)
	public String showMockExamPublishTimePage() {
		return "xxt/xxt_mock_exam_publish_time";
	}
	
	@RequestMapping(value = "showMockExamReportExamplePage", method = RequestMethod.GET)
	public String showMockExamReportExamplePage() {
		return "xxt/xxt_mock_exam_report_example";
	}
	
	
	/************************针对20140314的用户************************************/
	@RequestMapping(value = "{userid}/{idtype}/{miniUri}", method = RequestMethod.GET)
	public String showArticle(
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		return "xxt/minisite/" + miniUri;
	}
	
	@RequestMapping(value = "{userid}/{idtype}/{miniUri}/subject", method = RequestMethod.GET)
	public String showSubject(
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		return "xxt/xxt_mock_exam_analyse_subject_notice_v2";
	}
	
	@RequestMapping(value = "{userid}/{idtype}/{miniUri}/subjectV3", method = RequestMethod.GET)
	public String showSubjectV3(
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		return "xxt/xxt_mock_exam_analyse_subject_notice_v3";
	}
	
	@RequestMapping(value = "{userid}/{idtype}/{miniUri}/example", method = RequestMethod.GET)
	public String showExample(
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		return "xxt/xxt_mock_exam_report_example_v2";
	}
	
	@RequestMapping(value = "{userid}/{idtype}/{miniUri}/exampleV3", method = RequestMethod.GET)
	public String showExampleV3(
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		return "xxt/xxt_mock_exam_report_example_v3";
	}
	
	@RequestMapping(value = "{userid}/{idtype}/{miniUri}/xxtdownload", method = RequestMethod.GET)
	public String showXXTDownload(
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		return "xxt/xxt_app_download_v2";
	}
	
	@RequestMapping(value = "{userid}/{idtype}/{miniUri}/vedios", method = RequestMethod.GET)
	public String showVedios(
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		return "xxt/xxt_mock_exam_vedios_4msg";
	}
	
	@RequestMapping(value = "{userid}/{idtype}/{miniUri}/vedios4app", method = RequestMethod.GET)
	public String showVedios4App(
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		return "xxt/xxt_mock_exam_vedios_4xxtapp";
	}
	
	@RequestMapping(value = "{userid}/{idtype}/{miniUri}/{subject}/play", method = RequestMethod.GET)
	public String showVediosPlay(
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			@PathVariable("subject") String subject,
			Model model) {
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		model.addAttribute("subject", subject);
		return "xxt/xxt_mock_exam_vedios_play";
	}
	
	@RequestMapping(value = "{userid}/{idtype}/{miniUri}/{subject}/playlist", method = RequestMethod.GET)
	public String showVediosPlayList(
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			@PathVariable("subject") String subject,
			Model model) {
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		model.addAttribute("subject", subject);
		return "xxt/xxt_mock_exam_video_play_list";
	}
	
	
	
	/**********一模分析报告相关**********/
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/input", method = RequestMethod.GET)
	public String showInputPage(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			HttpServletRequest req,
			Model model) {
		model.addAttribute("cityId", cityId);
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		model.addAttribute("realName", xxtMinisiteFacade.getRealNameFromCookie(req));
		
		if("gz".equals(cityId)){
			return "xxt/xxt_mock_exam_report_input";
		}else{
			return "xxt/xxt_mock_exam_report_input_score";
		}
	}
	
	
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/scoreinput", method = RequestMethod.GET)
	public String showScoreInputPage(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
		model.addAttribute("cityId", cityId);
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		return "xxt/xxt_mock_exam_report_input_score";
	}
	
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/matcher", method = RequestMethod.POST)
	public String showMatcherPage(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			ReportInputVO inputVo,
			HttpServletRequest req,
			HttpServletResponse res,
			Model model)  {
		model.addAttribute("cityId", cityId);
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		model.addAttribute("inputVo", inputVo);
		
		String clientIp = getClientIp(req);
		inputVo.setUserIP(clientIp);
		
		xxtMinisiteFacade.saveInputIntoCookie(inputVo, res);
		
		ResultVO result = xxtMinisiteFacade.matcher(inputVo, model);
		if("-1".equals(result.getCode())){
			model.addAttribute("errorMsg", "请求发送错误，请尝试重试！");
			return showInputPage(cityId,userid,idtype,miniUri,req, model);
		}else if("0".equals(result.getCode())){
			return "xxt/xxt_mock_exam_report_result";
		}else{
			return "xxt/xxt_mock_exam_report_matcher";
		}
	}
	
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/resultnomc", method = RequestMethod.POST)
	public String showNoMatcherResultPage(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			ReportInputVO inputVo,
			HttpServletRequest req,
			Model model) {
		model.addAttribute("cityId", cityId);
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		model.addAttribute("action", "page-enter-report-result-nomc");
		model.addAttribute("inputVo", inputVo);
		
		String ticketNo = getTenBitTicketNoByUserid(userid);
		inputVo.setTicketNo(ticketNo);
		inputVo.setRealName("非广州");
		
		String clientIp = getClientIp(req);
		inputVo.setUserIP(clientIp);
		
		ResultVO result = xxtMinisiteFacade.createReportByScore(inputVo, model);
		if("-1".equals(result.getCode())){
			model.addAttribute("errorMsg", "请求发送错误，请尝试重试！");
			return showScoreInputPage(cityId,userid,idtype,miniUri, model);
		}else {
			return "xxt/xxt_mock_exam_report_result";
		}
	}
	
	
	
	
	/*******************变式题相关*********************/
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/index", method = RequestMethod.GET)
	public String showVariableIndexPage(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
		model.addAttribute("cityId", cityId);
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		
		return "xxt/xxt_variable_title_index";
	}
	
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/index4app", method = RequestMethod.GET)
	public String showVariableIndex4AppPage(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
		model.addAttribute("cityId", cityId);
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		
		return "xxt/xxt_variable_title_index4app";
	}
	
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/varinput", method = RequestMethod.GET)
	public String showVariableInputPage(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			HttpServletRequest req,
			Model model) {
		model.addAttribute("cityId", cityId);
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		model.addAttribute("realName", xxtMinisiteFacade.getRealNameFromCookie(req));
		
		if("gz".equals(cityId)){
			return "xxt/xxt_variable_title_input";
		}else{
			return "xxt/xxt_variable_title_input_score";
		}
	}
	
	
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/varscoreinput", method = RequestMethod.GET)
	public String showVariableScoreInputPage(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
		model.addAttribute("cityId", cityId);
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		return "xxt/xxt_variable_title_input_score";
	}
	
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/varmatcher", method = RequestMethod.POST)
	public String showVariableMatcherPage(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			ReportInputVO inputVo,
			HttpServletRequest req,
			HttpServletResponse res,
			Model model)  {
		model.addAttribute("cityId", cityId);
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		model.addAttribute("inputVo", inputVo);
		
		String clientIp = getClientIp(req);
		inputVo.setUserIP(clientIp);
		
		xxtMinisiteFacade.saveInputIntoCookie(inputVo, res);
		
		ResultVO result = xxtMinisiteFacade.matcher(inputVo, model);
		if("-1".equals(result.getCode())){
			model.addAttribute("errorMsg", "请求发送错误，请尝试重试！");
			return showVariableInputPage(cityId,userid,idtype,miniUri,req, model);
		}else if("0".equals(result.getCode())){
			return "xxt/xxt_variable_title_result";
		}else{
			return "xxt/xxt_variable_title_matcher";
		}
	}
	
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/varresultnomc", method = RequestMethod.POST)
	public String showVariableNoMatcherResultPage(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			ReportInputVO inputVo,
			HttpServletRequest req,
			Model model) {
		model.addAttribute("cityId", cityId);
		model.addAttribute("userid", userid);
		model.addAttribute("idtype", idtype);
		model.addAttribute("uri", miniUri);
		model.addAttribute("action", "page-enter-bst-result-nomc");
		model.addAttribute("inputVo", inputVo);
		
		String ticketNo = getTenBitTicketNoByUserid(userid);
		inputVo.setTicketNo(ticketNo);
		inputVo.setRealName("非广州");
		
		String clientIp = getClientIp(req);
		inputVo.setUserIP(clientIp);
		
		ResultVO result = xxtMinisiteFacade.createReportByScore(inputVo, model);
		if("-1".equals(result.getCode())){
			model.addAttribute("errorMsg", "请求发送错误，请尝试重试！");
			return showVariableScoreInputPage(cityId,userid,idtype,miniUri, model);
		}else {
			return "xxt/xxt_variable_title_result";
		}
	}
	
	
	/************文理分科相关*********************/
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/subjectChoose", method = RequestMethod.GET)
	public String showSubjectChoosePage(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri){
		if(idtype == 15){
			return "xxt/xxt_subject_choose_index4app";
		}
		return "xxt/xxt_subject_choose_index";
	}
	
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/subjectChooseSubscribe", method = RequestMethod.GET)
	public String showSubjectChooseSubscribePage(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			@CookieValue(value="cms_wlfk_username", required=false) String username,
			@CookieValue(value="cms_wlfk_pwd", required=false) String password,
			Model model){
		if(CommonUtils.isNull(username) || CommonUtils.isNull(password)){
			model.addAttribute("hasAccount", xxtMinisiteFacade.hasSubjectChooseSubscribeAccount());
			return "xxt/xxt_subject_choose_subscribe";
		}
		return "xxt/xxt_subject_choose_subscribe_result";
	}
	
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/doSubjectChooseAccount", method = RequestMethod.GET)
	public String doSubjectChooseAccount(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			@RequestParam("phone") String phone,
			@CookieValue(value="uuid", required=false) String uuid,
			@CookieValue(value="cms_wlfk_username", required=false) String username,
			@CookieValue(value="cms_wlfk_pwd", required=false) String password,
			HttpServletResponse res,
			Model model){
		
		if(CommonUtils.isNull(username) || CommonUtils.isNull(password)){
			XXTSubjectChooseAccount acct = xxtMinisiteFacade.getSubjectChooseSubscribeAccount(phone, uuid);
			if(acct != null){
				model.addAttribute("isNew", true);
				xxtMinisiteFacade.saveAccount2Cookie(acct.getUsername(), acct.getPassword(), res);
			}else{
				model.addAttribute("hasAccount", false);
				return "xxt/xxt_subject_choose_subscribe";
			}
			model.addAttribute("acct", acct);
		}
		
		return "xxt/xxt_subject_choose_subscribe_result";
	}
	
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/doSubjectChooseSubscribe", method = RequestMethod.GET)
	public String doSubjectChooseSubscribe(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			@RequestParam("phone") String phone,
			@CookieValue(value="uuid", required=false) String uuid,
			Model model){
		XXTSubjectChooseAccount acct = new XXTSubjectChooseAccount();
		acct.setPhone(phone);
		acct.setUuid(uuid);
		xxtMinisiteFacade.saveSubjectChooseSubscribe(acct);
		
		model.addAttribute("isSubscribe", true);
		return "xxt/xxt_subject_choose_subscribe_result";
	}
	
	
	private String getTenBitTicketNoByUserid(String userid) {
		String prefix = "88";
		String rnd = (Math.random() + "").replace("0.", "") + "00000000";
		return prefix + rnd.substring(0, 8);
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
	//高考备考策略
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/testStrategy", method = RequestMethod.GET)
	public String testStrategy(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
	
				return "xxt/xxt_testStrategy";
		
	}
	
	
	//校讯通APP公共账号，高一文理分科视频
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/subjectChooseVideo", method = RequestMethod.GET)
	public String subjectChooseVideo(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
	
				return "xxt/xxt_subject_choose_video";
		
	}
	
	//高三临门一脚
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/onefoot", method = RequestMethod.GET)
	public String oneFoot(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
	
				return "xxt/xxt_onefoot";
		
	}
	
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/{subject}/onefootplay", method = RequestMethod.GET)
	public String oneFootPlay(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			@PathVariable("subject") String subject,
			Model model) {
	
				return "xxt/xxt_onefoot_play";
		
	}
	
	//高中生涯结束，职业生涯开始！
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/book", method = RequestMethod.GET)
	public String book(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
	
				return "xxt/xxt_wish_book";
		
	}
	
	@RequestMapping(value = "book", method = RequestMethod.POST)
	@ResponseBody
	public BookVO bookByPhone(String phone){
		BookVO book = this.xxtMinisiteFacade.bookByPhone(phone);
		return book;
		
	}
	
	//我的同学去哪儿？
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/wheremyclassmate", method = RequestMethod.GET)
	public String whereMyClassmate(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
	
				return "xxt/xxt_where_my_classmate";
		
	}
	
	//2014高考志愿填报专业热度排行榜
	@RequestMapping(value = "{cityId}/{userid}/{idtype}/{miniUri}/subrank", method = RequestMethod.GET)
	public String subjectRank(
			@PathVariable("cityId") String cityId,
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model) {
	
				return "xxt/xxt_subject_rank";
		
	}
	
	
	@RequestMapping(value = "book1", method = RequestMethod.POST)
	@ResponseBody
	public BookVO book1ByPhone(BookVO book1){
		BookVO book = this.xxtMinisiteFacade.bookByPhone(book1.getPhone());
		System.out.println(book1.getIdType());
		System.out.println(book1.getPhone());
		this.minisiteUserActionStatFacade.saveBooksPhone(book1);
		return book;
		
	}
	
	@RequestMapping(value = "book2")
	@ResponseBody
	public BookVO bookById(
			HttpServletRequest request,
			@RequestParam String userid,@RequestParam String cityId){
		BookVO book = this.xxtMinisiteFacade.bookById(userid, cityId, getClientIp(request));
		return book;
	}
	
	
	@RequestMapping(value = "rptauto" , method = RequestMethod.POST)	
	public ModelAndView getRptAuto(HttpServletRequest req,String postIds,String titles,String idtype,String channels,String[] test,File[] files) throws UnsupportedEncodingException{
		titles = new String(titles.getBytes("iso8859-1"),"UTF-8");
		System.out.println(postIds + "," + titles + "," + idtype + "," + channels + "," + test[0] + "," + test[1] + "," + test[2] + "," + files[0].getName() + "," + files[1].getName());
		if(files == null){
			System.out.println("null");
		}
		List<AutoRptVO> rpt = minisiteUserActionStatFacade.getRptAuto(postIds,titles,idtype,channels);
		LogUtils.log(rpt + "");
		return new ModelAndView("xxt/xxt_rpt_auto", "rpt", rpt);
	}
	
	@RequestMapping(value = "getAutoPage", method = RequestMethod.GET)
	public String getAutoPage() {
				return "xxt/get_rpt_page";
		
	}
	
	@RequestMapping(value = "saveQues", method = RequestMethod.POST)
	public String saveQues(QuesVO qv) {
		this.xxtMinisiteFacade.saveQues(qv);
		return "success";
	}
	
}
