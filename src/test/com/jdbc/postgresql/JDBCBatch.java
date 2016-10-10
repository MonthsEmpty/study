package test.com.jdbc.postgresql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC批处理
 * 
 * @author Administrator
 *
 */
public class JDBCBatch {

	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	
	private static Connection conn = null;
	
	/**
	 * 初始化数据
	 */
	static{
		try {
			InputStream in = JDBCStatementCRUD.class.getClassLoader().getResourceAsStream("db.properties");
			Properties properties = new Properties();
			properties.load(in);
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			url = properties.getProperty("postgreUrl");
			driver = properties.getProperty("postgreDriver");
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		preparedstatementBatch();
	}
	
	/**
	 * 获取连接
	 */
	public static void getConnection(){
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用Statement对象添加要批量执行SQL语句
	 */
	public static void statementBatch(){
		try {
			if(conn == null){
				getConnection();
			}
			Statement st = conn.createStatement();
			String sql = "insert into people(id,name,age) values(4,'test1',23)";
			String sql1 = "insert into people(id,name,age) values(5,'test2',23)";
			String sql2 = "insert into people(id,name,age) values(6,'test3',23)";
			String sql3 = "insert into people(id,name,age) values(7,'test4',23)";
			st.addBatch(sql);
			st.addBatch(sql1);
			st.addBatch(sql2);
			st.addBatch(sql3);
			st.executeBatch();
			st.clearBatch();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用PreparedStatement完成批处理
	 */
	public static void preparedstatementBatch(){
		try {
			if(conn == null){
				getConnection();
			}
			String sql = "insert into people(id,name,age) values(?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			
			for(int i = 3;i<8;i++){
				st.setInt(1, i);
				st.setString(2, "test" + i);
				st.setInt(3, 26);
				st.addBatch();
			}
			st.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
