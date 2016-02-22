//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.03.19 时间 05:13:46 PM CST 
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
 *         &lt;element name="ClassList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ClassEntity" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ClassId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SchoolId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="GradeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="GradeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Bank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ClassType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "classList"
})
@XmlRootElement(name = "MSG_BODY")
public class QryBatchClassResponse {

    @XmlElement(name = "ClassList")
    protected List<QryBatchClassResponse.ClassList> classList;

    /**
     * Gets the value of the classList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QryBatchClassResponse.ClassList }
     * 
     * 
     */
    public List<QryBatchClassResponse.ClassList> getClassList() {
        if (classList == null) {
            classList = new ArrayList<QryBatchClassResponse.ClassList>();
        }
        return this.classList;
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
     *         &lt;element name="ClassEntity" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ClassId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SchoolId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="GradeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="GradeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Bank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ClassType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "classEntity"
    })
    public static class ClassList {

        @XmlElement(name = "ClassEntity")
        protected List<QryBatchClassResponse.ClassList.ClassEntity> classEntity;

        /**
         * Gets the value of the classEntity property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the classEntity property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getClassEntity().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link QryBatchClassResponse.ClassList.ClassEntity }
         * 
         * 
         */
        public List<QryBatchClassResponse.ClassList.ClassEntity> getClassEntity() {
            if (classEntity == null) {
                classEntity = new ArrayList<QryBatchClassResponse.ClassList.ClassEntity>();
            }
            return this.classEntity;
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
         *         &lt;element name="ClassId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SchoolId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="GradeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="GradeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Bank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ClassType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "classId",
            "schoolId",
            "gradeId",
            "gradeName",
            "bank",
            "className",
            "classType"
        })
        public static class ClassEntity {

            @XmlElement(name = "ClassId")
            protected String classId;
            @XmlElement(name = "SchoolId")
            protected String schoolId;
            @XmlElement(name = "GradeId")
            protected String gradeId;
            @XmlElement(name = "GradeName")
            protected String gradeName;
            @XmlElement(name = "Bank")
            protected String bank;
            @XmlElement(name = "ClassName")
            protected String className;
            @XmlElement(name = "ClassType")
            protected String classType;

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
             * 获取gradeId属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGradeId() {
                return gradeId;
            }

            /**
             * 设置gradeId属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGradeId(String value) {
                this.gradeId = value;
            }

            /**
             * 获取gradeName属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGradeName() {
                return gradeName;
            }

            /**
             * 设置gradeName属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGradeName(String value) {
                this.gradeName = value;
            }

            /**
             * 获取bank属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBank() {
                return bank;
            }

            /**
             * 设置bank属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBank(String value) {
                this.bank = value;
            }

            /**
             * 获取className属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getClassName() {
                return className;
            }

            /**
             * 设置className属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setClassName(String value) {
                this.className = value;
            }

            /**
             * 获取classType属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getClassType() {
                return classType;
            }

            /**
             * 设置classType属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setClassType(String value) {
                this.classType = value;
            }

        }

    }

}
