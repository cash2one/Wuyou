<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="xxt_subject_choose_header.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-${hasAccount == true ? 'getaccount' : 'subscribe' }&${ queryStr }" width="0" height="0" style="display: none;"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2, user-scalable=yes">

</head>
<body>
	<div id="page">
        <header class="page-header">
            <h1>${headTitle }</h1>
        </header>
        <div class="page-main">
        <c:choose>
			<c:when test="${hasAccount == true}">
            <div class="apply-cont">
                <!--马上申请-->
                <h2>申请学科倾向测试测试卡</h2>
                <form action="${commonPath }/doSubjectChooseAccount.do" 
        			method="get" onsubmit="return valid();" class="form mlr-a">
                    <input id="phone" name="phone" type="number" class="input mb-20" placeholder="请填写您的校讯通手机号码">
                    <input type="submit" class="btn-submit btn-red" value="马上获取">
                </form>
            </div>
            </c:when>
            <c:otherwise>
            <div class="over-msg">
                <img src="<%=basePath%>/img/ico-over.png" alt="">
                <p>来晚了，1000个免费名额已经送完</p>
            </div>
            <div class="reserve-cont">
                <h2 class="h2-red">第二批赠送名额统计中</h2>
                <p class="h2-aside">根据预定人数，我们将在一周内再采购一批送给用户</p>
                <form action="${commonPath }/doSubjectChooseSubscribe.do" 
        			method="get" onsubmit="return valid();" class="form mlr-a">
                    <input id="phone" name="phone" type="number" class="input mb-20" placeholder="请填写您的校讯通手机号码">
                    <input type="submit" class="btn-submit btn-red" value="马上绑定">
                </form>
                <p class="tips">如果您想进一步了解此服务，可以用电脑登录以下:<br><a href="http://sx.neea.edu.cn/" target="_blank">http://sx.neea.edu.cn/</a></p>
            </div>
            </c:otherwise>
        </c:choose>
        </div>
        <%@ include file="xxt_variable_title_footer.jsp" %>
    </div>
    <script type="text/javascript">
	function valid(){
		var phone = document.getElementById("phone");
		if(!phone || !phone.value){
			alert("请填写手机号码！");
			phone.focus();
			return false;
		}
		else if(!/^[0-9]{11}$/.test(phone.value)){
			alert("手机号码格式不正确！");
			phone.focus();
			return false;	
		}
		
		return true;
	}
	</script>
</body>
</html>
