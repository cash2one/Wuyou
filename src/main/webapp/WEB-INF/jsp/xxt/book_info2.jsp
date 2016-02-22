<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="xxt_variable_title_header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>家长无忧</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2, user-scalable=yes">
<style type="text/css">
.tb,.tb tr,.tb th,.tb td{border:1px #bebebe solid;padding:10px;}
.th1{width:100px;}
.tb{text-align: center;margin:100px auto;}
</style>
</head>
<body style="background-color: #fff;">
  <div id="page">
    <header class="page-header">
        <h1>报名名单</h1>
    </header>
    
    <div class="page-main">
        <article class="analy-item">
        	<section style="padding:2px;">
        		
        		<table class="tb">
        			<tr>
        				<th class="th1">姓名</th>
        				<th class="th1">手机号码</th>
        				<th class="th1">地址</th>
        				<th class="th1">昵称</th>
        				<th class="th1">用户Id</th>
        				<th class="th1">预约时间</th>
        			</tr>
        			<c:forEach items="${lb }" var="bookInfo">
        				<tr>
        					<td>${bookInfo.name }</td>
        					<td>${bookInfo.phone }</td>
        					<td>${bookInfo.address }</td>
        					<td>${bookInfo.nickName }</td>
        					<td>${bookInfo.uId }</td>
        					<td>${bookInfo.datetime }</td>
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
