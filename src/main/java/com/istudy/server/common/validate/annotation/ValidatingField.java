package com.istudy.server.common.validate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatingField{
	String name();
	ValidationType type() default ValidationType.STRING;
	boolean notNull() default false;
	int decSize() default 0;		//小数位长度
	int intSize() default 20;		//整数位长度
	int min() default 0;
	int max() default Integer.MAX_VALUE;
	int charMin() default 0;
	int charMax() default Integer.MAX_VALUE;
	String format() default "";
}
