<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成绩分析报表</title>
<link rel="stylesheet" href="css/score.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<!--chart -->
<script>
	var API_SERVER = "";
	var IMAGE_SERVER = "";
	var API_KEY = "";
</script>
<script type="text/javascript"
	src="http://www.istudy.com.cn/common/js/baseft.js"></script>
<script type="text/javascript"
	src="http://www.istudy.com.cn/common/js/chart/highcharts.js"></script>
<script type="text/javascript"
	src="http://isa.istudy.com.cn/common/api/mobile_gao1_chart.asp?req_id=${sId}&study_type=${type}&width=100%&height=280"></script>
<!--chart -->
</head>
<body>
	<div id="page">
		<header class="page-header"> <a
			onclick="window.history.back();" class="nav">返回</a>
		<h1 class="mar-l">家长无忧</h1>
		<img src="img/logo.png" alt="爱学网" width="88" height="40" class="logo">
		</header>
		<div class="page-main">
			<h2>
				分班后
				<c:if test="${type==1}">文科</c:if>
				<c:if test="${type==2}">理科</c:if>
				成绩报告
			</h2>
			<article class="art-main"> <section>
			<table class="fore-table">
				<tr>
					<th>预测分班后<c:if test="${type==1}">文科</c:if>
						<c:if test="${type==2}">理科</c:if>全级排名
					</th>
					<th>预测广东省排名</th>
					<th>预测广东省层次</th>
					<th rowspan="2">你的名次超过了广东省<strong id="gd_rate">67</strong>%考生
					</th>
				</tr>
				<tr>
					<td><em id="rank">22</em></td>
					<td><em id="gd_rank">5289</em></td>
					<td id="gd_grade">一本</td>
				</tr>
			</table>
			</section> <section>
			<div class="chartViewBox"
				style="height: 600px; padding-top: 13px; overflow: hidden">
				<div id="container"></div>
			</section> </article>
		</div>
	</div>


</body>
<script type="text/javascript">
	$
			.ajax({
				type : "GET",
				url : "http://isa.istudy.com.cn/common/api/mobile_gao1_report_json.asp?req_id=${sId}",
				dataType : "jsonp",
				jsonp : "jsoncallback",
				success : function(result) {
					var results = result[0].results;
					if (results.length > 0) {
						var rt = result[0].results[0];
						if ('${type}' == '1') {
							$('#gd_rate').html(rt.gd_wenke_rate);
							$('#rank').html(rt.wenke_rank2);
							$('#gd_rank').html(rt.gd_wenke_rank);
							$('#gd_grade').html(rt.gd_wenke_grade);
						} else {
							$('#gd_rate').html(rt.gd_like_rate);
							$('#rank').html(rt.like_rank2);
							$('#gd_rank').html(rt.gd_like_rank);
							$('#gd_grade').html(rt.gd_like_grade);
						}
					} else {
						alert('学生Id错误');
					}

				},
				error : function(result, status) {
					alert(result);
					alert(status);
				}
			});
</script>
</html>
