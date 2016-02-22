<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<c:set var="miniUri" value="${miniUri }"></c:set>
<c:set var="cityId" value="${cityId }"></c:set>
<c:set var="userid" value="${userid }"></c:set>
<c:set var="idtype" value="${idtype }"></c:set>
<c:set var="basePath" value="<%=basePath%>"></c:set>
<c:set var="commonPath" value="${basePath }xxtM/${cityId }/${userid }/${idtype }/${miniUri }"></c:set>
<c:set var="queryStr" value="cityId=${cityId }&userid=${userid }&idtype=${idtype }&miniUri=${miniUri }"></c:set>
<base href="<%=basePath%>">
<!--[if lte IE 8]>
    <script src="<%=basePath%>/js/html5.js"></script>
<![endif]-->
<link rel="stylesheet" href="<%=basePath%>/css/minisite_layout_bst.css?v1.4"/>
<script type="text/javascript">
	var _hmt = _hmt || [];
</script>