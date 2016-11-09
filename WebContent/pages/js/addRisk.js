function initData(){
	var requirements = [
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
	];
	var select_requirement = document.getElementById('select_requirement');
	for(var i=0; i<requirements.length;i++){
		select_requirement.add(new Option(requirements[i].content,i)); 
	}
}

