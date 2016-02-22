<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../common.jsp"%>
<%@include file="../minisite_common.jsp"%>
<c:set var="basePath" value="<%=basePath%>"></c:set>
<c:set var="catalog" value="${empty catalog ? 'i' : catalog }"></c:set>
<c:set var="commonPath" value="${basePath }/${catalog }/${cityId }/${userid }/${idtype }/${miniUri }"></c:set>
<c:set var="queryStr" value="cityId=${cityId }&userid=${userid }&idtype=${idtype }&miniUri=${miniUri }&catalog=${catalog }"></c:set>
<img src="<%=basePath%>/xxtStat/addRecordV2.do?action=page-enter-book&${ queryStr }" width="0" height="0" style="display: none;"/>
<html>
<head>
<base href="<%=basePath%>">
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, user-scalable=yes"/>
<link rel="stylesheet" href="<%=basePath%>/css/minisite_layout_6.12.css">
<script type="text/javascript" src="<%=basePath%>/js/istudy_minisite.js"></script>
</head>
<body>
    <div id="page">
        <header class="page-header">
            <h1>家长无忧<sup>™</sup></h1>
        </header>

        <div class="container">
            <article class="article">
                <section class="banner-wrap">
                    <img src="<%=basePath%>/img/banner-6.12.jpg" class="banner" alt="">
                    <h2>高中生涯结束，职业生涯开始！</h2>
                </section>
                <section class="main">
                    <p>一个校长在高考前寄语：“多年过去，再回忆高考，其实本质上没有考的好与差的说法，重要的是所有的年轻人在一起，做份试题，然后决定去哪座城市、做什么工作，今后和谁相知，和谁一起旅行，和谁走一辈子！不管故事怎样，结局如何，一切都是美好的！”</p>
                    <p>简单百余字，看似是为给考生高考减压，实则道出高考真谛——“去哪座城市？做什么工作？和谁相知？和谁一起旅行？和谁走一辈子？”</p>
                    <p>事实上，高考志愿填报，其核心竞争力不是利用什么样的技巧报考到一所可以成功录取的大学，而是以终为始，以4年后大学毕业就业为起点，在职业规划的基础上选好每一个学校、每一个专业！</p>
                    <h3>没有职业规划——<br/>高考志愿填报就如“瞎子摸象”！</h3>
                    <p>最新的一份调查数据显示，53%大学生后悔选错专业！当初选报专业仅有42%是根据自己的兴趣决定的，听从父母决定的占到26%，其余为就业、薪酬等其他原因作出决定的。</p>
                    <p>另外一份权威的调查报告数据，有83%的高考生对自己所读的专业“不满意”，每天面对不喜欢的知识，在大学校园里煎熬着，下课的时候才是最轻松的时候；有66％的在校大学生表示如果可能将改变专业，如果不可能毕业以后也要坚决的改行。</p>
                </section>
                <section class="intro">
                    <h2>尊敬的家长，如何提高高考志愿填报“命中率”？推荐使用</h2>
                    <img src="<%=basePath%>/img/intro-6.12.jpg" alt="" class="banner">
                    <ul class="fn-list">
                        <li>
                            <i class="icon-job"></i>
                            <div class="text">
                                <p class="title">职业倾向测评</p>
                                <p class="content">确定适合自己的专业方向</p>
                            </div>
                        </li>
                        <li>
                            <i class="icon-school"></i>
                            <div class="text">
                                <p class="title">院校检索</p>
                                <p class="content">通过批次、地区、专业智能筛选目标学校，轻松了解三年数据。</p>
                            </div>
                        </li>
                        <li>
                            <i class="icon-analyze"></i>
                            <div class="text">
                                <p class="title">模拟分析</p>
                                <p class="content">与历史数据比：三年高考录取历史大数据，助你精准定位与实时数据比：及时了解最新考生填报动态与热门专业。</p>
                            </div>
                        </li>
                    </ul>
                </section>
                <!-- <section class="fn">
                    <button type="button" class="btn" id="btnAppointment">立即预约</button>
                    <p class="tips">现在预约，可额外获赠<strong>1次</strong>“模拟填报和志愿分析”服务</p>
                </section> -->
                <section class="tips">
                    <h3>提前了解详情</h3>
                    <p>请电脑访问<em>（长按复制链接）</em></p>
                    <p class="href"><span id="pcHref">http://www.istudy.com.cn/</span></p>
                </section>
            </article>

            <div class="share">
                <button type="button" class="btn-unfold-share" id="btnUnfoldShare">将“志愿填报神器”告诉更多家长 【点击展开】</button>
                <div class="share-item" id="shareItem">
                    <h4>将“志愿填报神器”告诉更多家长</h4>
                    <div class="bdsharebuttonbox" id="btnShareItem">
                        <a href="#" onclick="shareSina('${basePath}','${queryStr }')" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
                        <a href="#" onclick="shareQQzone('${basePath}','${queryStr }')" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
                        <a href="#" onclick="shareRR('${basePath}','${queryStr }')" class="bds_renren" data-cmd="renren" title="分享到人人网"></a>
                        <a href="#" onclick="shareQQweibo('${basePath}','${queryStr }')" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a>
                    </div>
                    <div class="copy-href">
                        <p>长按复制链接地址：</p>
                        <P class="href" id="windowHref">http://t.cn/RvKPArM</P>
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

    <div class="overlay" id="overlay"></div>
    
    <div class="msgbox" id="msgbox">
        <div class="inner verify">
            <label for="userPhone" class="title">验证您的校讯通身份</label>
            <input type="number" name="userPhone" id="userPhone" class="input" placeholder="输入您在校讯通登记的手机号码" maxlength="11">

            <div class="valid" id="userPhoneValid"><!-- 请输入正确的手机号码 --></div>

            <div class="handle clearfix">
                <button type="button" id="btnSubmit">提交</button>
                <hr/>
                <button type="button" id="btnCancel">取消</button>
            </div>
        </div>

        <div class="inner loading" style="display:none;">
            <i class="icon-loading rotate animated linear infinite"></i>
            <p class="text">请稍候，正在返回结果</p>
        </div>

        <div class="inner result" style="display:none;">
            <div class="success" style="display:none;">
                <p class="title">预定成功，请查看手机短信</p>
                <p>账号：<strong id="userName"></strong></p>
                <p>密码：<strong id="userPaw"></strong></p>
            </div>

            <div class="fail" style="display:none;">
                <p class="title">预定失败</p>
            </div>
            <button type="button" id="btnHidebox" class="submit">确认</button>
        </div>
    </div>

    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
    <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"1","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"32"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
    <script src="<%=basePath%>/js/custom_6.12.js"></script>
</body>
</html>
