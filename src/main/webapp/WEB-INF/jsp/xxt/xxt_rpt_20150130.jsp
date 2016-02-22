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
                    <caption>【校讯通】【小班】【中班】【大班】寒假防骗是关键，骗局要知怎破解</caption>
                    <c:forEach var="item" items="${rpt }" begin="0" end="4">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
        		<table class="score-table">
                    <caption>【校园+】【小班】【中班】【大班】寒假防骗是关键，骗局要知怎破解</caption>
                    <c:forEach var="item" items="${rpt }" begin="5" end="6">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
            
                <table class="score-table">
                    <caption>【校讯通】【小一】【小二】专家教你私人定制“超长寒假”</caption>
                    <c:forEach var="item" items="${rpt }" begin="7" end="10">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>【校园+】【小一】【小二】专家教你私人定制“超长寒假”</caption>
                    <c:forEach var="item" items="${rpt }" begin="11" end="12">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                
                <table class="score-table">
                    <caption>【校讯通】【小三】【小四】专家教你私人定制“超长寒假”</caption>
                    <c:forEach var="item" items="${rpt }" begin="13" end="16">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>【校园+】【小三】【小四】专家教你私人定制“超长寒假”</caption>
                    <c:forEach var="item" items="${rpt }" begin="17" end="18">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                
                <table class="score-table">
                    <caption>【校讯通】【小五】【小六】专家教你私人定制“超长寒假”</caption>
                    <c:forEach var="item" items="${rpt }" begin="19" end="22">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>【校园+】【小五】【小六】专家教你私人定制“超长寒假”</caption>
                    <c:forEach var="item" items="${rpt }" begin="23" end="24">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                
                <table class="score-table">
                    <caption>【校讯通】【初一】为何爱读书的都是别人家的孩子！</caption>
                    <c:forEach var="item" items="${rpt }" begin="25" end="28">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>【校园+】【初一】为何爱读书的都是别人家的孩子！</caption>
                    <c:forEach var="item" items="${rpt }" begin="29" end="30">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                
                <table class="score-table">
                    <caption>【校讯通】【初二】寒假2小时黄金学习法</caption>
                    <c:forEach var="item" items="${rpt }" begin="31" end="34">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>【校园+】【初二】寒假2小时黄金学习法</caption>
                    <c:forEach var="item" items="${rpt }" begin="35" end="36">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>【校讯通】【初三】测一测，孩子中考提升的潜力有多大</caption>
                    <c:forEach var="item" items="${rpt }" begin="37" end="40">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                <table class="score-table">
                    <caption>【校园+】【初三】测一测，孩子中考提升的潜力有多大</caption>
                    <c:forEach var="item" items="${rpt }" begin="41" end="42">
                    	<tr>
		                	<th style="width: 70%">${item.key }</th>
	                        <td><strong>${item.value }</strong></td>
                    	</tr>
                    </c:forEach>
                </table></br>
                
                
                <table class="score-table">
                    <caption>【校讯通】【高三】测一测，孩子中考提升的潜力有多大</caption>
                    	<tr>
		                	<th style="width: 70%">发送总数</th>
	                        <td><strong>167154</strong></td>
                    	</tr>
                    	<tr>
		                	<th style="width: 70%">点击链接人数</th>
	                        <td><strong>2135</strong></td>
                    	</tr>
                    	<tr>
		                	<th style="width: 70%">链接打开率</th>
	                        <td><strong>1.28%</strong></td>
                    	</tr>
                    	<tr>
		                	<th style="width: 70%">点击下载人数</th>
	                        <td><strong>191</strong></td>
                    	</tr>
                </table></br>
                
                <table class="score-table">
                    <caption>【校园+】【高三】测一测，孩子中考提升的潜力有多大</caption>
                    	<tr>
		                	<th style="width: 70%">点击链接人数</th>
	                        <td><strong>267</strong></td>
                    	</tr>
                    	<tr>
		                	<th style="width: 70%">点击下载人数</th>
	                        <td><strong>21</strong></td>
                    	</tr>
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
