package com.istudy.server.common.protocol.ws.xxt.vo;

//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.05.09 时间 05:17:13 PM CST 
//



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
 *         &lt;element name="StudentInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ClassId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="GradeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="GradeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="StudentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="StudentSeq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="LoginName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SchoolId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "studentInfo"
})
@XmlRootElement(name = "MSG_BODY")
public class QryClassStudentResponse {

    @XmlElement(name = "StudentInfo")
    protected List<QryClassStudentResponse.StudentInfo> studentInfo;

    /**
     * Gets the value of the studentInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studentInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudentInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QryClassStudentResponse.StudentInfo }
     * 
     * 
     */
    public List<QryClassStudentResponse.StudentInfo> getStudentInfo() {
        if (studentInfo == null) {
            studentInfo = new ArrayList<QryClassStudentResponse.StudentInfo>();
        }
        return this.studentInfo;
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
     *         &lt;element name="ClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="GradeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="GradeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="StudentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="StudentSeq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="LoginName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SchoolId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "className",
        "gradeId",
        "gradeName",
        "studentId",
        "studentSeq",
        "loginName",
        "userName",
        "sex",
        "schoolId"
    })
    public static class StudentInfo {

        @XmlElement(name = "ClassId")
        protected String classId;
        @XmlElement(name = "ClassName")
        protected String className;
        @XmlElement(name = "GradeId")
        protected String gradeId;
        @XmlElement(name = "GradeName")
        protected String gradeName;
        @XmlElement(name = "StudentId")
        protected String studentId;
        @XmlElement(name = "StudentSeq")
        protected String studentSeq;
        @XmlElement(name = "LoginName")
        protected String loginName;
        @XmlElement(name = "UserName")
        protected String userName;
        @XmlElement(name = "Sex")
        protected String sex;
        @XmlElement(name = "SchoolId")
        protected String schoolId;

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
         * 获取sex属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSex() {
            return sex;
        }

        /**
         * 设置sex属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSex(String value) {
            this.sex = value;
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

    }

}
