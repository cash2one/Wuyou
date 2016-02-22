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
	String enterpriseName = (String)request.getAttribute("enterpriseName");
	if(null != enterpriseName){
		enterpriseName = new String(enterpriseName.getBytes("ISO-8859-1"), "UTF-8");
	}else{
		enterpriseName = "";
	}
%>
<body class="bc-white">
    <div id="page" class="pos-r">
        <div class="cms-container">
	        <div class="location">
	               <strong>企业列表</strong>
	        </div>
	        <div class="location" style="text-align: center;">
	        	<label>企业名称</label><input type="text" id="enterpriseName" value="<%=enterpriseName %>">
	        	<a style="margin-left: 80px;" href="javascript:parents();">
	        	<input type="button" value="查询"/>
	        	</a>
				<a style="margin-left: 80px;" href="javascript:deleteTaskByMid('enterprise/getAddEnterprisePage.do');">
	        	<input type="button" value="添加企业"/>
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
                            <th>企业名称</th>
                            <th>企业描述</th>
                            <th>厂商类别</th>
                            <th>相关操作</th>
                        </tr>
                    	</thead>
                        <tbody id="data_body">
                            <c:forEach var="task" items="${paging.result }">
	                            <tr>
	                                <td>
	                                	<c:if test="${task.vendorType!='4' }">
	                                		<input type="checkbox" name="enterpriseID" value="${task.enterpriseID }"/>
	                                	</c:if>
	                                </td>
	                                <td>
	                                    <c:if test="${task.vendorType!='4' }">
	                                    	<a href="<%=basePath %>enterprise/getEnterpriseById.do?enterpriseID=${task.enterpriseID}">${task.enterpriseName}</a>
	                                    </c:if>
	                                    <c:if test="${task.vendorType=='4' }">${task.enterpriseName }</c:if>
	                                </td>
	                                <td>${task.enterpriseDesc}</td>
	                                <td>
	                                	<c:if test="${task.vendorType == '1'}">第三方CP</c:if>
	                                	<c:if test="${task.vendorType == '2'}">爱学网小编</c:if>
	                                	<c:if test="${task.vendorType == '3'}">校讯通官方</c:if>
	                                	<c:if test="${task.vendorType == '4'}">超级管理员</c:if>
	                                </td>
	                                <td>
	                                    <a href="javascript:showAccount('${task.enterpriseID}','${task.enterpriseName }');">
	                                    <input type="button" value="查看所有账号"/>
	                                    </a>
	                                </td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="location" style="text-align: right;">
	        	<a style="margin-left: 80px;" href="javascript:deleteTaskByMid('enterprise/getAddEnterprisePage.do');">
	        	<input type="button" value="添加企业"/>
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
    	<iframe id="deleteIframe" src="" width="900" height="650" frameborder="0"></iframe>
    </div>
    
</body>

<script type="text/javascript">

function parents(){
	var enterpriseName = $("#enterpriseName").val();
	parent.redirect('enterprise/showPaging.do?target=enterprise_list&enterpriseName='+enterpriseName);
}

function showAccount(enterpriseID,enterpriseName){
	parent.redirect('accounts/showPaging.do?target=account_list&enterpriseID='+enterpriseID+'&enterprise_Name='+enterpriseName);
}

function deleteEnterprise(){
	var enterpriseIDs = document.getElementsByName("enterpriseID");
	var ids='';
	for(var i=0;i<enterpriseIDs.length;i++){
		if(enterpriseIDs[i].checked){
			ids+=enterpriseIDs[i].value+',';
		}
	}
	var resource = {'enterpriseIDs':ids};
	if(ids==''){
		alert('请勾选要删除的企业');
		return;
	}
	if(confirm("确认要删除选中企业并删除对应的所有账户吗?")){
		$.ajax({
	 		 type: "POST",
	 		 url: "enterprise/delEnterprise.do",
	 		 data: resource,
	 		 dataType: "json",
	 		 success: function(obj){
	 			var msg = obj.desc;
				alert(msg);	
	 			var cur = $(".cms-nav :first-child",window.parent.document);
				cur.addClass("cur");
				cur.siblings(".cur").removeClass("cur");
	 	 		location.href = url_head+'enterprise/showPaging.do?target=enterprise_list';
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
	$msgbox.css("width","900").css("height","650").css("top", "0").show();
}

function hideDeleteIframe() {
	$overlay.hide();
	$msgbox.hide();
	location.href = '<%=basePath %>enterprise/showPaging.do?target=enterprise_list';
}

$("#taskListOverlay").click(function() {
	hideDeleteIframe();
});

$.paging('enterprise_list',"enterprise/getPagingData.do",{},function(data){
	var result = data.result,
	innerHtml = "",
	task = null,
	currentPage = $('#currentPage'),
	dataBody = $('#data_body');
	for(var i = 0 ;i< result.length;i++){
		task = result[i];
		innerHtml+='<tr><td>';
		if(task.vendorType!='4'){
			innerHtml += '<input type="checkbox" name="enterpriseID" value="'+task.enterpriseID+'"/>';
		}
		innerHtml+='</td><td>';
		if(task.vendorType!='4'){
			innerHtml += '<a href="<%=basePath %>/enterprise/getEnterpriseById.do?enterpriseID='+task.enterpriseID+'">'+task.enterpriseName+'</a>';
		}else{
			innerHtml += task.enterpriseName;
		}
		innerHtml += '</td><td>'+
		task.enterpriseDesc+'</td><td>';
		if(task.vendorType == '1'){
			innerHtml += "第三方CP";
		}else if(task.vendorType=='2'){
			innerHtml += "爱学网小编";
		}else if(task.vendorType=='3'){
			innerHtml += "校讯通官方";
		}else if(task.vendorType=='4'){
			innerHtml += "超级管理员";
		}
		innerHtml+='</td><td><a href="javascript:showAccount(\''+task.enterpriseID+'\',\''+task.enterpriseName+'\');">'+
		'<input type="button" value="查看所有账号"/></a></td></tr>';
	}
	dataBody.html(innerHtml);
	currentPage.val(data.pageIndex);
});
</script>
</html>