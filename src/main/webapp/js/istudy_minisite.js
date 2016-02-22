function goTop(acceleration, time) {
  acceleration = acceleration || 0.1;//加速度 acceleration
   time = time || 15;//时间间隔
	var x=0,y=0;
	
	if (document.documentElement) {
	   x = document.documentElement.scrollLeft|| 0;
	   y = document.documentElement.scrollTop || 0;
	}
	
	var speed = 1 + acceleration;//滚动速度
	      //  floor()返回值为小于等于其数值参数的最大整数值 假如 y=36 speed=1.1   36/1.1=32;
	      // scrollTo()滚动条将要移动到x y 经过计算得出的值
	window.scrollTo(Math.floor(x / speed), Math.floor(y / speed));
	    //如果 x (scrollLeft!=0)||y(scrollTop!=0)还未移动到顶部.所以setTimeout()继续执行该函数
    if(x > 0 || y > 0) {
           var invokeFunction = "goTop(" + acceleration + ", " + time + ")";
           window.setTimeout(invokeFunction, time);
      }
}


function postUserActionRecord(basePath, type, info){
	basePath = basePath || "";
	$.ajax(basePath + "/xxtStat/addRecord.do",{
		async:false,
		cache:false,
		data:{type : type , miniUrl : info, url:window.location.href}
	});
	//$.post(basePath + "/xxtStat/addRecord.do", {type : type , info : info});
};

function postUserActionRecordV2(basePath, action, queryStr){
	basePath = basePath || "";
	$.ajax(basePath + "/xxtStat/addRecordV2.do?action=" + action + "&" + queryStr,{
		async:false,
		cache:false
	});
};

function useful(el,basePath,queryStr){
	eventPush(basePath,queryStr,"btnclick-useful");
	hiddenFeedback();
}

function useless(el,basePath,queryStr){
	eventPush(basePath,queryStr,"btnclick-useless");
	hiddenFeedback();
}

function hiddenFeedback(){
	showMessage();
	var fb = document.getElementById("feedback-div");
	if(fb){
		fb.style.display = "none";
		fb.parentNode.removeChild(fb);
	}
}

function disabledUseBtn(el){
	var nodes = el.parentNode.childNodes;
	for(var i = 0; i < nodes.length; i++){
		var node = nodes[i];
		node.onclick=function(){return false;};
		node.className+=" disabled";
	}
}

function eventPush(basePath,queryStr,action){
	basePath = basePath || "";
	queryStr = queryStr || "p=none";
	action = action || "noaction";
	var commonPath = basePath + "/xxtStat/addRecordV2.do?"+queryStr+"&action=";
	var img = new Image();
	img.src=commonPath + action + "&r=" + Math.random();
}

function eventPush2(basePath,queryStr,action,idtype){
	var $name = $("#userName");
	var name = $name.val();
	var localStorageKey = "isSubjection" + idtype;
	if(!name){
		alert("请填写姓名！");
		$name[0].focus();
		return false;
	}
	
	if(name && !/^[\u4e00-\u9fa5]{2,5}$/.test(name)){
		alert("姓名只能为2到5个汉字！");
		$name[0].focus();
		return false;
	}

	basePath = basePath || "";
	queryStr = queryStr || "p=none";
	action = action || "noaction";
	var commonPath = basePath + "/xxtStat/addRecordV2.do?"+queryStr+"&action=";
	var img = new Image();
	img.src=commonPath + action + "&info=" + encodeURI(name) + "&r=" + Math.random();
	if(localStorage.getItem(localStorageKey) !== "true") {
			localStorage.setItem(localStorageKey, "true");
		}
	
	$("#btnSubmit").attr("disabled", "disabled");
	
	$("#overlay").show();
	$("#msgbox").show();
	
	$("#btnHideBox").click(function() {
		$("#overlay").hide();
		$("#msgbox").hide();
	});
}

function eventPush3(basePath,queryStr,action,idtype){
	var $name = $("#userName");
	var name = $name.val();
	if(!name){
		alert("请填写姓名！");
		$name[0].focus();
		return false;
	}
	
	if(name && !/^[\u4e00-\u9fa5]{2,5}$/.test(name)){
		alert("姓名只能为2到5个汉字！");
		$name[0].focus();
		return false;
	}

	basePath = basePath || "";
	queryStr = queryStr || "p=none";
	action = action || "noaction";
	var commonPath = basePath + "/xxtStat/addRecordV2.do?"+queryStr+"&action=",
		getCountPath = basePath + "/xxtStat/countCheck.do?idtypes=220,221&action=" + action;
	var img = new Image();
/*	var resouce = {
			action: "btnclick-savename",
			idtypes : idtype
	};*/
	
	var localStorageKey = "isSubjection" + idtype;
	
	$.ajax({
  		 type: "GET",
  		 url: getCountPath,
  		 dataType: "json",
  		 success: function(obj){
  			 if(obj.code=="1"){ 
  				img.src=commonPath + action + "&info=" + encodeURI(name) + "&r=" + Math.random();
  				$("#msgbox .title").html("恭喜你已经预约成功！凭预约姓名和孩子入场，无需再确认。");
  				
  				if(localStorage.getItem(localStorageKey) !== "true") {
  					localStorage.setItem(localStorageKey, "true");
  				}
  			 }else{
  				img.src=commonPath + action + "&info=" + encodeURI(name) + "&r=" + Math.random();
  				$("#msgbox .title").html("很遗憾，讲座预约名额已满。您可拨打电话：020-23386779 提前预约下期讲座。");
  			 }
  		 }
  	});
	
	$("#btnSubmit").prop("disabled", true);
	$("#overlay").show();
	$("#msgbox").show();
	
	$("#btnHideBox").click(function() {
		$("#overlay").hide();
		$("#msgbox").hide();
	});
}


// 姓名||手机号码||地区  预约
function eventPush4(basePath,queryStr,action,idtype){
	var $name = $("#userName"),
		$phone = $("#phone"),
		$district = $("#district");
	var name = $name.val(),
		phone = $phone.val(),
		district = $district.val();
	if(!name){
		alert("请填写姓名！");
		$name[0].focus();
		return false;
	}
	
	if(name && !/^[\u4e00-\u9fa5]{2,5}$/.test(name)){
		alert("姓名只能为2到5个汉字！");
		$name[0].focus();
		return false;
	}
	if(!phone){
		alert("请填写手机号码！");
		$phone[0].focus();
		return false;
	}
	if(phone && !/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone)){
		alert("号码格式错误，请输入正确的手机号码！");
		$name[0].focus();
		return false;
	}

	basePath = basePath || "";
	queryStr = queryStr || "p=none";
	action = action || "noaction";
	var commonPath = basePath + "/xxtStat/addRecordV2.do?"+queryStr+"&action=",getCountPath = "";
	if("262" == idtype ||"263" == idtype ){
		getCountPath = basePath + "/xxtStat/countCheck1.do?idtypes=262,263&action=" + action;
	}
	else if("264" == idtype ||"265" == idtype ){
		getCountPath = basePath + "/xxtStat/countCheck1.do?idtypes=264,265&action=" + action;
	}
	else if("266" == idtype ||"267" == idtype ){
		getCountPath = basePath + "/xxtStat/countCheck1.do?idtypes=266,267&action=" + action;
	}
		
	var img = new Image();
/*	var resouce = {
			action: "btnclick-savename",
			idtypes : idtype
	};*/
	
	var localStorageKey = "isSubjection" + idtype;
	$.ajax({
  		 type: "GET",
  		 url: getCountPath,
  		 dataType: "json",
  		 success: function(obj){
  			 if(obj.code=="1"){ 
  				img.src=commonPath + action + "&info=" + encodeURI(name) + "|" + phone + "&r=" + Math.random();
  				$("#msgbox .title").html("恭喜你已经预约成功！凭预约姓名和孩子入场，无需再确认。");
  				
  				if(localStorage.getItem(localStorageKey) !== "true") {
  					localStorage.setItem(localStorageKey, "true");
  				}
  			 }else{
  				img.src=commonPath + action + "&info=" + encodeURI(name) + "|" + phone + "|" + encodeURI(district) + "&r=" + Math.random();
  				$("#msgbox .title").html("很遗憾，讲座预约名额已满。您可拨打电话：020-23386779 提前预约下期讲座。");
  			 }
  		 }
  	});
	
	$("#btnSubmit").prop("disabled", true);
	$("#overlay").show();
	$("#msgbox").show();
	
	$("#btnHideBox").click(function() {
		$("#overlay").hide();
		$("#msgbox").hide();
	});
}


function eventPush5(basePath,queryStr,action,idtype){
	var $name = $("#userName"),
		$school = $("#school"),
		$grade = $("#grade"),
		$district = $("#district"),
		$forward = $("#forward"),
		$phone = $("#phone");
	var name = $name.val(),
		school = $school.val(),
		grade = $grade.val(),
		district = $district.val(),
		forward = $forward.val(),
		phone = $phone.val();
	if(!name){
		alert("请填写姓名！");
		$name[0].focus();
		return false;
	}
	
	if(!school){
		alert("请填写学校！");
		$name[0].focus();
		return false;
	}
	
	if(!forward){
		alert("请填写意向学校！");
		$name[0].focus();
		return false;
	}
	
	if(name && !/^[\u4e00-\u9fa5]{2,5}$/.test(name)){
		alert("姓名只能为2到5个汉字！");
		$name[0].focus();
		return false;
	}
	if(!phone){
		alert("请填写手机号码！");
		$phone[0].focus();
		return false;
	}
	if(phone && !/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone)){
		alert("号码格式错误，请输入正确的手机号码！");
		$name[0].focus();
		return false;
	}

	basePath = basePath || "";
	queryStr = queryStr || "p=none";
	action = action || "noaction";
	var commonPath = basePath + "/xxtStat/addRecordV2.do?"+queryStr+"&action=",getCountPath = "";
	/*if("262" == idtype ||"263" == idtype ){
		getCountPath = basePath + "/xxtStat/countCheck1.do?idtypes=262,263&action=" + action;
	}
	else if("264" == idtype ||"265" == idtype ){
		getCountPath = basePath + "/xxtStat/countCheck1.do?idtypes=264,265&action=" + action;
	}
	else if("266" == idtype ||"267" == idtype ){
		getCountPath = basePath + "/xxtStat/countCheck1.do?idtypes=266,267&action=" + action;
	}*/
		
	var img = new Image();
/*	var resouce = {
			action: "btnclick-savename",
			idtypes : idtype
	};*/
	
	var localStorageKey = "isSubjection" + idtype;
	img.src=commonPath + action + "&info=" + encodeURI(name) + "|" + encodeURI(school) + "|"
		+ encodeURI(grade) + "|" + encodeURI(district) + "|" + encodeURI(forward) + "|" + phone + "&r=" + Math.random();
		
		/*if(localStorage.getItem(localStorageKey) !== "true") {
				localStorage.setItem(localStorageKey, "true");
		}*/
	
	if(window.location.hash != '#isBook'){
		$("#btnSubmit").prop("disabled", true);
		$("#overlay").show();
		$("#msgbox").show();
		
		$("#btnHideBox").click(function() {
			$("#overlay").hide();
			$("#msgbox").hide();
		});
		window.location.hash = 'isBook';
		document.getElementById("btnSubmit").disabled = true;
	}
	
	
}


function eventPush6(basePath,queryStr,action,idtype){
	var $name = $("#userName"),
		/*$school = $("#school"),
		$grade = $("#grade"),
		$district = $("#district"),*/
		$forward = $("#forward"),
		$phone = $("#phone");
	var name = $name.val(),
		/*school = $school.val(),
		grade = $grade.val(),
		district = $district.val(),*/
		forward = $forward.val(),
		phone = $phone.val();
	if(!name){
		alert("请填写姓名！");
		$name[0].focus();
		return false;
	}
	
	/*if(!school){
		alert("请填写学校！");
		$name[0].focus();
		return false;
	}*/
	
	if(!forward){
		alert("请填写意向学校！");
		$name[0].focus();
		return false;
	}
	
	if(name && !/^[\u4e00-\u9fa5]{2,5}$/.test(name)){
		alert("姓名只能为2到5个汉字！");
		$name[0].focus();
		return false;
	}
	if(!phone){
		alert("请填写手机号码！");
		$phone[0].focus();
		return false;
	}
	if(phone && !/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone)){
		alert("号码格式错误，请输入正确的手机号码！");
		$name[0].focus();
		return false;
	}

	basePath = basePath || "";
	queryStr = queryStr || "p=none";
	action = action || "noaction";
	var commonPath = basePath + "/xxtStat/addRecordV2.do?"+queryStr+"&action=",getCountPath = "";
	/*if("262" == idtype ||"263" == idtype ){
		getCountPath = basePath + "/xxtStat/countCheck1.do?idtypes=262,263&action=" + action;
	}
	else if("264" == idtype ||"265" == idtype ){
		getCountPath = basePath + "/xxtStat/countCheck1.do?idtypes=264,265&action=" + action;
	}
	else if("266" == idtype ||"267" == idtype ){
		getCountPath = basePath + "/xxtStat/countCheck1.do?idtypes=266,267&action=" + action;
	}*/
		
	var img = new Image();
/*	var resouce = {
			action: "btnclick-savename",
			idtypes : idtype
	};*/
	
	var localStorageKey = "isSubjection" + idtype;
	img.src=commonPath + action + "&info=" + encodeURI(name) + "|"  + encodeURI(forward) + "|" + phone + "&r=" + Math.random();
		
		/*if(localStorage.getItem(localStorageKey) !== "true") {
				localStorage.setItem(localStorageKey, "true");
		}*/
	
	if(window.location.hash != '#isBook'){
		$("#btnSubmit").prop("disabled", true);
		$("#overlay").show();
		$("#msgbox").show();
		
		$("#btnHideBox").click(function() {
			$("#overlay").hide();
			$("#msgbox").hide();
		});
		window.location.hash = 'isBook';
		document.getElementById("btnSubmit").disabled = true;
	}
	
	
}

function shareSina(basePath,queryStr){
	eventPush(basePath,queryStr,"btnclick-sina");
}

function shareQQzone(basePath,queryStr){
	eventPush(basePath,queryStr,"btnclick-qqzone");
}

function shareRR(basePath,queryStr){
	eventPush(basePath,queryStr,"btnclick-rr");
}

function shareQQweibo(basePath,queryStr){
	eventPush(basePath,queryStr,"btnclick-qqweibo");
}

function clickMainPage(basePath,queryStr){
	eventPush(basePath,queryStr,"btnclick-mainpage");
}

function clickBook(basePath,queryStr){
	eventPush(basePath,queryStr,"btnclick-book");
}

function click614(basePath,queryStr){
	eventPush(basePath,queryStr,"btnclick-614");
}

function click616(basePath,queryStr){
	eventPush(basePath,queryStr,"btnclick-616");
}

/**
 * 点击“有用没有”提示
 */
function showMessage(arg) {
    var feedbackMsgbox = document.getElementById("feedbackMsgbox");

    var msgText = arguments.length > 0 && typeof arguments[0] == "string" && arguments[0].replace(/^\s+|\s+$/g, "") ?
            arguments[0].replace(/^\s+|\s+$/g, "") : "感谢您的反馈";

    if(!feedbackMsgbox) {
        feedbackMsgbox = document.createElement("div");
        feedbackMsgbox.className = "feedback-msgbox";
        feedbackMsgbox.id = "feedbackMsgbox";

        var textEle = document.createElement("span");
        textEle.className = "text";
        
        var text = document.createTextNode(msgText);
        textEle.appendChild(text);

        feedbackMsgbox.appendChild(textEle);
        document.body.appendChild(feedbackMsgbox);
    } else {
        if(arguments.length > 0) {
            feedbackMsgbox.childNodes[0].firstChild.nodeValue = msgText;
        }
    }

    var i = 0,
        dataTimeout = feedbackMsgbox.getAttribute("data-timeout");

    i = setTimeout(function() {
        feedbackMsgbox.style.display = "none";
    }, 2000);
    
    if(dataTimeout !== undefined) {
        clearTimeout(parseInt(dataTimeout));
    }

    feedbackMsgbox.style.display = "block";
    feedbackMsgbox.setAttribute("data-timeout", i);
}


/**
 * 短信预览功能
 * url参数带有"previewSms=true"显示短信预览按钮，点击显示短信内容
 */
(function (w, d) {
    var search = w.location.search,
        arguments = search.substring(search.indexOf("?") + 1),
        regexp = new RegExp("(^|\\&)" + "previewSms=true" + "(\\&|$)");

    if(regexp.test(arguments)) {
        var header = d.getElementById("pageHeader"),
            btnShowSms = d.getElementById("btnShowSms"),
            smsContent = d.getElementById("smsContent"),
            btnHideSms = d.getElementById("btnHideSms");

        if(header && !btnShowSms && !btnHideSms && !smsContent) {
            var smsText = header.getAttribute("data-sms");

            btnShowSms = d.createElement("a");
            btnShowSms.href = "javascript:;";
            btnShowSms.className = "btn-sms";
            btnShowSms.id = "btnShowSms";
            btnShowSms.innerHTML = '<i class="icon-sms"></i>短信</a>';
            

            smsContent = d.createElement("div");
            smsContent.className = "sms-content";
            smsContent.id = "smsContent";

            var smsContentPosition = d.createElement("div");
            smsContentPosition.className = "position";

            var smsContentMain = d.createElement("div");
            smsContentMain.className = "main";

            if(smsText) {
                smsContentMain.appendChild(d.createTextNode(smsText));
            } else {
                smsContentMain.appendChild(d.createTextNode("无短信内容！"));
            }

            btnHideSms = d.createElement("button");
            btnHideSms.className = "btn-hide";
            btnHideSms.id = "btnHideSms";
            btnHideSms.appendChild(d.createTextNode("关闭"));

            smsContentPosition.appendChild(smsContentMain);
            smsContentPosition.appendChild(btnHideSms);
            smsContent.appendChild(smsContentPosition);
            header.appendChild(btnShowSms);
            header.parentNode.insertBefore(smsContent, header.nextSibling);
        }
        
        btnShowSms.style.display = "block";

        function isVisible(elem) {
            var display;

            if(window.getComputedStyle) {
                display = elem.ownerDocument.defaultView.getComputedStyle(elem, null).display;
            } else if(d.documentElement.currentStyle) {
                display =  elem.currentStyle.display;
            }

            return display == "none" ? false : true;
        }

        btnShowSms.onclick = function() {
            smsContent.style.display = isVisible(smsContent) ? "none" : "block";
        }

        btnHideSms.onclick = function() {
            smsContent.style.display = "none";
        }
    }
}(window, document));

if (!window.localStorage) {
    window.localStorage = {
        getItem: function (sKey) {
            if (!sKey || !this.hasOwnProperty(sKey)) {
                return null;
            }
            return unescape(document.cookie.replace(new RegExp("(?:^|.*;\\s*)" +
                    escape(sKey).replace(/[\-\.\+\*]/g, "\\$&") + "\\s*\\=\\s*((?:[^;](?!;))*[^;]?).*"), "$1"));
        },

        key: function (nKeyId) {
            return unescape(document.cookie.replace(/\s*\=(?:.(?!;))*$/, "").split(/\s*\=(?:[^;](?!;))*[^;]?;\s*/)[nKeyId]);
        },

        setItem: function (sKey, sValue) {
            if(!sKey) {
                return;
            }
            document.cookie = escape(sKey) + "=" + escape(sValue) + "; path=/";
            this.length = document.cookie.match(/\=/g).length;
        },

        length: 0,

        removeItem: function (sKey) {
            if (!sKey || !this.hasOwnProperty(sKey)) {
                return;
            }
            var sExpDate = new Date();
            sExpDate.setDate(sExpDate.getDate() - 1);
            document.cookie = escape(sKey) + "=; expires=" + sExpDate.toGMTString() + "; path=/";
            this.length--;
        },

        hasOwnProperty: function (sKey) {
            return (new RegExp("(?:^|;\\s*)" + escape(sKey).replace(/[\-\.\+\*]/g, "\\$&") + "\\s*\\=")).test(document.cookie);
        }
    };

    window.localStorage.length = (document.cookie.match(/\=/g) || window.localStorage).length;
}

// 百度统计
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F603a7b8374bb878690acfbca0e1d9342' type='text/javascript'%3E%3C/script%3E"));