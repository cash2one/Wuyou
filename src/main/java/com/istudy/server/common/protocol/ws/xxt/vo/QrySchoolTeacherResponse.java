//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.03.20 时间 10:08:03 AM CST 
//


package com.istudy.server.common.protocol.ws.xxt.vo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="Relations">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SchoolTeacherRelation" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SchoolId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AreaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TownName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SchoolName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TeacherId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LoginName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="HeadImage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="EMail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "relations"
})
@XmlRootElement(name = "MSG_BODY")
public class QrySchoolTeacherResponse {

    @XmlElement(name = "Relations")
    protected List<QrySchoolTeacherResponse.Relations> relations;

    /**
     * Gets the value of the relations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QrySchoolTeacherResponse.Relations }
     * 
     * 
     */
    public List<QrySchoolTeacherResponse.Relations> getRelations() {
        if (relations == null) {
            relations = new ArrayList<QrySchoolTeacherResponse.Relations>();
        }
        return this.relations;
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
     *         &lt;element name="SchoolTeacherRelation" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SchoolId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AreaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TownName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SchoolName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TeacherId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LoginName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="HeadImage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="EMail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "schoolTeacherRelation"
    })
    public static class Relations {

        @XmlElement(name = "SchoolTeacherRelation")
        protected List<QrySchoolTeacherResponse.Relations.SchoolTeacherRelation> schoolTeacherRelation;

        /**
         * Gets the value of the schoolTeacherRelation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the schoolTeacherRelation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSchoolTeacherRelation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link QrySchoolTeacherResponse.Relations.SchoolTeacherRelation }
         * 
         * 
         */
        public List<QrySchoolTeacherResponse.Relations.SchoolTeacherRelation> getSchoolTeacherRelation() {
            if (schoolTeacherRelation == null) {
                schoolTeacherRelation = new ArrayList<QrySchoolTeacherResponse.Relations.SchoolTeacherRelation>();
            }
            return this.schoolTeacherRelation;
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
         *         &lt;element name="SchoolId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AreaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TownName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SchoolName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TeacherId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LoginName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="HeadImage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="EMail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "schoolId",
            "areaName",
            "townName",
            "schoolName",
            "teacherId",
            "loginName",
            "userName",
            "headImage",
            "eMail"
        })
        public static class SchoolTeacherRelation {

            @XmlElement(name = "SchoolId")
            protected String schoolId;
            @XmlElement(name = "AreaName")
            protected String areaName;
            @XmlElement(name = "TownName")
            protected String townName;
            @XmlElement(name = "SchoolName")
            protected String schoolName;
            @XmlElement(name = "TeacherId")
            protected String teacherId;
            @XmlElement(name = "LoginName")
            protected String loginName;
            @XmlElement(name = "UserName")
            protected String userName;
            @XmlElement(name = "HeadImage")
            protected String headImage;
            @XmlElement(name = "EMail")
            protected String eMail;

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
             * 获取areaName属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAreaName() {
                return areaName;
            }

            /**
             * 设置areaName属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAreaName(String value) {
                this.areaName = value;
            }

            /**
             * 获取townName属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTownName() {
                return townName;
            }

            /**
             * 设置townName属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTownName(String value) {
                this.townName = value;
            }

            /**
             * 获取schoolName属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSchoolName() {
                return schoolName;
            }

            /**
             * 设置schoolName属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSchoolName(String value) {
                this.schoolName = value;
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
             * 获取loginName属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLoginName() {
                return loginName;
            }

            /**
             * 设置loginName属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLoginName(String value) {
                this.loginName = value;
            }

            /**
             * 获取userName属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUserName() {
                return userName;
            }

            /**
             * 设置userName属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUserName(String value) {
                this.userName = value;
            }

            /**
             * 获取headImage属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHeadImage() {
                return headImage;
            }

            /**
             * 设置headImage属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHeadImage(String value) {
                this.headImage = value;
            }

            /**
             * 获取eMail属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEMail() {
                return eMail;
            }

            /**
             * 设置eMail属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEMail(String value) {
                this.eMail = value;
            }

        }

    }

}
