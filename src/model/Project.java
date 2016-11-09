package model;

public class Project {
	String id;
	String name;
	String description;
	String ownerId;
	
	public Project(String id, String name, String description, String ownerId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ownerId = ownerId;
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

	public String getOwnerId() {
		return ownerId;
	}
	
}
