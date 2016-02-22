<%@ page pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<c:set var="basePath" value="<%=basePath%>"></c:set>
<c:set var="catalog" value="${empty catalog ? 'i' : catalog }"></c:set>
<c:set var="commonPath" value="${basePath }/${catalog }/${cityId }/${userid }/${idtype }/${miniUri }"></c:set>
<c:set var="queryStr" value="cityId=${cityId }&userid=${userid }&idtype=${idtype }&miniUri=${miniUri }&catalog=${catalog }"></c:set>
<%-- 页面title --%>
<c:choose>
<c:when test="${miniUri == '13965781689320' }"><c:set var="pageTitle" value="高一文理分科专题"></c:set></c:when>
<c:when test="${miniUri =='14014316379750'|| miniUri =='14005017275572'|| miniUri =='14005535482283'|| miniUri =='14005557476348'|| miniUri =='14011820305320'|| miniUri =='lmyj'|| miniUri =='14017663546030' || miniUri =='14018623768120'|| miniUri == '14005500386066'|| miniUri == '14018705942211'|| miniUri == '14005024068065'|| miniUri == '14005636882053'
|| miniUri =='14019473803365'|| miniUri == '14019480811847'|| miniUri == '14019471590584'|| miniUri == '14019486492448'|| miniUri == '14019477727966'
|| miniUri =='14023937316314'|| miniUri == '14023897991053'|| miniUri == '14023872620351'|| miniUri == '14024520377147'|| miniUri == '14023876168222'|| miniUri == '14024528133458'
|| miniUri =='14005011825841'|| miniUri == '14005526355250'|| miniUri == '14005548250874'|| miniUri == '14024042532776'|| miniUri == '14005564694531'|| miniUri == '14024008089635'|| miniUri == '14026547677253'|| miniUri == '14026567405824'|| miniUri == '14027154771825'|| miniUri == '14028261313730'|| miniUri == '14024642905669'|| miniUri == '14027200065956'|| miniUri == '14026476959591'|| miniUri == '14026469053400'|| miniUri == '14026479684272'|| miniUri =='14029159685110'|| miniUri =='14029681906141'|| miniUri =='14036054528080z'
|| miniUri =='14029920234013'|| miniUri == '14029894874392'|| miniUri == '14029940320815'|| miniUri == '14029925585744'|| miniUri == '14030629922140'|| miniUri == '14030633337611' 
|| miniUri =='14036915882040'|| miniUri == '14036918075871'|| miniUri == '14036945000112'|| miniUri == '14036956625724'|| miniUri == '14037522343597'|| miniUri == '14037524161698'|| miniUri == '14036951543333'|| miniUri == '14037514040176'
|| miniUri == '14043686135776'|| miniUri == '14043694010907'|| miniUri == '14043681026734'|| miniUri == '14043683757725'
|| miniUri == '14048923771980'|| miniUri == '14048927170961'|| miniUri == '14048994239552'|| miniUri == '14048995585163'|| miniUri == '14049717738884'|| miniUri == '14049719801850'|| miniUri == '14049759956506'|| miniUri == '14049774254866'|| miniUri == '14049729328731'|| miniUri == '14049774254866'|| miniUri == '14049734513273'|| miniUri == '14049753451584'|| miniUri == '14049759956506'|| miniUri == '14049774254866'|| miniUri == '14049734513273'|| miniUri == '14049753451584'|| miniUri == '14050481337740'|| miniUri == '14050484906941'
|| miniUri == '14054969368857'|| miniUri == '14054949824456'|| miniUri == '14054922084114'|| miniUri == '14054934312375'|| miniUri == '14055766894514'|| miniUri == '14055767260755'|| miniUri == '14055782290356'|| miniUri == '14055784461887'|| miniUri == '14055625425999'|| miniUri == '14055625786130'|| miniUri == '14055669616442'|| miniUri == '14055671416843'|| miniUri == '14055662090761'|| miniUri == '14055623953228'
|| miniUri == '14061047804255'|| miniUri == '14061048348946'|| miniUri == '14061684764379'|| miniUri == '14061686302210'|| miniUri == '14060841563192'|| miniUri == '14060842341823'|| miniUri == '14060817227090'|| miniUri == '14060817682471'|| miniUri == '14061693018771'|| miniUri == '14061694833202'|| miniUri == '14061705894693'|| miniUri == '14061706821134'|| miniUri == '14061072958237'|| miniUri == '14061074909598'|| miniUri == '14061844825265'|| miniUri == '14061845635176' }"><c:set var="pageTitle" value="校讯通服务升级"></c:set></c:when>
<c:otherwise><c:set var="pageTitle" value=""></c:set></c:otherwise>
</c:choose>


<%-- 文章页title --%>
<c:choose>
<c:when test="${miniUri == '13965781689320' }"><c:set var="headTitle" value="高一文理分科专题"></c:set></c:when>
<c:when test="${miniUri =='14014316379750'|| miniUri =='14005017275572'|| miniUri =='14005535482283'|| miniUri =='14005557476348'|| miniUri =='14011820305320'|| miniUri =='lmyj'|| miniUri =='14017663546030' || miniUri =='14018623768120'|| miniUri == '14005500386066'|| miniUri == '14018705942211'|| miniUri == '14005024068065'|| miniUri == '14005636882053'
|| miniUri =='14019473803365'|| miniUri == '14019480811847'|| miniUri == '14019471590584'|| miniUri == '14019486492448'|| miniUri == '14019477727966'
|| miniUri =='14023937316314'|| miniUri == '14023897991053'|| miniUri == '14023872620351'|| miniUri == '14024520377147'|| miniUri == '14023876168222'|| miniUri == '14024528133458'
|| miniUri =='14005011825841'|| miniUri == '14005526355250'|| miniUri == '14005548250874'|| miniUri == '14024042532776'|| miniUri == '14005564694531'|| miniUri == '14024008089635'|| miniUri == '14026547677253'|| miniUri == '14026567405824'|| miniUri == '14027154771825'|| miniUri == '14028261313730'|| miniUri == '14024642905669'|| miniUri == '14027200065956'|| miniUri == '14026476959591'|| miniUri == '14026469053400'|| miniUri == '14026479684272'|| miniUri =='14029159685110'|| miniUri =='14029681906141'|| miniUri =='14036054528080z'
|| miniUri =='14029920234013'|| miniUri == '14029894874392'|| miniUri == '14029940320815'|| miniUri == '14029925585744'|| miniUri == '14030629922140'|| miniUri == '14030633337611'
|| miniUri =='14036915882040'|| miniUri == '14036918075871'|| miniUri == '14036945000112'|| miniUri == '14036956625724'|| miniUri == '14037522343597'|| miniUri == '14037524161698'|| miniUri == '14036951543333'|| miniUri == '14037514040176'
|| miniUri == '14043686135776'|| miniUri == '14043694010907'|| miniUri == '14043681026734'|| miniUri == '14043683757725'
|| miniUri == '14048923771980'|| miniUri == '14048927170961'|| miniUri == '14048994239552'|| miniUri == '14048995585163'|| miniUri == '14049717738884'|| miniUri == '14049719801850'|| miniUri == '14049759956506'|| miniUri == '14049774254866'|| miniUri == '14049729328731'|| miniUri == '14049774254866'|| miniUri == '14049734513273'|| miniUri == '14049753451584'|| miniUri == '14049759956506'|| miniUri == '14049774254866'|| miniUri == '14049734513273'|| miniUri == '14049753451584'|| miniUri == '14050481337740'|| miniUri == '14050484906941'
|| miniUri == '14054969368857'|| miniUri == '14054949824456'|| miniUri == '14054922084114'|| miniUri == '14054934312375'|| miniUri == '14055766894514'|| miniUri == '14055767260755'|| miniUri == '14055782290356'|| miniUri == '14055784461887'|| miniUri == '14055625425999'|| miniUri == '14055625786130'|| miniUri == '14055669616442'|| miniUri == '14055671416843'|| miniUri == '14055662090761'|| miniUri == '14055623953228'
|| miniUri == '14061047804255'|| miniUri == '14061048348946'|| miniUri == '14061684764379'|| miniUri == '14061686302210'|| miniUri == '14060841563192'|| miniUri == '14060842341823'|| miniUri == '14060817227090'|| miniUri == '14060817682471'|| miniUri == '14061693018771'|| miniUri == '14061694833202'|| miniUri == '14061705894693'|| miniUri == '14061706821134'|| miniUri == '14061072958237'|| miniUri == '14061074909598'|| miniUri == '14061844825265'|| miniUri == '14061845635176'
|| miniUri == '14067791237236'|| miniUri == '14067792129477'|| miniUri == '14067877681618' }"><c:set var="headTitle" value="校讯通服务升级"></c:set></c:when>
<c:otherwise><c:set var="headTitle" value="家长无忧<sup>™</sup>"></c:set></c:otherwise>
</c:choose>

<base href="<%=basePath%>">
<!--[if lte IE 8]>
    <script src="<%=basePath%>/js/html5.js"></script>
<![endif]-->

<link rel="stylesheet" href="<%=basePath%>/css/minisite_layout.css?v20141016"  />

<script type="text/javascript">
	var _hmt = _hmt || [];
</script>