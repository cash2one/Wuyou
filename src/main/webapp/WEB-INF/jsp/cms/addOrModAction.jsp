<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建资源</title>
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
                <strong>添加/编辑功能</strong>
            </div>
            <div class="cms-main clearfix edit-cms-main">
                <form id="resource_div" class="form-item edit-cms-item">
                    <fieldset class="sms-edit">
                        <h2>功能信息</h2>
                        <input type="hidden" name="actionID" id="actionID" value="${result.actionID }" />
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>功能名称：</label>
                            <div class="label-con">
                            	<input type="text" name="actionName" value="${result.actionName }" id="actionName" class="txt-input" />
                            </div>
                        </div>
                        
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>功能描述：</label>
                            <div class="label-con">
                               <textarea rows="5" cols="80" name="actionDesc" id="actionDesc" >${result.actionDesc }</textarea>
                            </div>
                        </div>
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>功能地址：</label>
                            <div class="label-con">
                               <textarea rows="5" cols="80" name="actionURL" id="actionURL">${result.actionURL }</textarea>
                            </div>
                        </div>
                    </fieldset>

                    <a href="javascript:saveEnterpriseAndMsg(this);" id="save_form_data" class="btn-submit">保存</a>
                </form>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
	var basePath = "${basePath }";
        
        function validation(){
        	var actionName = $('#actionName').val(),
        	actionDesc = $('#actionDesc').val(),
        	actionURL = $('#actionURL').val();
        	if($.isNull(actionName)){
        		return "功能名称不能为空";
        	}
        	 if($.isNull(actionDesc)){
     			return "功能描述不能为空";
     		}
        	 if($.isNull(actionURL)){
     			return "功能地址不能为空";
     		}
        	return null;
        }
        
        function saveEnterpriseAndMsg(obj){
        	var resouce = {
        			actionName   : $('#actionName').val(),
        			actionDesc : $('#actionDesc').val(),
        			actionURL : $('#actionURL').val(),
        			actionID : $('#actionID').val()
        	};
        	var msg = validation();
        	if(msg){
       			alert(msg);
       			return ;
        	}
        	$(obj).attr("disabled","disabled");
        	var actionID = $('#actionID').val();
        	if(actionID){
        		$.ajax({
              		 type: "POST",
              		 url: "actions/modiActionInfo.do",
              		 data: eval(resouce),
              		 dataType: "json",
              		 success: function(obj){
              			 var msg = obj.desc;
              			 alert(msg);
              			 location.href = '<%=basePath %>actions/showPaging.do?target=action_list';
              		 }
              		});
        	}else{
        		$.ajax({
           		 type: "POST",
           		 url: "actions/saveActionInfo.do",
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
</script>
</html>
