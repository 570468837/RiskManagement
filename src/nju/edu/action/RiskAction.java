package nju.edu.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.json.JSONObject;

import db.*;
import model.AllRisks;
import model.RiskStatus;
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
			List<RiskStatus> statusList=riskStatusDB.getRiskStatusByYaoId(id);
			if(statusList.size()>0){
				RiskStatus status=riskStatusDB.getRiskStatusByYaoId(id).get(0);
				result=JsonUtils.toJSON(status).toString();
			}else{
				JSONObject obj = new JSONObject();
				obj.put("state", "");
				obj.put("description", "");
				result=obj.toString();
			}
			System.out.println(result);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "status";
	}
	
	public String entry() {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		String id=request.getParameter("id");
		RiskDB riskDB = new RiskDB();
		try {
			result=JsonUtils.toJSON(riskDB.getRiskByYaoId(id)).toString();
			System.out.println(result);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "entry";
	}
	
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		String id=request.getParameter("id");
		String state=request.getParameter("status");
		String description=request.getParameter("status");
		RiskStatus status=new RiskStatus(null,state,description,id,null,null);
		RiskStatusDB riskStatusDB = new RiskStatusDB();
		try {
			riskStatusDB.updateRiskStatus(status);
			System.out.println("update status");
			result="success";
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			result="failure";
		}
		return "status";
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
