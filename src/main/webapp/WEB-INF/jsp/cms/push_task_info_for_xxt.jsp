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

<script src="js/jquery.Jcrop.js"></script>
<script src="js/jquery.color.js"></script>
<link rel="stylesheet" href="css/jquery.Jcrop.css" type="text/css" />
</head>
<body class="bc-white">
<div class="cms-container">
            <div class="cms-main">
                <div class="form-item push-step-item">
                        <div class="L clearfix">
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
                        
                        <%-- <div class="L clearfix">
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
                        </div> --%>
                        
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>推送时间：</label>
                            <div class="label-con">
                            <input readonly="readonly" class="Wdate" size="25" type="text" id="activeDate" 
                            onClick="WdatePicker({autoPickDate:true,startDate:'%y-%M-%d 09:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d 09:00:00',alwaysUseStartDate:true})">
                            </div>
                        </div>
                        
                        <%-- <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>任务标题：</label>
                            <div class="label-con">
                                <input type="text" id="taskName" class="txt-input" value="${minisite.taskName}" size="90" />
                            </div>
                            <label class="label">类型：</label>
                            <div class="label-con">
                                <div class="con-strong">${minisite.typeName }</div>
                            </div>
                        </div> --%>
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>公共账号缩略图：</label>
                            <div class="label-con">
                            	<form id="subimg_form" name="subimg_form" 
                            		action="${basePath }/fileupload/xxt/subimgUpload.do" method="post"
                            		enctype="multipart/form-data" target="hiddenFrame">
                                 <input name="file" type="file" id="file_cp" class="button">
                                 <input type="button" id="btn_ensure" class="button model_btn dis-no" value="确认区域选择">
                                 <input type="button" id="btn_cancel" class="button model_btn dis-no" value="取消">
                                 <input type="hidden" name="x1" id="x1"/>
							     <input type="hidden" name="y1" id="y1"/>
							     <input type="hidden" name="x2" id="x2"/>
							     <input type="hidden" name="y2" id="y2"/>
							     <input type="hidden" name="width" id="w"/>
							     <input type="hidden" name="height" id="h"/>
							     <input type="hidden" id="scaleRatio"/>
							    </form>
                                <div id="img_preview_div" class="ma-top-5">
                                	<img id="img_preview" alt="" src="" class="dis-no">
                                	<!-- <div id="img_preview_ie" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);width: 1px;height: 1px;"></div> -->
                                </div>
                                <input type="hidden" id="subimg_url" >
                                <div id="result_preview_div" class="dis-no">
                                	<br>
                                	<img id="result_preview" alt="" src="">
                                </div>
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
                    <a id="submit-btn" href="javascript:pushTask(this);" class="btn-submit-app">推送至校讯通APP公共账号</a>
                    <span style="margin:15px 15px 0 350px;color: red" id="error_msg" ></span>
                    </div>
                    
                </div>
            </div>
        </div>
        <input type="hidden" id="minisiteId" value="${minisite.id }">
        <iframe frameborder="0" id="hiddenFrame" name="hiddenFrame" src="" width="0" height="0" ></iframe>
        <div id="tmp" style="width: 1px;height: 1px;"></div>
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
		
		$("#file_cp").change(function(){
			var files = this.files;
			if(files){
				var first = files[0];
				if(first){
					showImagePreview(first);
				}
			}else{
				var path = getRealPath(this);
			    if(_isIE && path && validateImageType({"name":path}) != false){
			    	cleanImage();
			    	var img = $('#img_preview_ie');
			    	if(img.length != 0){
			    		img.remove();
			    	}
			    	img = $('<div id="img_preview_ie" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);"></div>').appendTo($("#img_preview_div"));
			    	if(ieImageSizeCache[path]){
			    		img.css("width",ieImageSizeCache[path].w);
				    	img.css("height",ieImageSizeCache[path].h);
			    	}else{
			    		img.css("width","800");
				    	img.css("height","800");
			    	}
			    	
			    	img.css("display","block");
			    	
			    	img[0].filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = path;
			    	
			    	setTimeout(function(){
			    		resizeImage(img);
			    		initJcropTool(img[0]);
			    		ieImageSizeCache[path] = {"w":img.width(),"h":img.height()};
		    			$(".model_btn").show();
			    	},100);
			    }
			}
		});
			
		$("#img_preview").load(function(){
			resizeImage($(this));
			initJcropTool(this);
			$(".model_btn").show();
		});
		
		$("#btn_cancel").click(function(){
			cleanFileAndImage();
		});
		
		$("#btn_ensure").click(function(){
			subimg_form.submit();
			cleanImage();
			var width = $('#w').val();
			var height = $('#h').val();
			var img = $("#img_preview");
			img.css("width",width);
	    	img.css("height",height);
		});
		
		$("#hiddenFrame").load(function(){
			var subimgName = $(this).contents().text();
			if(subimgName){
				var subimgUrl = "${basePath }/${xxtImgRelativePath }" + subimgName;
				cleanImage();
				$("#result_preview").attr("src",subimgUrl);
				$("#result_preview_div").show();
				$("#subimg_url").val(subimgName);
			}
		});
		
    });
    
	function validation(){
		var activeDate=$('#activeDate').val(),
		taskName=$('#taskName',parent.document).val();
		newsThumbImg=$("#subimg_url").val();
		
		//校验城市和年级不能为空
		if($("#city_table input:checked").length==0){
			return "城市不能为空";		
		}
		if($("#grade_table input:checked",parent.document).length==0){
			return "年级不能为空";		
		}
		//$("#grade_table input:checked");
		if($.isNull(activeDate)){
			return "推送时间不能为空";
		}
		if($.isNull(newsThumbImg)){
			return "请上传公共账号缩略图";
		}
		if($.isNull(taskName)){
    		return "任务标题不能为空";
    	}
    	if($.charLength(taskName)>255){
    		return "任务标题长度不能超过255位，汉字占3位";
    	}
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
    			taskName:$('#taskName',parent.document).val(),
    			minisiteId:$('#minisiteId').val(),
    			grades:grade,
    			newsThumbImg: $("#subimg_url").val(),
    			miniUrl : '${minisite.miniUrl}',
    			citys:city
    	};
		var msg = validation();
		error_msg.html(msg);
		if(msg){
			return ;
		}
		
		$.ajax({
   		 type: "POST",
   		 url: "cmsTask/saveTaskInfoForXXT.do",
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
	
	function showImagePreview(file){
		if(!file){
			return;
		}
		if(validateImageType(file) == false){
			return false;
		}
		var size = file.size;
		if(size > 5 * 1024 * 1024){
			cleanFileAndImage();
			alert("图片大小不得大于5M！");
			return false;
		}
		appendImage(file); 
	};
	
	function validateImageType(file){
		var filename = file.name;
		var type = file.type;
		if(!type){
			var pIdx = filename.lastIndexOf(".");
			pIdx = (pIdx == -1) ? 0 : pIdx;
			type = "image/" + filename.substring(pIdx + 1,filename.length);
		}
		type = type.toUpperCase();
		if(type != "IMAGE/PNG" && type != "IMAGE/JPG" && type != "IMAGE/JPEG" && type != "IMAGE/BMP" && type != "IMAGE/GIF"){
			alert("仅支持png,jpg,jpeg,bmp,gif格式图片！");
			cleanFileAndImage();
			return false;
		}
	}
	
	function appendImage(file){
		var img = $("#img_preview");
		var reader = new FileReader(); 
	    reader.readAsDataURL(file);
	    reader.onload = function(e){ 
	    	cleanImage();
	    	img.attr("src", this.result);
	    	img.show();
	    };
	};
	
	var jcrop_api;
	function initJcropTool(img){
		var $img = $(img);
		var width = $img.width();
		var heigth = $img.height();
		
		var selectInitX1 = width * 0.2 / 2;
		var selectInitY1 = heigth * 0.2 / 2;
		var selectInitX2 = selectInitX1 + width * 0.8;
		var selectInitY2 = selectInitY1 + heigth * 0.8;
		jcrop_api = $.Jcrop("#" + $img.attr("id"), { onChange: setCoords, onSelect: setCoords });
        jcrop_api.setSelect([selectInitX1, selectInitY1, selectInitX2, selectInitY2]);
        jcrop_api.setOptions({ allowSelect: true, allowMove: true, allowResize: true, aspectRatio: 0 , minSize: [100,100]});
	};
	
	function setCoords(c)
	{
		var scaleRatio = $("#scaleRatio").val() || 1;
		$('#x1').val(Math.round(c.x * scaleRatio));
		$('#y1').val(Math.round(c.y * scaleRatio));
		$('#x2').val(Math.round(c.x2 * scaleRatio));
		$('#y2').val(Math.round(c.y2 * scaleRatio));
		$('#w').val(Math.round(c.w * scaleRatio));
		$('#h').val(Math.round(c.h * scaleRatio));
	};
	
	function cleanFileAndImage(){
		cleanImage();
		subimg_form.reset();
	}
	
	function cleanImage(){
		if(jcrop_api){
			jcrop_api.destroy();
		}
		var img = $("#img_preview");
		img.attr("src","");
		img.css("width","auto");
    	img.css("height","auto");
    	img.hide();
    	
    	var img_ie = $("#img_preview_ie");
    	img_ie.remove();
    	
    	$("#result_preview").attr("src","");
    	$("#subimg_url").val("");
    	$("#result_preview_div").hide();
    	
    	$(".model_btn").hide();
	}
	
	function resizeImage($img){
		var owidth = $img.width();
		var oheight = $img.height();
		$("#scaleRatio").val(1);
		
		//当长或宽大于800的时候调整图片显示大小
		if(owidth > 800 || oheight > 800){
			var nwidth, nheight;
			var rate = owidth / oheight;
			if(rate > 1){
				nwidth = 800;
				nheight = nwidth / rate;
				$("#scaleRatio").val(owidth / nwidth);
			}else{
				nheight = 800;
				nwidth = nheight * rate;
				$("#scaleRatio").val(oheight / nheight);
			}
			
			if(_isIE){
				$img[0].filters.item("DXImageTransform.Microsoft.AlphaImageLoader").sizingMethod = "scale";
			}
			
			$img.width(nwidth);
			$img.height(nheight);
		}
	}
	
	function getRealPath(obj) {
         if (obj) {
             //ie
             if (_isIE) {
                 obj.select();
                 $("#tmp")[0].focus();
                 // IE下取得图片的本地路径
                 var path = obj.value;
                 try{
                	 path = document.selection.createRange().text;
                 }catch(e){
                	 
                 }
                 return path;
             }
             //firefox
             else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
                 if (obj.files) {
                     // Firefox下取得的是图片的数据
                     return obj.files.item(0).getAsDataURL();
                 }
                 return obj.value;
             }
             return obj.value;
         }
   };
</script>
</html>