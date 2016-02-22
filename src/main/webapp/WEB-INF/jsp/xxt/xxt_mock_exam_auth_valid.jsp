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
<script type="text/javascript">
function doSubmit(){
	var phoneEl = document.getElementById("phoneNum");
	var phoneNum = phoneEl.value;
	if(!phoneNum || !/^[0-9]{11}$/.test(phoneNum)){
		alert("请输入正确格式的手机号码！");
		phoneEl.focus();
		return;
	}
	var stuNameEl = document.getElementById("stuName");
	var stuName = stuNameEl.value;
	if(!stuName){
		alert("学生姓名不能为空！");
		stuNameEl.focus();
		return;
	}
	form_phone.submit();
}

$(function(){
	postUserActionRecord("<%=basePath%>", "page-enter-register");
	$("#btn_next").click(function(){
		postUserActionRecord("<%=basePath%>", "btnclick-register-ok");
	});
	$(window).bind("unload",function(){
		postUserActionRecord("<%=basePath%>", "page-leave-register");
	});
});
</script>
<link rel="stylesheet" href="css/minisite_layout.css">
</head>
<body>

<div id="page">
        <header class="page-header">
            <a href="javascript:history.go(-1);" class="back">返回</a>
            <h1>获取学习账号</h1>
            <img src="img/logo.png" alt="爱学网" class="logo">
        </header>
        <div class="page-main">
            <div class="rss-user-enter">
                <p class="cap">请输入您的手机号码，为孩子获得专属的学习账号及密码</p>
                <form name="form_phone" id="form_phone"
                   action="${basePath }/xxtM/mockExamRegister.do" method="post">
	                <fieldset class="form">
	                    <label for="">您的手机号码：</label>
	                    <input name="phoneNum" id="phoneNum" type="number"/>
	                    <label for="">学生姓名：</label>
	                    <input name="stuName" class="input-st" id="stuName" type="text"/>
	                    <a id="btn_next" href="javascript:doSubmit();;" class="btn-submit">确 认</a>
	                </fieldset>
                </form>
            </div>
        </div>
        <footer class="page-footer">
            <div class="link">内容提供：华附在线学习中心（爱学网）</div>
        </footer>
</div>
</body>
</html>
