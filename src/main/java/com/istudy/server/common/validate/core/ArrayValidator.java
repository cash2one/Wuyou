package com.istudy.server.common.validate.core;

import java.util.Arrays;
import java.util.List;

import com.istudy.server.common.validate.annotation.ValidatingField;
import com.istudy.server.common.validate.utils.Assert;

public class ArrayValidator extends AbstractValidator {

	

	public ArrayValidator(ValidatingField vf, Object value) {
		super(vf, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void validate() {
		String fieldName = getValidatingField().name();
		ValidatingField vf = this.getValidatingField();
		Object value = this.getValue();
		if(vf.notNull()){
			Assert.notNull(value, "["+fieldName+"]不能为空");
		}else if(value==null){
			return ;
		}
		List<?> list = null ;
		if(value instanceof List){
			list = (List<?>)value;
		}else {
			Arrays.asList((Object[])value);
		}
		if(list.size()>vf.max()){
			throw new IllegalArgumentException("["+fieldName+"]参数长度超过"+vf.intSize()+"位");
		}
		if(list.size()<vf.min()){
			throw new IllegalArgumentException("["+fieldName+"]参数长度少于"+vf.min()+"位");
		}
	}

}
