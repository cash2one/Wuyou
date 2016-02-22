<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="xxt_variable_title_header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>家长无忧</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2, user-scalable=yes">
</head>
<body style="background-color: #fff;">
  <div id="page">
    <header class="page-header">
        <h1>推送统计报告</h1>
    </header>
    
    <div class="page-main">
        <article class="analy-item">
        	<section style="padding:2px;">
        	<table class="table" border="1">
        	<tbody id="companyChannelTable">
        		<c:forEach items="${rpt }" var="items">
        		 ${items.idtype } 
        		${items.click }
        		${items.download }
        		${items.datetime }
        		<br> 
        			<c:if test="${items.idtype == 1}">
        			<tr>
        			<td>测试1 ${items.datetime }</td>
					<td>${items.click }</td>
					<td>${not empty items.download? items.download : 0}</td>
					</tr>
					</c:if>
					
					<c:if test="${items.idtype == 2}">
        			<tr>
        			<td>测试2 ${items.datetime }</td>
					<td>${items.click }</td>
					<td>${not empty items.download? items.download : 0}</td>
					</tr>
					</c:if>
					
					<c:if test="${items.idtype == 3}">
        			<tr>
        			<td>测试3 ${items.datetime }</td>
					<td>${items.click }</td>
					<td>${not empty items.download? items.download : 0}</td>
					</tr>
					</c:if>
					
					<c:if test="${items.idtype == 4}">
        			<tr>
        			<td>测试4 ${items.datetime }</td>
					<td>${items.click }</td>
					<td>${not empty items.download? items.download : 0}</td>
					</tr>
					</c:if>
					
					<c:if test="${items.idtype == 5}">
        			<tr>
        			<td>测试5 ${items.datetime }</td>
					<td>${items.click }</td>
					<td>${not empty items.download? items.download : 0}</td>
					</tr>
					</c:if>
					
					<c:if test="${items.idtype == 6}">
        			<tr>
        			<td>测试6 ${items.datetime }</td>
					<td>${items.click }</td>
					<td>${not empty items.download? items.download : 0}</td>
					</tr>
					</c:if>
					
					<c:if test="${items.idtype == 7}">
        			<tr>
        			<td>测试7 ${items.datetime }</td>
					<td>${items.click }</td>
					<td>${not empty items.download? items.download : 0}</td>
					</tr>
					</c:if>

        		</c:forEach>
        		</tbody>
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
