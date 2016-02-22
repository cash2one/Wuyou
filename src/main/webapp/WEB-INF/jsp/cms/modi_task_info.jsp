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
                        <label class="label"><span style="color: red">*</span>推送规则：</label>
                        <label onclick="hide1()"><input type="radio" name="rule" id="rule" value="1" <c:if test="${task.rule=='1' }">checked="checked"</c:if> />城市+学校</label>
                        <label onclick="hide2()"><input type="radio" name="rule" id="rule" value="2" <c:if test="${task.rule=='2' }">checked="checked"</c:if>/>城市+年级</label>
                        <label onclick="hide3()"><input type="radio" name="rule" id="rule" value="3" <c:if test="${task.rule=='3' }">checked="checked"</c:if>/>城市+学校+年级</label>
                        </div>
                        
                        
                        
                         <div class="L clearfix" id="city1">
                             <label class="label"><span style="color: red">*</span>城市：</label>
                            <div class="label-con">
                            <label id="all_citys"><input type="checkbox" />全选</label> 
                                	 <div id="city_table">
                                	 	<c:forEach var="city" items="${citys}" varStatus="idx">
                                	 				<label id="city">
						 							<input type="checkbox" 
						 							
						 							<c:set var="cityId" value="${city.cityId}"/>
						 							<c:if test='${fn:contains(task.citys,cityId )}'> 
							 								checked="checked"
							 						</c:if>
						 							
						 							id="city"  value="${city.cityId }"/>
						 							<c:out value="${city.cityName }"/>
						 							</label>
					 					</c:forEach>
                                	 </div>
                                </dd>
                            </div>
                        </div>
                        
                         <div class="L clearfix" id= 'school1'>
                            <label class="label"><span style="color: red">*</span>学校：</label>
                            <div class="label-con">
                                <!-- <input type="checkbox" id="all_schools"/>全选 -->
                               	 <div id="school_table">
                               	 
                               	 	<c:forEach var="school" items="${schools}" varStatus="idx">
		 								<label id="school" data-city="${school.schoolCity }">
			 							<input type="checkbox" value="${school.schoolId }|${school.schoolCity }"
			 							<c:set var="schoolIds" value="${school.schoolId }|${school.schoolCity }"></c:set>
			 							<c:if test='${fn:contains(task.schoolIds,schoolIds)}'> 
							 								checked="checked"
							 						</c:if>
							 						/>
			 							<c:out value="${school.schoolName }"/>
			 							</label>
				 					</c:forEach>
                               	 </div>
                            </div>
                        </div>
                        
                        
                        <div class="L clearfix" id="grade1">
                             <label class="label"><span style="color: red">*</span>年级：</label>
                            <div class="label-con">
                                	<div id="grade_table">
                                	<label id="all_grades"><input type="checkbox"/>全选</label>
                                	<div id="grades_list">
                                	<c:forEach var="grade" items="${grades}" varStatus="idx">
                                				<label>
					 							<input type="checkbox" 
					 							<c:set var="gradeNO" value=",${grade.gradeNO},"/>
					 							<c:if test='${fn:contains(task.grades,gradeNO )}'> 
						 								checked="checked"
						 						</c:if>
					 							id="grade" value="${grade.gradeNO }"/>
					 							<c:out value="${grade.gradeName }"/>
					 							</label>
				 					</c:forEach>
                                	</div>
                                	</div>
                            </div>
                        </div>
                        
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>推送时间：</label>
                            <div class="label-con">
                            <input readonly="readonly"  size="25" value="${task.activeDate }" class="Wdate" type="text" id="activeDate" 
                            onClick="WdatePicker({autoPickDate:true,startDate:'%y-%M-%d 09:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d 09:00:00',alwaysUseStartDate:true})">
                            </div>
                        </div>
                        
                           <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>失效时间：</label>
                            <div class="label-con">
                            <input readonly="readonly" class="Wdate" size="25"  value="${task.validDate }" type="text" id="validDate" 
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
                                <div class="con-strong">${task.typeName }(<c:if test="${task.subjectType==0 }">分享</c:if><c:if test="${task.subjectType==1 }">家长会</c:if>)</div>
                            </div>
                        </div>

                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>短信内容：</label>
                            <div class="label-con">
                                <textarea id="msgDetails" class="txta">${task.msgDetails }</textarea>
                            </div>
                        </div>

                        <div class="L clearfix">
                            <label class="label">备注：</label>
                            <div class="label-con">
                                <textarea name="" id="remark" class="txta txta-bak">${task.remark }</textarea>
                            </div>
                        </div>
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
var _isIE = window.navigator.userAgent.indexOf("MSIE") >= 1;
var ieImageSizeCache = {};

	var $cityLable = $("#city_table label"),
	$allCityLable = $("#all_citys"),
	$schoolLable = $("#school_table label"),
	$allGrades = $("#all_grades"),
	$gradesList = $("#grades_list label");
	
	
	$schoolLable.hide();
	if($("input[name='rule']:checked").val()=='1'){
	  	$('#grade1').hide();
	  	$schoolLable.show();
	}
	if($("input[name='rule']:checked").val()=='2'){
	 	$('#school1').hide();
	  	$('#city1').show();
	  	$('#grade1').show();
	}
	if($("input[name='rule']:checked").val()=='3'){
		$schoolLable.show();
	}
	
	$allCityLable.click(function(){
		var isTrue = $(this).children("input").prop("checked");
		
		if(isTrue) {
			$schoolLable.show();
		} else {
			$schoolLable.hide();
			$schoolLable.children("input").prop("checked", false);
		}
		
		$cityLable.children("input").each(function() {
			$(this).prop("checked", isTrue);
		});
	});
	
	$cityLable.click(function() {
		var $input = $(this).children("input"),
			city = $input.val(),
			isTrue = $input.prop("checked"),
			datacity = "[data-city="+ city + "]";

		if(isTrue) {
			$schoolLable.filter(datacity).show();
		} else {
			$schoolLable.filter(datacity).hide();
			$schoolLable.children("input").prop("checked", false);
		}
		
	});
	

	
	$allGrades.click(function() {
		var isChecked = $(this).children("input").prop("checked");
		
		$gradesList.children("input").each(function() {
			$(this).prop("checked", isChecked);
		});
	});

	function clearChecked() {
	$allCityLable.children("input").prop("checked", false);
   	$cityLable.each(function() {
   		$(this).children("input").prop("checked", false);
   	});
   	
   	$schoolLable.each(function() {
   		$(this).children("input").prop("checked", false);
   	});
   	
   	$allGrades.children("input").prop("checked", false);
   	$gradesList.each(function() {
   		$(this).children("input").prop("checked", false);
   	});
}
   
  function hide1(){
  	$('#grade1').hide();
  	$('#city1').show();
  	$('#school1').show();
  	clearChecked();
  }
  
  function hide2(){
  	$('#school1').hide();
  	$('#city1').show();
  	$('#grade1').show();
  	clearChecked();
  }
  
  function hide3(){
  	$('#school1').show();
  	$('#city1').show();
  	$('#grade1').show();
  	clearChecked();
  }	


function validation(){
	var activeDate=$('#activeDate').val(),
	validDate=$('#validDate').val(),
	msgDetails = $('#msgDetails').val(),
	remark = $('#remark').val(),
	taskName=$('#taskName').val(),
	newsThumbImg=$("#subimg_url").val(),
	rule=$("input[name='rule']:checked").val();
	//sourceType = $('input[name=sourceType]:checked').val();
	//校验城市和年级不能为空
	/* if($("#school_table input:checked").length==0){
		return "学校不能为空";
	} */
	
	if($("#city_table input:checked").length==0){
		return "城市不能为空";		
	}
	if(rule!=1 && $("#grade_table input:checked").length==0){
		return "年级不能为空";
	}
	if(rule!=2 && $("#school_table input:checked").length==0){
		return "学校不能为空";
	}
	//$("#grade_table input:checked");
	if($.isNull(activeDate)){
		return "推送时间不能为空";
	}
	if($.isNull(validDate)||validDate<=activeDate){
		return "失效时间不能为空或小于推送时间";
	}
	if($.isNull(taskName)){
		return "任务标题不能为空";
	}
	if($.charLength(taskName)>255){
		return "任务标题长度不能超过255位，汉字占3位";
	} 
	if($.isNull(msgDetails)){
		return "短信内容不能为空";
	}
	if(msgDetails.length>200){
		return "短信内容字数不能超过200个";
	}
	if($.charLength(remark)>255){
		return "备注长度不能超过255位，汉字占3位";
	}
	//if($.isNull(sourceType)){
	//	return "推送类型不能为空";
	//}
}

	function pushTask(obj){
		
		var grade = "",
		error_msg = $('#error_msg'),
		city = "";
		schoolIds = "";
	$('input[id="grade"]:checked').each(function(){ 
		grade+=($(this).val()+",");
		}); 
	if(grade.length>0){
		grade=","+grade;
	}
	
	
	/* var schoolIds = new Array();
		var gradeArray = new Array();
		var cityArray = new Array();
		var gradeTmp = {};
		var cityTmp = {};
	$("input[id=schoolIds]:checked").each(function(){
		var $this = $(this);
		schoolIds.push($this.val());
		
		var cityId = $this.attr("cityId");
		if(!cityTmp[cityId]){
			cityTmp[cityId] = "1";
			cityArray.push(cityId);
		}
		
		var grades = $this.attr("grades") || "";
		var grd = grades.split(",");
		for(var i = 0; i < grd.length; i++){
			var cur = grd[i];
			if(!gradeTmp[cur]){
    			gradeTmp[cur] = "1";
    			gradeArray.push(cur);
    		}
		}
	}); */
	
	$('label[id="city"] input:checked').each(function(){ 
		city+=($(this).val()+",");   
		}); 
	if(city.length>0){
		city=","+city;
	}
	
	$('label[id="school"] input:checked').each(function(){ 
		schoolIds+=($(this).val()+",");   
		}); 
	if(schoolIds.length>0){
		schoolIds=","+schoolIds;
	}
	
	var resouce = {
			id:'${task.id }',
			activeDate:$('#activeDate').val(),
			validDate:$('#validDate').val(),
			msgDetails : $('#msgDetails').val(),
			remark : $('#remark').val(),
			taskName:$('#taskName').val(),
			minisiteId:$('#minisiteId').val(),
			grades:grade,
			//grades: "," + gradeArray.join() + ",",
			miniUrl : '${minisite.miniUrl}',
			citys:city,
			//citys:"," + cityArray.join() + ",",
			schoolIds:schoolIds,
			rule:$("input[name='rule']:checked").val()
			//sourceType:$('input[name=sourceType]:checked').val()
	};
		var msg = validation();
		if(msg){
			error_msg.html(msg);
			return ;
		}
		//alert(resouce);
		$(obj).attr("disabled","disabled");
		$.ajax({
   		 type: "POST",
   		 url: "cmsTask/modiTaskInfo.do",
   		 data: eval(resouce),
   		 dataType: "json",
   		 success: function(obj){
   			 alert(obj.desc);
   			 //window.location.reload();
   			location.href=url_head+"cmsTask/showPaging.do?target=cms_task_list";
   		 }
   		});  
	}
</script>
</html>