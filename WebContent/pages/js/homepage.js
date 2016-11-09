function initData(){
	var riskItem = {
		"riskid": "1.1.1",
		"content": "由于人手不够，所以可能无法deanline之前完成该项开发",
		"possibility": "high",
		"impact": "high",
		"trigger": "2016年12月1日",
		"subscriber": "郭建朋",
		"tracker": "郭建朋"
	}
	document.getElementById("item_content").innerText  =  riskItem.content ;
	document.getElementById("item_possibility").innerText  =  riskItem.possibility ;
	document.getElementById("item_impact").innerText  =  riskItem.impact ;
	document.getElementById("item_trigger").innerText  =  riskItem.trigger ;
	document.getElementById("item_subscriber").innerText  =  riskItem.subscriber ;
	document.getElementById("item_tracker").innerText  =  riskItem.tracker;

	var riskState= {
		"riskid": "1.1.1",
		"state": "依然存在，风险等级较高",
		"description": "人手不够，无法从其余组调人，开发时间比较紧张"
	}
	
	document.getElementById("state_state").value  =  riskState.state;
	document.getElementById("state_description").value  =  riskState.description;
	
	var addRisk = document.getElementById("addRisk");
	var addRequirement = document.getElementById("addRequirement");
	var addIter = document.getElementById("addIter");
	var url = window.location.search; //获取url中"?"符后的字串
	if (url.indexOf("?") != -1) {    //判断是否有参数
		var str = url.substr(1); //从第一个字符开始 因为第0个是?号 获取所有除问号的所有符串
		strs = str.split("=");   //用等号进行分隔 （因为知道只有一个参数 所以直接用等号进分隔 如果有多个参数 要用&号分隔 再用等号进行分隔）
		var role = strs[1];
		if(role != "projectleader"){
			addRisk.style.display="none";
			addRequirement.style.display="none";
			addIter.style.display="none";
		}
   }
   else{
		addRisk.style.display="none";
		addRequirement.style.display="none";
		addIter.style.display="none";
   }
}


function getTree() {
    /*var data = [
  {
    
    "nodes": [
      {
        "text": "登录界面",
        "nodes": [
          {
            "text": "1.1.1 风险1"
          },
          {
            "text": "1.1.2 风险2"
          }
        ]
      },
      {
        "text": "首页界面"
      }
    ],
	"text": "迭代1"
  },
  {
    "text": "迭代2"
  },
  {
    "text": "迭代3"
  },
  {
    "text": "迭代4"
  },
  {
    "text": "迭代5"
  }
];
    return data;*/
	

	
	var returnData;
	$.ajax({
			type : "POST",
			url : "../json/risk_tree.action",
			dataType : "json",
			success : function(data, status) {
				var result=JSON.parse(data.result);
				returnData = result;
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
				alert("网络繁忙，请稍后再试");
			}
		});
		return returnData;
		
}

function edit(){
	$("#state_state").attr("disabled",false);
	$("#state_description").attr("disabled",false);
	
	
	
}