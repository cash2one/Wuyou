<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<%@include file="../minisite_common.jsp"%>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-subrank&${ queryStr }" width="0" height="0" style="display: none;"/>
<html>
<head>
<base href="<%=basePath%>">
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, user-scalable=yes"/>
<link rel="stylesheet" href="<%=basePath%>/css/minisite_layout_6.12.css">
<%-- <script type="text/javascript" src="<%=basePath%>/js/istudy_minisite.js"></script> --%>
</head>
<body>
    <div id="page">
        <header class="page-header">
            <h1>2014高考志愿填报专业热度排行榜</h1>
        </header>

        <div class="container">
            <article class="hot-ranking">
                <section>
                    <h2 class="specialty-title">本科</h2>
                    <table class="ranking-table specialty">
                        <colgroup>
                            <col class="col-01"/>
                            <col class="col-02"/>
                            <col class="col-03"/>
                            <col class="col-04"/>
                            <col class="col-05"/>
                        </colgroup>
                        <thead>
                            <tr>
                                <th></th>
                                <th>专业名称</th>
                                <th>所属大类</th>
                                <th>所属小类</th>
                                <th>报考人次</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><span class="time">1</span></td>
                                <td>工商管理<i class="icon-up"></i></td>
                                <td>工学</td>
                                <td>工商管理类</td>
                                <td>3470</td>
                            </tr>
                            <tr>
                                <td><span class="time">2</span></td>
                                <td>计算机科学<i class="icon-down"></i></td>
                                <td>工学</td>
                                <td>计算机类</td>
                                <td>3470</td>
                            </tr>
                            <tr>
                                <td><span class="time">3</span></td>
                                <td>经济管理<i class="icon-up"></i></td>
                                <td>管理学</td>
                                <td>管理科学类</td>
                                <td>3470</td>
                            </tr>
                            <tr>
                                <td><span class="time">4</span></td>
                                <td>工商管理<i class="icon-hori"></i></td>
                                <td>管理学</td>
                                <td>工商管理类</td>
                                <td>3470</td>
                            </tr>
                        </tbody>
                    </table>
                </section>
                <section>
                    <h2 class="specialty-title">专科</h2>
                    <table class="ranking-table specialty">
                        <colgroup>
                            <col class="col-01"/>
                            <col class="col-02"/>
                            <col class="col-03"/>
                            <col class="col-04"/>
                            <col class="col-05"/>
                        </colgroup>
                        <thead>
                        <tr>
                            <th></th>
                            <th>专业名称</th>
                            <th>所属大类</th>
                            <th>所属小类</th>
                            <th>报考人次</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><span class="time">1</span></td>
                            <td>工商管理<i class="icon-up"></i></td>
                            <td>工学</td>
                            <td>工商管理类</td>
                            <td>3470</td>
                        </tr>
                        <tr>
                            <td><span class="time">2</span></td>
                            <td>计算机科学<i class="icon-up"></i></td>
                            <td>工学</td>
                            <td>计算机类</td>
                            <td>3470</td>
                        </tr>
                        <tr>
                            <td><span class="time">3</span></td>
                            <td>经济管理<i class="icon-up"></i></td>
                            <td>管理学</td>
                            <td>管理科学类</td>
                            <td>3470</td>
                        </tr>
                        <tr>
                            <td><span class="time">4</span></td>
                            <td>工商管理<i class="icon-up"></i></td>
                            <td>管理学</td>
                            <td>工商管理类</td>
                            <td>3470</td>
                        </tr>
                        </tbody>
                    </table>
                </section>
                <section class="tips">
                    <h3>2014高考志愿填报更多专业热度排行</h3>
                    <p>请用电脑访问<em>（长按复制链接）</em></p>
                    <p class="href" id="pcHref">http://www.baidu.com</p>
                </section>
            </article>
            <div class="share">
                <button type="button" class="btn-unfold-share" id="btnUnfoldShare">将“志愿填报神器”告诉更多家长 【点击展开】</button>
                <div class="share-item" id="shareItem">
                    <h4>将“志愿填报神器”告诉更多家长</h4>
                    <div class="bdsharebuttonbox" id="btnShareItem">
                        <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
                        <a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
                        <a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a>
                        <a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a>
                    </div>
                    <div class="copy-href">
                        <p>长按复制链接地址：</p>
                        <P class="href" id="windowHref"></P>
                    </div>
                    <button type="button" class="btn-fold-share" id="btnFoldShare"></button>
                </div>
            </div>
        </div>

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
    </div>

    <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"1","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"32"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
    <script src="<%=basePath%>/js/jquery-1.11.0.min.js"></script>
    <script src="<%=basePath%>/js/custom_6.12.js"></script>
</body>
</html>
