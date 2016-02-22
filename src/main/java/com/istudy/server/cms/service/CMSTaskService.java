package com.istudy.server.cms.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import com.istudy.server.cms.vo.CMSTaskVO;
import com.istudy.server.cms.vo.DeleteTaskVO;
import com.istudy.server.cms.vo.IstudyContentVO;
import com.istudy.server.cms.vo.IstudyResultVO;
import com.istudy.server.cms.vo.PublicAccountMsgContentVO;
import com.istudy.server.cms.vo.PublicAccountMsgResultVO;
import com.istudy.server.cms.vo.PublicAccountMsgVO;
import com.istudy.server.common.constants.CMSConstants;
import com.istudy.server.common.constants.IstudyConstants;
import com.istudy.server.common.constants.XXTConstants;
import com.istudy.server.common.exception.CMSException;
import com.istudy.server.common.service.BaseService;
import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.utils.EncryptionUtils;
import com.istudy.server.common.utils.HtmlUtils;
import com.istudy.server.common.utils.HttpUtils;
import com.istudy.server.common.utils.JsonUtils;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.validate.utils.ValidateUtils;

@Service("cmsTaskService")
public class CMSTaskService extends BaseService{
	
	public void saveTaskInfo(CMSTaskVO task){
		this.baseDAO.insert(task);
	}
	public void modiTaskInfo(CMSTaskVO task){
		this.baseDAO.update(task);
	}
	
	public CMSTaskVO getCMSXXTTaskInfoById(String taskId){
		return this.baseDAO.selectOne(taskId);
	}
	
	public void delCMSTaskByID(String id){
		this.baseDAO.delete(id);
	}
	
	public void delCMSTaskByMinisiteID(String id){
		this.baseDAO.delete(id);
	}
	
	public CMSTaskVO getCMSTaskInfoById(String taskId){
		return this.baseDAO.selectOne(taskId);
	}
	
	/*public static void main(String[] args) {
		CMSTaskService c = new CMSTaskService();
		CMSTaskVO task = new CMSTaskVO();
		task.setTaskName("广州出太阳了");
		task.setCitys(",zs,dg,zq,gz,sz,fs,zh,hz,jm,sg,hy,mz,sw,yj,zj,mm,qy,cz,jy,yf,st,");
		task.setGrades(",10,11,12,");
		c.sendSource2xxtAppSystem(task);
	}*/
	
	
	/*****************推送校讯通APP公共账号相关************************/
	public void saveTaskInfoForXXT(CMSTaskVO task) {
		this.baseDAO.insert(task);
	}
	public void modiTaskInfoForXXT(CMSTaskVO task) {
		this.baseDAO.update(task);
	}
	public void delCMSTaskForXXTByID(String id) {
		this.baseDAO.delete(id);
	}
	public CMSTaskVO getCMSTaskInfoForXXTById(String taskId) {
		return this.baseDAO.selectOne(taskId);
	}
	public List<CMSTaskVO> getWillSendXXTPublicAccount(String times){
		return this.baseDAO.selectList(times);
	}
	public void updateSendPublicStatusSuccessForXXT(String id){
		this.baseDAO.update(id);
	}
	public void sendSource2xxtAppSystem(CMSTaskVO task){
		String resourceUrl = XXTConstants.XXT_APP_PUBLIC_ACCOUNT_SYSTEM_URL_TAIL;
		
		PublicAccountMsgContentVO pac = new PublicAccountMsgContentVO();
		pac.setIsDefault("0");
		//XXTConstants.XXT_APP_PUBLIC_ACCOUNT_THUMB_IMG_PATH
		pac.setThumb(CMSConstants.DOMAIN_NAME+XXTConstants.XXT_APP_PUBLIC_ACCOUNT_THUMB_IMG_PATH+task.getNewsThumbImg());
		pac.setTitle(task.getTaskName());
		pac.setUrl(CMSConstants.DOMAIN_NAME+XXTConstants.MINISITE_URL_TAILS+task.getMiniUrl());
		List<PublicAccountMsgContentVO> l = new ArrayList<PublicAccountMsgContentVO>();
		l.add(pac);
		PublicAccountMsgVO msg = new PublicAccountMsgVO(XXTConstants.XXT_APP_PUBLIC_ACCOUNT_SERVICE_CODE,
				XXTConstants.XXT_APP_PUBLIC_ACCOUNT_PUBLIC_ID,
				"0",CommonUtils.delHeadAndLashChar(task.getCitys()),
				CommonUtils.delHeadAndLashChar(task.getGrades()),l
				);
		String json = JsonUtils.toJSON(msg);
		LogUtils.L.info("请求校讯通接口:"+json);
		String body = null;
		try {
			 body =EncryptionUtils.bytes2Hex(EncryptionUtils.desEncode(json.getBytes("UTF-8"),
					 XXTConstants.XXT_APP_PUBLIC_ACCOUNT_DES_PASSWD));
		} catch (UnsupportedEncodingException e) {
			throw new CMSException(e);
		}
		//LogUtils.L.info("加密后的字符串:"+body);
		String client = HttpUtils.doPost(XXTConstants.XXT_APP_PUBLIC_ACCOUNT_SYSTEM_URL, 
				resourceUrl, body, String.class);
		LogUtils.L.info("校讯通接口返回:"+client);
		PublicAccountMsgResultVO rs = JsonUtils.toObj(client, PublicAccountMsgResultVO.class);
		if(!"1".equals(rs.getState())){
			throw new CMSException("请求校讯通APP公共账号错误,接口返回:"+rs.getState());
		}
		//修改发送状态
		updateSendPublicStatusSuccessForXXT(task.getId());
	}
	
	/*****************推送爱学网APP相关************************/
	public void saveTaskInfoForIstudy(CMSTaskVO task) {
		this.baseDAO.insert(task);
	}
	public void modiTaskInfoForIstudy(CMSTaskVO task) {
		this.baseDAO.update(task);
	}
	public void delCMSTaskForIstudyByID(String id) {
		this.baseDAO.delete(id);
	}
	public CMSTaskVO getCMSTaskInfoForIstudyById(String taskId) {
		return this.baseDAO.selectOne(taskId);
	}
	public List<CMSTaskVO> getWillSendIstudyTasks(String times){
		return this.baseDAO.selectList(times);
	}
	public void updateSendPublicStatusSuccessForIstudy(String id){
		this.baseDAO.update(id);
	}
	public void sendSource2IstudyApp(List<CMSTaskVO> tasks) {
		if(tasks == null || tasks.isEmpty()){
			return;
		}
		
		List<IstudyContentVO> contents = new ArrayList<IstudyContentVO>();
		
		for(CMSTaskVO task : tasks){
			IstudyContentVO content = new IstudyContentVO();
			content.setType(task.getType());
			content.setTitle(task.getTaskName());
			content.setContent(task.getMsgDetails());
			content.setAreaIds(task.getCityIdList());
			content.setGradeIds(task.getGradeIdList());
			content.setThumb(CMSConstants.DOMAIN_NAME + IstudyConstants.ISTUDY_APP_THUMB_IMG_PATH + task.getNewsThumbImg());
			content.setUrl(CMSConstants.DOMAIN_NAME + XXTConstants.MINISITE_URL_TAILS + task.getMiniUrl());
			
			contents.add(content);
		}
		String json = JsonUtils.toJSON(contents);
		LogUtils.L.info("请求爱学网APP接口:"+json);
		String body = null;
		try {
			 body = EncryptionUtils.bytes2Hex(EncryptionUtils.desEncode(json.getBytes("UTF-8"),
					 IstudyConstants.ISTUDY_APP_SYSTEM_KEY));
		} catch (UnsupportedEncodingException e) {
			throw new CMSException(e);
		}
		//LogUtils.L.info("加密后的字符串:"+body);
		String client = HttpUtils.doPost(IstudyConstants.ISTUDY_APP_SYSTEM_URL, 
				"", body, String.class);
		LogUtils.L.info("爱学网APP接口返回:"+client);
		IstudyResultVO rs = JsonUtils.toObj(client, IstudyResultVO.class);
		if(!"00000".equals(rs.getCode())){
			throw new CMSException("请求爱学网APP接口返回错误,接口返回:"+rs.getDesc());
		}
		//批量修改发送状态
		for(CMSTaskVO task : tasks){
			updateSendPublicStatusSuccessForIstudy(task.getId());
		}
	}
	/*****************推送校园+APP相关************************/
	public void saveTaskInfoForXiaoyuan(CMSTaskVO task) {
		this.baseDAO.insert(task);
	}
	public void modiTaskInfoForXiaoyuan(CMSTaskVO task) {
		this.baseDAO.update(task);
	}
	public void delCMSTaskForXiaoyuanByID(String id) {
		this.baseDAO.delete(id);
	}
	public CMSTaskVO getCMSTaskInfoForXiaoyuanById(String taskId) {
		return this.baseDAO.selectOne(taskId);
	}
	public List<CMSTaskVO> getWillSendXiaoyuanTasks(String times){
		return this.baseDAO.selectList(times);
	}
	public void updateSendPublicStatusSuccessForXiaoyuan(String id){
		this.baseDAO.update(id);
	}
	
	public void updateSendNoticePublicStatusSuccessForXiaoyuan(String id){
		this.baseDAO.update(id);
	}
	
	public void sendXiaoyuanApp(List<CMSTaskVO> tasks) {
		if(tasks == null || tasks.isEmpty()){
			return;
		}
		
		for(CMSTaskVO task : tasks){
			IstudyResultVO rs = doSendHttpPostRequest(task);
			if(!"00000".equals(rs.getCode())){
				//throw new CMSException("请求校园＋APP文章推送接口出错:"+rs.getDesc());
				LogUtils.log("请求校园＋APP文章推送接口出错:"+rs.getDesc()+tasks);
				continue;
			}
			updateSendPublicStatusSuccessForXiaoyuan(task.getId());
		}
	}
	
	public List<CMSTaskVO> getWillSendXiaoyuanNoticeTasks(String times){
		return this.baseDAO.selectList(times);
	}
	
	public void sendArticleNotice2IstudyApp(List<CMSTaskVO> tasks) {
		// TODO Auto-generated method stub
		if(tasks == null || tasks.isEmpty()){
			return;
		}
		
		for(CMSTaskVO task : tasks){
			IstudyResultVO rs = doSendHttpPostRequest2(task);
			if(!"00000".equals(rs.getCode())){
				//throw new CMSException("请求校园＋APP文章推送接口出错:"+rs.getDesc());
				LogUtils.log("请求校园＋APP文章预告推送接口出错:"+rs.getDesc()+tasks);
				continue;
			}
			updateSendNoticePublicStatusSuccessForXiaoyuan(task.getId());
		}
		
	}
	
	private IstudyResultVO doSendHttpPostRequest2(CMSTaskVO task) {
		CloseableHttpClient httpclient = createCloseableHttpClient();
		String msg = null;
		try {
			HttpPost httppost = createSendHttpPost2(task);
			try {
				LogUtils.L.info("请求校园＋APP文章预告推送接口请求:"+httppost.getRequestLine()+task);
				CloseableHttpResponse response = httpclient.execute(httppost);
				IstudyResultVO rs = doResponse(response);
				LogUtils.L.info("请求校园＋APP文章预告推送接口返回:"+rs+task);
				return rs;
			} finally{
				if(httppost != null){
					httpclient.close();
				}
			}
		}catch(Exception e){
			msg = e.getMessage();
			e.printStackTrace();
		}
		return new IstudyResultVO("-1",msg);
	}
	

	private HttpPost createSendHttpPost2(CMSTaskVO task) throws ParseException {
		String hasImage;

		Date a = new Date();
		
		a = ValidateUtils.stringToDate(task.getActiveDate(),"yyyy-MM-dd HH:mm:ss");
		
		long b = a.getTime();
		
		String activeTime = Long.toString(b);
		
		List<String> imageUrls = HtmlUtils.extractImageUrlsFromHtml(task.getMiniDetails());
		if(imageUrls==null){
			hasImage="0";	
		}else{
			hasImage="1";
		}
		
		//long activeTime =  Long.parseLong(task.getActiveDate());
		HttpPost httppost = createHttpPostEntity(IstudyConstants.ISTUDY_APP_ARTICLE_SEND_NOTICE_URL);
		
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		ContentType type = getDefaultContentType();
		
		extractImages(builder,task);
		extractContent(builder,task,type);
		//builder.addTextBody("articleId", task.getMinisiteId(), type);
		//builder.addTextBody("type",task.getSourceType(), type);
		builder.addTextBody("activeTime",activeTime, type);
		
		builder.addTextBody("title",task.getMiniTitle(), type);
		builder.addTextBody("hasImage",hasImage, type);
		builder.addTextBody("grades",CommonUtils.delHeadAndLashChar(task.getGrades()) ,type);

		
		httppost.setEntity(builder.build());
		return httppost;
	}
	
	
	/*********推送文章至校园＋**********/
	public List<CMSTaskVO> getWillSendIstudyArticleTasks(String times){
		return this.baseDAO.selectList(times);
	}
	
	public void updateSendArticleStatusSuccess(String id){
		this.baseDAO.update(id);
	}
	
	public void sendArticle2IstudyApp(List<CMSTaskVO> tasks) {
		if(tasks == null || tasks.isEmpty()){
			return;
		}
		
		for(CMSTaskVO task : tasks){
			IstudyResultVO rs = doSendHttpPostRequest(task);
			if(!"00000".equals(rs.getCode())){
				//throw new CMSException("请求校园＋APP文章推送接口出错:"+rs.getDesc());
				LogUtils.log("请求校园＋APP文章推送接口出错:"+rs.getDesc()+tasks);
				continue;
			}
			updateSendPublicStatusSuccessForXiaoyuan(task.getId());
		}
	}
	
	private IstudyResultVO doSendHttpPostRequest(CMSTaskVO task) {
		CloseableHttpClient httpclient = createCloseableHttpClient();
		String msg = null;
		try {
			HttpPost httppost = createSendHttpPost(task);
			try {
				LogUtils.L.info("请求校园＋APP文章推送接口请求:"+httppost.getRequestLine()+task);
				CloseableHttpResponse response = httpclient.execute(httppost);
				IstudyResultVO rs = doResponse(response);
				LogUtils.L.info("请求校园＋APP文章推送接口返回:"+rs+task);
				return rs;
			} finally{
				if(httppost != null){
					httpclient.close();
				}
			}
		}catch(Exception e){
			msg = e.getMessage();
			e.printStackTrace();
		}
		return new IstudyResultVO("-1",msg);
	}
	
	
	private static IstudyResultVO doResponse(CloseableHttpResponse response)
			throws IOException {
		StringBuilder msg = new StringBuilder();
		InputStream is = response.getEntity().getContent();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader reader = new BufferedReader(isr);
		String str = null;
		while((str = reader.readLine()) != null){
			msg.append(str);
		}
		reader.close();
		IstudyResultVO rs = JsonUtils.toObj(msg.toString(), IstudyResultVO.class);
		return rs;
	}
	
	
	private HttpPost createSendHttpPost(CMSTaskVO task) {
		HttpPost httppost = createHttpPostEntity(IstudyConstants.ISTUDY_APP_ARTICLE_SEND_URL);
		
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		ContentType type = getDefaultContentType();
		
		extractImages(builder,task);
		extractContent(builder,task,type);
		builder.addTextBody("articleId", task.getMinisiteId(), type);
		builder.addTextBody("type",task.getSubjectType(), type);
		builder.addTextBody("title",task.getMiniTitle(), type);
		builder.addTextBody("grades",CommonUtils.delHeadAndLashChar(task.getGrades()) ,type);
		if(task.getSubjectType().equals("1")){
			builder.addTextBody("summary", task.getMiniShortDetails(), type);
			if(!CommonUtils.isNull(task.getFaqs())){
				builder.addTextBody("faqs",task.getFaqs(),type);
			}
			
		}

		
		httppost.setEntity(builder.build());
		return httppost;
	}
	private ContentType getDefaultContentType() {
		ContentType type = ContentType.APPLICATION_JSON;
		return type;
	}
	
	private void extractContent(MultipartEntityBuilder builder, CMSTaskVO task,
			ContentType type) {
		String content = HtmlUtils.extractTextFromHtml(task.getMiniDetails());
		builder.addTextBody("content",  content, type);
	}
	
	private void extractImages(MultipartEntityBuilder builder, CMSTaskVO task) {
		String localImageBasePath = this.getLocalImageBasePath();
		List<String> imageUrls = HtmlUtils.extractImageUrlsFromHtml(task.getMiniDetails());
		for(String url : imageUrls){
			try {
				File file = new File(url.replace(CMSConstants.DOMAIN_NAME, localImageBasePath));
				if(file.exists()){
					FileBody imageBody = new FileBody(file);
					builder.addPart("images", imageBody);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private String getLocalImageBasePath() {
		URL classPath = this.getClass().getClassLoader().getResource("");
		String webroot = classPath.getPath() + "../../";
		File file = new File(webroot + "img");
		if(file.exists()){
			return webroot;
		}
		webroot = classPath.getPath() + "../IstudyServer3.0/";
		file = new File(webroot + "img");
		if(file.exists()){
			return webroot;
		}
		return null;
	}
	
	private CloseableHttpClient createCloseableHttpClient() {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		return httpclient;
	}
	
	private HttpPost createHttpPostEntity(String url) {
		HttpPost httppost = new HttpPost(url);
		//httppost.setHeader("accessToken","U140331164450266541c9|1396255495544|0");
		return httppost;
	}
	
	public static void main(String[] args) throws URISyntaxException, ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
		HttpPost httppost = new HttpPost("http://10.0.0.168:8080/" + "IstudySns/status/push.do");
		FileBody bin2 = new FileBody(new File("D:\\testphones.txt"));
		httppost.setHeader("accessToken", "U140331164450266541c9|1396255495544|0");
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		ContentType type = ContentType.create("text/plain", Consts.UTF_8);
		builder.addPart("images", bin2);
		builder.addTextBody("content", "真的很不错", type);
		builder.addTextBody("articleId", "1", type);

		HttpEntity reqEntity = builder.build();
		httppost.setEntity(reqEntity);
		System.out.println("executing request " + httppost.getRequestLine());
		CloseableHttpResponse response = httpclient.execute(httppost);
		
		IstudyResultVO rs = doResponse(response);
		
		System.out.println(rs);
		} finally {
		httpclient.close();
		} 
	}
	public List<DeleteTaskVO> getDeleteTaskList(CMSTaskVO task) {
		// TODO Auto-generated method stub
		String rule = task.getRule();
		if(CommonUtils.isNull(task.getMsgId())){
			return null;
		}else{
			String[] ids = task.getMsgId().split(",");
			String[] msgId;
			List<DeleteTaskVO> dtv1 = new ArrayList<>();
			
			if(rule.equals("1")){
				for(int i=0;i<ids.length;i++){
					DeleteTaskVO dtv = new DeleteTaskVO();
					msgId = ids[i].split("_");
					if(!ids[0].equals("del")){
						dtv.setCityId(msgId[0]);
						dtv.setSchoolId(msgId[1]);
						dtv1.add(dtv);
					}
					
				}
			}
			else if(rule.equals("2")){
				for(int i=0;i<ids.length;i++){
					DeleteTaskVO dtv = new DeleteTaskVO();
					msgId = ids[i].split("_");
					if(!ids[0].equals("del")){
					dtv.setCityId(msgId[0]);
					dtv.setGrade(msgId[1]);
					dtv1.add(dtv);
					}
					
				}
			}
			else if(rule.equals("3")){
				for(int i=0;i<ids.length;i++){
					DeleteTaskVO dtv = new DeleteTaskVO();
					msgId = ids[i].split("_");
					if(!ids[0].equals("del")){
					dtv.setCityId(msgId[0]);
					dtv.setSchoolId(msgId[1]);
					dtv.setGrade(msgId[2]);
					dtv1.add(dtv);
					}
					
				}
			}
			return dtv1;
		}
		
		
		}
	public void setTop(String id) {
		// TODO Auto-generated method stub
		this.baseDAO.update(id);
	}
	public void removeTop(String id) {
		// TODO Auto-generated method stub
		this.baseDAO.delete(id);
	}
		

	
}
