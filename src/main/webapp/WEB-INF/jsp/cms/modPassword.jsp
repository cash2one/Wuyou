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
                <strong>修改用户密码</strong>
            </div>
            <div class="cms-main clearfix edit-cms-main">
                <form id="resource_div" class="form-item edit-cms-item">
                    <fieldset class="sms-edit">
                        <h2>修改用户密码</h2>
						<div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>旧密码：</label>
                            <div class="label-con">
                            	<input type="password" onclick="javascript:doMsg('olds')" onblur="javascript:doHidden('olds')" name="oldPassword" id="oldPassword" class="txt-input" />
                            </div>
							<label class="label" style="display: none;" id="olds">长度为6-20,可输入符号,数字或字母,不建议使用纯数字,纯字母或纯符号.</label>
                        </div>
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>新密码：</label>
                            <div class="label-con">
                            	<input type="password" onclick="javascript:doMsg('news')" onblur="javascript:doHidden('news')" name="newPassword" id="newPassword" class="txt-input" />
                            </div>
							<label class="label" style="display: none;" id="news">长度为6-20,可输入符号,数字或字母,不建议使用纯数字,纯字母或纯符号.</label>
                        </div>
                        <div class="L clearfix">
                            <label class="label"><span style="color: red">*</span>确认密码：</label>
                            <div class="label-con">
                            	<input type="password" onclick="javascript:doMsg('confirms')" onblur="javascript:doHidden('confirms')" name="confirmPassword" id="confirmPassword" class="txt-input" />
                            </div>
                            <label class="label" style="display: none;" id="confirms">长度为6-20,可输入符号,数字或字母,不建议使用纯数字,纯字母或纯符号.</label>
                        </div>
                        
                    </fieldset>

                    <a href="javascript:saveEnterpriseAndMsg(this);" id="save_form_data" class="btn-submit">保存</a>
                </form>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript">


function doMsg(objID){
	var obj = document.getElementById(objID);
	obj.style.display = 'block';
}

function doHidden(objID){
	var obj = document.getElementById(objID);
	obj.style.display = 'none';
}

	var basePath = "${basePath }";
        
        function validation(){
        	var oldPassword = $('#oldPassword').val(),
        	newPassword = $('#newPassword').val(),
        	confirmPassword = $('#confirmPassword').val();
        	oldPassword = oldPassword.replace(/[ ]/g,"");
        	newPassword = newPassword.replace(/[ ]/g,""); 
        	confirmPassword = confirmPassword.replace(/[ ]/g,"");
        	if($.isNull(oldPassword)){
        		return "旧密码不能为空";
        	}
        	if(!oldPassword||oldPassword.length<6||oldPassword.length>20){
        		return "旧密码不符合规范(请查看右侧提示)";
        	}
        	 if($.isNull(newPassword)){
     			return "新密码不能为空";
     		}
        	if(!newPassword||newPassword.length<6||newPassword.length>20){
         		return "新密码不符合规范(请查看右侧提示)";
         	}
        	if($.isNull(confirmPassword)){
        		return "确认密码不能为空";
        	}
        	if(!newPassword||newPassword.length<6||newPassword.length>20){
         		return "确认密码不符合规范(请查看右侧提示)";
         	}
        	if(/.*[\u4e00-\u9fa5]+.*$/.test(oldPassword)){
        		return "旧密码不能包含有中文";
        	}
        	if(/.*[\u4e00-\u9fa5]+.*$/.test(newPassword)){
        		return "新密码不能包含有中文";
        	}
        	if(/.*[\u4e00-\u9fa5]+.*$/.test(confirmPassword)){
        		return "确认密码不能包含有中文";
        	}
        	if(newPassword!=confirmPassword){
        		return "新密码和确认密码不一致";
        	}
        	return null;
        }
        
        function closeSelf(){
        	parent.hideDeleteIframe();
        }
        
        function saveEnterpriseAndMsg(obj){
        	var resouce = {
        			oldPassword : $('#oldPassword').val(),
        			confirmPassword   : $('#confirmPassword').val()
        	};
        	var msg = validation();
        	if(msg){
       			alert(msg);
       			return ;
        	}
        	$(obj).attr("disabled","disabled");
        		$.ajax({
              		 type: "POST",
              		 url: "accounts/modPassword.do",
              		 data: eval(resouce),
              		 dataType: "json",
              		 success: function(obj){
              			 var msg = obj.desc;
              			 alert(msg);	
              			 if(obj.code=='10002'){
              				 location.reload();
              				 return;
              			 }
              			 closeSelf();
              		 }
              		});
        	
        }
</script>
</html>
