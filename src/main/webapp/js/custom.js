function fnSendObj() {
    var $tabNav = $("#sendObjOpts .tab-nav"),
        navCurrentClass = "cur",
        $persorItem = $("#persorOpts"),                    // 发个人选项块
        $persorList = $persorItem.children(".sel-item"),   // 发个人选项列表
        $selNum = $("#studentNum"),                        // 选中的个数
        $selResult = $("#selectResult"),                  // 选中的结果
        student_pool = $('#student_pool'),
    	$class = $('input[name="class"]');

    /**
     * [发送对象标签切换，点击发个人显示个人选项]
     * @return {[type]} [description]
     */
    $tabNav.children().click(function() {
        $(this).addClass(navCurrentClass);
        $(this).siblings("." + navCurrentClass).removeClass(navCurrentClass);

        if($(this).index() === 1) {
            $persorItem.show();
        } else {
            $persorItem.hide();
        }
    });
    
    $class.on('click',function(event){
    	var _checkbox = $(this);
    	var class_id = $(this).val();
    	if(_checkbox.prop("checked") === true) {
        	var shtml = "";
        	$("input[value^='"+class_id+"']").each(function(){
        		 var obj = $(this).parents("span").html();
        		 if(obj){
        			 shtml+="<span>"+obj+"</span>"; 
        		 }
        	});
        	student_pool.append(shtml);
    	}else{
    		 //$selResult.children("[index=" + $(_this).index() + "]").remove();
    		 student_pool.find("[value^='"+class_id+"']").parents("span").remove();
    		 //删除已选
    		 var ssize = $("span[value^='"+class_id+"_']").length;
    		 var o = parseInt($('#studentNum').html());
    		 $('#studentNum').html(o-ssize);
    		 $('#selectResult').children("[value^='"+class_id+"_']").remove();
    		 
    	}
    	
    	
    });
    
    $persorList.on("click", "span", function(event) {
        var _this = this,
            _checkbox = $(_this).children("input");
        
        /**
         * 文字添加选中checkbox功能
         */
        if(!$(event.target).is(_checkbox)) {
            if(_checkbox.prop("checked") === true) {
                _checkbox.prop("checked", false);
            } else {
                _checkbox.prop("checked", true);
            }
            
        }

        /**
         * [getCheckedNum 获取选中的个数]
         * @return {[type]} [返回个数]
         */
        function getCheckedNum() {
            var num = 0;
            $persorList.find("input").each(function() {
                if($(this).prop("checked") === true) {
                    num++;
                }
            });
            return num;
        }
        
        /**
         * 选中时设置添加的span熟悉index，用于取消选中删除
         */
        if(_checkbox.prop("checked") === true) {
            $("<span>" + $(_this).text() + "</span>").attr({"index":$(_this).index(),"value":$(_this).children(":first").val()}).appendTo($selResult);
        } else {
            $selResult.children("[index=" + $(_this).index() + "]").remove();
        }

        $selNum.html(getCheckedNum());
    });
}