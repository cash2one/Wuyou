<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<%@include file="../minisite_common.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-vedioplay-${ subject }&${ queryStr }" width="0" height="0" style="display: none;"/>

<html>
<head>
<base href="<%=basePath%>">
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.5, user-scalable=yes"/>
<link rel="stylesheet" href="<%=basePath%>/css/minisite_layout.css?v3.2">
<style>
    html,body{height:100%;}
    .page-footer{position:absolute;bottom:0;width:100%;}
</style>
</head>
<body>
<div id="page">
    <header class="page-header">
        <a href="javascript:history.go(-1);" class="back">返回</a>
        <h1>视频观看</h1>
    </header>
    <div class="page-main">
        <div class="s-video">
        	<c:if test="${subject == 'yw' }">
        		<h2>语文&nbsp;&nbsp;华师附中老师&nbsp;&nbsp;张诚</h2>
	            <div class="s-video-main">
	            <script type="text/javascript">
					if(/MSIE/.test(window.navigator.userAgent)){
						document.write("<script src=\"http://p.bokecc.com/player?vid=303296D953ECA7179C33DC5901307461&siteid=440D049584AEB42E&autoStart=false&width=100%&height=180&playerid=D30050EE4A19E1BF&playertype=1\" type=\"text/javascript\"><\/script>");
                     }else{
                     	document.write("<script src=\"http://p.bokecc.com/player?vid=303296D953ECA7179C33DC5901307461&siteid=440D049584AEB42E&autoStart=false&width=100%&height=&playerid=D30050EE4A19E1BF&playertype=1\" type=\"text/javascript\"><\/script>");
                     }
				</script>
	            </div>
        	</c:if>
        	<c:if test="${subject == 'dl' }">
        		<h2>地理&nbsp;&nbsp;华师附中老师&nbsp;&nbsp;刘玉涵</h2>
	            <div class="s-video-main">
					<script type="text/javascript">
					if(/MSIE/.test(window.navigator.userAgent)){
						document.write("<script src=\"http://p.bokecc.com/player?vid=75A88C3A58CF00D69C33DC5901307461&siteid=440D049584AEB42E&autoStart=false&width=100%&height=180&playerid=D30050EE4A19E1BF&playertype=1\" type=\"text/javascript\"><\/script>");
                     }else{
                     	document.write("<script src=\"http://p.bokecc.com/player?vid=75A88C3A58CF00D69C33DC5901307461&siteid=440D049584AEB42E&autoStart=false&width=100%&height=&playerid=D30050EE4A19E1BF&playertype=1\" type=\"text/javascript\"><\/script>");
                     }
                    </script>
	            </div>
        	</c:if>
        	<c:if test="${subject == 'ls' }">
        		<h2>历史&nbsp;&nbsp;华师附中老师&nbsp;&nbsp;黄永友</h2>
	            <div class="s-video-main">
					<script type="text/javascript">
					if(/MSIE/.test(window.navigator.userAgent)){
						document.write("<script src=\"http://p.bokecc.com/player?vid=02E92760916AE4149C33DC5901307461&siteid=440D049584AEB42E&autoStart=false&width=100%&height=180&playerid=D30050EE4A19E1BF&playertype=1\" type=\"text/javascript\"><\/script>");
                     }else{
                     	document.write("<script src=\"http://p.bokecc.com/player?vid=02E92760916AE4149C33DC5901307461&siteid=440D049584AEB42E&autoStart=false&width=100%&height=&playerid=D30050EE4A19E1BF&playertype=1\" type=\"text/javascript\"><\/script>");
                     }
                    </script>
	            </div>
        	</c:if>
        	<c:if test="${subject == 'sw' }">
        		<h2>生物&nbsp;&nbsp;华师附中老师&nbsp;&nbsp;贺建</h2>
	            <div class="s-video-main">
					<script type="text/javascript">
					if(/MSIE/.test(window.navigator.userAgent)){
						document.write("<script src=\"http://p.bokecc.com/player?vid=3C3356006DC984C49C33DC5901307461&siteid=440D049584AEB42E&autoStart=false&width=100%&height=180&playerid=D30050EE4A19E1BF&playertype=1\" type=\"text/javascript\"><\/script>");
                     }else{
                     	document.write("<script src=\"http://p.bokecc.com/player?vid=3C3356006DC984C49C33DC5901307461&siteid=440D049584AEB42E&autoStart=false&width=100%&height=&playerid=D30050EE4A19E1BF&playertype=1\" type=\"text/javascript\"><\/script>");
                     }
                    </script>
	            </div>
        	</c:if>
        </div>
    </div>
    <footer class="page-footer">
        <div class="sf-footer">
            <span class="cap">服务提供：</span>
            <span class="list">
                <img src="<%=basePath%>/img/moble-logo.png" alt="中国移动" width="24" height="24"><span>中国移动</span>
            </span>
            <span class="list">
                <img src="<%=basePath%>/img/ico-logo.png" alt="istudy" width="30" height="24"><span>华附在线（爱学网）</span>
            </span>
        </div>
    </footer>
</div>
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.10.2.js"></script>
</body>
</html>
