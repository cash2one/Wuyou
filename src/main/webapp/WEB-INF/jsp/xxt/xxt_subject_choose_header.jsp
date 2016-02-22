<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<c:set var="basePath" value="<%=basePath%>"></c:set>
<c:set var="catalog" value="${empty catalog ? 'xxtM' : catalog }"></c:set>
<c:set var="commonPath" value="${basePath }/${catalog }/${cityId }/${userid }/${idtype }/${miniUri }"></c:set>
<c:set var="queryStr" value="cityId=${cityId }&userid=${userid }&idtype=${idtype }&miniUri=${miniUri }&catalog=${catalog }"></c:set>
<c:set var="headTitle" value="高一文理分科专题"></c:set>
<base href="<%=basePath%>">
<!--[if lte IE 8]>
    <script src="<%=basePath%>/js/html5.js"></script>
<![endif]-->
<link rel="stylesheet" href="<%=basePath%>/css/minisite_layout_sc.css?v0.02"/>
<script type="text/javascript">
	var _hmt = _hmt || [];
</script>