package com.istudy.server.common.validate.core;


import com.istudy.server.common.validate.annotation.ValidatingField;
import com.istudy.server.common.validate.utils.Assert;
import com.istudy.server.common.validate.utils.ValidateUtils;

public class DateValidator extends AbstractValidator {

	 

	public DateValidator(ValidatingField validatingField, Object value) {
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
		if(!ValidateUtils.isNull(vf.format())){
			Assert.matchers(str, vf.format(), "["+fieldName+"]不满足格式："+ vf.format());
		}
	}

}
