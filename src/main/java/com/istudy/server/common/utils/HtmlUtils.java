package com.istudy.server.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HtmlUtils {

	private static final Pattern PATT_IMG = Pattern.compile("<img.*?src=\"([^\"]+)\"",Pattern.CASE_INSENSITIVE);
	private static final Pattern PATT_P = Pattern.compile("<p(?:>|\\s[\\S\\s]*?>)([\\S\\s]*?)</p>",Pattern.CASE_INSENSITIVE);
	//private static final Pattern PATT_ANY = Pattern.compile("<([\\w]+)(?:>|\\s[\\S\\s]*?>)([\\S\\s]*?)</(\\1)>",Pattern.CASE_INSENSITIVE);
	//private static final Pattern PATT_SINGLE = Pattern.compile("<([^>]+?)/>", Pattern.CASE_INSENSITIVE);
	private static final String STR_FLAG_ANY = "<([^>]+?)>";
	private static final String STR_FLAG_BR = "<(b|B)(r|R)[/]?>";
	private static final String STR_FLAG_TRIM = "(^\\s+)|(\\s+$)";
	private static final String STR_SPACE = "(^ +)|( +$)";
	
	public static List<String> extractImageUrlsFromHtml(String html){
		if(CommonUtils.isNull(html)){
			return Collections.emptyList();
		}
		
		List<String> list = new ArrayList<String>();
		
		Matcher matcher = PATT_IMG.matcher(html);
		while(matcher.find()){
			list.add(matcher.group(1));
			//System.out.println(matcher.group(1));;
		}
		
		return list;
	}
	
	public static String extractTextFromHtml(String html){
		if(CommonUtils.isNull(html)){
			return "";
		}
		StringBuilder text = new StringBuilder();
		//System.out.println(html);
		Matcher matcher = PATT_P.matcher(html);
		while(matcher.find()){
			String pcontent = matcher.group(1).replaceAll(STR_FLAG_TRIM, " ");
			pcontent = replaceHtmlFlags(pcontent);
			String trimText = pcontent.replaceAll(STR_SPACE, "");
			if(!trimText.isEmpty()){
				text.append(pcontent);
				if(!trimText.endsWith("\n")){
					text.append("\n");
				}
			}
		}
		return text.toString().replaceAll("^[\\s　]*", "　　").replaceAll("\\n[\\s　]*", "\n　　");
	}
	
	private static String replaceHtmlFlags(String pcontent) {
		pcontent = pcontent.replaceAll(STR_FLAG_BR, "\n").replaceAll(STR_FLAG_ANY, "");
		return replaceHtmlChars(pcontent);
	}
	
	/*public static String extractTextFromHtml(String html){
		if(CommonUtils.isNull(html)){
			return "";
		}
		StringBuilder text = new StringBuilder();
		Matcher matcher = PATT_P.matcher(html);
		while(matcher.find()){
			String pcontent = matcher.group(1).trim();
			String innerText = doExtractInnerText(pcontent);
			if(CommonUtils.isNull(innerText)){
				innerText = pcontent;
				Matcher singlemc = PATT_SINGLE.matcher(innerText);
				if(singlemc.matches()){
					String flag = singlemc.group(1);
					if("BR".equalsIgnoreCase(flag.trim())){
						text.append("\n");
					}
					innerText = "";
				}
			}
			innerText = replaceHtmlChars(innerText);
			text.append(innerText);
			text.append("\n");
		}
		return text.toString();
	}
	

	private static String doExtractInnerText(String pcontent){
		if(CommonUtils.isNull(pcontent)){
			return "";
		}
		StringBuilder innerText = new StringBuilder();
		Matcher matcher = PATT_ANY.matcher(pcontent);
		while(matcher.find()){
			String curr = matcher.group(2);
			String next = doExtractInnerText(curr);
			if(CommonUtils.isNull(next)){
				innerText.append(curr);
			}else{
				innerText.append(next);
			}
		}
		return innerText.toString();
	}*/
	
	

	private static String replaceHtmlChars(String innerText) {
		if(innerText == null){
			return "";
		}
		return innerText
			.replaceAll("&lt;", "<")
			.replaceAll("&gt;", ">")
			.replaceAll("&amp;", "&")
			.replaceAll("&quot;", "\"")
			.replaceAll("&reg;", "®")
			.replaceAll("&copy;", "©")
			.replaceAll("&trade;", "™")
			.replaceAll("&ensp;", " ")
			.replaceAll("&emsp;", "　")
			.replaceAll("&nbsp;", " ");
	}
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<p>\n");
		sb.append("    推送到家长会\n");
		sb.append("</p>\n");
		sb.append("<p>\n");
		sb.append("    <br/>\n");
		sb.append("</p>\n");
		sb.append("<p>\n");
		sb.append("    <br/>\n");
		sb.append("</p>\n");
		sb.append("<p>\n");
		sb.append("    <br/>\n");
		sb.append("</p>\n");
		sb.append("<p>\n");
		sb.append("    <img src=\"http://10.0.0.170:8050/img/minisite/1401241524989.jpg\" style=\"float:none;\" title=\"华师附小.jpg\"/>\n");
		sb.append("</p>\n");
		sb.append("<p>\n");
		sb.append("    <img src=\"http://10.0.0.170:8050/img/minisite/1401241525057.jpg\" style=\"float:none;\" title=\"华师附小1.jpg\"/>\n");
		sb.append("</p>\n");
		sb.append("<p>\n");
		sb.append("    <img src=\"http://10.0.0.170:8050/img/minisite/1401241525084.jpg\" style=\"float:none;\" title=\"华师附小2.jpg\"/>\n");
		sb.append("</p>\n");
		sb.append("<p>\n");
		sb.append("    <img src=\"http://10.0.0.170:8050/img/minisite/1401241525134.png\" style=\"float:none;\" title=\"水印.png\"/>\n");
		sb.append("</p>\n");
		sb.append("<p>\n");
		sb.append("    <img src=\"http://10.0.0.170:8050/img/minisite/1401241525173.jpg\" style=\"float:none;\" title=\"校长.jpg\"/>\n");
		sb.append("</p>\n");
		sb.append("<p>\n");
		sb.append("    <img src=\"http://10.0.0.170:8050/img/minisite/1401241525219.jpg\" style=\"float:none;\" title=\"校长1.jpg\"/>\n");
		sb.append("</p>\n");
		sb.append("<p>\n");
		sb.append("    <br/>\n");
		sb.append("</p>\n");
		
		System.out.println(extractTextFromHtml(sb.toString()));
	}
}
