package test.com.jdbc.postgresql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCStatementCRUD {

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
			System.out.println(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		add();
		//delete();
		update();
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
	
	public static void add(){
		try {
			if(conn == null){
				getConnection();
			}
			Statement st = conn.createStatement();
			String sql = "insert into people(id,name,age) values(2,'json',25)";
			int num = st.executeUpdate(sql);
			if(num > 0){
				System.out.println("success");
			}else{
				System.out.println("fail");
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除
	 */
	public static void delete(){
		try {
			if(conn == null){
				getConnection();
			}
			Statement st = conn.createStatement();
			String sql = "delete from people where id = 2";
			int num = st.executeUpdate(sql);
			if(num > 0){
				System.out.println("success");
			}else{
				System.out.println("fail");
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改
	 */
	public static void update(){
		try {
			if(conn == null){
				getConnection();
			}
			Statement st = conn.createStatement();
			String sql = "update people set name = 'amy' where id = 2";
			int num = st.executeUpdate(sql);
			if(num > 0){
				System.out.println("success");
			}else{
				System.out.println("fail");
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
