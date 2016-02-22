package com.istudy.server.common.validate.core;

import com.istudy.server.common.validate.annotation.ValidatingField;

public class DefaultValidator extends AbstractValidator {

	public DefaultValidator(ValidatingField validatingField, Object value) {
		super(validatingField, value);
	}

	@Override
	public void validate() {
	}

}
