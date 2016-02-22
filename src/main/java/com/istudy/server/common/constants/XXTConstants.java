package com.istudy.server.common.constants;


import static com.istudy.server.common.utils.CommonUtils.*;

public final class XXTConstants extends CommonConstants{
	public static final String ROLE_CLASS_HEAD = "5";  //班主任角色
	
	public static final String XXT_WEBSERVICE_URL = PROPERTIES.getProperty("xxt.webservice.url");//校讯通webservice地址
	
	public static final String XXT_KEY = PROPERTIES.getProperty("xxt.key");//平台key
	
	public static final String XXT_CODE = PROPERTIES.getProperty("xxt.code");	//校讯通平台CODE
	
	public static final String SEND_SMS_INTERVAL_TIME = PROPERTIES.getProperty("send.sms.interval.time");	//发送短消息到校讯通定时任务的间隔时间
	public static final String QUERY_SEND_SMS_INTERVAL_TIME = PROPERTIES.getProperty("query.send.sms.interval.time");	//查询发送短信的间隔时间
	public static final int SEND_SMS_MAX_STUDENT_SIZE = Integer.parseInt(PROPERTIES.getProperty("send.sms.max.student.size"));	//短信发送人数上限
	//发送内容到校讯通公共账号开关
	public static final String SEND_MINISITE_XXT_PUBLIC = PROPERTIES.getProperty("send.minisite.xxt.public");	
	//校讯通公共账号系统后台URL
	public static final String XXT_APP_PUBLIC_ACCOUNT_SYSTEM_URL = PROPERTIES.getProperty("xxt.app.public.account.system.url");
	public static final String XXT_APP_PUBLIC_ACCOUNT_SYSTEM_URL_TAIL = PROPERTIES.getProperty("xxt.app.public.account.system.url.tail");
	
	public static final String XXT_APP_PUBLIC_ACCOUNT_PUBLIC_ID = PROPERTIES.getProperty("xxt.app.public.account.public.id");
	public static final String XXT_APP_PUBLIC_ACCOUNT_SERVICE_CODE = PROPERTIES.getProperty("xxt.app.public.account.service.code");
	public static final String XXT_APP_PUBLIC_ACCOUNT_DES_PASSWD = PROPERTIES.getProperty("xxt.app.public.account.desc.passwd");
	//公共账号上传图片本地地址
	public static final String XXT_APP_PUBLIC_ACCOUNT_THUMB_IMG_PATH = PROPERTIES.getProperty("xxt.app.public.account.thumb.img.path");
	//公共账号新闻筛选时间戳
	public static final String XXT_APP_PUBLIC_ACCOUNT_INTERVAL_TIME = PROPERTIES.getProperty("xxt.app.public.account.interval.time");
	
	public static final String XXT_APP_PUBLIC_ACCOUNT_TASK_INTERVAL_TIME = PROPERTIES.getProperty("xxt.app.public.account.task.interval.time");
	
	//广一模预注册接口
	public static final String XXT_MOCKEXAM_REGISTER_SYSTEM_URL = PROPERTIES.getProperty("xxt.mockexam.register.system.url");
	
	public static final String XXT_MOCKEXAM_REPORT_SYSTEM_URL = PROPERTIES.getProperty("xxt.mockexam.report.system.url");
	
	public static final String SEND_TYPE_NOW = "0";	//及时发送
	
	public static final String SEND_TYPE_TIMING = "1";//定时发送
	
	public static final String SEND_CLASS = "0";	//发班级
	
	public static final String SEND_STUDENT = "1";//法学生
	
	public static final String MINISITE_URL_TAILS = "xxtM/mPage.do.do?uri=";	//minisite页面URL
	
	public static final String SEND_SMS_STATUS_WAITING = "0";// 待发送
	public static final String SEND_SMS_STATUS_SENDING = "1";//发送中
	public static final String SEND_SMS_STATUS_SENDED = "2";//已发送
	public static final String SEND_SMS_STATUS_SUCCESS = "3";//发送成功
	public static final String SEND_SMS_STATUS_FAILED = "4";//发送失败
//	public static final String SEND_SMS_STATUS_SY = "5";
	
	//校讯通角色名称匹配
	public static final String XXT_ROLENAME_REGEX = PROPERTIES.getProperty("xxt.rolename.regex");
}

