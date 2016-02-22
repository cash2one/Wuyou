<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<%@include file="../minisite_common.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-vedio4app&${ queryStr }" width="0" height="0" style="display: none;"/>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.5, user-scalable=yes"/>
<title>校讯通服务升级</title>
<link rel="stylesheet" href="<%=basePath%>/css/minisite_layout.css?v3.2">
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.10.2.js?v3"></script>
<script type="text/javascript" src="<%=basePath%>/js/istudy_minisite.js?v3"></script>
<script type="text/javascript">
$(function(){
	$("#btn_yimo").click(function(){
		postUserActionRecordV2("<%=basePath%>", 'alinkclick-yimo', "${ queryStr }");
	});
});
</script>
</head>
<body>

<div id="page">
    <header class="page-header">
        <h1 class="small p-static">名校高考冲刺攻略专题</h1>
    </header>
    <div class="page-main mt-0">
        <article class="r-sms-intro">
            <section class="sec-cap">
                <h2>一模试题讲评</h2>
                <p>详解高频考点，透视出题趋势<br>一题一视频，名师讲评，难点轻松过！</p>
            </section>
            <section>
                <table class="video-p-list">
                    <tr>
                        <td>
                            <a href="${commonPath }/yuwen/playlist.do"><img src="<%=basePath%>/img/course-sms-yuwen.jpg" alt="语文"/></a>
                        </td>
                        <td>
                            <a href="${commonPath }/dili/playlist.do"><img src="<%=basePath%>/img/course-sms-dili.jpg" alt="地理"/></a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="${commonPath }/wuli/playlist.do"><img src="<%=basePath%>/img/course-sms-shengwu.jpg" alt="生物"/></a>
                        </td>
                        <td>
                            <a href="${commonPath }/lishi/playlist.do"><img src="<%=basePath%>/img/course-sms-lishi.jpg" alt="历史"/></a>
                        </td>
                    </tr>
                </table>
                <div class="course-list">
                    <h3>各科讲评老师</h3>
                    <ul>
                        <li><a href="${commonPath }/yuwen/playlist.do">语文 华师附中老师 张诚<span class="btn-on">马上观看</span></a></li>
                        <li><a href="${commonPath }/lishu/playlist.do">理数 华师附中老师 刘景亮<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/wenshu/playlist.do">文数 华师附中老师 桂鹏<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/yingyu/playlist.do">英语 广雅中学老师 温东瑜<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/wuli/playlist.do">物理 华师附中老师 赵建辉<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/huaxue/playlist.do">化学 华师附中老师 龚德昌<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/shengwu/playlist.do">生物 华师附中老师 贺建<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/lishi/playlist.do">历史 华师附中老师 黄永友<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/zhengzhi/playlist.do">政治 华师附中老师 戚正东<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/dili/playlist.do">地理 华师附中老师 刘玉涵<span class="btn-on">马上观看</span></a></a></li>
                    </ul>
                </div>
            </section>
        </article>
        <div class="r-sms-link">
            <h3>为了更流畅的观看效果，<br>请在电脑上打开以下网址</h3>
            <a id="btn_yimo" href="http://edu.gd.chinamobile.com/ymsp.html" target="_blank">edu.gd.chinamobile.com/ymsp.html</a>
        </div>
        <br>
    </div>
    <a href="${commonPath }/exampleV3.do" class="link-banner"><img src="<%=basePath%>/img/sms-banner.jpg" alt="一模分析报告"/></a>
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
