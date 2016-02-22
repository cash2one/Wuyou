package com.istudy.server.common.exception.handler;

import static com.istudy.server.common.constants.ResultInfoConstants.*;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.istudy.server.common.constants.ResultInfoConstants;
import com.istudy.server.common.exception.ResultException;
import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.vo.ResultVO;


public class CommonExceptionHandler implements HandlerExceptionResolver {
	public static final String ERROR_MSG = "ERROR_MSG";
	public static final String REDIRECT_URL = "REDIRECT_URL";

	@SuppressWarnings("serial")
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		LogUtils.L.error("异常:" + ex);
		if (ex instanceof ResultException) {
			final ResultException re = (ResultException) ex;
			if (re.isRedirect()) {
				String msg = "";
				if(!CommonUtils.isNull(re.getMessage())){
					msg+=re.getMessage()+",";
				}
				final String errorMsg = msg+ResultInfoConstants.RESULT.get(re.getCode());
				return new ModelAndView(re.getUrl(),
						new HashMap<String, String>() {
							{
								put("desc",
										errorMsg);
								put(REDIRECT_URL,
										re.getSourceUrl());
							}
						});
			}
			String code = ((ResultException) ex).getCode();
			return new ModelAndView(new MappingJackson2JsonView(),
					ResultVO.getResultMap(code, ResultInfoConstants.RESULT.get(code)));
		}
		return new ModelAndView(new MappingJackson2JsonView(),
				ResultVO.getResultMap(CODE_SERVER_ERROR, DESC_SERVER_ERROR));
	}

}
