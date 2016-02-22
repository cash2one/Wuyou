<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业信息列表</title>
<link rel="stylesheet" href="css/layout.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/istudy-cms.js"></script>
</head>
<body class="bc-white">
    <div id="page" class="pos-r">
        <div class="cms-container">
	        <div class="location">
	               <strong>功能列表</strong>
	        </div>
	        <div class="location" style="text-align: center;">
				<a style="margin-left: 80px;" href="javascript:deleteTaskByMid('actions/getAddActionPage.do');">
	        	<input type="button" value="添加功能"/>
	       		</a>
	       		<a href="javascript:deleteEnterprise();">
	       		<input type="button" value="删除"/>
	       		</a>
	        </div>
            <div class="cms-main">
                <div class="msg-list cms-msg-list">
                    <table class="list-t">
                        <thead>
                        <tr>
                            <th></th>
                            <th>功能名称</th>
                            <th>功能地址</th>
                            <th>功能描述</th>
                        </tr>
                    	</thead>
                        <tbody id="data_body">
                            <c:forEach var="task" items="${paging.result }">
	                            <tr>
	                                <td>
	                                	<input type="checkbox" name="actionID" value="${task.actionID }"/>
	                                </td>
	                                <td>
	                                    <a href="<%=basePath %>actions/getActionById.do?actionID=${task.actionID}">${task.actionName}</a>
	                                </td>
	                                <td>${task.actionURL}</td>
	                                <td>${task.actionDesc}</td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="location" style="text-align: right;">
	        	<a style="margin-left: 80px;" href="javascript:deleteTaskByMid('actions/getAddActionPage.do');">
	        	<input type="button" value="添加功能"/>
	        	</a>
	        	<a href="javascript:deleteEnterprise()">
	        	<input type="button" value="删除"/>
	        	</a>
	        </div>
                <%@include file="../paging.jsp"%>
            </div>
        </div>
    </div>
    
    <div class="overlay-white" id="taskListOverlay"></div>
    <div class="msgbox-key" id="taskListMsgbox">
    	<iframe id="deleteIframe" src="" width="700" height="450" frameborder="0" scroll="no"></iframe>
    </div>
    
</body>

<script type="text/javascript">


function deleteEnterprise(){
	var actionIDs = document.getElementsByName("actionID");
	var ids='';
	for(var i=0;i<actionIDs.length;i++){
		if(actionIDs[i].checked){
			ids+=actionIDs[i].value+',';
		}
	}
	var resource = {'actionIDs':ids};
	if(ids==''){
		alert('请勾选要删除的功能');
		return;
	}
	if(confirm("确认要删除选中的功能吗?")){
		$.ajax({
	 		 type: "POST",
	 		 url: "actions/delAction.do",
	 		 data: resource,
	 		 dataType: "json",
	 		 success: function(obj){
	 			var msg = obj.desc;
				alert(msg);	
	 			var cur = $(".cms-nav :first-child",window.parent.document);
				cur.addClass("cur");
				cur.siblings(".cur").removeClass("cur");
	 	 		location.href = url_head+'actions/showPaging.do?target=action_list';
	 		 }
	 		});		
	}
}

var $overlay = $("#taskListOverlay"),
	$msgbox = $("#taskListMsgbox"),
	$deleteIframe = $("#deleteIframe");

function deleteTaskByMid(url){
	$deleteIframe.attr('src', url);
	$overlay.show();
	$msgbox.css("width","700").css("height","450").css("top", "0").show();
}

function hideDeleteIframe() {
	$overlay.hide();
	$msgbox.hide();
	parent.redirect('actions/showPaging.do?target=action_list');
}

$("#taskListOverlay").click(function() {
	hideDeleteIframe();
});

$.paging('action_list',"actions/getPagingData.do",{},function(data){
	var result = data.result,
	innerHtml = "",
	task = null,
	currentPage = $('#currentPage'),
	dataBody = $('#data_body');
	for(var i = 0 ;i< result.length;i++){
		task = result[i];
		innerHtml+='<tr><td><input type="checkbox" name="actionID" value="'+task.actionID+'"/>'+
		'</td><td><a href="<%=basePath %>actions/getActionById.do?actionID='+
		task.actionID+'">'+
		task.actionName+'</a></td><td>'+
		task.actionURL+'</td><td>'+task.actionDesc+'</td></tr>';
	}
	dataBody.html(innerHtml);
	currentPage.val(data.pageIndex);
});
</script>
</html>