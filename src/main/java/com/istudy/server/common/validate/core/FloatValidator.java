package com.istudy.server.common.validate.core;

import java.text.NumberFormat;

import com.istudy.server.common.validate.annotation.ValidatingField;
import com.istudy.server.common.validate.utils.Assert;
import com.istudy.server.common.validate.utils.ValidateUtils;

public class FloatValidator extends AbstractValidator {

	 
	public FloatValidator(ValidatingField validatingField, Object value) {
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
		NumberFormat mf = NumberFormat.getInstance();
		mf.setMinimumFractionDigits(vf.decSize());
		mf.setMinimumIntegerDigits(vf.intSize());
		mf.setGroupingUsed(false);
		String[] args = mf.format(n.doubleValue()).split("\\.");
		if(args[0].length()>vf.intSize()){
			throw new IllegalArgumentException("["+fieldName+"]参数整数位长度超过"+vf.intSize()+"位");
		}
		if(args[0].length()<vf.min()){
			throw new IllegalArgumentException("["+fieldName+"]参数长度少于"+vf.min()+"位");
		}
		if(args[1].length()>vf.decSize()){
			throw new IllegalArgumentException("["+fieldName+"]参数小数位长度超过"+vf.decSize()+"位");
		}
	}

}
