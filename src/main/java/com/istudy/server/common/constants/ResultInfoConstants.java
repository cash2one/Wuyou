package com.istudy.server.common.constants;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public final class ResultInfoConstants extends CommonConstants{
	
	/**错误码**/
	public static String CODE_SUCCESS = "10000";
	public static String CODE_SERVER_ERROR = "10001";
	public static String CODE_OPERATE_FAILED = "10002";
	public static String CODE_USER_NOT_EXIST_FAILED = "10003";
	public static String CODE_SESSION_LOSE = "10004";
	public static String CODE_PASSWORD_FAILED = "10005";
	public static String CODE_ILLEGAL_ARGUMENT = "10006";
	public static String CODE_PERMISSION_INSUFFICIENT = "10007";
	
	/**错误提示**/
	public static String DESC_SUCCESS = "操作成功" ;		
	public static String DESC_SERVER_ERROR = "服务器内部错误";
	public static String DESC_OPERATE_FAILED = "操作失败";
	public static String DESC_USER_NOT_EXIST_FAILED = "用户不存在";
	public static String DESC_SESSION_LOSE = "未登录";
	public static String DESC_PASSWORD_FAILED = "密码错误";
	public static String DESC_ILLEGAL_ARGUMENT = "参数校验失败";
	public static String DESC_PERMISSION_INSUFFICIENT = "您的操作权限不足，请联系管理员！";
	
	public static Map<String,String> RESULT = null; 
	
	static{
		RESULT = new HashMap<String,String>(){{
			put(CODE_USER_NOT_EXIST_FAILED, DESC_USER_NOT_EXIST_FAILED);
			put(CODE_SUCCESS, DESC_SUCCESS);
			put(CODE_SERVER_ERROR, DESC_SERVER_ERROR);
			put(CODE_OPERATE_FAILED, DESC_OPERATE_FAILED);
			put(CODE_SESSION_LOSE, DESC_SESSION_LOSE);
			put(CODE_PASSWORD_FAILED, DESC_PASSWORD_FAILED);
			put(CODE_ILLEGAL_ARGUMENT, DESC_ILLEGAL_ARGUMENT);
			put(CODE_PERMISSION_INSUFFICIENT, DESC_PERMISSION_INSUFFICIENT);
		}};
	}
}
