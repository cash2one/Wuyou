package com.istudy.server.common.web;

import static com.istudy.server.common.constants.ResultInfoConstants.CODE_SUCCESS;
import static com.istudy.server.common.constants.ResultInfoConstants.DESC_SUCCESS;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.istudy.server.common.constants.CMSConstants;
import com.istudy.server.common.service.BaseFacade;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.vo.PagingVO;
import com.istudy.server.common.vo.ResultVO;

public abstract class BaseController {
	
	public ResultVO success(){
		return new ResultVO(CODE_SUCCESS,DESC_SUCCESS);
	}
	
}
