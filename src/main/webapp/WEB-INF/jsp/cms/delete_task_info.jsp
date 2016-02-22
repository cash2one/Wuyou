<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/layout.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/istudy-cms.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<title>Insert title here</title>
</head>
<body>
<div class="delete-iframe-content">
	<h1>删除列表</h1>
	<div class="item">
		<h2>推送规则:</h2>
		<p><c:if test="${task.rule == 1 }">城市 + 学校</c:if></p>
		<p><c:if test="${task.rule == 2 }">城市 + 年级</c:if></p>
		<p><c:if test="${task.rule == 3 }">城市 + 学校 + 年级</c:if></p>
	</div>
	<div class="item">
		<h2>未删除消息:</h2>
		<table class="list">
			<thead>
				<tr>
					<th>城市</th>
					<th>学校</th>
					<th>年级</th>
				</tr>
			</thead>
			<tbody id="table">
				<c:forEach var="msgId" items="${msg }">
					<tr>
						<td>
						<c:forEach var="city" items="${citys }">
						<c:if test="${ msgId.cityId == city.cityId }">${ city.cityName }</c:if>
						</c:forEach></td>
						<td>
						<c:forEach var="school" items="${schools }">
						<c:if test="${ msgId.schoolId == school.schoolId }">${ school.schoolName }</c:if>
						</c:forEach>
						</td>
						<td>
						<c:forEach var="grade" items="${grades }">
						<c:if test="${ msgId.grade == grade.gradeNO }">${ grade.gradeName }</c:if>
						</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	
	
	<c:if test="${msg[0].cityId != 'del' && task.sendPublicStatus == 3 }">
		<div id="delPart" class="item">
			<span class="c-red">*</span><label>删除理由：</label>
			<input id="reason" type="text"/>
			<button type="button" onclick="deleteTaskByMsgId(${task.id })">删除</button>
		</div>
	</c:if>
	<c:if test="${task.sendPublicStatus != 3 }">
		<div id="delPart" class="item">
			<label>消息正在推送中，请稍等...</label>
		</div>
	</c:if>
	<c:if test="${msg[0].cityId == 'del' && task.sendPublicStatus == 3 }">
		<div id="delPart" class="item">
			<label>消息已删除</label>
		</div>
	</c:if>
	<button type="button" class="btn-hide" id="btnHide">关闭</button>
</div>
</body>
<script type="text/javascript">
/* $(document).ready(function(){
	if( $msgId == null){
		$('#delPart').hide();
	}
}) */

$("#btnHide").click(function() {
	window.parent.hideDeleteIframe();
});

function deleteTaskByMsgId(id){
	var resouce = {
			id : '${task.id }',
			msgId : '${task.msgId }',
			reason : $('#reason').val()
	};
	if($.isNull(resouce.reason)){
		alert('理由不能为空');
		$('#reason').focus();
		return ;
	} 
	
	if(!confirm("确定删除该条记录吗")){
		return;
	}
	
	$.ajax({
			 type: "POST",
			 url: "cmsTask/deleteCMSTaskByMsgId.do",
			 data: eval(resouce),
			 dataType: "json",
			 success: function(obj){
				 alert(obj.desc);
				 window.location.reload();
				 //window.close();
			 }
			});
}
</script>
</html>