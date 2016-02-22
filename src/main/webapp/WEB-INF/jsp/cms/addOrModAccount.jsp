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
                <strong>添加/编辑账户</strong>
            </div>
            <div class="cms-main clearfix edit-cms-main">
                <form id="resource_div" class="form-item edit-cms-item">
                	<input type="hidden" id="identifier" value="${result.username }"/>
                    <fieldset class="sms-edit">
                        <h2>账户信息</h2>
                        <input type="hidden" name="enterpriseID" id="enterpriseID" value="${enterpriseID }" />
                        <input type="hidden" name="enterprise_Name" id="enterprise_Name" value="${enterprise_Name }" />
                        <div class="L clearfix">
                        	<c:if test="${result.username == null }">
                            <label class="label"><span style="color: red">*</span>账户：</label>
                            <div class="label-con">
								<input type="text" name="username" id="username" value="${result.username }" class="txt-input" />
                            </div>
                            </c:if>
                            <c:if test="${result.username != null }">
								<input type="hidden" name="username" id="username" value="${result.username }" />
                            </c:if>
                        </div>
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>账户密码：</label>
                            <div class="label-con">
                            	<input type="text" name="password" onclick="javascript:doMsg('news')" onblur="javascript:doHidden('news')" value="${result.password }" id="password" class="txt-input" />
                            </div>
                            <label class="label" style="display: none;" id="news">长度为6-20,可输入符号,数字或字母,不建议使用纯数字,纯字母或纯符号.</label>
                        </div>
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>账户描述：</label>
                            <div class="label-con">
                               <textarea rows="5" cols="80" name="account_desc" id="account_desc" >${result.account_desc }</textarea>
                            </div>
                        </div>
                    </fieldset>

                    <a href="javascript:saveAccountAndMsg(this);" id="save_form_data" class="btn-submit">保存</a>
                </form>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">
	var basePath = "${basePath }";
        
	
	function doMsg(objID){
		var obj = document.getElementById(objID);
		obj.style.display = 'block';
	}

	function doHidden(objID){
		var obj = document.getElementById(objID);
		obj.style.display = 'none';
	}
	
        function validation(){
        	var password = $('#password').val(),
        	account_desc = $('#account_desc').val(),
        	username = $('#username').val();
        	if($.isNull(username)){
        		return "账户不能为空";
        	}
        	if($.isNull(password)){
        		return "账户密码不能为空";
        	}
        	if(!password||password.length<6||password.length>20){
         		return "密码不符合规范(请查看右侧提示)";
         	}
        	if($.isNull(account_desc)){
     			return "账户描述不能为空";
     		}
        	if(/.*[\u4e00-\u9fa5]+.*$/.test(username)){
        		return "账户名不能包含有中文";
        	}
        	if(/.*[\u4e00-\u9fa5]+.*$/.test(password)){
        		return "账户密码不能包含有中文";
        	}
        	return null;
        }
        
        function saveAccountAndMsg(obj){
        	var resouce = {
        			username   : $('#username').val(),
        			password : $('#password').val(),
        			account_desc : $('#account_desc').val(),
        			enterpriseID : $('#enterpriseID').val()
        	};
        	var msg = validation();
        	if(msg){
       			alert(msg);
       			return ;
        	}
        	$(obj).attr("disabled","disabled");
        	var identifier = $('#identifier').val();
        	var enterpriseID = $('#enterpriseID').val();
        	var enterprise_Name = $('#enterprise_Name').val();
        	if(identifier){
        		$.ajax({
              		 type: "POST",
              		 url: "accounts/modiAccount.do",
              		 data: eval(resouce),
              		 dataType: "json",
              		 success: function(obj){
              			 var msg = obj.desc;
              			 alert(msg);
              			 location.href='<%=basePath %>accounts/showPaging.do?target=account_list&enterpriseID='+enterpriseID+'&enterprise_Name='+enterprise_Name;
              		 }
              		});
        	}else{
        		$.ajax({
           		 type: "POST",
           		 url: "accounts/saveAccountInfo.do",
           		 data: eval(resouce),
           		 dataType: "json",
           		 success: function(obj){
           			 var msg = obj.desc+",是否继续添加账户";
   					 if(confirm(msg)){
   						location.reload(); 
   					 }else{
   						 parent.hideDeleteIframe(enterpriseID,enterprise_Name);
   					 }
           		 }
           		});
        	}
        }
</script>
</html>
