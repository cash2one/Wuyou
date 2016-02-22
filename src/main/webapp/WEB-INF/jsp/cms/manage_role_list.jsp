<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../common.jsp"%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色列表</title>

<link rel="stylesheet" href="css/layout.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/istudy-cms.js"></script>
</head>
<body class="bc-white">
 <div id="page" class="pos-r">
        <div class="cms-container">
	        <div class="location">
	               <strong>角色列表</strong>
	        </div>
            <div class="cms-main">

                <div class="msg-list cms-msg-list">
                    <table class="list-t">
                        <colgroup>
                            <col class="col-01"><col class="col-02"><col class="col-03"><col class="col-04"><col class="col-05"> 
                        </colgroup>
                        <thead>
                        <tr>
                            <th><div class="td_style">角色名</div></th>
                            <th><div class="td_style">  </div></th>
                            <th><div class="td_style">角色权限</div></th>
                            <th><div class="td_style"> </div></th>
                        </tr>
                    	</thead>
                        <tbody id="data_body">
                       
                        
                            <c:forEach var="task" items="${paging.result }">
	                            <tr>
	                                <td>
	                                 <div class="td_style"> ${task.userName }</div>
	                                </td>
	                                <td>
	                            
	                                 <div class="td_style">${task.realName }</div>
	                                </td>
	                                <td><div class="td_style">${task.roleName }</div></td>
	                                <td>
	                               <div class="td_style"> </div>
	                                </td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <%@include file="../paging.jsp"%>
            </div>
        </div>
    </div>

</body>
</html>