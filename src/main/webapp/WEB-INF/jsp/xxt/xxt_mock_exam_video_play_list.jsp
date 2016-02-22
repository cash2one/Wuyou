<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<%@include file="../minisite_common.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-vedioplaylist-${ subject }&${ queryStr }" width="0" height="0" style="display: none;"/>
<%@include file="xxt_mock_exam_video_map.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, user-scalable=yes"/>
<link rel="stylesheet" href="<%=basePath%>/css/minisite_layout.css?v3.4">
<script src='<%=basePath%>/js/polyvplayer.min.js'></script>
</head>
<body class="bg-white">
<div id="page">
    <header class="page-header">
        <a href="javascript:history.go(-1);" class="back">返回</a>
        <h1 class="small">${subjectName }</h1>
    </header>
    <div class="page-main">
        <div class="s-video">
        <ul class="s-qus-list">
	       	<c:forEach var="item" begin="${empty contentStart ? 1 : contentStart }" end="${contentEnd }" step="1" varStatus="status">
	       	<c:set var="itemQ">{${item }}</c:set>
	       	<c:if test="${(empty excludeStart || empty excludeEnd || (item > excludeEnd || item < excludeStart)) && (empty exclude || !fn:contains(exclude,itemQ)) }">
		       	<li>
		       	<c:set var="key" value="${subject }-${item }"></c:set>
		       	<c:set var="vid" value="${videoMap[key] }"></c:set>
		       	<img src="${basePath }/img/yimo/${subject }/${item }_q.png" />
		       	<img src="${basePath }/img/yimo/${subject }/${item }_a.png" />
		       	<c:if test="${not empty vid }">
		       		<div class="load-t-video">
		       			<div class="article-video" style="display: none;">
		       				<div id='mainv${vid }_div'></div>
		       			</div>
		        		<img alt="播放视频" class="video-ctrl" src="${basePath }/img/loading-video.jpg" 
		        		data-id="${vid }" />
		       		</div>
		       	</c:if>
		       	</li>
	       	</c:if>
	       	</c:forEach>
        </ul>
        </div>
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
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".video-ctrl").one("click",function(){
			var $this = $(this);
			var data_id = $this.attr("data-id");
			new polyvObject.swf('http://player.polyv.net/videos/'+data_id+'.swf','mainv' + data_id,'600','337');
			$this.remove();
			$("#mainv" + data_id + "_div").parent().show();
		});
		//$(".video-ctrl").click();
	});
</script>
</body>
</html>
