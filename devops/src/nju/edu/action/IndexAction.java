package nju.edu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import nju.edu.service.IndexService;

public class IndexAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		IndexService is=new IndexService();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("fuck", is.getIndex());
		return "success";
	}
}
