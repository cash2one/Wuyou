<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<link rel="stylesheet" href="css/layout.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/istudy-cms.js"></script>
</head>
<body>
	<div class="page-main">
            <div class="location">
                推荐任务><strong>推送</strong>
            </div>
            <div class="msg-list">
                <table class="list-t">
                    <colgroup>
                        <col class="col-01">
                        <col class="col-02">
                    </colgroup>
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                            <th><div class="td_style">创建时间</div></th>
                        </tr>
                    </thead>
                    <tbody id="data_body">
                    	<c:forEach var="task" items="${paging.result }">
                        <tr>
                            <td>
                                <i class="ico ico-${task.miniType }"></i>
                            </td>
                            <td>
                                <a href="javascript:doTask(${task.id});">${task.taskName_}</a>
                            </td>
                            <td>
                                <div class="td_style">${task.activeDate}</div>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <%@include file="../paging.jsp"%>
        </div>
        <input type="hidden" id="userId" value="${userId }"/>
		<input type="hidden" id="cityId" value="${cityId }"/>
</body>
<script type="text/javascript">
function doTask(id){
	var userId = $("#userId").val(),
	cityId= $("#cityId").val();
	window.location.href=url_head+"xxtTask/showTaskPage.do?taskId="+id+"&userId="+userId+"&cityId="+cityId;
};


$.paging('xxt_task_recommend_list',"xxtTask/getPagingData.do?",{gradeId:'${gradeId }'
	,cityId:'${cityId }'},function(data){
	var result = data.result,
	innerHtml = "",
	task = null,
	currentPage = $('#currentPage'),
	dataBody = $('#data_body');
	for(var i = 0 ;i< result.length;i++){
		task = result[i];
		innerHtml+='<tr><td><i class="ico ico-'+
		task.miniType+'"></i></td><td><a href="javascript:doTask('+
		task.id+');">'+
		task.taskName_+'</a></td><td><div class="td_style">'+
		task.activeDate
		+'</div></td></tr>';
	}
	dataBody.html(innerHtml);
	currentPage.val(data.pageIndex);
});
</script>
</html>