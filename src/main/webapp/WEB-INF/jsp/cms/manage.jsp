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
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
</head>
<body class="bc-white">
		<div class="location">
               <strong>权限管理</strong>
        </div>
	
<a href="javascript:redirect('cmsmanage/showRegisterPage.do')">新增账号</a><br><a href="javascript:redirect('cmsmanage/showPaging.do?target=manage_user_list')">用户列表</a><br><a href="javascript:">新增角色</a> <br><a href="javascript:">角色列表</a><br>
<hr>
<iframe id="main_frame" scrolling="auto" height="1200" width="100%"
frameborder="0" marginwidth="0px" marginheight="0px" src="<%=basePath%>cmsmanage/showPaging.do?target=manage_user_list"></iframe>
      
</body>
<script type="text/javascript">
	function redirect(url){
		$('#main_frame').attr('src','<%=basePath%>'+url);
	}
</script>
</html>