package com.istudy.server.common.validate.core;

import com.istudy.server.common.validate.annotation.ValidatingField;
import com.istudy.server.common.validate.annotation.ValidationType;

public class ValidatorFactory {
	public static AbstractValidator instanceValidator(ValidatingField vf,Object value){
		AbstractValidator av= null;
		ValidationType vt = vf.type();
		switch (vt) {
		case STRING:
			av = new StringValidator(vf,value);
			break;
		case ARRAY:
			av= new ArrayValidator(vf,value);
			break;
		case INTEGER:
			av = new IntegerValidator(vf,value);
			break;
		case FLOAT:
			av = new FloatValidator(vf,value);
			break;
		case DATE:
			av = new DateValidator(vf,value);
			break;
		default:
			av = new StringValidator(vf,value);
			break;
		}
		return av;
	}
}
