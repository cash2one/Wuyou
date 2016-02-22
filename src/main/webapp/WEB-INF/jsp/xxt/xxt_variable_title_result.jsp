<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="xxt_variable_title_header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2, user-scalable=yes">
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=${empty action ? 'page-enter-bst-result-mc' : action }${cost }&info=${ticketNo }&${ queryStr }" width="0" height="0" style="display: none;"/>
<script type="text/javascript">
	var actionName = "${action == 'page-enter-bst-result-nomc' ? '进入结果页面by考号姓名' : '进入结果页面by成绩'}";
	_hmt.push(['_trackEvent', '广一模变式题', actionName, '${cityId }${userid }']);
</script>
</head>
<body>
    <div id="page">
    <header class="page-header">
    	<a href="javascript:window.history.go(-1);" class="btn-prev"><span>返回</span></a>
        <h1>广一模变式训练</h1>
    </header>
    
    <div class="page-main">
        <article class="analy-item">
        	<h2>一模变式题推送</h2>
        	<section>
        		<table class="score-table">
                    <caption>你的成绩</caption>
                    <tr>
                        <c:forEach var="score" items="${scoreList }">
	                	<th>${score.exam_subject }</th>
	                	</c:forEach>
                        <th>总分</th>
                    </tr>
                    <tr>
                        <c:forEach var="score" items="${scoreList }">
                		<td>${score.my_point }</td>
                		</c:forEach>
                		<td>${totalScore.point }</td>
                    </tr>
                </table>
                
                <c:if test="${action == 'page-enter-bst-result-nomc' }">
	                <div class="link-re-enter">
	                    <a href="javascript:window.history.go(-1);">重新录入分数&gt;&gt;</a>
	                </div>
                </c:if>
                
            	<c:set var="lower1" value=""></c:set>
            	<c:set var="lower2" value=""></c:set>
                <c:forEach var="score" items="${subjectList }" varStatus="status">
                	<c:if test="${status.last }">
                		<c:set var="lower1" value="${score.exam_subject }"></c:set>
                	</c:if>
                	<c:if test="${status.index == (fn:length(subjectList) - 2) }">
                		<c:set var="lower2" value="${score.exam_subject }"></c:set>
                	</c:if>
                </c:forEach>
                
                <div class="weak-sub">
                    <div class="title indent">和同分数段考生比较，<strong>${lower1 }</strong>、<strong>${lower2 }</strong>是你的劣势学科。</div>
                    <div class="aside">
                    	<c:choose>
                    		<c:when test="${lower1 == '语文' }"><p>语文变式题讲解： 华师附中老师 张诚</p></c:when>
                    		<c:when test="${lower1 == '数学' && studentMap['studyType'] == '2' }"><p>理数变式题讲解： 华师附中老师 刘景亮</p></c:when>
                    		<c:when test="${lower1 == '数学' && studentMap['studyType'] == '1' }"><p>文数变式题讲解： 华师附中老师 桂鹏</p></c:when>
                    		<c:when test="${lower1 == '英语' }"><p>英语变式题讲解： 广雅中学老师 温东瑜</p></c:when>
                    		<c:when test="${lower1 == '物理' }"><p>物理变式题讲解： 华师附中老师 赵建辉</p></c:when>
                    		<c:when test="${lower1 == '化学' }"><p>化学变式题讲解： 华师附中老师 龚德昌</p></c:when>
                    		<c:when test="${lower1 == '生物' }"><p>生物变式题讲解： 华师附中老师 贺建</p></c:when>
                    		<c:when test="${lower1 == '历史' }"><p>历史变式题讲解： 华师附中老师 黄永友</p></c:when>
                    		<c:when test="${lower1 == '政治' }"><p>政治变式题讲解： 华师附中老师 戚正东</p></c:when>
                    		<c:when test="${lower1 == '地理' }"><p>地理变式题讲解： 华师附中老师 刘玉涵</p></c:when>
                    	</c:choose>
                        
                        <c:choose>
                    		<c:when test="${lower2 == '语文' }"><p>语文变式题讲解： 华师附中老师 张诚</p></c:when>
                    		<c:when test="${lower2 == '数学' && studentMap['studyType'] == '2' }"><p>理数变式题讲解： 华师附中老师 刘景亮</p></c:when>
                    		<c:when test="${lower2 == '数学' && studentMap['studyType'] == '1' }"><p>文数变式题讲解： 华师附中老师 桂鹏</p></c:when>
                    		<c:when test="${lower2 == '英语' }"><p>英语变式题讲解： 广雅中学老师 温东瑜</p></c:when>
                    		<c:when test="${lower2 == '物理' }"><p>物理变式题讲解： 华师附中老师 赵建辉</p></c:when>
                    		<c:when test="${lower2 == '化学' }"><p>化学变式题讲解： 华师附中老师 龚德昌</p></c:when>
                    		<c:when test="${lower2 == '生物' }"><p>生物变式题讲解： 华师附中老师 贺建</p></c:when>
                    		<c:when test="${lower2 == '历史' }"><p>历史变式题讲解： 华师附中老师 黄永友</p></c:when>
                    		<c:when test="${lower2 == '政治' }"><p>政治变式题讲解： 华师附中老师 戚正东</p></c:when>
                    		<c:when test="${lower2 == '地理' }"><p>地理变式题讲解： 华师附中老师 刘玉涵</p></c:when>
                    	</c:choose>
						
                    </div>
                    <div class="tips">
                    <p>查看所有科目变式题请用电脑登录以下网址:</p>
                    <p class="ta-c">
                    	<a onclick="postEvent(this, 'alinkclick-yimo', '点击WAP页中广一模网址');" href="http://edu.gd.chinamobile.com/ymsp.html" target="_blank">edu.gd.chinamobile.com/ymsp.html</a>
                    </p>
                    </div>
                </div>
        	</section>
        	
            <section>
            	<p class="h2">成绩分析报告</p>
                <h3>总分定位</h3>
                <p class="h-aside">准确了解目前所处排位、上线批次</p>
                <p class="rank">你的总分超过了全省<strong>${totalScore.rank_percentage }%</strong>的学生</p>
                <table class="score-table">
                    <tr>
                        <c:forEach var="score" items="${scoreList }">
	                	<th>${score.exam_subject }</th>
	                	</c:forEach>
                        <th>总分</th>
                    </tr>
                    <tr>
                        <c:forEach var="score" items="${scoreList }">
                		<td>${score.my_point }</td>
                		</c:forEach>
                		<td>${totalScore.point }</td>
                    </tr>
                </table>
                
                <c:if test="${studentMap['studyType'] == '2'}">
                <div class="sec-chart-wrap ${totalScore.point >= 350.0 ? 'hidden-01' : ''}">
                    <div class="sec-chart">
                        <ul class="scale-line">
                            <li class="nth-9">750</li>
                            <li class="nth-8">700</li>
                            <li class="nth-7">600</li>
                            <li class="nth-6">500</li>
                            <li class="nth-5">400</li>
                            <li class="nth-4">300</li>
                            <li class="nth-3">200</li>
                            <li class="nth-2">100</li>
                            <li class="nth-1">0</li>
                        </ul>
                        <div class="scale-color"></div>
                        <div class="score-range score-range-1">
                            <div class="u">
                                <div class="critical">
                                    <div class="exp">
                                        <strong>一本线:560</strong>
                                        <em>临界范围:548-566</em>
                                    </div>
                                </div>
                            </div>
                            <div class="u-a">
                                <div class="critical">
                                    <div class="exp">
                                        <strong>本A线:497</strong>
                                        <em>临界范围:479-503</em>
                                    </div>
                                </div>
                            </div>
                            <div class="u-b">
                                <div class="critical">
                                    <div class="exp">
                                        <strong>本B线:461</strong>
                                        <em>临界范围:437-467</em>
                                    </div>
                                </div>
                            </div>
                            <div class="v-a">
                                <div class="critical">
                                    <div class="exp">
                                        <strong>专A线:391</strong>
                                        <em>临界范围:367-403</em>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="self-score" style="bottom:${totalScore.point / 7.5 }%;">
                            <i class="ico-line"></i>
                            <span class="text">您的<br>分数<br><strong>${totalScore.point }</strong></span>
                        </div>
                    </div>
                </div>
                </c:if>
                
                <c:if test="${studentMap['studyType'] == '1'}">
                
                <div class="sec-chart-wrap ${totalScore.point >= 350.0 ? 'hidden-01' : ''}">
                    <div class="sec-chart">
                        <ul class="scale-line">
                            <li class="nth-9">750</li>
                            <li class="nth-8">700</li>
                            <li class="nth-7">600</li>
                            <li class="nth-6">500</li>
                            <li class="nth-5">400</li>
                            <li class="nth-4">300</li>
                            <li class="nth-3">200</li>
                            <li class="nth-2">100</li>
                            <li class="nth-1">0</li>
                        </ul>
                        <div class="scale-color"></div>
                        <div class="score-range score-range-2">
                            <div class="u">
                                <div class="critical">
                                    <div class="exp">
                                        <strong>一本线:551</strong>
                                        <em>临界范围:540-556</em>
                                    </div>
                                </div>
                            </div>
                            <div class="u-a">
                                <div class="critical">
                                    <div class="exp">
                                        <strong>本A线:484</strong>
                                        <em>临界范围:467-489</em>
                                    </div>
                                </div>
                            </div>
                            <div class="u-b">
                                <div class="critical">
                                    <div class="exp">
                                        <strong>本B线:427</strong>
                                        <em>临界范围:405-432</em>
                                    </div>
                                </div>
                            </div>
                            <div class="v-a">
                                <div class="critical">
                                    <div class="exp">
                                        <strong>专A线:348</strong>
                                        <em>临界范围:326-359</em>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="self-score" style="bottom:${totalScore.point / 7.5 }%;">
                            <i class="ico-line"></i>
                            <span class="text">您的<br>分数<br><strong>${totalScore.point }</strong></span>
                        </div>
                    </div>
                </div>
                </c:if>
            </section>
        </article>
    </div>
    
    <%@ include file="xxt_variable_title_footer.jsp" %>
</div>
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
