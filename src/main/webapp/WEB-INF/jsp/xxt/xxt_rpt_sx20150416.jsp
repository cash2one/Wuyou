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
                    <caption>幼儿园小班、中班、大班校讯通家长用户<br>宝宝学才艺，专家有话说！</caption>
                    <c:forEach var="item" items="${rpt }" begin="0" end="2">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
        		<table class="score-table">
                    <caption>小学一、二年级<br>妈妈，帮我检查作业吧！</caption>
                    <c:forEach var="item" items="${rpt }" begin="3" end="4">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
            
                <table class="score-table">
                    <caption>小学三、四年级<br>告别磨蹭!五大技巧让孩子“快”起来！</caption>
                    <c:forEach var="item" items="${rpt }" begin="5" end="6">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>小学五年级<br>五年级——影响孩子一生的关键期</caption>
                    <c:forEach var="item" items="${rpt }" begin="7" end="8">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                
                <table class="score-table">
                    <caption>小学六年级<br>备战小升初，如何应战语数外，你了解吗？</caption>
                    <c:forEach var="item" items="${rpt }" begin="9" end="10">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>初一<br>巧做笔记，赢在初一！</caption>
                    <c:forEach var="item" items="${rpt }" begin="11" end="12">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                
                <table class="score-table">
                    <caption>初二<br>初二，让你从此不再偏科的5个技巧</caption>
                    <c:forEach var="item" items="${rpt }" begin="13" end="14">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>初三家长用户<br>中考冲刺，各科如何迅速“补短”？</caption>
                    <c:forEach var="item" items="${rpt }" begin="15" end="16">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                
                <table class="score-table">
                    <caption>高一家长用户<br>家长必读！孩子选“文”or“理”？ </caption>
                    <c:forEach var="item" items="${rpt }" begin="17" end="18">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>高二家长用户<br>高二这样学英语，想不得高分都难！</caption>
                    <c:forEach var="item" items="${rpt }" begin="19" end="20">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>高三家长用户<br>二模前，是时候操心填报志愿的事了！  </caption>
                    <c:forEach var="item" items="${rpt }" begin="21" end="22">
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
