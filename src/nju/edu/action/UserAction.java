package nju.edu.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import db.UserDB;
import model.User;

public class UserAction {
	private String result;
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		
		UserDB udb=new UserDB();
		User user=new User(username,username,password,role);
		boolean hasUser=false;
		try {
			hasUser=udb.checkPassword(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(hasUser){
			result="success";
		}else{
			result="failure";
		}
		System.out.println("login");
		return "login";
	}
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
