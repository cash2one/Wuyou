<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<%@include file="../minisite_common.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-onefoot&${ queryStr }" width="0" height="0" style="display: none;"/>
<html>
<head>
<base href="<%=basePath%>">
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, user-scalable=yes"/>
<link rel="stylesheet" href="<%=basePath%>/css/minisite_layout.css?v3.4">
<script src='<%=basePath%>/js/polyvplayer.min.js'></script>
<script type="text/javascript" src="<%=basePath%>/js/istudy_minisite.js"></script>
</head>
<body class="bg-white">
<div id="page">
    <header class="page-header">
        <h1>校讯通服务升级</h1>
    </header>
    <div class="page-main mt-0">
        <article class="r-sms-intro">
            <section class="sec-cap">
                <h2>高考前6天最后的提分方法</h2>
                <strong>临门一脚网课</strong>
                <p class="ta-l indent">每科“最后1小时”，由省内顶级名校名师授课，解密高考题型，预测高考命题方向和出题思路。2013年广东高考命中分值：文科达145分，理科达156分！</p>
            </section>
            <section>
                <div id="articleVideo" class="article-video">
                    <script src='http://static.polyv.net/file/polyvplayer.min.js'></script><div id='mainv9db4ad2a0d2aa59aa2244c555c6cfd62_9_div'></div><script>var polyv_player = new polyvObject.swf('http://player.polyv.net/videos/9db4ad2a0d2aa59aa2244c555c6cfd62_9.swf','mainv9db4ad2a0d2aa59aa2244c555c6cfd62_9','600','340','#000000v');</script>
                </div>
                <div class="course-list">
                    <h3>各科讲评老师</h3>
                    <ul>
                        <li><a href="${commonPath }/yuwen/onefootplay.do">语文 华师附中老师 张诚<span class="btn-on">马上观看</span></a></li>
                        <li><a href="${commonPath }/lishu/onefootplay.do">理数 华师附中老师 刘景亮<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/wenshu/onefootplay.do">文数 华师附中老师 桂鹏<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/yingyu/onefootplay.do">英语 广雅中学老师 温东瑜<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/wuli/onefootplay.do">物理 华师附中老师 赵建辉<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/huaxue/onefootplay.do">化学 华师附中老师 龚德昌<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/shengwu/onefootplay.do">生物 华师附中老师 刘桦<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/lishi/onefootplay.do">历史 华师附中老师 黄永友<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/zhengzhi/onefootplay.do">政治 华师附中老师 戚正东<span class="btn-on">马上观看</span></a></a></li>
                        <li><a href="${commonPath }/dili/onefootplay.do">地理 华师附中老师 吕鸿斌<span class="btn-on">马上观看</span></a></a></li>
                    </ul>
                </div>
            </section>
        </article>
        
        <div class="r-sms-link">
            <h3>为了更流畅的观看效果，<br>请在电脑上打开以下网址</h3>
            <a id="btn_yimo" href="http://www.istudy.com.cn/zhixue/linmenyijiaocourse.html" target="_blank">www.istudy.com.cn/zhixue/linmenyijiaocourse.html</a>
        </div>
        
		<c:set var="ufCookieName" value="uf_${miniUri }"></c:set>
		<c:if test="${empty cookie[ufCookieName].value }">
			<div id="feedback-div" class="feedback-item">
			    <p class="cap">本期内容对你有用吗？</p>
			    <div class="clearfix">
			        <a onclick="${empty cookie[ufCookieName].value ? '' : 'return false;'}useful(this,'${basePath}', '${queryStr }');" href="javascript:" class="btn-use flo-l ${empty cookie[ufCookieName].value ? '' : 'disabled' }">有用</a>
			        <a onclick="${empty cookie[ufCookieName].value ? '' : 'return false;'}useless(this,'${basePath}', '${queryStr }');" href="javascript:" class="btn-no-use flo-r ${empty cookie[ufCookieName].value ? '' : 'disabled' }">没用</a>
			    </div>
			</div>
			<div class="msgbox" id="msgbox">
			    <span class="text">感谢您的反馈</span>
			</div>
		</c:if>
	
		<c:if test="${userid != 'appuser'}">
		<div  class="app-download">
		        <div class="title ta-c"><span>关爱孩子的成长，获取更多家校沟通功能、教育资讯和服务，请下载校讯通手机客户端</span></div>
		        <a onclick="eventPush('${basePath}','${queryStr }','btnclick-download-ios')" href="http://120.197.89.182/release/app/ios/ios_intall.html" target="_blank" class="iphone"><span>校讯通iPhone版</span></a>
		        <a onclick="eventPush('${basePath}','${queryStr }','btnclick-download-android')" href="http://120.197.89.182/release/app/android/3g.qq.com/GuangDongApp.apk" target="_blank" class="andriod"><span>校讯通Android版</span></a>
		    </div>
		</c:if>
	
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
<script type="text/javascript">
function useful(el,basePath,queryStr){
	eventPush(basePath,queryStr,"btnclick-useful");
	hiddenFeedback();
}

function useless(el,basePath,queryStr){
	eventPush(basePath,queryStr,"btnclick-useless");
	hiddenFeedback();
}

function hiddenFeedback(){
	showMsg();
	var fb = document.getElementById("feedback-div");
	if(fb){
		fb.style.display = "none";
		fb.parentNode.removeChild(fb);
	}
}

function showMsg() {
    var box = document.getElementById("msgbox");
    function restore() {
        box.style.display = "none";
        box.className = "msgbox";
        showMsg.over = false;
    }
    box.style.display = "block";
    box.className = "msgbox animation-fadeOut";

    showMsg.over = setTimeout(restore, 2500);
}

var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F603a7b8374bb878690acfbca0e1d9342' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>
