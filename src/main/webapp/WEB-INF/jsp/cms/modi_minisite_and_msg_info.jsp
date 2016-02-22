<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑资源</title>
<link rel="stylesheet" href="css/layout.css?v0.01">
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="js/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="js/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="js/istudy-cms.js"></script>
</head>
<body class="bc-white">
    <div id="page" class="pos-r">
        <div class="cms-container">
            <div class="location">
                资源库><strong>添加/编辑资源</strong>
            </div>
            <div class="cms-main clearfix edit-cms-main">
                <form id="resource_div" class="form-item edit-cms-item">
                    <fieldset class="sms-edit">
                        <h2>短信编辑</h2>
                        <div class="L clearfix">
                            <label class="label">类型：</label>
                            <div class="label-con type-opts">
                            	<%-- <label>
                                <input type="radio" name="editType" 
                                 <c:if test="${minisite.type==0 }"> 
                                 checked="checked" 
                                 </c:if>
                                 id="text" value="0"/>纯文本
                                 </label> --%>
                                <label>
								<input type="radio"
								<c:if test="${minisite.type==1 }"> 
                                 checked="checked" 
                                 </c:if>
                                  name="editType" id="imgText" value="1"/>图文
                                </label>
                                <label>
								<input type="radio"
								<c:if test="${minisite.type==2 }"> 
                                 checked="checked" 
                                 </c:if>
                                  name="editType" id="vidio" value="2"/>视频
                                </label>
                            </div>
                        </div>
                        
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>任务标题：</label>
                            <div class="label-con">
                               <input type="text" name="taskName" id="taskName" value="${minisite.taskName }" class="txt-input" size="90" />
                            </div>
                        </div>
                        
                        
                        <div class="L clearfix">
                        	<label class="label"><span style="color: red">*</span>主题类型：</label>
                        	<label><input type="radio" name="subjectType" <c:if test="${minisite.subjectType==1 }"> 
                                 checked="checked" 
                                 </c:if>id="subjectType" value="1">家长会</label>
                        	<label><input type="radio" name="subjectType" <c:if test="${minisite.subjectType==0 }">
                        	 checked="checked"
                                 </c:if> id="subjectType" value="0">分享</label>   	
                        	<select id="shareType" >
                        	<option value=""></option>
                        	<option value="教学热点" 
                        	<c:if test="${minisite.shareType=='教学热点' }">
                        	 selected="selected"
                                 </c:if> 
                             >教学热点</option>
                        	<option value="学习方法" 
                        	<c:if test="${minisite.shareType=='学习方法' }">
                        	 selected="selected"
                                 </c:if> 
                            >学习方法</option>
                        	<option value="政策解读" 
                        	<c:if test="${minisite.shareType=='政策解读' }">
                        	 selected="selected"
                                 </c:if>
                             >政策解读</option>
                        	<option value="心灵鸡汤" 
                        	<c:if test="${minisite.shareType=='心灵鸡汤' }">
                        	 selected="selected"
                                 </c:if>
                            >心灵鸡汤</option>
                        	<option value="生活指导" 
                        	<c:if test="${minisite.shareType=='生活指导' }">
                        	 selected="selected"
                                 </c:if>
                            >生活指导</option>
                        	<option value="测评工具" 
                        	<c:if test="${minisite.shareType=='测评工具' }">
                        	 selected="selected"
                                 </c:if>
                            >测评工具</option>
                        	<option value="家长课堂" 
                        	<c:if test="${minisite.shareType=='家长课堂' }">
                        	 selected="selected"
                                 </c:if>
                            >家长课堂</option>
                        	</select>
                        </div>
                        
                            <div class="L clearfix">
                            <label class="label">短信内容：</label>
                            <div class="label-con">
                                <textarea  id="msgDetails" class="txta">${minisite.msgDetails }</textarea>
                            </div>
                        </div>
                        
                    </fieldset>

                    <div  class="edit-type-item">
                        <fieldset>
                        	<div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>页眉：</label>
                            <div class="label-con">
                               <input type="text" name="headerName" id="headerName" class="txt-input" size="90" value="${minisite.headerName }" />
                            </div>
                       		</div>
                       		
                       		
                            <div  id="tile_div" style="display: none;" class="L clearfix">
                                <label class="label"><span style="color: red">*</span><span id="tile_span">标题：</span></label>
                                <div class="label-con">
                                    <input type="text" id="articleName" value="${minisite.title }" class="txt-input">
                                </div>
                            </div>

                            <div id="details_div" style="display: none;" class="L clearfix">
                                <label id="details_attr" class="label">视频介绍：</label>
                                <div class="label-con">
                                    <script id="details" type="text/plain" style="width:548px;height:300px;">${minisite.details } </script>
                                </div>
                            </div>

							<div id="vidio_div" style="display: none;" class="L clearfix">
                                <label class="label"><span style="color: red">*</span>视频代码：</label>
                                <div class="label-con">
                                    <input type="text" id="videoUrl" value="${fn:escapeXml(minisite.videoUrl)}" class="txt-input" style="width: 540px;">
                                </div>
                            </div>
                            
                            
                            <div id="shortDetails_div" class="L clearfix">
                                <label id="shortDetails_attr" class="label"><span style="color: red">*</span>文章摘要：</label>
                                <div class="label-con">
                                    <script id="shortDetails" type="text/plain" style="width:548px;height:150px;">${minisite.shortDetails }</script>
                                </div>
                            </div>
                            
                        </fieldset>    
                    </div>
                    <a href="javascript:saveMinisiteAndMsg(this);" id="save_form_data" class="btn-submit">保存</a>
                    <span style="color: red;" id="error_msg" ></span>
                    <br><br><br>
                </form>
				<c:set var="gradeNO" value=",${grade.gradeNO},"/>
                <div class="edit-sidebar">
                    <dl>
                        <dt>适应年级</dt>
                        <dd>
                            <table class="push-time-opts">
                            	<c:forEach var="grade" items="${grades}" varStatus="idx">
			 						<c:if test="${idx.index%3==0}">
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
			 						<c:if test="${idx.index%3==2||(idx.index+1)==fn:length(grades)}">
			 							</tr>
			 						</c:if>
				 				</c:forEach>
                            </table>
                        </dd>
                    </dl>
                    <dl>
                        <dt>适用推送时间</dt>
                        <dd>
                            <table class="push-time-opts">
                            	<c:forEach var="month" items="${months}" varStatus="idx">
			 						<c:if test="${idx.index%3==0}">
			 							<tr>
			 						</c:if>
			 							<td>
				 							<input type="checkbox" 
				 							<c:set var="monthId" value=",${month.monthId},"/>
				 							<c:set var="suggestMonth" value=",${minisite.suggestMonth},"/>
					 							<c:if test='${fn:contains(suggestMonth,monthId)}'> 
						 								checked="checked"
						 						</c:if>
				 							id="suggestMonth" value="${month.monthId }"/>
				 							<c:out value="${month.monthName }"/>
			 							</td>
			 						<c:if test="${idx.index%3==2||(idx.index+1)==fn:length(months)}">
			 							</tr>
			 						</c:if>
				 				</c:forEach>
                            
                            </table>
                        </dd>
                    </dl>
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" id="miniUrl" value="${minisite.miniUrl }"/>
    <input type="hidden" id="miniId" value="${minisite.id }"/>
</body>
</html>

<script type="text/javascript">  
var ue = UE.getEditor("details",{maximumWords:5000});
var ue2 = UE.getEditor("shortDetails",{maximumWords:5000});

$().ready(function(){
	var st = "${minisite.subjectType }";
	var $shortDetails_div = $("#shortDetails_div"),
	$shareType = $("#shareType");
	
	if(st == '0'){
		$shortDetails_div.hide();
		$shareType.show();
	}else if(st == '1'){
		$shareType.hide();
	}
	
	
	$('input[name=editType]').click(function(){
		var item = $('input[name=editType]:checked').val();
		if(item=='0'){
			ue.setContent('');
			ue2.setContent('');
			$shortDetails_div.hide();
		}
	});
	
	
	 $('input[name=subjectType]').click(function() {
		 if($(this).val() === "0") {
			 $shortDetails_div.hide();
			 $shareType.show();
		 } else {
			 $shortDetails_div.show();
			 $shareType.hide();
		 }
	 })
});

	
	
  /* var ckDetails = CKEDITOR.replace('details',addUploadButton(this));  
        function addUploadButton(editor){  
           CKEDITOR.on('dialogDefinition', function( ev ){  
               var dialogName = ev.data.name;  
               var dialogDefinition = ev.data.definition;  
               if ( dialogName == 'image' ){  
                   var infoTab = dialogDefinition.getContents( 'info' );  
                   infoTab.add({  
                       type : 'button',  
                       id : 'upload_image',  
                       align : 'center',  
                       label : '上传图片',  
                       onClick : function( evt ){  
                           var thisDialog = this.getDialog();  
                           var txtUrlObj = thisDialog.getContentElement('info', 'txtUrl');  
                           var txtUrlId = txtUrlObj.getInputElement().$.id;  
                           addUploadImage(txtUrlId);  
                       }  
                   }, 'browse'); //place front of the browser button  
               }  
           });  
       }   */
	    
        function addUploadImage(theURLElementId){  
            var uploadUrl = "<%=basePath%>fileupload/imgUploadPage.do"; //这是我自己的处理文件/图片上传的页面URL  
			var imgUrl = window.showModalDialog(uploadUrl, null,
					"dialogWidth:360px;dialogHeight:120px;help:no;status:no");
            
            if(imgUrl == undefined){
            	imgUrl = window.returnValue;
            }
			var urlObj = $("#" + theURLElementId);
			if(imgUrl){
				urlObj.val(imgUrl);
				urlObj.change(); //触发url文本框的onchange事件，以便预览图片
			}
		}
        
        function validation(){
        	var  type = parseInt($('input[name=editType]:checked').val()),
        			taskName = $('#taskName').val(),
        			msgDetails = $('#msgDetails').val(),
        			//remark = $('#remark').val(),
        			headerName = $('#headerName').val(),
        			title = $('#articleName').val(),
        			details =ue.getContent(),
        			shortDetails =ue2.getContent(),
        			videoUrl = $('#videoUrl').val(),
        			subjectType = $('input[name=subjectType]:checked').val(),
        			shareType = $('#shareType').val();
        	if($.isNull(taskName)){
        		return "任务标题不能为空";
        	}
        	if($.charLength(taskName)>255){
        		return "任务标题长度不能超过255位，汉字占3位";
        	} 
        	 if(msgDetails.length>200){
        		return "短信内容字数不能超过200个";
        	}
        	 if($.isNull(subjectType)){
      			return "主题类型不能为空";
      		}
        	 if($.isNull(headerName)){
         		return "页眉不能为空";
         	}
        	 if($.charLength(headerName)>60){
         		return "页眉不能超过20个字";
         	}
        	 /*
        	if($.charLength(remark)>255){
        		return "备注长度不能超过255位，汉字占3位";
        	} */
        	if(type>0){
        		var label = type == 2 ? "视频" : "图文";
        		if($.isNull(title)){
            		return label + "标题不能为空";
            	}
        		if($.charLength(title)>255){
        			return label + "标题长度不能超过255位，汉字占3位";
        		}
        		
        		var reg=new RegExp('&nbsp;',"g");
        		var detailsStr = details.substring(details.indexOf('>')+1,details.lastIndexOf('<')).replace(reg,'');
        		if(details=='<p><br></p>'||details=='<br>'||MyString.delSpecialStr(detailsStr)==''){
            		return "文章内容不能为空";
            	}
        		if(subjectType=='1'){
        			var detailsStr1 = shortDetails.substring(shortDetails.indexOf('>')+1,shortDetails.lastIndexOf('<')).replace(reg,'');
        			if(shortDetails=='<p><br></p>'||shortDetails=='<br>'||MyString.delSpecialStr(detailsStr1)==''){
                		return "家长会摘要内容不能为空";
                	}
        		}
        		if(subjectType=='0'){
        			if(shareType==''){
        				return "请选择分享类型";
        			}
        		}
        		if(type==2){
        			if($.isNull(videoUrl)){
                		return "视频代码不能为空";
                	}
        			if($.charLength(videoUrl)>2550){
            			return "视频代码长度不能超过2550位，汉字占3位";
            		}
        		}
        	}
        	return null;
        }
        
        function saveMinisiteAndMsg(obj){
        	
        	var suggestMonths = "";
        	$('input[id="suggestMonth"]:checked').each(function(){ 
        		suggestMonths+=($(this).val()+",");   
       		}); 
        	 if(suggestMonths.length>0){
        		suggestMonths= suggestMonths.substring(0, suggestMonths.length-1)
        	} 
        	
        	var grade = "";
        	$('input[id="grade"]:checked').each(function(){ 
         		grade+=($(this).val()+",");   
        	});
        	if(grade.length>0){
        		grade=","+grade;
        	}
        	var resouce = {
        			type : $('input[name=editType]:checked').val(),
        			taskName : $('#taskName').val(),
        			msgDetails : $('#msgDetails').val(),
        			//remark : $('#remark').val(),
        			title : $('#articleName').val(),
        			details : ue.getContent(),
        			shortDetails : ue2.getContent(),
        			videoUrl : $('#videoUrl').val(),
        			headerName:$('#headerName').val(),
        			grades : grade,
        			miniUrl : $('#miniUrl').val(),
        			id : $('#miniId').val(),
        			suggestMonth:suggestMonths,
        			subjectType:$('input[name=subjectType]:checked').val(),
        			shareType:$('#shareType:visible').val()
        	};
        	//alert(1);
        	var msg = validation();
        	 if(msg){
        			alert(msg);
        			return ;
        	} 
        	
        	$(obj).attr("disabled","disabled");
        	$.ajax({
        		 type: "POST",
        		 url: "minisite/modiMinisiteInfo.do",
        		 data: eval(resouce),
        		 dataType: "json",
        		 success: function(obj){
        			 alert(obj.desc);
        			 location.href = url_head+'minisite/showPaging.do?target=minisite_list&subjectType=-1&grade=0&month=0';
        		 }
        	});   
        	
        }
</script>
