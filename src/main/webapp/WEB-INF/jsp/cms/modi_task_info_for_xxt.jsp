<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>推送任务</title>
<link rel="stylesheet" href="css/layout.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/istudy-cms.js"></script>
<script type="text/javascript" src="js/date_picker/WdatePicker.js"  defer="defer"></script>
</head>
<body class="bc-white">
<div class="cms-container">
            <div class="location">
                资源库><strong>推送</strong>
            </div>
            <div class="cms-main">
                <div class="form-item push-step-item">
                    <h2>推送规则</h2>
                    <fieldset class="pos-r">
                        <div class="L clearfix">
                            <label class="label">城市：</label>
                            <div class="label-con">
                                <dd>
                                	 <table id="city_table">
                                	 	<c:forEach var="city" items="${citys}" varStatus="idx">
					 						<c:if test="${idx.index%12==0}">
					 							<tr>
					 						</c:if>
					 							<td>
						 							<input type="checkbox" 
						 							
						 							<c:set var="cityId" value=",${city.cityId},"/>
						 							<c:if test='${fn:contains(task.citys,cityId )}'> 
							 								checked="checked"
							 						</c:if>
						 							
						 							id="city"  value="${city.cityId }"/>
						 							<c:out value="${city.cityName }"/>
					 							</td>
					 						<c:if test="${idx.index%12==11||(idx.index+1)==fn:length(citys)}">
					 							</tr>
					 						</c:if>
					 					</c:forEach>
                                	 </table>
                                </dd>
                            </div>
                        </div>
                        
                        <div class="L clearfix">
                            <label class="label">年级：</label>
                            <div class="label-con">
                                <dd>
                                	<table id="grade_table">
                                	<c:forEach var="grade" items="${grades}" varStatus="idx">
				 						<c:if test="${idx.index%12==0}">
				 							<tr>
				 						</c:if>
				 							<td>
					 							<input type="checkbox" 
					 							<c:set var="gradeNO" value=",${grade.gradeNO},"/>
					 							<c:if test='${fn:contains(task.grades,gradeNO )}'> 
						 								checked="checked"
						 						</c:if>
					 							id="grade" value="${grade.gradeNO }"/>
					 							<c:out value="${grade.gradeName }"/>
				 							</td>
				 						<c:if test="${idx.index%12==11||(idx.index+1)==fn:length(grades)}">
				 							</tr>
				 						</c:if>
				 					</c:forEach>
                                	</table>
                                </dd>
                            </div>
                        </div>
                        
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>推送时间：</label>
                            <div class="label-con">
                            <input readonly="readonly"  size="25" value="${task.activeDate }" class="Wdate" type="text" id="activeDate" 
                            onClick="WdatePicker({autoPickDate:true,startDate:'%y-%M-%d 09:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d 09:00:00',alwaysUseStartDate:true})">
                            </div>
                        </div>
                        
                    </fieldset>

                    <h2>内容预览</h2>
                    <fieldset class="pos-r">
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>任务标题：</label>
                            <div class="label-con">
                                <input type="text" id="taskName" class="txt-input" value="${task.taskName}" size="90" />
                            </div>
                            <label class="label">类型：</label>
                            <div class="label-con">
                                <div class="con-strong">${task.typeName }</div>
                            </div>
                        </div>

                        <%-- <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>短信内容：</label>
                            <div class="label-con">
                                <textarea  id="msgDetails" class="txta">${task.msgDetails }</textarea>
                            </div>
                        </div>

                        <div class="L clearfix">
                            <label class="label">备注：</label>
                            <div class="label-con">
                                <textarea name="" id="remark" class="txta txta-bak">${task.remark }</textarea>
                            </div>
                        </div> --%>
						<c:if test="${minisite.type==1 || minisite.type==2}">
	                        <div class="L clearfix">
	                            <label class="label">预览：</label>
	                            <div class="label-con">
	                               <iframe id="show_minisite" scrolling="yes" width="1000" height="400px" 
        	frameborder="0" marginwidth="0px" marginheight="0px" 
        	src="<%=basePath%>xxtM/mPage.do.do?uri=${minisite.miniUrl}"></iframe>
	                            </div>
	                        </div>
						</c:if>
						
                    </fieldset>
                    <c:if test="${task.sendPublicStatus != '3' }">
                    <div >
                    <a href="javascript:pushTask(this);" class="btn-submit">保存</a>
                    <span style="color: red;" id="error_msg" ></span>
                    </div>
                    </c:if>
                </div>
            </div>
        </div>
        <input type="hidden" id="minisiteId" value="${task.miniUrl }">
        <input type="hidden" id="taskId" value="${task.id }">
</body>

<script type="text/javascript">
$(document).ready(function(){
	if("$(task.sendPublicStatus == '3')"){
		$('input,textarea').attr('disabled','true');
	}
})  
	function validation(){
		var activeDate=$('#activeDate').val(),
		msgDetails = $('#msgDetails').val(),
		remark = $('#remark').val(),
		taskName=$('#taskName').val();
		
		//校验城市和年级不能为空
		if($("#city_table input:checked").length==0){
			return "城市不能为空";		
		}
		if($("#grade_table input:checked").length==0){
			return "年级不能为空";		
		}
		
		if($.isNull(activeDate)){
			return "推送时间不能为空";
		}
		
		if($.isNull(taskName)){
    		return "短信标题不能为空";
    	}
    	if($.charLength(taskName)>255){
    		return "短信标题长度不能超过255位，汉字占3位";
    	} 
    	/* if($.isNull(msgDetails)){
    		return "短信内容不能为空";
    	}
    	if(msgDetails.length>100){
    		return "短信内容字数不能超过100个";
    	}
    	if($.charLength(remark)>255){
    		return "备注长度不能超过255位，汉字占3位";
    	}   */
	}
	function pushTask(obj){
		
		var grade = "",
			error_msg = $('#error_msg'),
			city = "";
    	$('input[id="grade"]:checked').each(function(){ 
    		grade+=($(this).val()+",");   
   		}); 
    	if(grade.length>0){
    		grade=","+grade;
    	}
    	
    	$('input[id="city"]:checked').each(function(){ 
    		city+=($(this).val()+",");   
   		}); 
    	if(city.length>0){
    		city=","+city;
    	}
    	
		var resouce = {
				activeDate:$('#activeDate').val(),
    			taskName:$('#taskName').val(),
    			minisiteId:$('#minisiteId').val(),
    			grades:grade,
    			id:$('#taskId').val(),
    			citys:city
    	};
		var msg = validation();
		if(msg){
			error_msg.html(msg);
			return ;
		}
		$(obj).attr("disabled","disabled");
		$.ajax({
   		 type: "POST",
   		 url: "cmsTask/modiTaskInfoForXXT.do",
   		 data: eval(resouce),
   		 dataType: "json",
   		 success: function(obj){
   			 alert(obj.desc);
   			 //window.location.reload();
   			location.href=url_head+"cmsTask/showPaging.do?target=cms_task_list_for_xxt";
   		 }
   		});  
	}
</script>
</html>