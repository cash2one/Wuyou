package com.istudy.server.common.utils;

import java.io.IOException;
import java.io.Writer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.istudy.server.common.exception.CMSException;
import com.istudy.server.xxt.vo.HisTaskVO;

public class JsonUtils {
	 //private static JsonGenerator jsonGenerator = null;
	 private static ObjectMapper objectMapper = null;
	 
	 static{
		 objectMapper = new ObjectMapper();
		 objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		  // or (for older versions):
		 //objectMapper.configure(MapperFeature.WRITE_NULL_PROPERTIES, false);
	 }
	 
	 public static String toJSON(Object value){
	        try {
	        	return objectMapper.writeValueAsString(value);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return null;
	 }
	 
	 public static <T> T toObj(String json , Class<T> type){
			try {
				return objectMapper.readValue(json, type);
			} catch (IOException e) {
				throw new CMSException(e);
			}
	 }
	 
	 public static String toString(Object o){
		 StringBuffer sb = new StringBuffer();
		 sb.append("{")
		 .append(o.getClass().getSimpleName())
		 .append(":")
		 .append(toJSON(o))
		 .append("}");
		 return sb.toString();
	 }
	 
	 public static void main(String[] args){
		 String json = "{}";
		 try {
			HisTaskVO o = objectMapper.readValue(json, HisTaskVO.class);
			System.out.println(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
}
