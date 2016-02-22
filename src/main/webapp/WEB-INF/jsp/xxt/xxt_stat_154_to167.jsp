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
        		<div style="text-align: right;padding: 5px 10px;"><button id="btn_reflush" onclick="window.location.reload();" style="font-size: 1.1em;width: 4.5em;" >刷新</button></div>
        		<table class="score-table">
                    <caption>【小二】三大家长常犯错误易致孩子成绩下滑</caption>
                    <c:forEach var="item" items="${rpt }" begin="0" end="5">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
        		<table class="score-table">
                    <caption>校讯通公共账号点击情况</caption>
                    <c:forEach var="item" items="${rpt }" begin="6" end="8">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
            
                <table class="score-table">
                    <caption>【小五】小学你应该带孩子旅行的6大景点</caption>
                    <c:forEach var="item" items="${rpt }" begin="9" end="13">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>校讯通公共账号点击情况</caption>
                    <c:forEach var="item" items="${rpt }" begin="14" end="16">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>【小六】新初一需知的广州中考概况</caption>
                    <c:forEach var="item" items="${rpt }" begin="17" end="21">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>校讯通公共账号点击情况</caption>
                    <c:forEach var="item" items="${rpt }" begin="22" end="24">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                
                <table class="score-table">
                    <caption>【初二】与叛逆期孩子沟通的几个误区</caption>
                    <c:forEach var="item" items="${rpt }" begin="25" end="29">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>校讯通公共账号点击情况</caption>
                    <c:forEach var="item" items="${rpt }" begin="30" end="32">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                
                <table class="score-table">
                    <caption>【初三】新高一生不得不知的高中规划</caption>
                    <c:forEach var="item" items="${rpt }" begin="33" end="37">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>校讯通公共账号点击情况</caption>
                    <c:forEach var="item" items="${rpt }" begin="38" end="40">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                
               <%--  <table class="score-table">
                    <caption>如何利用高二期末考，为高考初定目标</caption>
                    <c:forEach var="item" items="${rpt }" begin="41" end="45">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>校讯通公共账号点击情况</caption>
                    <c:forEach var="item" items="${rpt }" begin="46" end="48">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br> --%>
                
                
                <table class="score-table">
                    <caption>【高一】如何利用暑假实现“弯道超车”？</caption>
                    <c:forEach var="item" items="${rpt }" begin="41" end="45">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>校讯通公共账号点击情况</caption>
                    <c:forEach var="item" items="${rpt }" begin="46" end="48">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                
                
                <table class="score-table">
                    <caption>【高二】高三新生 职业规划事不宜迟</caption>
                    <c:forEach var="item" items="${rpt }" begin="49" end="53">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>校讯通公共账号点击情况</caption>
                    <c:forEach var="item" items="${rpt }" begin="54" end="56">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                
                
                
                
                
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
