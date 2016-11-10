package utils;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * provide get and close method of database connection
 */
public class DatabaseUtils {
	private static String url;
	private static String driver;
	private static String user;
	private static String password;
	
	static{	
		try {
			//read config from config.prop
			/*FileInputStream fis = new FileInputStream("db.conf");
			Properties prop = new Properties();
			prop.load(fis);
			*/
			driver = "com.mysql.jdbc.Driver";
			url = "114.115.222.240:3306/riskManagement";					//prop.getProperty("mysql_url");
			if(!url.startsWith("jdbc:mysql://")){
				url = "jdbc:mysql://" + url;
			}
			url += "?characterEncoding=utf8&useSSL=true";
			user = "root";			//prop.getProperty("user");
			password = "";			//prop.getProperty("password");
			
			Class.forName(driver);
			
			//fis.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn){
		try {
			if(conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollBack(Connection conn){
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
