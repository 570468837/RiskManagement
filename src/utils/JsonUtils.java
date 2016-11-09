package utils;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.AllRisks;
import model.Project;
import model.ProjectDetail;
import model.Requirement;
import model.RequirementDetail;
import model.Risk;
import model.RiskStatus;


public class JsonUtils {
	
	public static String toJSON(List list) {
		JSONArray arr = new JSONArray();
	}
	
	public static String toJSON(Project project) {
		JSONObject obj = new JSONObject();
		obj.put("id", project.getId());
		obj.put("content", project.getName());
		obj.put("description", project.getDescription());
		obj.put("ownerid", project.getOwnerId());
		return obj.toString();
	}
	
	public static String toJSON(Requirement req) {
		JSONObject obj = new JSONObject();
		obj.put("id", req.getId());
		obj.put("name", req.getName());
		obj.put("description", req.getDescription());
		obj.put("content", req.getProjectName() + "-" + req.getName());
		return obj.toString();
	}
	
	public static String toJSON(Risk risk) {
		JSONObject obj = new JSONObject();
		obj.put("id", risk.getId());
		obj.put("name", risk.getName());
		obj.put("content", risk.getContent());
		obj.put("possibility", risk.getPossibility());
		obj.put("impact", risk.getInfluence());
		obj.put("trigger", risk.getThreshold());
		obj.put("subscriberid", risk.getSubmitterId());
		obj.put("trackerid", risk.getTracerId());
		obj.put("subscriber", risk.getSubscriber());
		obj.put("tracker", risk.getTracker());
		obj.put("requirementid", risk.getRequirementId());
		obj.put("riskid", risk.getYaoId());
		return obj.toString();
	}
	
	public static String toJSON(RiskStatus status) {
		JSONObject obj = new JSONObject();
		obj.put("id", status.getId());
		obj.put("state", status.getState());
		obj.put("description", status.getDescription());
		obj.put("riskidindb", status.getRiskId());
		obj.put("createTime", status.getCreateTime());
		obj.put("recorderid", status.getRecorderId());
		obj.put("riskid", status.getRiskYaoId());
		return obj.toString();
	}
	
	public static String toJSON(AllRisks risks) {
		JSONArray arr = new JSONArray();
		for(ProjectDetail project: risks.getProjects()) {
			arr.put(toJSONsp(project));
		}
		JSONObject obj=new JSONObject();
		obj.put("content", arr);
		return obj.toString();
	}
	
	private static JSONObject toJSONsp(ProjectDetail project) {
		JSONObject obj = new JSONObject();
		obj.put("projectid", project.getId());
		obj.put("text", project.getName());
		JSONArray arr = new JSONArray();
		for(RequirementDetail req: project.getRequirements()) {
			arr.put(toJSONsp(req));
		}
		obj.put("nodes", arr);
		return obj;
	}
	
	private static JSONObject toJSONsp(RequirementDetail req) {
		JSONObject obj = new JSONObject();
		obj.put("requirementid", req.getId());
		obj.put("text", req.getName());
		JSONArray arr = new JSONArray();
		for(Risk risk: req.getRisks()) {
			arr.put(toJSONsp(risk));
		}
		obj.put("nodes", arr);
		return obj;
	}
	
	private static JSONObject toJSONsp(Risk risk) {
		JSONObject obj = new JSONObject();
		obj.put("text", risk.getYaoId() + "-" + risk.getContent());
		obj.put("riskid", risk.getId());
		return obj;
	}
}
