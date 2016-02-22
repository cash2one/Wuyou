<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="xxt_common.jsp"%>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主题推荐</title>
<%-- <link rel="stylesheet" href="<%=basePath%>css/common.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/istudy-cms.js"></script> --%>
<style type="text/css">
html,body,dl,dd{font-size: 12px;padding: 0; margin: 0;}
.work_list_1{ overflow:hidden; padding:0; max-width: 500px;}
.work_list_1 .btns{text-align: right;padding: 2px 10px 5px 0;}
.work_list_1 dt{ width:400px; height:28px; line-height:28px; padding:0; margin:0; float:left; overflow:hidden; white-space:nowrap; text-overflow:ellipsis;}
.work_list_1 a{ color:#333;text-decoration: none;}
.work_list_1 a:hover{ color:#C00;text-decoration: underline;}
.work_list_1 dt b{ color:#c60;}
.work_list_1 dt span{ color:#999; margin:0 0 0 10px;}
.work_list_1 dd{ width:80px; height:28px; line-height:28px; float:right; text-align:center; color:#390;}
</style>
</head>
<body>
<c:choose>
<c:when test="${empty tasks}">
<div style="margin: 5px;">暂未有推荐主题！
	<c:if test="${empty teacher }">
	<span style="display: none;">${msg }</span>
	</c:if>
</div>
</c:when>
<c:otherwise>
<div>
	<dl class="work_list_1">
	<div class="btns">
		<a target="_blank" href="<%=CMSConstants.DOMAIN_NAME%>xxtTask/task4pcMore.do?userId=${teacher.userId }&cityId=${teacher.cityId }&grades=${teacher.gradesAsString}&schoolId=${teacher.schoolId}">查看更多</a>
		<c:if test="${isManager }">
		&nbsp;
		<a target="_blank" href="http://manage.istudy.com.cn">校园+管理</a>
		</c:if>
	</div>
	<c:forEach var="task" items="${tasks }">
	<dt title="${task.miniTitle }">
	<b>【${task.subjectType == '1' ? '三分钟家长会' : task.shareType }】</b>
	<a href="${ctx }/xxtTask/showTaskPage.do?taskId=${task.id }&userId=${teacher.userId }&cityId=${teacher.cityId }&schoolId=${teacher.schoolId }" target="_blank">${task.miniTitle }</a>
	</dt>
	<dd>
	<fmt:parseDate var="date" value="${task.activeDate }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
	<fmt:formatDate value="${date }" pattern="yyyy-MM-dd"/>
	</dd>
	</c:forEach>
	</dl>
</div>
</c:otherwise>
</c:choose>
</body>
</html>