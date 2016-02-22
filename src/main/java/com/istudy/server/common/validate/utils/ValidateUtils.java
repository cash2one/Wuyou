package com.istudy.server.common.validate.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ValidateUtils {
	public static boolean isNull(String str){
		return str == null||str.trim().length()==0;
	}
	
	public static boolean isNull(List<?> v){
		return  v == null|| v.isEmpty();
	}
	
	public static boolean notPram(Method m ){
		return m.getParameterTypes().length==0;
	}
	
	public static boolean notStatic(Method m ){
		int mo = m.getModifiers();
		return !Modifier.isStatic(mo);
	}
	
	public static String start4LowlerCase(String v){
		String start = new String(new char[]{v.charAt(0)}).toLowerCase();
		return v.substring(1)+start;
	}
	
	public static String asNull(String v){
		if(isNull(v)){
			return null;
		}
		return v;
	}
	public static Date stringToDate(String strTime, String formatType)
 			throws ParseException {
 		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
 		Date date = null;
 		date = formatter.parse(strTime);
 		return date;
 	}
	
}
