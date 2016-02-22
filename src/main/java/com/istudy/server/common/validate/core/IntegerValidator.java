package com.istudy.server.common.validate.core;

import com.istudy.server.common.validate.annotation.ValidatingField;
import com.istudy.server.common.validate.utils.Assert;
import com.istudy.server.common.validate.utils.ValidateUtils;

public class IntegerValidator extends AbstractValidator {


	public IntegerValidator(ValidatingField validatingField, Object value) {
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
		Number n =(Number)value;
		if(n.toString().length()>vf.intSize()){
			throw new IllegalArgumentException("["+fieldName+"]参数长度超过"+vf.intSize()+"位");
		}
		if(n.toString().length()<vf.min()){
			throw new IllegalArgumentException("["+fieldName+"]参数长度少于"+vf.min()+"位");
		}
	}

}
