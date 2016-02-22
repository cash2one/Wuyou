<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>study</title>
<link rel="stylesheet" href="../../css/layout.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
</head>
<body>
    <div class="cms-container">
        <div class="location">
            <a href="">添加/编辑资源</a> > <strong>资源库</strong>
        </div>

        <div class="cms-main">
            <h2 class="faq-title">选定资源：【家长会】${minisite.title }</h2>

            <fieldset class="faq-item">
                <legend>添加该主题的FAQ</legend>
                <ul class="faq-list" id="FAQList">
                    <%-- <li>
                        <div class="clearfix">
                            <label for="Q1" class="label">问题1</label>
                            <div class="main">
                                <input type="text" id="Q1" placeholder="问题标题" value="${faqs[0].question }">
                            </div>
                        </div>
                        <div class="clearfix">
                            <label for="A1" class="label">回答1</label>
                            <div class="main">
                                <textarea name="" id="A1" placeholder="推荐答复">${faqs[0].answer }</textarea>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="clearfix">
                            <label for="Q2" class="label">问题2</label>
                            <div class="main">
                                <input type="text" id="Q2" placeholder="问题标题" value="${faqs[1].question }">
                            </div>
                        </div>
                        <div class="clearfix">
                            <label for="A2" class="label">回答2</label>
                            <div class="main">
                                <textarea name="" id="A2" placeholder="推荐答复">${faqs[1].answer }</textarea>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="clearfix">
                            <label for="Q3" class="label">问题3</label>
                            <div class="main">
                                <input type="text" id="Q3" placeholder="问题标题" value="${faqs[2].question }">
                            </div>
                        </div>
                        <div class="clearfix">
                            <label for="A3" class="label">回答3</label>
                            <div class="main">
                                <textarea name="" id="A3" placeholder="推荐答复">${faqs[2].answer }</textarea>
                            </div>
                        </div>
                    </li> --%>
                    <c:forEach items="${faqs}" var="faq" varStatus="f">
                     
                    <li>
                    		<div class="clearfix">
                    		<label for="Q${f.index+1 }" class="label">问题${f.index+1 }</label>
                    		<div class="main">
                                <input type="text" id="Q${f.index+1 }" placeholder="问题标题" value="${faq.question }">
                            </div>
                            </div>
                            <div class="clearfix">
                    		<label for="Q${f.index+1 }" class="label">回答${f.index+1 }</label>
                    		<div class="main">
                                <textarea name="" id="A${f.index+1 }" placeholder="推荐答复">${faq.answer }</textarea>
                            </div>
                            </div>
                            </li>
                    </c:forEach>
                </ul>
            </fieldset>

            <div class="faq-handle">
                <a href="javascript:;" class="btn-add" id="btnAddFAQ">+继续添加</a>
                <a href="javascript:;" class="btn-save btn-blue" id="btnSaveFAQ">保存</a>
            </div>
        </div>
    </div>

    <script>
        (function() {

            function addFAQ() {
                var $FAQList = $("#FAQList"),
                    $btnAddFAQ = $("#btnAddFAQ");

                function create() {
                    var size = $FAQList.children().length;

                    //alert('${faqs[size].answer }');
                    var html = '<li>' +
                                    '<div class="clearfix">' +
                                        '<label for="Q' + ++size + '" class="label">问题' + size + '</label>' +
                                        '<div class="main">' +
                                            '<input type="text" id="Q' + size + '" placeholder="问题标题" value="">' +
                                        '</div>' +
                                    '</div>' +
                                    '<div class="clearfix">' +
                                        '<label for="A' + size+ '" class="label">回答' + size + '</label>' +
                                        '<div class="main">' +
                                            '<textarea name="" id="A' + size+ '" placeholder="推荐答复"></textarea>' +
                                        '</div>' +
                                    '</div>' +
                                '</li>';

                    $FAQList.append(html);
                }

                $btnAddFAQ.click(function() {
                    create();
                });
            }

            addFAQ();

            

            function responseValue() {
                var $btnSaveFAQ = $("#btnSaveFAQ");

                var FAQ = [];

                var warning = true;
                function eachValue() {
                    var $FAQListLi = $("#FAQList li");

                    FAQ = [];

                    $FAQListLi.each(function(i, t) {
                        var $Q = $(t).find("input"),
                            $A = $(t).find("textarea"),
                            QValue = $.trim($Q.val()),
                            AValue = $.trim($A.val());

                        if(QValue && !AValue) {
                            warning = false;
                            alert("请填写回答" + (i + 1));
                            $A.focus();
                            return false;
                        }

                        if(AValue && !QValue) {
                            warning = false;
                            alert("请填写问题" + (i + 1));
                            $Q.focus();
                            return false;
                        }

                        warning = true;

                        if(QValue && AValue) {
                        	if(AValue.length > 200) {
                        		warning = false;
                        		alert("回答字数不能超过200");
                        		$A.focus();
                        		return false;
                        	}
                            FAQ.push({
                                question: QValue,
                                answer: AValue
                            });
                        }
                    });
                }

                var $FAQList_firstInput = $("#FAQList input").first();

                $btnSaveFAQ.click(function() {
                    eachValue();

                    if(warning) {
                        if(FAQ.length < 1) {
                            alert("请填写至少一个问题和回答！");
                            $FAQList_firstInput.focus();
                        } else {
                            //alert(JSON.stringify(FAQ));
                            var id = '${minisite.id }',
                            	faqs = JSON.stringify(FAQ);
                            var resouce = {
                            		id: id,
                            		faqs : faqs,
                            		title : '${minisite.title }'
                        	};
                            $.ajax({
                   	   		 type: "POST",
                   	   		 url: "minisite/saveFaqs.do",
                   	   		 data: eval(resouce),
                   	   		 dataType: "json",
                   	   		 success: function(obj){
                   	   			 if(obj.code=="10000"){
                   	   				alert(obj.desc);
                   	   				window.location.href = "<%=basePath%>minisite/showPaging.do?target=minisite_list&subjectType=-1&grade=0&month=0";
                   	   			 }else{
                   	   				 alert(obj.desc);
                   	   	  			 window.location.reload();
                   	   			 }
                   	   		 }
                   	   	});
                            
                        }
                    }
                });
            }

            responseValue();
        }());
    </script>
</body>
</html>