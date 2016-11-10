function initData(){
	/*
	var iters = [
		{"id": "1", "name": "迭代1"},
		{"id": "2", "name": "迭代2"},
		{"id": "3", "name": "迭代3"}
	];
	*/
	$.ajax({
			type : "POST",
			url : "../json/iter_list.action",
			dataType : "json",
			success : function(data, status) {
				var iters=JSON.parse(data.result);
				var select_iter = document.getElementById('select_iter');
				for(var i=0; i<iters.length;i++){
					select_iter.add(new Option(iters[i].name,iters[i].id)); 
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

function add(){
	$.ajax({
			type : "POST",
			url : "../json/req_add.action",
			data : {
				iterid : risk_num_global,
				description : document.getElementById("requirement_description").value
			},
			dataType : "json",
			success : function(data, status) {
				var response = data.result;
				if(response == "success"){
					alert("提交成功");
				}
				else{
					alert("提交失败");
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