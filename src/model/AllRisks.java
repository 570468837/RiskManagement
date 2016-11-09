package model;

import java.util.ArrayList;
import java.util.List;

public class AllRisks {
	
	List<ProjectDetail> projects;
	
	public AllRisks() {
		projects = new ArrayList<ProjectDetail>();
	}
	
	public void addProject(ProjectDetail project) {
		projects.add(project);
	}
	
	public List<ProjectDetail> getProjects() {
		return projects;
	}
}
