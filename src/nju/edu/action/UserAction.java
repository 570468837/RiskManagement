package nju.edu.action;

import javax.servlet.http.HttpServletRequest;

public class UserAction {
	private String result;
	public String login() {
		result="projectleader";
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
