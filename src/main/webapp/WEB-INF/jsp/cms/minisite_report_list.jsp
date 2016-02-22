<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>minisite统计列表</title>
<link rel="stylesheet" href="css/layout.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/istudy-cms.js"></script>
<style type="text/css">
.msg-list td{color: #000;}
.sort{padding: 0 6px;}
.sort:HOVER{text-decoration: none;}
</style>
</head>
<body class="bc-white">
	<div class="cms-container">
		<div class="location">
               <strong>统计报表</strong>
        </div>
		<div class="cms-main">
			<div class="msg-list cms-msg-list">
				<table class="list-t">
					<colgroup>
						<col class="col-01">
						<col width="20%">
						<!-- <col> -->
						<col>
						<col>
						<col>
						<col>
					</colgroup>
					<thead>
                        <tr>
                        	<th></th>
                            <th><div>文章</div></th>
                            <!-- <th><div class="ta-c">创建时间</div></th> -->
                            <th><div class="ta-c">点击标题老师数<a href="javascript:sort('teacherActiveCount')" class="sort">${sort == 'teacherActiveCount' ? '▼' : '▽' }</a></div></th>
                            <th><div class="ta-c">发送短信老师数<a href="javascript:sort('teacherPushCount')" class="sort">${sort == 'teacherPushCount' ? '▼' : '▽' }</a></div></th>
                            <th><div class="ta-c">老师发送短信量<a href="javascript:sort('teacherPushMsgTotal')" class="sort">${sort == 'teacherPushMsgTotal' ? '▼' : '▽' }</a></div></th>
                            <th><div class="ta-c">点击短信链接的家长数<a href="javascript:sort('parentEnterCount')" class="sort">${sort == 'parentEnterCount' ? '▼' : '▽' }</a></div></th>
                        </tr>
                    </thead>
					<tbody id="data_body">
						<c:forEach var="report" items="${paging.result }">
							<tr>
								<td><i class="ico ico-${report.subjectType}"></i></td>
								<td><a title="预览" target="_blank"
									href="<%=basePath%>xxtM/mPage.do?uri=${report.miniUrl }&previewSms=true">
									${report.miniTitle}</a></td>
								<%-- <td><div class="ta-c">${report.createDate}</div></td>	 --%>
								<td><div class="ta-c">${report.teacherActiveCount}</div></td>
								<td><div class="ta-c">${report.teacherPushCount}</div></td>
								<td><div class="ta-c">${report.teacherPushMsgTotal}</div></td>
								<td><div class="ta-c">${report.parentEnterCount}</div></td>
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

function sort(type){
	window.location.href="<%=basePath%>minisite/showPaging.do?target=minisite_report_list&sort=" + type;
}

function openMiniPage(uri){
	window.open(uri);
}

$.paging('minisite_report_list',"minisite/getPagingData.do",{"sort":'${param.sort}'},function(data){
	var result = data.result,
	innerHtml = new Array(),
	report = null,
	currentPage = $('#currentPage'),
	dataBody = $('#data_body');
	
	for(var i = 0 ;i< result.length;i++){
		report = result[i];

		innerHtml.push('<tr>');
		innerHtml.push('<td><i class="ico ico-'+report.subjectType+'"></i></td>');
		innerHtml.push('<td><a title="预览" target="_blank"');
		innerHtml.push('	href="<%=basePath%>xxtM/mPage.do?uri='+report.miniUrl +'&previewSms=true">');
		innerHtml.push('	'+report.miniTitle +'</a></td>');
		/* innerHtml.push('<td><div class="ta-c">'+report.createDate +'</div></td>'); */
		innerHtml.push('<td><div class="ta-c">'+report.teacherActiveCount +'</div></td>');
		innerHtml.push('<td><div class="ta-c">'+report.teacherPushCount +'</div></td>');
		innerHtml.push('<td><div class="ta-c">'+report.teacherPushMsgTotal +'</div></td>');
		innerHtml.push('<td><div class="ta-c">'+report.parentEnterCount +'</div></td>');
		innerHtml.push('</tr>');
		
	}
	dataBody.html(innerHtml.join(""));
	currentPage.val(data.pageIndex);
});
</script>
</html>