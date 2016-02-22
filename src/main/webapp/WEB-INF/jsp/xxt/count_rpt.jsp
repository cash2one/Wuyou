<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2, user-scalable=yes">
<style>
body,h1,h2,h3,h4,h5,h6,dl,dd,ul,ol,p,blockquote,form,fieldset,figure{margin:0;}
ul,ol,menu,th,td,legend,fieldset{padding:0;}
article,aside,details,figcaption,figure,footer,header,hgroup,menu,nav,section{display:block;}
html{font:62.5%/1.5 arial, "\5B8B\4F53", sans-serif;}
body{font-size:1.4em;color:#333;}
input,textarea,button{font:1em arial, "\5B8B\4F53", sans-serif;}
ul,ol,menu{list-style-type:none;}
table{border-spacing:0;border-collapse:collapse;}
fieldset{border:none;}
blockquote,q{quotes:none;}
blockquote:before,blockquote:after,q:before,q:after{content:"";}
a{text-decoration:none;outline:0 none;color:#444;cursor:pointer;}
a:hover,a:active{text-decoration:underline;color:#00aff0;}
#page{}
.page-header{padding:15px;}
.page-header .date{font-size:1.2em;}
.page-header button{margin-left:15px;padding:5px 15px;}

.table{margin-bottom:2em;width:100%;}
.table caption{padding:5px 0;background-color:#00aff0;font-size:1.2em;font-weight:bold;color:#fff;}
.table th, .table td{padding:5px 2px;border:1px solid #666;text-align:center;}
</style>
</head>
<body>
	<div id="page">
		<div class="page-header">
			<span class="date" id="data">
			<c:if test="${type== '1' }">
			${today }
			</c:if>
			<c:if test="${type== '2' }">
			${yesterday }
			</c:if>
			<c:if test="${type== '3' }">
			${beginDay } ~ ${today }
			</c:if>
			</span>
			<button type="button" id="btnToday">今天</button>
			<button type="button" id="btnYesterday">昨天</button>
			<button type="button" id="btnSevenDay">最近7天</button>
		</div>
		<table class="table">
			<caption>渠道来源转化</caption>
			<thead>
				<tr>
					<th>渠道</th><th>打开链接次数</th><th>下载次数</th>
				</tr>
			</thead>
			<tbody id="channelTable">
				<tr>
					<td>主站</td>
					<c:if test="${empty channelCount['site']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty channelCount['site']}">
					<td>${not empty channelCount['site'].click? channelCount['site'].click : 0}</td>
					<td>${not empty channelCount['site'].download? channelCount['site'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td>用户邀请（分享）</td>
					<c:if test="${empty channelCount['ushare']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty channelCount['ushare']}">
					<td>${not empty channelCount['ushare'].click? channelCount['ushare'].click : 0}</td>
					<td>${not empty channelCount['ushare'].download? channelCount['ushare'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td>公司内部邀请</td>
					<c:if test="${empty channelCount['ishare']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty channelCount['ishare']}">
					<td>${not empty channelCount['ishare'].click? channelCount['ishare'].click : 0}</td>
					<td>${not empty channelCount['ishare'].download? channelCount['ishare'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td>自有渠道（现场）</td>
					<c:if test="${empty channelCount['iscene']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty channelCount['iscene']}">
					<td>${not empty channelCount['iscene'].click? channelCount['iscene'].click : 0}</td>
					<td>${not empty channelCount['iscene'].download? channelCount['iscene'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td>自有渠道（无忧）</td>
					<c:if test="${empty channelCount['iwuyou']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty channelCount['iwuyou']}">
					<td>${not empty channelCount['iwuyou'].click? channelCount['iwuyou'].click : 0}</td>
					<td>${not empty channelCount['iwuyou'].download? channelCount['iwuyou'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td>校讯通渠道（现场）</td>
					<c:if test="${empty channelCount['xscene']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty channelCount['xscene']}">
					<td>${not empty channelCount['xscene'].click? channelCount['xscene'].click : 0}</td>
					<td>${not empty channelCount['xscene'].download? channelCount['xscene'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td>校讯通渠道（无忧）</td>
					<c:if test="${empty channelCount['xwuyou']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty channelCount['xwuyou']}">
					<td>${not empty channelCount['xwuyou'].click? channelCount['xwuyou'].click : 0}</td>
					<td>${not empty channelCount['xwuyou'].download? channelCount['xwuyou'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td>二维码校内推广</td>
					<c:if test="${empty channelCount['qrcode']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty channelCount['qrcode']}">
					<td>${not empty channelCount['qrcode'].click? channelCount['qrcode'].click : 0}</td>
					<td>${not empty channelCount['qrcode'].download? channelCount['qrcode'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td>老师短信推广</td>
					<c:if test="${empty channelCount['tshare']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty channelCount['tshare']}">
					<td>${not empty channelCount['tshare'].click? channelCount['tshare'].click : 0}</td>
					<td>${not empty channelCount['tshare'].download? channelCount['tshare'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td>自由渠道订阅</td>
					<c:if test="${empty channelCount['udingyue']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty channelCount['udingyue']}">
					<td>${not empty channelCount['udingyue'].click? channelCount['udingyue'].click : 0}</td>
					<td>${not empty channelCount['udingyue'].download? channelCount['udingyue'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td>研发中心学校推广渠道</td>
					<c:if test="${empty channelCount['ikfzx']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty channelCount['ikfzx']}">
					<td>${not empty channelCount['ikfzx'].click? channelCount['ikfzx'].click : 0}</td>
					<td>${not empty channelCount['ikfzx'].download? channelCount['ikfzx'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td>话题详情短信推广</td>
					<c:if test="${empty channelCount['msght']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty channelCount['msght']}">
					<td>${not empty channelCount['msght'].click? channelCount['msght'].click : 0}</td>
					<td>${not empty channelCount['msght'].download? channelCount['msght'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<th>总计</th>
					<c:set var="sum" value="0"></c:set>
					<td><c:forEach items="channelCount" var="ac">${sum }</c:forEach></td>
					<td>${not empty channelCount['fengyi'].download? channelCount['fengyi'].download : 0}</td>
				</tr>
			</tbody>
		</table>
		
		<table class="table">
			<caption>无忧推送来源转化</caption>
			<thead>
				<tr>
					<th>无忧页面内容</th><!-- <th>短信类型</th><th>短信发送数量</th> --><th>打开链接次数</th><!-- <th>链接点击率</th> --><th>下载次数</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rpt }" var="items">
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
		
		<table class="table">
			<caption>公司部门渠道来源转化</caption>
			<thead>
				<tr>
					<th>部门名称</th><th>打开链接次数</th><th>下载次数</th>
				</tr>
			</thead>
			<tbody id="companyChannelTable">
				<%-- <c:forEach var="item" items="${innerCount }">
				<tr>
					<td>${item.channel}</td><td>${item.click}</td><td>${empty item.download ? 0 : item.download}</td>
				</tr>
				</c:forEach> --%>
				<tr>
					<td>总裁办</td>
					<c:if test="${empty innerCount['1001']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty innerCount['1001']}">
					<td>${not empty innerCount['1001'].click? innerCount['1001'].click : 0}</td>
					<td>${not empty innerCount['1001'].download? innerCount['1001'].download : 0}</td>
					</c:if>
					
				</tr>
				<tr>
					<td> 行政人事财务部</td>
					<c:if test="${empty innerCount['1002']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty innerCount['1002']}">
					<td>${not empty innerCount['1002'].click? innerCount['1002'].click : 0}</td>
					<td>${not empty innerCount['1002'].download? innerCount['1002'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td>互联网事业部</td>
					<c:if test="${empty innerCount['1003']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty innerCount['1003']}">
					<td>${not empty innerCount['1003'].click ? innerCount['1003'].click : 0}</td>
					<td>${not empty innerCount['1003'].download ? innerCount['1003'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td>事业拓展部</td>
					<c:if test="${empty innerCount['1004']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty innerCount['1004']}">
					<td>${not empty innerCount['1004'].click? innerCount['1004'].click : 0}</td>
					<td>${not empty innerCount['1004'].download? innerCount['1004'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td> 战略资源部</td>
					<c:if test="${empty innerCount['1005']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty innerCount['1005']}">
					<td>${not empty innerCount['1005'].click? innerCount['1005'].click : 0}</td>
					<td>${not empty innerCount['1005'].download? innerCount['1005'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td>爱学堂事业部</td>
					<c:if test="${empty innerCount['1006']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty innerCount['1006']}">
					<td>${not empty innerCount['1006'].click? innerCount['1006'].click : 0}</td>
					<td>${not empty innerCount['1006'].download? innerCount['1006'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<td>冯颐</td>
					<c:if test="${empty innerCount['1007']}">
					<td>0</td>
					<td>0</td>
					</c:if>
					<c:if test="${not empty innerCount['1007']}">
					<td>${not empty innerCount['1007'].click? innerCount['1007'].click : 0}</td>
					<td>${not empty innerCount['1007'].download? innerCount['1007'].download : 0}</td>
					</c:if>
				</tr>
				<tr>
					<th>总计</th>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript">
	(function(w, d) {
		var today = d.getElementById("btnToday"),
			yesterday = d.getElementById("btnYesterday"),
			sevenDay = d.getElementById("btnSevenDay");
		
		function openHref(type) {
			window.location.href="<%=basePath%>" + "/xxtStat/channelRpt.do?type=" + type;
		}
		
		today.onclick = function() {
			openHref(1);
		}
		
		yesterday.onclick = function() {
			openHref(2);
		}
		
		sevenDay.onclick = function() {
			openHref(3);
		}
	}(window, document));

	(function(w, d) {
		
		function count(ele) {
			var channelTable = d.getElementById(ele),
				channelTableTr = channelTable.getElementsByTagName("tr");
			
			var countOpen = 0,
				countDownload = 0,
				i = 0,
				length = channelTableTr.length;
			
			for(; i < length - 1; i++) {
				var tdItem = channelTableTr[i].getElementsByTagName("td");
				
				var openTd = tdItem[1],
					downloadTd = tdItem[2];
				
				countOpen += parseInt(openTd.childNodes[0].nodeValue, 10);
				countDownload += parseInt(downloadTd.childNodes[0].nodeValue, 10);
			}
			
			var lastTr = channelTableTr[length - 1],
				lastTrChild = lastTr.getElementsByTagName("td");
			
			lastTrChild[0].innerHTML = countOpen;
			lastTrChild[1].innerHTML = countDownload;
		}
		
		count("channelTable");
		
		count("companyChannelTable");
	}(window, document));
</script>
</html>
