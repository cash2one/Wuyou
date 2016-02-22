package com.istudy.server.cms.controller;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.istudy.server.cms.facade.UEFacade;
import com.istudy.server.cms.vo.UERegisterVO;
import com.istudy.server.common.utils.CommonUtils;

/**
 * 爱学网用户体验计划
 * @author yangwenjie
 *
 */
@Controller
@RequestMapping("/ue")
public class UEController {
	
	@Autowired
	private UEFacade ueFacade;

	@RequestMapping("")
	public String index(){
		return "istudy/ue_register";
	}
	
	@RequestMapping(value="/reg", method=RequestMethod.POST)
	public String register(UERegisterVO vo, 
			@CookieValue(value="uuid",required=false) String uuid, 
			Model model,HttpServletResponse res){
		if(CommonUtils.isNull(uuid)){
			uuid = UUID.randomUUID().toString();
			Cookie cookie = new Cookie("uuid", uuid);
			cookie.setPath("/");
			cookie.setMaxAge(365 * 24 * 3600);
			res.addCookie(cookie);
		}
		vo.setUuid(uuid);
		ueFacade.saveUERegister(vo);
		model.addAttribute("s", 1);
		return "redirect:/ue.do";
	}
}
