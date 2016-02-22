package com.istudy.server.common.protocol.ws.xxt;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.istudy.server.common.constants.XXTConstants;
import com.istudy.server.common.exception.CMSException;
import com.istudy.server.common.protocol.ws.xxt.vo.XXTWSRequestBody;
import com.istudy.server.common.protocol.ws.xxt.vo.XXTWSRequestBody.SmsList;
import com.istudy.server.common.protocol.ws.xxt.vo.XXTWSRequestBody.SmsList.SmsEntity;
import com.istudy.server.common.utils.EncryptionUtils;
import com.istudy.server.common.utils.JsonUtils;
import com.istudy.server.xxt.service.XXTWSService;
import com.istudy.server.xxt.vo.ClassVO;

public class XXTServiceMain {
	
	private static final Log LOG = LogFactory.getLog(XXTServiceMain.class);
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSSS");
	
	public static final String XXT_RESPONSE_SUCCESS_CODE = "200"; 
	
	public static Request iniRequest(String type,String body){
		String timestamp = sdf.format(new Date());
		Request req = new Request(
				XXTConstants.XXT_CODE,
				"1.0",
				"83896097",
				timestamp);
		//请求一个XML文本
		req.setBody(body);
		req.setMsgType(type);
		req.setSkey(getKey(req));
		return req;
	}
	
	public static Response requestXXT(String type,String body){
		Request req = iniRequest(type,body);
		//LOG.info(req);
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(Cmcc.class);
		factory.setAddress(XXTConstants.XXT_WEBSERVICE_URL);
		System.setProperty("org.apache.cxf.bus.factory", "org.apache.cxf.bus.CXFBusFactory");
		Cmcc cmccService = (Cmcc) factory.create();
		Response res = cmccService.edu(req);
		//LOG.info(res);
		String code = res.getResult();
		if(XXT_RESPONSE_SUCCESS_CODE.equals(code)){
			return res;
		}
		throw new CMSException("调用校讯通接口错误,请求详情："+JsonUtils.toString(req)+"\n返回详情："+JsonUtils.toString(res));
	}
	
	public static String getKey(Request req){
		String beforeMD5 = XXTConstants.XXT_CODE +req.getTimeStamp()+req.getMsgSeq()+req.getMsgType()+XXTConstants.XXT_KEY;
		return EncryptionUtils.md5(beforeMD5);
	} 
	
	public static void main(String[] args) {
		/*System.out.println(XXTConstants.XXT_CODE);
		System.out.println(XXTConstants.XXT_WEBSERVICE_URL);
		
		
		XXTWSRequestBody rb = new XXTWSRequestBody();
		
		rb.setOthMsgId("gz_169055_12_158");
		rb.setReason("Too bad!");
		
		Response res = requestXXT("DEL_SYS_MESSAGE",rb.toXML());
		System.out.println(res);
		*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody("gz","1751539",null);
		Response res = requestXXT("QRY_CLASS_STUDENT",rb.toXML());
		System.out.println(res.getBody());*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setCityId("gz");
		rb.setStudentId("3697161");
		Response res = requestXXT("QRY_BASEDATA",rb.toXML());
		System.out.println(res.getBody());*/
		
		//XXTWSRequestBody rb = new XXTWSRequestBody();
		
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		//rb.setTeacherId("3161547");
		rb.setClassId("1406044");
		rb.setCityId("gz");
		Response res = requestXXT("QRY_STUPRT_BY_CLASS",rb.toXML());
		System.out.println(res.getBody());*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setCityId("gz");
		rb.setUserType("3");
		rb.setSmsType("1");
		
		int i = 0;
		
		SmsList list = new SmsList();
		SmsEntity entity = new SmsEntity();
		entity.setOthSmsId(System.currentTimeMillis() + "" + i++);
		entity.setSmsTargetSeq("4932192");
		entity.setSmsContent("校讯通短信接口【SEND_SINGLE_SMS】测试，发送对象家长【4932192】链接：http://t.cn/8s85000");
		list.getSmsEntity().add(entity);
		
		SmsEntity entity2 = new SmsEntity();
		entity2.setOthSmsId(System.currentTimeMillis() + "" + i++);
		entity2.setSmsTargetSeq("4932193");
		entity2.setSmsContent("校讯通短信接口【SEND_SINGLE_SMS】测试，发送对象家长【4932192】链接：http://t.cn/8s85000");
		list.getSmsEntity().add(entity2);
		
		SmsEntity entity3 = new SmsEntity();
		entity3.setOthSmsId(System.currentTimeMillis() + "" + i++);
		entity3.setSmsTargetSeq("4932194");
		entity3.setSmsContent("校讯通短信接口【SEND_SINGLE_SMS】测试，发送对象家长【4932192】链接：http://t.cn/8s85000");
		list.getSmsEntity().add(entity3);
	
		SmsEntity entity4 = new SmsEntity();
		entity4.setOthSmsId(System.currentTimeMillis() + "" + i++);
		entity4.setSmsTargetSeq("4932392");
		entity4.setSmsContent("据悉，高一学生文理分科后不仅不能立马丢掉家长，不能决。");
		list.getSmsEntity().add(entity4);
		
		rb.getSmsList().add(list);
		
		Response res = requestXXT("SEND_SINGLE_SMS",rb.toXML());
		System.out.println(res.getBody());*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setCityId("gz");
		Response res = requestXXT("QRY_TOWN",rb.toXML());
		System.out.println(res.getBody());*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setTownId("3385");//3385
		Response res = requestXXT("QRY_BATCH_SCHOOL",rb.toXML());
		System.out.println(res.getBody());*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setSchoolId("73902");//37545 38697 38275
		Response res = requestXXT("QRY_BATCH_CLASS",rb.toXML());
		System.out.println(res.getBody());*/
		
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setCityId("gz");
		rb.setSchoolId("169055");
		rb.setMessageType("1");
		rb.setUserType("1");
		rb.setMessageContent("测试消息推送");
		rb.setUserId("3336447");
		rb.setMessageURL("http://www.istudy.com.cn");
		rb.setIsOauth("0");
		rb.setValidDate("2014-05-20 10:00:00");
		Response res = requestXXT("SEND_SYS_PUBLIC_MESSAGE",rb.toXML());
		System.out.println(res.getBody());*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setCityId("gz");
		rb.setSchoolId("169055");
		rb.setMessageType("1");
		rb.setUserType("1");
		rb.setTitle("家长无忧");
		rb.setMessageContent("测试消息推送");
		rb.setMessageURL("http://www.istudy.com.cn");
		rb.setIsOauth("1");
		rb.setValidDate("2014-06-12 10:00:00");
		Response res = requestXXT("SEND_OEM_SCH_MESSAGE",rb.toXML());
		System.out.println(res.getBody());*/
		
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setCityId("gz");
		rb.setSchoolId("169055");
		rb.setMessageType("1");
		rb.setUserType("1");
		rb.setTemplateCode("test1");
		rb.setMessageURL("http://www.istudy.com.cn");
		rb.setIsOauth("0");
		rb.setValidDate("2014-05-20 10:00:00");
		Response res = requestXXT("SEND_SYS_SCH_MESSAGE",rb.toXML());
		System.out.println(res.getBody());*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setCityId("gz");
		rb.setBank("12");
		rb.setMessageType("1");
		rb.setUserType("1");
		rb.setMessageURL("http://www.istudy.com.cn");
		rb.setIsOauth("1");
		rb.setValidDate("2014-06-12 10:00:00");
		rb.setTitle("家长无忧");
		rb.setMessageContent("推送测试");
		Response res = requestXXT("SEND_OEM_GRP_MESSAGE",rb.toXML());
		System.out.println(res.getBody());*/
		
		//rb.setUserId("3500050");
		//rb.setCityId("gz");
		//rb.setRoleType("1");
		//rb.setTownId("1841");
		//rb.setTeacherId("3281056");
		//rb.setCityId("gz");
		//rb.setToken("181c4935c3de7b5d142bff63d0d82b4c");
		//Response res  = requestXXT("QRY_BATCH_SCHOOL",rb.toXML());
		//System.out.println(res.getBody());
		
		///2734405
		//rb.setPhone("13727251596");
		//rb.setStuUserName("郭豪达");
		//Response res  = requestXXT("CHK_PARENT_HF",rb.toXML());
		//System.out.println(new XXTWSService().checkParentHf("18576432258", "张敏"));
		//System.out.println(rb.toXML());
		
		//System.out.println(new XXTWSService().getStudentsByClass("32323232", "gz"));
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setSmsTargetSeq("1241440");
		rb.setCityId("gz");
		rb.setSmsType("1");
		rb.setSmsContent("ssssss");
		Response res = requestXXT("SEND_SYS_SMS",rb.toXML());
		
		String body = res.getBody();
		SendSysSmsResponse o =   parseToBean(body,SendSysSmsResponse.class);
		System.out.println(o);*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setSchoolId("200256");//37545 38697 38275
		Response res = requestXXT("QRY_SCHOOL_TEACHER",rb.toXML());
		System.out.println(res.getBody());*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setUserId("5344039");
		rb.setCityId("gz");
		Response res = requestXXT("QRY_PARENT_INFO",rb.toXML());
		System.out.println(res.getBody());*/ //classid:1515045		
		
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setTeacherId("1062518");//  1935291 1935292 1935294 1935295
		//rb.setClassId("1517856");
		rb.setCityId("gz");
		Response res = requestXXT("QRY_CLASS_TEACHER",rb.toXML());
		System.out.println(res.getBody());*/


		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setCityId("gz");
		rb.setSmsSn("a56b0c36-a8d8-4895-b024-1003e8f3ce6e");
		rb.setIsRead("-1");
		//rb.setPageNo("0");
		Response res = requestXXT("QRY_SMS_RESULT",rb.toXML());
		System.out.println(res.getBody());*/
		
		/*List<StudentVO> stuprts = new XXTWSService().getStudentParentByClass("1515045", "gz");
		System.out.println(stuprts);*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setToken("da54450051b04e6a91d8efb73a9db00e");
		Response res = requestXXT("CHK_OAUTH",rb.toXML());
		System.out.println(res.getBody());*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setSchoolId("200256");
		Response res = requestXXT("QRY_SCHOOL",rb.toXML());
		System.out.println(res.getBody());*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setSchoolId("200256");
		Response res = requestXXT("QRY_CLASS",rb.toXML());
		System.out.println(res.getBody());*/
		
		/*Map<String, List<ClassVO>> classesBySchoolId = new XXTWSService().getGradeGroupBySchoolId("169055");
		System.out.println(classesBySchoolId);*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setCityId("gz");
		rb.setUserId("3018054");
		Response res = requestXXT("QRY_STUDENT_INFO",rb.toXML());
		System.out.println(res.getBody());*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setCityId("gz");
		rb.setUserId("3331649");
		Response res = requestXXT("QRY_TEACHER_INFO",rb.toXML());
		System.out.println(res.getBody());*/
		
		/*System.out.println(new XXTWSService().getTeachersById("gz", "3331649"));;
		System.out.println(new XXTWSService().getSchoolById("169055"));;*/
		
		//zs__12_146,dg__12_146,zq__12_146,gz__12_146,sz__12_146,fs__12_146,zh__12_146,hz__12_146,jm__12_146,sg__12_146,hy__12_146,mz__12_146,sw__12_146,yj__12_146,zj__12_146,mm__12_146,qy__12_146,cz__12_146,jy__12_146,yf__12_146,st__12_146
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setOthMsgId("dg__12_146");
		rb.setReason("内容需调整");
		Response res = requestXXT("DEL_OEM_MESSAGE",rb.toXML());
		System.out.println(res.getBody());*/
		
		/*XXTWSRequestBody rb = new XXTWSRequestBody();
		rb.setOthMsgId("zs__12_146");
		rb.setPageNo("1");
		Response res = requestXXT("QRY_OEM_MESSAGE",rb.toXML());
		System.out.println(res.getBody());*/
		
		
	}
	
	//xml转换成bean
    @SuppressWarnings("unchecked")
	public static <T> T parseToBean(String xmlstr,Class<T> clazz)  {  
    	T res = null;
        try {  
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);  
            Unmarshaller um = jaxbContext.createUnmarshaller();  
            res  = (T) um.unmarshal(new ByteArrayInputStream(xmlstr.getBytes("UTF8")));  
        } catch (JAXBException e) {  
            throw new CMSException(e);
        } catch (UnsupportedEncodingException e) {
        	throw new CMSException(e);
		} 
        LOG.info(res);
        return  res;  
    }
}
