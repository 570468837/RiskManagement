function initData(){
	var riskItem = {
		"riskid": "1.1.1",
		"content": "�������ֲ��������Կ����޷�deanline֮ǰ��ɸ����",
		"possibility": "high",
		"impact": "high",
		"trigger": "2016��12��1��",
		"subscriber": "������",
		"tracker": "������"
	}
	document.getElementById("item_content").innerText  =  riskItem.content ;
	document.getElementById("item_possibility").innerText  =  riskItem.possibility ;
	document.getElementById("item_impact").innerText  =  riskItem.impact ;
	document.getElementById("item_trigger").innerText  =  riskItem.trigger ;
	document.getElementById("item_subscriber").innerText  =  riskItem.subscriber ;
	document.getElementById("item_tracker").innerText  =  riskItem.tracker;

	var riskState= {
		"riskid": "1.1.1",
		"state": "��Ȼ���ڣ����յȼ��ϸ�",
		"description": "���ֲ������޷�����������ˣ�����ʱ��ȽϽ���"
	}
	
	document.getElementById("state_state").value  =  riskState.state;
	document.getElementById("state_description").value  =  riskState.description;
}


function getTree() {
    var data = [
  {
    "text": "����1",
    "nodes": [
      {
        "text": "��¼����",
        "nodes": [
          {
            "text": "1.1.1 ����1"
          },
          {
            "text": "1.1.2 ����2"
          }
        ]
      },
      {
        "text": "��ҳ����"
      }
    ]
  },
  {
    "text": "����2"
  },
  {
    "text": "����3"
  },
  {
    "text": "����4"
  },
  {
    "text": "����5"
  }
];
    return data;
}

function edit(){
	$("#state_state").attr("disabled",false);
	$("#state_description").attr("disabled",false);
	
	
	
}