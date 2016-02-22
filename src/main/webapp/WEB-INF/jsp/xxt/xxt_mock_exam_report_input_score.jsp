<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<%@include file="../minisite_common.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-report-input-score&${ queryStr }" width="0" height="0" style="display: none;"/>

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
            <a href="javascript:window.history.go(-1);" class="btn-prev"><span>返回</span></a>
            <h1>广一模成绩分析报告</h1>
        </header>
        <div class="page-main">
            <article class="report-item">
                <section class="sec-cap">
                    <h2>此报告结果来自权威教研部门数据分析，<br>是高考冲刺必备的指导手册。<br></h2>
                	<p>请输入成绩，生成你的个人报告：</p>
                </section>
                <section>
                    <form id="form_score" action="${commonPath }/resultnomc.do" method="post" novalidate>
                        <div class="st-sub-radio" id="subjectRadio">
                            <span><label><input type="radio" name="studyType" value="2" <c:if test="${empty inputVo.studyType || inputVo.studyType == '2' }">checked</c:if> /><strong>理科考生</strong></label></span>
                            <span><label><input type="radio" name="studyType" value="1" <c:if test="${inputVo.studyType == '1' }">checked</c:if>/><strong>文科考生</strong></label></span>
                        </div>
                        <fieldset class="st-score-i">
                            <table>
                                <tr>
                                    <th>语文</th>
                                    <th>数学</th>
                                    <th>英语</th>
                                </tr>
                                <tr>
                                    <td><input type="number" name="yuwen" maxs="150" class="scoreInput" title="语文" value="${inputVo.yuwenAsString }" /></td>
                                    <td><input type="number" name="shuxue" maxs="150" class="scoreInput" title="数学" value="${inputVo.shuxueAsString }" /></td>
                                    <td><input type="number" name="yingyu" maxs="150" class="scoreInput" title="英语" value="${inputVo.yingyuAsString }" /></td>
                                </tr>
                            </table>
                            <div class="sub-list" id="subjectList">
                                <table id="lk" ${inputVo.studyType == '1' ? 'class="d-none"' : '' }>
                                    <tr>
                                        <th>物理</th>
                                        <th>化学</th>
                                        <th>生物</th>
                                    </tr>
                                    <tr>
                                        <td><input type="number" name="wuli" maxs="100" class="scoreInput" title="物理" value="${inputVo.wuliAsString }" /></td>
                                        <td><input type="number" name="huaxue" maxs="100" class="scoreInput" title="化学" value="${inputVo.huaxueAsString }" /></td>
                                        <td><input type="number" name="shengwu" maxs="100" class="scoreInput" title="生物" value="${inputVo.shengwuAsString }" /></td>
                                    </tr>
                                </table>
                                <table id="wk" ${empty inputVo.studyType || inputVo.studyType == '2' ? 'class="d-none"' : '' }>
                                    <tr>
                                        <th>政治</th>
                                        <th>历史</th>
                                        <th>地理</th>
                                    </tr>
                                    <tr>
                                        <td><input type="number" name="zhengzhi" maxs="100" class="scoreInput" title="政治" value="${inputVo.zhengzhiAsString }" /></td>
                                        <td><input type="number" name="lishi" maxs="100" class="scoreInput" title="历史" value="${inputVo.lishiAsString }" /></td>
                                        <td><input type="number" name="dili" maxs="100" class="scoreInput" title="地理" value="${inputVo.diliAsString }" /></td>
                                    </tr>
                                </table>
                            </div>
                        </fieldset>

                        <input type="submit" class="s-red-btn" value="生成报告">
                        
                        <p class="exp-input">温馨提示：您输入的分数我们会严格保密，只有您自己可以看到。</p>
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
        	var studyType = $("input[name=studyType]");
        	studyType.change(function(){
        		var val = $("input[name=studyType]:checked").val();
        		if(val == '1'){
        			$("#wk").show();
        			$("#lk").hide();
        		}else if(val == '2'){
        			$("#wk").hide();
        			$("#lk").show();
        		}
        	});
        	studyType.change();
        	
            
            var form_score = $("#form_score");
            form_score.submit(function(){
            	var total = 0;
            	var scores = form_score.find("input.scoreInput:visible");
            	var flag = true;
            	scores.each(function(){
            		var $this = $(this);
            		var val = $this.val();
            		var title = $this.attr("title");
            		if(!val){
            			alert(title + "分数不能为空")
            			this.focus();
            			return (flag = false);
            		}
            		if(isNaN(val)){
            			alert(title +"分数只能输入数字！");
            			this.focus();
            			return (flag = false);
            		}
            		var nval = (Number(val) + "");
            		var index = nval.indexOf(".");
            		if(index > -1 && nval.substring(index) != ".5" ){
            			alert(title +"分数小数点后只能为5，如90.5！");
            			this.focus();
            			return (flag = false);
            		}
            		
            		var maxs = $this.attr("maxs");
            		if(nval > Number(maxs)){
            			alert(title +"分数不能高于" + maxs + "！");
            			this.focus();
            			return (flag = false);
            		}
            		
            		if(nval < 0){
            			alert(title +"分数不能低于0分！");
            			this.focus();
            			return (flag = false);
            		}
            		
            		total = total + Number(val);
            	});
            	
            	if(flag == false){
            		return false;
            	}
            	
            	if(total < 100){
            		alert("总分不得小于100分！");
            		return (flag = false);
            	}
            	
            	
            });
        }());
    </script>
</body>
</html>
