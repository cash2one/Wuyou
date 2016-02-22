<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业信息列表</title>
<link rel="stylesheet" href="css/layout.css?v0.01">
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="js/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="js/ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript" src="js/istudy-cms.js"></script>
<%
	String enterprise_Name = (String)request.getAttribute("enterprise_Name");
	if(null!=enterprise_Name){
		enterprise_Name = new String(enterprise_Name.getBytes("ISO-8859-1"), "UTF-8");
	}else{
		enterprise_Name = "";
	}
%>
</head>
<body class="bc-white">
    <div id="page" class="pos-r">
        <div class="cms-container">
	        <div class="location">
	               <strong>角色列表</strong>
	        </div>
	        <div class="location">
	        <a href="javascript:saveEnterpriseAndMsg(this);" id="save_form_data" class="btn-submit">
	        <input type="button"  value="保存" />
	        </a>
	        <a href="javascript:deleLink(this);" id="save_form_data" class="btn-submit">
	        <input type="button"  value="删除" />
	        </a>
	       		<label style="margin-left: 60px;"><font color="green">已有角色:</font></label><label><strong>${roleName }</strong></label>
	        </div>
            <div class="cms-main">
                <div class="msg-list cms-msg-list">
                	<input type="hidden" id="username" value="${username }" />
                	<input type="hidden" id="enterpriseID" value="${enterpriseID }" />
                	<input type="hidden" id="enterprise_Name" value="<%=enterprise_Name %>" />
                    <table class="list-t">
                        <thead>
                        <tr>
                            <th></th>
                            <th>角色名称</th>
                        </tr>
                    	</thead>
                        <tbody id="data_body">
                            <c:forEach var="task" items="${paging.result }">
	                            <tr>
	                                <td>
	                                	<input type="checkbox" name="roleID" value="${task.roleID }"/>
	                                </td>
	                                <td>${task.roleName}</td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
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
}

$("#taskListOverlay").click(function() {
	hideDeleteIframe();
});


function validation(){
	var roleIDs = document.getElementsByName("roleID");
	var ids = '';
	for(var i=0;i<roleIDs.length;i++){
		if(roleIDs[i].checked){
			ids+=roleIDs[i].value+',';
		}
	}
	return ids;
}

function validations(){
	var roleIDs = document.getElementsByName("roleID");
	var ids = '';
	for(var i=0;i<roleIDs.length;i++){
		if(roleIDs[i].checked){
			ids+=roleIDs[i].value+',';
		}
	}
	return ids;
}

function saveEnterpriseAndMsg(obj){
	var msg = validation();
	if(msg==''){
			alert('请勾选角色后再保存');
			return ;
	}
	var resouce = {
			username   : $('#username').val(),
			roleID : msg
	};
	var enterpriseID = $('#enterpriseID').val(),enterprise_Name=$('#enterprise_Name').val();
	$(obj).attr("disabled","disabled");
	$.ajax({
		 type: "POST",
		 url: "roles/linkAccount2Role.do",
		 data: eval(resouce),
		 dataType: "json",
		 success: function(obj){
			 var msg = obj.desc;
			 alert(msg);
		 }
	});
}

function deleLink(obj){
	var msg = validations();
	if(msg==''){
			alert('请勾选需要删除的已有角色再点删除');
			return ;
	}
	var resouce = {
			username   : $('#username').val(),
			roleID : msg
	};
	var enterpriseID = $('#enterpriseID').val(),enterprise_Name=$('#enterprise_Name').val();
	$(obj).attr("disabled","disabled");
	$.ajax({
		 type: "POST",
		 url: "roles/removeAccount2Role.do",
		 data: eval(resouce),
		 dataType: "json",
		 success: function(obj){
			 var msg = obj.desc;
			 alert(msg);
		 }
	});
}

$.paging('role_for_chose',"actions/getPagingData.do",{},function(data){
	var result = data.result,
	innerHtml = "",
	task = null,
	currentPage = $('#currentPage'),
	dataBody = $('#data_body');
	for(var i = 0 ;i< result.length;i++){
		task = result[i];
		innerHtml+='<tr><td><input type="checkbox" name="roleID" value="'+task.roleID+'"/><td>'+task.roleName+'</td></tr>';
	}
	dataBody.html(innerHtml);
	currentPage.val(data.pageIndex);
});
</script>
</html>