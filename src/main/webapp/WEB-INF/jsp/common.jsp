<%@page import="com.istudy.server.common.constants.CMSConstants"%>
<%@page import="com.istudy.server.common.utils.CommonUtils"%>
<%@page import="com.istudy.server.common.constants.CommonConstants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<%
 	String path = request.getContextPath();
	String basePath = CMSConstants.DOMAIN_NAME;
%>
