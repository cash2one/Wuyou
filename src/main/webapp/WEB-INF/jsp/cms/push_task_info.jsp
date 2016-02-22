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
                        <div class="L clearfix">
                        <label class="label"><span style="color: red">*</span>推送规则：</label>
                        <label onclick="hide1()"><input type="radio" name="rule" id="rule" value="1">城市+学校</label>
                        <label onclick="hide2()"><input type="radio" name="rule" id="rule" value="2">城市+年级</label>
                        <label onclick="hide3()"><input type="radio" name="rule" id="rule" value="3" checked="checked">城市+学校+年级</label>
                        </div>
                        <div class="L clearfix" id="city1">
                            <label class="label"><span style="color: red">*</span>城市：</label>
                            <div class="label-con">
	                            <label id="all_citys"><input type="checkbox" />全选</label>
	                                
	                            <div id="city_table">
	                            	<c:forEach var="city" items="${citys}" varStatus="idx">	 							
		 								<label id="city">
			 							<input type="checkbox"  value="${city.cityId }"/>
			 							<c:out value="${city.cityName }"/>
			 							</label>
		 							</c:forEach>
	                            </div>
	                                <%-- <select id="city" onchange="chooseSchool()">
	                                <c:forEach var="city" items="${citys}">
	                                <option value="${city.cityId }">${city.cityName }</option>
	                                </c:forEach>
	                                </select> --%>
                            </div>
                        </div>
                        
                        
                        <div class="L clearfix" id= 'school1'>
                            <label class="label"><span style="color: red">*</span>学校：</label>
                            <div class="label-con">
                                <!-- <input type="checkbox" id="all_schools"/>全选 -->
                               	 <div id="school_table">
                               	 
                               	 	<c:forEach var="school" items="${schools}" varStatus="idx">
		 								<label id="school" data-city="${school.schoolCity }">
			 							<input type="checkbox" value="${school.schoolId }|${school.schoolCity }"/>
			 							<c:out value="${school.schoolName }"/>
			 							</label>
				 					</c:forEach>
                               	 </div>
                            </div>
                        </div>
                        
                        
                        <%-- <div class="L clearfix" id="grade1">
                            <label class="label"><span style="color: red">*</span>年级：</label>
                            <div class="label-con">
                            	<select id="grades">
                                <c:forEach var="grade" items="${grades}">
                                <option value="${grade.gradeNO }">${grade.gradeName }</option>
                                </c:forEach>
                                </select>
                                	<div id="grade_table">
                                	 <label id="all_grades"><input type="checkbox"/>全选</label>
                                	 
                                	 <div id="grades_list">
                                	 	<c:forEach var="grade" items="${grades}" varStatus="idx">
				 							<label><input type="checkbox" 
				 							<c:set var="gradeNO" value=",${grade.gradeNO},"/>
				 							<c:if test='${fn:contains(minisite.grades,gradeNO )}'> 
					 								checked="checked"
					 						</c:if>
				 							id="grade" value="${grade.gradeNO }"/>
				 							<c:out value="${grade.gradeName }"/></label>
				 						</c:forEach>
                                	 </div>
                                	
                                </div>
                            </div>
                        </div> --%>
                        
                        
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>推送时间：</label>
                            <div class="label-con">
                            <input readonly="readonly" class="Wdate" size="25" type="text" id="activeDate" 
                            onClick="WdatePicker({autoPickDate:true,startDate:'%y-%M-%d 09:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d 09:00:00',alwaysUseStartDate:true})">
                            </div>
                        </div>
                        
                         <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>失效时间：</label>
                            <div class="label-con">
                            <input readonly="readonly" class="Wdate" size="25" type="text" id="validDate" 
                            onClick="WdatePicker({autoPickDate:true,startDate:'%y-%M-%d 09:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d 09:00:00',alwaysUseStartDate:true})">
                            </div>
                        </div>
                        	
                        <!--  <div class="L clearfix">
                        	<label class="label"><span style="color: red">*</span>主题类型：</label>
                        	<input type="radio" name="sourceType" id="sourceType" value="0">分享</label>
                        	<input type="radio" name="sourceType" id="sourceType" value="1">家长会</label>
                        </div>-->
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>短信内容：</label>
                            <div class="label-con">
                                <textarea  id="msgDetails" class="txta">${minisite.msgDetails }</textarea>
                                <div>
									<a style="color: #00e" href="javascript:void();" id="showStylePreview">最终样式预览</a>
								</div>
								<div class="style-preview" id="stylePreview"></div>
                            </div>
                        </div>

						<%-- <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>短信内容：</label>
                            <div class="label-con">
                                <textarea  id="msgDetails" class="txta">${minisite.msgDetails }</textarea>
                            </div>
                        </div> --%>

                        <div class="L clearfix">
                            <label class="label">备注：</label>
                            <div class="label-con">
                                <textarea name="" id="remark" class="txta txta-bak">${minisite.remark }</textarea>
                            </div>
                        </div>
                        
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
                    <a id="submit-btn" href="javascript:pushTask(this);"  class="btn-submit">推送至校讯通</a>
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
	
   	var $cityLable = $("#city_table label"),
		$allCityLable = $("#all_citys"),
		$schoolLable = $("#school_table label"),
		$allGrades = $("#all_grades"),
		$gradesList = $("#grades_list label");
		
   	$schoolLable.hide();
   	
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
   	
   	
   	
   	
   	/* $('#all_schools').change(function(){
   		$(':checkbox[id="schoolIds"]').prop("checked", function( i, val ) {
    		  return $('#all_schools').prop('checked');
    	 });
   	}); */
   	/* $('#all_citys').toggle(
	  function () {
		   alert(true);
		  },
		  function () {
		    alert(false);
		  }
		); */
	
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
		taskName=$('#taskName',parent.document).val(),
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
		if(rule!=1 && $("#grade_table input:checked",parent.document).length==0){
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
    	$('input[id="grade"]:checked',parent.document).each(function(){ 
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
				activeDate:$('#activeDate').val(),
				validDate:$('#validDate').val(),
    			msgDetails : $('#msgDetails').val(),
    			remark : $('#remark').val(),
    			taskName:$('#taskName',parent.document).val(),
    			minisiteId:$('#minisiteId').val(),
    			grades:grade,
    			//grades: "," + gradeArray.join() + ",",
    			miniUrl : '${minisite.miniUrl}',
    			citys:city,
    			//citys:"," + cityArray.join() + ",",
    			schoolIds:schoolIds,
    			rule:$("input[name='rule']:checked").val(),
    			subjectType : '${minisite.subjectType}' 
    			//sourceType:$('input[name=sourceType]:checked').val()
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
   		 url: "cmsTask/saveTaskInfo.do",
   		 data: eval(resouce),
   		 dataType: "json",
   		 success: function(obj){
   			 alert(obj.desc);
   			 //window.location.reload();
   			 if(obj.code == '10000'){
   				$("#submit-btn").hide();
   				//$('.btn-submit').attr('disabled','true');
   				//$('.btn-submit').attr('href','javascript:void();');
   			 }
   		 }
   		});  
	}
	
	
	(function() {
		var $stylePreview = $("#stylePreview"),
			$showStylePreview = $("#showStylePreview");
		
		$stylePreview.html("【学校名称】XXX家长，你好！" +
				$('#msgDetails').val() +
				" 手机打开http://t.cn/xxxxxx【XXX老师】");
		
		var _left = $showStylePreview.position().left,
			_top = $showStylePreview.position().top;
		
		var timeOut = 0;
		$showStylePreview.hover(function() {
			$stylePreview.html("【学校名称】XXX家长，你好！" +
					$('#msgDetails').val() +
					" 手机打开http://t.cn/xxxxxx【XXX老师】");
			clearTimeout(timeOut);
			$stylePreview.css({left: _left, top: _top}).show();
		}, function() {
			timeOut = setTimeout(function() {
				$stylePreview.hide();
			}, 500);
		});
		
		$stylePreview.hover(function() {
			clearTimeout(timeOut);
		}, function() {
			timeOut = setTimeout(function() {
				$stylePreview.hide();
			}, 500);
		});
	}());
</script>
</html>