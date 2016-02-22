/**
 * 省份文案
 */
var CONFIG = {
    DESCRIBE: {
        GD: "什么离家近、经济发达都不是问题~<br>“什么都能吃”才是留在广东的主要原因~~",  // 广东
        BJ: "为了烤鸭！为了爆肚！为了炒肝！雾霾已经阻止不了我们对小吃的追求！不对，理想的追求！",  // 北京
        SH: "你猜，他们喜欢小四还是韩寒？",  // 上海
        ZJ: "过了20年什么都能吃的生活<br>他们要去体验什么钱都能赚的生活。",  // 浙江
        FJ: "他们其实是想去娶一个福建的妹子吧？",  // 福建
        JS: "过了20年什么都能吃的生活<br>他们要去体验什么钱都能赚的生活。",  // 江苏
        UB: "吃四年的热干面...一定很爽吧！",  // 湖北
        UN: "观众朋友们已经不记得湖南除了湖南卫视还有啥了。什么臭豆腐什么主席的家乡啊...",  // 湖南
        AH: "黄山的迎客松...应该是全国家庭中挂在客厅上仅少于毛主席画像的画了吧。",  // 安徽
        SX: "山西的煤老板现在也不好混啊，现在去会不会太晚了？",  // 山西
        AX: "肉夹馍~哟~凉皮~哟~臊子面~哟~羊肉泡馍~哟~",  // 陕西
        SD: "不用说，冲着青岛啤酒去的！",  // 山东
        GX: "桂林山水甲天下，未来四年就生活在桂林山水之间...想想就很爽吧",  // 广西  TODO API文档没有
        HN: "去海南上学，回来之后人就变成海鲜了吧。",  // 海南
        EN: "大中华的发源地，即使天天被黑，我们也爱它。",  // 河南
        JX: "赣鄱大地，是江南“鱼米之乡”，古有“吴头楚尾，粤户闽庭”之称",  // 江西
        TJ: "天子渡口。",  // 天津
        EB: "位于中国华北地区、河北东临渤海、内环京津。",  // 河北
        NM: "横贯东西...咦，在新疆旁边，也在东三省旁边...",  // 内蒙古
        NX: "那个...梁静茹不是宁夏人...<br>宁夏羊肉！好吃！",  // 宁夏  TODO API文档没有
        XJ: "新疆古称西域，自汉朝以来就是中国不可分割的一部分。",  // 新疆  TODO API文档没有
        XZ: "西藏是中国神圣领土不可分割的一部分，中央政权始终对西藏行使着有效管辖。藏族人民是中华民族大家庭中的重要一员。",  // 西藏  TODO API文档没有
        QH: "境内山脉高耸，地形多样，河流纵横，湖泊棋布。",  // 青海
        GS: "简称甘或陇，中国省级行政单位之一，位于黄河上游。",  // 甘肃
        SC: "蜀，天府之国！",  // 四川
        YN: "滇，人类文明重要发祥地之一",  // 云南
        CQ: "山城，一个神奇的城市！",  // 重庆
        LN: "中国重要的老工业基地，是全国工业门类较为齐全的省份之一",  // 辽宁
        JL: "早在远古时期，就有人类在吉林省这块土地上繁衍生息", // 吉林
        HL: "中国最东北部，中国国土的北端与东端均位于省境"  // 黑龙江
    }
};


$(function() {
	/**
     * 分享展开与合并
     * @type {*|jQuery|HTMLElement}
     */
    var $btnUnfoldShare = $("#btnUnfoldShare"),
        $btnFoldShare = $("#btnFoldShare"),
        $shareItem = $("#shareItem");

    $btnUnfoldShare.bind("click", function() {
        $(this).hide();
        $shareItem.show();
        window.scrollTo(0, document.documentElement.scrollHeight - document.documentElement.clientHeight);
    });

    $btnFoldShare.bind("click", function() {
        $shareItem.hide();
        $btnUnfoldShare.show();
    });
    
    var $distributionList = $("#distributionList"),
        $describe = $distributionList.find(".describe"),
        $chartInner = $distributionList.find(".meter-chart i");

    $describe.each(function(i, t) {
        $(t).html(CONFIG.DESCRIBE[$(t).attr("data-key")]);
    });

    function supportedStyle(arg, callback) {
        var prefix = ["webkit", "moz", "o", "ms"];

        var style = document.body.style;

        for(var i = -1; i < prefix.length; i++) {
            if(i < 0) {
                if(arg in style) {
                    return arg;
                }
            } else {
                if("-" + prefix[i] + "-" + arg in style) {
                    return "-" + prefix[i] + "-" + arg;
                }
            }
        }
        if(arguments.length > 1) {
            return callback();
        }
    }

    var supported = supportedStyle("transform", function() {
        return "right";
    });

    $chartInner.each(function(i, t) {
        if($(t).attr("data-width")) {
            if(supported === "right") {
                $(t).css("right", (100 - parseFloat($(t).attr("data-width").replace("%", ""))) + "%");
            } else {
                $(t).css(supported, "translateX(" + $(t).attr("data-width") + ")");
            }
        }
    });
});