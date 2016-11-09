package db;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import utils.DatabaseUtils;


public class ProjectDB {
	
	static String sql_insert_project = "insert into `project` values(null, ?, ?, ?);";
	static String sql_get_by_id = "select * from `project` where id = ?;";
	static String sql_get_all_projects = "select * from `project`;";
	
	public void insertProject(Project project) throws SQLException{
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_insert_project);
		pstmt.setString(1, project.getName());
		pstmt.setString(2, project.getDescription());
		pstmt.setString(3, project.getOwnerId());
		pstmt.executeUpdate();
		pstmt.close();
		DatabaseUtils.closeConnection(conn);
	}
	
	public Project getProjectById(String id) throws SQLException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_get_by_id);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		Project project = null;
		while(rs.next()) {
			project = new Project(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getString("ownerid"));
			break;
		}
		return project;
	}
	
	public List<Project> getAllProjects() throws SQLException{
		List<Project> projects = new ArrayList<Project>();
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_get_all_projects);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Project project = new Project(rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getString("ownerid"));
			projects.add(project);
		}
		return projects;
	}
	
}
