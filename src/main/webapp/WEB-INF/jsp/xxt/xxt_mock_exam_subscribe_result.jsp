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
		postUserActionRecord("<%=basePath%>", "page-enter-regresult");
		$(window).bind("unload",function(){
			postUserActionRecord("<%=basePath%>", "page-leave-regresult");
		});
	});
</script>
</head>
<body>

<div id="page">
    <header class="page-header">
        <a href="javascript:history.go(-1);" class="back">返回</a>
        <h1>提示</h1>
        <img src="img/logo.png" alt="爱学网" class="logo">
    </header>
    <div class="page-main">
        <div class="rss-msg">
            <div class="inside">
            	<c:choose>
               		<c:when test="${result.code == '-1' }">
               			<div style="padding:30px 0;">
	               			<h2 class="rss-msg-title">
	                        	<img src="img/ico-error.png" alt="提交失败" width="34" height="34"/>
	                        <span>提交失败！</span>
		                    </h2>
		                    <div class="ta-c" style="margin-top:10px;">
		                        <a href="javascript:history.go(-1);">返回重试</a>
		                    </div>
	                    </div>
               		</c:when>
               		<c:otherwise>
               			<h2 class="rss-msg-title">
	                    <img src="img/ico-succ.png" alt="提交成功" width="34" height="34"/>
	                    <span>提交成功！</span>
		                </h2>
		                <div class="rss-msg-cont">
		                	<p>尊敬的${name }家长，我们会以短信方式发给您专属的学习账号及密码，请注意查收，并请转发给您的孩子进行学习！</p>
		                    <br>
                        	<p>您订阅的<br><span class="name">一模试题讲评&一模分析报告</span></p>
		                    <dl>
		                        <dt>每辑发布时间预告如下：</dt>
		                        <dd>
		                            <p>3月15日上线<br>一模试题讲评 （视频讲解）</p>
		                            <p>3月21日上线<br>一模分析报告 （系统生成）</p>
		                        </dd>
		                    </dl>
		                    <p>届时，我们将会以短信方式提醒您，敬请关注！</p>
		                </div>
               		</c:otherwise>
               	</c:choose>
            </div>
        </div>
    </div>
    <footer class="page-footer">
       <div class="link">内容提供：华附在线学习中心（爱学网）</div>
    </footer>
</div>
</body>
</html>
