<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建资源</title>
<!--[if lte IE 8]>
    <script src="<%=basePath%>/js/html5.js"></script>
<![endif]-->
<link rel="stylesheet" href="css/layout.css?v0.01">
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="js/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="js/ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript" src="js/istudy-cms.js"></script>

</head>
<body class="bc-white">
    <div id="page" class="pos-r">
        <div class="cms-container">
            <div class="location">
                <strong>添加/编辑企业</strong>
            </div>
            <div class="cms-main clearfix edit-cms-main">
                <form id="resource_div" class="form-item edit-cms-item">
                    <fieldset class="sms-edit">
                        <h2>企业信息</h2>
                        <input type="hidden" name="enterpriseID" id="enterpriseID" value="${result.enterpriseID }" />
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>企业名称：</label>
                            <div class="label-con">
                            	<input type="text" name="enterpriseName" value="${result.enterpriseName }" id="enterpriseName" class="txt-input" />
                            </div>
                        </div>
                        
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>企业描述：</label>
                            <div class="label-con">
                               <textarea rows="5" cols="80" name="enterpriseDesc" id="enterpriseDesc" >${result.enterpriseDesc }</textarea>
                            </div>
                        </div>
                        
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>页眉描述：</label>
                            <div class="label-con">
                               <input type="text" name="enterpriseHeader" value="${result.enterpriseHeader }" id="enterpriseHeader" class="txt-input" />
                            </div>
                        </div>
                        
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>页脚属性：</label>
                            <div class="label-con">
                            <c:if test="${!empty result.enterpriseFooter }">
								<c:forEach var="footer" items="${footerList }" varStatus="status">
									<div style="margin: 5px;">
									<input type="radio" value="${footer }" <c:if test="${footer==result.enterpriseFooter }">checked</c:if> name="enterpriseFooter" id="enterpriseFooter" />
										<div style="width: 300px; display: inline-block;" >
                           				<jsp:include page="../minisite_footer_logo.jsp" flush="true">
											<jsp:param name="footerId" value="${footer }"></jsp:param>
										</jsp:include>  
										</div>
									</div>              				
                				</c:forEach>
                            </c:if>
                            <c:if test="${empty result.enterpriseFooter }">
                            	<c:forEach var="footer" items="${footerList }" varStatus="status">
									<div style="margin: 5px;">
									<input type="radio" value="${footer }" name="enterpriseFooter" id="enterpriseFooter" />
                           				<div style="width: 300px; display: inline-block;" >
                           					<jsp:include page="../minisite_footer_logo.jsp" flush="true">
												<jsp:param name="footerId" value="${footer }"></jsp:param>
											</jsp:include>
                           				</div>
                           			</div>              				
                				</c:forEach>
                            </c:if>
                            </div>
                        </div>
                        
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>厂商类别：</label>
                            <div class="label-con">
                               <select id="vendorType" name="vendorType">
                               		<option value="0"></option>
                               		<option value="1" <c:if test="${result.vendorType == '1'}">selected="selected"</c:if>>第三方CP</option>
                               		<option value="2" <c:if test="${result.vendorType == '2'}">selected="selected"</c:if>>爱学网小编</option>
                              		<option value="3" <c:if test="${result.vendorType == '3'}">selected="selected"</c:if>>校讯通官方</option>
                               </select>
                            </div>
                        </div>
                    </fieldset>

                    <a href="javascript:saveEnterpriseAndMsg(this);" id="save_form_data" class="btn-submit">保存</a>
                </form>
            </div>
        </div>
    </div>
    <div class="overlay-white" id="taskListOverlay"></div>
    <div class="msgbox-key" id="taskListMsgbox">
    	<iframe id="choseIFrame" src="" width="500" height="700" frameborder="0"></iframe>
    </div>
</body>
<script type="text/javascript">
	var basePath = "${basePath }";
        
		function setValue2Footer(val){
			$("#enterpriseFooter").val(val);
		}
	
        function validation(){
        	var enterpriseName = $('#enterpriseName').val(),
        	enterpriseDesc = $('#enterpriseDesc').val(),
        	vendorType = $('#vendorType').val(),
        	enterpriseHeader = $("#enterpriseHeader").val(),
        	enterpriseFooter = $("[name=enterpriseFooter]");
        	if($.isNull(enterpriseName)){
        		return "企业名称不能为空";
        	}
        	 if($.isNull(enterpriseDesc)){
     			return "企业描述不能为空";
     		}
        	if($.isNull(enterpriseHeader)){
        		return "页眉描述不能为空";
        	}
        	var count=0;
        	for(var i=0;i<enterpriseFooter.length;i++){
        		if(enterpriseFooter[i].checked){
        			++count;
        		}
        	}
        	if(count==0){
        		return "请选择页脚样式";
        	}
        	if(vendorType==0){
        		return "请选择厂商类别";
        	}
        	return null;
        }
        
        function saveEnterpriseAndMsg(obj){
        	var footers = $("[name=enterpriseFooter]");
        	var enterpriseCheckFooter = undefined;
        	for(var i=0;i<footers.length;i++){
        		if(footers[i].checked){
        			enterpriseCheckFooter = footers[i].value;
        		}
        	}
        	var resouce = {
        			enterpriseID   : $('#enterpriseID').val(),
        			enterpriseName : $('#enterpriseName').val(),
        			enterpriseDesc : $('#enterpriseDesc').val(),
        			vendorType : $('#vendorType').val(),
        			enterpriseHeader : $("#enterpriseHeader").val(),
                	enterpriseFooter : enterpriseCheckFooter
        	};
        	var msg = validation();
        	if(msg){
       			alert(msg);
       			return ;
        	}
        	$(obj).attr("disabled","disabled");
        	var enterpriseID = $('#enterpriseID').val();
        	if(enterpriseID){
        		$.ajax({
              		 type: "POST",
              		 url: "enterprise/modiEnterpriseInfo.do",
              		 data: eval(resouce),
              		 dataType: "json",
              		 success: function(obj){
              			 var msg = obj.desc;
              			 alert(msg);
              			 location.href = '<%=basePath %>enterprise/showPaging.do?target=enterprise_list';
              		 }
              		});
        	}else{
        		$.ajax({
           		 type: "POST",
           		 url: "enterprise/saveEnterpriseInfo.do",
           		 data: eval(resouce),
           		 dataType: "json",
           		 success: function(obj){
           			 var msg = obj.desc+",是否继续添加资源";
   					 if(confirm(msg)){
   						location.reload(); 
   					 }else{
   						parent.hideDeleteIframe();
   					 }
           		 }
           		});
        	}
        }
        
    var $overlay = $("#taskListOverlay"),
   	$msgbox = $("#taskListMsgbox"),
   	$choseIFrame = $("#choseIFrame");

    function choseFooter(){
    	$choseIFrame.attr('src', './enterprise/getFooterPage2Set.do');
    	$overlay.show();
    	$msgbox.css("width","500").css("height","700").css("top", "0").show();
    }

    function choseRole(url){
    	$choseIFrame.css("width","600").css("height","500").attr('src', url);
    	$overlay.show();
    	$msgbox.css("width","600").css("height","500").css("top", "0").show();
    }

    function hideDeleteIframe(enterpriseID,enterpriseName) {
    	$overlay.hide();
    	$msgbox.hide();
    	if(enterpriseID){
    		location.href='<%=basePath %>accounts/showPaging.do?target=account_list&enterpriseID='+enterpriseID+'&enterprise_Name='+enterpriseName;
    	}
    }

    $("#taskListOverlay").click(function() {
    	hideDeleteIframe();
    });
</script>
</html>
