package com.istudy.server.common.vo;

import com.istudy.server.common.constants.CommonConstants;
import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.utils.JsonUtils;

public abstract class CMSVO implements IVO{
	@Override
	public String toString() {
		return JsonUtils.toString(this);
	}
	
}
