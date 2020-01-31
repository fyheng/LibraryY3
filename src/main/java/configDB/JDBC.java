package configDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Logger;

public class JDBC {

	public JDBC() {
	}

	static Statement statement;
	static ResultSet resultSet;

	/**
	 * this is default configuration/libaryDB/root/12345
	 */
	static String port = "3307";
	static String dbName = "libaryDB";
	static String connectionName = "root";
	static String password = "12345";

	public JDBC(String port, String dbName, String connectionName, String password) {
		JDBC.port = port; // JDBC mean this
		JDBC.dbName = dbName;
		JDBC.connectionName = connectionName;
		JDBC.password = password;
	}

	// method connection returnType is Connection
	public static Connection connection() throws SQLException {

		Connection cnn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnn = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + dbName + "", connectionName,
					password);
		} catch (Exception e) {
			Logger logger = Logger.getGlobal();
			logger.info("connection problem!!!");
		}
		return cnn;
	}

	// list all rows with Specified on column
	public static Object readData(String tbName, String... columnName) throws SQLException {

		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> set;
		statement = connection().createStatement();
		resultSet = statement.executeQuery("select * from " + tbName + "");

		// loop rows
		while (resultSet.next()) {
			set = new ArrayList<String>();
			// loop column
			for (String name : columnName) {
				set.add(resultSet.getString(name));
			}
			result.add(set);
		}
		resultSet.close();
		return result;
	}

	// list all rows and all column
	public static Object readData(String tbName) throws SQLException {

		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> set;
		ArrayList<String> columnName = new ArrayList<String>();
		statement = connection().createStatement();
		resultSet = statement.executeQuery("select * from " + tbName + "");
		columnName = JDBC.getColumnName(resultSet);

		// loop rows
		while (resultSet.next()) {
			// loop column
			set = new ArrayList<String>();
			for (String name : columnName) {
				set.add(resultSet.getString(name));
			}
			result.add(set);
		}
		resultSet.close();
		return result;
	}

	// get All column name form table
	public static ArrayList<String> getColumnName(ResultSet resultSet) throws SQLException {
		int columCount = resultSet.getMetaData().getColumnCount();
		int i = 1;
		ArrayList<String> name = new ArrayList<String>();

		for (i = 1; i <= columCount; i++) {
			name.add(resultSet.getMetaData().getColumnName(i));
		}

		// print column name
		System.out.println(name);

		return name;
	}

	public static int getCount(String tbName) throws SQLException {
		int count = 0;
		statement = connection().createStatement();
		resultSet = statement.executeQuery("SELECT COUNT(*) as totals from " + tbName + "");

		while (resultSet.next()) {
			count +=resultSet.getInt("totals");
		}
		resultSet.close();
		return count;
	}

	public static int getCount(String tbName, String colum, String value) throws SQLException {
		int c = 0;
		String date =  JDBC.getDate();
		statement = connection().createStatement();
		resultSet = statement.executeQuery(
				"select count(id) as totals from " + tbName + " where " + colum + " = '"+ date +"' ");
		while (resultSet.next()) {
			c += resultSet.getInt("totals");
		}
		resultSet.close();
		return c;

	}

	//getCurrent date java.lang 
	public static String getDate() {
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		// System.out.println(dtf.format(now));
		return now.toString().substring(0, 10);
	}
}
