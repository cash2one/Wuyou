package com.istudy.server.common.security.interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.istudy.server.cms.facade.LoginFacade;
import com.istudy.server.cms.vo.LoginVO;
import com.istudy.server.common.constants.ResultInfoConstants;
import com.istudy.server.common.exception.ResultException;
import com.istudy.server.common.security.BaseHandlerInterceptor;
import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.system.facade.AccountFacade;
import com.istudy.server.system.facade.ActionFacade;
import com.istudy.server.system.vo.AccountVO;
import com.istudy.server.system.vo.ActionVO;

 
/**
 * 登录校验
 * @author LONGTING
 *
 */
public class LoginHandlerInterceptor extends BaseHandlerInterceptor{
	
	private static final Log LOG = LogFactory.getLog(LoginHandlerInterceptor.class);
	
	@Autowired
	private LoginFacade loginFacade;
	
	@Autowired
	private AccountFacade accountFacade;
	
	@Autowired
	private ActionFacade actionFacade;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		String sourceUrl = request.getRequestURL().toString();
		String sessionId = session.getId();
		LOG.info("URL:"+request.getRequestURL()+",URI:"+request.getRequestURI()
				+",sessionID:"+sessionId);
		String userName = (String) session.getAttribute("username");
		if(!CommonUtils.isNull(userName)){
			doPermissionCheck(request, response);
			return true;
		}else{
			throw new ResultException(ResultInfoConstants.CODE_SESSION_LOSE,true,"cms/login",sourceUrl);
		}
	}
	
	/*
	 * 权限校验
	 * (non-Javadoc)
	 * @see com.istudy.server.common.security.BaseHandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	public void doPermissionCheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String url = request.getRequestURI();
		String target = request.getParameter("target");
		if(null!=target){
			url = url+"?target="+target;
		}
		AccountVO acv = new AccountVO();
		acv.setActionURL(url);
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		acv.setUsername(username);
		LoginVO lv = (LoginVO)session.getAttribute("user");
		if(username!=null){
			if(!lv.getVendorType().equals("4")){
				if(url.equals("/cms/main.do")||url.equals("/login/unlogin.do")
						||url.equals("/accounts/modPassword.do")||url.equals("/accounts/getModPasswordPage.do")
						||url.contains("/getPagingData.do")){
					
				}else{
					ActionVO action = this.accountFacade.getActionByUsername(acv);
					if(action == null){
						//response.sendRedirect("../login/showError.do");
						if(!isAJAXRequest(request)){
							response.sendRedirect("../login/showError.do");
						}
						throw new ResultException(ResultInfoConstants.CODE_PERMISSION_INSUFFICIENT, ResultInfoConstants.DESC_PERMISSION_INSUFFICIENT);
					}
				}
			}
		}
	}
	
	protected boolean isAJAXRequest(HttpServletRequest req) {

	    String requestType = req.getHeader("X-Requested-With"); 
	    if (requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")) { 
	        return true; 
	    } else { 
	        return false; 
	    }

	}

}
