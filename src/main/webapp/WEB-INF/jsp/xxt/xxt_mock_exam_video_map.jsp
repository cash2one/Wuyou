<%@ page pageEncoding="UTF-8"%>
<%
	//http://p.bokecc.com/player?siteid=440D049584AEB42E&autoStart=false&width=600&height=490&playerid=D30050EE4A19E1BF&playertype=1
	Map videoMap = new HashMap();
	//dili（地理）
	videoMap.put("dili-1", "9db4ad2a0d4ddef076b8a4715a0aec7b_9");
	videoMap.put("dili-2", "9db4ad2a0d1e4ecd9d4623e91c31a334_9");
	videoMap.put("dili-3", "9db4ad2a0d43ba9c0e427a6ff26ec445_9");
	videoMap.put("dili-4", "9db4ad2a0d81d6652b125482cb01ce91_9");
	videoMap.put("dili-5", "9db4ad2a0dd840fc3f0c3f80f70b671a_9");
	videoMap.put("dili-6", "9db4ad2a0dc367b1deac1b64f5e413de_9");
	videoMap.put("dili-8", "9db4ad2a0d3ba0a3a35257e425ee7a26_9");
	videoMap.put("dili-9", "9db4ad2a0d5b3d18972dbad832c15f6b_9");
	videoMap.put("dili-10","9db4ad2a0d8f7627a917f9903d453294_9");
	videoMap.put("dili-11","9db4ad2a0df4ebb826274735bea8ca2c_9");
	videoMap.put("dili-44","9db4ad2a0d7b2b8f8aa65b6e7d7c4012_9");
	videoMap.put("dili-48","9db4ad2a0d43e29048d60665a1e4cb9d_9");
	
	//huaxue（化学）
	videoMap.put("huaxue-7","9db4ad2a0dbf551a367764dafc0f0132_9");
	videoMap.put("huaxue-8","9db4ad2a0d039a26ec15fcc613c8629a_9");
	videoMap.put("huaxue-9","9db4ad2a0d4aaf0fc3b8c41b78f4066f_9");
	videoMap.put("huaxue-10","9db4ad2a0dc7f91a9f12b89919921b4d_9");
	videoMap.put("huaxue-11","9db4ad2a0d0ffe40c4df06e3fcccd575_9");
	videoMap.put("huaxue-12","9db4ad2a0dc9eddda0a95fca7aec3e32_9");
	videoMap.put("huaxue-22","9db4ad2a0d37d7471757e0040a142512_9");
	videoMap.put("huaxue-23","9db4ad2a0d86a48923ce76798d9262b0_9");
	videoMap.put("huaxue-30","9db4ad2a0dd54e8a34687933a097125e_9");
	videoMap.put("huaxue-31","9db4ad2a0df5d5bf2a40a2109e5e1523_9");
	videoMap.put("huaxue-32","9db4ad2a0d8bb23c5557e99b1b2056f9_9");
	videoMap.put("huaxue-33","9db4ad2a0d7fc76bb9822c2f3e27f177_9");

	
	//lishi(历史)
	videoMap.put("lishi-12","9db4ad2a0d90cacb67c836ce8a35f259_9");
	videoMap.put("lishi-13","9db4ad2a0dd5992054738930edd8231f_9");
	videoMap.put("lishi-14","9db4ad2a0d712d8cf53a67fe3005bdb9_9");
	videoMap.put("lishi-15","9db4ad2a0d561da0ec8650317b6ccee2_9");
	videoMap.put("lishi-16","9db4ad2a0d828bac0f9e47c7bbba024c_9");
	videoMap.put("lishi-17","9db4ad2a0d50b6337602c14970f6b3b3_9");
	videoMap.put("lishi-18","9db4ad2a0debc6179bd686657d6a33a8_9");
	videoMap.put("lishi-19","9db4ad2a0dacda29016d2544d76b8389_9");
	videoMap.put("lishi-20","9db4ad2a0df22bb9380ffc42423fcaf0_9");
	videoMap.put("lishi-21","9db4ad2a0db5823d0b56a60f6ac4478d_9");
	videoMap.put("lishi-22","9db4ad2a0dfc0ba2319949f55baa4d45_9");
	videoMap.put("lishi-23","9db4ad2a0da002062c6f55c993e27845_9");
	videoMap.put("lishi-41","9db4ad2a0dae725c8a5c3f4e25c97622_9");
	videoMap.put("lishi-45","9db4ad2a0d6ed29ff56bf867c716c2ba_9");

	
	//lishu(理数)
	videoMap.put("lishu-1", "9db4ad2a0d784cf80f20a517035bc4a8_9");
	videoMap.put("lishu-2", "9db4ad2a0d0aa7d858ca5f588f1b35b1_9");
	videoMap.put("lishu-3", "9db4ad2a0d8794a6c7200ac24b52318a_9");
	videoMap.put("lishu-4", "9db4ad2a0dbc52f50ddaeb8e884fbbbb_9");
	videoMap.put("lishu-5", "9db4ad2a0d410ce949da1f02531a3646_9");
	videoMap.put("lishu-6", "9db4ad2a0dd96162666d438c1ee24121_9");
	videoMap.put("lishu-7", "9db4ad2a0d28422466353cbf5b4b7107_9");
	videoMap.put("lishu-8", "9db4ad2a0d9de83d35c8e1d0b213df1f_9");
	videoMap.put("lishu-9", "9db4ad2a0dbdeb6517388f4718962d41_9");
	videoMap.put("lishu-10", "9db4ad2a0d379665fc8cb958802fe819_9");
	videoMap.put("lishu-11", "9db4ad2a0d6c278736d78f423d5da8ab_9");
	videoMap.put("lishu-12", "9db4ad2a0dc954ae761aa505a61a6f11_9");
	videoMap.put("lishu-13", "9db4ad2a0dae33496a9faad36a894d3d_9");
	videoMap.put("lishu-14", "9db4ad2a0d17ccb618157850069b92c0_9");
	videoMap.put("lishu-15", "9db4ad2a0d156fe1cfa9e792d570b4c7_9");
	videoMap.put("lishu-16", "9db4ad2a0d0f691fb74e00ebfeec9f16_9");
	videoMap.put("lishu-17", "9db4ad2a0d6d8f67e852ddc9d085b92d_9");
	videoMap.put("lishu-18", "9db4ad2a0d9e55c4f63d1651e4212013_9");
	videoMap.put("lishu-19", "9db4ad2a0dcf5002da90de0b600755b6_9");
	videoMap.put("lishu-20", "9db4ad2a0dfb0a187fa1ca762730fb4d_9");
	videoMap.put("lishu-21", "9db4ad2a0d3fa5888af8c997568bdb1e_9");
	
	//shengwu(生物)
	videoMap.put("shengwu-1", "9db4ad2a0dc1140e79c6abfc13ad9f59_9");
	videoMap.put("shengwu-2", "9db4ad2a0d35697c53d50fa2e55c5d49_9");
	videoMap.put("shengwu-3", "9db4ad2a0d8d2bdb023e2ba7c84cacd3_9");
	videoMap.put("shengwu-4", "9db4ad2a0de602fd4282cd73155df6f1_9");
	videoMap.put("shengwu-5", "9db4ad2a0d649afb78894e8615cd9e5e_9");
	videoMap.put("shengwu-6", "9db4ad2a0d66f08c765ac1e837645f95_9");
	videoMap.put("shengwu-24","9db4ad2a0dc666675459a2364562eb74_9");
	videoMap.put("shengwu-25","9db4ad2a0dad53c04130a5fbe4bceed4_9");
	videoMap.put("shengwu-26","9db4ad2a0d06575e15c2ddfa64e11afd_9");
	videoMap.put("shengwu-27","9db4ad2a0dd3aa8877253f1471993b92_9");
	videoMap.put("shengwu-28","9db4ad2a0dee8c8ac25dfe79390ce597_9");
	videoMap.put("shengwu-29","9db4ad2a0d50fcf69c7183df5cecbbd1_9");
	
	//wenshu(文数)
	videoMap.put("wenshu-1", "9db4ad2a0dab8180098f62d73747b27d_9");
	videoMap.put("wenshu-2", "9db4ad2a0dc2634487c6b5fde19b2573_9");
	videoMap.put("wenshu-3", "9db4ad2a0daff0de762f7cebf52b9024_9");
	videoMap.put("wenshu-4", "9db4ad2a0db5f040d40681d1f052e24d_9");
	videoMap.put("wenshu-5", "9db4ad2a0db0bd658abde74d672eee13_9");
	videoMap.put("wenshu-6", "9db4ad2a0dc07250009681f8b5972741_9");
	videoMap.put("wenshu-7", "9db4ad2a0d4b1f3f022803ec432475d4_9");
	videoMap.put("wenshu-8", "9db4ad2a0d19b69a235fbfe4b9310929_9");
	videoMap.put("wenshu-9", "9db4ad2a0d892e49121d54b183511434_9");
	videoMap.put("wenshu-10", "9db4ad2a0d1b4383c4af0cdb536905d5_9");
	videoMap.put("wenshu-11", "9db4ad2a0d7cd3da8ae81f4bcfcaed27_9");
	videoMap.put("wenshu-12", "9db4ad2a0d6b1f7e06b6a1ffc5c75427_9");
	videoMap.put("wenshu-13", "9db4ad2a0da1df417176e91480cdc3c1_9");
	videoMap.put("wenshu-14", "9db4ad2a0d6920bab456b9618f46460f_9");
	videoMap.put("wenshu-15", "9db4ad2a0d03a0ae15f443889ee1271c_9");
	videoMap.put("wenshu-16", "9db4ad2a0d06864d352ad43e3baded2c_9");
	videoMap.put("wenshu-17", "9db4ad2a0d5eff9f7bb08b1abcc39688_9");
	videoMap.put("wenshu-18", "9db4ad2a0dd8fbbe0a757c8c32a590ac_9");
	videoMap.put("wenshu-19", "9db4ad2a0d87bb20ae1d9648fbaff0fb_9");
	videoMap.put("wenshu-20", "9db4ad2a0d8d79e8e298f5b74ed10724_9");
	videoMap.put("wenshu-21", "9db4ad2a0dbcacc4daaefb4d93236c6b_9");
	
	//wuli(物理)
	videoMap.put("wuli-13","9db4ad2a0df922e649dc1c28aecff363_9");
	videoMap.put("wuli-14","9db4ad2a0dfc111dddbab59991f194fc_9");
	videoMap.put("wuli-15","9db4ad2a0d948b931004a762d06c6bef_9");
	videoMap.put("wuli-16","9db4ad2a0d0789307b89f0078b113fce_9");
	videoMap.put("wuli-17","9db4ad2a0d3c63bdf66d02fa5fb772dc_9");
	videoMap.put("wuli-18","9db4ad2a0d10eab9036fbaf82d2f05e3_9");
	videoMap.put("wuli-19","9db4ad2a0d09a79cea4ff6bc28a7ffc8_9");
	videoMap.put("wuli-20","9db4ad2a0d89a75c6f64d3800eaee279_9");
	videoMap.put("wuli-21","9db4ad2a0d0b7df266f0eb4096fc5052_9");
	videoMap.put("wuli-35","9db4ad2a0da71282e0998e3a7924435a_9");
	videoMap.put("wuli-36","9db4ad2a0d4282e6ab1c76bf4d9e28d0_9");
	videoMap.put("wuli-37","9db4ad2a0d504948e41433ff542bf95f_9");
	
	//yingyu(英语)
	videoMap.put("yingyu-1", "9db4ad2a0d5d4a479c322545c528e259_9");
	videoMap.put("yingyu-2", "9db4ad2a0dbef322ad36b3368fcd678e_9");
	videoMap.put("yingyu-3", "9db4ad2a0d2222b50a794bb527719304_9");
	videoMap.put("yingyu-4", "9db4ad2a0dcf898d098ea30645107f43_9");
	videoMap.put("yingyu-5", "9db4ad2a0df9baa998e974e657e15641_9");
	videoMap.put("yingyu-6", "9db4ad2a0db7a73c66286d09a7e2bc91_9");
	videoMap.put("yingyu-7", "9db4ad2a0d37478be4a061072ab29565_9");
	videoMap.put("yingyu-8", "9db4ad2a0dbad862557818cb69136e18_9");
	videoMap.put("yingyu-9", "9db4ad2a0d28ffd3aa529aee07aa1b72_9");
	videoMap.put("yingyu-14","9db4ad2a0dcb1fb8af9df47cbcdb9dd2_9");
	videoMap.put("yingyu-19","9db4ad2a0dd593cdc8adbe74c7b54db6_9");
	videoMap.put("yingyu-24","9db4ad2a0dfbf1e0f31ec84192d7d986_9");
	videoMap.put("yingyu-29","9db4ad2a0d5113fa36806e44cdba8db2_9");
	videoMap.put("yingyu-30","9db4ad2a0da77bc2cc7ea551b7d1c750_9");
	videoMap.put("yingyu-31","9db4ad2a0d46c13caa9b6e49cdcdd5d9_9");
	videoMap.put("yingyu-32","9db4ad2a0da8b9062f1c802020af7b40_9");
	videoMap.put("yingyu-33","9db4ad2a0d13298c94a32ce09433826b_9");
	videoMap.put("yingyu-34","9db4ad2a0d732983ae376cd1fa6f55e0_9");
	videoMap.put("yingyu-35","9db4ad2a0d9e70a14cf9172e313d9b45_9");
	videoMap.put("yingyu-36","9db4ad2a0d2d05e3ca8ccf779a2b862a_9");
	
	//yuwen(语文)
	videoMap.put("yuwen-1", "9db4ad2a0d69072fc42c8b61cea0f3f5_9");
	videoMap.put("yuwen-2", "9db4ad2a0d8261dd3a244706dc4bd1c6_9");
	videoMap.put("yuwen-3", "9db4ad2a0dfb35cf27716d59aa5a9359_9");
	videoMap.put("yuwen-4", "9db4ad2a0d5a6d53ca48529baa7599fd_9");
	videoMap.put("yuwen-5", "9db4ad2a0d67dc3b89158fcbc312be61_9");
	videoMap.put("yuwen-6", "9db4ad2a0d79aaa1cbd3458afa5b2e6c_9");
	videoMap.put("yuwen-7", "9db4ad2a0db8d540d3022f7b65a81a79_9");
	videoMap.put("yuwen-8", "9db4ad2a0db89bff86d664fd693e2073_9");
	videoMap.put("yuwen-9", "9db4ad2a0de826d45ae93d9f1a610870_9");
	videoMap.put("yuwen-10", "9db4ad2a0d6f57b9d2dd8743f1c47b12_9");
	videoMap.put("yuwen-11", "9db4ad2a0d0072072da0518cf12a1ec6_9");
	videoMap.put("yuwen-13", "9db4ad2a0d8d2f06232ac4396c0a8184_9");
	videoMap.put("yuwen-12", "9db4ad2a0d41d26e1e00a3a99d43fbae_9");
	videoMap.put("yuwen-14", "9db4ad2a0d059a149a82bdb0ab03ae25_9");
	videoMap.put("yuwen-15", "9db4ad2a0dc19f983128916bb18bf902_9");
	videoMap.put("yuwen-16", "9db4ad2a0d63fb22a951c5b2149912eb_9");
	videoMap.put("yuwen-17", "9db4ad2a0d237a2e2b0d067f89ff6ab3_9");
	videoMap.put("yuwen-18", "9db4ad2a0d3df57a74936a08179387a6_9");
	videoMap.put("yuwen-19", "9db4ad2a0ddaf9aef13bcaac16dd6f00_9");
	videoMap.put("yuwen-20", "9db4ad2a0d749a1532f3ce9b900e0bf5_9");
	videoMap.put("yuwen-21", "9db4ad2a0d9cbfd23ccc18b0c1257995_9");
	videoMap.put("yuwen-22", "9db4ad2a0da31432f650de2f63362a38_9");
	videoMap.put("yuwen-24", "9db4ad2a0d5ccc3b6ac683efa3efc805_9");
	videoMap.put("yuwen-23", "9db4ad2a0dc31d32cf10999071669fe1_9");

	
	//zhengzhi(政治)
	videoMap.put("zhengzhi-24","9db4ad2a0da398385c250c32bb75d324_9");
	videoMap.put("zhengzhi-25","9db4ad2a0d894865685f78eac378edc1_9");
	videoMap.put("zhengzhi-26","9db4ad2a0dabcd8a7266e0c577e33030_9");
	videoMap.put("zhengzhi-27","9db4ad2a0d2671133891611f41138f6c_9");
	videoMap.put("zhengzhi-28","9db4ad2a0dc36c10594d6bd01c44fd08_9");
	videoMap.put("zhengzhi-29","9db4ad2a0d9d109ca3a28e42e1080c66_9");
	videoMap.put("zhengzhi-30","9db4ad2a0d5f516dcb140f5d10b058d6_9");
	videoMap.put("zhengzhi-31","9db4ad2a0dae6269586c4ad6ff413586_9");
	videoMap.put("zhengzhi-32","9db4ad2a0d532ee6ce1c5bad9d22caae_9");
	videoMap.put("zhengzhi-33","9db4ad2a0d510b7daab1502c68b3b4b6_9");
	videoMap.put("zhengzhi-34","9db4ad2a0d10843015ef0f18846ce645_9");
	videoMap.put("zhengzhi-35","9db4ad2a0d0c30c0056bfb5f421656d7_9");
	videoMap.put("zhengzhi-36","9db4ad2a0d55cf6d9d49ccafc7d26ebf_9");
	videoMap.put("zhengzhi-37","9db4ad2a0d2a33b9925c32545a2abdc8_9");
	
	request.setAttribute("videoMap", videoMap);
	request.setAttribute("isIE", request.getHeader("User-Agent").contains("MSIE"));
%>

<c:set var="videoHeight" value="${isIE ? '490' : '' }"></c:set>
<c:set var="baseVideoUrl" value="http://p.bokecc.com/player?siteid=440D049584AEB42E&autoStart=true&width=100%&height=${videoHeight }&playerid=D30050EE4A19E1BF&playertype=1"></c:set>
<c:choose>
	<c:when test="${subject == 'dili'}">
		<c:set var="subjectName">地理&nbsp;&nbsp;华师附中老师&nbsp;&nbsp;刘玉涵</c:set>
		<c:set var="contentEnd">48</c:set>
		<c:set var="excludeStart">12</c:set>
		<c:set var="excludeEnd">39</c:set>
	</c:when>
	<c:when test="${subject == 'huaxue'}">
		<c:set var="subjectName">化学&nbsp;&nbsp;华师附中老师&nbsp;&nbsp;龚德昌</c:set>
		<c:set var="contentStart">7</c:set>
		<c:set var="contentEnd">33</c:set>
		<c:set var="excludeStart">13</c:set>
		<c:set var="excludeEnd">21</c:set>
		<c:set var="exclude">{24}{25}{26}{27}{28}{29}</c:set>
	</c:when>
	<c:when test="${subject == 'lishi'}">
		<c:set var="subjectName">历史&nbsp;&nbsp;华师附中老师&nbsp;&nbsp;黄永友</c:set>
		<c:set var="contentStart">12</c:set>
		<c:set var="contentEnd">45</c:set>
		<c:set var="excludeStart">24</c:set>
		<c:set var="excludeEnd">37</c:set>
	</c:when>
	<c:when test="${subject == 'lishu'}">
		<c:set var="subjectName">理数&nbsp;&nbsp;华师附中老师&nbsp;&nbsp;刘景亮</c:set>
		<c:set var="contentEnd">21</c:set>
	</c:when>
	<c:when test="${subject == 'shengwu'}">
		<c:set var="subjectName">生物&nbsp;&nbsp;华师附中老师&nbsp;&nbsp;贺建</c:set>
		<c:set var="contentStart">1</c:set>
		<c:set var="contentEnd">29</c:set>
		<c:set var="excludeStart">7</c:set>
		<c:set var="excludeEnd">23</c:set>
	</c:when>
	<c:when test="${subject == 'wenshu'}">
		<c:set var="subjectName">文数&nbsp;&nbsp;华师附中老师&nbsp;&nbsp;桂鹏</c:set>
		<c:set var="contentEnd">21</c:set>
	</c:when>
	<c:when test="${subject == 'wuli'}">
		<c:set var="subjectName">物理&nbsp;&nbsp;华师附中老师&nbsp;&nbsp;赵建辉</c:set>
		<c:set var="contentStart">13</c:set>
		<c:set var="contentEnd">37</c:set>
		<c:set var="excludeStart">22</c:set>
		<c:set var="excludeEnd">33</c:set>
	</c:when>
	<c:when test="${subject == 'yingyu'}">
		<c:set var="subjectName">英语&nbsp;&nbsp;广雅中学老师&nbsp;&nbsp;温东瑜</c:set>
		<c:set var="contentEnd">36</c:set>
	</c:when>
	<c:when test="${subject == 'yuwen'}">
		<c:set var="subjectName">语文&nbsp;&nbsp;华师附中老师&nbsp;&nbsp;张诚</c:set>
		<c:set var="contentEnd">24</c:set>
	</c:when>
	<c:when test="${subject == 'zhengzhi'}">
		<c:set var="subjectName">政治&nbsp;&nbsp;华师附中老师&nbsp;&nbsp;戚正东</c:set>
		<c:set var="contentStart">24</c:set>
		<c:set var="contentEnd">37</c:set>
	</c:when>
</c:choose>
