package model;

import java.util.ArrayList;
import java.util.List;

public class RequirementDetail extends Requirement {
	
	List<Risk> risks;
	
	public RequirementDetail(String id, String name, String description,
			String projectId) {
		super(id, name, description, projectId);
		risks = new ArrayList<Risk>();
	}
	
	public RequirementDetail(Requirement req) {
		this(req.id, req.name, req.description, req.projectId);
		this.setProjectName(req.projectName);
		this.setYaoId(req.yaoId);
	}
	
	public void addRisk(Risk risk) {
		risks.add(risk);
	}
	
	public List<Risk> getRisks() {
		return risks;
	}
}
