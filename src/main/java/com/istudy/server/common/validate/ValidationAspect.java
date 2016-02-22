package com.istudy.server.common.validate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.istudy.server.common.constants.ResultInfoConstants;
import com.istudy.server.common.exception.ResultException;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.validate.framework.AfuAbstractValidator;

@Aspect
@Component
@Order(2)
public class ValidationAspect {
	
	@Autowired
	private AfuAbstractValidator afuAbstractValidator;
	
	@Around("execution(public * com.istudy.server.*.controller.*.*(..))"+
			" && @annotation(org.springframework.web.bind.annotation.RequestMapping)"+
			" && ( @annotation(com.istudy.server.common.validate.annotation.NotNull)"+
			" || @annotation(com.istudy.server.common.validate.annotation.Validation))"
			)
		public Object aspect(ProceedingJoinPoint pjp) throws Throwable 
		{
			try{
				LogUtils.log("ValidationAspect.aspect");
				afuAbstractValidator.validate(pjp);
			}catch(IllegalArgumentException e){
				LogUtils.L.error(e);
				throw new ResultException(ResultInfoConstants.CODE_ILLEGAL_ARGUMENT,e.getMessage());
			}
			return pjp.proceed();
		}

}
