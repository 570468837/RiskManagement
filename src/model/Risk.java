package model;

public class Risk {
	String id;
	String name;
	String content;
	String possibility;
	String influence;
	String threshold;
	String submitterId;
	String tracerId;
	String requirementId;
	
	String yaoId;
	String subscriber;
	String tracker;
	
	public Risk(String id, String name, String content, String possibility,
			String influence, String threshold, String submitterId,
			String tracerId, String requirementId) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.possibility = possibility;
		this.influence = influence;
		this.threshold = threshold;
		this.submitterId = submitterId;
		this.tracerId = tracerId;
		this.requirementId = requirementId;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public String getPossibility() {
		return possibility;
	}

	public String getInfluence() {
		return influence;
	}

	public String getThreshold() {
		return threshold;
	}

	public String getSubmitterId() {
		return submitterId;
	}

	public String getTracerId() {
		return tracerId;
	}
	
	public String getRequirementId() {
		return requirementId;
	}

	public String getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}

	public String getTracker() {
		return tracker;
	}

	public void setTracker(String tracker) {
		this.tracker = tracker;
	}

	public String getYaoId() {
		return yaoId;
	}

	public void setYaoId(String yaoId) {
		this.yaoId = yaoId;
	}
	
}
