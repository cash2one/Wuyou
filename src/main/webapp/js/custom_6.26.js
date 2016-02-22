/**
 * Created by Wangcy on 2014/6/12.
 */

(function(w, d) {
    $("#pcHref").bind("click", function() {
        window.location.href = $(this).text();
    });

    $(".click-open").bind("click", function() {
        window.location.href = $(this).attr("data-src");
    });
    
    var $btnUnfoldShare = $("#btnUnfoldShare"),
        $btnFoldShare = $("#btnFoldShare"),
        $shareItem = $("#shareItem");

    $btnUnfoldShare.bind("click", function() {
        $(this).hide();
        $shareItem.show();
        w.scrollTo(0, d.documentElement.scrollHeight - d.documentElement.clientHeight);
    });

    $btnFoldShare.bind("click", function() {
        $shareItem.hide();
        $btnUnfoldShare.show();
    });

    var $btnAppointment = $("#btnAppointment"),
        $overlay = $("#overlay"),
        $msgbox = $("#msgbox"),
        $userPhone = $("#userPhone"),
        $userPhoneValid = $("#userPhoneValid"),
        $btnSubmit = $("#btnSubmit"),
        $btnCancel = $("#btnCancel"),
        $btnHidebox = $("#btnHidebox"),
        $verify = $("#msgbox .verify"),
        $loading = $("#msgbox .loading"),
        $result = $("#msgbox .result"),
        $resultSuccess = $result.children(".success"),
        $resultFail = $result.children(".fail"),
        $resultFailTitle = $resultFail.children(".title"),
        $userAccount = $("#userAccount"),
        $userPwd = $("#userPwd"),
        $btnHidebox = $("#btnHidebox");

    function showMsg() {
        $overlay.show();
        $msgbox.show();
        $msgbox.css("margin-top", -$msgbox.height()/2);
    }

    function hideMsg() {
        $overlay.hide();
        $msgbox.hide();
    }

//    function book(){
//        $userPhoneValid.html("");
//
//        var resouce = {
//            phone: $userPhone.val()
//        };
//
//        var mobile = $("#userPhone").val();
//
//        if(!/^1[0-9]{10}$/.test(mobile)){
//            $userPhoneValid.html("输入号码格式错误");
//        }else{
//            $verify.hide();
//            $loading.show();
//            $.ajax({
//                type: "POST",
//                url: "xxtM/book.do",
//                data: eval(resouce),
//                dataType: "json",
//                success: function(obj){
//                    $loading.hide();
//                    $result.show();
//                    if(obj.motivation_status === "OK"){
//                        $userAccount.html(obj.u_username);
//                        $userPwd.html(obj.u_pwd);
//                        $resultFail.hide();
//                        $resultSuccess.show();
//                        $msgbox.css("margin-top", -$msgbox.height()/2);
//                    } else if(obj.motivation_status === "HAVED_BOOKING") {
//                        $resultSuccess.hide();
//                        $resultFail.show();
//                        $resultFailTitle.html("您已经预约过了");
//                        $msgbox.css("margin-top", -$msgbox.height()/2);
//                    } else {
//                        $resultSuccess.hide();
//                        $resultFail.show();
//                        $resultFailTitle.html("预约失败，请检查您的手机号码重试");
//                        $msgbox.css("margin-top", -$msgbox.height()/2);
//                    }
//                }
//            });
//        }
//    };
//
//    
//    function book1(){
//        $userPhoneValid.html("");
//
//        var resouce = {
//            phone: $userPhone.val(),
//            idType: $("#idtype").val()
//        };
//
//        var mobile = $("#userPhone").val();
//
//        if(!/^1[0-9]{10}$/.test(mobile)){
//            $userPhoneValid.html("输入号码格式错误");
//        }else{
//            $verify.hide();
//            $loading.show();
//            $.ajax({
//                type: "POST",
//                url: "xxtM/book1.do",
//                data: eval(resouce),
//                dataType: "json",
//                success: function(obj){
//                    $loading.hide();
//                    $result.show();
//                    if(obj.motivation_status === "OK"){
//                        $userAccount.html(obj.u_username);
//                        $userPwd.html(obj.u_pwd);
//                        $resultFail.hide();
//                        $resultSuccess.show();
//                        $msgbox.css("margin-top", -$msgbox.height()/2);
//                    } else if(obj.motivation_status === "HAVED_BOOKING") {
//                        $resultSuccess.hide();
//                        $resultFail.show();
//                        $resultFailTitle.html("您已经预约过了");
//                        $msgbox.css("margin-top", -$msgbox.height()/2);
//                    } else {
//                        $resultSuccess.hide();
//                        $resultFail.show();
//                        $resultFailTitle.html("预约失败，请检查您的手机号码重试");
//                        $msgbox.css("margin-top", -$msgbox.height()/2);
//                    }
//                }
//            });
//        }
//    };
    
    

    $btnAppointment.bind("click", function() {
        $verify.hide();
        $loading.hide();
        $result.show();
        $resultSuccess.show();
        showMsg();
    });

//    $btnSubmit.bind("click", function() {
//        book1();
//    });

//    $btnCancel.bind("click", function() {
//        hideMsg();
//    });

    $btnHidebox.bind("click", function() {
        hideMsg();
    });

}(window, document));