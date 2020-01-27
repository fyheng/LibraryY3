package configDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class JDBC {

	static Statement statement;
	static ResultSet resultSet;

	/**
	 * this is default config
	 */
	static String port = "3306";
	static String dbName = "libaryDB";
	static String connectionName = "root";
	static String password = "12345678";

	public JDBC() {
	}
	/*
	 * public JDBC(String tbName) { JDBC.tbName = tbName; }
	 */

	public JDBC(String port, String dbName, String connectionName, String password) {
		this.port = port;
		this.dbName = dbName;
		this.connectionName = connectionName;
		this.password = password;
	}

	/**
	 * method connection returnType is Connection
	 * 
	 * @return
	 * @throws SQLException
	 */

	public static Connection connection() throws SQLException {

		Connection cnn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnn = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + dbName + "", connectionName,
					password);
		} catch (Exception e) {
			e.getMessage();
		}

		return cnn;
	}

	public static Object readData(String tbName, String... columnName) throws SQLException {

		statement = connection().createStatement();
		resultSet = statement.executeQuery("select * from " + tbName + "");

		ArrayList<Object> resulft = null;
		ArrayList<String> count = new ArrayList<String>();

//		for (String name : columnName) {
//			count.add(name);
//		}

		System.out.println(count);

		while (resultSet.next()) {
			for (String name : columnName) {
				resultSet.getString(name);
				System.out.print(resultSet.getString(name)+"\t");
				count.add(resultSet.getString(name));
			}
			System.out.println("\n");
		}

		return resulft;

	}

//	public static String[] getColumnName(ResultSet resultSet) throws SQLException {
//		int columCount = resultSet.getMetaData().getColumnCount();
//		int i = 1;
//		String[] columnName = new String[10];
//		for (i = 1; i <= columCount; i++) 
//			columnName[i] = resultSet.getMetaData().getColumnName(i);
//			System.out.println(columnName[i]);
//			return  columnName;
//		
//		System.out.println(columnName);
//		return columnName;
//	}

}
