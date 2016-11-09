package nju.edu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

public class RiskAction {
	private String result;
	public String tree() {
		Map<String,ArrayList<Map<String,Object>>> map=new HashMap<>();
		ArrayList<Map<String,Object>> list=new ArrayList<>();
		Map<String,Object> iter1 = new HashMap<>();
		iter1.put("text", "µü´ú1");
		Map<String,Object> iter2 = new HashMap<>();
		iter2.put("text", "µü´ú2");
		list.add(iter1);
		list.add(iter2);
		map.put("content", list);
		try {
			result=JSONUtil.serialize(map);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login";
	}
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
