<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="xxt_common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta  charset="utf-8">
<title>study</title>
<link rel="stylesheet" href="css/layout.css">
<style>
html, body{overflow-y:hidden;}
html, body, #page{height:100%;}
td{vertical-align:top;}
</style>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
</head>
<body class="bc-white">
    <div id="page" class="pos-r">
        <div class="page-header">
            <div class="h-inside clearfix">
                <h1>家长无忧</h1>
                <div class="tab-nav">
                    <a target="main_frame" href="<%=CMSConstants.DOMAIN_NAME%>xxtTask/showPaging.do?target=xxt_task_for_pc_list&userId=${userId}&cityId=${cityId}&grades=${grades}&schoolId=${schoolId}" class="cur">推荐任务</a>
                    <a target="main_frame" href="<%=CMSConstants.DOMAIN_NAME%>xxtTask/showPaging.do?target=xxt_task_his_list&userId=${userId }">发送记录</a>
                </div>
            </div>
        </div>
       	<iframe id="main_frame" name="main_frame" scrolling="auto" width="100%" height="100%" 
		        	frameborder="0" marginwidth="0px" marginheight="0px" src="<%=CMSConstants.DOMAIN_NAME%>xxtTask/showPaging.do?target=xxt_task_for_pc_list&userId=${userId}&cityId=${cityId}&grades=${grades}&schoolId=${schoolId}"></iframe>
    </div>
</body>
<script type="text/javascript">
	(function() {
		var frame = document.getElementById("main_frame");
		
		frame.style.height = document.documentElement.clientHeight - 60 + "px";
		
		window.onresize = function() {
			frame.style.height = document.documentElement.clientHeight - 60 + "px";
		}
	}());
	function redirect(url){
		$('#main_frame').attr('src',url);
	}
	$().ready(function(){
		var currentClass = "cur";
		$('.tab-nav a').click(function(){
			$(this).addClass(currentClass);
			$(this).siblings('.'+currentClass).removeClass(currentClass);
		});
	})
</script>
</html>