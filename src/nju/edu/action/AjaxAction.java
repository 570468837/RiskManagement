package nju.edu.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;




public class AjaxAction{
	private String result;
	
	public String fuck() {
		HttpServletRequest request = ServletActionContext.getRequest(); // 获取request
		HttpSession session = request.getSession();
		int gjp=Integer.parseInt(request.getParameter("gjp"));
		System.out.println(gjp);
		result="success";
		return "fuck";
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
