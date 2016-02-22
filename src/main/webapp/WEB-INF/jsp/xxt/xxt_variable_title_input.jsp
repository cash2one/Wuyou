<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="xxt_variable_title_header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.5, user-scalable=yes">
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-bst-input&${ queryStr }" width="0" height="0" style="display: none;"/>
<script type="text/javascript">
	_hmt.push(['_trackEvent', '广一模变式题', '进入考号姓名输入页面', '${cityId }${userid }']);
</script>
</head>
<body>
    <div id="page">
        <header class="page-header">
            <h1>广一模变式训练</h1>
        </header>
        <div class="page-main">
            <article class="report-item">
                <section class="sec-cap">
                	<h2>广一模变式题</h2>
                	<p>请输入你的一模考号和姓名，以根据你的薄弱知识点推送有针对性的变式题，最大限度提高你的复习功率。</p>
                </section>
                <section>
                    <form id="form_score" name="form_score" action="${commonPath }/varmatcher.do" method="post" >
                        <fieldset class="u-login-i">
                        	<legend>输入广一模考号和姓名</legend>
                            <div class="L">
                                <label for="examno">考号：</label>
                                <span><input name="ticketNo" id="examno" type="number" value="${cookie.ticketNo.value }"/></span>
                            </div>
                            <div class="L">
                                <label for="name">姓名：</label>
                                <span><input name="realName" id="name" type="text" value="${realName }"/></span>
                            </div>
                        </fieldset>
                        <input type="submit" class="s-red-btn" value="获取我的变式题">
                    </form>
                </section>
            </article>
        </div>
        <%@ include file="xxt_variable_title_footer.jsp" %>
    </div>

    <script src="<%=basePath%>/js/jquery-1.11.0.min.js"></script>
    <script>
        (function() {
            var form_score = $("#form_score");
            form_score.submit(function(){
            	var $examno = $("#examno");
            	var examno = $examno.val();
            	if(!examno){
            		alert("请填写考号！");
            		$examno[0].focus();
            		return false;
            	}
            	
            	if(examno && !/^[0-9]{10}$/.test(examno)){
            		alert("考号只能为10位数字！");
            		$examno[0].focus();
            		return false;
            	}
            	
            	var $name = $("#name");
            	var name = $name.val();
            	if(!name){
            		alert("请填写姓名！");
            		$name[0].focus();
            		return false;
            	}
            	
            	if(name && !/^[\u4e00-\u9fa5]{2,5}$/.test(name)){
            		alert("姓名只能为2到5个汉字！");
            		$name[0].focus();
            		return false;
            	}
            });
        }());
    </script>
</body>
</html>
