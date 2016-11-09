function initData(){
	var iters = [
		{"content": "迭代1"},
		{"content": "迭代2"},
		{"content": "迭代3"}
	];
	var select_iter = document.getElementById('select_iter');
	for(var i=0; i<iters.length;i++){
		select_iter.add(new Option(iters[i].content,i)); 
	}
}