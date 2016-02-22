<%@ page pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<c:set var="basePath" value="<%=basePath%>"></c:set>
<c:set var="commonPath" value="${basePath }/${param.catalog }/${param.cityId }/${param.userid }/${param.idtype }/${param.miniUri }"></c:set>
<c:set var="queryStr" value="cityId=${param.cityId }&userid=${param.userid }&idtype=${param.idtype }&miniUri=${param.miniUri }&catalog=${param.catalog }"></c:set>
<c:choose>
<c:when test="${param.miniUri == '13965781689320' }">
<a href="${commonPath }/subjectChoose.do">
<img alt="" src="${basePath }/img/cms-article-btn.jpg" style="width:100%;height:auto;display:block;border:none;margin-top:30px;">
</a>
</c:when>
<c:when test="${param.idtype == 17 }">

            <div class="app-download">
                <div class="title">
                    <strong>更多学生发展指导资讯，请登录校讯通APP查看</strong><br>
                    <span>本周推出由广州大学新闻与传播学院党委副书记孙凌主讲的《从高校招生及职业规划看文理分科》讲座视频</span>
                </div>
                <a onclick="eventPush('${basePath}','${queryStr }','btnclick-download-android')" href="http://120.197.89.182/release/app/ios/ios_intall.html" target="_blank" class="iphone"><span>校讯通iPhone版</span></a>
                <a onclick="eventPush('${basePath}','${queryStr }','btnclick-download-ios')" href="http://120.197.89.182/release/app/android/3g.qq.com/GuangDongApp.apk" target="_blank" class="andriod"><span>校讯通Android版</span></a>
            </div>
</c:when>
<c:when test="${param.idtype == 18 }">
<div class="app-download">
                <div class="title">
                    <strong>更多高考备考策略，请登录校讯通APP查看</strong><br>
                    <span>本周推出由华师附中老师主讲的《各科高考备考策略》视频（物理、化学、生物、历史、政治、地理共6科）</span>
                </div>
                <a onclick="eventPush('${basePath}','${queryStr }','btnclick-download-android')" href="http://120.197.89.182/release/app/ios/ios_intall.html" target="_blank" class="iphone"><span>校讯通iPhone版</span></a>
                <a onclick="eventPush('${basePath}','${queryStr }','btnclick-download-ios')" href="http://120.197.89.182/release/app/android/3g.qq.com/GuangDongApp.apk" target="_blank" class="andriod"><span>校讯通Android版</span></a>
            </div>
</c:when>
<c:otherwise></c:otherwise>
</c:choose>