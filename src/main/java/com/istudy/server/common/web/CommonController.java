package com.istudy.server.common.web;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

















import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.istudy.server.common.service.BaseFacade;
import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.vo.PagingVO;
import com.istudy.server.system.facade.RoleFacade;
import com.istudy.server.system.vo.ActionVO;
import com.istudy.server.system.vo.RoleVO;

public abstract class CommonController extends BaseController{

	@Autowired
	private BaseFacade<?> baseFacade;
	
	@Autowired
	private RoleFacade roleFacade;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/showPaging",method=RequestMethod.GET)
	public ModelAndView showPaing(@RequestParam() Map<String,Object> param, HttpServletRequest req){
		param.put("sessionUser", req.getSession().getAttribute("user"));
		
		String target =  (String) param.get("target");
		String enterpriseName=(String)param.get("enterpriseName");
		String enterpriseID = (String)param.get("enterpriseID");
		String condition = (String) param.get("condition");
		req.getSession().setAttribute("enterpriseName", enterpriseName);
		req.getSession().setAttribute("enterpriseID", enterpriseID);
		String enterprise_Name = (String)param.get("enterprise_Name");
		req.getSession().setAttribute("enterprise_Name", enterprise_Name);
		LogUtils.log("BaseController.showPaing start "+param);
		
		String username = (String)param.get("username");
		
		if(null!=enterpriseName&&!enterpriseName.trim().equals("")){
			try {
				enterpriseName = new String(enterpriseName.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			target+="_query";
		}
		
		if(null!=enterprise_Name&&!enterprise_Name.trim().equals("")){
			try {
				enterprise_Name = new String(enterprise_Name.getBytes("ISO-8859-1"), "UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(null!=condition&&!condition.trim().equals("")){
			try {
				condition = new String(condition.getBytes("ISO-8859-1"), "UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		param.put("condition", condition);
		String grades = (String)param.get("grades");
		if(!CommonUtils.isNull(grades)){
			param.put("grades", Arrays.asList(grades.split(",")));
		}else{
			param.remove("grades");
		}
		
		PagingVO paging = new PagingVO(target);
		paging.setEnterpriseName(enterpriseName);
		paging.setEnterpriseID(enterpriseID);
		paging.setEnterprise_Name(enterprise_Name);
		paging.setParam(param);
		Map<String, Object> rs = this.baseFacade.initPaging(paging);
		rs.putAll(param);
		
		if(null!=username&&!username.trim().equals("")){
			Map<String, Object> role = this.roleFacade.initRoleInfoByUsername(username);
			StringBuffer sb = new StringBuffer("");
			List<RoleVO> list = (List<RoleVO>) role.get("result");
			for(RoleVO vv : list){
				sb.append(vv.getRoleName()).append(",");
			}
			rs.put("roleName", sb.toString());
			rs.put("username", username);
		}
		
		String roleID = (String)param.get("roleID");
		if(null!=roleID&&!roleID.trim().equals("")){
			List<ActionVO> list = this.roleFacade.getActionInfoByRoleId(roleID);
			StringBuffer sb = new StringBuffer("");
			for(ActionVO ac : list){
				sb.append("<span>").append(ac.getActionName()).append("</span>");
			}
			rs.put("allAction", sb.toString());
			rs.put("roleID", roleID);
		}
		
		LogUtils.log("BaseController.showPaing end "+paging);
		if(null!=enterpriseName&&!enterpriseName.trim().equals("")){
			int index = target.indexOf("_query");
			target = target.substring(0, index);
		}
		
		return new ModelAndView(getRootPath()+target,rs);
	}
	
	public abstract String getRootPath();
	
	@RequestMapping(value="/getPagingData",method=RequestMethod.POST)
	public @ResponseBody PagingVO getPagingData(PagingVO paging,  HttpServletRequest req) {
		paging.getParam().put("sessionUser", req.getSession().getAttribute("user"));
		
		String enterpriseName=(String)req.getSession().getAttribute("enterpriseName");
		if(null!=enterpriseName&&!enterpriseName.trim().equals("")){
			String what =paging.getWhat(); 
			what+="_query";
			paging.setWhat(what);
		}
		String enterpriseID=(String)req.getSession().getAttribute("enterpriseID");
		String enterprise_Name=(String)req.getSession().getAttribute("enterprise_Name");
		paging.setEnterpriseName(enterpriseName);
		paging.setEnterpriseID(enterpriseID);
		paging.setEnterprise_Name(enterprise_Name);
		
		Map<String, Object> param = paging.getParam();
		String grades = (String)param.get("grades");
		if(!CommonUtils.isNull(grades)){
			param.put("grades", Arrays.asList(grades.split(",")));
		}else{
			param.remove("grades");
		}
		
		LogUtils.log("BaseController.getPagingData start "+paging);
		this.baseFacade.getPagingData(paging);
		LogUtils.log("BaseController.getPagingData end"+paging);
		return paging;
	}

	protected BaseFacade<?> getBaseFacade() {
		return baseFacade;
	}
	
}
