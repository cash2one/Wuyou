package com.istudy.server.xxt.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istudy.server.cms.vo.CMSTaskVO;
import com.istudy.server.cms.vo.IstudyResultVO;
import com.istudy.server.common.constants.IstudyConstants;
import com.istudy.server.common.constants.XXTConstants;
import com.istudy.server.common.dao.BaseDAO;
import com.istudy.server.common.exception.CMSException;
import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.utils.JsonUtils;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.xxt.vo.HisTaskVO;
import com.istudy.server.xxt.vo.KeyVO;
import com.istudy.server.xxt.vo.XXTGetTasksParamVO;
import com.istudy.server.xxt.vo.XXTTeacherAuthVO;

@Service("xxtTaskService")
public class XXTTaskService {
	
	@Autowired(required=true)
	private BaseDAO baseDAO;
	
	public List<HisTaskVO> getTaskTitleList(XXTGetTasksParamVO param){
		return this.baseDAO.selectList(param);
	}
	
	public void saveTeacherSendMsgInfo(HisTaskVO task){
		this.baseDAO.insert(task);
	}
	
	public HisTaskVO getHisTaskVOById(String id){
		return this.baseDAO.selectOne(id);
	}
	
	public void delHisTaskByMinisiteID(String minisiteId){
		this.baseDAO.delete(minisiteId);
	}
	
	public void modHisTaskStatusInfo(HisTaskVO task){
		this.baseDAO.update(task);
	}
	
	public void modHisTaskStatusInfo1(HisTaskVO task){
		this.baseDAO.update(task);
	}
	
	public List<HisTaskVO> getCMSTaskByStatus(String param){
		return this.baseDAO.selectList(param);
	}
	
	public List<CMSTaskVO> getCMSTaskByStatus2(String param){
		return this.baseDAO.selectList(param);
	}
	/**
	 * 发送任务到校讯通公共账号
	 * 
	 * @param task
	 */
	public void sendTask2XXTPublicAccountService(List<HisTaskVO> tasks){
		
		for(HisTaskVO t : tasks){
			Map<String,Object> v = new HashMap<String,Object>();
			//v.put("default", t.get)
		}
		
		//EncryptionUtils.bytes2Hex(bts)
		
	}
	
	
	public List<HisTaskVO> getWillSyncIstudyArticleTasks(String days){
		return this.baseDAO.selectList(days);
	}
	
	public void updateSyncArticleStatusSuccess(String id){
		this.baseDAO.update(id);
	}
	
	
	public void syncArticleSendStatus2IstudyApp(List<HisTaskVO> tasks) {
		if(tasks == null || tasks.isEmpty()){
			return;
		}
		for(HisTaskVO task : tasks){
			IstudyResultVO rs = doSyncHttpPostRequest(task);
			if(!"00000".equals(rs.getCode())){
				throw new CMSException("请求校园＋APP文章推送状态同步接口出错:"+rs.getDesc());
			}
			updateSyncArticleStatusSuccess(task.getId());
		}
	}
	private CloseableHttpClient createCloseableHttpClient() {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		return httpclient;
	}
	
	private IstudyResultVO doSyncHttpPostRequest(
			HisTaskVO task) {
		String msg = null;
		try {
			CloseableHttpClient httpclient = createCloseableHttpClient();
			HttpPost httppost = createSyncHttpPost(task);
			try {
				LogUtils.L.info("请求校园＋APP文章推送状态同步接口请求:"+httppost.getRequestLine());
				CloseableHttpResponse response = httpclient.execute(httppost);
				IstudyResultVO rs = doResponse(response);
				LogUtils.L.info("请求校园＋APP文章推送状态同步接口返回:"+rs);
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
	
	
	
	private HttpPost createSyncHttpPost(HisTaskVO task) {
		HttpPost httppost = createHttpPostEntity(IstudyConstants.ISTUDY_APP_ARTICLE_SYNC_URL);
		
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		ContentType type = ContentType.APPLICATION_JSON;
		
		builder.addTextBody("xxtTeacherId", task.getUserId(), type);
		builder.addTextBody("articleId", task.getMinisiteId(), type);

		httppost.setEntity(builder.build());
		return httppost;
	}
	
	
	private HttpPost createHttpPostEntity(String url) {
		HttpPost httppost = new HttpPost(url);
		//httppost.setHeader("accessToken","U140331164450266541c9|1396255495544|0");
		return httppost;
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

	public void modCMSTaskStatusInfo(CMSTaskVO task1) {
		// TODO Auto-generated method stub
		task1.setSendPublicStatus("5");
		this.baseDAO.update(task1);
	}

	public void updateFailedSchools(CMSTaskVO task1) {
		this.baseDAO.update(task1);
	}

	public void updateFailedGrades(CMSTaskVO task1) {
		this.baseDAO.update(task1);
	}

	public void updateCMSTaskInfo(CMSTaskVO task1) {
		// TODO Auto-generated method stub
		this.baseDAO.update(task1);
	}

	public void updateXXTSmsSnInfo(HisTaskVO task) {
		// TODO Auto-generated method stub
		this.baseDAO.update(task);
	}

	public List<KeyVO> getKeyByCityUserId(KeyVO k) {
		// TODO Auto-generated method stub
		return this.baseDAO.selectList(k);
	}

	public void updateKeyUser(KeyVO key) {
		// TODO Auto-generated method stub
		this.baseDAO.update(key);
	}

	public void updateCMSTaskInfo1(CMSTaskVO dtv) {
		// TODO Auto-generated method stub
		this.baseDAO.update(dtv);
	}

	public List<CMSTaskVO> getXXTTask4pcByTeacher(XXTTeacherAuthVO teacher) {
		return baseDAO.selectList(teacher);
	}
}
