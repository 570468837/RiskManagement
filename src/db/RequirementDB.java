package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Requirement;
import utils.DatabaseUtils;


public class RequirementDB {
	
	static String sql_insert_requirement = "insert into `requirement` values(null, ?, ?, ?, null);";
	static String sql_get_by_id = "select * from `requirement` where id = ?;";
	static String sql_get_by_project = "select * "
									 + "from `requirement` r, `project` p "
									 + "where projectid = ? and p.id = projectid;";
	
	public void insertRequirement(Requirement req) throws SQLException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_insert_requirement);
		pstmt.setString(1, req.getName());
		pstmt.setString(2, req.getDescription());
		pstmt.setString(3, req.getProjectId());
		pstmt.executeUpdate();
		pstmt.close();
		DatabaseUtils.closeConnection(conn);
	}
	
	public Requirement getRequirementById(String id) throws SQLException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_get_by_id);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		Requirement req = null;
		while(rs.next()) {
			String name = rs.getString("name");
			String description = rs.getString("description");
			String projectId = rs.getString("projectid");
			req = new Requirement(id, name, description, projectId);
			break;
		}
		return req;
	}
	
	public List<Requirement> getRequirementByProject(String projectId) throws SQLException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_get_by_project);
		pstmt.setString(1, projectId);
		ResultSet rs = pstmt.executeQuery();
		List<Requirement> reqs = new ArrayList<Requirement>();
		while(rs.next()) {
			String id = rs.getString("r.id");
			String name = rs.getString("r.name");
			String description = rs.getString("r.description");
			String projectName = rs.getString("p.name");
			String yaoId = rs.getString("r.yaoid");
			Requirement req = new Requirement(id, name, description, projectId);
			req.setProjectName(projectName);
			req.setYaoId(yaoId);
			reqs.add(req);
		}
		return reqs;
	}
}
