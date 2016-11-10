package nju.edu.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import db.ProjectDB;
import db.UserDB;
import model.Project;
import model.User;
import utils.JsonUtils;

public class IterationAction {
	private String result;

	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		String iter=request.getParameter("iter");
		ProjectDB projectDB=new ProjectDB();
		try {
			List<Project> projectList=projectDB.getAllProjects();
			for(Project p:projectList){
				if(p.getName().equals(iter)){
					result="failure";
					return "add";
				}
			}
			Project project=new Project(null,iter,null,null);
			projectDB.insertProject(project);
			System.out.println("insert iter");
			result="success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result="failure";
			e.printStackTrace();
		}
		return "add";
	}
	
	public String list() {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		ProjectDB projectDB=new ProjectDB();
		try {
			List<Project> projectList=projectDB.getAllProjects();
			result=JsonUtils.toJSON(projectList);
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
