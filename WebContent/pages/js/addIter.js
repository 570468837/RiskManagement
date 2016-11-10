function initData(){
	var select_iter = document.getElementById('select_iter');
	for(var i=0; i<10;i++){
		select_iter.add(new Option("迭代"+(i+1),"迭代"+(i+1))); 
	}
}

function add(){
	$.ajax({
			type : "POST",
			url : "../json/iter_add.action",
			data : {
				iter : document.getElementById("select_iter").value
			},
			dataType : "json",
			success : function(data, status) {
				var result=data.result;
				if(result == "failure"){
					alert("添加失败，已经存在该迭代。");
				}
				else{
					//success
					alert("添加成功");
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