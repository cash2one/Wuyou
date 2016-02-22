<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../common.jsp"%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.5, user-scalable=yes"/>
<style type="text/css">
body{
	height: 100%;
	padding: 0px;
	margin: 0px;
	background-color: #f3f3f3;
	font-size: 87.5%;
}
@media screen and (max-device-width: 400px) {
	body{font-size: 100%;}
}
#page{
	max-width:960px;
	margin: 0 auto;
	box-shadow:0 0 8px 5px hsla(0, 0%, 0%, .2);
}
.page-header {
	height: 40px;
	background-color: #00aff0;
	padding: .2em 10px;
	border-bottom: 1px solid #0588ba;
	position: relative
}

.page-header h1 {
	font-size: 1.5em;
	text-align: center;
	line-height: 40px;
	color: #fff;
	word-wrap: normal;
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
	margin: 0;
}

.page-footer {
	background-color: #00aff0;
	margin-top: 30px
}
.copyright {
	padding: 8px;
	color: #fff
}
.copyright table {
	max-width: 100%;
	margin: 0 auto;
	font-size: 12px
}
.copyright td {
	word-wrap: normal;
	white-space: nowrap;
	text-overflow: ellipsis
}
.copyright img,.copyright span {
	vertical-align: middle
}
.copyright .pr {
	padding-right: 1em
}

.reg_table{
	margin:0px auto;
	min-width:80%;
	max-width: 100%;
	border-collapse:collapse;
	border-bottom:none;
}

.reg_table th,.reg_table td{
	padding: 5px 0px;
	border:1px solid #DDDDDD;
}

.reg_table th{
	width: 28%;
	text-align: right;
	background:#F7F7F7;
}

.reg_table td{
	padding: 10px 5px;
}

.reg_table .text{
	min-width:180px;
	max-width: 85%;
	height: 26px;
	border: 1px #999 solid;
	line-height: 1.1;
	padding: 0px 2px;
	font-size: 1.0em;
	background-color: #fff;
}
.reg_table .text:focus{
	border-color:green;
}

.reg_table .textarea{
	min-width:180px;
	max-width: 85%;
	border: 1px #999 solid;
	line-height: 1.1;
	padding: 0px 2px;
	font-size: 1.0em;
	background-color: #fff;
}
.reg_table .textarea:focus{
	border-color:green;
}

.reg_table label{
	display: inline-block;
}

.reg_table select{
	min-width: 100px;
	padding: 3px 2px;
	background-color: #fff;
	border: 1px #999 solid;
}

.gp{
	display: none;
}

.requird{
	color: #f00;
	margin-left: 3px;
}

.table_title h2{
	line-height: 1.2em;
	text-align: center;
	margin: 5px 0px;
}
.table_title span{
	margin:8px 5px;
	font-size: 12px;
	text-align: right;
	display:block;
}
.table_title strong{
	color: red;
	text-align: center;
	display: block;
	margin: 5px 0px;
	font-size: 1.2em;
}

.submit{
	cursor:pointer;
	display: block;
	font-size: .9em;
	color: #fff;
	text-decoration: none;
	text-align: center;
	padding: 5px 15px;
	border-radius: 5px;
	border: 0;
	border-bottom: 4px solid rgba(190, 18, 0, .8);
	box-shadow: inset 2px -3px 3px rgba(253, 106, 91, .3);
	background-color: #f14848;
	background-image: -webkit-linear-gradient(90deg, #e63d3d, #fe5656);
	background-image: linear-gradient(0deg, #e63d3d, #fe5656)
}

.inst{
	padding: 10px 1em;
}

.inst p{
	text-indent: 2em;
	line-height: 1.6;
}
</style>
<title>爱学网UE用户注册</title>
<script type="text/javascript">
<c:if test="${param.s == '1' }">alert('注册成功，感谢您的参与！');</c:if>
</script>
</head>
<body>
<div id="page">
    <header class="page-header">
        <h1>爱学网用户体验计划注册</h1>
    </header>
    
    <div>
    <article>
    	<section class="inst">
    	<p><strong>爱学网用户体验计划</strong>是由爱学网用户体验设计研究与创新团队主持的旨在深入进行用户交流的项目。目的是收集用户（老师和家长）的相关需求、反馈和用户体验，同时，解决用户使用产品过程中的相关问题。同时，通过该计划，用户可以尽早体验我们的产品，从而为进一步的使用我们的产品奠定基础。 </p>
	    <p>该计划主要包括新产品体验、产品试用、用户研究、参与设计和用户交流会等内容。</p>
	    <p>不论您是否是爱学网的会员和用户，只要您愿意，我们都热忱欢迎所有用户参加我们的爱学网的用户体验计划。</p>
	    <p>参加爱学网用户体验计划的用户将定期获得我们专门为参加该计划的客户提供相关的礼品和酬金，并比一般用户更早体验和使用我们的新产品，有机会获得收费产品的优惠（如赠送使用期限、价格打折等等。</p>
	    <p>精彩用户体验，爱学网期待您的参与！</p>
    	</section>
    	
        <section>
           <form id="form_reg" name="form_reg" onsubmit="return valid();" 
           action="/ue/reg.do" method="post" >
                   <table class="reg_table">
                   <tr>
                   	<td colspan="2">
                   		<div class="table_title">
                   			<h2>体验计划注册信息表</h2>
                   			<span>温馨提示：此次我们召集的体验用户主要面向老师和家长</span>
                   		</div>
                   	</td>
                   </tr>
                   <tr>
                   	<th>真实姓名：</th>
                   	<td><input type="text" class="text" id="name" name="name" maxlength="8"><span class="requird">*</span></td>
                   </tr>
                   <tr>
                   	<th>性别：</th>
                   	<td>
                   		<label>
                   		<input type="radio" id="gender" name="gender" value="MALE">男
                   		</label>
                   		&nbsp;&nbsp;
                   		<label>
                   		<input type="radio" id="gender" name="gender" value="FEMALE">女
                   		</label><span class="requird">*</span>
                   	</td>
                   </tr>
                   <tr>
                   	<th>出生年份：</th>
                   	<td>
                   		<select id="birthYear" name="birthYear">
                   			<option value="">-请选择-</option>
                   			<optgroup label="40">
                   			<option value="1950">1940</option>
                   			<option value="1950">1941</option>
                   			<option value="1950">1942</option>
                   			<option value="1950">1943</option>
                   			<option value="1950">1944</option>
                   			<option value="1950">1945</option>
                   			<option value="1950">1946</option>
                   			<option value="1950">1947</option>
                   			<option value="1950">1948</option>
                   			<option value="1950">1949</option>
                   			</optgroup>
                   			<optgroup label="50">
                   			<option value="1950">1950</option>
							<option value="1951">1951</option>
							<option value="1952">1952</option>
							<option value="1953">1953</option>
							<option value="1954">1954</option>
							<option value="1955">1955</option>
							<option value="1956">1956</option>
							<option value="1957">1957</option>
							<option value="1958">1958</option>
							<option value="1959">1959</option>
							</optgroup>
                   			<optgroup label="60">
							<option value="1960">1960</option>
							<option value="1961">1961</option>
							<option value="1962">1962</option>
							<option value="1963">1963</option>
							<option value="1964">1964</option>
							<option value="1965">1965</option>
							<option value="1966">1966</option>
							<option value="1967">1967</option>
							<option value="1968">1968</option>
							<option value="1969">1969</option>
							</optgroup>
                   			<optgroup label="70">
							<option value="1970">1970</option>
							<option value="1971">1971</option>
							<option value="1972">1972</option>
							<option value="1973">1973</option>
							<option value="1974">1974</option>
							<option value="1975">1975</option>
							<option value="1976">1976</option>
							<option value="1977">1977</option>
							<option value="1978">1978</option>
							<option value="1979">1979</option>
							</optgroup>
                   			<optgroup label="80">
							<option value="1980">1980</option>
							<option value="1981">1981</option>
							<option value="1982">1982</option>
							<option value="1983">1983</option>
							<option value="1984">1984</option>
							<option value="1985">1985</option>
							<option value="1986">1986</option>
							<option value="1987">1987</option>
							<option value="1988">1988</option>
							<option value="1989">1989</option>
							</optgroup>
                   			<optgroup label="90">
							<option value="1990">1990</option>
							<option value="1991">1991</option>
							<option value="1992">1992</option>
							<option value="1993">1993</option>
							<option value="1994">1994</option>
							<option value="1995">1995</option>
							<option value="1996">1996</option>
							<option value="1997">1997</option>
							<option value="1998">1998</option>
							<option value="1999">1999</option>
							<option value="2000">2000</option>
							</optgroup>
                   		</select><span class="requird">*</span>
                   	</td>
                   </tr>
                   <tr>
                   	<th>身份：</th>
                   	<td>
                   		<label><input type="radio" id="identity1" name="identity" value="CLZ_MASTER">班主任</label><label><input type="radio" id="identity2" name="identity" value="TEACHER">任课老师</label><label><input type="radio" id="identity2" name="identity" value="PARENT">家长</label><span class="requird">*</span>
                   	</td>
                   </tr>
                   <tr>
                   	<th>学校：</th>
                   	<td><input type="text" class="text" id="school" name="school" maxlength="64"><span class="requird">*</span></td>
                   </tr>
                   <tr class="gp PARENT">
                   	<th>孩子年级：</th>
                   	<td>
                   		<select name="grade" id="grade">
                   			<option value="">-请选择-</option>
							<option value="1">小一</option>
							<option value="2">小二</option>
							<option value="3">小三</option>
							<option value="4">小四</option>
							<option value="5">小五</option>
							<option value="6">小六</option>
							<option value="7">初一</option>
							<option value="8">初二</option>
							<option value="9">初三</option>
							<option value="10">高一</option>
							<option value="11">高二</option>
							<option value="12">高三</option>
							<option value="13">大学一年级</option>
							<option value="14">大学二年级</option>
							<option value="15">大学三年级</option>
							<option value="16">大学四年级</option>
							<option value="-7">幼儿园托儿班</option>
							<option value="-6">幼儿园小小班</option>
							<option value="-5">幼儿园小班</option>
							<option value="-4">幼儿园中班</option>
							<option value="-3">幼儿园大班</option>
							<option value="-2">幼儿园学前班</option>
							<option value="-1">幼儿园</option>
							<option value="0">学前班</option>
							<option value="30">兴趣</option>
                   		</select><span class="requird">*</span>
                   	</td>
                   </tr>
                   <tr class="gp TEACHER CLZ_MASTER">
                   	<th>任教科目：</th>
                   	<td>
                   		<select id="subject" name="subject">
                   			<option value="">-请选择-</option>
                   			<option value="1">语文</option>
							<option value="2">数学</option>
							<option value="3">英语</option>
							<option value="4">政治</option>
							<option value="5">物理</option>
							<option value="6">化学</option>
							<option value="7">地理</option>
							<option value="8">历史</option>
							<option value="9">生物</option>
							<option value="10">美术</option>
							<option value="11">音乐</option>
							<option value="12">体育</option>
							<option value="13">德育考核</option>
							<option value="14">劳动技术</option>
							<option value="15">计算机</option>
							<option value="16">物理实验</option>
							<option value="17">化学实验</option>
							<option value="18">生物实验</option>
                   		</select><span class="requird">*</span>
                   	</td>
                   </tr>
                   <tr>
                   	<th>邮箱地址：</th>
                   	<td><input type="email" class="text" id="email" name="email" maxlength="64"><span class="requird">*</span></td>
                   </tr>
                   <tr>
                   	<th>手机号：</th>
                   	<td><input type="text" class="text" id="phone" name="phone" maxlength="11"><span class="requird">*</span></td>
                   </tr>
                   <tr>
                   	<th>收货地址：<br>(便于邮寄礼品)</th>
                   	<td>
                   	<textarea id="addr" name="addr" rows="5" class="textarea" maxlength="255"></textarea>
                   	<span class="requird">*</span></td>
                   </tr>
                   <tr>
                   	<td></td>
                   	<td><input type="submit" value="提　交" class="submit">
                   	</td>
                   </tr>
                   </table>
           </form>
       </section>
       
       <section style="padding-right:10px;">
<p style="margin:50px 10px 10px 15px;text-align: justify;font-size: 14px;font-family: &#39;Times New Roman&#39;;white-space: normal">
    <span style="color: rgb(255, 115, 0);font-size: 33px;font-family: 黑体">常见问题与解答</span>
</p>
<p style="margin: 0 0 0 24px;text-align: justify;font-size: 14px;font-family: &#39;Times New Roman&#39;;white-space: normal;line-height: 21px">
    <span style="font-weight: bold;font-size: 14px;font-family: Symbol">1&nbsp;</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">什么是</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">爱学网</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">用户体验计划？该计划包括哪些内容？</span><span style="font-size: 14px;font-family: 宋体"><br/></span><span style="font-size: 14px;font-family: 宋体">爱学网</span><span style="font-size: 14px;font-family: 宋体">用户体验计划是由</span><span style="font-size: 14px;font-family: 宋体">爱学网</span><span style="font-size: 14px;font-family: 宋体">中国站用户体验设计研究与创新团队主持的旨在深入进行用户交流的长期项目。目的是收集用户的相关需求、反馈和用户体验，同时，解决用户使用产品过程中的相关问题。通过该计划，用户可以尽早体验我们的产品，从而为进一步的使用我们的产品奠定基础。该计划主要包括新产品体验、用户研究、产品试用、参与设计和用户交流会等内容。</span><span style="font-size: 14px;font-family: 宋体"><br/></span>
</p><br>
<p style="margin: 0 0 0 24px;text-align: justify;font-size: 14px;font-family: &#39;Times New Roman&#39;;white-space: normal;line-height: 21px">
    <span style="font-weight: bold;font-size: 14px;font-family: Symbol">2&nbsp;</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">参加该计划的活动大约花费多长时间？</span><span style="font-size: 14px;font-family: 宋体"><br/></span><span style="font-size: 14px;font-family: 宋体">我们组织的活动形式多样，从5分钟到2个小时不等。具体时间我们将根据活动内容具体和您协商决定。</span><span style="font-size: 14px;font-family: 宋体"><br/></span>
</p><br>
<p style="margin: 0 0 0 24px;text-align: justify;font-size: 14px;font-family: &#39;Times New Roman&#39;;white-space: normal;line-height: 21px">
    <span style="font-weight: bold;font-size: 14px;font-family: Symbol">3&nbsp;</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">我参加</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">爱学网</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">用户体验计划有什么好处？</span><span style="font-size: 14px;font-family: 宋体"><br/></span><span style="font-size: 14px;font-family: 宋体">首先</span><span style="font-size: 14px;font-family: 宋体">，我们会为参加</span><span style="font-size: 14px;font-family: 宋体">爱学网</span><span style="font-size: 14px;font-family: 宋体">用户体验计划的用户提供实实在在的优惠，如有机会获得收费产品的优惠（如赠送使用期限、价格打折等）、获得我们提供相关的礼品和酬金等。</span><span style="font-size: 14px;font-family: 宋体"><br/></span><span style="font-size: 14px;font-family: 宋体">第</span><span style="font-size: 14px;font-family: 宋体">二</span><span style="font-size: 14px;font-family: 宋体">，参加</span><span style="font-size: 14px;font-family: 宋体">爱学网</span><span style="font-size: 14px;font-family: 宋体">用户体验计划的用户将比一般用户更早体验核使用我们的新产品，</span><span style="font-size: 14px;font-family: 宋体">了解教育行业最新信息和享用最优教学成果</span><span style="font-size: 14px;font-family: 宋体">。</span><span style="font-size: 14px;font-family: 宋体"><br/></span><span style="font-size: 14px;font-family: 宋体">另外，如果您愿意，您还有机会直接和</span><span style="font-size: 14px;font-family: 宋体">中国顶尖的教育教学</span><span style="font-size: 14px;font-family: 宋体">研发团队一起，参与我们的产品研发，把您的需求直接转化为我们的产品。</span><span style="font-size: 14px;font-family: 宋体"><br/></span>
</p><br>
<p style="margin: 0 0 0 24px;text-align: justify;font-size: 14px;font-family: &#39;Times New Roman&#39;;white-space: normal;line-height: 21px">
    <span style="font-weight: bold;font-size: 14px;font-family: Symbol">4&nbsp;</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">我不是</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">爱学网</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">会员</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">和</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">用户，我可以参加吗？</span><span style="font-size: 14px;font-family: 宋体"><br/></span><span style="font-size: 14px;font-family: 宋体">当然可以。我们热忱欢迎所有用户参加我们的</span><span style="font-size: 14px;font-family: 宋体">爱学网</span><span style="font-size: 14px;font-family: 宋体">用户体验计划。</span><span style="font-size: 14px;font-family: 宋体"><br/></span>
</p><br>
<p style="margin: 0 0 0 24px;text-align: justify;font-size: 14px;font-family: &#39;Times New Roman&#39;;white-space: normal;line-height: 21px">
    <span style="font-weight: bold;font-size: 14px;font-family: Symbol">5&nbsp;</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">我以前从来没有接触过</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">爱学网</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">任何产品，我可以参加吗？</span><span style="font-size: 14px;font-family: 宋体"><br/></span><span style="font-size: 14px;font-family: 宋体">当然可以。我们热忱欢迎所有用户参加我们的</span><span style="font-size: 14px;font-family: 宋体">爱学网</span><span style="font-size: 14px;font-family: 宋体">用户体验计划。</span><span style="font-size: 14px;font-family: 宋体"><br/></span>
</p><br>
<p style="margin: 0 0 0 24px;text-align: justify;font-size: 14px;font-family: &#39;Times New Roman&#39;;white-space: normal;line-height: 21px">
    <span style="font-weight: bold;font-size: 14px;font-family: Symbol">6&nbsp;</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">我的住址不在</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">广州</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">，我是否可以参加？</span><span style="font-size: 14px;font-family: 宋体"><br/></span><span style="font-size: 14px;font-family: 宋体">可以。我们的活动</span><span style="font-size: 14px;font-family: 宋体">基本可以通过手机，邮件等方式实现，所以地域不是问题。</span><span style="font-size: 14px;font-family: 宋体"><br/></span>
</p><br>
<p style="margin: 0 0 0 24px;text-align: justify;font-size: 14px;font-family: &#39;Times New Roman&#39;;white-space: normal;line-height: 21px">
    <span style="font-weight: bold;font-size: 14px;font-family: Symbol">7&nbsp;</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">爱学网</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">如何确保我的隐私和注册信息的安全？</span><span style="font-size: 14px;font-family: 宋体"><br/></span><span style="font-size: 14px;font-family: 宋体">爱学网</span><span style="font-size: 14px;font-family: 宋体">有严格的隐私保护和信息安全的政策。我们保证您的所有信息，都不会用于商业用途，仅限于</span><span style="font-size: 14px;font-family: 宋体">爱学网</span><span style="font-size: 14px;font-family: 宋体">产品研发。</span><span style="font-size: 14px;font-family: 宋体"><br/></span>
</p><br>
<p style="margin: 0 0 0 24px;text-align: justify;font-size: 14px;font-family: &#39;Times New Roman&#39;;white-space: normal;line-height: 21px">
    <span style="font-weight: bold;font-size: 14px;font-family: Symbol">8&nbsp;</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">多久可以参加一次研究和活动？&nbsp;</span><span style="font-size: 14px;font-family: 宋体"><br/></span><span style="font-size: 14px;font-family: 宋体">我们将统一安排组织相关的研究和活动。一般说来，我们将根据您填写的注册信息和我们和您沟通的结果确定。</span><span style="font-size: 14px;font-family: 宋体">一般一个月不超过</span><span style="font-size: 14px;font-family: 宋体">4次体验活动。</span><span style="font-size: 14px;font-family: 宋体"><br/></span>
</p><br>
<p style="margin: 0 0 0 24px;text-align: justify;font-size: 14px;font-family: &#39;Times New Roman&#39;;white-space: normal;line-height: 21px">
    <span style="font-weight: bold;font-size: 14px;font-family: Symbol">9&nbsp;</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">我注册后，你们会怎么联系我？</span><span style="font-size: 14px;font-family: 宋体"><br/></span><span style="font-size: 14px;font-family: 宋体">我们将主要通过电话和电子邮件的方式联系您。</span><span style="font-size: 14px;font-family: 宋体"><br/></span>
</p><br>
<p style="margin: 0 0 0 24px;text-align: justify;font-size: 14px;font-family: &#39;Times New Roman&#39;;white-space: normal;line-height: 21px">
    <span style="font-weight: bold;font-size: 14px;font-family: 宋体">10&nbsp;除了在网上注册，还有其他的参加方式吗？</span><span style="color: rgb(255, 0, 0);font-size: 14px;font-family: 宋体"><br/></span><span style="font-size: 14px;font-family: 宋体">网上注册是您参加爱学网用户体验计划的主要途径。同时我们还会在爱学网的其它用户活动中，通过发放注册表的方式来邀请我们的用户参加爱学网用户体验计划。我们强烈建议您通过网上注册的方式参加我们的活动。</span><span style="font-size: 14px;font-family: 宋体"><br/></span>
</p><br>
<p style="margin: 0 0 0 24px;text-align: justify;font-size: 14px;font-family: &#39;Times New Roman&#39;;white-space: normal;line-height: 21px">
    <span style="font-weight: bold;font-size: 14px;font-family: Symbol">11&nbsp;</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">我可以更新我的信息吗？</span><span style="font-size: 14px;font-family: 宋体"><br/></span><span style="font-size: 14px;font-family: 宋体">您可以随时通过电话或电子邮件更新您的信息。</span><span style="font-size: 14px;font-family: 宋体"><br/></span>
</p><br>
<p style="margin: 0 0 0 24px;text-align: justify;font-size: 14px;font-family: &#39;Times New Roman&#39;;white-space: normal;line-height: 21px">
    <span style="font-weight: bold;font-size: 14px;font-family: Symbol">12&nbsp;</span><span style="font-weight: bold;font-size: 14px;font-family: 宋体">如果我还有疑问，我该怎么办？</span><span style="font-size: 14px;font-family: 宋体"><br/></span><span style="font-size: 14px;font-family: 宋体">如果您还有任何疑问，您可以发送电子邮件给我们（</span><span style="font-size: 14px;font-family: 宋体">yi_sun@istudy.com.cn</span><span style="font-size: 14px;font-family: 宋体">），我们将尽快给您回复。</span>
</p><br>
<p style=";text-align: justify;font-size: 14px;font-family: &#39;Times New Roman&#39;;white-space: normal">
    <span style="font-size: 14px">&nbsp;</span>
</p><br>
       </section>
    </article>
    </div>
    <footer class="page-footer">
    <div class="copyright">
        <table>
            <tr>
                <td>服务提供：</td>
                <td><img src="<%=basePath%>/img/i-logo-footer.png" alt="istudy" width="30" height="24"><span>华附在线（爱学网）</span></td>
            </tr>
        </table>
    </div>
	</footer>
</div>
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">

(function(){
	$("input[name=identity]").on("change",function(){
		var val = $(this).val();
		$("tr.gp").hide();
		$("tr." + val).show();
	});
}());

function getLabel($obj){
	var text = $obj.parents("td").prev().text() || "";
	return text.replace("：", "");
}

function checkNull(){
	var flag = true;
	$("#form_reg input:visible,#form_reg select:visible").each(function(){
		var $this = $(this);
		var type = $this.attr("type");
		if(type == 'radio'){
			var name = $this.attr("name");
			if($("#form_reg input[name="+name+"]:radio:checked").length == 0){
				alert("请选择" + getLabel($this));
				this.focus();
				flag = false;
				return false;
			}
		}else{
			var val = $.trim($this.val() || "");
			$this.val(val);
			if(!val){
				var tagName = this.tagName;
				if(tagName.toUpperCase() == 'SELECT'){
					alert("请选择" + getLabel($this));
				}else{
					alert("请填写" + getLabel($this));
				}
				this.focus();
				flag = false;
				return false;
			}
		}
	});
	if(flag == true){
		var addr = $("#addr").val();
		if(!addr){
			alert("请填写收货地址！");
			return false;
		}else if(addr.length > 255){
			alert("地址长度不得大于255个字符！");
			return false;
		}
	}
	
	return flag;
}

function valid(){
	
	if(checkNull() == false){
		return false;
	}
	

	var name = $("#name");
	if(!/^[\u4e00-\u9fa5]{2,8}$/.test(name.val())){
		alert(getLabel(name) + "只能为2到8个汉字！");
		name[0].focus();
		return false;
	}
	
	var email = $("#email");
	if(!/^([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+@([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+.[a-za-z]{2,3}$/.test(email.val())){
		alert(getLabel(email) + "格式不正确！");
		email[0].focus();
		return false;
	}
	
	var phone = $("#phone");
	if(!/^[0-9]{11}$/.test(phone.val())){
		alert(getLabel(phone) + "格式不正确！");
		phone[0].focus();
		return false;
	}
	
	return true;
}
</script>
</body>
</html>
