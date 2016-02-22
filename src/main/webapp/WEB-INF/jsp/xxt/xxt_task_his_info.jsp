<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务信息</title>

<link rel="stylesheet" href="<%=basePath%>css/layout.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/istudy-cms.js"></script>
<script src="<%=basePath%>js/custom.js"></script>
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
                        <textarea name="" id="msgDetails" class="txta sms-txta" >${task.msgDetails }</textarea>
                    </div>
                </div>

                <div class="L clearfix">
                    <label class="label">备注：</label>
                    <div class="label-con">
                        <div class="con-em">${task.remark }</div>
                    </div>
                </div>

				
				<div class="L clearfix">
                    <label class="label">发送类型：</label>
                    <div class="label-con">
                        <div>
                            <span class="l-sel">
                                <input type="radio" disabled="disabled"
                                <c:if test="${task.sendType=='0' }">
                               	 checked="checked"
                                </c:if>
                                 name="sendType"
                                  value="0" id="forthwidthSend"><label for="forthwidthSend">即时发送</label>
                            </span>
                            <span class="l-sel">
                                <input type="radio" name="sendType" disabled="disabled"
                                ${task.sendType != '0' ? 'checked="checked"' : ''} 
                                id="timingSend" value="1" ><label for="timingSend">定时发送</label>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="L clearfix">
                    <label class="label">发送时间：</label>
                    <div class="label-con">
                        <div class="con-em">${task.sendTime}</div>
                    </div>
                </div>
                <div class="L clearfix">
                    <label class="label">发送状态：</label>
                    <div class="label-con">
                        <div class="con-em">${task.sendStatusInfo }</div>
                    </div>
                </div>
                
                <div class="L clearfix">
                    <label class="label">发送对象：</label>
                    <div class="label-con">
                        <div class="con-em">${task.sendNames }</div>
                    </div>
                </div>
                <c:if test="${task.miniType!=0}">
	                <div class="L clearfix">
	                    <label class="label">图文预览：</label>
	                    <div class="label-con">
	                        <div>
	                        	<iframe id="show_minisite" scrolling="yes" width="450px" height="400px" 
	        	frameborder="0" marginwidth="0px" marginheight="0px" 
	        	src="<%=basePath%>xxtM/mPage.do.do?uri=${task.miniUrl}"></iframe>
	                        </div>
	                    </div>
	                </div>
				</c:if>
				
                <a href="javascript:history.go(-1);" id="sendButton" class="btn-submit">返回</a>
            </fieldset>
        </div>
    </div>
</body>

<script type="text/javascript">
 	$().ready(function(){
 		$('input,textarea').attr({readonly:'readonly'});
 	})
</script>
</html>