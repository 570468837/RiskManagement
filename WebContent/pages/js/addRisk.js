function initData(){
	var requirements = [
		{"content": "����1-��¼����"},
		{"content": "����1-��ҳ"},
		{"content": "����1-��������"},
		{"content": "����1-��Ʒ����ҳ��"},
		{"content": "����2-֧��ҳ��"},
		{"content": "����2-����ѡ��ҳ��"},
		{"content": "����2-��ͬ��ӡ"},
		{"content": "����3-���Ի��Ƽ�ҳ��"},
		{"content": "����3-���ﳵͬ��"},
		{"content": "����3-Mobile app����"},
	];
	var select_requirement = document.getElementById('select_requirement');
	for(var i=0; i<requirements.length;i++){
		select_requirement.add(new Option(requirements[i].content,i)); 
	}
}

