package nju.edu.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import com.opensymphony.xwork2.ActionSupport;




public class AjaxAction{
	private String result;
	
	public String fuck() {
		HttpServletRequest request = ServletActionContext.getRequest(); // 获取request
		HttpSession session = request.getSession();
		int gjp=Integer.parseInt(request.getParameter("gjp"));
		
		result="success";
		Map<String,Object> statsMap = new HashMap<>();
		statsMap.put("count",1);
		statsMap.put("pass", 2);
		statsMap.put("fail", 3);
		statsMap.put("Models",4);
		statsMap.put("OS", 5);
		statsMap.put("mobileList", 6);
		
		try {
			result=JSONUtil.serialize(statsMap);
			System.out.println(result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fuck";
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
