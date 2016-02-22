<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="xxt_variable_title_header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.5, user-scalable=yes">
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-bst-input-score&${ queryStr }" width="0" height="0" style="display: none;"/>
<script type="text/javascript">
	_hmt.push(['_trackEvent', '广一模变式题', '进入成绩输入页面', '${cityId }${userid }']);
</script>
</head>
<body>
    <div id="page">
        <header class="page-header">
            <a href="javascript:window.history.go(-1);" class="btn-prev"><span>返回</span></a>
            <h1>广一模变式训练</h1>
        </header>
        <div class="page-main">
            <article class="report-item">
                <section class="sec-cap">
                    <h2>广一模变式题</h2>
                    <p>请输入您的一模成绩，以推送有针对性的变式题，最大限度提高你的复习效率。</p>
                </section>
                <section>
                    <form id="form_score" action="${commonPath }/varresultnomc.do" method="post" novalidate>
                    	<div class="ta-c">输入广一模成绩</div>
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
