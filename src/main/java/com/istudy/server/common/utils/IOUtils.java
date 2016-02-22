package com.istudy.server.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import com.istudy.server.common.exception.CMSException;

public class IOUtils extends org.apache.commons.io.IOUtils{
	public static void close(OutputStream os) {
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				throw new CMSException("关闭流异常", e);
			}
		}
	}
	
	public static void close(Writer os) {
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				throw new CMSException("关闭流异常", e);
			}
		}
	}
	
	public static void close(Reader os) {
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				throw new CMSException("关闭流异常", e);
			}
		}
	}

	public static String paserToString(InputStream is){
		Writer w = new StringWriter();
		try {
			copy(is, w,"UTF-8");
		} catch (IOException e) {
			throw new CMSException(e);
		}finally{
			close(w);
		}
		return w.toString();
	}
}
