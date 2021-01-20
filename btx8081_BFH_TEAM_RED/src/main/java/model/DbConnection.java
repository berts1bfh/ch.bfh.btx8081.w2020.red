package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Makes DB Connection (Singleton)
 */
public class DbConnection {

	private static final DbConnection dbConnection = new DbConnection();
	private Connection connection = null;

	private DbConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			// Original: "jdbc:sqlite:src/main/java/model/acadiaDB.db"
            // Denis: "jdbc:sqlite:C:/Users/Denis/git/ch.bfh.btx8081.w2020.red/btx8081_BFH_TEAM_RED/src/main/java/model/acadiaDB.db";
			connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/model/acadiaDB.db");
			connection.setAutoCommit(false);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e + ""); // Legit for debugging reasons? (Could use log instead)
		}
	}

	/**
	 * Returns the current Connection for DbConnection
	 * @return Connection of current DbConnection
	 */
	public Connection getConnection() {
	    return connection;
	}

	/**
	 * Returns Connection of current DbConnection
	 * @return Connection of current dbConnection
	 */
	public static Connection connect() {
		return dbConnection.getConnection();
	}
}