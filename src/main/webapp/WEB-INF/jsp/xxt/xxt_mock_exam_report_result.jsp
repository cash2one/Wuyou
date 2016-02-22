<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<%@include file="../minisite_common.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=${empty action ? 'page-enter-report-result-mc' : action }${cost }&info=${ticketNo }&${ queryStr }" width="0" height="0" style="display: none;"/>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广一模报告</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2, user-scalable=yes">
    <link rel="stylesheet" href="<%=basePath%>/css/minisite_layout_report.css?v2"/>
    <!--[if lte IE 8]>
        <script src="<%=basePath%>/js/html5.js"></script>
    <![endif]-->
</head>
<body>
    <div id="page">
    <header class="page-header">
    	<a href="javascript:window.history.go(-1);" class="btn-prev"><span>返回</span></a>
        <h1>广一模成绩分析报告 </h1>
    </header>
    
    <div class="page-main">
        <article class="report-item">
            <section class="sec-cap">
                <p class="h1">成绩分析报告</p>
                <h2>(简版)</h2>
                <c:if test="${action != 'page-enter-report-result-nomc' }">
                <table class="rep-st-info">
                    <tr>
                        <th>姓名：</th>
                        <td>${studentMap['studentName'] }</td>
                        <th>学校：</th>
                        <td>${studentMap['schoolName'] }</td>
                    </tr>
                    <tr>
                        <th>考号：</th>
                        <td>${studentMap['ticketNo'] }</td>
                        <th>分科：</th>
                        <td>${studentMap['studyTypeName'] }</td>
                    </tr>
                </table>
                </c:if>
            </section>
        </article>
        <article class="analy-item">
            <section>
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
                <c:if test="${action == 'page-enter-report-result-nomc' }">
	                <div class="link-re-enter">
	                    <a href="javascript:window.history.go(-1);">重新录入分数&gt;&gt;</a>
	                </div>
                </c:if>
                
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
				
				<c:choose>
				<c:when test="${totalScore.point > 566.0 }"><div class="chart-aside">恭喜你，预测你的高考稳定处于<strong>一本线</strong>，不要骄傲，保持低调！</div></c:when>
                <c:when test="${totalScore.point >= 560.0 }"><div class="chart-aside">恭喜你，预测你的高考很有机会达到<strong>一本线</strong>，不过还不够保险，再提<em>${567 - totalScore.point }</em>分以上，就胜券在握了。</div></c:when>
                <c:when test="${totalScore.point >= 548.0 }"><div class="chart-aside">哎呀，就差一点就上<strong>一本线</strong>了，不要灰心，只要再提<em>${560 - totalScore.point }</em>分以上，就有机会达到<em>一本线</em>了，加油哦！</div></c:when>
                <c:when test="${totalScore.point > 503.0 }"><div class="chart-aside">你稳定处于<strong>本A线</strong>，冲一冲达到<em>一本线</em>不是梦。加油哦！</div></c:when>
                <c:when test="${totalScore.point >= 497.0 }"><div class="chart-aside">恭喜你，预测你的高考很有机会达到<strong>本A线</strong>，不过还不够保险，再提<em>${504 - totalScore.point }</em>分以上，就胜券在握了。</div></c:when>
                <c:when test="${totalScore.point >= 479.0 }"><div class="chart-aside">哎呀，就差一点就上<strong>本A线</strong>了，不要灰心，只要再提<em>${497 - totalScore.point }</em>分以上，就有机会达到<em>本A线</em>了，加油哦！</div></c:when>
				<c:when test="${totalScore.point > 467.0 }"><div class="chart-aside">你稳定处于<strong>本B线</strong>，冲一冲，达到<em>本A线</em>不是梦，加油哦！</div></c:when>
				<c:when test="${totalScore.point >= 461.0 }"><div class="chart-aside">恭喜你，预测你的高考很有机会达到<strong>本B线</strong>，不过还不够保险，再提${468 - totalScore.point }分以上，就胜券在握了。</div></c:when>
				<c:when test="${totalScore.point >= 437.0 }"><div class="chart-aside">哎呀，就差一点就上<strong>本B线</strong>了，不要灰心，只要再提${461 - totalScore.point }分以上，就有机会达到<em>本B线</em>了，加油哦！</div></c:when>
				<c:when test="${totalScore.point > 403.0 }"><div class="chart-aside">你稳定处于<strong>专A线</strong>，冲一冲，达到<em>本B线</em>不是梦，加油哦！</div></c:when>
				<c:when test="${totalScore.point >= 391.0 }"><div class="chart-aside">恭喜你，预测你的高考很有机会达到<strong>专A线</strong>，不过还不够保险，再提<em>${404 - totalScore.point }</em>分以上，就胜券在握了。</div></c:when>
				<c:when test="${totalScore.point >=367.0 }"><div class="chart-aside">哎呀，就差一点就上<strong>专A线</strong>了，不要灰心，只要再提<em>${391 - totalScore.point }</em>分以上，就有机会达到<em>专A线</em>了，加油哦！</div></c:when>
				<c:when test="${totalScore.point < 367.0 }"><div class="chart-aside">哎呀，离<strong>专A线</strong>还有一定距离哦，不要灰心，只要再提<em>${391 - totalScore.point }</em>分以上，就有机会达到<em>专A线</em>了，加油哦！</div></c:when>
				</c:choose>
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
                
				<c:choose>
				<c:when test="${totalScore.point > 556.0 }"><div class="chart-aside">恭喜你，预测你的高考稳定处于<strong>一本线</strong>，不要骄傲，保持低调！</div></c:when>
                <c:when test="${totalScore.point >= 551.0 }"><div class="chart-aside">恭喜你，预测你的高考很有机会达到<strong>一本线</strong>，不过还不够保险，再提<em>${557 - totalScore.point }</em>分以上，就胜券在握了。</div></c:when>
                <c:when test="${totalScore.point >= 540.0 }"><div class="chart-aside">哎呀，就差一点就上<strong>一本线</strong>了，不要灰心，只要再提<em>${551 - totalScore.point }</em>分以上，就有机会达到<em>一本线</em>了，加油哦！</div></c:when>
                <c:when test="${totalScore.point > 489.0 }"><div class="chart-aside">你稳定处于<strong>本A线</strong>，冲一冲达到<em>一本线</em>不是梦。加油哦！</div></c:when>
                <c:when test="${totalScore.point >= 484.0 }"><div class="chart-aside">恭喜你，预测你的高考很有机会达到<strong>本A线</strong>，不过还不够保险，再提<em>${490 - totalScore.point }</em>分以上，就胜券在握了。</div></c:when>
                <c:when test="${totalScore.point >= 467.0 }"><div class="chart-aside">哎呀，就差一点就上<strong>本A线</strong>了，不要灰心，只要再提<em>${484 - totalScore.point }</em>分以上，就有机会达到<em>本A线</em>了，加油哦！</div></c:when>
				<c:when test="${totalScore.point > 432.0 }"><div class="chart-aside">你稳定处于<strong>本B线</strong>，冲一冲，达到<em>本A线</em>不是梦，加油哦！</div></c:when>
				<c:when test="${totalScore.point >= 427.0 }"><div class="chart-aside">恭喜你，预测你的高考很有机会达到<strong>本B线</strong>，不过还不够保险，再提${433 - totalScore.point }分以上，就胜券在握了。</div></c:when>
				<c:when test="${totalScore.point >= 405.0 }"><div class="chart-aside">哎呀，就差一点就上<strong>本B线</strong>了，不要灰心，只要再提${427 - totalScore.point }分以上，就有机会达到<em>本B线</em>了，加油哦！</div></c:when>
				<c:when test="${totalScore.point > 359.0 }"><div class="chart-aside">你稳定处于<strong>专A线</strong>，冲一冲，达到<em>本B线</em>不是梦，加油哦！</div></c:when>
				<c:when test="${totalScore.point >= 348.0 }"><div class="chart-aside">恭喜你，预测你的高考很有机会达到<strong>专A线</strong>，不过还不够保险，再提<em>${360 - totalScore.point }</em>分以上，就胜券在握了。</div></c:when>
				<c:when test="${totalScore.point >= 326.0 }"><div class="chart-aside">哎呀，就差一点就上<strong>专A线</strong>了，不要灰心，只要再提<em>${348 - totalScore.point }</em>分以上，就有机会达到<em>专A线</em>了，加油哦！</div></c:when>
				<c:when test="${totalScore.point < 326.0 }"><div class="chart-aside">哎呀，离<strong>专A线</strong>还有一定距离哦，不要灰心，只要再提<em>${348 - totalScore.point }</em>分以上，就有机会达到<em>专A线</em>了，加油哦！</div></c:when>
				</c:choose>
                </c:if>

                
            </section>
            <section>
                <h3>学科整体诊断</h3>
                <p class="h-aside">分析优劣学科情况，有效评估学习现状，走出一模后备考误区，明确最优提分科目。</p>
                <table class="score-table p-order">
                    <caption>和同分数段考生比较，你的优劣学科排序如下:</caption>
                    <tr>
                        <th colspan="${fn:length(subjectList) }">
                            <div class="th">
                                <span class="flo-l">优势科目</span>
                                <span class="flo-r">薄弱科目</span>
                                <div class="dir"></div>
                            </div>
                        </th>
                    </tr>
                    <tr>
                    	<c:set var="topSubjectDesc" value=""></c:set>
                    	<c:set var="lowerSubjectDesc" value=""></c:set>
                    	<c:set var="lowerSubject" value=""></c:set>
                        <c:forEach var="score" items="${subjectList }" varStatus="status">
                		<td>${score.exam_subject }</td>
                		<c:if test="${status.first }">
                			<c:set var="topSubjectDesc" value="${score.exam_subject }是${score.cha_tongfen_point < 0.0 ? '劣势' : '优势' }最明显的科目，${score.cha_tongfen_point < 0.0 ? '落后' : '领先' }于${score.target_point }分考生(同分数段)${score.cha_tongfen_point < 0.0 ? '<em>' : '<strong>' }${fn:replace(score.cha_tongfen_point,'-','') }${score.cha_tongfen_point < 0.0 ? '</em>' : '</strong>' }分"></c:set>
                		</c:if>
                		<c:if test="${status.index == (fn:length(subjectList) - 2) }">
                			<c:set var="lowerSubject" value="${score.exam_subject }"></c:set>
                		</c:if>
                		<c:if test="${status.last }">
                			<c:set var="lowerSubject" value="${score.exam_subject }、${lowerSubject }"></c:set>
                			<c:set var="lowerSubjectDesc" value="${score.exam_subject }是${score.cha_tongfen_point < 0.0 ? '劣势' : '优势' }最明显的科目，${score.cha_tongfen_point < 0.0 ? '落后' : '领先' }于${score.target_point }分考生(同分数段)${score.cha_tongfen_point < 0.0 ? '<em>' : '<strong>' }${fn:replace(score.cha_tongfen_point,'-','') }${score.cha_tongfen_point < 0.0 ? '</em>' : '</strong>' }分"></c:set>
                		</c:if>
                		</c:forEach>
                    </tr>
                    <tr>
                        <c:forEach var="score" items="${subjectList }" varStatus="status">
                		<td class="${score.cha_tongfen_point < 0.0 ? 'c-red' : 'c-blue' }">${score.cha_tongfen_point }</td>
                		</c:forEach>
                    </tr>
                </table>
                <div class="sub-compare">
                ${topSubjectDesc }；${lowerSubjectDesc }
                </div>
                <div class="sub-notice">注意：请重点关注你的劣势学科--<strong>${lowerSubject }</strong></div>
            </section>
        </article>
        <div class="analy-exp">查看为你度身定制的<strong>${lowerSubject }</strong>提分策略以及更详细的成绩分析报告，请用电脑访问以下网址：<a id="btn_yimo" href="http://edu.gd.chinamobile.com/ymsp.html" target="_blank">http://edu.gd.chinamobile.com/ymsp.html</a></div>
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
<script src="<%=basePath%>/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/istudy_minisite.js"></script>
<script type="text/javascript">
 (function() {
 	$("#btn_yimo").click(function(){
 		postUserActionRecordV2("<%=basePath%>", 'alinkclick-yimo', "${ queryStr }");
 	});
 }());
</script>
</body>
</html>
