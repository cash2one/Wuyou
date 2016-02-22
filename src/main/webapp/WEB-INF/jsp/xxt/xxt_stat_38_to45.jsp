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
        <h1>5.30推送统计报告</h1>
    </header>
    
    <div class="page-main">
        <article class="analy-item">
        	<section style="padding:2px;">
        		<div style="text-align: right;padding: 5px 10px;"><button id="btn_reflush" onclick="window.location.reload();" style="font-size: 1.1em;width: 4.5em;" >刷新</button></div>
                
        		 <table class="score-table">
                    <caption>【高三】广东省考试院权威解读——影响高考成绩考场细节</caption>
                    <c:forEach var="item" items="${rpt }" begin="0" end="0">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                    <c:forEach var="item" items="${rpt }" begin="10" end="14">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table>
                <table class="score-table">
                    <caption>校讯通公共账号点击情况</caption>
                    <c:forEach var="item" items="${rpt }" begin="15" end="17">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table><br/>
                
                
                
                <table class="score-table">
                    <caption>【高二】高中学业水平考试与期末考“扑面来”，如何应对？</caption>
                    <c:forEach var="item" items="${rpt }" begin="18" end="22">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table>
                
                <table class="score-table">
                    <caption>校讯通公共账号点击情况</caption>
                    <c:forEach var="item" items="${rpt }" begin="23" end="25">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table><br/>
                
               <table class="score-table">
                    <caption>【初三】中考志愿填系列——巧用“重本率”，锁定目标！</caption>
                    <c:forEach var="item" items="${rpt }" begin="26" end="30">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table>
                <table class="score-table">
                    <caption>校讯通公共账号点击情况</caption>
                    <c:forEach var="item" items="${rpt }" begin="31" end="33">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table><br/>
                
                
               <table class="score-table">
                    <caption>【小六】小升初择校，公办民办如何取舍？</caption>
                    <c:forEach var="item" items="${rpt }" begin="34" end="38">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table>
                <table class="score-table">
                    <caption>校讯通公共账号点击情况</caption>
                    <c:forEach var="item" items="${rpt }" begin="39" end="41">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table><br/>  <br/>                
                
                <table class="score-table">
                	<caption><strong>[计划5.31发送]</strong></caption>
                    <caption>【高三】高考前10天最后的提分方法</caption>
                    <c:forEach var="item" items="${rpt }" begin="1" end="6">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table>
                <table class="score-table">
                    <caption>校讯通公共账号点击情况</caption>
                    <c:forEach var="item" items="${rpt }" begin="7" end="9">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table>
                <br/>
                
                
                
                 <table class="score-table">
                	<caption><strong>[计划6.01发送]</strong></caption>
                    <caption>【高三】华师附中三模密卷</caption>
                    <c:forEach var="item" items="${rpt }" begin="42" end="46">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table>
                <table class="score-table">
                    <caption>校讯通公共账号点击情况</caption>
                    <c:forEach var="item" items="${rpt }" begin="47" end="49">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table>
                <br/>
                
                
                
        	</section>
        </article>
    </div>
    <footer class="page-footer">
	    <div class="copyright">
	        <table>
	            <tr>
	                <td>服务提供：</td>
	                <td><img src="<%=basePath%>/img/moble-logo.png" alt="中国移动" width="24" height="24"><span>中国移动</span></td>
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
