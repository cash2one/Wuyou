//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.01.20 时间 02:26:55 PM CST 
//


package com.istudy.server.common.protocol.ws.xxt.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.istudy.server.common.protocol.ws.WSVO;
import com.istudy.server.common.protocol.ws.xxt.vo.XXTWSRequestBody.SmsList;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CityId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SmsType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SmsTargetSeq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SmsContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClassId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SchoolId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TeacherId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoleType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StudentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "cityId",
    "smsType",
    "smsTargetSeq",
    "smsContent",
    "classId",
    "schoolId",
    "teacherId",
    "userId",
    "roleType",
    "token",
    "studentId",
    "parentId",
    "phone",
    "stuUserName",
    "userName",
    "townId",
    "userType",
    "smsList",
    "messageType",
    "templateCode",
    "messageContent",
    "messageURL",
    "isOauth",
    "validDate",
    "bank",
    "smsSn",
    "isRead",
    "pageNo",
    "gradeId",
    "title",
    "othMsgId",
    "reason"
})
@XmlRootElement(name = "MSG_BODY")
public class XXTWSRequestBody extends WSVO{

    @XmlElement(name = "CityId")
    protected String cityId;
    @XmlElement(name = "SmsType")
    protected String smsType;
    @XmlElement(name = "SmsTargetSeq")
    protected String smsTargetSeq;
    @XmlElement(name = "SmsContent")
    protected String smsContent;
    @XmlElement(name = "ClassId")
    protected String classId;
    @XmlElement(name = "SchoolId")
    protected String schoolId;
    @XmlElement(name = "TeacherId")
    protected String teacherId;
    @XmlElement(name = "UserId")
    protected String userId;
    @XmlElement(name = "RoleType")
    protected String roleType;
    @XmlElement(name = "Token")
    protected String token;
    @XmlElement(name = "StudentId")
    protected String studentId;
    @XmlElement(name = "ParentId")
    protected String parentId;
    @XmlElement(name = "Phone")
    protected String phone;
    @XmlElement(name = "StuUserName")
    protected String stuUserName;
    @XmlElement(name = "UserName")
    protected String userName;
    @XmlElement(name = "TownId")
    protected String townId;
    
    @XmlElement(name = "UserType")
    protected String userType;
    @XmlElement(name = "SmsList")
    protected List<SmsList> smsList;
    @XmlElement(name = "MessageType")
    protected String messageType;
    @XmlElement(name = "TemplateCode")
    protected String templateCode;
    @XmlElement(name = "MessageContent")
    protected String messageContent;
    @XmlElement(name = "MessageURL")
    protected String messageURL;
    @XmlElement(name = "IsOauth")
    protected String isOauth;
    @XmlElement(name = "ValidDate")
    protected String validDate;
    @XmlElement(name = "Bank")
    protected String bank;
    
    @XmlElement(name = "SmsSn")
    protected String smsSn;
    @XmlElement(name = "IsRead")
    protected String isRead;
    @XmlElement(name = "PageNo")
    protected String pageNo;
    @XmlElement(name = "GradeId")
    protected String gradeId;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "OthMsgId")
    protected String othMsgId;
    @XmlElement(name = "Reason")
    protected String reason;
    
    
    public XXTWSRequestBody() {
		super();
	}

	public XXTWSRequestBody(String classId, String teacherId) {
		super();
		this.classId = classId;
		this.teacherId = teacherId;
	}

	public XXTWSRequestBody(String cityId, String classId, String studentId) {
		super();
		this.cityId = cityId;
		this.classId = classId;
		this.studentId = studentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**
     * 获取cityId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * 设置cityId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityId(String value) {
        this.cityId = value;
    }

    /**
     * 获取smsType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmsType() {
        return smsType;
    }

    /**
     * 设置smsType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmsType(String value) {
        this.smsType = value;
    }

    /**
     * 获取smsTargetSeq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmsTargetSeq() {
        return smsTargetSeq;
    }

    /**
     * 设置smsTargetSeq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmsTargetSeq(String value) {
        this.smsTargetSeq = value;
    }

    /**
     * 获取smsContent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmsContent() {
        return smsContent;
    }

    /**
     * 设置smsContent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmsContent(String value) {
        this.smsContent = value;
    }

    /**
     * 获取classId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassId() {
        return classId;
    }

    /**
     * 设置classId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassId(String value) {
        this.classId = value;
    }

    /**
     * 获取schoolId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchoolId() {
        return schoolId;
    }

    /**
     * 设置schoolId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchoolId(String value) {
        this.schoolId = value;
    }

    /**
     * 获取teacherId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeacherId() {
        return teacherId;
    }

    /**
     * 设置teacherId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeacherId(String value) {
        this.teacherId = value;
    }

    /**
     * 获取userId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置userId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * 获取roleType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * 设置roleType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleType(String value) {
        this.roleType = value;
    }

    /**
     * 获取token属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置token属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStuUserName() {
		return stuUserName;
	}

	public void setStuUserName(String stuUserName) {
		this.stuUserName = stuUserName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTownId() {
		return townId;
	}

	public void setTownId(String townId) {
		this.townId = townId;
	}
	
	
	/**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="SmsEntity" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="OthSmsId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SmsTargetSeq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SmsContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "smsEntity"
    })
    public static class SmsList {

        @XmlElement(name = "SmsEntity")
        protected List<SmsList.SmsEntity> smsEntity;

        /**
         * Gets the value of the smsEntity property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the smsEntity property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSmsEntity().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SmsList.SmsEntity }
         * 
         * 
         */
        public List<SmsList.SmsEntity> getSmsEntity() {
            if (smsEntity == null) {
                smsEntity = new ArrayList<SmsList.SmsEntity>();
            }
            return this.smsEntity;
        }


        /**
         * <p>anonymous complex type的 Java 类。
         * 
         * <p>以下模式片段指定包含在此类中的预期内容。
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="OthSmsId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SmsTargetSeq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SmsContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "othSmsId",
            "smsTargetSeq",
            "smsContent"
        })
        public static class SmsEntity {

            @XmlElement(name = "OthSmsId")
            protected String othSmsId;
            @XmlElement(name = "SmsTargetSeq")
            protected String smsTargetSeq;
            @XmlElement(name = "SmsContent")
            protected String smsContent;

            /**
             * 获取othSmsId属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOthSmsId() {
                return othSmsId;
            }

            /**
             * 设置othSmsId属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOthSmsId(String value) {
                this.othSmsId = value;
            }

            /**
             * 获取smsTargetSeq属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSmsTargetSeq() {
                return smsTargetSeq;
            }

            /**
             * 设置smsTargetSeq属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSmsTargetSeq(String value) {
                this.smsTargetSeq = value;
            }

            /**
             * 获取smsContent属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSmsContent() {
                return smsContent;
            }

            /**
             * 设置smsContent属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSmsContent(String value) {
                this.smsContent = value;
            }

        }

    }
    
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setSmsList(List<SmsList> smsList) {
		this.smsList = smsList;
	}

	public List<SmsList> getSmsList() {
        if (smsList == null) {
            smsList = new ArrayList<SmsList>();
        }
        return this.smsList;
    }

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getMessageURL() {
		return messageURL;
	}

	public void setMessageURL(String messageURL) {
		this.messageURL = messageURL;
	}

	public String getIsOauth() {
		return isOauth;
	}

	public void setIsOauth(String isOauth) {
		this.isOauth = isOauth;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getSmsSn() {
		return smsSn;
	}

	public void setSmsSn(String smsSn) {
		this.smsSn = smsSn;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getOthMsgId() {
		return othMsgId;
	}

	public void setOthMsgId(String othMsgId) {
		this.othMsgId = othMsgId;
	}
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
