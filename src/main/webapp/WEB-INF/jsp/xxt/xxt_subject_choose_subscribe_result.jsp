<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="xxt_subject_choose_header.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-result-${isNew == true ? 'new' : (isSubscribe == true ? 'sub' : 'old') }&${ queryStr }" width="0" height="0" style="display: none;"/>
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
            <div class="apply-cont">
            <c:choose>
            <c:when test="${isNew }">
        	<!--申请成功-->
                <h2>恭喜，申请成功！</h2>
                <div class="apply-msg">
                    <table class="mlr-a mb-20">
                        <tr>
                            <td>卡号：</td>
                            <td>${acct.username }</td>
                        </tr>
                        <tr>
                            <td>密码：</td>
                            <td>${acct.password }</td>
                        </tr>
                    </table>
                    <p class="tips">
                        请用电脑登录教育部考试中心网站进行测试:<br><a href="http://sx.etest.net.cn/xkqx/" target="_blank">http://sx.etest.net.cn/xkqx/</a>
                    </p>
                </div>
			</c:when>
			<c:when test="${isSubscribe == true }">
				<!--预定成功-->
	            <div class="reserve-cont">
	                <h2>您的预定已记录</h2>
	                <p class="h2-aside">我们将会根据预定人数，再采购一批测试卡送给用户，敬请关注！</p>
	                <p class="tips">如果您想进一步了解此服务，可以用电脑登录以下:<br><a href="http://sx.neea.edu.cn/" target="_blank">http://sx.neea.edu.cn/</a></p>
	            </div>
			</c:when>
			<c:otherwise>
                <!--已申请过-->
                <h2>您申请的卡号和密码是</h2>
                <div class="apply-msg">
                    <table class="mlr-a mb-20">
                        <tr>
                            <td>卡号：</td>
                            <td>${cookie.cms_wlfk_username.value }</td>
                        </tr>
                        <tr>
                            <td>密码：</td>
                            <td>${cookie.cms_wlfk_pwd.value }</td>
                        </tr>
                    </table>
                    <p class="tips">
                        请用电脑登录教育部考试中心网站进行测试:<br><a href="http://sx.etest.net.cn/xkqx/" target="_blank">http://sx.etest.net.cn/xkqx/</a>
                    </p>
                </div>
             </c:otherwise>
             </c:choose>
           </div>
        </div>
        
        <%@ include file="xxt_variable_title_footer.jsp" %>
    </div>
    <script type="text/javascript">
	var commonPath = "<%=basePath%>/xxtStat/addRecordV2.do?${queryStr}&action=";
	var img = new Image();
	function postEvent(obj ,action, actionName){
		img.src=commonPath + action + "&r=" + Math.random();
	}
	</script>
</body>
</html>
