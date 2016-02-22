package com.istudy.server.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.istudy.server.cms.facade.IStudyMinisiteFacade;

@Controller
@RequestMapping("/i")
public class IStudyMinisiteController {
	
	@Autowired
	private IStudyMinisiteFacade iStudyMinisiteFacade;

	@RequestMapping(value = "/{userid}/{idtype}/{miniUri}", method = RequestMethod.GET)
	public String article(
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri) {
		return "xxt/minisite/" + miniUri;
	}
	
	@RequestMapping(value = "/{userid}/{idtype}/{miniUri}/subscribe", method = RequestMethod.GET)
	public String prepExamSubscribe(
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri){
		return "istudy/prep_exam_subscribe";
	}
	
	@RequestMapping(value = "/{userid}/{idtype}/{miniUri}/doSubscribe", method = RequestMethod.POST)
	public String doPrepExamSubscribe(
			@PathVariable("userid") String userid,
			@PathVariable("idtype") int idtype,
			@PathVariable("miniUri") String miniUri,
			Model model){
		
		return "istudy/prep_exam_subscribe_result";
	}
}
