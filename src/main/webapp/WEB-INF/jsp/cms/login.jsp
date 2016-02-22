<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../common.jsp"%>
<html class="full-screen">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>家长无忧后台管理系统</title>
<link rel="stylesheet" href="css/layout.css">
</head>
<body>
    <div id="admin-login-page">
        <div class="admin-login-main">
            <div class="title">家长无忧后台管理系统</div>
            <div class="admin-login-form" >
                <fieldset>
                    <input type="text" id="userName" class="input" tabindex="1" placeholder="用户名">
                    <input type="password" id="password" class="input" tabindex="2" placeholder="密码">
                    <button type="button" class="btn-submit" onclick="login()" tabindex="3">登录</button>
                </fieldset>
            </div>
        </div>
    </div>
</body>
<!-- <div>
		<table>
			<tr><td>用户名:<input id="userName" type="text"/></td></tr>
			<tr><td>密码:<input id="password" type="password"/></td></tr>
			<tr><td><input value="登录" type="button" onclick="login()"/></td></tr>			
		</table>
	</div> -->
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/istudy-cms.js"></script>
<script type="text/javascript">
	$().ready(function(){
		$('input:first').focus();
		$(document).keypress(function(e){
			var key = event.keyCode;
			if(key ==13){
				 $(".btn-submit").click(); 
			}
		});
	});
	 
	 function login(){
		var resouce = {
				userName:$('#userName').val(),
				password : $('#password').val()
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
		$.ajax({
	   		 type: "POST",
	   		 url: "login/login.do",
	   		 data: eval(resouce),
	   		 dataType: "json",
	   		 success: function(obj){
	   			 if(obj.code=="10000"){
	   				var redirectUrl = $('#redirectUrl').val();
	   				if(redirectUrl&&redirectUrl!=""){
	   					location.href=redirectUrl;
	   					return ;
	   				}
	   				window.parent.location.href = "<%=basePath%>cms/main.do";
	   			 }else{
	   				 alert(obj.desc);
	   	  			 window.location.reload();
	   			 }
	   		 }
	   	}); 
	} 
</script>
</html>