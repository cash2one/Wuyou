<%@ page pageEncoding="UTF-8"%>
<c:set var="uri" value="${param.uri }${miniUri }"></c:set>
<c:set var="ufCookieName" value="uf_${uri }"></c:set>

<script type="text/javascript" src="<%=basePath%>/js/istudy_minisite.js?v20141027"></script>


<c:if test="${not empty userid && userid != 'appuser' && userid != 'f'&& uri != '14019473803365'
				&&idtype!= '587'&& idtype !='588' && idtype!='589' && idtype !='590' && idtype != '591'&& idtype!='624' && uri!='14176649782333'&&uri!='14176744360226'}">
<div  class="app-download">
        <div class="title ta-c"><span><!--  关爱孩子的成长，获取更多家校沟通功能、教育资讯和服务，请下载校讯通手机客户端--></span></div>
        <a onclick="eventPush('${basePath}','${queryStr }','btnclick-download-ios')" href="http://120.197.89.182:7000/release/app/ios/html/GuangDongApp_axw_xwy.html" target="_blank" class="link-iphone"><i class="icon-iphone"></i>和教育iPhone版</a>
        <a onclick="eventPush('${basePath}','${queryStr }','btnclick-download-android')" href="http://120.197.89.182:7000/release/app/ios/html/GuangDongApp_axw_xwy.html" target="_blank" class="link-android"><i class="icon-android"></i>和教育Android版</a>
    </div>
</c:if>
<c:if test="${idtype== '587' || idtype =='588' || idtype=='589' || idtype =='590' || idtype == '591' }">
	<div  class="app-download" style="background-color:transparent">
        <div class="title ta-c"><span><!--  关爱孩子的成长，获取更多家校沟通功能、教育资讯和服务，请下载校讯通手机客户端--></span></div>
        <a onclick="eventPush('${basePath}','${queryStr }','btnclick-download-update')" href="http://120.197.89.182:7000/release/app/ios/html/GuangDongApp_axw_xqt.html" target="_blank" class="link-iphone"><strong>马上升级</strong></a>
        </div>
</c:if>
<c:if test="${empty cookie[ufCookieName].value && not empty userid}">
<c:choose>
<c:when test="${idtype == '624'||uri=='14176649782333'||uri=='14176744360226'||idtype == '677'||idtype == '678'||idtype == '679'|| idtype == '701' || idtype == '702' || idtype == '703'|| idtype == '712' || idtype == '713' || idtype == '714'|| idtype =='721'|| idtype =='724' || idtype == '731' || idtype == '738' || idtype == '739' || idtype == '746'|| idtype == '755'|| idtype == '764'|| idtype == '773'|| idtype == '774' || idtype =='777'|| idtype == '780' || idtype == '787'|| idtype == '802' || idtype == '803' || idtype == '820'|| idtype == '827'|| idtype == '828'|| idtype == '829'|| idtype == '842'|| idtype == '843'|| idtype == '844'|| idtype == '849'|| idtype == '860'|| idtype == '861'|| idtype == '862'|| idtype == '873'|| idtype == '886'|| idtype == '897'}">
</c:when>
<c:when test="${idtype == '49' }">
<div id="feedback-div" class="feedback-item">
    <p class="cap">下周将继续连载，敬请关注</p>
    <div class="clearfix">
        <a onclick="${empty cookie[ufCookieName].value ? '' : 'return false;'}useful(this,'${basePath}', '${queryStr }');" href="javascript:" class="btn flo-l">感兴趣</a>
        <a onclick="${empty cookie[ufCookieName].value ? '' : 'return false;'}useless(this,'${basePath}', '${queryStr }');" href="javascript:" class="btn flo-r">不感兴趣</a>
    </div>
</div>
</c:when>
<c:otherwise>
<div id="feedback-div" class="feedback-item">
    <p class="cap">本期内容对你有用吗？</p>
    <div class="clearfix">
        <a onclick="${empty cookie[ufCookieName].value ? '' : 'return false;'}useful(this,'${basePath}', '${queryStr }');" href="javascript:" class="btn flo-l"><i class="icon-useful"></i>有用</a>
        <a onclick="${empty cookie[ufCookieName].value ? '' : 'return false;'}useless(this,'${basePath}', '${queryStr }');" href="javascript:" class="btn flo-r"><i class="icon-useless"></i>没用</a>
    </div>
</div>
</c:otherwise>
</c:choose>
</c:if>


    
<c:choose>
<%-- <c:when test="${uri == '13965781689320' || uri == '13971153946320' }"> --%>
<c:when test="${uri == '13965781689320' || uri == 'gkbkcl' || uri == '13977321156971' || uri == '13978003870440'|| uri == 'wlfksp'|| uri == '13994435231374' || uri == '13993622254863' || uri == '14005772105707' || uri == '14005529466521' || uri == '14008119739339' || uri == '14017663546030' 
|| uri =='14014316379750'|| uri =='14005017275572'|| uri =='14005535482283'|| uri =='14005557476348'|| uri =='14011820305320'|| uri =='lmyj' || uri =='14018623768120' || uri == '14005500386066'|| uri == '14018705942211'|| uri == '14005024068065'|| uri == '14005636882053'
 || uri =='14019473803365' || uri == '14019480811847'|| uri == '14019471590584'|| uri == '14019486492448'|| uri == '14019477727966'
 || uri =='14023937316314'|| uri == '14023897991053'|| uri == '14023872620351'|| uri == '14024520377147'|| uri == '14023876168222'|| uri == '14024528133458'
|| uri =='14005011825841'|| uri == '14005526355250'|| uri == '14005548250874'|| uri == '14024042532776'|| uri == '14005564694531'|| uri == '14024008089635'|| uri == '14026547677253'|| uri == '14026567405824'|| uri == '14027154771825'|| uri == '14028261313730'|| uri == '14024642905669'|| uri == '14027200065956'|| uri == '14026476959591'|| uri == '14026469053400'|| uri == '14026479684272'|| uri =='14029681906141'|| uri =='14029159685110'|| uri =='14036054528080z'
|| uri =='14029920234013'|| uri == '14029894874392'|| uri == '14029940320815'|| uri == '14029925585744'|| uri == '14030629922140'|| uri == '14030633337611'
|| uri =='14036915882040'|| uri == '14036918075871'|| uri == '14036945000112'|| uri == '14036956625724'|| uri == '14037522343597'|| uri == '14037524161698'|| uri == '14036951543333'|| uri == '14037514040176'
|| uri == '14043686135776'|| uri == '14043694010907'|| uri == '14043681026734'|| uri == '14043683757725'
|| uri == '14048923771980'|| uri == '14048927170961'|| uri == '14048994239552'|| uri == '14048995585163'|| uri == '14049717738884'|| uri == '14049719801850'|| uri == '14049759956506'|| uri == '14049774254866'|| uri == '14049729328731'|| uri == '14049774254866'|| uri == '14049734513273'|| uri == '14049753451584'|| uri == '14049759956506'|| uri == '14049774254866'|| uri == '14049734513273'|| uri == '14049753451584'|| uri == '14050481337740'|| uri == '14050484906941'
|| uri == '14054969368857'|| uri == '14054949824456'|| uri == '14054922084114'|| uri == '14054934312375'|| uri == '14055766894514'|| uri == '14055767260755'|| uri == '14055782290356'|| uri == '14055784461887'|| uri == '14055625425999'|| uri == '14055625786130'|| uri == '14055669616442'|| uri == '14055671416843'|| uri == '14055662090761'|| uri == '14055623953228'
|| uri == '14061047804255'|| uri == '14061048348946'|| uri == '14061684764379'|| uri == '14061686302210'|| uri == '14060841563192'|| uri == '14060842341823'|| uri == '14060817227090'|| uri == '14060817682471'|| uri == '14061693018771'|| uri == '14061694833202'|| uri == '14061705894693'|| uri == '14061706821134'|| uri == '14061072958237'|| uri == '14061074909598'|| uri == '14061844825265'|| uri == '14061845635176'
|| uri == '14067791237236'|| uri == '14067792129477'|| uri == '14067877681618' }">
<footer class="page-footer">
    <div class="sf-footer">
        <span class="cap">服务提供：</span>
        <span class="list">
            <i class="icon-mobile"></i><span>中国移动</span>
        </span>
        <span class="list">
            <i class="icon-istudy"></i><span>华附在线（爱学网）</span>
        </span>
    </div>
</footer>
</c:when>
<c:when test="${idtype == '677'||idtype == '678'||idtype == '679'|| idtype == '701' || idtype == '702' || idtype == '703'|| idtype == '712' || idtype == '713' || idtype == '714'|| idtype =='721'|| idtype =='724' || idtype == '731' || idtype == '738' || idtype == '739' || idtype == '746'|| idtype == '755'|| idtype == '764'|| idtype == '773'|| idtype == '774' || idtype =='777'|| idtype == '780'|| idtype == '787'|| idtype == '802' || idtype == '803' || idtype == '820'|| idtype == '827'|| idtype == '828'|| idtype == '829'|| idtype == '842'|| idtype == '843'|| idtype == '844'|| idtype == '849'|| idtype == '860'|| idtype == '861'|| idtype == '862'|| idtype == '873'|| idtype == '886'|| idtype == '897'}"> 
<footer class="page-footer">
    <div class="sf-footer">
        <span class="cap">服务提供：</span>
        <span class="list">
            <i class="icon-istudy"></i><span>华附在线（爱学网）</span>
        </span>
    </div>
</footer>
</c:when>
<c:otherwise>
<!-- <footer class="page-footer">
     <div class="sf-footer">
        <span class="cap">服务提供：</span>
        <span class="list">
            <i class="icon-istudy"></i><span>华附在线（爱学网）</span>
        </span>
    </div> 
</footer> -->
<jsp:include page="../../minisite_footer_logo.jsp" flush="true">
	<jsp:param name="footerId" value="${footerId }"></jsp:param>
	</jsp:include>
</c:otherwise>
</c:choose>

