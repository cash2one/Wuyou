<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<%@ include file="../hm.jsp" %>
<%
_HMT _hmt = new _HMT("603a7b8374bb878690acfbca0e1d9342");
_hmt.setDomainName("wuyou.istudy.com.cn");
_hmt.setHttpServletObjects(request, response);
String _hmtPixel = _hmt.trackPageview();
%>
<img src="<%= _hmtPixel %>" width="0" height="0"  />

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.5, user-scalable=yes"/>
<title>家长无忧</title>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/istudy_minisite.js"></script>
<link rel="stylesheet" href="css/minisite_layout.css">
<script type="text/javascript">
	$(function(){
		postUserActionRecord("<%=basePath%>", "page-enter-report-example");
		$(window).bind("unload",function(){
			postUserActionRecord("<%=basePath%>", "page-leave-report-example");
		});
	});
</script>
</head>
<body class="bg-white">
<div id="page">
        <header class="page-header">
            <a href="javascript:history.go(-1);" class="back">返回</a>
            <h1>报告案例马上看</h1>
            <img src="img/logo.png" alt="爱学网" class="logo">
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
                    <img src="img/onemodent.png?v1" alt="" width="100%" style="display:block;">
                    <p>2014一模成绩分析报告将在3月21日发布，敬请关注！</p>
                </section>
            </article>
        </div>
        <footer class="page-footer">
            <div class="link">内容提供：华附在线学习中心（爱学网）</div>
        </footer>
</div>
</body>
</html>
