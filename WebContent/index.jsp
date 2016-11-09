<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function fuck() {
		$.ajax({
			type : "POST",
			url : "json/ajax_fuck.action",
			data : {
				gjp : 123
			},
			dataType : "json",
			success : function(data, status) {
				var a=eval("(" + data.result + ")");
				alert(a.count);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
				alert(errorThrown);
				alert("网络繁忙，请稍后再试");
			}
		});
	}
	function list() {
		$.ajax({
			type : "POST",
			url : "json/ajax_list.action",
			data : {
				gjp : 123
			},
			dataType : "json",
			success : function(data, status) {
				var a=eval("(" + data.result + ")");
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
				alert("网络繁忙，请稍后再试");
			}
		});
	}
</script>
</head>
<body>
	<label>hello</label>
	<button onclick="fuck()">tony</button>
	<button onclick="list()">list</button>
</body>
</html>