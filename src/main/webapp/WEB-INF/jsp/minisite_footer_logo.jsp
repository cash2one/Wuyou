<%@ page pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<style type="text/css">
.page-footer {
	background-color: #00aff0;
}

.cus-sf-footer {
	height:40px;
	font-size: .6em;
	color: #fff;
	text-align: center;
}
.cus-sf-footer .cap,.cus-sf-footer .list {
	display: inline-block;
	vertical-align: middle
}
.cus-sf-footer .list ~ .list {
	margin-left: 3px
}
.cus-sf-footer img,
.cus-sf-footer span{vertical-align:middle;}
.cus-sf-footer img{max-height:40px;width:auto;border:none;margin-right:3px;}
.cus-sf-footer .vm{margin-right:-3px;display:inline-block;height:40px;width:0;vertical-align: middle;}
</style>
<c:choose>
<c:when test="${param.footerId == 'xxt' }">
<footer class="page-footer">
    <div class="cus-sf-footer">
    	<span class="vm"></span>
        <span class="cap">服务提供：</span>
        <span class="list">
            <img src="../img/logo/xxt.png" height="25"><span>中国移动</span>
        </span>
        <span class="list">
            <img src="../img/logo/axw.png" height="25"><span>华附在线（爱学网）</span>
        </span>
    </div>
</footer>
</c:when>
<c:when test="${param.footerId == 'mswkt' }">
<footer class="page-footer">
    <div class="cus-sf-footer">
    	<span class="vm"></span>
        <span class="cap">服务提供：</span>
        <span class="list">
        	<img src="../img/logo/mswkt.png" height="38">
        </span>
    </div>
</footer>
</c:when>
<c:when test="${param.footerId == 'axw' }">

<footer class="page-footer">
    <div class="cus-sf-footer">
    	<span class="vm"></span>
        <span class="cap">服务提供：</span>
        <span class="list">
            <img src="../img/logo/axw.png" height="25"><span>华附在线（爱学网）</span>
        </span>
    </div>
</footer>
</c:when>
<c:otherwise>
<!-- <footer class="page-footer">
    <div class="cus-sf-footer">
    	<span class="vm"></span>
        <span class="cap">&nbsp;</span>
        <span class="list">
            &nbsp;
        </span>
    </div>
</footer> -->
</c:otherwise>
</c:choose>