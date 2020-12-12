package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Makes DB Connection
 */
public class DbConnection {

	public static final String DB_URL = "jdbc:sqlite:src/acadiaDB.db";

	public static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(DB_URL);
			connection.setAutoCommit(false);																				// database
			System.out.println("Connected!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e + "");
		}

		return connection;
	}
}