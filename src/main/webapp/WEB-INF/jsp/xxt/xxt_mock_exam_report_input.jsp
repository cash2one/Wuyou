<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<%@include file="../minisite_common.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-report-input&${ queryStr }" width="0" height="0" style="display: none;"/>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广一模报告</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.5, user-scalable=yes">
<link rel="stylesheet" href="<%=basePath%>/css/minisite_layout_report.css?v2"/>
<!--[if lte IE 8]>
    <script src="<%=basePath%>/js/html5.js"></script>
<![endif]-->
</head>
<body>
    <div id="page">
        <header class="page-header">
            <h1>广一模成绩分析报告</h1>
        </header>
        <div class="page-main">
            <article class="report-item">
                <section class="sec-cap">
                	<h2>此报告结果来自权威教研部门数据分析，<br>是高考冲刺必备的指导手册。<br></h2>
                	<!-- <p>只需输入以下信息，就可免费获得：</p> -->
                </section>
                <section>
                    <form id="form_score" name="form_score" action="${commonPath }/matcher.do" method="post" >
                        <fieldset class="u-login-i">
                        	<legend>请输入考号和姓名，生成你的个人报告</legend>
                            <div class="L">
                                <label for="examno">考号：</label>
                                <span><input name="ticketNo" id="examno" type="number" value="${cookie.ticketNo.value }"/></span>
                            </div>
                            <div class="L">
                                <label for="name">姓名：</label>
                                <span><input name="realName" id="name" type="text" value="${realName }"/></span>
                            </div>
                        </fieldset>
                        <input type="submit" class="s-red-btn" value="确 认" />
                    </form>
                </section>
            </article>
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
