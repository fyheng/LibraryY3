package configDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	static String localHost = "127.0.0.1";
	static String port = "3306";
	static String dbName = "libraryproject";
	static String connectionName = "root";
	static String password = "password";
	
	static ArrayList<String> columnName = new ArrayList<String>();
	static String keySets = new String();
	static String temps = new String();

	public JDBC(String localHost,String port, String dbName, String connectionName, String password) {
		JDBC.localHost = localHost;
		JDBC.port = port;
		JDBC.dbName = dbName;
		JDBC.connectionName = connectionName;
		JDBC.password = password;
	}

	// method connection returnType Connection
	public static Connection connection() throws SQLException {

		Connection cnn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnn = DriverManager.getConnection("jdbc:mysql://" + localHost + ":" + port + "/" + dbName + "",
					connectionName, password);
		} catch (Exception e) {
			Logger logger = Logger.getGlobal();
			logger.info("connection problem!!!");
		}
		return cnn;
	}

//List Data from DB=========================================================================================================

	// list all rows and all column
	public static ArrayList<ArrayList<String>> readData(String tbName) throws SQLException {

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

	// list all rows with Specified on column
	public static ArrayList<ArrayList<String>> readData(String tbName, String... columnName) throws SQLException {

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

	// list all rows with condition
	public static ArrayList<ArrayList<String>> readBy(String tbName, String column, String value) throws SQLException {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> set;
		ArrayList<String> columnName = new ArrayList<String>();
		value = value.length() == 0 ? JDBC.getDate() : value;

		statement = connection().createStatement();
		resultSet = statement.executeQuery("select * from " + tbName + " where " + column + " = '" + value + "' ");
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

	// list all rows with 2 condition
	public static ArrayList<ArrayList<String>> readBys(String tbName, String column1, String value1, String column2,
			String value2) throws SQLException {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> set;
		ArrayList<String> columnName = new ArrayList<String>();
		statement = connection().createStatement();
		resultSet = statement.executeQuery("select * from " + tbName + " where " + column1 + " = '" + value1 + "' and "
				+ column2 + " = '" + value2 + "' ");
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

//get totals=============================================================================================================

	// return totals rows from table
	public static int getCount(String tbName) throws SQLException {
		int count = 0;
		statement = connection().createStatement();
		resultSet = statement.executeQuery("SELECT COUNT(*) as totals from " + tbName + "");

		while (resultSet.next()) {
			count += resultSet.getInt("totals");
		}
		resultSet.close();
		return count;
	}

	// return totals rows by column from table
	public static int getCount(String tbName, String colName, String value) throws SQLException {
		int c = 0;
		statement = connection().createStatement();
		resultSet = statement.executeQuery(
				"select count(id) as totals from " + tbName + " where " + colName + " = '" + value + "' ");
		while (resultSet.next()) {
			c += resultSet.getInt("totals");
		}
		resultSet.close();
		return c;

	}

	// return totals rows by 2 condition
	public static int getCountBy(String tbName, String c1, String v1, String c2, String v2) throws SQLException {
		int c = 0;
		statement = connection().createStatement();
		resultSet = statement.executeQuery("select count(id) as totals from " + tbName + " where " + c1 + " = '" + v1
				+ "' and " + c2 + " = '" + v2 + "' ");
		while (resultSet.next()) {
			c += resultSet.getInt("totals");
		}
		resultSet.close();
		return c;
	}

	// return totals rows by current date
	public static int getCountToday(String tbName, String colDateName) throws SQLException {
		int c = 0;
		String date = JDBC.getDate();
		statement = connection().createStatement();
		resultSet = statement.executeQuery(
				"select count(id) as totals from " + tbName + " where " + colDateName + " = '" + date + "' ");
		while (resultSet.next()) {
			c += resultSet.getInt("totals");
		}
		resultSet.close();
		return c;
	}

// Insert into DB===================================================================================================
	public static String insert(String tbName, String... values) throws SQLException {
		String sql = "INSERT INTO " + tbName + " ( " + keySets + " ) values (" + temps + ")";
		PreparedStatement prepared = connection().prepareStatement(sql);
		int i = 1;
		for (String value : values) {
			prepared.setString(i++, value);
		}
		prepared.execute();
		connection().close();
		Logger logger = Logger.getGlobal();
		logger.info("Insert Data Success");
		return sql;
	}

// Delete from DB===================================================================================================
	public static void delete(String tbName,String column,String value) throws SQLException {
		statement = connection().createStatement();
		String sql = "DELETE FROM " +tbName+ " WHERE "+column+" = "+value+" ";	
		statement.executeUpdate(sql);
		connection().close();
		Logger logger = Logger.getGlobal();
		logger.info("Delete Data Success");
	}
	
	
//update from DB===================================================================================================
	
	public static void update(String tbName,String column,String value) throws SQLException {
		statement = connection().createStatement();
		String sql = "UPDATE " +tbName+ " WHERE "+column+" = "+value+" ";	
		statement.executeUpdate(sql);
		connection().close();
		Logger logger = Logger.getGlobal();
		logger.info("update success");
	}
	
	
	
	//use in forgetPassword========================================
	
	public static boolean updateBy(String tbName,String column,String Oldvalue,String newValue) {
		
		String sql = "UPDATE " +tbName+ " SET "+column+" = '"+newValue+"' WHERE "+ column +" = '"+Oldvalue+"' ";	
		try {			statement = connection().createStatement();
			statement.executeUpdate(sql);
			Logger logger = Logger.getGlobal();
			logger.info("update success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean updateBy(String tbName, String column, String newValue, String where, String condi) {

		String sql = "UPDATE " + tbName + " SET " + column + " = '" + newValue + "' WHERE " + where + " = '" + condi
				+ "' ";
		try {
			statement = connection().createStatement();
			statement.executeUpdate(sql);
			Logger logger = Logger.getGlobal();
			logger.info("update success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	//============================================================
	

	public void updateTableColumns(){
	    String sql = "update tableName set column1 = ? , column2 = ? , column3 = ? where rowName = ?";
	    try {
	        PreparedStatement ps = connection().prepareStatement(sql); 
	        ps.setString(1, "Value of column1");// Set value for each ?
	        ps.setString(2, "Value of column2");
	        ps.setString(3, "Value of column3");
	        ps.setString(4, "Value of rowName");

	        ps.execute(sql); //execute the sql sentence in sql database
	    } catch (SQLException e) {}
	}
	
	
	public static boolean updateDynamic(String tbName,String column,String Oldvalue,String newValue) throws SQLException {
		
		String sql = "update staff set 'version' = ? , 'address' = ?  where 'secuserId' = ? ";
		PreparedStatement psm =  connection().prepareStatement(sql);
		psm.setInt(1, 5);
		psm.setString(2, "kondal");
		psm.setInt(3, 1);
	
		
		
		psm.execute(sql);
		Logger logger = Logger.getGlobal();
		logger.info("update success");
		return true;
	}

// @supProcess===================================================================================================

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

	// getCurrent date java.lang
	public static String getDate() {
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		// System.out.println(dtf.format(now));
		return now.toString().substring(0, 10);
	}

	/**
	 * set all column to keySets(local string variable) set temp value prepare to
	 * temps (local) set all column to columnName (local ArrayList variable)
	 * 
	 * @param keys
	 */
	public static void setKey(String... keys) {
		ArrayList<String> column = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		for (String key : keys) {
			column.add(key);
			temp.add("?");
		}
		String string = column.toString();
		String keySet = string.substring(1, string.length() - 1);
		columnName = column;
		keySets = keySet;

		// temp for value prepare
		String tempString = temp.toString();
		String subTemp = tempString.substring(1, tempString.length() - 1);
		temps = subTemp;
	}
	
	
	static int getColumnKey(String key) {
		return 1;
	}

	
	public static void getColumnName(String... key) {
		ArrayList<String> keyNames = new ArrayList<String>();
		for (String keys : key) {
			keyNames.add(keys);
		}
 
		columnName = keyNames;
		System.out.println(columnName); 
	}
}
