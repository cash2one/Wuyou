package com.istudy.server.common.validate.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;

public class Assert {
	public static void notNull(String v,String msg){
		if (ValidateUtils.isNull(v)){
			throw new IllegalArgumentException(msg);
		}
	}
	
	public static void notNull(Object v,String msg){
		if(v instanceof String){
			String value = (String)v;
			notNull(value,msg);
		}
		if (v==null){
			throw new IllegalArgumentException(msg);
		}
	}
	
	public static void matchers(String v,String regex,String msg){
		if(!Pattern.matches(regex, v)){
			throw new IllegalArgumentException(msg);
		}
	}
	
	public static void notNull(List<?> v,String msg){
		if (ValidateUtils.isNull(v)){
			throw new IllegalArgumentException(msg);
		}
	}
	
	public static void assertDate(String v,String regex,String msg){
		SimpleDateFormat sdf = new SimpleDateFormat(regex);
		sdf.setLenient(false);
		try {
			sdf.parse(regex);
		} catch (ParseException e) {
			throw new IllegalArgumentException(msg,e);
		}
	}
}
