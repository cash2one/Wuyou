package com.istudy.server.xxt.vo;

import org.apache.cxf.jaxrs.ext.form.Form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.istudy.server.common.utils.CommonUtils;

public class XXTRegisterRequestVO {
	
	private String mobile; //手机号
	private String trueName;//学生名字（中文）
	private String school;//学校名称（中文）
	private String grade;//年级（数字 1-12）
	private int motivation = 4;//4.高三一模报告预约
	private int flag = 2;//1 校讯通 2 自有渠道
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	
	public int getMotivation() {
		return motivation;
	}
	public void setMotivation(int motivation) {
		this.motivation = motivation;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@JsonIgnore
	public Form getParamForm() {
		Form form = new Form();
		form.set("mobile", CommonUtils.nullToEmpty(mobile));
		form.set("trueName", CommonUtils.nullToEmpty(trueName));
		form.set("school", CommonUtils.nullToEmpty(school));
		form.set("grade", CommonUtils.nullToEmpty(grade));
		form.set("motivation", motivation);
		form.set("flag", flag);
		return form;
	}
	  
	
	/**********
	 * 
	 * 接口注意事项描述
	 * 
	 *  1、只接收post请求
		2、以下情况接口没有输出
			1、post数据为空
			2、学生名字大于20个字节
			3、学校名称大于100个字节
			4、手机号为空字符串或未传递手机号
		
		3、手机号：
			1、长度(11) 
			2、字符(0-9)
			3、首位字符(1)
		4、学校名称
			1、长度100个字节
		5、年级
			1、数字
			2、区间(1-12)
			3、否则默认12
		6、学生名字
			1、长度20个字节
		
		目前接口说明
		1、年级与数字对应关系
				1	一年级
				2	二年级
				3	三年级
				4	四年级
				5	五年级
				6	六年级
				7	初一
				8	初二
				9	初三
				10	高一
				11	高二
				12	高三
				
		2、 注册用户：标识为 “校讯通用户”  会员名为xxt+手机号
			匹配用户：未标识 “校讯通用户”
		
		3、 注册用户：新增记录
			匹配用户：只查询未更新
		
		4、省市区默认值：广东省, 广州市, 天河区（学校名称无法完全匹配时使用）
		
		5、对于有输出的调用有调用记录
		
		6、匹配成功 | 注册成功 时发送短信
		
		7、用户使用会员名（xxt+手机号）或手机号都可以登录
	 * 
	 * 
	 * 
	 */
	
}
