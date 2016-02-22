<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="xxt_variable_title_header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.5, user-scalable=yes">
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-bst-matcher&${ queryStr }" width="0" height="0" style="display: none;"/>
<script type="text/javascript">
_hmt.push(['_trackEvent', '广一模变式题', '进入考号姓名匹配失败页面', '${cityId }${userid }']);
</script>
</head>
<body>
    <div id="page">
    <header class="page-header">
        <a href="javascript:window.history.go(-1);" class="btn-prev"><span>返回</span></a>
        <h1>广一模变式训练</h1>
    </header>
    <div class="page-main">
        <article class="report-item">
            <section class="m-fail">
                <img src="<%=basePath%>/img/ico-mismatch.png" alt="" class="ico"/>
                <div class="aside">
                  	 抱歉<br>考号和姓名不匹配
                </div>
                <a href="${commonPath }/varinput.do" class="s-red-btn">重新输入考号和姓名</a>
            </section>
            <section class="m-fail-i">
                <div>您也可以手动输入各科成绩<br>生成相应的成绩报告</div>
                <a href="${commonPath }/varscoreinput.do" class="link">手动输入</a>
            </section>
        </article>
    </div>
    <%@ include file="xxt_variable_title_footer.jsp" %>
</div>
</div>
</body>
</html>
