package nju.edu.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import db.ProjectDB;
import db.RequirementDB;
import db.UserDB;
import model.Project;
import model.Requirement;
import model.User;
import utils.JsonUtils;

public class RequirementAction {
	private String result;
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		String iterid=request.getParameter("iterid");
		String description=request.getParameter("description");
		
		RequirementDB requirementDB=new RequirementDB();
		try {
			List<Requirement> requirementList=requirementDB.getRequirementByProject(iterid);
			for(Requirement r:requirementList){
				if(r.getName().equals(description)){
					result="failure";
					return "add";
				}
			}
			Requirement req=new Requirement(null,description,"",iterid);
			requirementDB.insertRequirement(req);
			System.out.println("insert iter");
			result="success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result="failure";
			e.printStackTrace();
		}
		System.out.println("insert req");
		return "add";
	}
	
	public String list() {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		RequirementDB requirementDB=new RequirementDB();
		ProjectDB projectDB=new ProjectDB();
		ArrayList<Requirement> requirementList=new ArrayList<>();
		try {
			List<Project> projectList=projectDB.getAllProjects();
			for(Project p:projectList){
				requirementList.addAll(requirementDB.getRequirementByProject(p.getId()));
			}
			result=JsonUtils.toJSON(requirementList);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result="failure";
			e.printStackTrace();
		}
		return "list";
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
