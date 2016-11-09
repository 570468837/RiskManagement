function initData(){
	var select_iter = document.getElementById('select_iter');
	for(var i=0; i<6;i++){
		select_iter.add(new Option("µü´ú"+(i+1),i)); 
	}
}