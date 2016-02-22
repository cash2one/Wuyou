package com.istudy.server.common.utils;

import org.apache.cxf.jaxrs.client.WebClient;

import com.istudy.server.xxt.vo.HisTaskVO;

public class HttpUtils {
	public static <T>T doPost(String uri,String resourceUrl,Object body, Class<T> responseClass){
		WebClient  client = WebClient.create(uri);
		return  client.path(resourceUrl).accept("application/json").post(body, responseClass);
	}
	
	public static <T>T doGet(String uri,String resourceUrl, Class<T> responseClass){
		WebClient  client = WebClient.create(uri);
		return  client.path(resourceUrl).accept("application/json").get(responseClass);
	}
	//http://120.197.89.182:7000/mobile/pull/outinter/pubacc
	public static void main(String[] args) {
		HisTaskVO task = new HisTaskVO();
		task.setTaskId("132");
		String json = JsonUtils.toJSON(task);
		String resp = HttpUtils.doGet("http://wuyou.istudy.com.cn/", 
				"xxtM/0/appuser/1261/160119qz.do",  String.class);
		
		System.out.println(JsonUtils.toJSON(resp));
		/*String json = "";
		//Base64.encode()
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(int i = 0 ;i<2 ;i++){
			Map<String,Object> m = new HashMap<String,Object>();
			m.put("default", "0");//默认消息类型
			m.put("content", "消息标题");//
			m.put("thumb", "http://avatar.csdn.net/1/3/A/1_xjtuse_mal.jpg");
			m.put("original", "http://avatar.csdn.net/1/3/A/1_xjtuse_mal.jpg");
			m.put("url", "http://blog.csdn.net/xjtuse_mal/article/details/6925912");
			list.add(m);
		}
		String resourceUrl = "mobile/pull/outinter/pubacc";
		String resp = HttpUtils.doPost(XXTConstants.XXT_APP_PUBLIC_ACCOUNT_SYSTEM_URL, 
				resourceUrl, null, String.class);
		System.out.println(resp);*/
		
	}
}
