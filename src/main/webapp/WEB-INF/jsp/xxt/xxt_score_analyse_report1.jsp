<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>家长无忧-成绩报告</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<link rel="stylesheet" href="css/score.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
</head>
<body>
	<div id="page">
		<header class="page-header">
		<h1>家长无忧</h1>
		<img src="img/logo.png" alt="爱学网" width="88" height="40"
			class="logo"> </header>
		<div class="page-main">
			<h2>成绩报告</h2>
			<article class="art-main">                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
			<section>
			<table class="score-table ta-c">
				<colgroup class="score-col">
					<col>
					<col>
					<col>
				</colgroup>
				<thead>
					<tr>
						<td>科目</td>
						<td>分数</td>
						<td>年级排名</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>总分</td>
						<td>920</td>
						<td id="total_rank"></td>
					</tr>
					<tr>
						<td>语文</td>
						<td>110</td>
						<td id="yuwen_rank"></td>
					</tr>
					<tr>
						<td>数学</td>
						<td>110</td>
						<td id="shuxue_rank"></td>
					</tr>
					<tr>
						<td>英语</td>
						<td>110</td>
						<td id="yingyu_rank"></td>
					</tr>
					<tr>
						<td>物理</td>
						<td>110</td>
						<td id="wuli_rank"></td>
					</tr>
					<tr>
						<td>化学</td>
						<td>110</td>
						<td id="huaxue_rank"></td>
					</tr>
					<tr>
						<td>生物</td>
						<td>110</td>
						<td id="shengwu_rank"></td>
					</tr>
					<tr>
						<td>政治</td>
						<td>110</td>
						<td id="zhengzhi_rank"></td>
					</tr>
					<tr>
						<td>历史</td>
						<td>110</td>
						<td id="lishi_rank"></td>
					</tr>
					<tr>
						<td>地理</td>
						<td>110</td>
						<td id="dili_rank"></td>
					</tr>
				</tbody>
			</table>
			</section>
			<section>
			<table class="score-table ran-rep-tab">
				<thead>
					<tr>
						<td>分类</td>
						<td>当前位置/总人数</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>总分在年级中的位置</td>
						<td id="total_rank_"></td>
					</tr>
					<tr>
						<td>理科在年级中的位置</td>
						<td id="like_rank1"></td>
					</tr>
					<tr>
						<td>文科在年级中的位置</td>
						<td id="wenke_rank1"></td>
					</tr>
					<tr>
						<td><a href="xxtM/showScoreReport2.do?type=2&sId=${sId}">预测分班后理科全级排名 &rsaquo;</a></td>
						<td id="like_rank2"></td>
					</tr>
					<tr>
						<td><a href="xxtM/showScoreReport2.do?type=1&sId=${sId}">预测分班后文科全级排名 &rsaquo;</a></td>
						<td id="wenke_rank2"></td>
					</tr>
				</tbody>
			</table>
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
						$('#total_rank').html(rt.total_rank);
						$('#yuwen_rank').html(rt.yuwen_rank);
						$('#shuxue_rank').html(rt.shuxue_rank);
						$('#yingyu_rank').html(rt.yingyu_rank);
						$('#wuli_rank').html(rt.wuli_rank);
						$('#huaxue_rank').html(rt.huaxue_rank);
						$('#shengwu_rank').html(rt.shengwu_rank);
						$('#zhengzhi_rank').html(rt.zhengzhi_rank);
						$('#lishi_rank').html(rt.lishi_rank);
						$('#dili_rank').html(rt.dili_rank);
						$('#total_rank_').html(rt.total_rank+"/"+rt.school_total_count);
						$('#like_rank1').html(rt.like_rank1+"/"+rt.school_total_count);
						$('#wenke_rank1').html(rt.wenke_rank1+"/"+rt.school_total_count);
						$('#like_rank2').html(rt.like_rank2+"/"+rt.school_total_count);
						$('#wenke_rank2').html(rt.wenke_rank2+"/"+rt.school_total_count);
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
