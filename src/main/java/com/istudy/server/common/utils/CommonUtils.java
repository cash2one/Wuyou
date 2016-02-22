package com.istudy.server.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import com.istudy.server.common.constants.CommonConstants;
import com.istudy.server.common.exception.CMSException;

public class CommonUtils extends
		com.istudy.server.common.validate.utils.ValidateUtils {

	public static Properties PROPERTIES = null;

	public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static final String BASIC_DATE_STYLE = "yyyy-MM-dd";
	
	public static final SimpleDateFormat BASIC_DATE_FORMAT = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
	static {
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					CommonUtils.class.getResource("/").getPath()
							+ "application.context.properties"));
			PROPERTIES = new Properties();
			PROPERTIES.load(in);
		} catch (IOException e) {
			LogUtils.L.error(e);
			// System.exit(0);
		}
	}

	public static String getImgName() {
		return String.valueOf(System.currentTimeMillis());
	}

	public static String getTypeName(String type) {
		if (CommonUtils.isNull(type)) {
			return "";
		}
		switch (Integer.parseInt(type)) {
		case 0:
			return "纯文本";
		case 1:
			return "图文";
		case 2:
			return "视频";

		default:
			return "文字";
		}
	};
	
	public static String uuid(){
		String result = UUID.randomUUID().toString();
		result = result.replaceAll("-", "");
		return result;
	}
	
	public static String getDate(Date date , String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	public static void beanAppendMap(Object obj, Map<String, Object> map) {  
        if(obj == null){  
            return;  
        }          
        //Map<String, Object> map = new HashMap<String, Object>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
                if (!key.equals("class")) {  
                    // 得到property对应的getter方法  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
                    map.put(key, value);  
                }  
            }  
        } catch (Exception e) {  
            throw new CMSException(e);
        }  
        //return map;  
    }  
	
	public static int getPagingSize(){
		int size = 0 ; 
		try {
			size = Integer.parseInt(CommonConstants.PAGING_SIZE);
		} catch (Exception e) {
			LogUtils.L.error(e);
			size=20;
		}
		return size;
	}
	
	public static int parseInt(String v){
		int i = 0 ; 
		try {
			i = Integer.parseInt(v);
		} catch (Exception e) {
			LogUtils.L.error(e);
		}
		return i;
	}
	
	public static void delFile(String target){
		if(isNull(target)){
			LogUtils.L.info("删除的文件为空");
			return ;
		}
		File f = new File(target);
		if(f.exists()&&f.isFile()){
			LogUtils.L.info("删除文件："+target);
			f.delete();
		}
	}
	
	public static String delLastChar(String val){
		return val.substring(0, val.length()-1);
	}
	
	public static String delHeadChar(String v){
		return v.substring(1,v.length());
	}
	
	public static String delHeadAndLashChar(String v){
		if(isNull(v)||v.length()<2){
			return v;
		}
		return delHeadChar(delLastChar(v));
	}
	
	public static List<String> spliteStringToList(String str){
		if(isNull(str)){
			return Collections.emptyList();
		}
		if(str.startsWith(",")){
			str = delHeadChar(str);
		}
		List<String> result = Arrays.asList(str.split(","));
		if(isNull(result.get(0))){
			result.remove(0);
		}
		return result;
	}
	
	public static String nullToEmpty(String source){
		return source == null ? "" : source;
	}
	
	public static String formatFloatString(Float source){
		String str = null;
		if(source != null){
			str = source + "";
		}
		return formatFloatString(str);
	}
	
	public static String formatFloatString(String source){
		if(isNull(source)){
			return null;
		}
		try {
			float f = Float.parseFloat(source);
			int i = (int)f;
			if(f > (float)i){
				return f + "";
			}else{
				return i + "";
			}
		} catch (Exception e) {
			
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		System.out.println(delHeadAndLashChar(","));
	}
	public static void createPath(String uri){
		uri.replace("../webapps/", "");
		File f = new File(uri);
		if(!f.isDirectory()){
			f.mkdirs();
		}
	}
}
