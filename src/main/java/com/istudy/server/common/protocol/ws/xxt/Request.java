
package com.istudy.server.common.protocol.ws.xxt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.istudy.server.common.utils.JsonUtils;


/**
 * 
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MsgType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MsgSeq" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TimeStamp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PerformCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Skey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Body" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "version",
    "msgType",
    "msgSeq",
    "timeStamp",
    "performCode",
    "skey",
    "body"
})
@XmlRootElement(name = "Request")
public class Request {

    @XmlElement(name = "Version", required = true)
    protected String version;
    @XmlElement(name = "MsgType", required = true)
    protected String msgType;
    @XmlElement(name = "MsgSeq", required = true)
    protected String msgSeq;
    @XmlElement(name = "TimeStamp", required = true)
    protected String timeStamp;
    @XmlElement(name = "PerformCode", required = true)
    protected String performCode;
    @XmlElement(name = "Skey", required = true)
    protected String skey;
    @XmlElement(name = "Body", required = true)
    protected String body;

    public Request() {}
    
	public Request(String performCode,
			String version, String msgSeq, String timeStamp) {
		this.version = version;
		this.msgSeq = msgSeq;
		this.timeStamp = timeStamp;
		this.performCode = performCode;
	}


	/**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgType(String value) {
        this.msgType = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgSeq() {
        return msgSeq;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgSeq(String value) {
        this.msgSeq = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeStamp(String value) {
        this.timeStamp = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerformCode() {
        return performCode;
    }

    /**
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerformCode(String value) {
        this.performCode = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkey() {
        return skey;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkey(String value) {
        this.skey = value;
    }

    /**
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBody() {
        return body;
    }

    /**
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBody(String value) {
        this.body = value;
    }

	@Override
	public String toString() {
		return JsonUtils.toString(this);
	}
    
    
}
