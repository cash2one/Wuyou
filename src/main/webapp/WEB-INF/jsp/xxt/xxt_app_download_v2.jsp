<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<%@include file="../minisite_common.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-xxtdownload&${ queryStr }" width="0" height="0" style="display: none;"/>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.5, user-scalable=yes"/>
<title>校讯通服务升级</title>
<link rel="stylesheet" href="<%=basePath%>/css/minisite_layout.css">
<style>
    html, body{height:100%;}
    .page-footer{position:absolute;width:100%;bottom:0;}
</style>
</head>
<body>

<div id="page">
    <header class="page-header">
        <a href="javascript:history.go(-1);" class="back">上一步</a>
        <h1 class="small">高考冲刺攻略专题</h1>
    </header>
    <div class="page-main">
        <article class="sf-intro">
            <section class="text ta-c">
                <img src="img/x-logo.png" alt="校讯通" width="100" height="100"/>
                <h2 style="margin:1em 0 1em 0;">抢先免费获取名校高考冲刺攻略</h2>
                <a id="btn_xxt" href="http://wap.edu.gd.chinamobile.com/activity/other/TongFen.do?action=index" target="_blank" class="btn-down-x">请下载校讯通客户端</a>
            </section>
        </article>
    </div>
    <footer class="page-footer">
        <div class="sf-footer">
            <span class="cap">服务提供：</span>
            <span class="list">
                <img src="img/moble-logo.png" alt="中国移动" width="24" height="24"><span>中国移动</span>
            </span>
            <span class="list">
                <img src="img/ico-logo.png" alt="istudy" width="30" height="24"><span>华附在线（爱学网）</span>
            </span>
        </div>
    </footer>
</div>
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/istudy_minisite.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn_xxt").click(function(){
		postUserActionRecordV2("<%=basePath%>", 'btnclick-xxt-app', "${ queryStr }");
	});
});
</script>
</body>
</html>
