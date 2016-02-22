<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<%@include file="../minisite_common.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-report-matcher&${ queryStr }" width="0" height="0" style="display: none;"/>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广一模报告</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.5, user-scalable=yes">
    <link rel="stylesheet" href="<%=basePath%>/css/minisite_layout_report.css?v2"/>
    <!--[if lte IE 8]>
        <script src="<%=basePath%>/js/html5.js"></script>
    <![endif]-->
</head>
<body>
    <div id="page">
    <header class="page-header">
        <a href="javascript:window.history.go(-1);" class="btn-prev"><span>返回</span></a>
        <h1>广一模成绩分析报告</h1>
    </header>
    <div class="page-main">
        <article class="report-item">
            <section class="m-fail">
                <img src="<%=basePath%>/img/ico-mismatch.png" alt="" class="ico"/>
                <div class="aside">
                  	 抱歉<br>考号和姓名不匹配
                </div>
                <a href="${commonPath }/input.do" class="s-red-btn">重新输入考号和姓名</a>
            </section>
            <section class="m-fail-i">
                <div>您也可以手动输入各科成绩<br>生成相应的成绩报告</div>
                <a href="${commonPath }/scoreinput.do" class="link">手动输入</a>
            </section>
        </article>
    </div>
    <footer class="page-footer">
        <div class="copyright">
            <table>
                <tr>
                    <td>服务提供：</td>
                    <td class="pr"><img src="<%=basePath%>/img/moble-logo.png" alt="中国移动" width="24" height="24"><span>中国移动</span></td>
                    <td><img src="<%=basePath%>/img/i-logo-footer.png" alt="istudy" width="30" height="24"><span>华附在线（爱学网）</span></td>
                </tr>
            </table>
        </div>
    </footer>
</div>
</div>
</body>
</html>
