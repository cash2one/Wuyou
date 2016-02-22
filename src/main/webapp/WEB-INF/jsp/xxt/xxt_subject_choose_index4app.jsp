<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="xxt_subject_choose_header.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-sc-index&${ queryStr }" width="0" height="0" style="display: none;"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>高一文理分科专题</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2, user-scalable=yes">

</head>
<body>

	<div id="page">
        <header class="page-header">
            <h1>${headTitle }</h1>
        </header>
        
        <div class="page-main">
            <article class="art">
                <section class="art-top">
                    <div class="aside">教育部考试中心</div>
                    <h2 class="ta-c mb-10">学科倾向测试</h2>
                    <p class="indent">由国家教育部权威推出，通过测试学生的兴趣、性格、逻辑推理能力、思维方式等，帮助学生了解自己文理倾向，规划自己的学业。</p>
                </section>
                <section class="art-step">
                    <div class="title">step1测</div>
                    <h4>【思维方式】</h4>
                    <img src="<%=basePath%>/img/step-01.jpg" class="pic" alt="思维方式分布图">
                </section>
                <section class="art-step">
                    <div class="title">step2测</div>
                    <h4>【学科兴趣】</h4>
                    <img src="<%=basePath%>/img/step-02.jpg" class="pic" alt="学科兴趣分布图">
                </section>
                <section class="art-step">
                    <div class="title">step3测</div>
                    <h4>【学科能力】</h4>
                    <img src="<%=basePath%>/img/step-03.jpg" class="pic" alt="学科能力倾向分布图">
                </section>
                <section class="art-step">
                    <div class="title">step4测</div>
                    <h4>【职业兴趣】</h4>
                    <img src="<%=basePath%>/img/step-04.jpg" class="pic" alt="职业兴趣分布图">
                </section>
                <section class="art-tips mb-20">
                    <div class="notice">
                        <span class="td">注：</span>
                        <div class="td">
                            <p class="mb-10">此测试服务由<strong>国家教育部考试中心</strong>提供，价值40元。</p>
                            <p><strong class="free">前1000位家长可免费获得</strong>测试卡，先到先得！</p>
                        </div>
                    </div>
                    <a href="${commonPath }/subjectChooseSubscribe.do" class="btn-apply">马上申请</a>
                </section>
            </article>
        </div>
        <%@ include file="xxt_variable_title_footer.jsp" %>
    </div>
    <script type="text/javascript">
	var commonPath = "<%=basePath%>/xxtStat/addRecordV2.do?${queryStr}&action=";
	var img = new Image();
	function postEvent(obj ,action, actionName){
		img.src=commonPath + action + "&r=" + Math.random();
	}
	</script>
</body>
</html>
