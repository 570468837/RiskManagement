function initData(){
	var iters = [
		{"content": "µü´ú1"},
		{"content": "µü´ú2"},
		{"content": "µü´ú3"}
	];
	var select_iter = document.getElementById('select_iter');
	for(var i=0; i<iters.length;i++){
		select_iter.add(new Option(iters[i].content,i)); 
	}
}