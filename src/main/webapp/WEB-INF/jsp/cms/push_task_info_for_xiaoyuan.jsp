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
            <div class="cms-main">
                <div class="form-item push-step-item">
                        <%-- <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>城市：</label>
                            <div class="label-con">
                                <input type="checkbox" id="all_citys"/>全选
                                <dd>
                                	 <table id="city_table">
                                	 	<c:forEach var="city" items="${citys}" varStatus="idx">
					 						<c:if test="${idx.index%12==0}">
					 							<tr>
					 						</c:if>
					 							<td>
						 							<input type="checkbox" id="city"  value="${city.cityId }"/>
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
                            <label class="label"><span style="color: red">*</span>年级：</label>
                            <div class="label-con">
                                <dd>
                                	<table id="grade_table">
                                	<tr><input type="checkbox" id="all_grades"/>全选</tr>
                                	<c:forEach var="grade" items="${grades}" varStatus="idx">
				 						<c:if test="${idx.index%12==0}">
				 							<tr>
				 						</c:if>
				 							<td>
					 							<input type="checkbox" 
					 							<c:set var="gradeNO" value=",${grade.gradeNO},"/>
					 							<c:if test='${fn:contains(minisite.grades,gradeNO )}'> 
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
                        --%>
                        
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>推送时间：</label>
                            <div class="label-con">
                            <input readonly="readonly" class="Wdate" size="25" type="text" id="activeDate" 
                            onClick="WdatePicker({autoPickDate:true,startDate:'%y-%M-%d 09:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d 09:00:00',alwaysUseStartDate:true})">
                            </div>
                        </div>
                        
                        <!--  <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>失效时间：</label>
                            <div class="label-con">
                            <input readonly="readonly" class="Wdate" size="25" type="text" id="validDate" 
                            onClick="WdatePicker({autoPickDate:true,startDate:'%y-%M-%d 09:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d 09:00:00',alwaysUseStartDate:true})">
                            </div>
                        </div> -->

                        <!--<div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>短信内容：</label>
                            <div class="label-con">
                                <textarea  id="msgDetails" class="txta">${minisite.msgDetails }</textarea>
                            </div>
                        </div>-->

						<%-- <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>短信内容：</label>
                            <div class="label-con">
                                <textarea  id="msgDetails" class="txta">${minisite.msgDetails }</textarea>
                            </div>
                        </div> --%>

                       <!--  <div class="L clearfix">
                            <label class="label">备注：</label>
                            <div class="label-con">
                                <textarea name="" id="remark" class="txta txta-bak">${minisite.remark }</textarea>
                            </div>
                        </div> -->
                        
						<c:if test="${minisite.type==1 || minisite.type==2}">
	                        <div class="L clearfix">
	                            <label class="label">预览：</label>
	                            <div class="label-con">
	                               <iframe id="show_minisite" scrolling="yes" width="450" height="400px" 
        	frameborder="0" marginwidth="0px" marginheight="0px" 
        	src="<%=basePath%>xxtM/mPage.do.do?uri=${minisite.miniUrl}"></iframe>
	                            </div>
	                        </div>
						</c:if>
                    <div >
                    <a id="submit-btn" href="javascript:pushTask(this);"  class="btn-submit-app">推送至校园+APP</a>
                    <span style="margin:15px 15px 0 350px;color: red" id="error_msg" ></span>
                    </div>
                </div>
            </div>
        </div>
        <input type="hidden" id="minisiteId" value="${minisite.id }">
</body>

<script type="text/javascript">
	var _isIE = window.navigator.userAgent.indexOf("MSIE") >= 1;
	var ieImageSizeCache = {};
    $().ready(function(){
    	$('#all_citys').click(function(){
    		$(':checkbox[id="city"]').prop("checked", function( i, val ) {
	    		  return $('#all_citys').prop('checked');
	    	 });
    	});
    	$('#all_grades').click(function(){
    		$(':checkbox[id="grade"]').prop("checked", function( i, val ) {
	    		  return $('#all_grades').prop('checked');
	    	 });
    	});
    	
    	/* $('#all_citys').toggle(
		  function () {
			   alert(true);
			  },
			  function () {
			    alert(false);
			  }
			); */
		
    });
    
	function validation(){
		var activeDate=$('#activeDate').val(),
		validDate=$('#validDate').val(),
		msgDetails = $('#msgDetails').val(),
		remark = $('#remark').val(),
		taskName=$('#taskName',parent.document).val(),
		newsThumbImg=$("#subimg_url").val();
		
		//校验城市和年级不能为空
		/* if($("#city_table input:checked").length==0){
			return "城市不能为空";		
		} */
		if($("#grade_table input:checked",parent.document).length==0){
			return "年级不能为空";		
		}
		//$("#grade_table input:checked");
		if($.isNull(activeDate)){
			return "推送时间不能为空";
		}
		//if($.isNull(validDate)||validDate<=activeDate){
		//	return "失效时间不能为空或小于推送时间";
		//}
		if($.isNull(taskName)){
    		return "任务标题不能为空";
    	}
    	if($.charLength(taskName)>255){
    		return "任务标题长度不能超过255位，汉字占3位";
    	} 
    	/*if($.isNull(msgDetails)){
    		return "短信内容不能为空";
    	}
    	if(msgDetails.length>100){
    		return "短信内容字数不能超过100个";
    	}
    	if($.charLength(remark)>255){
    		return "备注长度不能超过255位，汉字占3位";
    	}*/
	}
	function pushTask(obj){
		
		var grade = "",
			error_msg = $('#error_msg'),
			city = "";
    	$('input[id="grade"]:checked',parent.document).each(function(){ 
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
				validDate:$('#validDate').val(),
    			//msgDetails : $('#msgDetails').val(),
    			//remark : $('#remark').val(),
    			taskName:$('#taskName',parent.document).val(),
    			minisiteId:$('#minisiteId').val(),
    			grades:grade,
    			miniUrl : '${minisite.miniUrl}',
    			subjectType : '${minisite.subjectType}',
    			citys:city
    	};
		var msg = validation();
		if(msg){
			error_msg.html(msg);
			return ;
		}else{
			error_msg.html("");
		}
		
		$.ajax({
   		 type: "POST",
   		 url: "cmsTask/saveTaskInfoForXiaoyuan.do",
   		 data: eval(resouce),
   		 dataType: "json",
   		 success: function(obj){
   			 alert(obj.desc);
   			 if(obj.code == "10000"){
   				$("#submit-btn").hide();
   				//$('#submit-btn').attr('href','javascript:void();');
   				//$('#submit-btn').attr('disabled',true);
   			 }
   			 //window.location.reload();
   			 //location.href = url_head+'minisite/showPaging.do?target=minisite_list'; 
   		 }
   		});  
	}
	
</script>
</html>