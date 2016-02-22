<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/layout.css">
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/istudy-cms.js"></script>
</head>
<body class="bc-white">
<fieldset class="pos-r">
<div class="L clearfix">
<label class="label">用户名：</label>
<div class="label-con">
<input type="text" id="userName" class="txt-input" size="90" />
</div>
</div>

<div class="L clearfix">
<label class="label">密码：</label>
<div class="label-con">
<input type="password" id="password" class="txt-input" size="90" />
</div>
</div>

<div class="L clearfix">
<label class="label">用户组：</label>
<div class="label-con">
<!--  <input type="text" id="userGroup" class="txt-input" size="90" />-->
<select name="roleName" id="roleName">
<c:forEach var="role" items="${role}">
<option value="${role.id }"><c:out value="${role.roleName }"></c:out></option>
</c:forEach>

</select>
</div>
</div>

<div class="L clearfix">
<label class="label">真实姓名：</label>
<div class="label-con">
<input type="text" id="realName" class="txt-input" size="90" />
</div>
</div>  
<input type="hidden" id="role" value="${role }"/>
<a href="javascript:register()">确定</a>
</fieldset> 
</body>
<script type="text/javascript">
var role = $('#role').val();
$().ready(function(){
	//alert(role);
});

var url_head = '/';

function register(){
	
	 var resouce = {
			userName:$('#userName').val(),
			password: $('#password').val(),
			roleId: $('#roleName').val(),
			realName:$('#realName').val()
			
	};

	if($.isNull(resouce.userName)){
		alert('用户名不能为空');
		$('#userName').focus();
		return ;
	}
	if($.isNull(resouce.password)){
		alert('密码不能为空');
		$('#password').focus();
		return ;
	} 
	if($.isNull(resouce.userName)){
		alert('真实姓名不能为空');
		$('#realName').focus();
		return ;
	}
	$.ajax({
		 type: "POST",
		 url: "cmsmanage/register.do",
		 data: eval(resouce),
		 dataType: "json",
		 success: function(obj){
			 var msg = obj.desc;
			 if(confirm(msg)){
				 location.href = url_head+'cmsmanage/showPaging.do?target=manage_user_list'; 
			 }else{
				 location.reload();
			 }
		 }
	});
	
	
} 
</script>
</html>