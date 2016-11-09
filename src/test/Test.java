package test;



import java.sql.SQLException;
import java.util.List;

import db.*;
import model.*;
import utils.JsonUtils;
import utils.TimeUtils;


public class Test {
	
	static UserDB userdb = new UserDB();
	static ProjectDB projectdb = new ProjectDB();
	static RequirementDB reqdb = new RequirementDB();
	static RiskDB riskdb = new RiskDB();
	static RiskStatusDB statusdb = new RiskStatusDB();
	
	static void insertData() throws SQLException {
		
		
		User user = new User(null, "xukelei", "123123", "admin");
		userdb.insertAccount(user);
		System.out.println(userdb.checkPassword(user));
		
		
		
		Project project = new Project(null, "iteration1", "xiedai1", "1");
		System.out.println(JsonUtils.toJSON(project));
		projectdb.insertProject(project);
		
		
		
		Requirement req = new Requirement(null, "UI", "user interface", "1");
		System.out.println(JsonUtils.toJSON(req));
		reqdb.insertRequirement(req);
		
		
		
		Risk risk = new Risk(null, "risk1", "riskcontent", "high", "high", "threshold", "1", "1", "1");
		System.out.println(JsonUtils.toJSON(risk));
		riskdb.insertRisk(risk);
		
		
		
		RiskStatus status = new RiskStatus(null, "cannot complete", "not enough people", "1", TimeUtils.now(), "1");
		System.out.println(JsonUtils.toJSON(status));
		statusdb.insertRiskStatus(status);
		
		
		projectdb.insertProject(new Project(null, "迭代2", "描述2", "1"));
		projectdb.insertProject(new Project(null, "迭代3", "描述3", "1"));
		projectdb.insertProject(new Project(null, "迭代4", "描述4", "1"));
		
		reqdb.insertRequirement(new Requirement(null, "界面", "完成界面设计", "2"));
		reqdb.insertRequirement(new Requirement(null, "db", "use mysql", "2"));
		
		riskdb.insertRisk(new Risk(null, "超时", "人数不够", "high", "high", "2016-11-09", "1", "1", "2"));
		riskdb.insertRisk(new Risk(null, "太丑", "界面不好看", "high", "high", "2016-11-09", "1", "1", "2"));
	}
	
	static void query() throws SQLException {
		/*
		Project p = projectdb.getProjectById("1");
		System.out.println(JsonUtils.toJSON(p));
		*/
		
		/*
		List<Requirement> reqs = reqdb.getRequirementByProject("1");
		for(Requirement r: reqs) {
			System.out.println(JsonUtils.toJSON(r));
		}
		*/
		
		/*
		List<Risk> risks = riskdb.getRiskByRequirement("1");
		for(Risk r: risks) {
			System.out.println(JsonUtils.toJSON(r));
		}
		*/
		
		/*
		List<RiskStatus> statuses = statusdb.getRiskStatusByRisk("1");
		for(RiskStatus s: statuses) {
			System.out.println(JsonUtils.toJSON(s));
		}
		*/
		
		AllRisks risks = riskdb.getAllRisks();
		System.out.println(JsonUtils.toJSON(risks));
	}
	
	static void update() throws SQLException {
		riskdb.updateRisk(new Risk("1", "updateName", "updateContent", "highhigh", "lowlow", "no", "999", "1", "999"));
	}

	public static void main(String[] args) {
		try {
			insertData();
			//query();
			//update();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
