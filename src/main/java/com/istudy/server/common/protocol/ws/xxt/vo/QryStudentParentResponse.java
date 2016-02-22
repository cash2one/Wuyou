//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.03.18 时间 05:18:33 PM CST 
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
 *                   &lt;element name="StudentParentRelation" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="StudentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="StuLoginName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="StuUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ParentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ParLoginName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ParUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
public class QryStudentParentResponse {

    @XmlElement(name = "Relations")
    protected List<QryStudentParentResponse.Relations> relations;

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
     * {@link QryStudentParentResponse.Relations }
     * 
     * 
     */
    public List<QryStudentParentResponse.Relations> getRelations() {
        if (relations == null) {
            relations = new ArrayList<QryStudentParentResponse.Relations>();
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
     *         &lt;element name="StudentParentRelation" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="StudentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="StuLoginName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="StuUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ParentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ParLoginName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ParUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "studentParentRelation"
    })
    public static class Relations {

        @XmlElement(name = "StudentParentRelation")
        protected List<QryStudentParentResponse.Relations.StudentParentRelation> studentParentRelation;

        /**
         * Gets the value of the studentParentRelation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the studentParentRelation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStudentParentRelation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link QryStudentParentResponse.Relations.StudentParentRelation }
         * 
         * 
         */
        public List<QryStudentParentResponse.Relations.StudentParentRelation> getStudentParentRelation() {
            if (studentParentRelation == null) {
                studentParentRelation = new ArrayList<QryStudentParentResponse.Relations.StudentParentRelation>();
            }
            return this.studentParentRelation;
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
         *         &lt;element name="StudentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="StuLoginName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="StuUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ParentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ParLoginName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ParUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "studentId",
            "stuLoginName",
            "stuUserName",
            "parentId",
            "parLoginName",
            "parUserName",
            "stuHeadImage",
            "stuEMail",
            "parHeadImage",
            "parEMail"
        })
        public static class StudentParentRelation {

            @XmlElement(name = "StudentId")
            protected String studentId;
            @XmlElement(name = "StuLoginName")
            protected String stuLoginName;
            @XmlElement(name = "StuUserName")
            protected String stuUserName;
            @XmlElement(name = "ParentId")
            protected String parentId;
            @XmlElement(name = "ParLoginName")
            protected String parLoginName;
            @XmlElement(name = "ParUserName")
            protected String parUserName;

            @XmlElement(name = "StuHeadImage")
            protected String stuHeadImage;
            @XmlElement(name = "StuEMail")
            protected String stuEMail;
            @XmlElement(name = "ParHeadImage")
            protected String parHeadImage;
            @XmlElement(name = "ParEMail")
            protected String parEMail;

            /**
             * 获取studentId属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStudentId() {
                return studentId;
            }

            /**
             * 设置studentId属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStudentId(String value) {
                this.studentId = value;
            }

            /**
             * 获取stuLoginName属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStuLoginName() {
                return stuLoginName;
            }

            /**
             * 设置stuLoginName属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStuLoginName(String value) {
                this.stuLoginName = value;
            }

            /**
             * 获取stuUserName属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStuUserName() {
                return stuUserName;
            }

            /**
             * 设置stuUserName属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStuUserName(String value) {
                this.stuUserName = value;
            }

            /**
             * 获取parentId属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getParentId() {
                return parentId;
            }

            /**
             * 设置parentId属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setParentId(String value) {
                this.parentId = value;
            }

            /**
             * 获取parLoginName属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getParLoginName() {
                return parLoginName;
            }

            /**
             * 设置parLoginName属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setParLoginName(String value) {
                this.parLoginName = value;
            }

            /**
             * 获取parUserName属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getParUserName() {
                return parUserName;
            }

            /**
             * 设置parUserName属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setParUserName(String value) {
                this.parUserName = value;
            }

			public String getStuHeadImage() {
				return stuHeadImage;
			}

			public void setStuHeadImage(String stuHeadImage) {
				this.stuHeadImage = stuHeadImage;
			}

			public String getStuEMail() {
				return stuEMail;
			}

			public void setStuEMail(String stuEMail) {
				this.stuEMail = stuEMail;
			}

			public String getParHeadImage() {
				return parHeadImage;
			}

			public void setParHeadImage(String parHeadImage) {
				this.parHeadImage = parHeadImage;
			}

			public String getParEMail() {
				return parEMail;
			}

			public void setParEMail(String parEMail) {
				this.parEMail = parEMail;
			}

        }

    }

}
