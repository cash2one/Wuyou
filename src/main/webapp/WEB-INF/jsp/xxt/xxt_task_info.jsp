<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../common.jsp"%>
<c:set var="queryStr" value="cityId=${cityId }&userid=${userId }&idtype=99&miniUri=${miniUri }"></c:set>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-task&${ queryStr }" width="0" height="0" style="display: none;"/>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务信息</title>

<link rel="stylesheet" href="<%=basePath%>css/layout.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/istudy-cms.js"></script>
<script type="text/javascript" src="<%=basePath%>js/date_picker/WdatePicker.js"
	defer="defer"></script>
<script src="<%=basePath%>js/custom.js?v=0.1"></script>
<script src="<%=basePath%>js/istudy_minisite.js"></script>
</head>
<body>
	<div id="page">
		<div class="page-main">
			<fieldset class="form-item">
				<div class="L clearfix">
					<label class="label">短信标题：</label>
					<div class="label-con">
						<div class="con-strong">${task.taskName }</div>
					</div>
					<label class="label">类型：</label>
					<div class="label-con">
						<div class="con-strong">${task.typeName }</div>
					</div>
				</div>

				<div class="L clearfix">
					<label class="label">短信内容：</label>
					<div class="label-con">
						<textarea name="" id="msgDetails" class="txta sms-txta">${task.msgDetails }</textarea>
						<div>
							<a style="color: #00e" href="javascript:void();"  id="showStylePreview">最终样式预览</a>
						</div>
						<div class="style-preview" id="stylePreview"></div>
					</div>
					
				</div>
				
				<div class="L clearfix">
					<label class="label">备注：</label>
					<div class="label-con">
						<div class="con-em">${task.remark }</div>
					</div>
				</div>
				<input type="hidden" id="key1" value="${key[0].keyWord }">
				
				<c:if test="${ task.miniUrl == '14036147344130' }">
				<div class="L clearfix" id="key" <c:if test="${empty key  }">style="display:none;"</c:if>>
					<label class="label">已获得邀请码：</label>
					<div class="label-con">
						 邀请码1：<strong id="keyWord1">${key[0].keyWord }</strong>，<br>
						 邀请码2：<strong id="keyWord2">${key[1].keyWord }</strong>，<br>
						 邀请码3：<strong id="keyWord3">${key[2].keyWord }</strong>，<br>
						 您可以选择发送班上的贫困生。<br>
						 邀请码使用方法：<br>
						 打开志愿填报系统首页：<a href="http://www.istudy.com.cn/zhiyuan" target="_blank">http://www.istudy.com.cn/zhiyuan</a><br>
						 在【我有邀请码】一栏中输入即可。
					</div>
				</div>
				</c:if>
				<div class="L clearfix">
					<c:if test="${task.type!=0 }">
						<label class="label">图文预览：</label>
					</c:if>

					<div class="label-con">
						<c:if test="${task.type!=0 }">
							<div>
								<iframe id="show_minisite" scrolling="yes" width="450px"
									height="400px" frameborder="0" marginwidth="0px"
									marginheight="0px"
									src="<%=basePath%>xxtM/mPage.do.do?uri=${task.miniUrl}"></iframe>
							</div>
						</c:if>
						<div class="send-opts">
							<span class="l-sel"> <input type="radio" checked="checked"
								name="sendType" value="0" id="forthwidthSend"><label
								for="forthwidthSend">即时发送</label>
							</span> <span class="l-sel"> <input type="radio" name="sendType"
								id="timingSend" value="1"><label for="timingSend">定时发送</label>
								<input type="text" size="25" id="sendTime"
								onClick="WdatePicker({autoPickDate:true,startDate:'%y-%M-%d 09:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d 09:00:00',alwaysUseStartDate:true})"
								class="Wdate">
							</span>
						</div>
					</div>
				</div>

				<div class="L clearfix">
					<label class="label">发送对象：</label>
					<div class="label-con send-obj-opts" id="sendObjOpts">
						<div class="tab-nav">
							<a name="allClass" href="javascript:;" class="cur">发全班</a> <a
								name="allStudent" href="javascript:;">发个人</a>
						</div>
						
						<style>
							.opts-class .list li{display:inline-block;*display:inline;zoom:1;margin:5px;}
						</style>
						<div class="tab-item">
							<div class="opts-class clearfix">
								<div class="title">选择班级</div>
								<ul class="list">
									<c:forEach var="c" items="${classes}" varStatus="status">
										<li><label><input type="checkbox" name="class" id="class"
											value="${c.classId}" ssize="${fn:length(c.students)}">
											${c.className }</label>
										</li>
										<li>
											<div id="student_div" style="display: none">
												<c:forEach var="s" items="${c.students }">
													<span><input type="checkbox"
														student="${s.parentIds }" student_name="${s.realName }"
														id="studentId" value="${c.classId }_${s.parentIds }" />${s.realName }</span>
												</c:forEach>
											</div>
										</li>
									</c:forEach>

								</ul>
							</div>

							<!-- 发送个人选项，默认隐藏 -->
							<div class="opts-per" id="persorOpts" style="display: none;">
								<div id="student_pool" class="sel-item">
									<!--  <span><input type="checkbox" name="person" id="personOpts01">谢少春1</span> -->
								</div>

								<div class="sel-result">
									<div class="title">
										您已选择了<strong id="studentNum">0</strong>名学生
									</div>
									<div class="value" id="selectResult"></div>
								</div>
							</div>
						</div>
					</div>

					<script>
						fnSendObj();
					</script>
				</div>
				<a href="javascript:sendMsgToPatriarch();" id="sendButton"
					class="btn-submit">确认发送</a> 
					<span style="color: red;"
					id="error_msg"></span>
				
			</fieldset>
		</div>
	</div>
	
	<div class="overlay-white" id="overlayWhite"></div>
	
	<div class="msgbox-key" id="msgboxKey">
		<h4>短信推送成功！</h4>
		
		<p>恭喜您获得3个免费使用志愿填报系统的邀请码：<strong id="boxKeyWord1"></strong>，<strong id="boxKeyWord2"></strong>，<strong id="boxKeyWord3"></strong>，您可以选择发送班上的贫困生，每个激活码只能发给一个人噢。详情访问：<a href="http://www.istudy.com.cn/zhiyuan" target="_blank">http://www.istudy.com.cn/zhiyuan。</a></p>
		
		<a href="javascript:;" class="btn-submit">确 定</a>
	</div>
</body>

<script type="text/javascript">

	$(document).ready(function(){
		
		
		
		
	});
	
	
	function validate(sourceType) {
		var sendType = $('input[name=sendType]:checked').val(), msgDetails = $(
				'#msgDetails').val(), sendTime = $('#sendTime').val();
		if (msgDetails.length > 200) {
			return "短信内容字数不能超过200个";
		}
		if ($.isNull(msgDetails)) {
			return "短信内容不能为空";
		}
		if (sendType == '1') {
			if ($.isNull(sendTime)) {
				return "定时发送时间不能为空";
			}
		}

		//班级
		if (sourceType == '0') {
			if ($('input[name=class]:checked').length == 0) {
				return "请选择班级";
			}else{
				var user = getUsers(sourceType);
				if(!user.userIds){
					return "您选择的班级不包含任何学生";
				}
			}
		} else {//学生
			if ($('input[id=studentId]:checked').length == 0) {
				return "请选择学生";
			}
		}

	}
	function getType() {
		var type = '1', typeName = $('.cur').attr('name');//allClass , allStudent
		if (typeName == 'allClass') {
			type = '0';
		}
		;
		return type;
	}
	function getUsers(type) {

		var userIds = "";
		var userNames = "";
		if (type == '0') {
			$('input[name=class]:checked').each(function(i) {
				/*userIds += $(this).val()+",";
				userNames+=$(this).siblings("label").html()+",";*/
				$(this).parents('li').next().find('input[id=studentId]').each(function(i) {
					userIds += $(this).attr('student') + ",";
					userNames += $(this).attr('student_name') + ",";
				});
			});
		} else {
			$('#student_pool input[id=studentId]:checked').each(function(i) {
				userIds += $(this).attr('student') + ",";
				userNames += $(this).attr('student_name') + ",";
			});
		}
		if (userIds.length > 0) {
			userIds = MyString.excLast(userIds);
		}
		var user = {
			userIds : userIds,
			userNames : userNames
		}
		return user;
	}
	
	
		     
	
	
	function sendMsgToPatriarch() {
		var t = getType();
		
		msg = validate(t);
		if (msg) {
			alert(msg);
			return;
		}
		
		
		
		var user = getUsers(t), source = {
			msgDetails : $('#msgDetails').val(),
			sendType : $('input[name=sendType]:checked').val(),
			sendTime : $('#sendTime').val(),
			sendUsers : user.userIds,
			userId : '${userId }',
			taskId : '${task.id }',
			type : t,
			taskName : '${task.taskName }',
			miniUrl : '${task.miniUrl}',
			miniType : '${task.type }',
			minisiteId : '${task.minisiteId }',
			teaCity : '${cityId}',
			sendNames : MyString.excLast(user.userNames),
			amountUsers : $('#studentNum').html(),
			teaName : '${teacher.teacherName}',
			schoolName : '${school.schoolName}'
		};
		if (source.type == 0) {//统计班级
			source.amountUsers = getStudentSize();
		}
		$('#sendButton').attr('href', 'javascript:;');
		$('#sendButton').attr('disabled', true);
		
		$.ajax({
			type : "POST",
			url : "<%=basePath%>xxtTask/saveTeacherSendMsg.do",
			data : eval(source),
			dataType : "json",
			success : function(obj) {
				alert(obj.desc);
				if(obj.code == "10000"){
					$("#sendButton").hide();
					
					eventPush("<%=basePath%>",'${queryStr }',"btnclick-push");
					
					var key = $('#key1').val();
					var userSource = {
						userId : '${userId }',
						cityId : '${cityId}'
					};
					//14036147344130
					if(!key && '${task.miniUrl}' == '14036147344130'){
						$.ajax({
							type : "POST",
							url : "<%=basePath%>xxtTask/getUserKey.do",
							data : eval(userSource),
							dataType : "json",
							success : function(obj){
								$("#keyWord1").html(obj[0].keyWord);
								$("#keyWord2").html(obj[1].keyWord);
								$("#keyWord3").html(obj[2].keyWord);
								
								$("#key").show();
								
								$("#boxKeyWord1").html(obj[0].keyWord);
								$("#boxKeyWord2").html(obj[1].keyWord);
								$("#boxKeyWord3").html(obj[2].keyWord);
								
								$("#overlayWhite").show();
								window.scrollTo(0, 0);
								$("#msgboxKey").css("top", 450).show();
								
							}
						});
					}else{
						//window.location.href = "<%=basePath%>xxtTask/showPaging.do?target=xxt_task_his_list&userId=${userId}";
					}
				}
				//window.location.reload();
				//history.go(-1);
			}
		/* ,error:function(XMLHttpRequest, textStatus, errorThrown) {   
		alert(XMLHttpRequest.status+","+XMLHttpRequest.readyState+","+textStatus);  
		} */
		});
		
	}
	
	$("#msgboxKey .btn-submit").click(function() {
		$("#overlayWhite").hide();
		$("#msgboxKey").hide();
	});
	
	

	function getStudentSize() {
		var ssize = 0;
		$('input[name=class]:checked').each(function() {
			ssize += parseInt($(this).attr("ssize"));
		});
		return ssize;
	}
	
	(function() {
		var $stylePreview = $("#stylePreview"),
			$showStylePreview = $("#showStylePreview");
		
		$stylePreview.html("【${school.schoolName}】XXX家长，你好！" +
				$('#msgDetails').val() +
				" 手机打开http://t.cn/xxxxxx【${teacher.teacherName}老师】");
		
		var _left = $showStylePreview.position().left,
			_top = $showStylePreview.position().top;
		
		var timeOut = 0;
		$showStylePreview.hover(function() {
			$stylePreview.html("【${school.schoolName}】XXX家长，你好！" +
					$('#msgDetails').val() +
					" 手机打开http://t.cn/xxxxxx【${teacher.teacherName}老师】");
			clearTimeout(timeOut);
			$stylePreview.css({left: _left, top: _top}).show();
		}, function() {
			timeOut = setTimeout(function() {
				$stylePreview.hide();
			}, 500);
		});
		
		$stylePreview.hover(function() {
			clearTimeout(timeOut);
		}, function() {
			timeOut = setTimeout(function() {
				$stylePreview.hide();
			}, 500);
		});
	}());
</script>
</html>