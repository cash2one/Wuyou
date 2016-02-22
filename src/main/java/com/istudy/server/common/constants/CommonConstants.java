package com.istudy.server.common.constants;

import com.istudy.server.common.utils.CommonUtils;

public class CommonConstants {
	public static final String PAGING_SIZE = CommonUtils.PROPERTIES.getProperty("paging.size");
	
	//public static final String PROJECT_PATH = System.getProperty("user.dir")+"/";
	
	public static final int TASK_NAME_VIEW_SIZE = 20;	//任务名称显示最大长度
	
	public static final String MINI_TYPE_TEXT="0";		//minisite类型,文本类型
}
