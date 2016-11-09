package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.*;
import utils.DatabaseUtils;


public class RiskStatusDB {

	static String sql_insert_riskStatus = "insert into `riskstatus` values(null, ?, ?, ?, ?, ?);";
	static String sql_get_by_id = "select * from `riskstatus` where id = ?;";
	static String sql_get_by_risk = "select * "
								  + "from `riskstatus` rs, `risk` r "
								  + "where rs.riskid = ? and r.id = rs.riskid;";
	
	public void insertRiskStatus(RiskStatus status) throws SQLException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_insert_riskStatus);
		pstmt.setString(1, status.getState());
		pstmt.setString(2, status.getDescription());
		pstmt.setString(3, status.getRiskId());
		pstmt.setString(4, status.getCreateTime());
		pstmt.setString(5, status.getRecorderId());
		pstmt.executeUpdate();
		pstmt.close();
		DatabaseUtils.closeConnection(conn);
	}
	
	public RiskStatus getRiskStatusById(String id) throws SQLException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_get_by_id);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		RiskStatus status = null;
		while(rs.next()) {
			String state = rs.getString("state");
			String description = rs.getString("description");
			String riskId = rs.getString("riskid");
			String createTime = rs.getString("createtime");
			String recorderId = rs.getString("recorder");
			status = new RiskStatus(id, state, description, riskId, createTime, recorderId);
			break;
		}
		return status;
	}
	
	public List<RiskStatus> getRiskStatusByRisk(String riskId) throws SQLException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_get_by_risk);
		pstmt.setString(1, riskId);
		ResultSet rs = pstmt.executeQuery();
		List<RiskStatus> statuses = new ArrayList<RiskStatus>();
		while(rs.next()) {
			String id = rs.getString("rs.id");
			String state = rs.getString("rs.state");
			String description = rs.getString("rs.description");
			String createTime = rs.getString("rs.createtime");
			String recorderId = rs.getString("rs.recorder");
			String riskYaoId = rs.getString("r.yaoid");
			RiskStatus status = new RiskStatus(id, state, description, riskId, createTime, recorderId);
			status.setRiskYaoId(riskYaoId);
			statuses.add(status);
		}
		return statuses;
	}
}
