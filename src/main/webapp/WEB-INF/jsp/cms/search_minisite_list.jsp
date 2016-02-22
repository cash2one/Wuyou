<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>minisite列表</title>
<link rel="stylesheet" href="css/layout.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/istudy-cms.js"></script>
<style type="text/css"></style>
</head>
<body class="bc-white">
	<div class="cms-container">
		<!-- <div class="res-topbar clearfix">
			<div class="sort-nav">
				<a href="javascript:;" class="cur">全部</a> <a href="javascript:;">家长学堂</a>
				<a href="javascript:;">成长路</a> <a href="javascript:;">学能测试</a>
			</div>
			<div class="search">
				<input type="text" class="input-search"> <a
					href="javascript:;" class="btn-search">搜索</a>
			</div>
		</div> -->
		<div class="location">
               <strong>资源库</strong>
        </div>

        <div style="margin-left: 7px">  
        <select id="subjectType" onchange="search() ">
        <option value="1" <c:if test="${param.subjectType == '1' }">selected="selected"</c:if>>家长会</option>
        <option value="0" <c:if test="${param.subjectType == '0' }">selected="selected"</c:if>>分享</option>
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
        筛选资源数：${paging.size }
        </div>
		<div class="cms-main">
			<!-- <div class="res-handle-bar clearfix">
				<a href="minisite/addResoucePage.do" class="btn-add flo-l">+添加</a>
			</div> -->


			<div class="msg-list cms-msg-list">
				<table class="list-t">
					<colgroup>
						<col class="col-01">
						<col class="col-02">
						<col class="col-03">
						<col class="col-04">
						<col class="col-05">
						<col class="col-06">
						<col class="col-07">
						<col class="col-07">
						<col>
					</colgroup>
					<thead>
                        <tr>
                            <th></th>
                            <th></th>
                            <th><div class="td_style">创建时间</div></th>
                            <th><div class="td_bt_style"></div></th>
                            <th><div class="td_bt_style"></div></th>
                            <th><div class="td_bt_style"></div></th>
                            <th><div class="td_bt_style"></div></th>
                            <th><div class="td_bt_style"></div></th>
                            <th><div class="td_bt_style"></div></th>
                        </tr>
                    </thead>
					<tbody id="data_body">
						<c:forEach var="minisites" items="${paging.result }">
							<tr>
								<td>
									<i class="ico ico-${minisites.subjectType}"></i>
								</td>
								<td ><a href="minisite/showModiMinisitePage.do?minisiteId=${minisites.id}">${minisites.taskName_}</a></td>
								<td><div class="td_style">${minisites.createDate }</div></td>
								<td><div class="td_bt_style">
								<c:if test="${minisites.type !=0 }">
									<a href="javascript:openMiniPage('<%=basePath%>xxtM/mPage.do?uri=${minisites.miniUrl }&previewSms=true');" class="btn-push">预览</a>
								</c:if>
								</div></td>
								  
								<td>
									 <div class="td_bt_style">
									<a href="javascript:redirectPush('${minisites.id}','xiaoyuan');" class="btn-push-app">推送至校园+APP</a>
									</div>
								</td>
								<!--  <td>
									<div class="td_bt_style">
									<a href="javascript:redirectPush('${minisites.id}','istudy');" class="btn-push-app">推送至爱学网app</a>
									</div>
								</td>-->
								<td>
									<div class="td_bt_style">
									<a href="javascript:redirectPush('${minisites.id}','xxt');" class="btn-push-app">推送至校讯通APP</a>
									</div>
								</td>
								<td>
									<div class="td_bt_style">
										<a href="javascript:redirectPush('${minisites.id}');" class="btn-push-app">推送至校讯通PC</a>
									</div>
								</td>
								<td>
	                              <c:if test="${minisites.subjectType == '1' }"><div class="td_bt_style"><a href="minisite/showFaqPage.do?minisiteId=${minisites.id}" class="btn-push">FAQ</a></div></c:if>
	                            </td>
								<td>
	                              <div class="td_bt_style"><a href="javascript:deleteMinistite(<c:out value="${minisites.id}" />);" class="btn-delete">删除</a></div>
	                            </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div>
			  <jsp:include page="../paging.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function search(){
	var subjectType = $('#subjectType').val();
	var grade = $('#grade').val();
	window.location.href="/minisite/showPaging.do?target=search_minisite_list&subjectType=" + subjectType + "&grade=" + grade;
}


var power = '<%=session.getAttribute("power")%>';
 
/*  $(document).ready(function(){
	if(power.indexOf("2")){
		$(".btn-push").hide();
	}else{
		alert(power);
	}
	
}) */



function openMiniPage(uri){
	window.open(uri);
}

function redirectPush(id, type){
	if(type == 'xxt'){
		location.href=url_head+"cmsTask/showPushTaskPageForXXT.do?minisiteId="+id;
	} else if(type == 'xiaoyuan'){
		location.href=url_head+"cmsTask/showPushTaskPageForXiaoyuan.do?minisiteId="+id;
	} else if(type == 'istudy'){
		location.href=url_head+"cmsTask/showPushTaskPageForIstudy.do?minisiteId="+id;
	}
	else{
		location.href=url_head+"cmsTask/showPushTaskPage.do?minisiteId="+id;
	}
}
 
function deleteMinistite(id){
	if(!confirm("确定删除该条记录吗")){
		return;
	}
	$.ajax({
  		 type: "POST",
  		 url: "minisite/delMinisite.do",
  		 data: {"minisiteId":id},
  		 dataType: "json",
  		 success: function(obj){
  			 alert(obj.desc);
  			 window.location.reload();
  		 }
  		});  
}

$.paging('minisite_list',"minisite/getPagingData.do",{},function(data){
	var result = data.result,
	innerHtml = "",
	minisites = null,
	currentPage = $('#currentPage'),
	dataBody = $('#data_body');
	for(var i = 0 ;i< result.length;i++){
		minisites = result[i];
		var preview = "";
		if(minisites.type!='0'){
			preview = '<a href="javascript:openMiniPage(\'<%=basePath%>xxtM/mPage.do?uri='+
					minisites.miniUrl+'&previewSms=true\');" class="btn-push">预览</a>';
					 
		}
		innerHtml+='<tr><td><i class="ico ico-'+
		minisites.subjectType+'"></i></td><td><a href="minisite/showModiMinisitePage.do?minisiteId='+
		minisites.id		
				+'">'+
				minisites.taskName_+'</a></td><td><div class="td_style">'+
				minisites.createDate
				+'</div></td><td><div class="td_bt_style">'+
				preview
				+'<td><div class="td_bt_style"><a href="javascript:redirectPush(\''+minisites.id+'\',\'xiaoyuan\');" class="btn-push-app">推送至校园+APP</a></div></td>'
				+'<td><div class="td_bt_style"><a href="javascript:redirectPush(\''+minisites.id+'\',\'xxt\');" class="btn-push-app">推送至校讯通APP</a></div></td>'
				+'</div></td><td><div class="td_bt_style"><a href="javascript:redirectPush('+
		minisites.id+');" class="btn-push-app">推送至校讯通PC</a></div></td><td><div class="td_bt_style">'+
		'<a href="minisite/showModiMinisitePage.do?minisiteId='+
		minisites.id+'" class="btn-push">编辑</a>'
		+'</div></td><td><div class="td_bt_style"><a href="javascript:deleteMinistite('+
		minisites.id+');" class="btn-delete">删除</a></div></td></tr>';
	}
	dataBody.html(innerHtml);
	currentPage.val(data.pageIndex);
});
</script>
</html>