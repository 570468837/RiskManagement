function initData(){
	/*var requirements = [
		{"content": "迭代1-登录界面"},
		{"content": "迭代1-首页"},
		{"content": "迭代1-个人中心"},
		{"content": "迭代1-商品详情页面"},
		{"content": "迭代2-支付页面"},
		{"content": "迭代2-物流选择页面"},
		{"content": "迭代2-合同打印"},
		{"content": "迭代3-个性化推荐页面"},
		{"content": "迭代3-购物车同步"},
		{"content": "迭代3-Mobile app开发"},
	]; */
	
	$.ajax({
			type : "POST",
			url : "../json/req_list.action",
			dataType : "json",
			success : function(data, status) {
				var requirements = JSON.parse(data.result);
				var select_requirement = document.getElementById('select_requirement');
				for(var i=0; i<requirements.length;i++){
					select_requirement.add(new Option(requirements[i].content,requirements[i].id)); 
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
				alert("网络繁忙，请稍后再试");
			}
		});
}

