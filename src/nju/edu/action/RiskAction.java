package nju.edu.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "tree";
	}
	
	public String status() {
		RiskStatusDB riskStatusDB = new RiskStatusDB();
		
		try {
			
			result=JsonUtils.toJSON(risks);
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
