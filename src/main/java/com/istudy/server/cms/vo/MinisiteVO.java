package com.istudy.server.cms.vo;

import com.istudy.server.common.utils.CommonUtils;
import com.istudy.server.common.vo.TaskNameViewVO;

/**
 * minisite值传递对象，在controller中和JSON字符串转换，在持久层中和数据库中的表数据映射转换。
 * @author LONGTING
 *
 */
public class MinisiteVO extends TaskNameViewVO{
	private String id            ;	
	private String taskName		;//任务名称
	private String type		;	//minisite类型,0:文字  ，1：图文，2：视频
	private String msgDetails   ;//信息详情
	private String remark        ;//备注
	private String suggestMonth ;//建议月份
	
	private String title         ;//文章标题
	
	private String details       ;//文章内容
	private String shortDetails   ;//摘要内容
	private String videoUrl       ;//视频地址
	private String label         ;//标签
	private String miniUrl      ;//文章地址
	private String imgUrl		;//图片地址
	
	private String createDate   ;//创建时间
	private String updateDate   ;//修改
	private String teachers      ;//适合的老师
	private String grades        ;//适合的年级
	private String miniTypeIds ;//文章类型id集合
	
	private String creator;//文章创建人
	private String creatorEntId;//文章创建人所在企业ID
	private String updator;//最后更新人
	private String subjectType;//主题类型 0分享，1家长会
	
	private String headerName;//页眉
	private String footerType;//页脚 0爱学网 ，1移动+爱学网
	
	private String faqs;
	
	private String shareType;//分享类型
	
	
	/**
	 * 获取主题类型描述
	 * @return
	 */
	public String getSubjectTypeDesc(){
		if(CommonUtils.isNull(subjectType)){
			return null;
		}
		if("1".equals(subjectType)){
			return "家长会";
		}else if("0".equals(subjectType)){
			if(CommonUtils.isNull(shareType)){
				return "分享";
			}else{
				return "分享_" + shareType;
			}
		}else{
			return null;
		}
	}
	
	public String getTypeName(){
		return CommonUtils.getTypeName(type);
	};
	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}



	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getMsgDetails() {
		return msgDetails;
	}
	public void setMsgDetails(String msgDetails) {
		this.msgDetails = msgDetails;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTeachers() {
		return teachers;
	}
	public void setTeachers(String teachers) {
		this.teachers = teachers;
	}
	public String getMiniUrl() {
		return miniUrl;
	}
	public void setMiniUrl(String miniUrl) {
		this.miniUrl = miniUrl;
	}
	public String getGrades() {
		return grades;
	}
	public void setGrades(String grades) {
		this.grades = grades;
	}
	public String getMiniTypeIds() {
		return miniTypeIds;
	}
	public void setMiniTypeIds(String miniTypeIds) {
		this.miniTypeIds = miniTypeIds;
	}
	public String getSuggestMonth() {
		return suggestMonth;
	}
	public void setSuggestMonth(String suggestMonth) {
		this.suggestMonth = suggestMonth;
	}
 
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	public String getHeaderName() {
		return headerName;
	}

	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}

	public String getFooterType() {
		return footerType;
	}

	public void setFooterType(String footerType) {
		this.footerType = footerType;
	}

	public String getShortDetails() {
		return shortDetails;
	}

	public void setShortDetails(String shortDetails) {
		this.shortDetails = shortDetails;
	}

	public String getFaqs() {
		return faqs;
	}

	public void setFaqs(String faqs) {
		this.faqs = faqs;
	}

	public String getShareType() {
		return shareType;
	}

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	public String getCreatorEntId() {
		return creatorEntId;
	}

	public void setCreatorEntId(String creatorEntId) {
		this.creatorEntId = creatorEntId;
	}
	
	
	
}
