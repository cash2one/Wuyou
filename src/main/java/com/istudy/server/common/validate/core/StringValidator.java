package com.istudy.server.common.validate.core;

import java.io.UnsupportedEncodingException;

import com.istudy.server.common.validate.annotation.ValidatingField;
import com.istudy.server.common.validate.utils.Assert;
import com.istudy.server.common.validate.utils.ValidateUtils;

public class StringValidator extends AbstractValidator {

	public StringValidator(ValidatingField validatingField, Object value) {
		super(validatingField, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void validate() {
		Object value = this.getValue();
		ValidatingField vf = this.getValidatingField();
		String fieldName = vf.name();
		if(vf.notNull()){
			Assert.notNull(value, "["+fieldName+"]不能为空");
		}else if(value==null){
			return ;
		}
		String str = (String)value;
		try {
			if(str.getBytes("GBK").length>vf.max()){
				throw new IllegalArgumentException( "["+fieldName+"]参数的字节长度超过"+vf.max()+"位");
			}
			if(str.getBytes("GBK").length<vf.min()){
				throw new IllegalArgumentException( "["+fieldName+"]参数的字节长度少于"+vf.min()+"位");
			}
			if(str.length()>vf.max()){
				throw new IllegalArgumentException( "["+fieldName+"]参数长度超过"+vf.max()+"位");
			}
			if(str.length()<vf.min()){
				throw new IllegalArgumentException( "["+fieldName+"]参数长度少于"+vf.min()+"位");
			}
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("["+fieldName+"]参数编码不正确",e);
		}
		if(!ValidateUtils.isNull(vf.format())){
			Assert.matchers(str, vf.format(), "["+fieldName+"]不满足格式："+ vf.format());
		}
	}
}
