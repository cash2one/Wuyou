package com.istudy.server.common.protocol.ws;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.istudy.server.common.exception.CMSException;
import com.istudy.server.common.vo.CMSVO;

public abstract class WSVO extends CMSVO{
	   public String toXML(){
	        JAXBContext context;
	        StringWriter sw = null;
			try {
				context = JAXBContext.newInstance(this.getClass());
		        Marshaller m = context.createMarshaller();
		        sw = new StringWriter();
		        m.marshal(this,sw);
			} catch (JAXBException e) {
				throw new CMSException(e);
			}
	        return sw.toString();
	    }
}
