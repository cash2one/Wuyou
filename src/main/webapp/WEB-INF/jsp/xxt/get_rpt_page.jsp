<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<%@include file="../minisite_common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>大嘉辉专用统计生成页</title>
</head>
<body>
	<div>
		<dl>
			<dd>postId</dd>
			<dd><input type="text" id="postId"></dd>
			<dd>title</dd>
			<dd><input type="text" id="title"></dd>
			<dd>channel</dd>
			<dd><input type="text" id="channel"></dd>
			<dd><button type="button" onclick="addPost()">添加</button></dd>
		</dl>
	</div>

	<ul>
		<li>
			<label>postIds</label><br>
			<textarea rows="" cols="" id="postIds"  style="width:500px;"></textarea>
		</li>
		<li>
			<label>titles</label><br>
			<textarea rows="" cols="" id="titles"  style="width:500px;"></textarea>
		</li>
		<li>
			<label>channels</label><br>
			<textarea rows="" cols="" id="channels"  style="width:500px;"></textarea>
		</li>
		<li>
			<label>idtype</label><br>
			<input type="text" id="idtype">
			<!-- <select id="idtype">
				<option value="post-share">普通分享</option>
				<option value="SMS-sx-wuyou">山西</option>
				<option value="SMS-sn-wuyou">陕西</option>
			</select> -->
		</li>
		<li>
			<button type="button" onclick="getRpt()">提交</button>
		</li>
		
	</ul>

	<div>
		<form action="rptauto.do" enctype="multipart/form-data" method="post">
			<input type="text" name="postIds">
			<input type="text" name="titles">
			<input type="text" name="idtype">
			<input type="text" name="channels">
			<input type="text" name="test">
			<input type="text" name="test">
			<input type="text" name="test">
			<input type="file" name="files">
			<input type="file" name="files">
			<input type="submit" value="提交">
		</form>
	</div>

<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	function addPost(){
		var postId = $("#postId").val(),
			title = $("#title").val(),
			channel = $("#channel").val(),
			postIds = $("#postIds").val(),
			titles = $("#titles").val(),
			channels = $("#channels").val();
		if(postId==""||postId==null){
			alert("postId is empty");
			return false;
		}
		if(title==""||title==null){
			alert("title is empty");
			return false;
		}
		if(channel==""||channel==null){
			alert("channel is empty");
			return false;
		}
		$("#postIds").val(postIds + "," + postId);
		$("#titles").val(titles + "," + title);
		$("#channels").val(channels + "," + channel);
	}

	function getRpt(){
		var postIds = $("#postIds").val(),
			titles = $("#titles").val(),
			channels = $("#channels").val(),
			idtype = $("#idtype").val(),
			
			p = "",
			t = "",
			c = "";
		p = postIds.substring(1);
		t = titles.substring(1);
		c = channels.substring(1);
		window.location.href="/xxtM/rptauto.do?postIds=" + p + "&titles=" + encodeURI(t) + "&channels="+ c + "&idtype=" + idtype ;
	}

</script>
</body>
</html>