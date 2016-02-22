<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<%@include file="../minisite_common.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-subject&${ queryStr }" width="0" height="0" style="display: none;"/>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.5, user-scalable=yes"/>
<title>家长无忧</title>
<link rel="stylesheet" href="<%=basePath%>/css/minisite_layout.css">
<script type="text/javascript">
</script>
</head>
<body>

<div id="page">
    <header class="page-header">
        <a href="javascript:history.go(-1);" class="back">返回</a>
        <h1 class="small">校讯通·家长无忧<sup>TM</sup></h1>
    </header>
    <div class="page-main mt-0">
        <article class="rss-intro">
            <section>
                <p class="r-date-cap">顶级名校高考冲刺攻略<span class="tips">首发</span></p>
                <img src="<%=basePath%>/img/sprit-step.gif" alt="高考冲刺攻略" class="r-intro-pic"/>
                <div class="r-date-item sf-cont">
                    <div class="days c-blue">
                        <p>3月15日，一模当天首发！距离高考还有83天！</p>
                        <ico class="ico-tri"></ico>
                        <img src="<%=basePath%>/img/ico-commented.png" alt="讲评" class="ico-type"/>
                    </div>
                    <div class="sf-c-main ta-c">
	                    <dl class="intro">
	                        <dt>一模试题讲评</dt>
                            <dd>
                                <p class="c-red">分数早知道、重温解题思路</p>
                            </dd>
	                    </dl>
                        <div class="vedio" id="vedio">
                        <script type="text/javascript">
                        <div class="article-video">
                        <script src='http://static.polyv.net/file/polyvplayer.min.js'></script><div id='mainv9db4ad2a0dcebc3dd172d8e8b799d5aa_9_div'></div><script>var polyv_player = new polyvObject.swf('http://player.polyv.net/videos/9db4ad2a0dcebc3dd172d8e8b799d5aa_9.swf','mainv9db4ad2a0dcebc3dd172d8e8b799d5aa_9','600','337','#ffffff');</script>
                        </div>
                        </script>
                        </div>
                        <br>
                        <p>
							让观看更流畅，请登录爱学网查看<br>
                            <big><a href="http://www.istudy.com.cn/yimo" target="_blank">www.istudy.com.cn/yimo</a></big><br/>
                            <span class="c-gray">还有更多完整视频哦！</span>
                        </p>
					</div>
                    <div class="days c-l-gray">
                        <p>3月21日发布 , 距离高考还有77天！</p>
                        <ico class="ico-tri"></ico>
                        <img src="<%=basePath%>/img/ico-report-gray.png" alt="报告" class="ico-type"/>
                    </div>
                    <div class="sf-c-main">
                        <dl class="intro ta-c">
                            <dt>一模分析报告</dt>
                            <dd>
                                <p class="c-gray">高考前，最后一次弯道超越的独家秘笈</p>
                                <a href="${commonPath }/example.do">报告案例马上查看>></a>
                            </dd>
                        </dl>
                    </div>
                </div>
            </section>
        </article>
    </div>
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
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/istudy_minisite.js"></script>
</body>
</html>
