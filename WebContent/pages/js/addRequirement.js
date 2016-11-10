function initData(){
	var iters = [
		{"id": "1", "name": "迭代1"},
		{"id": "2", "name": "迭代2"},
		{"id": "3", "name": "迭代3"}
	];
	var select_iter = document.getElementById('select_iter');
	for(var i=0; i<iters.length;i++){
		select_iter.add(new Option(iters[i].name,iters[i].id)); 
	}
	
}

function add(){
	
}