package nju.edu.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import db.*;
import model.AllRisks;
import utils.JsonUtils;

public class RiskAction {
	private String result;
	public String tree() {
		RiskDB riskDB = new RiskDB();
		try {
			AllRisks risks=riskDB.getAllRisks();
			result=JsonUtils.toJSON(risks);
			System.out.println(result);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "tree";
	}
	
	public String status() {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		String id=request.getParameter("id");
		RiskStatusDB riskStatusDB = new RiskStatusDB();
		try {
			result=JsonUtils.toJSON(riskStatusDB.getRiskStatusByRisk(id));
			System.out.println(result);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "tree";
	}
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
