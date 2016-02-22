package com.istudy.server.common.validate.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.istudy.server.cms.controller.CMSTaskController;
import com.istudy.server.common.utils.LogUtils;
import com.istudy.server.common.validate.annotation.ValidatingField;
import com.istudy.server.common.validate.core.AbstractValidator;
import com.istudy.server.common.validate.core.DefaultValidator;
import com.istudy.server.common.validate.core.ValidatorFactory;
import com.istudy.server.common.validate.utils.ValidateUtils;

public class ObjectReflector {
	private static final Log LOG = LogFactory.getLog(ObjectReflector.class);
	private Map<String,AbstractValidator> param = new HashMap<String,AbstractValidator>();
	
	public void  reflect(Object o,String name) {
		if(o instanceof List){
			List<?> ls = (List<?>)o;
			for(Object l : ls){
				this.reflect(l,name);
			}
		}else if(o instanceof Object[]){
			Object[] os = (Object[])o;
			for(Object l : os){
				this.reflect(l,name);
			}
		}else if(o instanceof Map){
			Map<?,?> m = (Map<?,?>)o;
			for(Entry<?,?> e :m.entrySet()){
				this.reflect(e.getValue(),name+"."+e.getKey());
			}
		}else{
			try {
				/*String packageName = o.getClass().getPackage().getName();
				if(packageName.startsWith("java")){
					return;
				}*/
				Field[] fs = o.getClass().getDeclaredFields();
				if(LOG.isInfoEnabled()){
					LOG.info(o.getClass().getName()+":::"+fs.length);
				}
				Method[] ms = o.getClass().getDeclaredMethods();
				Map<String, Object> methodMap = new HashMap<String, Object>();
				for(Method m : ms){
					String methodName = m.getName();
					if(methodName.startsWith("get")&&methodName.length()>3&&ValidateUtils.notPram(m)){
						Object invoke = m.invoke(o, null);
						if(LOG.isInfoEnabled()){
							LOG.info(m.getName()+"   :   "+invoke);
						}
						methodMap.put(toFieldName(methodName), invoke);
					}
				}
				if(LOG.isInfoEnabled()){
					LOG.info("methodMap==="+methodMap);
				}
				for(Field f : fs){
					String fieldName = f.getName();
					//System.out.println(fieldName);
					Object value = methodMap.get(fieldName);
					AbstractValidator av = new DefaultValidator(null,value);
					//校验
					if(value!=null){
						ValidatingField vf = f.getAnnotation(ValidatingField.class) ;
						if(vf!= null){
							av= ValidatorFactory.instanceValidator(vf,value);
							av.validate();
						}
					}else if(!methodMap.containsKey(fieldName)){
							value = f.get(o);
					}
					//设值
					param.put(name+"."+fieldName, av);
					if(isCustomObject(value)){
						this.reflect(value, name+"."+fieldName);
					}
				}
			} catch (Exception e) {
				//throw new IllegalArgumentException(e);
				LogUtils.L.info(e);
				return ;
			}	
		}
	}
	
	private boolean isCustomObject(Object o){
		if(o == null){
			return false;
		}
		if(o instanceof Number){
			return false;
		}
		if(o instanceof String ){
			return false;
		}
		if(o instanceof Date){
			return false;
		}
		return true;
	}
	
	private String toFieldName(String methodName){
		char[] cs = methodName.toCharArray();
		char[] targetChar = new char[]{cs[3]};
		if(methodName.length()==4){
			return new String(targetChar).toLowerCase();
		}
		char[] vs = new char[cs.length-4];
		System.arraycopy(cs, 4, vs, 0, vs.length);
		return new String(targetChar).toLowerCase()+new String(vs);
	}
	
	public Map<String,AbstractValidator> getParam() {
		return param;
	}

}
