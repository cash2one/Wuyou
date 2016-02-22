package com.istudy.server.common.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.istudy.server.common.exception.CMSException;

public class VelocityUtils {
	
	/**
	 * 
	 * @param velocityEngine
	 * @param model 参数对象
	 * @param webParentPath 系统web目录
	 * @param source vm文件地址
	 * @param taget html存放地址
	 */
	public static void work(VelocityEngine velocityEngine,Map<String, Object> model,
			String webParentPath,String source,String taget) {
		String result = null;
		String uri = webParentPath+"/WEB-INF/jsp/xxt/minisite/";
		CommonUtils.createPath(uri);
		try {
			model.put("istudy_name", "进入爱学网");
			result = VelocityEngineUtils.mergeTemplateIntoString(
					velocityEngine, "com/istudy/server/velocity/"+source, "UTF-8", model);
			String toPath = uri+taget;
			PrintWriter writer = new PrintWriter(toPath);
			writer.println(result);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			throw new CMSException(e);
		}
	}
 
}
