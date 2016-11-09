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
}


function getTree() {
    var data = [
  {
    "text": "迭代1",
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
    ]
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
    return data;
}

function edit(){
	$("#state_state").attr("disabled",false);
	$("#state_description").attr("disabled",false);
	
	
	
}