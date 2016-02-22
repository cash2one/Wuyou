<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<%@include file="../minisite_common.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-example&${ queryStr }" width="0" height="0" style="display: none;"/>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.5, user-scalable=yes"/>
<title>家长无忧</title>
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/istudy_minisite.js"></script>
<link rel="stylesheet" href="<%=basePath%>/css/minisite_layout.css">
</head>
<body class="bg-white">
<div id="page">
        <header class="page-header">
            <a href="javascript:history.go(-1);" class="back">返回</a>
            <h1>报告案例马上看</h1>
            <img src="<%=basePath%>/img/logo.png" alt="爱学网" class="logo">
        </header>
        <div class="page-main mt-0">
            <article class="rss-intro">
                <section class="rep-cap">
                    <h2>一模分析报告</h2>
                    <dl>
                        <dt>小伙伴们，一模分析报告<strong>到底有神马威力？</strong></dt>
                        <dd>
                            <p>不清楚自己存在哪些知识漏洞？</p>
                            <p>时间少？内容多？</p>
                            <p>不知道如何制定一模后每天备考计划？</p>
                        </dd>
                    </dl>
                    <dl>
                        <dt>一模分析系统能帮你 ——</dt>
                        <dd>
                            <p>清晰总分排名——知己知彼，百战不殆！</p>
                            <p>找准劣势科目——确定优先补习科目！</p>
                            <p>指出薄弱知识——锁定最优提分模块！</p>
                            <p>助你精准定位，科学备考！</p>
                        </dd>
                    </dl>
                    <img src="<%=basePath%>/img/onemodent.png?v2" alt="" width="100%" style="display:block;">
                    <p>2014一模成绩分析报告将在3月21日发布，敬请关注！</p>
                </section>
            </article>
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
</body>
</html>
