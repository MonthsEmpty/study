package test.com.jdbc.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC详解 1、DriverManager Jdbc程序中的DriverManager用于加载驱动，并创建与数据库的链接。 2、Connection类
 * Jdbc程序中的Connection，它用于代表数据库的链接，Collection是数据库编程中最重要的一个对象，
 * 客户端与数据库所有交互都是通过connection对象完成的。常用方法有：
 * （1）createStatement()：创建向数据库发送sql的statement对象。 （2）prepareStatement(sql)
 * ：创建向数据库发送预编译sql的PrepareSatement对象。 3、Statement类
 * Jdbc程序中的Statement对象用于向数据库发送SQL语句，常用方法有： （1）executeQuery(String sql)
 * ：用于向数据发送查询语句。 （2）executeUpdate(String sql)：用于向数据库发送insert、update或delete语句
 * （3）execute(String sql)：用于向数据库发送任意sql语句 4、ResultSet类
 * Jdbc程序中的ResultSet用于代表Sql语句的执行结果。Resultset封装执行结果时，采用的类似于表格的方式。 ResultSet
 * 对象维护了一个指向表格数据行的游标，初始的时候，游标在第一行之前，调用ResultSet.next() 方法，
 * 可以使游标指向具体的数据行，进行调用方法获取该行的数据。
 * 
 * @author Administrator
 *
 */
public class PostgresqlJDBCTest {

	public static void main(String[] args) {
		// 要连接的数据库URL
				String url = "jdbc:postgresql://localhost/mytest";
				// 连接的数据库时使用的用户名
				String username = "postgres";
				// 连接的数据库时使用的密码
				String password = "renwu123";
				try {
					// 1.加载驱动
					Class.forName("org.postgresql.Driver");
					// 2.获取与数据库的链接
					Connection conn = DriverManager.getConnection(url, username, password);
					// 3.获取用于向数据库发送sql语句的statement
					Statement st = conn.createStatement();
					// 4.向数据库发sql,并获取代表结果集的resultset
					String sql = "select * from people";
					ResultSet rs = st.executeQuery(sql);
					// 5.取出结果集的数据
					while (rs.next()) {
						System.out.println(rs.getObject("id"));
						System.out.println(rs.getObject("name"));
						System.out.println(rs.getObject("age"));
					}
					// 6.关闭链接，释放资源
					rs.close();
					st.close();
					conn.close();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

}
