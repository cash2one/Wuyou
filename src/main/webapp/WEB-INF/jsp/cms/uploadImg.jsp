<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>上传</title>
</head>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<body>
	<iframe name="smz" width="0" height="0" frameborder="0"
		style="display: none;"></iframe>
	<!-- <font color="red"><s:property value="#request.errorMessage" /></font> -->
	
	<form onsubmit="return Submit()" id="submit_form" action="imgUpload.do" method="post" enctype="multipart/form-data"
		name="UploadPhoto" target="smz">
		<input type="file" name="file" id="file" class="button"> 
		<input
			type="hidden" name="type" id="type" value=".jpg"> 
		<input
			  type="submit" name="submit" value="上传"
			class="button">
	</form>
	
	<input type="hidden" name="pagePath" id="_page_path"
		value="${saveTaget }" />
	<script type="text/javascript">
		var tp ="jpeg,jpg,gif,bmp,png";
		var _page_path = '${saveTaget }';
		if (_page_path) {
			if (parent.window.opener != undefined) {
				parent.window.opener.returnValue = _page_path;
			}else {
				parent.window.returnValue = _page_path;
			}
			parent.close();
		}
		function Submit() {
			var file = document.getElementById('file').value;
			
			if(file==null||file==""){
				alert("请选择上传图片");
				return false;
			}else{
				var strs=file.split(".");
				var last = strs[strs.length-1];
				var rs=tp.indexOf(last.toLowerCase());
				if(rs<0){
					alert("请选择图片类型，如["+tp+"]");
					return false;
				}
			}
			document.getElementById('type').value = file;
			//document.getElementById('submit_form').submit();
		}
		
	</script>
</body>
</html>