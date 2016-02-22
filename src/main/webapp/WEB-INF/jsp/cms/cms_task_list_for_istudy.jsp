<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CMS后台校讯通APP公共账号任务列表</title>

<link rel="stylesheet" href="css/layout.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/istudy-cms.js"></script>
</head>

<body class="bc-white">
    <div id="page" class="pos-r">
        <div class="cms-container">
	        <div class="location">
	               <strong>任务列表</strong>
	        </div>
            <div class="cms-main">

                <div class="msg-list cms-msg-list">
                    <table class="list-t">
                        <colgroup>
                            <col class="col-01"><col class="col-02"><col class="col-03"><col class="col-04"><col class="col-05">
                        </colgroup>
                        <thead>
                        <tr>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th><div class="td_style">老师可见时间</div></th>
                            <th><div class="td_style">删除</div></th>
                        </tr>
                    	</thead>
                        <tbody id="data_body">
                            <c:forEach var="task" items="${paging.result }">
	                            <tr>
	                                <td>
	                                    <i class="ico ico-${task.subjectType}"></i>
	                                </td>
	                                <td>
	                                    <a href="<%=basePath %>/cmsTask/showModiTaskPageForIstudy.do?taskId=${task.id}">${task.taskName_}</a>
	                                </td>
	                                <td>
	                                	<c:choose>
	                                		<c:when test="${task.sendStatus == '0'}">待发送</c:when>
	                                		<c:when test="${task.sendStatus == '1'}">发送中</c:when>
	                                		<c:when test="${task.sendStatus == '2'}">已发送</c:when>
	                                		<c:when test="${task.sendStatus == '3'}">发送成功</c:when>
	                                		<c:when test="${task.sendStatus == '4'}">发送失败</c:when>
	                                	</c:choose>
	                                </td>
	                                <td><div class="td_style">${task.activeDate}</div></td>
	                                <td>
	                                    <div class="td_style"><a href="javascript:deleteTask(<c:out value="${task.id}" />);" class="btn-delete">删除</a></div>
	                                </td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <%@include file="../paging.jsp"%>
            </div>
        </div>
    </div>
</body>

<script type="text/javascript">
function deleteTask(id){
	if(!confirm("确定删除该条记录吗")){
		return;
	}
	$.ajax({
  		 type: "POST",
  		 url: "cmsTask/deleteCMSTaskForIstudy.do",
  		 data: {"id":id},
  		 dataType: "json",
  		 success: function(obj){
  			 alert(obj.desc);
  			 window.location.reload();
  		 }
  		});  
}

$.paging('cms_task_list_for_istudy',"cmsTask/getPagingData.do",{},function(data){
	var result = data.result,
	innerHtml = "",
	task = null,
	currentPage = $('#currentPage'),
	dataBody = $('#data_body');
	for(var i = 0 ;i< result.length;i++){
		task = result[i];
		innerHtml+='<tr><td><i class="ico ico-'+
		task.subjectType+'"></i></td><td><a href="<%=basePath %>/cmsTask/showModiTaskPageForIstudy.do?taskId='+
		task.id+'">'+
		task.taskName_+'</a></td><td><div class="td_style">'+
		task.activeDate+'</div></td><td><div class="td_style"><a href="javascript:deleteTaskForIstudy('+
		task.id+');" class="btn-delete">删除</a></div></td></tr>';
	}
	dataBody.html(innerHtml);
	currentPage.val(data.pageIndex);
});
</script>
</html>