package model;

public class Requirement {
	String id;
	String name;
	String description;
	String projectId;
	String projectName;
	String yaoId;
	
	public Requirement(String id, String name, String description,
			String projectId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.projectId = projectId;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getProjectId() {
		return projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getYaoId() {
		return yaoId;
	}

	public void setYaoId(String yaoId) {
		this.yaoId = yaoId;
	}
	
}
