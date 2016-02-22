var url_head = "/";
$(document).ready(function() {
	var item = $('input[name=editType]:checked').val();
	changeMinisiPage(item);
	$('input[name=editType]').click(function() {
		item = $('input[name=editType]:checked').val();
		changeMinisiPage(item);
	});
	//刷新页数
	var currentPage = $('#currentPage');
	if(currentPage){
		currentPage.val('1');
	}
	
	function changeMinisiPage (item){
		switch (parseInt(item)) {
		case 1:
			// 图文
			$('#tile_div').show();
			$('#details_div').show();
			$('#vidio_div').hide();
			$('#details_attr').html('<span style="color: red">*</span>图文内容:');
			$('#tile_span').html('图文标题');
			//tile_span
			break;
		case 2:
			// 视频
			$('#tile_div').show();
			$('#details_div').show();
			$('#vidio_div').show();
			$('#details_attr').html('<span style="color: red">*</span>视频介绍:');
			$('#tile_span').html('视频标题');
			break;
		default:
			$('#tile_div').hide();
			$('#details_div').hide();
			$('#vidio_div').hide();
			$('.edit-type-item input').prop('value',function(){
				return "";
			});
			//alert($('.edit-type-item input').length);
			break;
		}
	};
	$('#allGrade').click(function() {
		var checked = $(this).is(':checked');
		if (checked == true) {
			// $("[name='grade']").attr('checked','true');
			$("[name='grade']").each(function() {
				$(this).attr('checked', 'checked');
			});
		} else {
			$("[name='grade']").each(function() {
				$(this).removeAttr('checked');
			});
			// $("#grade").attr("checked",'');
		}

	});

	$('*').focus(function() {
		var error_msg = $('#error_msg');
		if (error_msg) {
			error_msg.html('');
		}
	});
});

(function($) {
	$.charLength = function(value) {
		var length = value.length;
		for (var i = 0; i < value.length; i++) {
			if (value.charCodeAt(i) > 127) {
				length+=2;
			}
		}
		return length;
	};
	//判断为空
	$.isNull = function(value){
		return value==null||this.trim(value)=='';
	};
	/** 分页* */
	jQuery.paging = function(what ,url, resouce, result) {
		var // pageSize=20,
		// startIndex=0,
		startPage = $('a[name=startPage]'), endPage = $('a[name=endPage]'), beforePage = $('a[name=beforePage]'), nextPage = $('a[name=nextPage]'), currentPage = $('#currentPage'), amount = parseInt($(
				'strong[name=pageAmount]').html()), // 总页数
		current = parseInt(currentPage.val()), paging = {
			pageIndex : 0,
			what:what,
			param : resouce
		}, doPaging = function(paging) {
			$.ajax({
				type : "POST",
				url : url,
				data : eval(paging),
				dataType : "json",
				success : result
			});
			current = paging.pageIndex;
		};
		// 起始页
		startPage.click(function() {
			if (current <= 1) {// 当前是第一页
				return;
			}
			paging.pageIndex = 1;
			doPaging(paging);
		});

		// 结束页
		endPage.click(function() {
			if (current >= amount) {
				return;
			}
			paging.pageIndex = amount;
			doPaging(paging);
		});

		// 前一页
		beforePage.click(function() {
			if (current <= 1) {// 当前是第一页
				return;
			}
			paging.pageIndex = current - 1;
			doPaging(paging);
		});

		// 后一页
		nextPage.click(function() {
			if (current >= amount) {
				return;
			}
			paging.pageIndex = current + 1;
			doPaging(paging);
		});

		// 跳转到指定页
		currentPage.blur(function() {
			var c_ = parseInt(currentPage.val());
			if (c_) {
				if (!isNaN(c_)) {
					if (c_ > 0 && c_ <= amount) {
						paging.pageIndex = c_;
						doPaging(paging);
					} else {
						alert('你输入的页数超过了总页数');
					}
				} else {
					alert('你输入的页数不是数字');
				}
			} else {
				alert('请输入页数');
			}
		});
		return this;
	};
})(jQuery);

/**
 * JSON对象转字符串
 */
MyString =MyTest =JSON = function(){};
JSON.stringify = JSON.stringify || function(obj) {
	var t = typeof (obj);
	if (t != "object" || obj === null) {
		// simple data type
		if (t == "string")
			obj = '"' + obj + '"';
		return String(obj);
	} else {
		// recurse array or object
		var n, v, json = [], arr = (obj && obj.constructor == Array);
		for (n in obj) {
			v = obj[n];
			t = typeof (v);
			if (t == "string")
				v = '"' + v + '"';
			else if (t == "object" && v !== null)
				v = JSON.stringify(v);
			json.push((arr ? "" : '"' + n + '":') + String(v));
		}
		return (arr ? "[" : "{") + String(json) + (arr ? "]" : "}");
	}
};

//"number," "string," "boolean," "object," "function," 和 "undefined."
MyString.toEmpty = function(obj){
	var t = typeof (obj);
	if(t=="undefined"){
		return "";
	}
	return obj;
};

MyString.toNull = function(obj){
	var t = typeof (obj);
	if(t=="undefined"||obj==""){
		return null;
	}
	return obj;
};
MyString.excLast = function(obj){
	var t = typeof (obj);
	if(t=="string"){
		return obj.replace(/\,$/,"");
	}
	return obj;
};
MyString.delSpecialStr = function(obj){
	var t = typeof (obj),
			back = "";
	if(t=="string"){
		//过滤HTML字符实体
		//&amp;nbsp;&amp;gt;&amp;lt;
		for(var i = 0;i<obj.length;i++){
			var cur = obj.substring(i,i+1);
			var code = obj.charCodeAt(i);
			if(!((code<48)||(code>=58&&code<=64)||(code>=91&&code<=96))){
				back+=cur;
			}
		}
		return back;
	}
	return obj;
};

MyTest.a = function(a){return ""};
