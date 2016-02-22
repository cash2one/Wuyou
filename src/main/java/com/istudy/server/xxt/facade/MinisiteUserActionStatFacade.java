package com.istudy.server.xxt.facade;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.xxt.service.MinisiteUserActionStatService;
import com.istudy.server.xxt.vo.AutoRptVO;
import com.istudy.server.xxt.vo.BookVO;
import com.istudy.server.xxt.vo.ChannelVO;
import com.istudy.server.xxt.vo.ClickInfo;
import com.istudy.server.xxt.vo.DCountVO;
import com.istudy.server.xxt.vo.QuesVO;
import com.istudy.server.xxt.vo.UserAction3VO;
import com.istudy.server.xxt.vo.UserActionRecordPhoneRelaVO;
import com.istudy.server.xxt.vo.UserActionRecordVO;
import com.istudy.server.xxt.vo.UserActionVO;
import com.istudy.server.xxt.vo.bookInfoVO;

@Service
public class MinisiteUserActionStatFacade {
	
	public static final String UUID_KEY = "uuid";
	
	public static final String UUID_KEY_V3 = "uuid_channel";
	
	@Autowired
	private MinisiteUserActionStatService minisiteUserActionStatService;

	public void addRecord(UserActionRecordVO vo, HttpServletRequest req,
			HttpServletResponse res){
		String uuid = createUUID2Cookie(req, res);
		vo.setUuid(uuid);
		
		minisiteUserActionStatService.addRecord(vo);
	}
	
	private String getValueFromCookie(HttpServletRequest req,String key){
		Cookie[] cookies = req.getCookies();
		if(key != null && cookies != null){
			for(Cookie cookie : cookies)
			{
				if(key.equals(cookie.getName())){
					return cookie.getValue();
				}
			}
		}
		
		return null;
	}
	
	public void addRecordPhoneRela(UserActionRecordPhoneRelaVO vo, HttpServletRequest req){
		String uuid = vo.getUuid();
		if(CommonUtils.isNull(uuid)){
			uuid = getValueFromCookie(req, UUID_KEY);
			vo.setUuid(uuid);
		}
		List<UserActionRecordPhoneRelaVO> list = minisiteUserActionStatService.findRecordPhoneRelas(vo);
		if(list == null || list.isEmpty()){
			minisiteUserActionStatService.addRecordPhoneRela(vo);
		}
	}
	
	public String createUUID2Cookie(HttpServletRequest req, HttpServletResponse res){
		String uuid = getValueFromCookie(req, UUID_KEY);
		if(CommonUtils.isNull(uuid)){
			uuid = UUID.randomUUID().toString();
			
			Cookie cookie = new Cookie(UUID_KEY, uuid);
			cookie.setPath("/");
			cookie.setMaxAge(365 * 24 * 3600);
			res.addCookie(cookie);
		}
		return uuid;
	}
	
	public String createUUID3Cookie(HttpServletRequest req, HttpServletResponse res){
		String uuid = getValueFromCookie(req, UUID_KEY_V3);
		if(CommonUtils.isNull(uuid)){
			uuid = UUID.randomUUID().toString();
			
			Cookie cookie = new Cookie(UUID_KEY_V3, uuid);
			cookie.setPath("/");
			cookie.setMaxAge(365 * 24 * 3600);
			res.addCookie(cookie);
		}
		return uuid;
	}
	
	private void createUsefulFlag2Cookie(UserActionVO vo, HttpServletRequest req,
			HttpServletResponse res) {
		Cookie cookie = new Cookie("uf_" + vo.getMiniUri(), "1");
		cookie.setPath("/");
		cookie.setMaxAge(365 * 24 * 3600);
		res.addCookie(cookie);
	}
	
	
	public void addRecordV2(UserActionVO vo, HttpServletRequest req,
			HttpServletResponse res){
		String uuid = createUUID2Cookie(req, res);
		try {
			if(!CommonUtils.isNull(vo.getInfo())){
				vo.setInfo(new String(vo.getInfo().getBytes("ISO-8859-1"),"UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		};
		
		vo.setUuid(uuid);
		setClientTermInfo(vo, req);
		if("btnclick-useful".equalsIgnoreCase(vo.getAction()) || 
				"btnclick-useless".equalsIgnoreCase(vo.getAction())){
			if(this.getValueFromCookie(req, "uf_" + vo.getMiniUri()) != null){
				return;
			}
			createUsefulFlag2Cookie(vo, req, res);
		}
		minisiteUserActionStatService.addRecordV2(vo);
	}


	public void addRecordV3(UserAction3VO vo, HttpServletRequest req,
			HttpServletResponse res) {
		
		String uuid = createUUID3Cookie(req, res);
		try {
			if(!CommonUtils.isNull(vo.getInfo())){
				vo.setInfo(new String(vo.getInfo().getBytes("ISO-8859-1"),"UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		};
		
		vo.setUuid(uuid);
		setClientTermInfo3(vo, req);
		/*if("btnclick-useful".equalsIgnoreCase(vo.getAction()) || 
				"btnclick-useless".equalsIgnoreCase(vo.getAction())){
			if(this.getValueFromCookie(req, "uf_" + vo.getMiniUri()) != null){
				return;
			}
			createUsefulFlag2Cookie(vo, req, res);
		}*/
		minisiteUserActionStatService.addRecordV3(vo);
	}
	
	private void setClientTermInfo(UserActionVO vo, HttpServletRequest req) {
		vo.setIp(getClientIp(req));
		String agent = req.getHeader("User-Agent");
		vo.setPlatform(agent);
	}
	
	private void setClientTermInfo3(UserAction3VO vo, HttpServletRequest req) {
		vo.setIp(getClientIp(req));
		String agent = req.getHeader("User-Agent");
		vo.setPlatform(agent);
	}
	
	public List<bookInfoVO> bookInfo(String idtype) {
		
		String[] it = StringUtils.split(idtype, ",");
		System.out.println(it);
		List<bookInfoVO> listBookInfo = new ArrayList<bookInfoVO>();
		if(it.length>0 && it != null){
			for(int i = 0 ; i < it.length ; i ++ ){
				System.out.println(it[i]);
				List<bookInfoVO> lb = this.minisiteUserActionStatService.bookInfo(it[i]);
				System.out.println(lb);
				listBookInfo.addAll(lb);
			}
		}
		System.out.println(listBookInfo);
		//List<bookInfoVO> lb = this.minisiteUserActionStatService.bookInfo(idtype);
		return listBookInfo;
	}
	
	public List<bookInfoVO> bookInfo2(String idtype) {
		
		String[] it = StringUtils.split(idtype, ",");
		System.out.println(it);
		List<bookInfoVO> listBookInfo = new ArrayList<bookInfoVO>();
		if(it.length>0 && it != null){
			for(int i = 0 ; i < it.length ; i ++ ){
				System.out.println(it[i]);
				List<bookInfoVO> lb = this.minisiteUserActionStatService.bookInfo(it[i]);
				System.out.println(lb);
				listBookInfo.addAll(lb);
			}
		}
		System.out.println(listBookInfo);
		//List<bookInfoVO> lb = this.minisiteUserActionStatService.bookInfo(idtype);
		return listBookInfo;
	}
	
	public List<AutoRptVO> getRptAuto(String postIds, String titles, String idtype, String channels) {
		
		String[] postId = StringUtils.split(postIds, ",");
		String[] title = StringUtils.split(titles, ",");
		String[] channel = StringUtils.split(channels, ",");
		List<AutoRptVO> listAutoRpt = new ArrayList<AutoRptVO>();
		if(postId.length>0 && postId != null){
			for(int i = 0 ; i < postId.length ; i ++ ){
				AutoRptVO arv = new AutoRptVO();
				arv.setPostId(postId[i]);
				arv.setIdtype(idtype);
				arv.setChannel(channel[i]);
				String openCount = this.minisiteUserActionStatService.openCount(arv);
				String downloadCount = this.minisiteUserActionStatService.downloadCount(arv);
				//AutoRptVO arv = this.minisiteUserActionStatService.autoRpt(postId[i],idtype);
				arv.setTitle(title[i]);	
				arv.setOpenCount(openCount);
				arv.setDownloadCount(downloadCount);
				System.out.println(arv);
				listAutoRpt.add(arv);
			}
		}
		
		return listAutoRpt;
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

	public Map<String, Integer> getVariableTitileReport() {
		return minisiteUserActionStatService.getVariableTitileReport();
	}
	
	public Map<String, Integer> getSubjectChooseReport() {
		return minisiteUserActionStatService.getSubjectChooseReport();
	}

	public Map<String, Integer> getTestStrategyReport() {
		
		return minisiteUserActionStatService.getTestStrategyReport();
	}
	public Map<String, Integer> getStat28to31() {
		return minisiteUserActionStatService.getStat28to31();
	}

	public Map<String, Integer> getStat32to37() {
		return minisiteUserActionStatService.getStat32to37();
	}

	public Map<String, Integer> getStat38to45() {
		return minisiteUserActionStatService.getStat38to45();
	}

	public Map<String, Integer> getStat49() {
		return minisiteUserActionStatService.getStat49();
	}

	public Map<String, Integer> getStat50() {
		
		return minisiteUserActionStatService.getStat50();
	}

	public Map<String, Integer> getStat51to60() {
		
		return minisiteUserActionStatService.getStat51to60();
	}

	public Map<String, Integer> getStat66to67() {
		
		return minisiteUserActionStatService.getStat66to67();
	}

	public Map<String, Integer> getStat70to81() {
		
		return minisiteUserActionStatService.getStat70to81();
	}

	public Map<String, Integer> getStat82to83() {
		
		return minisiteUserActionStatService.getStat82to83();
	}

	public Map<String, Integer> getStat88() {
		
		return minisiteUserActionStatService.getStat88();
	}

	public Map<String, Integer> getStat89to105() {
		
		return minisiteUserActionStatService.getStat89to105();
	}

	public Map<String, Integer> getStat106to108() {
		
		return minisiteUserActionStatService.getStat106to108();
	}

	public Map<String, Integer> getStat96to103() {
		
		return minisiteUserActionStatService.getStat96to103();
	}

	public void saveBooksPhone(BookVO book1) {
		
		this.minisiteUserActionStatService.saveBooksPhone(book1);
		
	}

	public List<Object> getBookPhoneReport() {
		
		return minisiteUserActionStatService.getBookPhoneReport();
	}

	public Map<String, Integer> getStat112() {
		
		return minisiteUserActionStatService.getStat112();
	}

	public Map<String, Integer> getStat113to114() {
		
		return minisiteUserActionStatService.getStat113to114();
	}

	public Map<String, Integer> getStat115to122() {
		
		return minisiteUserActionStatService.getStat115to122();
	}

	public Map<String, Integer> getStat123() {
		
		return minisiteUserActionStatService.getStat123();
	}

	public Map<String, Integer> getStat130to131() {
		
		return minisiteUserActionStatService.getStat130to131();
	}

	public Map<String, Integer> getStat132to135() {
		
		return minisiteUserActionStatService.getStat132to135();
	}

	public Map<String, Integer> getStat136to147() {
		
		return minisiteUserActionStatService.getStat136to147();
	}

	public Map<String, Integer> getStat154to167() {
		
		return minisiteUserActionStatService.getStat154to167();
	}

	public int getStatCount(Map<String, Object> params) {
		return minisiteUserActionStatService.getStatCount(params);
	}

	public Map<String, Integer> getStat168to183() {
		
		return minisiteUserActionStatService.getStat168to183();
	}

	public Map<String, Integer> getStat184to201() {
		
		return minisiteUserActionStatService.getStat184to201();
	}

	public Map<String, Integer> getStat202to221() {
		
		return minisiteUserActionStatService.getStat202to221();
	}

	public Map<String, Integer> getStat222to239() {
		
		return minisiteUserActionStatService.getStat222to239();
	}

	public Map<String, Integer> getStat240to241() {
		
		return minisiteUserActionStatService.getStat240to241();
	}

	public Map<String, Integer> getStat242to243() {
		
		return minisiteUserActionStatService.getStat242to243();
	}

	public Map<String, Integer> getStat244to261() {
		
		return minisiteUserActionStatService.getStat244to261();
	}

	public Map<String, Integer> getStat262to267() {
		
		return minisiteUserActionStatService.getStat262to267();
	}

	public Map<String, Integer> getStat268to275() {
		
		return minisiteUserActionStatService.getStat268to275();
	}

	public Map<String, Integer> getStat290to301() {
		
		return minisiteUserActionStatService.getStat290to301();
	}

	public Map<String, Integer> getStat302to313() {
		
		return minisiteUserActionStatService.getStat302to313();
	}

	public Map<String, Integer> getStat316to319() {
		
		return minisiteUserActionStatService.getStat316to319();
	}

	public Map<String, Integer> getStat140916() {
		
		return minisiteUserActionStatService.getStat140916();
	}

	public Map<String, Integer> getStat1001to2003() {
		
		return minisiteUserActionStatService.getStat1001to2003();
	}

	public Map<String, Integer> getStat321to324() {
		
		return minisiteUserActionStatService.getStat321to324();
	}

	public Map<String, Integer> getStat325to336() {
		
		return minisiteUserActionStatService.getStat325to336();
	}

	public Map<String, Integer> getStat337to348() {
		
		return minisiteUserActionStatService.getStat337to348();
	}

	
	public Map<String, Object> channelRpt(String type) {
		
		final List<ChannelVO> list = minisiteUserActionStatService.channelRpt(type);
		final List<ChannelVO> list1 = minisiteUserActionStatService.innerRpt(type);
		final List<DCountVO> list2 = minisiteUserActionStatService.rptTest(type);
		final Map<String,ChannelVO> map=new HashMap<String, ChannelVO>();
		final Map<String,ChannelVO> map1=new HashMap<String, ChannelVO>();
		for(ChannelVO vo:list){
			map.put(vo.getChannel(), vo);
		}
		for(ChannelVO vo:list1){
			map1.put(vo.getChannel(), vo);
		}
		return new HashMap<String, Object>() {
			{
				put("channelCount",map);
				put("innerCount",map1);
				put("rpt",list2);
			}
		};
	
	}

	public Map<String, Object> rptTest(String type) {
		final List<DCountVO> list = minisiteUserActionStatService.rptTest(type);
		
		final Map<String,DCountVO> map=new HashMap<String, DCountVO>();
		for(DCountVO vo:list){
			map.put(vo.getIdtype(), vo);
		}
		return new HashMap<String, Object>() {
			{
				put("rpt",list);
			}
		};
	}

	public Map<String, Integer> getStat367to372() {
		
		return minisiteUserActionStatService.getStat367to372();
	}

	public Map<String, Integer> getStat373to396() {
		
		return minisiteUserActionStatService.getStat373to396();
	}

	public Map<String, Integer> getStat355to366() {
		
		return minisiteUserActionStatService.getStat355to366();
	}

	public Map<String, Integer> getStat397to432() {
		
		return minisiteUserActionStatService.getStat397to432();
	}

	public Map<String, Integer> getStat433to450() {
		
		return minisiteUserActionStatService.getStat433to450();
	}

	public Map<String, Integer> getStat451to468() {
		
		return minisiteUserActionStatService.getStat451to468();
	}

	public Map<String, Integer> getStat469to472() {
		
		return minisiteUserActionStatService.getStat469to472();
	}

	public Map<String, Integer> getStat473to490() {
		
		return minisiteUserActionStatService.getStat473to490();
	}

	public Map<String, Integer> getStat491to502() {
		
		return minisiteUserActionStatService.getStat491to502();
	}

	public Map<String, Integer> getStat503to506() {
		
		return minisiteUserActionStatService.getStat503to506();
	}

	public Map<String, Integer> getStat521to524() {
		
		return minisiteUserActionStatService.getStat521to524();
	}

	public Map<String, Integer> getStat507to528() {
		
		return minisiteUserActionStatService.getStat507to528();
	}

	public Map<String, Integer> getStat529to540() {
		
		return minisiteUserActionStatService.getStat529to540();
	}

	public Map<String, Integer> getStat545to562() {
		
		return minisiteUserActionStatService.getStat545to562();
	}

	public Map<String, Integer> getStat563to582() {
		
		return minisiteUserActionStatService.getStat563to582();
	}

	public Map<String, Integer> getRpt20141121() {
		
		return minisiteUserActionStatService.getRpt20141121();
	}

	public Map<String, Integer> getStat587to591() {
		
		return minisiteUserActionStatService.getStat587to591();
	}

	public Map<String, Integer> getStat597to614() {
		
		return minisiteUserActionStatService.getStat597to614();
	}

	public Map<String, Integer> getStat595to623() {
		
		return minisiteUserActionStatService.getStat595to623();
	}

	public Map<String, Integer> getStat625to630() {
		
		return minisiteUserActionStatService.getStat625to630();
	}

	public Map<String, Integer> getStat631to654() {
		
		return minisiteUserActionStatService.getStat631to654();
	}

	public Map<String, Integer> getRpt20141205() {
		
		return minisiteUserActionStatService.getRpt20141205();
	}

	public Map<String, Integer> getRpt20141210() {
		
		return minisiteUserActionStatService.getRpt20141210();
	}

	public Map<String, Integer> getRpt20141211() {
		
		return minisiteUserActionStatService.getRpt20141211();
	}

	public Map<String, Integer> getRpt20141212() {
		
		return minisiteUserActionStatService.getRpt20141212();
	}

	public Map<String, Integer> getRpt20141228() {
		
		return minisiteUserActionStatService.getRpt20141228();
	}

	public Map<String, Integer> getRpt20141227() {
		
		return minisiteUserActionStatService.getRpt20141227();
	}

	public Map<String, Integer> getStat677to679() {
		
		return minisiteUserActionStatService.getStat677to679();
	}

	public Map<String, Integer> getStat655to676() {
		
		return minisiteUserActionStatService.getStat655to676();
	}

	public Map<String, Integer> getStat693to698() {
		
		return minisiteUserActionStatService.getStat693to698();
	}

	public Map<String, Integer> getRpt20150115() {
		
		return minisiteUserActionStatService.getRpt20150115();
	}

	public Map<String, Integer> getStat687to692() {
		
		return minisiteUserActionStatService.getStat687to692();
	}

	public Map<String, Integer> getStat701to703() {
		
		return minisiteUserActionStatService.getStat701to703();
	}

	public Map<String, Integer> getRpt20150121() {
		
		return minisiteUserActionStatService.getRpt20150121();
	}

	public Map<String, Integer> getRpt20150123() {
		
		return minisiteUserActionStatService.getRpt20150123();
	}

	public Map<String, Integer> getRpt2015012302() {
		
		return minisiteUserActionStatService.getRpt2015012302();
	}

	public Map<String, Integer> getRpt20150129() {
		
		return minisiteUserActionStatService.getRpt20150129();
	}

	public Map<String, Integer> getRpt20150130() {
		
		return minisiteUserActionStatService.getRpt20150130();
	}

	public Map<String, Integer> getRpt20150205() {
		
		return minisiteUserActionStatService.getRpt20150205();
	}

	public Map<String, Integer> getRpt20150209() {
		
		return minisiteUserActionStatService.getRpt20150209();
	}

	public Map<String, Integer> getRpt2015020902() {
		
		return minisiteUserActionStatService.getRpt2015020902();
	}

	public Map<String, Integer> getRpt20150306() {
		
		return minisiteUserActionStatService.getRpt20150306();
	}

	public Map<String, Integer> getRpt2015030602() {
		
		return minisiteUserActionStatService.getRpt2015030602();
	}

	public Map<String, Integer> getRpt2015030603() {
		
		return minisiteUserActionStatService.getRpt2015030603();
	}

	public Map<String, Integer> getRptSX() {
		
		return minisiteUserActionStatService.getRptSX();
	}

	public Map<String, Integer> getRpt2015031303() {
		
		return minisiteUserActionStatService.getRpt2015031303();
	}

	public Map<String, Integer> getRptSX20150320() {
		
		return minisiteUserActionStatService.getRptSX20150320();
	}

	public Map<String, Integer> getRpt20150320() {
		
		return minisiteUserActionStatService.getRpt20150320();
	}

	public Map<String, Integer> getRpt2015032002() {
		
		return minisiteUserActionStatService.getRpt2015032002();
	}

	public Map<String, Integer> getRpt2015032003() {
		
		return minisiteUserActionStatService.getRpt2015032003();
	}

	public Map<String, Integer> getRptSX20150326() {
		
		return minisiteUserActionStatService.getRptSX20150326();
	}

	public Map<String, Integer> getRpt20150326() {
		
		return minisiteUserActionStatService.getRpt20150326();
	}

	public Map<String, Integer> getRpt2015032602() {
		
		return minisiteUserActionStatService.getRpt2015032602();
	}

	public Map<String, Integer> getRpt2015032603() {
		
		return minisiteUserActionStatService.getRpt2015032603();
	}

	public Map<String, Integer> getRptSX20150402() {
		
		return minisiteUserActionStatService.getRptSX20150402();
	}

	public Map<String, Integer> getRpt20150402() {
		
		return minisiteUserActionStatService.getRpt20150402();
	}
	
	public Map<String, Integer> getRpt2015040202() {
		
		return minisiteUserActionStatService.getRpt2015040202();
	}
	
	public Map<String, Integer> getRpt2015040203() {
		
		return minisiteUserActionStatService.getRpt2015040203();
	}

	public Map<String, Integer> getRptSX20150410() {
		
		return minisiteUserActionStatService.getRptSX20150410();
	}

	public Map<String, Integer> getRpt20150410() {
		
		return minisiteUserActionStatService.getRpt20150410();
	}

	public Map<String, Integer> getRpt2015041002() {
		
		return minisiteUserActionStatService.getRpt2015041002();
	}

	public Map<String, Integer> getRpt2015041003() {
		
		return minisiteUserActionStatService.getRpt2015041003();
	}

	public Map<String, Integer> getRptSN20150416() {
		
		return minisiteUserActionStatService.getRptSN20150416();
	}

	public Map<String, Integer> getRptSX20150416() {
		
		return minisiteUserActionStatService.getRptSX20150416();
	}

	public Map<String, Integer> getRpt2015041702() {
		
		return minisiteUserActionStatService.getRpt2015041702();
	}

	public Map<String, Integer> getRpt2015041703() {
		
		return minisiteUserActionStatService.getRpt2015041703();
	}

	public Map<String, Integer> getRpt20150417() {
		
		return minisiteUserActionStatService.getRpt20150417();
	}

	public Map<String, Integer> getRpt20150423() {
		
		return minisiteUserActionStatService.getRpt20150423();
	}

	public Map<String, Integer> getRpt2015042302() {
		
		return minisiteUserActionStatService.getRpt2015042302();
	}

	public Map<String, Integer> getRpt2015042303() {
		
		return minisiteUserActionStatService.getRpt2015042303();
	}

	public Map<String, Integer> getRptSX20150424() {
		
		return minisiteUserActionStatService.getRptSX20150424();
	}

	public Map<String, Integer> getRptSN20150428() {
		
		return minisiteUserActionStatService.getRptSN20150428();
	}

	public Map<String, Integer> getRpt20150429() {
		
		return minisiteUserActionStatService.getRpt20150429();
	}

	public Map<String, Integer> getRpt2015042902() {
		
		return minisiteUserActionStatService.getRpt2015042902();
	}

	public Map<String, Integer> getRpt2015042903() {
		
		return minisiteUserActionStatService.getRpt2015042903();
	}

	public Map<String, Integer> getRpt2015042904() {
		
		return minisiteUserActionStatService.getRpt2015042904();
	}
	
	public Map<String, Integer> getRpt2015042905() {
		
		return minisiteUserActionStatService.getRpt2015042905();
	}
	
	public Map<String, Integer> getRpt2015042906() {
		
		return minisiteUserActionStatService.getRpt2015042906();
	}

	public Map<String, Integer> getRptSX20150430() {
		
		return minisiteUserActionStatService.getRptSX20150430();
	}

	public Map<String, Integer> getRptSX20150507() {
		
		return minisiteUserActionStatService.getRptSX20150507();
	}

	public Map<String, Integer> getRpt20150507() {
		
		return minisiteUserActionStatService.getRpt20150507();
	}

	public Map<String, Integer> getRpt2015050702() {
		
		return minisiteUserActionStatService.getRpt2015050702();
	}
	
	public Map<String, Integer> getRpt2015050703() {
		
		return minisiteUserActionStatService.getRpt2015050703();
	}
	
	public Map<String, Integer> getRpt2015050704() {
		
		return minisiteUserActionStatService.getRpt2015050704();
	}
	
	public Map<String, Integer> getRpt2015050705() {
		
		return minisiteUserActionStatService.getRpt2015050705();
	}

	public Map<String, Integer> getRptSN20150508() {
		
		return minisiteUserActionStatService.getRptSN20150508();
	}

	public Map<String, Integer> getRpt20150514() {
		
		return minisiteUserActionStatService.getRpt20150514();
	}
	public Map<String, Integer> getRpt2015051402() {
		
		return minisiteUserActionStatService.getRpt2015051402();
	}
	public Map<String, Integer> getRpt2015051403() {
		
		return minisiteUserActionStatService.getRpt2015051403();
	}
	public Map<String, Integer> getRpt2015051404() {
		
		return minisiteUserActionStatService.getRpt2015051403();
	}
	public Map<String, Integer> getRpt2015051405() {
		
		return minisiteUserActionStatService.getRpt2015051403();
	}
	public Map<String, Integer> getRpt2015051406() {
		
		return minisiteUserActionStatService.getRpt2015051403();
	}
	public Map<String, Integer> getRpt2015051407() {
		
		return minisiteUserActionStatService.getRpt2015051403();
	}

	public Map<String, Integer> getRptSX20150515() {
		
		return minisiteUserActionStatService.getRptSX20150515();
	}

	public Map<String, Integer> getRptSN20150518() {
		
		return minisiteUserActionStatService.getRptSN20150518();
	}

	public Map<String, Integer> getRptSX20150522() {
		
		return minisiteUserActionStatService.getRptSX20150522();
	}

	public Map<String, Integer> getRpt20150521() {
		
		return minisiteUserActionStatService.getRpt20150521();
	}
	public Map<String, Integer> getRpt2015052102() {
		
		return minisiteUserActionStatService.getRpt2015052102();
	}
	public Map<String, Integer> getRpt2015052103() {
		
		return minisiteUserActionStatService.getRpt2015052103();
	}

	public Map<String, Integer> getRpt2015052104() {
		
		return minisiteUserActionStatService.getRpt2015052104();
	}
	
	public Map<String, Integer> getRpt2015052105() {
		
		return minisiteUserActionStatService.getRpt2015052105();
	}

	public Map<String, Integer> getRpt20150528() {
		
		return minisiteUserActionStatService.getRpt20150528();
	}

	public Map<String, Integer> getRpt2015052802() {
		
		return minisiteUserActionStatService.getRpt2015052802();
	}

	public Map<String, Integer> getRpt2015052803() {
		
		return minisiteUserActionStatService.getRpt2015052803();
	}

	public Map<String, Integer> getRpt2015052804() {
		
		return minisiteUserActionStatService.getRpt2015052804();
	}

	public Map<String, Integer> getRpt20150604() {
		
		return minisiteUserActionStatService.getRpt20150604();
	}
	

	public Map<String, Integer> getRpt2015060402() {
		
		return minisiteUserActionStatService.getRpt2015060402();
	}

	public Map<String, Integer> getRpt2015060403() {
		
		return minisiteUserActionStatService.getRpt2015060403();
	}

	public Map<String, Integer> getRptSX20150529() {
		
		return minisiteUserActionStatService.getRptSX20150529();
	}

	public Map<String, Integer> getRptSX20150605() {
		
		return minisiteUserActionStatService.getRptSX20150605();
	}

	public Map<String, Integer> getRptSN20150608() {
		
		return minisiteUserActionStatService.getRptSN20150608();
	}

	public Map<String, Integer> getRpt20150611() {
		
		return minisiteUserActionStatService.getRpt20150611();
	}

	public Map<String, Integer> getRpt2015061102() {
		
		return minisiteUserActionStatService.getRpt2015061102();
	}

	public Map<String, Integer> getRpt2015061103() {
		
		return minisiteUserActionStatService.getRpt2015061103();
	}
	
	public Map<String, Integer> getRpt2015061104() {
		
		return minisiteUserActionStatService.getRpt2015061104();
	}
	
	public Map<String, Integer> getRpt2015061105() {
		
		return minisiteUserActionStatService.getRpt2015061105();
	}

	public Map<String, Integer> getRptSX20150611() {
		
		return minisiteUserActionStatService.getRptSX20150611();
	}

	public Map<String, Integer> getRpt20150615() {
		
		return minisiteUserActionStatService.getRpt20150615();
	}

	public Map<String, Integer> getRpt20150618() {
		
		return minisiteUserActionStatService.getRpt20150618();
	}

	public Map<String, Integer> getRpt2015061802() {
		
		return minisiteUserActionStatService.getRpt2015061802();
	}

	public Map<String, Integer> getRpt2015061803() {
		
		return minisiteUserActionStatService.getRpt2015061803();
	}

	public Map<String, Integer> getRpt2015061804() {
		
		return minisiteUserActionStatService.getRpt2015061804();
	}

	public Map<String, Integer> getRptSX20150619() {
		
		return minisiteUserActionStatService.getRptSX20150619();
	}

	public Map<String, Integer> getRpt20150623() {
		
		return minisiteUserActionStatService.getRpt20150623();
	}

	public Map<String, Integer> getRpt20150625() {
		
		return minisiteUserActionStatService.getRpt20150625();
	}

	public Map<String, Integer> getRpt2015062502() {
		
		return minisiteUserActionStatService.getRpt2015062502();
	}
	
	public Map<String, Integer> getRpt2015062503() {
		
		return minisiteUserActionStatService.getRpt2015062503();
	}
	
	public Map<String, Integer> getRpt2015062504() {
		
		return minisiteUserActionStatService.getRpt2015062504();
	}

	public Map<String, Integer> getRptSX20150626() {
		
		return minisiteUserActionStatService.getRptSX20150626();
	}

	public Map<String, Integer> getRpt20150626() {
		
		return minisiteUserActionStatService.getRpt20150626();
	}

	public Map<String, Integer> getRptSN20150701() {
		
		return minisiteUserActionStatService.getRptSN20150701();
	}

	public Map<String, Integer> getRpt20150701() {
		
		return minisiteUserActionStatService.getRpt20150701();
	}

	public Map<String, Integer> getRpt2015070102() {
		
		return minisiteUserActionStatService.getRpt2015070102();
	}

	public Map<String, Integer> getRpt2015070103() {
		
		return minisiteUserActionStatService.getRpt2015070103();
	}
	
	public Map<String, Integer> getRpt2015070104() {
		
		return minisiteUserActionStatService.getRpt2015070104();
	}

	public Map<String, Integer> getRptSX20150706() {
		
		return minisiteUserActionStatService.getRptSX20150706();
	}

	public Map<String, Integer> getRpt20150708() {
		
		return minisiteUserActionStatService.getRpt20150708();
	}

	public Map<String, Integer> getRpt20150709() {
		
		return minisiteUserActionStatService.getRpt20150709();
	}
	

	public Map<String, Integer> getRpt2015070902() {
		
		return minisiteUserActionStatService.getRpt2015070902();
	}

	public Map<String, Integer> getRpt2015070903() {
		
		return minisiteUserActionStatService.getRpt2015070903();
	}

	public Map<String, Integer> getRptSX20150710() {
		
		return minisiteUserActionStatService.getRptSX20150710();
	}

	public Map<String, Integer> getRptSN20150714() {
		
		return minisiteUserActionStatService.getRptSN20150714();
	}

	public Map<String, Integer> getRpt20150716() {
		
		return minisiteUserActionStatService.getRpt20150716();
	}

	public Map<String, Integer> getRpt2015071602() {
		
		return minisiteUserActionStatService.getRpt2015071602();
	}

	public Map<String, Integer> getRpt2015071603() {
		
		return minisiteUserActionStatService.getRpt2015071603();
	}

	public Map<String, Integer> getRptSX20150720() {
		
		return minisiteUserActionStatService.getRptSX20150720();
	}

	public Map<String, Integer> getRptSN20150722() {
		
		return minisiteUserActionStatService.getRptSN20150722();
	}

	public Map<String, Integer> getRpt20150723() {
		
		return minisiteUserActionStatService.getRpt20150723();
	}

	public Map<String, Integer> getRpt2015072302() {
		
		return minisiteUserActionStatService.getRpt2015072302();
	}

	public Map<String, Integer> getRpt2015072303() {
		
		return minisiteUserActionStatService.getRpt2015072303();
	}

	public Map<String, Integer> getRptSX20150724() {
		
		return minisiteUserActionStatService.getRptSX20150724();
	}

	public Map<String, Integer> getRpt20150729() {
		
		return minisiteUserActionStatService.getRpt20150729();
	}
	
	public Map<String, Integer> getRpt2015072902() {
		
		return minisiteUserActionStatService.getRpt2015072902();
	}
	
	public Map<String, Integer> getRpt2015072903() {
		
		return minisiteUserActionStatService.getRpt2015072903();
	}

	public Map<String, Integer> getRpt20150730() {
		
		return minisiteUserActionStatService.getRpt20150730();
	}

	public Map<String, Integer> getRptSX20150803() {
		
		return minisiteUserActionStatService.getRptSX20150803();
	}

	public Map<String, Integer> getRpt20150804() {
		
		return minisiteUserActionStatService.getRpt20150804();
	}

	public Map<String, Integer> getRpt20150805() {
		
		return minisiteUserActionStatService.getRpt20150805();
	}

	public Map<String, Integer> getRpt2015080502() {
		
		return minisiteUserActionStatService.getRpt2015080502();
	}

	public Map<String, Integer> getRptSX20150806() {
		
		return minisiteUserActionStatService.getRptSX20150806();
	}

	public Map<String, Integer> getRptSN20150813() {
		
		return minisiteUserActionStatService.getRptSN20150813();
	}

	public Map<String, Integer> getRptSX20150813() {
		
		return minisiteUserActionStatService.getRptSX20150813();
	}

	public Map<String, Integer> getRpt20150814() {
		
		return minisiteUserActionStatService.getRpt20150814();
	}

	public Map<String, Integer> getRpt2015081402() {
		
		return minisiteUserActionStatService.getRpt2015081402();
	}

	public Map<String, Integer> getRpt2015081403() {
		
		return minisiteUserActionStatService.getRpt2015081403();
	}

	public Map<String, Integer> getRpt20150820() {
		
		return minisiteUserActionStatService.getRpt20150820();
	}

	public Map<String, Integer> getRpt2015082002() {
		
		return minisiteUserActionStatService.getRpt2015082002();
	}

	public Map<String, Integer> getRpt2015082003() {
		
		return minisiteUserActionStatService.getRpt2015082003();
	}

	public Map<String, Integer> getRptSX20150824() {
		
		return minisiteUserActionStatService.getRptSX20150824();
	}

	public Map<String, Integer> getRpt20150826() {
		
		return minisiteUserActionStatService.getRpt20150826();
	}

	public Map<String, Integer> getRpt2015082602() {
		
		return minisiteUserActionStatService.getRpt2015082602();
	}

	public Map<String, Integer> getRpt2015082603() {
		
		return minisiteUserActionStatService.getRpt2015082603();
	}

	public Map<String, Integer> getRptSX20150828() {
		
		return minisiteUserActionStatService.getRptSX20150828();
	}

	public Map<String, Integer> getRpt20150902() {
		
		return minisiteUserActionStatService.getRpt20150902();
	}

	public Map<String, Integer> getRpt2015090202() {
		
		return minisiteUserActionStatService.getRpt2015090202();
	}

	public Map<String, Integer> getRpt2015090203() {
		
		return minisiteUserActionStatService.getRpt2015090203();
	}

	public List<QuesVO> quesInfo() {
		
		return minisiteUserActionStatService.quesInfo();
	}
	
	public List<QuesVO> tlbQuesInfo() {
		
		return minisiteUserActionStatService.tlbQuesInfo();
	}

	public Map<String, Integer> getRpt20150910() {
		
		return minisiteUserActionStatService.getRpt20150910();
	}

	public Map<String, Integer> getRpt2015091002() {
		
		return minisiteUserActionStatService.getRpt2015091002();
	}

	public Map<String, Integer> getRpt2015091003() {
		
		return minisiteUserActionStatService.getRpt2015091003();
	}

	public Map<String, Integer> getRpt2015091004() {
		
		return minisiteUserActionStatService.getRpt2015091004();
	}

	public Map<String, Integer> getRptSX20150911() {
		
		return minisiteUserActionStatService.getRptSX20150911();
	}

	public Map<String, Integer> getRptSN20150916() {
		
		return minisiteUserActionStatService.getRptSN20150916();
	}

	public Map<String, Integer> getRptSX20150917() {
		
		return minisiteUserActionStatService.getRptSX20150917();
	}

	public Map<String, Integer> getRpt20151015() {
		
		return minisiteUserActionStatService.getRpt20151015();
	}

	public Map<String, Integer> getRpt2015101502() {
		
		return minisiteUserActionStatService.getRpt2015101502();
	}

	public Map<String, Integer> getRpt20151102() {
		
		return minisiteUserActionStatService.getRpt20151102();
	}

	public Map<String, Integer> getRpt2015110202() {
		
		return minisiteUserActionStatService.getRpt2015110202();
	}

	public Map<String, Integer> getRpt2015110203() {
		
		return minisiteUserActionStatService.getRpt2015110203();
	}

	public Map<String, Integer> getRptSN20151203() {
		
		return minisiteUserActionStatService.getRptSN20151203();
	}

	public Map<String, Integer> getRptSN20151207() {
		
		return minisiteUserActionStatService.getRptSN20151207();
	}

	public Map<String, Integer> getRpt20151209() {
		
		return minisiteUserActionStatService.getRpt20151209();
	}

	public Map<String, Integer> getRpt20151211() {
		
		return minisiteUserActionStatService.getRpt20151211();
	}

	public Map<String, Integer> getRpt2015121102() {
		
		return minisiteUserActionStatService.getRpt2015121102();
	}

	public Map<String, Integer> getRpt2015121103() {
		
		return minisiteUserActionStatService.getRpt2015121103();
	}

	public Map<String, Integer> getRptSN20151211() {
		
		return minisiteUserActionStatService.getRptSN20151211();
	}

	public Map<String, Integer> getRpt20151218() {
		
		return minisiteUserActionStatService.getRpt20151218();
	}

	public Map<String, Integer> getRpt2015121802() {
		
		return minisiteUserActionStatService.getRpt2015121802();
	}

	public Map<String, Integer> getRpt2015121803() {
		
		return minisiteUserActionStatService.getRpt2015121803();
	}
	
	public Map<String, Integer> getRpt2015121804() {
		
		return minisiteUserActionStatService.getRpt2015121804();
	}

	public Map<String, Integer> getRptSN20151218() {
		
		return minisiteUserActionStatService.getRptSN20151218();
	}

	public Map<String, Integer> getRpt20151224() {
		
		return minisiteUserActionStatService.getRpt20151224();
	}

	public Map<String, Integer> getRpt2015122402() {
		
		return minisiteUserActionStatService.getRpt2015122402();
	}

	public Map<String, Integer> getRpt2015122403() {
		
		return minisiteUserActionStatService.getRpt2015122403();
	}

	public Map<String, Integer> getRpt2015122404() {
		
		return minisiteUserActionStatService.getRpt2015122404();
	}

	public Map<String, Integer> getRptSN20151225() {
		
		return minisiteUserActionStatService.getRptSN20151225();
	}
	
	public Map<String, Integer> getRptSN2015122502() {
		
		return minisiteUserActionStatService.getRptSN20151225();
	}

	public Map<String, Integer> getRpt20160104() {
		
		return minisiteUserActionStatService.getRpt20160104();
	}

	public Map<String, Integer> getRpt20160108() {
		return minisiteUserActionStatService.getRpt20160108();
	}

	public Map<String, Integer> getRpt2016010802() {
		return minisiteUserActionStatService.getRpt2016010802();
	}

	public Map<String, Integer> getRptSN20160108() {
		return minisiteUserActionStatService.getRptSN20160108();
	}

	public Map<String, Integer> clickInfo(String idtype, String channel, String action, String type, String postId) {
		ClickInfo ci = new ClickInfo(idtype,channel,type,action,postId);
		System.out.println(ci.getIdtype() + "," + ci.getAction() + "," + ci.getChannel() + "," + ci.getType() + "," + ci.getPostId());
		return minisiteUserActionStatService.clickInfo(ci);
	}

}
