<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="xxt_variable_title_header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>家长无忧</title>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2, user-scalable=yes"> -->
<style type="text/css">
.tb,.tb tr,.tb th,.tb td{border:1px #bebebe solid;padding:10px;word-break:break-all; word-wrap:break-word;}
td{width:100px;}
.th1{width:100px;}
.th2{width:200px;}
.tb{text-align: center;width:2600px;}
</style>
</head>
<body style="background-color: #fff;">
  <div id="page">
    <header class="page-header">
        <h1>桃李杯舞蹈大赛报名详情</h1>
    </header>
    
    <div class="page-main">
        <article class="analy-item">
        	<section style="padding:10px 0;overflow:auto;">
        		<table class="tb">
        			<tr>
        				<th class="th1">姓名</th>
        				<th class="th1">性别</th>
        				<th class="th1">出生日期</th>
        				<th class="th1">身份证号码</th>
        				<th class="th1">学校名称</th>
        				<th class="th1">联系电话</th>
        				<th class="th1">通讯地址</th>
        				<th class="th1">E-mail</th>
        				<th class="th1">地区</th>
        				<th class="th1">国籍</th>
        				<th class="th1">类型</th>
        				<th class="th2">曾获奖项及年份</th>
        				<th class="th2">最高考级名称及级别</th>
        				<th class="th2">指导老师姓名</th>
        				<th class="th2">指导老师电话</th>
        				<th class="th2">指导老师E-mail</th>
        				<th class="th1">舞蹈名称</th>
        				<th class="th1">节目时长</th>
        				<th class="th1">选送单位</th>
        				<th class="th1">组别</th>
        				<th class="th1">舞蹈类型</th>
        				<th class="th1">参赛形式</th>
        				<th class="th1">群舞人数</th>
        				<th class="th1">报名时间</th>
        			</tr>
        			<c:forEach items="${listTLB }" var="info">
        				<tr>
        					<td>${info.name }</td>
        					<td>${info.sex }</td>
        					<td>${info.birth }</td>
        					<td>${info.id }</td>
        					<td>${info.school }</td>
        					<td>${info.phone }</td>
        					<td>${info.address }</td>
        					<td>${info.email }</td>
        					<td>${info.area }</td>
        					<td>${info.country }</td>
        					<td>${info.type }</td>
        					<td>${info.prize }</td>
        					<td>${info.level }</td>
        					<td>${info.teacherName }</td>
        					<td>${info.teacherPhone }</td>
        					<td>${info.teacherEmail }</td>
        					<td>${info.dance }</td>
        					<td>${info.t }</td>
        					<td>${info.select2 }</td>
        					<td>${info.proGroup }</td>
        					<td>${info.proDance }</td>
        					<td>${info.proType }</td>
        					<td>${info.proNum }</td>
        					<td>${info.time }</td>
        				</tr>
        			</c:forEach>
        		</table>
                
                
        	</section>
        </article>
    </div>
    <footer class="page-footer">
	    <div class="copyright">
	        <table>
	            <tr>
	                <td>服务提供：</td>
	                <td><img src="<%=basePath%>/img/i-logo-footer.png" alt="istudy" width="30" height="24"><span>华附在线（爱学网）</span></td>
	            </tr>
	        </table>
	    </div>
	</footer>
</div>
<script type="text/javascript">
var tlb = ${listTLB};
console.log()
var btn_reflush = document.getElementById("btn_reflush");
var total = 5;
btn_reflush.disabled = true;
btn_reflush.innerText = "" + total + ".0";

var handler = setInterval(function(){
	total = Math.round((total - 0.1) * 10) / 10;
	if(total <= 0){
		btn_reflush.disabled = false;
		btn_reflush.innerText = "刷 新";
		clearInterval(handler);
		return;
	}
	var text = total;
	if((text + "").indexOf(".") == -1){
		text = text + ".0";
	}
	btn_reflush.innerText = "" + text;
}, 100);
</script>
</body>
</html>
