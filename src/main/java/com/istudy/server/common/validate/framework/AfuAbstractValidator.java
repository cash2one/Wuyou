package com.istudy.server.common.validate.framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.istudy.server.common.validate.annotation.NotNull;
import com.istudy.server.common.validate.annotation.ValidatingField;
import com.istudy.server.common.validate.annotation.Validation;
import com.istudy.server.common.validate.core.AbstractValidator;
import com.istudy.server.common.validate.core.ValidatorFactory;
import com.istudy.server.common.validate.reflection.ObjectReflector;
import com.istudy.server.common.validate.utils.Assert;

/**
 * 
 * 校验核心类
 * 由自己的切面类来调用该类的validate
 *
 */
@Component
public class AfuAbstractValidator {
	
	/**
	 * 
	 * @param pjp
	 * @return
	 * @throws Exception 
	 */
	public void validate(ProceedingJoinPoint pjp) throws Exception{
		MethodSignature r = (MethodSignature)pjp.getSignature();
		String[] ns = r.getParameterNames();
		Object[] os = pjp.getArgs();
		Method method = r.getMethod();
		//检查参数属性长度,返回一个Map
		proccessArgs(os,ns,method);
	}
	
	public void proccessArgs(Object[] os,String[] ns,Method method) throws Exception {
		for(int i = 0 ;i<os.length;i++){
			Object o = os[i];
			if(o  instanceof List||o  instanceof Object[]){
				List<?> os1 = (List<?>)o;
				for(Object o1 : os1){
					validateArgs(o1,ns[i],method);
				}
			}else{
				validateArgs(o,ns[i],method);
			}
		}
	}
	
	public void validateArgs(Object o,String paramName,Method method) throws Exception{
		ObjectReflector r = new ObjectReflector();
		r.reflect(o,paramName);	
		//有NotNull注解
		notNullValidating(r.getParam(),paramName,method);
		//有Validation注解
		fieldValidating(r.getParam(),paramName,method);
	}
	
	private void fieldValidating(Map<String,AbstractValidator> map,String paramName,Method method) throws Exception{
		 Validation vs = method.getAnnotation(Validation.class);
		if(vs==null){
			return ;
		}
		for(ValidatingField vf : vs.value()){
			AbstractValidator v = map.get(vf.name());
			if(v==null){
				return ;
			}
			Object value = v.getValue();
			AbstractValidator av = ValidatorFactory.instanceValidator(vf,value);
			av.validate();
		}
	}
	
	private void notNullValidating(Map<String,AbstractValidator> map,String paramName,Method method) throws Exception{
		NotNull notNull = method.getAnnotation(NotNull.class);
		if(notNull==null){
			return ;
		}
		String[] vs = notNull.value();
		for(String v : vs){
			if(v.startsWith(paramName+".")){
				if(!map.containsKey(v)){
					throw new Exception("Afu系统异常,没有找到["+v+"]参数");
				}
				Assert.notNull(map.get(v).getValue(), "参数["+v+"]不能为空");
			}
		}
	}
	
}
