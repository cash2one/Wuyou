<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<link rel="stylesheet" href="<%=basePath%>css/layout.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/istudy-cms.js"></script>
</head>
<body>
        <div class="page-main">
            <div class="location">
                推荐任务><strong>发送记录</strong>
            </div>
            <div class="msg-list">
                <table class="list-t">
                    <colgroup>
                        <col class="col-01"><col class="col-02"><col class="col-03"><col>
                    </colgroup>
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                            <th><div class="td_style">发送状态</div></th>
                            <th><div class="td_style">创建时间</div></th>
                            <th><div class="td_style">发送时间</div></th>
                            <th><div class="td_style">发送人数</div></th>
                        </tr>
                    </thead>
                    <tbody id="data_body">
                    <c:forEach var="task" items="${paging.result }">
                        <tr>
                            <td>
                                <i class="ico ico-${task.miniType}"></i>
                            </td>
                            <td>
                                <a href="javascript: showTask(${task.id});">${task.taskName_ }</a>
                            </td>
                            <td><div class="td_style">${task.sendStatusInfo }</div></td>
                            <td><div class="td_style">${task.createDate }</div></td>
                            <td><div class="td_style">${task.sendTime }</div></td>
                            <td>
                                <div class="td_style">${task.amountUsers }</div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <%@include file="../paging.jsp"%>
</body>
<script type="text/javascript">
$.paging('xxt_task_his_list',"<%=basePath%>xxtTask/getPagingData.do?",{userId:'${userId}'},function(data){
	var result = data.result,
	innerHtml = "",
	task = null,
	currentPage = $('#currentPage'),
	dataBody = $('#data_body');
	for(var i = 0 ;i< result.length;i++){
		task = result[i];
		innerHtml+='<tr><td><i class="ico ico-'+
		task.miniType+'"></i></td><td><a href="javascript:showTask('+
		task.id+');">'+
		task.taskName_+'</a></td><td><div class="td_style">'+
		task.sendStatusInfo+'</div></td><td><div class="td_style">'+
		task.createDate+'</div></td><td><div class="td_style">'+
		MyString.toEmpty(task.sendTime)+'</div></td><td><div class="td_style">'+
		MyString.toEmpty(task.amountUsers)+'</div></td></tr>';
	}
	dataBody.html(innerHtml);
	currentPage.val(data.pageIndex);
});

function showTask(id){
	location.href="<%=basePath%>xxtTask/showHisTaskPage.do?id="+id;
}
</script>
</html>