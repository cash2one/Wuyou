//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.03.18 时间 02:11:38 PM CST 
//


package com.istudy.server.common.protocol.ws.xxt.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *         &lt;element name="SchoolEntity">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SchoolId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="AreaId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="AreaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TownName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SchoolName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Section" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TownId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="StudentEntity">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="StudentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="StudentSeq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
 *         &lt;element name="ParentList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ParentEntity" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ParentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ParUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CheckCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "schoolEntityOrStudentEntityOrClassList"
})
@XmlRootElement(name = "MSG_BODY")
public class QryBaseDataResponse {

    @XmlElements({
        @XmlElement(name = "SchoolEntity", type = QryBaseDataResponse.SchoolEntity.class),
        @XmlElement(name = "StudentEntity", type = QryBaseDataResponse.StudentEntity.class),
        @XmlElement(name = "ClassList", type = QryBaseDataResponse.ClassList.class),
        @XmlElement(name = "ParentList", type = QryBaseDataResponse.ParentList.class)
    })
    protected List<Object> schoolEntityOrStudentEntityOrClassList;

    /**
     * Gets the value of the schoolEntityOrStudentEntityOrClassList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the schoolEntityOrStudentEntityOrClassList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSchoolEntityOrStudentEntityOrClassList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QryBaseDataResponse.SchoolEntity }
     * {@link QryBaseDataResponse.StudentEntity }
     * {@link QryBaseDataResponse.ClassList }
     * {@link QryBaseDataResponse.ParentList }
     * 
     * 
     */
    public List<Object> getSchoolEntityOrStudentEntityOrClassList() {
        if (schoolEntityOrStudentEntityOrClassList == null) {
            schoolEntityOrStudentEntityOrClassList = new ArrayList<Object>();
        }
        return this.schoolEntityOrStudentEntityOrClassList;
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
        protected List<QryBaseDataResponse.ClassList.ClassEntity> classEntity;

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
         * {@link QryBaseDataResponse.ClassList.ClassEntity }
         * 
         * 
         */
        public List<QryBaseDataResponse.ClassList.ClassEntity> getClassEntity() {
            if (classEntity == null) {
                classEntity = new ArrayList<QryBaseDataResponse.ClassList.ClassEntity>();
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
     *         &lt;element name="ParentEntity" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ParentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ParUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CheckCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "parentEntity"
    })
    public static class ParentList {

        @XmlElement(name = "ParentEntity")
        protected List<QryBaseDataResponse.ParentList.ParentEntity> parentEntity;

        /**
         * Gets the value of the parentEntity property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the parentEntity property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getParentEntity().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link QryBaseDataResponse.ParentList.ParentEntity }
         * 
         * 
         */
        public List<QryBaseDataResponse.ParentList.ParentEntity> getParentEntity() {
            if (parentEntity == null) {
                parentEntity = new ArrayList<QryBaseDataResponse.ParentList.ParentEntity>();
            }
            return this.parentEntity;
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
         *         &lt;element name="ParentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ParUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CheckCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "parentId",
            "parLoginName",
            "parUserName",
            "parHeadImage",
            "parEMail",
            "checkCode"
        })
        public static class ParentEntity {

            @XmlElement(name = "ParentId")
            protected String parentId;
            @XmlElement(name = "ParLoginName")
            protected String parLoginName;
            @XmlElement(name = "ParUserName")
            protected String parUserName;
            @XmlElement(name = "ParHeadImage")
            protected String parHeadImage;
            @XmlElement(name = "ParEMail")
            protected String parEMail;
            @XmlElement(name = "CheckCode")
            protected String checkCode;

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

            /**
             * 获取checkCode属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCheckCode() {
                return checkCode;
            }

            /**
             * 设置checkCode属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCheckCode(String value) {
                this.checkCode = value;
            }

			public String getParLoginName() {
				return parLoginName;
			}

			public void setParLoginName(String parLoginName) {
				this.parLoginName = parLoginName;
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
     *         &lt;element name="AreaId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="AreaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TownName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SchoolName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Section" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TownId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "areaId",
        "areaName",
        "townName",
        "schoolName",
        "section",
        "townId"
    })
    public static class SchoolEntity {

        @XmlElement(name = "SchoolId")
        protected String schoolId;
        @XmlElement(name = "AreaId")
        protected String areaId;
        @XmlElement(name = "AreaName")
        protected String areaName;
        @XmlElement(name = "TownName")
        protected String townName;
        @XmlElement(name = "SchoolName")
        protected String schoolName;
        @XmlElement(name = "Section")
        protected String section;
        @XmlElement(name = "TownId")
        protected String townId;

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
         * 获取areaId属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAreaId() {
            return areaId;
        }

        /**
         * 设置areaId属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAreaId(String value) {
            this.areaId = value;
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
         * 获取section属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSection() {
            return section;
        }

        /**
         * 设置section属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSection(String value) {
            this.section = value;
        }

        /**
         * 获取townId属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTownId() {
            return townId;
        }

        /**
         * 设置townId属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTownId(String value) {
            this.townId = value;
        }

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
     *         &lt;element name="StudentSeq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "studentSeq",
        "loginName",
        "userName",
        "headImage",
        "eMail"
    })
    public static class StudentEntity {

    	
        @XmlElement(name = "StudentId")
        protected String studentId;
        @XmlElement(name = "StudentSeq")
        protected String studentSeq;
        @XmlElement(name = "UserName")
        protected String userName;
        @XmlElement(name = "LoginName")
        protected String loginName;
        @XmlElement(name = "HeadImage")
        protected String headImage;
        @XmlElement(name = "EMail")
        protected String eMail;

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
         * 获取studentSeq属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStudentSeq() {
            return studentSeq;
        }

        /**
         * 设置studentSeq属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStudentSeq(String value) {
            this.studentSeq = value;
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

		public String getLoginName() {
			return loginName;
		}

		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}

		public String getHeadImage() {
			return headImage;
		}

		public void setHeadImage(String headImage) {
			this.headImage = headImage;
		}

		public String getEMail() {
			return eMail;
		}

		public void setEMail(String eMail) {
			this.eMail = eMail;
		}

    }

}
