package com.istudy.server.xxt.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.vo.ResultVO;
import com.istudy.server.xxt.facade.MinisiteUserActionStatFacade;
import com.istudy.server.xxt.vo.BookVO;
import com.istudy.server.xxt.vo.QuesVO;
import com.istudy.server.xxt.vo.TLBQuesVO;
import com.istudy.server.xxt.vo.UserAction3VO;
import com.istudy.server.xxt.vo.UserActionRecordVO;
import com.istudy.server.xxt.vo.UserActionVO;
import com.istudy.server.xxt.vo.bookInfoVO;

@Controller
@RequestMapping("/xxtStat/")
public class MinisiteUserActionStatController {

	@Autowired
	private MinisiteUserActionStatFacade minisiteUserActionStatFacade;
	
	@RequestMapping("addRecord")
	public void addRecord(UserActionRecordVO vo, HttpServletRequest req,
			HttpServletResponse res) {
		minisiteUserActionStatFacade.addRecord(vo, req, res);
	}
	
	@RequestMapping("addRecordV2")
	public void addRecordV2(UserActionVO vo, HttpServletRequest req,
			HttpServletResponse res) {
		if(CommonUtils.isNull(vo.getMiniUri())){
			return;
		}
		minisiteUserActionStatFacade.addRecordV2(vo, req, res);
	}
	
	@RequestMapping("addRecordV3")
	public void addRecordV3(UserAction3VO vo, HttpServletRequest req,
			HttpServletResponse res) {
		minisiteUserActionStatFacade.addRecordV3(vo, req, res);
	}
	
	@RequestMapping("channelRpt")
	public ModelAndView channelRpt(HttpServletRequest req,String type) throws ParseException{
		Map<String, Object> rpt = this.minisiteUserActionStatFacade.channelRpt(type);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today =format.format(date);
		Date beginDay = format.parse(today);
		Date yesterday = format.parse(today);
		Calendar c = Calendar.getInstance();
		c.setTime(beginDay);
		c.add(Calendar.DATE, -1);
		yesterday = c.getTime();
		c.add(Calendar.DATE, -6);
		beginDay = c.getTime();
		if(type.equals("1")){
			rpt.put("today", today);
		}else if(type.equals("2")){
			rpt.put("yesterday", format.format(yesterday));
		}else if(type.equals("3")){
			rpt.put("today", today);
			rpt.put("beginDay", format.format(beginDay));
		}
		rpt.put("type", type);
		return new ModelAndView("xxt/count_rpt", rpt);
	}
	
	@RequestMapping("bookInfo")
	public ModelAndView bookInfo(HttpServletRequest req,String idtype){
		System.out.println(idtype);
		List<bookInfoVO> lb = this.minisiteUserActionStatFacade.bookInfo(idtype);
		return new ModelAndView("xxt/book_info", "lb", lb);
	}
	
	@RequestMapping("bookInfo2")
	public ModelAndView bookInfo2(HttpServletRequest req,String idtype){
		System.out.println(idtype);
		List<bookInfoVO> lb = this.minisiteUserActionStatFacade.bookInfo2(idtype);
		return new ModelAndView("xxt/book_info2", "lb", lb);
	}
	
	@RequestMapping("bookInfo3")
	public ModelAndView bookInfo3(HttpServletRequest req,String idtype){
		System.out.println(idtype);
		List<bookInfoVO> lb = this.minisiteUserActionStatFacade.bookInfo2(idtype);
		return new ModelAndView("xxt/book_info3", "lb", lb);
	}
	
	@RequestMapping("bookInfo4")
	public ModelAndView bookInfo4(HttpServletRequest req,String idtype){
		System.out.println(idtype);
		List<bookInfoVO> lb = this.minisiteUserActionStatFacade.bookInfo2(idtype);
		return new ModelAndView("xxt/book_info4", "lb", lb);
	}
	
	@RequestMapping("bookInfo5")
	public ModelAndView bookInfo5(HttpServletRequest req,String idtype){
		System.out.println(idtype);
		List<bookInfoVO> lb = this.minisiteUserActionStatFacade.bookInfo2(idtype);
		return new ModelAndView("xxt/book_info5", "lb", lb);
	}
	
	@RequestMapping("bookInfo6")
	public ModelAndView bookInfo6(HttpServletRequest req,String idtype){
		System.out.println(idtype);
		List<bookInfoVO> lb = this.minisiteUserActionStatFacade.bookInfo2(idtype);
		return new ModelAndView("xxt/book_info6", "lb", lb);
	}
	
	@RequestMapping("bookInfo7")
	public ModelAndView bookInfo7(HttpServletRequest req,String idtype){
		System.out.println(idtype);
		List<bookInfoVO> lb = this.minisiteUserActionStatFacade.bookInfo2(idtype);
		return new ModelAndView("xxt/book_info7", "lb", lb);
	}
	
	@RequestMapping("quesInfo")
	public ModelAndView quesInfo(HttpServletRequest req){
		List<QuesVO> lq = this.minisiteUserActionStatFacade.quesInfo();
		return new ModelAndView("xxt/qeus_info", "lq", lq);
	}
	
	@RequestMapping("tlbQuesInfo")
	public ModelAndView tlbQuesInfo(HttpServletRequest req){
		List<QuesVO> lq = this.minisiteUserActionStatFacade.tlbQuesInfo();
		List<TLBQuesVO> lt = new ArrayList<TLBQuesVO>();
		for (QuesVO qv:lq){
			TLBQuesVO tv = new TLBQuesVO();
			String a[] = StringUtils.split(qv.getFirst(),"|");
			
			String b[] = StringUtils.split(qv.getSecond(),"|");
			String c[] = StringUtils.split(qv.getThird(),"|");
			String d[] = StringUtils.split(qv.getFourth(),"|");
			
			String g[] = StringUtils.split(qv.getSeventh(),"|");
			String h[] = StringUtils.split(qv.getEighth(),"|");
			String i[] = StringUtils.split(qv.getNinth(),"|");
			
			
			tv.setName(a[0]);
			tv.setSex(a[1]);
			tv.setBirth(a[2]);
			tv.setId(b[0]);
			tv.setSchool(b[1]);
			tv.setPhone(b[2]);
			tv.setAddress(c[0]);
			tv.setEmail(c[1]);
			tv.setArea(d[0]);
			tv.setCountry(d[1]);
			tv.setType(d[2]);
			tv.setPrize(qv.getFifth());
			tv.setLevel(qv.getSixth());
			tv.setTeacherName(g[0]);
			tv.setTeacherPhone(g[1]);
			tv.setTeacherEmail(g[2]);
			tv.setDance(h[0]);
			tv.setT(h[1]);
			tv.setSelect2(h[2]);
			tv.setProGroup(i[0]);
			tv.setProDance(i[1]);
			tv.setProType(i[2]);
			tv.setProNum(qv.getTenth());
			tv.setSource(qv.getSource());
			tv.setTime(qv.getTime());
			lt.add(tv);
		}
		return new ModelAndView("xxt/tlb_info", "listTLB", lt);
	}
	
	@RequestMapping("countCheck")
	@ResponseBody
	public ResultVO countCheck(@RequestParam("idtypes") String idtypes, 
			@RequestParam("action") String action){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idtypes", idtypes);
		params.put("action", action);
		int statCount = minisiteUserActionStatFacade.getStatCount(params);
		if(statCount > 50){
			return new ResultVO("-1", "");
		}else{
			return new ResultVO("1", "");
		}
	}
	
	
	@RequestMapping("countCheck1")
	@ResponseBody
	public ResultVO countCheck1(@RequestParam("idtypes") String idtypes, 
			@RequestParam("action") String action){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idtypes", idtypes);
		params.put("action", action);
		int statCount = minisiteUserActionStatFacade.getStatCount(params);
		if(statCount >= 25){
			return new ResultVO("-1", "");
		}else{
			return new ResultVO("1", "");
		}
	}
	
	@RequestMapping("rpt")
	public ModelAndView getVariableTitileReport(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getVariableTitileReport();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_variable_title_stat", "rpt", rpt);
	}
	
	@RequestMapping("scrpt")
	public ModelAndView getSubjectChooseReport(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getSubjectChooseReport();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_subject_choose_stat", "rpt", rpt);
	}
	
	@RequestMapping("gkclrpt")
	public ModelAndView getTestStrategyReport(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getTestStrategyReport();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_test_strategy_report", "rpt", rpt);
	}
	
	
	
	@RequestMapping("rpt28to31")
	public ModelAndView getStat28to31(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat28to31();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_28_to31", "rpt", rpt);
	}
	
	@RequestMapping("rpt32to37")
	public ModelAndView getStat32to37(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat32to37();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_32_to37", "rpt", rpt);
	}
	
	@RequestMapping("rpt38to45")
	public ModelAndView getStat38to45(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat38to45();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_38_to45", "rpt", rpt);
	}
	
	@RequestMapping("rpt49")
	public ModelAndView getStat49(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat49();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_49", "rpt", rpt);
	}
	
	@RequestMapping("rpt50")
	public ModelAndView getStat50(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat50();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_50", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt56to65")
	public ModelAndView getStat51to60(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat51to60();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_51_to60", "rpt", rpt);
	}
	
	@RequestMapping("rpt66to67")
	public ModelAndView getStat66to67(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat66to67();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_66_to67", "rpt", rpt);
	}
	
	@RequestMapping("rpt70to81")
	public ModelAndView getStat70to81(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat70to81();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_70_to81", "rpt", rpt);
	}
	
	@RequestMapping("rpt84to86")
	public ModelAndView getStat82to83(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat82to83();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_82_to83", "rpt", rpt);
	}
	
	@RequestMapping("rpt88")
	public ModelAndView getStat88(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat88();
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		Long shareCount = 0L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("短信发送总数", 282247);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率", df.format((openCount / 282247.0) * 100) + "%");				
			}
			else if(i == 3){
				System.out.println(entry.getKey());
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率", df.format((value/ (double)openCount) * 100) + "%");	
			}
			else if(i == 8){
				System.out.println(entry.getKey());
					Long value = Long.parseLong(entry.getValue() + "");
					newRpt.put("分享点击率", df.format((value/ (double)openCount) * 100) + "%");
			}
			
			
			i++;
		}
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_88", "rpt", newRpt);
	}
	
	@RequestMapping("rpt89to105")
	public ModelAndView getStat89to105(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat89to105();
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long x6openCount = 1L;
		Long openCount = 1L;
		Long appOpenCount = 1L;
		Long shareCount = 0L;
		int i = 0;
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("短信发送总数  ", 77128);
			}
			else if(i == 1){
				x6openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信点击率    ", df.format((x6openCount / 77128.0) * 100) + "%");
			}
			else if(i == 8){
				newRpt.put("短信发送总数", 296428);				
			}
			else if(i == 9){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率", df.format((openCount / 296428.0) * 100) + "%");				
			}
			else if(i == 11){
				System.out.println(entry.getKey());
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率", df.format((value/ (double)openCount) * 100) + "%");	
			}
			else if(i == 16){
				System.out.println(entry.getKey());
					Long value = Long.parseLong(entry.getValue() + "");
					newRpt.put("分享点击率", df.format((value/ (double)openCount) * 100) + "%");
			}
			else if( i == 17){
				appOpenCount = Long.parseLong(entry.getValue() + "");
			}
			else if(i == 19){
				System.out.println(entry.getKey());
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率 ", df.format((value/ (double)appOpenCount) * 100) + "%");	
			}
			else if(i == 24){
				System.out.println(entry.getKey());
					Long value = Long.parseLong(entry.getValue() + "");
					newRpt.put("分享点击率 ", df.format((value/ (double)appOpenCount) * 100) + "%");
			}
			
			
			i++;
		}
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_89_to105", "rpt", newRpt);
	}
	
	@RequestMapping("rpt106to108")
	public ModelAndView getStat106to108(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat106to108();
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		Long shareCount = 0L;
		Long openCount1 = 1L;
		Long openCount2 = 1L;
		Long openCount3 = 1L;
		Long openCount4 = 1L;
		Long openCount5= 1L;
		Long shareCount1 = 0L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			//1
			if(i == 0){
				newRpt.put("短信发送总数", 282247);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率", df.format((openCount / 282247.0) * 100) + "%");				
			}
			else if(i == 3){
				System.out.println(entry.getKey());
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率", df.format((value/ (double)openCount) * 100) + "%");	
			}
			else if(i == 8){
				System.out.println(entry.getKey());
					Long value = Long.parseLong(entry.getValue() + "");
					newRpt.put("分享点击率", df.format((value/ (double)openCount) * 100) + "%");
			}
			
			else if( i == 9){
				openCount1 = Long.parseLong(entry.getValue() + "");
			}
			else if(i == 11){
				System.out.println(entry.getKey());
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率 ", df.format((value/ (double)openCount) * 100) + "%");	
			}
			else if(i == 16){
				System.out.println(entry.getKey());
					Long value = Long.parseLong(entry.getValue() + "");
					newRpt.put("分享点击率 ", df.format((value/ (double)openCount) * 100) + "%");
			}
			
			//2
			if(i == 18){
				newRpt.put("短信发送总数 ", 282247);				
			}
			else if(i == 17){
				openCount2 = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率 ", df.format((openCount2 / 282247.0) * 100) + "%");				
			}
			else if(i == 19){
				System.out.println(entry.getKey());
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率  ", df.format((value/ (double)openCount2) * 100) + "%");	
			}
			else if(i == 24){
				System.out.println(entry.getKey());
					Long value = Long.parseLong(entry.getValue() + "");
					newRpt.put("分享点击率  ", df.format((value/ (double)openCount2) * 100) + "%");
			}
			
			
			else if( i == 25){
				openCount3 = Long.parseLong(entry.getValue() + "");
			}
			else if(i == 27){
				System.out.println(entry.getKey());
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率   ", df.format((value/ (double)openCount3) * 100) + "%");	
			}
			else if(i == 32){
				System.out.println(entry.getKey());
					Long value = Long.parseLong(entry.getValue() + "");
					newRpt.put("分享点击率   ", df.format((value/ (double)openCount3) * 100) + "%");
			}
			
			
			//3
			if(i == 34){
				newRpt.put("短信发送总数  ", 282247);				
			}
			else if(i == 33){
				openCount4 = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率  ", df.format((openCount4 / 282247.0) * 100) + "%");				
			}
			else if(i == 35){
				System.out.println(entry.getKey());
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率    ", df.format((value/ (double)openCount4) * 100) + "%");	
			}
			else if(i == 40){
				System.out.println(entry.getKey());
					Long value = Long.parseLong(entry.getValue() + "");
					newRpt.put("分享点击率    ", df.format((value/ (double)openCount4) * 100) + "%");
			}
			
			else if( i == 41){
				openCount5 = Long.parseLong(entry.getValue() + "");
			}
			else if(i == 43){
				System.out.println(entry.getKey());
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率     ", df.format((value/ (double)openCount5) * 100) + "%");	
			}
			else if(i == 48){
				System.out.println(entry.getKey());
					Long value = Long.parseLong(entry.getValue() + "");
					newRpt.put("分享点击率     ", df.format((value/ (double)openCount5) * 100) + "%");
			}
			
			
			i++;
		}
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_106to108", "rpt", newRpt);
	}
	
	
	@RequestMapping("rpt96to103")
	public ModelAndView getStat96to103(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat96to103();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_96_to103", "rpt", rpt);
	}
	
	@RequestMapping("rptBookPhone")
	public ModelAndView getBookPhoneReport(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		final List<Object> rpt = minisiteUserActionStatFacade.getBookPhoneReport();
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_book_phone", new HashMap<String, Object>() {
			{
				put("rpt",rpt);
			}
		});
	}
	
	
	@RequestMapping("rpt112")
	public ModelAndView getStat112(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat112();
		/*java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		Long shareCount = 0L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 282247);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率", df.format((openCount / 282247.0) * 100) + "%");				
			}
			else if(i == 3){
				System.out.println(entry.getKey());
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率", df.format((value/ (double)openCount) * 100) + "%");	
			}
			else if(i == 8){
				System.out.println(entry.getKey());
					Long value = Long.parseLong(entry.getValue() + "");
					newRpt.put("分享点击率", df.format((value/ (double)openCount) * 100) + "%");
			}
			
			
			i++;
		}*/
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_112", "rpt", rpt);
	}
	
	@RequestMapping("rpt113to114")
	public ModelAndView getStat113to114(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat113to114();
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		Long openCount1 = 1L;
		Long shareCount = 0L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 284167);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率", df.format((openCount / 284167.0) * 100) + "%");				
			}
			else if(i == 3){
				System.out.println(entry.getKey());
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率", df.format((value/ (double)openCount) * 100) + "%");	
			}
			else if(i == 8){
				System.out.println(entry.getKey());
					Long value = Long.parseLong(entry.getValue() + "");
					newRpt.put("分享点击率", df.format((value/ (double)openCount) * 100) + "%");
			}
			else if(i == 9){
				openCount1 = Long.parseLong(entry.getValue() + "");
			}
			else if(i == 11){
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率 ", df.format((value/ (double)openCount1) * 100) + "%");	
			}
			else if(i == 16){
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("分享点击率 ", df.format((value/ (double)openCount1) * 100) + "%");	
			}
			
			
			i++;
		}
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_113to114", "rpt", newRpt);
	}
	
	@RequestMapping("rpt115to122")
	public ModelAndView getStat115to122(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat115to122();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_115_to122", "rpt", rpt);
	}
	
	
	
	@RequestMapping("rpt123")
	public ModelAndView getStat123(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat123();
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		Long openCount1 = 1L;
		Long shareCount = 0L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 266666);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率", df.format((openCount / 266666.0) * 100) + "%");				
			}
			else if(i == 3){
				System.out.println(entry.getKey());
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率", df.format((value/ (double)openCount) * 100) + "%");	
			}
			else if(i == 8){
				System.out.println(entry.getKey());
					Long value = Long.parseLong(entry.getValue() + "");
					newRpt.put("分享点击率", df.format((value/ (double)openCount) * 100) + "%");
			}
			/*else if(i == 9){
				openCount1 = Long.parseLong(entry.getValue() + "");
			}
			else if(i == 11){
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率 ", df.format((value/ (double)openCount1) * 100) + "%");	
			}
			else if(i == 16){
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("分享点击率 ", df.format((value/ (double)openCount1) * 100) + "%");	
			}*/
			
			
			i++;
		}
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_123", "rpt", newRpt);
	}
	
	
	@RequestMapping("rpt130to131")
	public ModelAndView getStat130to131(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat130to131();
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		Long openCount1 = 1L;
		Long shareCount = 0L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 2){
				newRpt.put("发送总数", 266666);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率", df.format((openCount / 266666.0) * 100) + "%");				
			}
			else if(i == 3){
				System.out.println(entry.getKey());
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率", df.format((value/ (double)openCount) * 100) + "%");	
			}
			else if(i == 8){
				System.out.println(entry.getKey());
					Long value = Long.parseLong(entry.getValue() + "");
					newRpt.put("分享点击率", df.format((value/ (double)openCount) * 100) + "%");
			}
			else if(i == 9){
				openCount1 = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率 ", df.format((openCount1 / 266666.0) * 100) + "%");				
			}
			else if(i == 10){
				newRpt.put("发送总数 ", 266666);				
			}
			else if(i == 11){
				System.out.println(entry.getKey());
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率 ", df.format((value/ (double)openCount1) * 100) + "%");	
			}
			else if(i == 16){
				System.out.println(entry.getKey());
					Long value = Long.parseLong(entry.getValue() + "");
					newRpt.put("分享点击率 ", df.format((value/ (double)openCount1) * 100) + "%");
			}
			/*else if(i == 9){
				openCount1 = Long.parseLong(entry.getValue() + "");
			}
			else if(i == 11){
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("预约点击率 ", df.format((value/ (double)openCount1) * 100) + "%");	
			}
			else if(i == 16){
				Long value = Long.parseLong(entry.getValue() + "");
				newRpt.put("分享点击率 ", df.format((value/ (double)openCount1) * 100) + "%");	
			}*/
			
			
			i++;
		}
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_130_to131", "rpt", newRpt);
	}
	
	
	@RequestMapping("rpt132to135")
	public ModelAndView getStat132to135(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat132to135();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_132_to135", "rpt", rpt);
	}
	
	@RequestMapping("rpt136to147")
	public ModelAndView getStat136to147(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat136to147();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_136_to147", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt154to167")
	public ModelAndView getStat154to167(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat154to167();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_154_to167", "rpt", rpt);
	}
	
	@RequestMapping("rpt168to183")
	public ModelAndView getStat168to183(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat168to183();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_168_to183", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt184to201")
	public ModelAndView getStat184to201(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat184to201();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_184_to201", "rpt", rpt);
	}
	
	
	
	@RequestMapping("rpt202to221")
	public ModelAndView getStat202to221(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat202to221();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_202_to221", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt222to239")
	public ModelAndView getStat222to239(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat222to239();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_222_to239", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt240to241")
	public ModelAndView getStat240to241(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat240to241();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_240_to241", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt242to243")
	public ModelAndView getStat242to243(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat242to243();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_242_to243", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt244to261")
	public ModelAndView getStat244to261(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat244to261();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_244_to261", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt262to267")
	public ModelAndView getStat262to267(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat262to267();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_262_to267", "rpt", rpt);
	}
	
	
	
	@RequestMapping("rpt268to275")
	public ModelAndView getStat268to275(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat268to275();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_268_to275", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt290to301")
	public ModelAndView getStat290to301(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat290to301();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_290_to301", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt302to313")
	public ModelAndView getStat302to313(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat302to313();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_302_to313", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt316to319")
	public ModelAndView getStat316to319(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat316to319();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_316_to319", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt140916")
	public ModelAndView getStat140916(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat140916();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_140916", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt1001to2003")
	public ModelAndView getStat1001to2003(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat1001to2003();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_1001_to2003", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt321to324")
	public ModelAndView getStat321to324(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat321to324();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_321_to324", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt325to336")
	public ModelAndView getStat325to336(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat325to336();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_325_to336", "rpt", rpt);
	}
	
	
	
	@RequestMapping("rpt337to348")
	public ModelAndView getStat337to348(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat337to348();
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 9732);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率", df.format((openCount / 9732.0) * 100) + "%");				
			}
			else if(i == 8){
				newRpt.put("发送总数 ", 92497);				
			}
			else if(i == 9){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率 ", df.format((openCount / 92497.0) * 100) + "%");				
			}
			else if(i == 16){
				newRpt.put("发送总数  ", 123809);				
			}
			else if(i == 17){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率  ", df.format((openCount / 123809.0) * 100) + "%");				
			}
			else if(i == 24){
				newRpt.put("发送总数   ", 453417);				
			}
			else if(i == 25){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率   ", df.format((openCount / 453417.0) * 100) + "%");				
			}
			else if(i == 32){
				newRpt.put("发送总数    ", 425280);				
			}
			else if(i == 33){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率    ", df.format((openCount / 425280.0) * 100) + "%");				
			}
			else if(i == 40){
				newRpt.put("发送总数     ", 388564);				
			}
			else if(i == 41){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("短信打开率     ", df.format((openCount / 388564.0) * 100) + "%");				
			}
			i++;
		}
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_337_to348", "rpt", newRpt);
	}
	
	@RequestMapping("rptTest")
	public ModelAndView rptTest(HttpServletRequest req,String type){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Object> rpt = minisiteUserActionStatFacade.rptTest(type);
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/test", rpt);
	}
	
	@RequestMapping("rptTest1")
	public @ResponseBody Map rptTest1(HttpServletRequest req,String type){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Object> rpt = minisiteUserActionStatFacade.rptTest(type);
		session.setAttribute("lastVisit", currVisit);
		return rpt;
	}
	
	@RequestMapping("rpt367to372")
	public ModelAndView getStat367to372(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat367to372();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_367_to372", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt373to396")
	public ModelAndView getStat373to396(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat373to396();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_373_to396", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt355to366")
	public ModelAndView getStat355to366(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat355to366();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_355_to366", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt397to432")
	public ModelAndView getStat397to432(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat397to432();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_397_to432", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt433to450")
	public ModelAndView getStat433to450(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat433to450();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_433_to450", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt451to468")
	public ModelAndView getStat451to468(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat451to468();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_451_to468", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt469to472")
	public ModelAndView getStat469to472(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat469to472();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_469_to472", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt473to490")
	public ModelAndView getStat473to490(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat473to490();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_473_to490", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt491to502")
	public ModelAndView getStat491to502(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat491to502();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_491_to502", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt503to506")
	public ModelAndView getStat503to506(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat503to506();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_503_to506", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt521to524")
	public ModelAndView getStat521to524(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat521to524();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_521_to524", "rpt", rpt);
	}
	
	
	
	@RequestMapping("rpt507to528")
	public ModelAndView getStat507to528(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat507to528();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_507_to528", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt529to540")
	public ModelAndView getStat529to540(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat529to540();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_529_to540", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt545to562")
	public ModelAndView getStat545to562(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat545to562();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_545_to562", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt563to582")
	public ModelAndView getStat563to582(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat563to582();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_563_to582", "rpt", rpt);
	}
	
	@RequestMapping("rpt20141121")
	public ModelAndView getRpt20141121(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20141121();
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 204892);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 204892.0) * 100) + "%");				
			}
			/*else if(i == 2){
				newRpt.put("发送总数 ", 1580787);				
			}
			else if(i == 3){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 92497.0) * 100) + "%");				
			}*/
			else if(i == 4){
				newRpt.put("发送总数  ", 1152650);				
			}
			else if(i == 5){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 1152650.0) * 100) + "%");				
			}
			/*else if(i == 6){
				newRpt.put("发送总数   ", 453417);				
			}
			else if(i == 7){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率   ", df.format((openCount / 453417.0) * 100) + "%");				
			}*/
			else if(i == 8){
				newRpt.put("发送总数    ", 317486);				
			}
			else if(i == 9){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率    ", df.format((openCount / 317486.0) * 100) + "%");				
			}
			/*else if(i == 10){
				newRpt.put("发送总数     ", 388564);				
			}
			else if(i == 11){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率     ", df.format((openCount / 388564.0) * 100) + "%");				
			}*/
			else if(i == 12){
				newRpt.put("发送总数       ", 306511);				
			}
			else if(i == 13){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率       ", df.format((openCount / 306511.0) * 100) + "%");				
			}
			/*else if(i == 14){
				newRpt.put("发送总数        ", 123809);				
			}
			else if(i == 15){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率        ", df.format((openCount / 123809.0) * 100) + "%");				
			}*/
			else if(i == 16){
				newRpt.put("发送总数         ", 210235);				
			}
			else if(i == 17){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率         ", df.format((openCount / 210235.0) * 100) + "%");				
			}
			/*else if(i == 18){
				newRpt.put("发送总数          ", 425280);				
			}
			else if(i == 19){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率          ", df.format((openCount / 425280.0) * 100) + "%");				
			}*/
			else if(i == 20){
				newRpt.put("发送总数           ", 73833);				
			}
			else if(i == 21){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率           ", df.format((openCount / 73833.0) * 100) + "%");				
			}
			/*else if(i == 22){
				newRpt.put("发送总数            ", 92497);				
			}
			else if(i == 23){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率            ", df.format((openCount / 92497.0) * 100) + "%");				
			}*/
			else if(i == 24){
				newRpt.put("发送总数             ", 409110);				
			}
			else if(i == 25){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率             ", df.format((openCount / 409110.0) * 100) + "%");				
			}
			/*else if(i == 26){
				newRpt.put("发送总数              ", 453417);				
			}
			else if(i == 27){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率              ", df.format((openCount / 453417.0) * 100) + "%");				
			}*/
			else if(i == 28){
				newRpt.put("发送总数               ", 374782);				
			}
			else if(i == 29){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率               ", df.format((openCount / 374782.0) * 100) + "%");				
			}
			/*else if(i == 30){
				newRpt.put("发送总数                ", 388564);				
			}
			else if(i == 31){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率                ", df.format((openCount / 388564.0) * 100) + "%");				
			}*/
			else if(i == 32){
				newRpt.put("发送总数                 ", 355465);				
			}
			else if(i == 33){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率                 ", df.format((openCount / 355465.0) * 100) + "%");				
			}
			/*else if(i == 34){
				newRpt.put("发送总数                  ", 123809);				
			}
			else if(i == 35){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率                  ", df.format((openCount / 123809.0) * 100) + "%");				
			}*/
			else if(i == 36){
				newRpt.put("发送总数                   ", 288461);				
			}
			else if(i == 37){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率                   ", df.format((openCount / 288461.0) * 100) + "%");				
			}
			/*else if(i == 38){
				newRpt.put("发送总数                    ", 425280);				
			}
			else if(i == 39){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率                    ", df.format((openCount / 425280.0) * 100) + "%");				
			}*/
			else if(i == 40){
				newRpt.put("发送总数                     ", 215335);				
			}
			else if(i == 41){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率                     ", df.format((openCount / 215335.0) * 100) + "%");				
			}
			/*else if(i == 42){
				newRpt.put("发送总数                      ", 388564);				
			}
			else if(i == 43){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率                      ", df.format((openCount / 388564.0) * 100) + "%");				
			}*/
			else if(i == 44){
				newRpt.put("发送总数                       ", 215577);				
			}
			else if(i == 45){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率                       ", df.format((openCount / 215577.0) * 100) + "%");				
			}
			/*else if(i == 46){
				newRpt.put("发送总数                        ", 388564);				
			}
			else if(i == 47){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率                        ", df.format((openCount / 388564.0) * 100) + "%");				
			}*/
			i++;
		}
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20141121", "rpt", newRpt);
	}
	
	@RequestMapping("rpt587to591")
	public ModelAndView getStat587to591(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat587to591();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_587_to591", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt597to614")
	public ModelAndView getStat597to614(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat597to614();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_597_to614", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt595to623")
	public ModelAndView getStat595to623(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat595to623();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_595_to623", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt625to630")
	public ModelAndView getStat625to630(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat625to630();
		
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 26763);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 26763.0) * 100) + "%");				
			}
			else if(i == 10){
				newRpt.put("发送总数 ", 22441);				
			}
			else if(i == 11){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 22441.0) * 100) + "%");				
			}
			else if(i == 20){
				newRpt.put("发送总数  ", 72826);				
			}
			else if(i == 21){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 72826.0) * 100) + "%");				
			}
			
			
			i++;
		}
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_625_to630", "rpt", newRpt);
	}
	
	@RequestMapping("rpt631to654")
	public ModelAndView getStat631to654(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat631to654();
		
		
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 9498);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 9498.0) * 100) + "%");				
			}
			else if(i == 8){
				newRpt.put("发送总数 ", 84997);				
			}
			else if(i == 9){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 84997.0) * 100) + "%");				
			}
			else if(i == 16){
				newRpt.put("发送总数  ", 110976);				
			}
			else if(i == 17){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 110976.0) * 100) + "%");				
			}
			else if(i == 24){
				newRpt.put("发送总数   ", 453201);				
			}
			else if(i == 25){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率   ", df.format((openCount / 453201.0) * 100) + "%");				
			}
			else if(i == 32){
				newRpt.put("发送总数    ", 370076);				
			}
			else if(i == 33){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率    ", df.format((openCount / 370076.0) * 100) + "%");				
			}
			else if(i == 40){
				newRpt.put("发送总数     ", 336631);				
			}
			else if(i == 41){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率     ", df.format((openCount / 336631.0) * 100) + "%");				
			}
			else if(i == 48){
				newRpt.put("发送总数       ", 320376);				
			}
			else if(i == 49){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率       ", df.format((openCount / 320376.0) * 100) + "%");				
			}
			else if(i == 56){
				newRpt.put("发送总数        ", 287642);				
			}
			else if(i == 57){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率        ", df.format((openCount / 287642.0) * 100) + "%");				
			}
			else if(i == 64){
				newRpt.put("发送总数         ", 415748);				
			}
			else if(i == 65){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率         ", df.format((openCount / 415748.0) * 100) + "%");				
			}
			else if(i == 72){
				newRpt.put("发送总数          ", 359608);				
			}
			else if(i == 73){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率          ", df.format((openCount / 359608.0) * 100) + "%");				
			}
			else if(i == 80){
				newRpt.put("发送总数           ", 263171);				
			}
			else if(i == 81){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率           ", df.format((openCount / 263171.0) * 100) + "%");				
			}
			else if(i == 88){
				newRpt.put("发送总数            ", 217564);				
			}
			else if(i == 89){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率            ", df.format((openCount / 217564.0) * 100) + "%");				
			}
			
			i++;
		}
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_631_to654", "rpt", newRpt);
	}
	
	@RequestMapping("rpt20141205")
	public ModelAndView getRpt20141205(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20141205();
		
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 224788);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 224788.0) * 100) + "%");				
			}
			else if(i == 4){
				newRpt.put("发送总数 ", 379515);				
			}
			else if(i == 5){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 379515.0) * 100) + "%");				
			}
			else if(i == 8){
				newRpt.put("发送总数  ", 217866);				
			}
			else if(i == 9){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 217866.0) * 100) + "%");				
			}
			
			
			i++;
		}
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20141205", "rpt", newRpt);
	}
	
	@RequestMapping("rpt20141210")
	public ModelAndView getRpt20141210(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20141210();
		
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 9498);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 9498.0) * 100) + "%");				
			}
			else if(i == 4){
				newRpt.put("发送总数 ", 84997);				
			}
			else if(i == 5){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 84997.0) * 100) + "%");				
			}
			else if(i == 8){
				newRpt.put("发送总数  ", 110976);				
			}
			else if(i == 9){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 110976.0) * 100) + "%");				
			}
			else if(i == 12){
				newRpt.put("发送总数       ", 1159908);				
			}
			else if(i == 13){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率       ", df.format((openCount / 1159908.0) * 100) + "%");				
			}
			else if(i == 16){
				newRpt.put("发送总数         ", 415748);				
			}
			else if(i == 17){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率         ", df.format((openCount / 415748.0) * 100) + "%");				
			}
			else if(i == 20){
				newRpt.put("发送总数           ", 379515);				
			}
			else if(i == 21){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率           ", df.format((openCount / 379515.0) * 100) + "%");				
			}
			
			
			i++;
		}
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20141210", "rpt", newRpt);
	}
	
	
	@RequestMapping("rpt20141211")
	public ModelAndView getRpt20141211(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20141211();
		
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 336631);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 336631.0) * 100) + "%");				
			}
			else if(i == 4){
				newRpt.put("发送总数 ", 320376);				
			}
			else if(i == 5){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 320376.0) * 100) + "%");				
			}
			else if(i == 8){
				newRpt.put("发送总数  ", 224788);				
			}
			else if(i == 9){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 224788.0) * 100) + "%");				
			}
			else if(i == 12){
				newRpt.put("发送总数       ", 359608);				
			}
			else if(i == 13){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率       ", df.format((openCount / 359608.0) * 100) + "%");				
			}
			else if(i == 16){
				newRpt.put("发送总数         ", 72826);				
			}
			else if(i == 17){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率         ", df.format((openCount / 72826.0) * 100) + "%");				
			}
			
			
			
			i++;
		}
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20141211", "rpt", newRpt);
	}
	
	
	@RequestMapping("rpt20141212")
	public ModelAndView getRpt20141212(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20141212();
		
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 26763);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 26763.0) * 100) + "%");				
			}
			else if(i == 10){
				newRpt.put("发送总数 ", 22441);				
			}
			else if(i == 11){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 22441.0) * 100) + "%");				
			}
			else if(i == 20){
				newRpt.put("发送总数  ", 263171);				
			}
			else if(i == 21){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 263171.0) * 100) + "%");				
			}
			else if(i == 24){
				newRpt.put("发送总数       ", 217866);				
			}
			else if(i == 25){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率       ", df.format((openCount / 217866.0) * 100) + "%");				
			}
			else if(i == 28){
				newRpt.put("发送总数         ", 217564);				
			}
			else if(i == 29){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率         ", df.format((openCount / 217564.0) * 100) + "%");				
			}
			
			
			
			i++;
		}
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20141212", "rpt", newRpt);
	}
	
	
	@RequestMapping("rpt20141228")
	public ModelAndView getRpt20141228(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20141228();
		
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 205471);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 205471.0) * 100) + "%");				
			}
			else if(i == 4){
				newRpt.put("发送总数 ", 1159908);				
			}
			else if(i == 5){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 1159908.0) * 100) + "%");				
			}
			else if(i == 8){
				newRpt.put("发送总数  ", 336631);				
			}
			else if(i == 9){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 336631.0) * 100) + "%");				
			}
			else if(i == 12){
				newRpt.put("发送总数       ", 320376);				
			}
			else if(i == 13){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率       ", df.format((openCount / 320376.0) * 100) + "%");				
			}
			else if(i == 16){
				newRpt.put("发送总数         ", 224788);				
			}
			else if(i == 17){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率         ", df.format((openCount / 224788.0) * 100) + "%");				
			}
			
			
			
			i++;
		}
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20141228", "rpt", newRpt);
	}
	
	@RequestMapping("rpt20141227")
	public ModelAndView getRpt20141227(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20141227();
		
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 415748);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 415748.0) * 100) + "%");				
			}
			else if(i == 4){
				newRpt.put("发送总数 ", 379515);				
			}
			else if(i == 5){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 379515.0) * 100) + "%");				
			}
			else if(i == 8){
				newRpt.put("发送总数  ", 359608);				
			}
			else if(i == 9){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 359608.0) * 100) + "%");				
			}
			else if(i == 12){
				newRpt.put("发送总数       ", 263171);				
			}
			else if(i == 13){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率       ", df.format((openCount / 263171.0) * 100) + "%");				
			}
			else if(i == 16){
				newRpt.put("发送总数         ", 217866);				
			}
			else if(i == 17){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率         ", df.format((openCount / 217866.0) * 100) + "%");				
			}
			else if(i == 20){
				newRpt.put("发送总数           ", 217564);				
			}
			else if(i == 21){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率           ", df.format((openCount / 217564.0) * 100) + "%");				
			}
			
			
			i++;
		}
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20141227", "rpt", newRpt);
	}
	
	
	@RequestMapping("rpt677to679")
	public ModelAndView getStat677to679(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat677to679();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_677_to679", "rpt", rpt);
	}
	
	@RequestMapping("rpt655to676")
	public ModelAndView getStat655to676(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat655to676();
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 49999);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 49999.0) * 100) + "%");				
			}
			else if(i == 10){
				newRpt.put("发送总数 ", 26310);				
			}
			else if(i == 11){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 26310.0) * 100) + "%");				
			}
			else if(i == 20){
				newRpt.put("发送总数  ", 23636);				
			}
			else if(i == 21){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 23636.0) * 100) + "%");				
			}
			else if(i == 30){
				newRpt.put("发送总数       ", 21072);				
			}
			else if(i == 31){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率       ", df.format((openCount / 21072.0) * 100) + "%");				
			}
			else if(i == 40){
				newRpt.put("发送总数        ", 72826);				
			}
			else if(i == 41){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率        ", df.format((openCount / 72826.0) * 100) + "%");				
			}
			
			
			
			
			i++;
		}
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_655_to676", "rpt", newRpt);
	}
	
	
	@RequestMapping("rpt693to698")
	public ModelAndView getStat693to698(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat693to698();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_693_to698", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150115")
	public ModelAndView getRpt20150115(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150115();
		
Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 201807);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 201807.0) * 100) + "%");				
			}
			else if(i == 4){
				newRpt.put("发送总数 ", 806606);				
			}
			else if(i == 5){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 806606.0) * 100) + "%");				
			}
			else if(i == 8){
				newRpt.put("发送总数  ", 640149);				
			}
			else if(i == 9){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 640149.0) * 100) + "%");				
			}
			else if(i == 12){
				newRpt.put("发送总数       ", 506380);		//小五小六		
			}
			else if(i == 13){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率       ", df.format((openCount / 506380.0) * 100) + "%");				
			}
			else if(i == 16){
				newRpt.put("发送总数         ", 400137);				
			}
			else if(i == 17){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率         ", df.format((openCount / 400137.0) * 100) + "%");				
			}
			else if(i == 20){
				newRpt.put("发送总数           ", 365719);				
			}
			else if(i == 21){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率           ", df.format((openCount / 365719.0) * 100) + "%");				
			}
			else if(i == 24){
				newRpt.put("发送总数            ", 347495);				
			}
			else if(i == 25){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率            ", df.format((openCount / 347495.0) * 100) + "%");				
			}
			
			
			i++;
		}
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150115", "rpt", newRpt);
	}
	
	
	@RequestMapping("rpt687to692")
	public ModelAndView getStat687to692(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat687to692();
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 90730);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 90730.0) * 100) + "%");				
			}
			else if(i == 10){
				newRpt.put("发送总数 ", 83667);				
			}
			else if(i == 11){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 83667.0) * 100) + "%");				
			}
			else if(i == 20){
				newRpt.put("发送总数  ", 71712);				
			}
			else if(i == 21){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 71712.0) * 100) + "%");				
			}
			
			
			
			
			
			i++;
		}
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_687_to692", "rpt", newRpt);
	}
	
	
	@RequestMapping("rpt701to703")
	public ModelAndView getStat701to703(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getStat701to703();
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_stat_701_to703", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150121")
	public ModelAndView getRpt20150121(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150121();
		
Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 201807);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 201807.0) * 100) + "%");				
			}
			else if(i == 4){
				newRpt.put("发送总数 ", 806606);				
			}
			else if(i == 5){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 806606.0) * 100) + "%");				
			}
			else if(i == 8){
				newRpt.put("发送总数  ", 640149);				
			}
			else if(i == 9){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 640149.0) * 100) + "%");				
			}
			else if(i == 12){
				newRpt.put("发送总数       ", 506380);		//小五小六		
			}
			else if(i == 13){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率       ", df.format((openCount / 506380.0) * 100) + "%");				
			}
			
			
			
			i++;
		}
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150121", "rpt", newRpt);
	}
	
	
	
	
	@RequestMapping("rpt20150123")
	public ModelAndView getRpt20150123(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150123();
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 90730);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 90730.0) * 100) + "%");				
			}
			else if(i == 10){
				newRpt.put("发送总数 ", 83667);				
			}
			else if(i == 11){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 83667.0) * 100) + "%");				
			}
			else if(i == 20){
				newRpt.put("发送总数  ", 71712);				
			}
			else if(i == 21){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 71712.0) * 100) + "%");				
			}
			else if(i == 30){
				newRpt.put("发送总数   ", 30025);				
			}
			else if(i == 31){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率   ", df.format((openCount / 30025.0) * 100) + "%");				
			}
			
			
			
			
			i++;
		}
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150123", "rpt", newRpt);
	}
	
	
	@RequestMapping("rpt2015012302")
	public ModelAndView getRpt2015012302(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015012302();
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 26129);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 26129.0) * 100) + "%");				
			}
			else if(i == 10){
				newRpt.put("发送总数 ", 23470);				
			}
			else if(i == 11){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 23470.0) * 100) + "%");				
			}
			else if(i == 20){
				newRpt.put("发送总数  ", 21072);				
			}
			else if(i == 21){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 21072.0) * 100) + "%");				
			}
			
			
			
			
			
			i++;
		}
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015012302", "rpt", newRpt);
	}
	
	
	@RequestMapping("rpt20150129")
	public ModelAndView getRpt20150129(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150129();
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 70837);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 70837.0) * 100) + "%");				
			}
			else if(i == 10){
				newRpt.put("发送总数 ", 26045);				
			}
			else if(i == 11){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 26045.0) * 100) + "%");				
			}
			else if(i == 20){
				newRpt.put("发送总数  ", 209314);				
			}
			else if(i == 21){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 209314.0) * 100) + "%");				
			}
			else if(i == 30){
				newRpt.put("发送总数   ", 163766);				
			}
			else if(i == 31){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率   ", df.format((openCount / 163766.0) * 100) + "%");				
			}
			
			
			
			
			i++;
		}
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150129", "rpt", newRpt);
	}
	
	
	@RequestMapping("rpt20150130")
	public ModelAndView getRpt20150130(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150130();
		
Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 201807);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 201807.0) * 100) + "%");				
			}
			else if(i == 4){
				newRpt.put("发送总数 ", 806606);				
			}
			else if(i == 5){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 806606.0) * 100) + "%");				
			}
			else if(i == 8){
				newRpt.put("发送总数  ", 640149);				
			}
			else if(i == 9){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 640149.0) * 100) + "%");				
			}
			else if(i == 12){
				newRpt.put("发送总数       ", 506380);		//小五小六		
			}
			else if(i == 13){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率       ", df.format((openCount / 506380.0) * 100) + "%");				
			}
			else if(i == 16){
				newRpt.put("发送总数         ", 400137);				
			}
			else if(i == 17){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率         ", df.format((openCount / 400137.0) * 100) + "%");				
			}
			else if(i == 20){
				newRpt.put("发送总数           ", 365719);				
			}
			else if(i == 21){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率           ", df.format((openCount / 365719.0) * 100) + "%");				
			}
			else if(i == 24){
				newRpt.put("发送总数            ", 347495);				
			}
			else if(i == 25){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率            ", df.format((openCount / 347495.0) * 100) + "%");				
			}
			
			
			i++;
		}
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150130", "rpt", newRpt);
	}
	
	
	@RequestMapping("rpt20150205")
	public ModelAndView getRpt20150205(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150205();
		Map<String, Object> newRpt = new LinkedHashMap<String, Object>();
		
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Long openCount = 1L;
		int i = 0;
		for(Map.Entry<String, Integer> entry : rpt.entrySet()){
			newRpt.put(entry.getKey(), entry.getValue());
			if(i == 0){
				newRpt.put("发送总数", 26045);				
			}
			else if(i == 1){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率", df.format((openCount / 26045.0) * 100) + "%");				
			}
			else if(i == 10){
				newRpt.put("发送总数 ", 23470);				
			}
			else if(i == 11){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率 ", df.format((openCount / 23470.0) * 100) + "%");				
			}
			else if(i == 20){
				newRpt.put("发送总数  ", 21072);				
			}
			else if(i == 21){
				openCount = Long.parseLong(entry.getValue() + "");
				newRpt.put("链接打开率  ", df.format((openCount / 21072.0) * 100) + "%");				
			}
			
			
			
			
			
			i++;
		}
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150205", "rpt", newRpt);
	}
	
	
	@RequestMapping("rpt20150209")
	public ModelAndView getRpt20150209(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150209();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150209", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015020902")
	public ModelAndView getRpt2015020902(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015020902();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015020902", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150306")
	public ModelAndView getRpt20150306(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150306();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150306", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015030602")
	public ModelAndView getRpt2015030602(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015030602();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015030602", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015030603")
	public ModelAndView getRpt2015030603(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015030603();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015030603", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsx")	
	public ModelAndView getRptSX(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015031303")
	public ModelAndView getRpt2015031303(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015031303();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015031303", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsx20150320")	
	public ModelAndView getRptSX20150320(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150320();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150320", "rpt", rpt);
	}
	
	
	
	@RequestMapping("rpt20150320")
	public ModelAndView getRpt20150320(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150320();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150320", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015032002")
	public ModelAndView getRpt2015032002(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015032002();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015032002", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015032003")
	public ModelAndView getRpt2015032003(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015032003();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015032003", "rpt", rpt);
	}
	
	
	
	@RequestMapping("rptsx20150326")	
	public ModelAndView getRptSX20150326(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150326();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150326", "rpt", rpt);
	}
	
	
	
	@RequestMapping("rpt20150326")
	public ModelAndView getRpt20150326(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150326();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150326", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015032602")
	public ModelAndView getRpt2015032602(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015032602();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015032602", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015032603")
	public ModelAndView getRpt2015032603(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015032603();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015032603", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsx20150402")	
	public ModelAndView getRptSX20150402(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150402();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150402", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150402")
	public ModelAndView getRpt20150402(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150402();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150402", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015040202")
	public ModelAndView getRpt2015040202(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015040202();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015040202", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015040203")
	public ModelAndView getRpt2015040203(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015040203();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015040203", "rpt", rpt);
	}
	
	@RequestMapping("rptsx20150410")	
	public ModelAndView getRptSX20150410(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150410();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150410", "rpt", rpt);
	}
	
	@RequestMapping("rpt20150410")
	public ModelAndView getRpt20150410(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150410();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150410", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015041002")
	public ModelAndView getRpt2015041002(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015041002();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015041002", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015041003")
	public ModelAndView getRpt2015041003(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015041003();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015041003", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsn20150416")	
	public ModelAndView getRptSN20150416(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20150416();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20150416", "rpt", rpt);
	}
	
	@RequestMapping("rptsx20150416")	
	public ModelAndView getRptSX20150416(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150416();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150416", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150417")
	public ModelAndView getRpt20150417(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150417();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150417", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015041702")
	public ModelAndView getRpt2015041702(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015041702();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015041702", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015041703")
	public ModelAndView getRpt2015041703(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015041703();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015041703", "rpt", rpt);
	}
	
	
	
	
	@RequestMapping("rpt20150423")
	public ModelAndView getRpt20150423(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150423();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150423", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015042302")
	public ModelAndView getRpt2015042302(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015042302();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015042302", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015042303")
	public ModelAndView getRpt2015042303(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015042303();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015042303", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsx20150424")	
	public ModelAndView getRptSX20150424(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150424();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150424", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsn20150428")	
	public ModelAndView getRptSN20150428(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20150428();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20150428", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150429")
	public ModelAndView getRpt20150429(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150429();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150429", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015042902")
	public ModelAndView getRpt2015042902(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015042902();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015042902", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015042903")
	public ModelAndView getRpt2015042903(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015042903();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015042903", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015042904")
	public ModelAndView getRpt2015042904(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015042904();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015042904", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015042905")
	public ModelAndView getRpt2015042905(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015042905();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015042905", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015042906")
	public ModelAndView getRpt2015042906(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015042906();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015042906", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsx20150430")	
	public ModelAndView getRptSX20150430(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150430();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150430", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsx20150507")	
	public ModelAndView getRptSX20150507(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150507();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150507", "rpt", rpt);
	}
	
	@RequestMapping("rpt20150507")
	public ModelAndView getRpt20150507(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150507();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150507", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015050702")
	public ModelAndView getRpt2015050702(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015050702();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015050702", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015050703")
	public ModelAndView getRpt2015050703(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015050703();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015050703", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015050704")
	public ModelAndView getRpt2015050704(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015050704();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015050704", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015050705")
	public ModelAndView getRpt2015050705(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015050705();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015050705", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsn20150508")	
	public ModelAndView getRptSN20150508(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20150508();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20150508", "rpt", rpt);
	}
	
	
	
	@RequestMapping("rpt20150514")
	public ModelAndView getRpt20150514(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150514();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150514", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015051402")
	public ModelAndView getRpt2015051402(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015051402();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015051402", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015051403")
	public ModelAndView getRpt2015051403(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015051403();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015051403", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015051404")
	public ModelAndView getRpt2015051404(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015051404();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015051404", "rpt", rpt);
	}
	@RequestMapping("rpt2015051405")
	public ModelAndView getRpt2015051405(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015051405();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015051405", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015051406")
	public ModelAndView getRpt2015051406(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015051406();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015051406", "rpt", rpt);
	}
	@RequestMapping("rpt2015051407")
	public ModelAndView getRpt2015051407(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015051407();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015051407", "rpt", rpt);
	}
	
	@RequestMapping("rptsx20150515")	
	public ModelAndView getRptSX20150515(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150515();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150515", "rpt", rpt);
	}
	
	@RequestMapping("rptsn20150518")	
	public ModelAndView getRptSN20150518(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20150518();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20150518", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsx20150522")	
	public ModelAndView getRptSX20150522(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150522();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150522", "rpt", rpt);
	}
	
	@RequestMapping("rpt20150521")
	public ModelAndView getRpt20150521(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150521();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150521", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015052102")
	public ModelAndView getRpt2015052102(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015052102();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015052102", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015052103")
	public ModelAndView getRpt2015052103(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015052103();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015052103", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015052104")
	public ModelAndView getRpt2015052104(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015052104();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015052104", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015052105")
	public ModelAndView getRpt2015052105(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015052105();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015052105", "rpt", rpt);
	}
	
	
	
	@RequestMapping("rpt20150528")
	public ModelAndView getRpt20150528(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150528();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150528", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015052802")
	public ModelAndView getRpt2015052802(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015052802();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015052802", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015052803")
	public ModelAndView getRpt2015052803(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015052803();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015052803", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015052804")
	public ModelAndView getRpt2015052804(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015052804();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015052804", "rpt", rpt);
	}
	
	
	
	@RequestMapping("rpt20150604")
	public ModelAndView getRpt20150604(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150604();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150604", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015060402")
	public ModelAndView getRpt2015060402(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015060402();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015060402", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015060403")
	public ModelAndView getRpt2015060403(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015060403();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015060403", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsx20150529")	
	public ModelAndView getRptSX20150529(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150529();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150529", "rpt", rpt);
	}
	
	@RequestMapping("rptsx20150605")	
	public ModelAndView getRptSX20150605(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150605();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150605", "rpt", rpt);
	}
	
	@RequestMapping("rptsn20150608")	
	public ModelAndView getRptSN20150608(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20150608();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20150608", "rpt", rpt);
	}
	
	@RequestMapping("rpt20150611")
	public ModelAndView getRpt20150611(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150611();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150611", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015061102")
	public ModelAndView getRpt2015061102(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015061102();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015061102", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015061103")
	public ModelAndView getRpt2015061103(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015061103();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015061103", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015061104")
	public ModelAndView getRpt2015061104(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015061104();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015061104", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015061105")
	public ModelAndView getRpt2015061105(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015061105();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015061105", "rpt", rpt);
	}
	
	@RequestMapping("rptsx20150611")	
	public ModelAndView getRptSX20150611(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150611();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150611", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150615")	
	public ModelAndView getRpt20150615(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150615();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150615", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150618")
	public ModelAndView getRpt20150618(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150618();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150618", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015061802")
	public ModelAndView getRpt2015061802(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015061802();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015061802", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015061803")
	public ModelAndView getRpt2015061803(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015061803();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015061803", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015061804")
	public ModelAndView getRpt2015061804(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015061804();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015061804", "rpt", rpt);
	}
	
	@RequestMapping("rptsx20150619")	
	public ModelAndView getRptSX20150619(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150619();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150619", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150623")
	public ModelAndView getRpt20150623(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150623();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150623", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150625")
	public ModelAndView getRpt20150625(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150625();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150625", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015062502")
	public ModelAndView getRpt2015062502(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015062502();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015062502", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015062503")
	public ModelAndView getRpt2015062503(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015062503();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015062503", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015062504")
	public ModelAndView getRpt2015062504(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015062504();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015062504", "rpt", rpt);
	}
	
	@RequestMapping("rptsx20150626")	
	public ModelAndView getRptSX20150626(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150626();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150626", "rpt", rpt);
	}
	
	@RequestMapping("rpt20150626")
	public ModelAndView getRpt20150626(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150626();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150626", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsn20150701")	
	public ModelAndView getRptSN20150701(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20150701();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20150701", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150701")
	public ModelAndView getRpt20150701(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150701();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150701", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015070102")
	public ModelAndView getRpt2015070102(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015070102();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015070102", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015070103")
	public ModelAndView getRpt2015070103(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015070103();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015070103", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015070104")
	public ModelAndView getRpt2015070104(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015070104();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015070104", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsx20150706")	
	public ModelAndView getRptSX20150706(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150706();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150706", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150708")
	public ModelAndView getRpt20150708(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150708();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150708", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150709")
	public ModelAndView getRpt20150709(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150709();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150709", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015070902")
	public ModelAndView getRpt2015070902(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015070902();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015070902", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015070903")
	public ModelAndView getRpt2015070903(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015070903();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015070903", "rpt", rpt);
	}
	
	@RequestMapping("rptsx20150710")	
	public ModelAndView getRptSX20150710(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150710();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150710", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsn20150714")	
	public ModelAndView getRptSN20150714(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20150714();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20150714", "rpt", rpt);
	}
	
	@RequestMapping("rpt20150716")
	public ModelAndView getRpt20150716(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150716();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150716", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015071602")
	public ModelAndView getRpt2015071602(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015071602();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015071602", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015071603")
	public ModelAndView getRpt2015071603(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015071603();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015071603", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsx20150720")	
	public ModelAndView getRptSX20150720(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150720();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150720", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsn20150722")	
	public ModelAndView getRptSN20150722(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20150722();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20150722", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150723")
	public ModelAndView getRpt20150723(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150723();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150723", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015072302")
	public ModelAndView getRpt2015072302(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015072302();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015072302", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015072303")
	public ModelAndView getRpt2015072303(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015072303();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015072303", "rpt", rpt);
	}
	
	@RequestMapping("rptsx20150724")	
	public ModelAndView getRptSX20150724(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150724();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150724", "rpt", rpt);
	}
	
	@RequestMapping("rpt20150729")
	public ModelAndView getRpt2015079(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150729();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150729", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015072902")
	public ModelAndView getRpt201507902(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015072902();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015072902", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015072903")
	public ModelAndView getRpt201507903(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015072903();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015072903", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150730")
	public ModelAndView getRpt20150730(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150730();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150730", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsx20150803")	
	public ModelAndView getRptSX20150803(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150803();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150803", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150804")
	public ModelAndView getRpt20150804(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150804();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150804", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150805")
	public ModelAndView getRpt20150805(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150805();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150805", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015080502")
	public ModelAndView getRpt2015080502(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015080502();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015080502", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsx20150806")	
	public ModelAndView getRptSX20150806(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150806();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150806", "rpt", rpt);
	}
	
	@RequestMapping("rptsn20150813")	
	public ModelAndView getRptSN20150813(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20150813();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20150813", "rpt", rpt);
	}
	
	@RequestMapping("rptsx20150813")	
	public ModelAndView getRptSX20150813(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150813();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150813", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150814")
	public ModelAndView getRpt20150814(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150814();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150814", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015081402")
	public ModelAndView getRpt2015081402(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015081402();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015081402", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015081403")
	public ModelAndView getRpt2015081403(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015081403();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015081403", "rpt", rpt);
	}
	
	
	
	@RequestMapping("rpt20150820")
	public ModelAndView getRpt20150820(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150820();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150820", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015082002")
	public ModelAndView getRpt2015082002(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015082002();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015082002", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015082003")
	public ModelAndView getRpt2015082003(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015082003();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015082003", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsx20150824")	
	public ModelAndView getRptSX20150824(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150824();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150824", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150826")
	public ModelAndView getRpt20150826(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150826();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150826", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015082602")
	public ModelAndView getRpt2015082602(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015082602();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015082602", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015082603")
	public ModelAndView getRpt2015082603(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015082603();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015082603", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsx20150828")	
	public ModelAndView getRptSX20150828(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150828();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150828", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150902")
	public ModelAndView getRpt20150902(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150902();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150902", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015090202")
	public ModelAndView getRpt2015090202(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015090202();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015090202", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015090203")
	public ModelAndView getRpt2015090203(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015090203();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015090203", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20150910")
	public ModelAndView getRpt20150910(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20150910();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20150910", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015091002")
	public ModelAndView getRpt2015091002(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015091002();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015091002", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015091003")
	public ModelAndView getRpt2015091003(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015091003();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015091003", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015091004")
	public ModelAndView getRpt2015091004(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015091004();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015091004", "rpt", rpt);
	}
	
	@RequestMapping("rptsx20150911")	
	public ModelAndView getRptSX20150911(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150911();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150911", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsn20150916")	
	public ModelAndView getRptSN20150916(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20150916();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20150916", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsx20150917")	
	public ModelAndView getRptSX20150917(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSX20150917();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sx20150917", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20151015")
	public ModelAndView getRpt20151015(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20151015();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20151015", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015101502")
	public ModelAndView getRpt2015101502(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015101502();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015101502", "rpt", rpt);
	}
	
	
	
	@RequestMapping("rpt20151102")
	public ModelAndView getRpt20151102(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20151102();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20151102", "rpt", rpt);
	}
	
	
	
	@RequestMapping("rpt2015110202")
	public ModelAndView getRpt2015110202(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015110202();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015110202", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt2015110203")
	public ModelAndView getRpt2015110203(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015110203();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015110203", "rpt", rpt);
	}
	
	@RequestMapping("rptsn20151203")	
	public ModelAndView getRptSN20151203(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20151203();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20151203", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsn20151207")	
	public ModelAndView getRptSN20151207(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20151207();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20151207", "rpt", rpt);
	}
	
	@RequestMapping("rpt20151209")
	public ModelAndView getRpt20151209(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20151209();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20151209", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20151211")
	public ModelAndView getRpt20151211(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20151211();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20151211", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015121102")
	public ModelAndView getRpt2015121102(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015121102();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015121102", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015121103")
	public ModelAndView getRpt2015121103(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015121103();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015121103", "rpt", rpt);
	}
	
	
	@RequestMapping("rptsn20151211")	
	public ModelAndView getRptSN20151211(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20151211();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20151211", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20151218")
	public ModelAndView getRpt20151218(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20151218();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20151218", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015121802")
	public ModelAndView getRpt2015121802(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015121802();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015121802", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015121803")
	public ModelAndView getRpt2015121803(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015121803();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015121803", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015121804")
	public ModelAndView getRpt2015121804(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015121804();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015121804", "rpt", rpt);
	}
	
	@RequestMapping("rptsn20151218")	
	public ModelAndView getRptSN20151218(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20151218();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20151218", "rpt", rpt);
	}
	
	
	@RequestMapping("rpt20151224")
	public ModelAndView getRpt20151224(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20151224();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20151224", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015122402")
	public ModelAndView getRpt2015122402(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015122402();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015122402", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015122403")
	public ModelAndView getRpt2015122403(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015122403();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015122403", "rpt", rpt);
	}
	
	@RequestMapping("rpt2015122404")
	public ModelAndView getRpt2015122404(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2015122404();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2015122404", "rpt", rpt);
	}
	
	@RequestMapping("rptsn20151225")	
	public ModelAndView getRptSN20151225(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20151225();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20151225", "rpt", rpt);
	}
	
	@RequestMapping("rptsn2015122502")	
	public ModelAndView getRptSN2015122502(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN2015122502();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn2015122502", "rpt", rpt);
	}
	
	@RequestMapping("rpt20160104")
	public ModelAndView getRpt20160104(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20160104();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20160104", "rpt", rpt);
	}
	
	@RequestMapping("rpt20160108")
	public ModelAndView getRpt20160108(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt20160108();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_20160108", "rpt", rpt);
	}
	
	@RequestMapping("rpt2016010802")
	public ModelAndView getRpt2016010802(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRpt2016010802();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_2016010802", "rpt", rpt);
	}
	

	@RequestMapping("rptsn20160108")	
	public ModelAndView getRptSN20160108(HttpServletRequest req){
		HttpSession session = req.getSession();
		Long lastVisit = (Long)session.getAttribute("lastVisit");
		Long currVisit = System.currentTimeMillis();
		if(lastVisit != null){
			long offset = 5000 - (currVisit - lastVisit);
			if(offset > 0){
				try {
					Thread.sleep(offset);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Map<String, Integer> rpt = minisiteUserActionStatFacade.getRptSN20160108();
		
		
		
		session.setAttribute("lastVisit", currVisit);
		return new ModelAndView("xxt/xxt_rpt_sn20160108", "rpt", rpt);
	}
	
	@RequestMapping("clickInfo")	
	public ModelAndView clickInfo(HttpServletRequest req,String idtype,String channel,String action,@RequestParam(required = true)String type,String postId){
		Map<String, Integer> rpt = minisiteUserActionStatFacade.clickInfo(idtype,channel,action,type,postId);
		return new ModelAndView("xxt/xxt_clickinfo", "rpt", rpt);
	}
}
