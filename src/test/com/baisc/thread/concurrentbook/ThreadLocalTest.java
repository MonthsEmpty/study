package test.com.baisc.thread.concurrentbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 每个线程都持有一个Connection，为何呢？因为每个线程都会初始化它
 * @author Administrator
 *
 */
public class ThreadLocalTest {

	private static final String DB_URL = "";
	
	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>(){
		protected Connection initialValue() {
			try {
				return DriverManager.getConnection(DB_URL);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
	
	public static Connection getConnection(){
		return connectionHolder.get();
	}
}
