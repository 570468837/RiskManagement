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
				if (data.result == "fail")
					alert("订购失败");
				else {
					alert("订购成功");
				}
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
</script>
</head>
<body>
	<label>hello</label>
	<button onclick="fuck()">tony</button>
</body>
</html>