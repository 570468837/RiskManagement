package model;

public class RiskStatus {
	
	String id;
	String state;
	String description;
	String riskId;
	String createTime;
	String recorderId;
	String riskYaoId;
	
	public RiskStatus(String id, String state,String description, 
			String riskId, String createTime, String recorderId) {
		super();
		this.id = id;
		this.state = state;
		this.description = description;
		this.riskId = riskId;
		this.createTime = createTime;
		this.recorderId = recorderId;
	}

	public String getId() {
		return id;
	}

	public String getState() {
		return state;
	}

	public String getDescription() {
		return description;
	}

	public String getRiskId() {
		return riskId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public String getRecorderId() {
		return recorderId;
	}

	public String getRiskYaoId() {
		return riskYaoId;
	}

	public void setRiskYaoId(String riskYaoId) {
		this.riskYaoId = riskYaoId;
	}
	
}
