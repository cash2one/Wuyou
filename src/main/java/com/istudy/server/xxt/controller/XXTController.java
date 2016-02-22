package com.istudy.server.xxt.controller;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.istudy.server.common.exception.CMSException;
import com.istudy.server.common.validate.annotation.NotNull;
import com.istudy.server.common.validate.annotation.ValidatingField;
import com.istudy.server.common.validate.annotation.Validation;
import com.istudy.server.common.web.CommonController;
import com.istudy.server.xxt.vo.XXTGetTasksParamVO;

@Controller
@RequestMapping("/xxt/")
public class XXTController extends CommonController{

	@Override
	public String getRootPath() {
		return "xxt/";
	}
	
	@RequestMapping(value="main", method = RequestMethod.GET)
	@NotNull({ "param.userId", "param.teacherRole", "param.cityId", "param.gradeId"})
	@Validation({ @ValidatingField(format = "5", name = "param.teacherRole") })
	public ModelAndView showMain(final XXTGetTasksParamVO param){
		try {
			return new ModelAndView(getRootPath() + "xxt_main",BeanUtils.describe(param));
		} catch (IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			throw new CMSException(e);
		}
	}
}
