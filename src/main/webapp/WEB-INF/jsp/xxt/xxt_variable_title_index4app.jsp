<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="xxt_variable_title_header.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-bst-index&${ queryStr }" width="0" height="0" style="display: none;"/>
<script type="text/javascript">
_hmt.push(['_setCustomVar', 2, 'INFO_2', "${cityId == 'gz' ? '广州校讯通APP用户' : '非广州校讯通APP用户'}", 1]);
	_hmt.push(['_trackEvent', '广一模变式题', '进入短信链接页面', '${cityId }${userid }']);
</script>
<script src='<%=basePath%>/js/polyvplayer.min.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广一模变式训练</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2, user-scalable=yes">

</head>
<body>
    <div id="page">
        <header class="page-header">
            <h1>广一模变式训练</h1>
        </header>
        <div class="page-main">
            <article class="index-art">
                <section>
                    <h2>变式训练帮你脱离【题海】</h2>
                    <img class="banner" src="<%=basePath%>/img/banner.jpg" alt="" class="banner"/>
                    <div class="ind-qus">
                        <p class="q">什么是变式训练？</p>
                        <p class="a">抓住一个知识点，对一道题目进行适当演变、引申、拓展，称之为变式训练。</p>
                        <p class="q">变式训练的意义：</p>
                        <p class="a">变式训练可以加深学生对知识点的理解，培养学生观察、分析能力，提高解题能力，实现举一反三。</p>
                    </div>
                </section>
                <section>
                    <h3>广一模变式题</h3>
                    <p class="indent">根据你的一模考试得分最低的薄弱知识点，给你推送最具有针对性的变式题，最大限度提高你的复习效率。</p>
                    <div class="ind-intro-list">一题一视频，讲解清晰透彻</div>
                    <div class="ind-exam">
                        <p class="title">案例</p>
                        <div class="info">
                            <span>考号：010*******</span>
                            <span>姓名：张**</span>
                        </div>
                        <table class="score-table">
                            <tr>
                                <th>语文</th>
                                <th>数学</th>
                                <th>英语</th>
                                <th>物理</th>
                                <th>化学</th>
                                <th>生物</th>
                                <th>总分</th>
                            </tr>
                            <tr>
                                <td>110</td>
                                <td>80</td>
                                <td>90</td>
                                <td>80</td>
                                <td>50</td>
                                <td>80</td>
                                <td>490</td>
                            </tr>
                        </table>
                        <p class="aside">和同分数段考生比较，<strong>数学</strong>、<strong>化学</strong>是你的劣势学科，建议你可以重点训练这两科对应的变式题。</p>
                        <p class="sub-title">数学</p>
                        <p class="aside">广一模数学试卷中你做错了第<strong>[1]</strong>题，这些题对应的变式题如下：</p>
                        <img src="<%=basePath%>/img/test-01.jpg" alt="" class="pic"/>
                    </div>

                    <div class="video">
                    	<div class="article-video" style="display: none;">
                    		<div id='mainv9db4ad2a0d22f7b2f168e2ef4fcd3e3a_9_div'></div>
                    	</div>
                        <img id="vedioimg" src="<%=basePath%>/img/video.jpg" alt="视频图片" class="video"
                        data-id="9db4ad2a0d22f7b2f168e2ef4fcd3e3a_9"
                        />
                    </div>
                    <a href="${commonPath }/varinput.do" class="s-red-btn">查看一模变式题</a>
                </section>
            </article>
        </div>
        <%@ include file="xxt_variable_title_footer.jsp" %>
    </div>
    <script type="text/javascript" src="<%=basePath%>/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#vedioimg").one("click",function(){
				var $this = $(this);
				var data_id = $this.attr("data-id");
				new polyvObject.swf('http://player.polyv.net/videos/'+data_id+'.swf','mainv' + data_id,'600','337');
				$this.remove();
				$("#mainv" + data_id + "_div").parent().show();
				postEvent(this, 'video-play', '点击APP文章页示例视频');
			});
			//$(".video-ctrl").click();
		});
	</script>
    <script type="text/javascript">
	var commonPath = "<%=basePath%>/xxtStat/addRecordV2.do?${queryStr}&action=";
	var img = new Image();
	function postEvent(obj ,action, actionName){
		img.src=commonPath + action + "&r=" + Math.random();
		if(_hmt){_hmt.push(['_trackEvent', '广一模变式题', actionName, '${cityId }${userid }']);}
	}
	</script>
</body>
</html>
