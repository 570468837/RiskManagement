package nju.edu.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;



public class AjaxAction extends ActionSupport{
	String result;
	public String fuck() {
		HttpServletRequest request = ServletActionContext.getRequest(); // 获取request
		HttpSession session = request.getSession();
		System.out.println("baby");
		int gjp=Integer.parseInt(request.getParameter("gjp"));
		result="success";
		return "ajax";
	}
}
