<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CMS后台任务列表</title>

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
	        <div class="select-topbar">
		        <select id="pushType" onchange="search() ">
		        <option value="1" <c:if test="${param.pushType == '1' }">selected="selected"</c:if>>校讯通PC</option>
		        <c:if test="${sessionScope.user.vendorType!='3' }">
		        	<option value="2" <c:if test="${param.pushType == '2' }">selected="selected"</c:if>>校讯通APP</option>
		        	<option value="3" <c:if test="${param.pushType == '3' }">selected="selected"</c:if>>校园+APP</option>
		        </c:if>
		        </select>
		        <select id="grade" onchange="search() ">
	       	 	<option value="0">全部年级</option>
	        	<option value="1" <c:if test="${param.grade == '1' }">selected="selected"</c:if>>小一</option>
	        	<option value="2" <c:if test="${param.grade == '2' }">selected="selected"</c:if>>小二</option>
	        	<option value="3" <c:if test="${param.grade == '3' }">selected="selected"</c:if>>小三</option>
	        	<option value="4" <c:if test="${param.grade == '4' }">selected="selected"</c:if>>小四</option>
	        	<option value="5" <c:if test="${param.grade == '5' }">selected="selected"</c:if>>小五</option>
	        	<option value="6" <c:if test="${param.grade == '6' }">selected="selected"</c:if>>小六</option>
	        	<option value="7" <c:if test="${param.grade == '7' }">selected="selected"</c:if>>初一</option>
	        	<option value="8" <c:if test="${param.grade == '8' }">selected="selected"</c:if>>初二</option>
		        <option value="9" <c:if test="${param.grade == '9' }">selected="selected"</c:if>>初三</option>
		        <option value="10" <c:if test="${param.grade == '10' }">selected="selected"</c:if>>高一</option>
	        	<option value="11" <c:if test="${param.grade == '11' }">selected="selected"</c:if>>高二</option>
	        	<option value="12" <c:if test="${param.grade == '12' }">selected="selected"</c:if>>高三</option>
	        	</select>
	        	<select id="month" onchange="search() ">
	        	<option value="0">全部月份</option>
	       	 	<option value="1" <c:if test="${param.month == '1' }">selected="selected"</c:if>>一月</option>
	       	 	<option value="2" <c:if test="${param.month == '2' }">selected="selected"</c:if>>二月</option>
	        	<option value="3" <c:if test="${param.month == '3' }">selected="selected"</c:if>>三月</option>
	        	<option value="4" <c:if test="${param.month == '4' }">selected="selected"</c:if>>四月</option>
	        	<option value="5" <c:if test="${param.month == '5' }">selected="selected"</c:if>>五月</option>
	        	<option value="6" <c:if test="${param.month == '6' }">selected="selected"</c:if>>六月</option>
	        	<option value="7" <c:if test="${param.month == '7' }">selected="selected"</c:if>>七月</option>
	        	<option value="8" <c:if test="${param.month == '8' }">selected="selected"</c:if>>八月</option>
	        	<option value="9" <c:if test="${param.month == '9' }">selected="selected"</c:if>>九月</option>
	        	<option value="10" <c:if test="${param.month == '10' }">selected="selected"</c:if>>十月</option>
	        	<option value="11" <c:if test="${param.month == '11' }">selected="selected"</c:if>>十一月</option>
	        	<option value="12" <c:if test="${param.month == '12' }">selected="selected"</c:if>>十二月</option>
	        	</select>
	        	
	        	<div class="radio-item">
			        <label><input type="radio" name="taskType" value="1" onchange="search()" <c:if test="${param.taskType == '1' }">checked="checked"</c:if>>当前有效</label>
			        <label><input type="radio" name="taskType" value="2" onchange="search()"  <c:if test="${param.taskType == '2' }">checked="checked"</c:if>>等待中的任务</label>
			        <label><input type="radio" name="taskType" value="3" onchange="search()"  <c:if test="${param.taskType == '3' }">checked="checked"</c:if>>已过期的任务</label>
		        </div>
	        </div>
	        
            <div class="cms-main">

                <div class="msg-list cms-msg-list">
                    <table class="list-t">
                        <colgroup>
                            <col class="col-01">
                            <col class="col-02">
                            <col class="col-03">
                            <col>
                            <col class="col-04">
                            <col class="col-04">
                            <col class="col-05">
                        </colgroup>
                        <thead>
                        <tr>
                            <th></th>
                            <th>任务标题</th>
                            <th>图文标题</th>
                            
                            <th>创建者</th>
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
	                                    <c:if test="${param.pushType == '1' }"><a href="<%=basePath %>/cmsTask/showModiTaskPage.do?taskId=${task.id}">${task.taskName_}</a></c:if>
	                                    <c:if test="${param.pushType == '2' }"><a href="<%=basePath %>/cmsTask/showModiTaskPageForXXT.do?taskId=${task.id}">${task.taskName_}</a></c:if>
	                                    <c:if test="${param.pushType == '3' }"><a href="<%=basePath %>/cmsTask/showModiTaskPageForXiaoyuan.do?taskId=${task.id}">${task.taskName_}</a></c:if>
	                                </td>
	                                <td>${task.miniTitle }</td>
	                                <td>${task.creator }</td>
	                                <td>
	                                <c:if test="${param.pushType == '1' && param.taskType == '1' && sessionScope.user.vendorType!='1'}">
	                                <c:choose>
	                                <c:when test="${empty task.sortDate }">
	                                <button onclick="setTop(${task.id})" class="btn-fn">置顶</button>
	                                </c:when>
	                                <c:otherwise>
	                                <button onclick="removeTop(${task.id})" class="btn-fn">取消置顶</button>
	                                </c:otherwise>
	                                </c:choose>
	                                </c:if></td>
	                                <td><div class="td_style">${task.activeDate}</div></td>
	                                <td>
	                                <c:if test="${user.vendorType != 2 || user.enterpriseID == task.creatorEntId }">
		                                <c:if test="${param.pushType == '1' }">
		                                <div class="td_style"><a href="javascript:deleteTask(<c:out value="${task.id}" />);" class="btn-delete">删除</a></div>
		                                <%-- <c:choose>
		                                <c:when test="${task.sendPublicStatus=='3'}">
		                                <div class="td_style"><a href="javascript:deleteTaskByMid('cmsTask/showDeleteTaskList.do?id=${task.id}');" class="btn-delete">删除</a></div>
		                                </c:when>
		                                <c:otherwise>
		                                <div class="td_style"><a href="javascript:deleteTask(<c:out value="${task.id}" />);" class="btn-delete">删除</a></div>
		                                </c:otherwise>
		                                </c:choose> --%>
		                                </c:if>
		                                <c:if test="${param.pushType == '2' }">
		                                <div class="td_style"><a href="javascript:deleteTaskForXXT(<c:out value="${task.id}" />);" class="btn-delete">删除</a></div>
		                                </c:if>
		                                <c:if test="${param.pushType == '3' }">
		                                <div class="td_style"><a href="javascript:deleteTaskForXiaoYuan(<c:out value="${task.id}" />);" class="btn-delete">删除</a></div>
		                                </c:if>
	                                </c:if>
	                                    <%-- <c:if test="${task.sendPublicStatus!='3' }"> <div class="td_style"><a href="javascript:deleteTask(<c:out value="${task.id}" />);" class="btn-delete">删除</a></div></c:if> 
	                                    <c:if test="${task.sendPublicStatus=='3' && param.pushType == '1' }"><div class="td_style"><a href="javascript:deleteTaskByMid('cmsTask/showDeleteTaskList.do?id=${task.id}');" class="btn-delete">删除</a></div></c:if> --%>
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
    
    <div class="overlay-white" id="taskListOverlay"></div>
    <div class="msgbox-key" id="taskListMsgbox">
    	<iframe id="deleteIframe" src="" width="100%" height="300" frameborder="0" scroll="no"></iframe>
    </div>
    
</body>

<script type="text/javascript">
function setTop(id){
	$.ajax({
 		 type: "POST",
 		 url: "cmsTask/setTop.do",
 		 data: {"id":id},
 		 dataType: "json",
 		 success: function(obj){
 			if(obj.code=="10000"){
				 window.location.reload(); 
			 }else{
				 alert(obj.desc);
			 }
 		 }
 		});  
}
function removeTop(id){
	$.ajax({
		 type: "POST",
		 url: "cmsTask/removeTop.do",
		 data: {"id":id},
		 dataType: "json",
		 success: function(obj){
			 if(obj.code=="10000"){
				 window.location.reload(); 
			 }else{
				 alert(obj.desc);
			 }
			 
		 }
		});  
}
function search(){
	var taskType = $('input[name=taskType]:checked').val(),
		pushType = $('#pushType').val(),
	    grade = $('#grade').val(),
	    month = $('#month').val();
	window.location.href="/cmsTask/showPaging.do?target=cms_task_list&pushType=" + pushType + "&grade=" + grade  + "&month=" + month  + "&taskType=" + taskType;
}
 function deleteTask(id){
	if(!confirm("确定删除该条记录吗")){
		return;
	}
	$.ajax({
  		 type: "POST",
  		 url: "cmsTask/deleteCMSTask.do",
  		 data: {"id":id},
  		 dataType: "json",
  		 success: function(obj){
  			 alert(obj.desc);
  			 window.location.reload();
  		 }
  		});  
} 
 function deleteTaskForXXT(id){
		if(!confirm("确定删除该条记录吗")){
			return;
		}
		$.ajax({
	  		 type: "POST",
	  		 url: "cmsTask/deleteCMSTaskForXXT.do",
	  		 data: {"id":id},
	  		 dataType: "json",
	  		 success: function(obj){
	  			 alert(obj.desc);
	  			 window.location.reload();
	  		 }
	  		});  
	} 
 function deleteTaskForXiaoYuan(id){
		if(!confirm("确定删除该条记录吗")){
			return;
		}
		$.ajax({
	  		 type: "POST",
	  		 url: "cmsTask/deleteCMSTaskForXiaoyuan.do",
	  		 data: {"id":id},
	  		 dataType: "json",
	  		 success: function(obj){
	  			 alert(obj.desc);
	  			 window.location.reload();
	  		 }
	  		});  
	} 

var $overlay = $("#taskListOverlay"),
	$msgbox = $("#taskListMsgbox"),
	$deleteIframe = $("#deleteIframe");

function deleteTaskByMid(url){
	$deleteIframe.attr('src', url);
	$overlay.show();
	$msgbox.css("top", "0").show();
}

function hideDeleteIframe() {
	$overlay.hide();
	$msgbox.hide();
}

$("#taskListOverlay").click(function() {
	hideDeleteIframe();
});



$.paging('cms_task_list',"cmsTask/getPagingData.do",{"pushType":"${param.pushType}","grade":"${param.grade}","month":"${param.month}","taskType":"${param.taskType}"},function(data){
	var result = data.result,
	innerHtml = "",
	task = null,
	currentPage = $('#currentPage'),
	dataBody = $('#data_body'),
	pushType = ${param.pushType };
	var modi = "",
	top = "",
	del = "";
	
	for(var i = 0 ;i< result.length;i++){
		task = result[i];
		if('${user.vendorType}' != '2' || '${user.enterpriseID}' == task.creatorEntId){
			if(pushType == '1'){
				del = '<a href="javascript:deleteTask(' + task.id + ');" class="btn-delete">删除</a>';
				/* if(task.sendPublicStatus=='3'){
					del = '<a href="javascript:deleteTaskByMid(&apos;cmsTask/showDeleteTaskList.do?id=' + task.id + '&apos;);" class="btn-delete">删除</a>';
				}else{
					del = '<a href="javascript:deleteTask(' + task.id + ');" class="btn-delete">删除</a>';
				} */
			}else if(pushType == '2'){
				del = '<a href="javascript:deleteTaskForXXT(' + task.id + ');" class="btn-delete">删除</a>';
			}else{
				del = '<a href="javascript:deleteTaskForXiaoYuan(' + task.id + ');" class="btn-delete">删除</a>';
			}
		}else{
			del = "";
		}
		if(pushType == '1'){
			modi = '<a href="/cmsTask/showModiTaskPage.do?taskId='+ task.id +'">'+ task.taskName_+'</a>';
			if('${user.vendorType}' != '1'){
				if(!task.sortDate){
					top = '<button onclick="setTop(' + task.id + ')" class="btn-fn">置顶</button>';
				}else{
					top = '<button onclick="removeTop(' + task.id + ')" class="btn-fn">取消置顶</button>';
				}
			}
				
		}else if(pushType == '2'){
			modi = '<a href="/cmsTask/showModiTaskPageForXXT.do?taskId='+ task.id +'">'+ task.taskName_+'</a>';
			top = ""
		}else{
			modi = '<a href="/cmsTask/showModiTaskPageForXiaoyuan.do?taskId='+ task.id +'">'+ task.taskName_+'</a>';
			top = ""
		}
		innerHtml+='<tr><td><i class="ico ico-'+
		task.subjectType+'"></i></td><td>' + modi + '</td><td>'+ task.miniTitle +'</td><td>' + task.creator + '</td><td>' + top + '</td><td><div class="td_style">'+
		task.activeDate+'</div></td><td><div class="td_style">'+ 
		del +'</div></td></tr>';
	}
	dataBody.html(innerHtml);
	currentPage.val(data.pageIndex);
});
</script>
</html>