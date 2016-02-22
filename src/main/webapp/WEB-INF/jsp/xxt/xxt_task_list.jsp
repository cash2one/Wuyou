<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="xxt_common.jsp"%>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务列表</title>

<link rel="stylesheet" href="<%=basePath%>css/common.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/istudy-cms.js"></script>
</head>
<body>
 <div style="width: 50em">
		<c:forEach var="task" items="${tasks }">
			<ul>
				<li class="li1" onclick="doTask(${task.id})" style="cursor: pointer"><c:out value="${task.taskName_}" /></li>
			</ul>
			<ul >
				<li class="li1" style="background-image: url('img/u27_line.png');"></li>
			</ul>
		</c:forEach>
	</div>
	<div>
		<a target="_blank" href="<%=CMSConstants.DOMAIN_NAME%>xxt/main.do?target=xxt_task_recommend_list&userId=${userId }&cityId=${cityId }&teacherRole=${teacherRole}&gradeId=${gradeId}">查看更多</a>
	</div>
	<input type="hidden" id="userId" value="${userId }"/>
	<input type="hidden" id="cityId" value="${cityId }"/>
</body>

<script type="text/javascript">
	function doTask(id){
		var userId = $("#userId").val(),
		cityId= $("#cityId").val();
		window.open('<%=basePath%>xxtTask/showTaskPage.do?taskId='+id+'&userId='+userId+'&cityId='+cityId);
	};
</script>
</html>