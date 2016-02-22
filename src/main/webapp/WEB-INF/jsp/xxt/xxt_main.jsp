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
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
</head>
<body class="bc-white">
    <div id="page" class="pos-r">
        <div class="page-header">
            <div class="h-inside clearfix">
                <h1>家长无忧</h1>
                <div class="tab-nav">
                    <a href="javascript:redirect('<%=CMSConstants.DOMAIN_NAME%>xxtTask/showPaging.do?target=xxt_task_recommend_list&userId=${userId}&cityId=${cityId}&teacherRole=${teacherRole}&gradeId=${gradeId}');" class="cur">推荐任务</a>
                    <a href="javascript:redirect('<%=CMSConstants.DOMAIN_NAME%>xxtTask/showPaging.do?target=xxt_task_his_list&userId=${userId }');">发送记录</a>
                </div>
            </div>
        </div>
        <div class="cms-container" style="height: 100%;">
        	<iframe id="main_frame" scrolling="auto" width="100%" height="100%" 
        	frameborder="0" marginwidth="0px" marginheight="0px" src="<%=CMSConstants.DOMAIN_NAME%>xxtTask/showPaging.do?target=xxt_task_recommend_list&userId=${userId }&cityId=${cityId }&teacherRole=${teacherRole}&gradeId=${gradeId}"></iframe>
        </div>
    </div>
</body>
<script type="text/javascript">
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