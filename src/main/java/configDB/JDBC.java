package configDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
	
	/**
	 * this is default config
	 */
	String port="3306";
	String dbName="libaryDB";
	String connectionName="root";
	String password="12345678";
	
	
	public JDBC() {}
	public JDBC(String port, String dbName, String connectionName,String password) {
		this.port = port;
		this.dbName = dbName;
		this.connectionName = connectionName;
		this.password = password;
		
	}

	
	/**
	 * method connection
	 * returnType is Connection
	 * @return
	 */
	public Connection connection() {
		
		Connection cnn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnn = DriverManager.getConnection("jdbc:mysql://localhost:"+port+"/"+dbName+"", connectionName, password);
		} catch (Exception e) {
			e.getMessage();
		}
		
		return cnn;
	}

}
