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
<%
	String enterprise_Name = (String)request.getAttribute("enterprise_Name");
	if(enterprise_Name!=null){
		enterprise_Name = new String(enterprise_Name.getBytes("ISO-8859-1"), "UTF-8");
	}else{
		enterprise_Name="";
	}
%>
<body class="bc-white">
    <div id="page" class="pos-r">
        <div class="cms-container">
	        <div class="location">
	               <strong>账户列表</strong><br>
	               <label><font color="red">由于安全问题,密码是明文，但是修改后能正常使用,请知晓。</font></label>
	        </div>
	        <div class="location" style="text-align: center;">
				<a style="margin-left: 80px;" href="javascript:deleteTaskByMid('accounts/getAddAccountPage.do?enterpriseID=${paging.enterpriseID }&enterprise_Name=${paging.enterprise_Name }');">
	        	<input type="button" value="添加账户"/>
	       		</a>
	       		<a href="javascript:deleteEnterprise();">
	       		<input type="button" value="删除"/>
	       		</a>
	       		<label style="margin-left: 60px;"><font color="green">所属企业:</font></label><label><strong><%=enterprise_Name %></strong></label>
	        </div>
            <div class="cms-main">
                <div class="msg-list cms-msg-list">
                <input type="hidden" id="enterprise_Name" value="${paging.enterprise_Name }"/>
                <input type="hidden" id="enterpriseID" value="${paging.enterpriseID }"/>
                    <table class="list-t">
                        <thead>
                        <tr>
                            <th></th>
                            <th>账户名称</th>
                            <th>账户密码</th>
                            <th>账户描述</th>
                            <th>相关操作</th>
                        </tr>
                    	</thead>
                        <tbody id="data_body">
                            <c:forEach var="task" items="${paging.result }">
	                            <tr>
	                                <td>
	                                	<input type="checkbox" name="username" value="${task.username }"/>
	                                </td>
	                                <td>
	                                    <a href="<%=basePath %>accounts/getAccountById.do?username=${task.username}&enterpriseID=${paging.enterpriseID }&enterprise_Name=${paging.enterprise_Name }">${task.username}</a>
	                                </td>
	                                <td>${task.password}</td>
	                                <td>${task.account_desc}</td>
	                                <td>
	                                    <a href="javascript:choseRole('accounts/showPaging.do?target=role_for_chose&username=${task.username }&enterpriseID=${paging.enterpriseID }&enterprise_Name=${paging.enterprise_Name }');">
	                                    <input type="button" value="分配角色"/>
	                                    </a>
	                                </td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="location" style="text-align: right;">
	        	<a style="margin-left: 80px;" href="javascript:deleteTaskByMid('accounts/getAddAccountPage.do?enterpriseID=${paging.enterpriseID }&enterprise_Name=${paging.enterprise_Name }');">
	        	<input type="button" value="添加账户"/>
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
    	<iframe id="deleteIframe" src="" width="700" height="350" frameborder="0" scroll="no"></iframe>
    </div>
    
</body>

<script type="text/javascript">

function parents(){
	parent.redirect('enterprise/showPaging.do?target=account_list');
}

function deleteEnterprise(){
	var usernames = document.getElementsByName("username");
	var ids='';
	for(var i=0;i<usernames.length;i++){
		if(usernames[i].checked){
			ids+=usernames[i].value+',';
		}
	}
	var resource = {'usernameStr':ids};
	if(ids==''){
		alert('请勾选要删除的账户');
		return;
	}
	if(confirm("确认要删除选中账户吗?")){
		$.ajax({
	 		 type: "POST",
	 		 url: "accounts/delAccount.do",
	 		 data: resource,
	 		 dataType: "json",
	 		 success: function(obj){
	 			var msg = obj.desc;
				alert(msg);	
	 			var cur = $(".cms-nav :first-child",window.parent.document);
				cur.addClass("cur");
				cur.siblings(".cur").removeClass("cur");
				var enterpriseID=$('#enterpriseID').val();
				var enterprise_Name=$('#enterprise_Name').val();
				location.href='<%=basePath %>accounts/showPaging.do?target=account_list&enterpriseID='+enterpriseID+'&enterprise_Name='+enterprise_Name;
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

function choseRole(url){
	$deleteIframe.css("width","600").css("height","500").attr('src', url);
	$overlay.show();
	$msgbox.css("width","600").css("height","500").css("top", "0").show();
}

function hideDeleteIframe(enterpriseID,enterpriseName) {
	$overlay.hide();
	$msgbox.hide();
	if(enterpriseID){
		location.href='<%=basePath %>accounts/showPaging.do?target=account_list&enterpriseID='+enterpriseID+'&enterprise_Name='+enterpriseName;
	}
}

$("#taskListOverlay").click(function() {
	hideDeleteIframe();
});

$.paging('account_list',"accounts/getPagingData.do",{},function(data){
	var result = data.result,
	innerHtml = "",
	task = null,
	currentPage = $('#currentPage'),
	dataBody = $('#data_body');
	var enterpriseID = data.enterpriseID;
	var enterprise_Name = data.enterprise_Name;
	for(var i = 0 ;i< result.length;i++){
		task = result[i];
		innerHtml+='<tr><td><input type="checkbox" id="username" value="'+task.username+'"/>'+
		'</td><td><a href="<%=basePath %>accounts/getAccountById.do?username='+
				task.username+'&enterpriseID='+enterpriseID+'&enterprise_Name='+enterprise_Name+'">'+
		task.username+'</a></td><td>'+task.password+'</td><td>'+
		task.account_desc+'</td><td><a href="javascript:choseRole(\'accounts/showPaging.do?target=role_for_chose&username='+
				task.username+'&enterpriseID='+data.enterpriseID+'&enterprise_Name='+data.enterprise_Name+
				'\');"><input type="button" value="分配角色"/></a></td></tr>';
	}
	dataBody.html(innerHtml);
	currentPage.val(data.pageIndex);
});
</script>
</html>