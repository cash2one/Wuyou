<%@ page pageEncoding="UTF-8"%>
<c:set var="miniUri" value="${miniUri }"></c:set>
<c:set var="cityId" value="${cityId }"></c:set>
<c:set var="userid" value="${userid }"></c:set>
<c:set var="idtype" value="${idtype }"></c:set>
<c:set var="basePath" value="<%=basePath%>"></c:set>
<c:set var="commonPath" value="${basePath }xxtM/${cityId }/${userid }/${idtype }/${miniUri }"></c:set>
<c:set var="queryStr" value="cityId=${cityId }&userid=${userid }&idtype=${idtype }&miniUri=${miniUri }"></c:set>
<%@ include file="hm.jsp" %>
<%
_HMT _hmt = new _HMT("603a7b8374bb878690acfbca0e1d9342");
_hmt.setDomainName("wuyou.istudy.com.cn");
_hmt.setHttpServletObjects(request, response);
String _hmtPixel = _hmt.trackPageview();
%>
<img src="<%= _hmtPixel %>" width="0" height="0" style="display: none;"/>
