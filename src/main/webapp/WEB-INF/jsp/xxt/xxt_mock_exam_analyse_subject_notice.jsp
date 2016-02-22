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
		postUserActionRecord("<%=basePath%>", "page-enter-subject");
		$("#btn_next").click(function(){
			postUserActionRecord("<%=basePath%>", "btnclick-get-accout");
		});
		$(window).bind("unload",function(){
			postUserActionRecord("<%=basePath%>", "page-leave-subject");
		});
	});
</script>
</head>
<body>
<div id="page">
    <header class="page-header">
        <a href="javascript:history.go(-1);" class="back">返回</a>
        <h1>我订阅的本期内容</h1>
        <img src="img/logo.png" alt="爱学网" class="logo"/>
    </header>
    <div class="page-main mt-0">
        <article class="rss-intro">
            <section class="bg-white">
                <p class="r-date-cap">一模考试季<strong>【免费版】</strong><br>攻克弱点，锁定提分知识点</p>
                <div class="r-date-item">
                    <div class="days c-blue">
                        <p>上线日期3月15日，此时距离高考还有83天！</p>
                        <ico class="ico-tri"></ico>
                        <img src="img/ico-commented.png" alt="讲评" class="ico-type"/>
                    </div>
                    <dl class="intro">
                        <dt>一模试题讲评
                        <a href="http://wuyou.istudy.com.cn/xxtM/mPage.do?uri=13944295366853" class="links">考前热身抢先看&gt;&gt;</a>
                        </dt>
                        <dd>
                            <p><strong>一模答案：</strong>独家首发。</p>
                            <p><strong>试题详解：</strong>华附高三一线名师主讲，一题一视频，必考知识点逐一过关。</p>
                            <p><strong>得分标准：</strong>即时发布，明确得分点/失分点。</p>
                        </dd>
                    </dl>

                    <div class="days c-l-brown">
                        <p>上线日期3月21日，此时距离高考还有77天！</p>
                        <ico class="ico-tri"></ico>
                        <img src="img/ico-report.png" alt="报告" class="ico-type"/>
                    </div>
                    <dl class="intro">
                        <dt>一模分析报告
                        <a href="${basePath }/xxtM/showMockExamReportExamplePage.do" class="links">报告案例马上看&gt;&gt;</a>
                        </dt>
                        <dd>
                            <p><strong>总分精准定位：</strong>明确高考排位。</p>
                            <p><strong>学科整体诊断：</strong>科学诊断优劣学科，明确最优提分科。</p>
                            <p><strong>学科模块诊断：</strong>锁定最佳提分知识点，找准一模后点对点提分方向。</p>
                            <p><strong>高效提分策略：</strong>制定最佳学习方案，达成一模后快速提分。</p>
                        </dd>
                    </dl>
                </div>
            </section>
            <section class="ta-c">
                <p>为了获得更好的学习体验，<br>请登录华附在线（爱学网）<br><a href="http://www.istudy.com.cn/yimo" target="_blank">http://www.istudy.com.cn/yimo</a></p>
                <br>
                <a id="btn_next" href="${basePath }/xxtM/showMockExamAuthValidPage.do" class="btn-rss">获取您在爱学网的专属学习账号</a>
            </section>
        </article>
    </div>
    <footer class="page-footer">
        <div class="link">内容提供：华附在线学习中心（爱学网）</div>
    </footer>
</div>
</body>
</html>
