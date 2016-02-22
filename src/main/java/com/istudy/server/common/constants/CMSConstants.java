package com.istudy.server.common.constants;

import com.istudy.server.common.utils.CommonUtils;

public class CMSConstants extends CommonConstants{
	public static final String VM_IMAGE_TEXT_FILE = "image-text.vm"; //图文模板文件
	public static final String VM_VIDEO_FILE = "video.vm"; //视频模板文件
	public static final String TEMPLATE_FILE_TAIL = ".jsp";
	public static final String USER_NAME_KEY = "userName";
	public static final String DOMAIN_NAME = CommonUtils.PROPERTIES.getProperty("domain.name");
}
