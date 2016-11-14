package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;
import utils.DatabaseUtils;


public class RiskDB {

	static String sql_insert_risk = "insert into `risk` values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	static String sql_get_by_id = "select * from `risk` where id = ?;";
	static String sql_get_by_requirement = "select * "
										 + "from `risk` r, `account` a1, `account` a2 "
										 + "where r.requirementid = ? and r.submitter = a1.id and r.tracer = a2.id;";
	static String sql_update_risk = "update `risk` "
								  + "set name = ?, content = ?, possibility = ?, influence = ?, threshold = ?, tracer = ? "
								  + "where id = ?;";
	static String sql_get_by_yaoid = "select * from `risk` where yaoid = ?;";
	
	public void insertRisk(Risk risk) throws SQLException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_insert_risk);
		pstmt.setString(1, risk.getName());
		pstmt.setString(2, risk.getContent());
		pstmt.setString(3, risk.getPossibility());
		pstmt.setString(4, risk.getInfluence());
		pstmt.setString(5, risk.getThreshold());
		pstmt.setString(6, risk.getSubmitterId());
		pstmt.setString(7, risk.getTracerId());
		pstmt.setString(8, risk.getRequirementId());
		pstmt.setString(9, "1.1.2");
		pstmt.executeUpdate();
		pstmt.close();
		DatabaseUtils.closeConnection(conn);
	}
	
	public Risk getRiskById(String id) throws SQLException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_get_by_id);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		Risk risk = null;
		while(rs.next()) {
			String name = rs.getString("name");
			String content = rs.getString("content");
			String possibility = rs.getString("possibility");
			String influence = rs.getString("influence");
			String threshold = rs.getString("threshold");
			String submitterId = rs.getString("submitter");
			String tracerId = rs.getString("tracer");
			String requirementId = rs.getString("requirementId");
			risk = new Risk(id, name, content, possibility, influence, threshold, submitterId, tracerId, requirementId);
			break;
		}
		return risk;
	}
	
	public List<Risk> getRiskByRequirement(String requirementId) throws SQLException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_get_by_requirement);
		pstmt.setString(1, requirementId);
		ResultSet rs = pstmt.executeQuery();
		List<Risk> risks = new ArrayList<Risk>();
		while(rs.next()) {
			String id = rs.getString("r.id");
			String name = rs.getString("r.name");
			String content = rs.getString("r.content");
			String possibility = rs.getString("r.possibility");
			String influence = rs.getString("r.influence");
			String threshold = rs.getString("r.threshold");
			String submitterId = rs.getString("r.submitter");
			String tracerId = rs.getString("r.tracer");
			String subscriber = rs.getString("a1.username");
			String tracker = rs.getString("a2.username");
			String yaoId = rs.getString("r.yaoid");
			Risk risk = new Risk(id, name, content, possibility, influence, threshold, submitterId, tracerId, requirementId);
			risk.setSubscriber(subscriber);
			risk.setTracker(tracker);
			risk.setYaoId(yaoId);
			risks.add(risk);
		}
		return risks;
	}
	
	public AllRisks getAllRisks() throws SQLException {
		ProjectDB projectdb = new ProjectDB();
		RequirementDB reqdb = new RequirementDB();
		RiskDB riskdb = new RiskDB();
		AllRisks allRisks = new AllRisks();
		List<Project> projects = projectdb.getAllProjects();
		for(Project project: projects) {
			List<Requirement> reqs = reqdb.getRequirementByProject(project.getId());
			ProjectDetail projectDetail = new ProjectDetail(project);
			for(Requirement req: reqs) {
				List<Risk> risks = riskdb.getRiskByRequirement(req.getId());
				RequirementDetail reqDetail = new RequirementDetail(req);
				for(Risk risk: risks) {
					reqDetail.addRisk(risk);
				}
				projectDetail.addRequirement(reqDetail);
			}
			allRisks.addProject(projectDetail);
		}
		return allRisks;
	}
	
	public void updateRisk(Risk risk) throws SQLException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_update_risk);
		pstmt.setString(1, risk.getName());
		pstmt.setString(2, risk.getContent());
		pstmt.setString(3, risk.getPossibility());
		pstmt.setString(4, risk.getInfluence());
		pstmt.setString(5, risk.getThreshold());
		pstmt.setString(6, risk.getTracerId());
		pstmt.setString(7, risk.getId());
		pstmt.executeUpdate();
		pstmt.close();
		DatabaseUtils.closeConnection(conn);
	}
	
	public Risk getRiskByYaoId(String id) throws SQLException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_get_by_yaoid);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		Risk risk = null;
		while(rs.next()) {
			String name = rs.getString("name");
			String content = rs.getString("content");
			String possibility = rs.getString("possibility");
			String influence = rs.getString("influence");
			String threshold = rs.getString("threshold");
			String submitterId = rs.getString("submitter");
			String tracerId = rs.getString("tracer");
			String requirementId = rs.getString("requirementId");
			risk = new Risk(id, name, content, possibility, influence, threshold, submitterId, tracerId, requirementId);
			break;
		}
		return risk;
	}
	
}
