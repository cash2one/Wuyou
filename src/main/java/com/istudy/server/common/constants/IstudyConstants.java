package com.istudy.server.common.constants;

import static com.istudy.server.common.utils.CommonUtils.PROPERTIES;

public class IstudyConstants {
	
	//爱学网系统后台URL
	public static final String ISTUDY_APP_SYSTEM_BASEURL = PROPERTIES.getProperty("istudy.app.system.baseUrl");
	public static final String ISTUDY_APP_SYSTEM_URL = PROPERTIES.getProperty("istudy.app.system.url");
	public static final String ISTUDY_APP_SYSTEM_KEY = PROPERTIES.getProperty("istudy.app.system.key");
	//爱学网上传图片本地地址
	public static final String ISTUDY_APP_THUMB_IMG_PATH = PROPERTIES.getProperty("istudy.app.thumb.img.path");
	
	public static final String ISTUDY_APP_INTERVAL_TIME = PROPERTIES.getProperty("istudy.app.interval.time");
	public static final String ISTUDY_APP_TASK_INTERVAL_TIME = PROPERTIES.getProperty("istudy.app.task.interval.time");
	
	//校园＋ 老师发送文章接口地址
	public static final String ISTUDY_APP_ARTICLE_SEND_URL = ISTUDY_APP_SYSTEM_BASEURL + PROPERTIES.getProperty("istudy.app.article.send.url");
	public static final String ISTUDY_APP_ARTICLE_SYNC_URL = ISTUDY_APP_SYSTEM_BASEURL + PROPERTIES.getProperty("istudy.app.article.sync.url");
	public static final String ISTUDY_APP_ARTICLE_SEND_NOTICE_URL = ISTUDY_APP_SYSTEM_BASEURL + PROPERTIES.getProperty("istudy.app.article.send.notice.url");
}
