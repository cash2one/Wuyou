<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/jsp/common.jsp" %>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
	padding:0;
	margin:0;
}
body{
	font-family: "Helvetica","Arial",serif;
	color:#333;
	background-color:#ccc;
	margin: 1em 10%;
}
h1{
	color: #333;
	background-color: transparent;
}
a{
	color: #c60;
	background-color: transparent; 
	font-weight: bold;
	text-decoration: none;
}
ul{
	padding : 0;
}
li{
	 float:left;
	padding: 1em;
	list-style:none; 
	/* display:inline; */
}
img{
	display:block;
}
.clear{display:block;width:0;height:0;padding:0;clear:both;float:none;}
.clearfix{zoom:1;}
.clearfix:before,
.clearfix:after{content:"";display:table;}
.clearfix:after{clear:both;}
</style>
</head>
<body>
<!-- <p>hello world</p>
<p id="test"></p>
<button onclick="test()">测试</button> -->
<h1>Snapshots</h1>
<p style="cursor:move">test<strong style="display:block">test</strong>test</p>
<ul class="clearfix">
<li title="123">
<a href="img/2014092601.jpg" class="a" test="" title="2014092601">测试1</a>
</li>

<li title="456">
<a href="img/2014092602.jpg" target="_blank" id="test2" class="a" test="" title="2014062602">测试2</a>
</li>

<li title="789">
<a href="img/2014092603.jpg" target="_blank" class="a" test="" title="2014062603">测试3</a>
</li>
<li title="012">
<a href="javascript:" target="_blank" class="a" title="2014062604">测试4</a>
</li>
</ul>

<img alt="" src="" id="placeholder">

<div id="table">
<p id="description" name="choose">choose an image</p>
<table id="dataTable">
	<tbody>
		<tr><td>123</td></tr>
		<tr><td>456</td></tr>
		<tr><td>789</td></tr>
	</tbody>
</table>
<p>test 1</p>
</div>
  <button id="theone">Does nothing...</button>
<button id="bind">Add Click</button>
<button id="unbind">Remove Click</button>
<div id="off" style="display:none;">Click!</div>


<!-- <a name="02">02</a> -->
<script type="text/javascript">
function aClick() {
	  $("#off").show().fadeOut("slow");
	}
	$("#bind").click(function () {
	  $("body").on("click", "#theone", aClick)
	    .find("#theone").text("Can Click!");
	});
	$("#unbind").click(function () {
	  $("body").off("click", "#theone", aClick)
	    .find("#theone").text("Does nothing...");
	});
	/* $("a").off("click","#test2",function(){
		alert("1")
	}); */
	
(function(){
	$(window).load(function(){
		alert("1")
		
	})
	/* var tab = document.getElementById("table");
	var des = document.getElementById("description");
	var p = document.createElement("p");
	var txt = document.createTextNode("text 2");
	p.appendChild(txt);
	des.parentNode.insertBefore(p, des.nextSibling);
	//tab.appendChild(p);
	
	$("#dataTable tbody tr").on("click",function(event){
		  alert($(this).text());
		});0 */
		var ph= $("#placeholder"),
			a = $(".a");
		
		
		
		a.on("click",function(event){
			event.preventDefault();
			ph.attr("src", this.href);
		})
		
		
		/* a.click(function(event){
			event.preventDefault();
			ph.attr("src", this.href);
		}) */
}())

function onTest(){

}

	
function showPic(whichpic){
	var source = whichpic.getAttribute("test");
	var text = whichpic.getAttribute("title");
	/* var source = whichpic; */
	var placeholder = document.getElementById("placeholder");
	placeholder.setAttribute("src",source);
	var description = document.getElementById("description");
	description.firstChild.nodeValue="This image is " + text;
}
function test(){
	/* $.ajax({
		 type: "GET",
		 url: "xxtStat/rptTest1.do",
		 dataType: "json",
		 success: function(data){
			 var s = "";
			 
			 for(var o in data){  
			        for(var i=0;i<data[o].length;i++){
			        	
			        	s = s + "<tr><td>文章编号</td><td>" + data[o][i].idtype +"</td> <td>点击数</td><td>" + data[o][i].click + "</td></tr>" ;
			        }
			          
			      } 
			 document.write("<table border='1' style='background-color:grey'>" + s + "</table>");
		 }
}); */
$.ajax({
	 type: "GET",
	 crossDomain:true,
	 url: "http://wuyou.istudy.com.cn/xxtStat/rptTest1.do",
	 dataType: "jsonp",
	 jsonp:'callback'
}).done(function(data){
	
	var s = "";
	 
	 for(var o in data){  
	        /* for(var i=0;i<data[o].length;i++){
	        	
	        	s = s + "<tr><td>文章编号</td><td>" + data[o][i].idtype +"</td> <td>点击数</td><td>" + data[o][i].click + "</td></tr>" ;
	        } */
	          alert(o +":" + data[o]);
	      } 
	 document.write("<table border='1' style='background-color:grey'>" + s + "</table>");
}).fail(function(){
	alert("fail")
})
}

</script>
</body>

</html>