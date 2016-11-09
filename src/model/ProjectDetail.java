package model;

import java.util.ArrayList;
import java.util.List;

public class ProjectDetail extends Project {
	
	List<RequirementDetail> requirements;
	
	public ProjectDetail(String id, String name, String description,
			String ownerId) {
		super(id, name, description, ownerId);
		requirements = new ArrayList<RequirementDetail>();
	}
	
	public ProjectDetail(Project project) {
		this(project.id, project.name, project.description, project.ownerId);
	}
	
	public void addRequirement(RequirementDetail req) {
		requirements.add(req);
	}
	
	public List<RequirementDetail> getRequirements() {
		return requirements;
	}
}
