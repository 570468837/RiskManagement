function initData(){
	var iters = [
		{"content": "����1"},
		{"content": "����2"},
		{"content": "����3"}
	];
	var select_iter = document.getElementById('select_iter');
	for(var i=0; i<iters.length;i++){
		select_iter.add(new Option(iters[i].content,i)); 
	}
}