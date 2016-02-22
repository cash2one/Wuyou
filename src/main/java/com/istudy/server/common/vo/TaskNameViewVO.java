package com.istudy.server.common.vo;

import com.istudy.server.common.constants.CommonConstants;
import com.istudy.server.common.utils.CommonUtils;

public abstract class TaskNameViewVO extends CMSVO{
	public String getTaskName_(){
		String taskName = getTaskName();
		if(!CommonUtils.isNull(taskName)&&taskName.length()>CommonConstants.TASK_NAME_VIEW_SIZE){
			return taskName.substring(0, CommonConstants.TASK_NAME_VIEW_SIZE);
		}
		return taskName;
	}
	
	public abstract String getTaskName();
}
