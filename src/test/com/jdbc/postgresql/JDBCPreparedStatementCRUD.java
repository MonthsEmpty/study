package test.com.jdbc.postgresql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * PreperedStatement是Statement的子类，它的实例对象可以通过调用Connection.preparedStatement()方法获得，
 * 相对于Statement对象而言：PreperedStatement可以避免SQL注入的问题。
 * Statement会使数据库频繁编译SQL，可能造成数据库缓冲区溢出。PreparedStatement可对SQL进行预编译，
 * 从而提高数据库的执行效率。并且PreperedStatement对于sql中的参数，允许使用占位符的形式进行替换，
 * 简化sql语句的编写。
 * 
 * @author Administrator
 *
 */
public class JDBCPreparedStatementCRUD {

	private static String username = null;
	private static String password = null;
	private static String url = null;
	private static String driver = null;
	
	private static Connection conn = null;
	
	static {
		try {
			Properties properties = new Properties();
			InputStream inputStream = JDBCPreparedStatementCRUD.class.getClassLoader().getResourceAsStream("db.properties");
			properties.load(inputStream);
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			url = properties.getProperty("postgreUrl");
			driver = properties.getProperty("postgreDriver");
			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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
	
	public static void main(String[] args) {
	//	add();
	//	delete();
		update();
	}
	
	public static void add(){
		try {
			if(conn == null){
				getConnection();
			}
			PreparedStatement st = null;
			String sql = "insert into people(id,name,age) values(?,?,?)";
			st = conn.prepareStatement(sql);
			//为SQL语句中的参数赋值，注意，索引是从1开始的
			st.setInt(1, 3);
			st.setString(2, "tom");
			st.setInt(3, 26);
			int num = st.executeUpdate();
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
	
	public static void delete(){
		try {
			if(conn == null){
				getConnection();
			}
			PreparedStatement st = null;
			String sql = "delete from people where id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, 3);
			int num = st.executeUpdate();
			if(num > 0){
				System.out.println("success");
			}else{
				System.out.println("fail");
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void update(){
		try {
			if(conn == null){
				getConnection();
			}
			String sql = "update people set name = ? where id = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "jerry");
			st.setInt(2, 2);
			int num = st.executeUpdate();
			if(num > 0){
				System.out.println("success");
			}else{
				System.out.println("fail");
			}
			st.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(1);
		}
	}
}
