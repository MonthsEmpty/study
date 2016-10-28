package test.com.jdbc.postgresql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	//各状态的数据
	private static String sql = "select count(1) from flow_mobile_pool where status = ?";
	//结合flow_order表的数据
	private static String sql2 = "select count(DISTINCT(fmp.mobile)) from flow_order fo,flow_mobile_pool fmp where fo.mobile = fmp.mobile and fmp.status = ?";
	//结合flow_mobile_sms表的数据
	private static String sql3 = "select count(DISTINCT(fmp.mobile)) from flow_mobile_pool fmp ,flow_mobile_sms fms where fmp.mobile = fms.mobile and fmp.status = ?";
	//
	private static String sql4 = "select count(1) from flow_mobile_pool where history_max_degree >= 80 and status = ?";
	//所有的状态
	private static String str = "0,1,2,3,4,5,6,7,9,10,11,12,13,14,15,16,17,18,19,25,26,28,31,32,33,34,35,36,37,39,40,41,42,43,44,45,46,47,48,80,81,90,91,95,96,97,98,100,101,102,107,108,109,110,111,113,114,115,116,117,301,302,303,304,305,401,402,403,404,406,413,417,431,432,433,434,435,599,2626,3020,3055,3200";
	//需要做对比的状态
	private static String str2 = "-1,0,5,14,16,26,28,34,35,42,91,95,96,102,401,402,403,404,432,599,2626";
	
	public static void main(String[] args) {
		String userName = "renwu";
		String password = "gqcjrw695qzf";
		String url = "jdbc:postgresql://61.155.178.246:15205/ahdx";
		String[] array = str2.split(",");
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, userName, password);
			PreparedStatement statement = connection.prepareStatement(sql4);
			ResultSet resultSet = null;
			for(int i =0;i<array.length;i++){
				int status = Integer.parseInt(array[i]);
				statement.setInt(1, status);
				resultSet = statement.executeQuery();
				while(resultSet.next()){
					System.out.println("status '" + status + "' count :" + resultSet.getInt(1));
				}
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
