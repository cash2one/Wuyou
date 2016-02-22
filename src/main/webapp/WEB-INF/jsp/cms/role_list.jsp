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
	               <strong>角色列表</strong>
	        </div>
	        <div class="location" style="text-align: center;">
				<a style="margin-left: 80px;" href="javascript:deleteTaskByMid('roles/getAddRolePage.do');">
	        	<input type="button" value="添加角色"/>
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
                            <th>角色名称</th>
                            <th>角色描述</th>
                            <th>相关操作</th>
                        </tr>
                    	</thead>
                        <tbody id="data_body">
                            <c:forEach var="task" items="${paging.result }">
	                            <tr>
	                                <td>
	                                	<input type="checkbox" name="roleID" value="${task.roleID }"/>
	                                </td>
	                                <td>
	                                    <a href="<%=basePath %>roles/getRoleById.do?roleID=${task.roleID}">${task.roleName}</a>
	                                </td>
	                                <td>${task.roleDesc}</td>
	                                <td>
	                                    <a href="javascript:deleteTaskByMid('roles/showPaging.do?target=action_for_chose&roleID=${task.roleID}');">
	                                    <input type="button" value="分配访问地址"/>
	                                    </a>
	                                </td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="location" style="text-align: right;">
	        	<a style="margin-left: 80px;" href="javascript:deleteTaskByMid('roles/getAddRolePage.do');">
	        	<input type="button" value="添加角色"/>
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
    	<iframe id="deleteIframe" src="" width="700" height="350" frameborder="0"></iframe>
    </div>
    
</body>

<script type="text/javascript">

function deleteEnterprise(){
	var roleIDs = document.getElementsByName("roleID");
	var ids='';
	for(var i=0;i<roleIDs.length;i++){
		if(roleIDs[i].checked){
			ids+=roleIDs[i].value+',';
		}
	}
	var resource = {'roleIDs':ids};
	if(ids==''){
		alert('请勾选要删除的角色');
		return;
	}
	if(confirm("确认要删除选中的角色吗?")){
		$.ajax({
	 		 type: "POST",
	 		 url: "roles/delRole.do",
	 		 data: resource,
	 		 dataType: "json",
	 		 success: function(obj){
	 			var msg = obj.desc;
				alert(msg);	
	 			var cur = $(".cms-nav :first-child",window.parent.document);
				cur.addClass("cur");
				cur.siblings(".cur").removeClass("cur");
	 	 		location.href = url_head+'roles/showPaging.do?target=role_list';
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
	$msgbox.css("width","700").css("height","350").css("top", "0").show();
}

function hideDeleteIframe() {
	$overlay.hide();
	$msgbox.hide();
	//parent.redirect('roles/showPaging.do?target=role_list');
}

$("#taskListOverlay").click(function() {
	hideDeleteIframe();
	location.href = '<%=basePath %>roles/showPaging.do?target=role_list';
});

$.paging('role_list',"roles/getPagingData.do",{},function(data){
	var result = data.result,
	innerHtml = "",
	task = null,
	currentPage = $('#currentPage'),
	dataBody = $('#data_body');
	for(var i = 0 ;i< result.length;i++){
		task = result[i];
		innerHtml+='<tr><td><input type="checkbox" name="roleID" value="'+task.roleID+'"/>'+
		'</td><td><a href="<%=basePath %>roles/getRoleById.do?roleID='+
		task.roleID+'">'+
		task.roleName+'</a></td><td>'+
		task.roleDesc+'</td><td><a href="javascript:deleteTaskByMid(\'roles/showPaging.do?target=action_for_chose&roleID='+task.roleID+'\');">'+
		'<input type="button" value="分配访问地址"/></a></td></tr>';
	}
	dataBody.html(innerHtml);
	currentPage.val(data.pageIndex);
});
</script>
</html>