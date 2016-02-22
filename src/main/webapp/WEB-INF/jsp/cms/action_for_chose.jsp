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
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="js/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="js/ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript" src="js/istudy-cms.js"></script>
</head>
<body class="bc-white">
    <div id="page" class="pos-r">
        <div class="cms-container">
	        <div class="location">
	               <strong>功能列表</strong>
	        </div>
	        <div class="location">
		        <a href="javascript:saveEnterpriseAndMsg(this);" id="save_form_data" class="btn-submit">
		        <input type="button"  value="保存" />
		        </a>
		        <a href="javascript:deleLink(this);" id="save_form_data" class="btn-submit">
		        <input type="button"  value="删除" />
		        </a>
		        <a href="javascript:oneKeyAction(this);" id="save_form_data" class="btn-submit">
		        <input type="button"  value="一键分配功能" />
		        </a>
	        </div>
	        
	        <dl class="fenp-fn">
	        	<dt>已分配功能</dt>
	        	<dd>${allAction }</dd>
	        </dl>
	       
            <div class="cms-main">
                <div class="msg-list cms-msg-list">
                	<input type="hidden" id="roleID" value="${roleID }" />
                    <table class="list-t">
                        <thead>
                        <tr>
                            <th></th>
                            <th>功能名称</th>
                        </tr>
                    	</thead>
                        <tbody id="data_body">
                            <c:forEach var="task" items="${paging.result }">
	                            <tr>
	                                <td>
	                                	<input type="checkbox" name="actionID" value="${task.actionID }"/>
	                                </td>
	                                <td>${task.actionName}</td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
	        </div>
                <%@include file="../paging.jsp"%>
            </div>
        </div>
    
    <div class="overlay-white" id="taskListOverlay"></div>
    <div class="msgbox-key" id="taskListMsgbox">
    	<iframe id="deleteIframe" src="" width="700" height="450" frameborder="0"></iframe>
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
	parent.redirect('actions/showPaging.do?target=action_list');
}

$("#taskListOverlay").click(function() {
	hideDeleteIframe();
});

function oneKeyAction(obj){
	if(confirm('确定要为该角色分配所有访问地址吗?')){
		var resouce = {
				roleID   : $('#roleID').val()
		};
		$(obj).attr("disabled","disabled");
		$.ajax({
			 type: "POST",
			 url: "roles/oneKeyRole2Action.do",
			 data: resouce,
			 dataType: "json",
			 success: function(obj){
				 var msg = obj.desc;
				 alert(msg);
			 }
		});
	}
}

function validations(){
	var actionIDs = document.getElementsByName("actionID");
	var ids = '';
	for(var i=0;i<actionIDs.length;i++){
		if(actionIDs[i].checked){
			ids+=actionIDs[i].value+',';
		}
	}
	return ids;
}

function saveEnterpriseAndMsg(obj){
	var msg = validations();
	if(msg==''){
			alert('请勾选功能后再保存');
			return ;
	}
	var resouce = {
			roleID   : $('#roleID').val(),
			actionID : msg
	};
	$(obj).attr("disabled","disabled");
	$.ajax({
		 type: "POST",
		 url: "roles/linkRole2Action.do",
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
			alert('请勾选需要删除的已有功能再点删除');
			return ;
	}
	var resouce = {
			roleID   : $('#roleID').val(),
			actionID : msg
	};
	
	$(obj).attr("disabled","disabled");
	$.ajax({
		 type: "POST",
		 url: "roles/removeRole2Action.do",
		 data: eval(resouce),
		 dataType: "json",
		 success: function(obj){
			 var msg = obj.desc;
			 alert(msg);
		 }
	});
}

$.paging('action_for_chose',"actions/getPagingData.do",{},function(data){
	var result = data.result,
	innerHtml = "",
	task = null,
	currentPage = $('#currentPage'),
	dataBody = $('#data_body');
	for(var i = 0 ;i< result.length;i++){
		task = result[i];
		innerHtml+='<tr><td><input type="checkbox" name="actionID" value="'+task.actionID+'"/><td>'+task.actionName+'</td></tr>';
	}
	dataBody.html(innerHtml);
	currentPage.val(data.pageIndex);
});
</script>
</html>