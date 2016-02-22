package com.istudy.server.common.validate.core;

import com.istudy.server.common.validate.annotation.ValidatingField;

public abstract class AbstractValidator {
	
	private Object value;
	private ValidatingField validatingField;
	
	public AbstractValidator(ValidatingField validatingField,Object value) {
		this.validatingField = validatingField;
		this.value = value;
	}

	public abstract void validate();

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public ValidatingField getValidatingField() {
		return validatingField;
	}

	public void setValidatingField(ValidatingField validatingField) {
		this.validatingField = validatingField;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbstractValidator [value=").append(value)
				.append(", validatingField=").append(validatingField).append("]");
		return builder.toString();
	}
	
}
