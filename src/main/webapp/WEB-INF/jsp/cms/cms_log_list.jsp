<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作日志</title>

<link rel="stylesheet" href="css/layout.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/istudy-cms.js"></script>
</head>

<body class="bc-white">
    <div id="page" class="pos-r">
        <div class="cms-container">
	        <div class="location">
	               <strong>操作日志</strong>
	        </div>
            <div class="cms-main">

				<div>
				请输入关键字：<input type="text" id="condition" value="${condition }"><!-- <a href="javascript:search()">日志查询</a> --><button onclick="search()">查询</button>
				</div>
				<div>
				<br>
				</div>
                <div class="msg-list cms-msg-list">
                    <table class="list-t">
                        <colgroup>
                            <col class="col-01"><col class="col-02"><col class="col-04"><col class="col-03"><col class="col-05">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>用户</th>
                            <th>企业名称</th>
                            <th>来源ip</th>
                            <th>日志内容</th>
                            <th>时间</th>
                        </tr>
                    	</thead>
                        <tbody id="data_body">
                            <c:forEach var="log" items="${paging.result }">
	                            <tr>
	                                <td>${log.userName }</td>
	                                <td>${log.enterpriseName }</td>
	                                <td>${log.ip }</td>
	                                <td>${log.logInfo }</td>
	                                <td>${log.activeDate }</td>
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
/* $(document).ready(function(){
	$('#condition').attr('value','${param.condition}');
}) */
$().ready(function(){
	$('input:first').focus();
	$(document).keypress(function(e){
		var key = event.keyCode;
		if(key ==13){
			 $("button").click(); 
		}
	});
});
function search(){
	var condition = $('#condition').val();
	var condition1 = encodeURI(condition);  
	window.location.href="/cms/showPaging.do?target=cms_log_list&condition=" + condition1;
}


$.paging('cms_log_list',"cms/getPagingData.do",{"condition":"${condition}"},function(data){
	var result = data.result,
	innerHtml = "",
	task = null,
	currentPage = $('#currentPage'),
	dataBody = $('#data_body');
	for(var i = 0 ;i< result.length;i++){
		task = result[i];
		innerHtml+='<tr><td>' + task.userName + '</td><td>'
							  + task.enterpriseName + '</td><td>'
							  + task.ip + '</td><td>'
							  + task.logInfo + '</td><td>'
							  + task.activeDate + '</td></tr>';
	}
	dataBody.html(innerHtml);
	currentPage.val(data.pageIndex);
});
</script>
</html>