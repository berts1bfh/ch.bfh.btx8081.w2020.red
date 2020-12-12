package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Reference / template Model for User
 * User may replace this later on
 */
public class UserSql {
	public Connection connection = DbConnection.connect();

	private int userId;
	private String first_name;
	private String last_Name;
	private String gbDate;
	private String Password;

	//Inster user in the database
	public void insertUser() {

		String sql = "INSERT INTO user(id,first_name,last_Name,gbDatum,password) VALUES(?,?,?,?,?)";

		try {
			connection = DbConnection.connect();
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, userId);
			pstmt.setString(2, first_name);
			pstmt.setString(3, last_Name);
			pstmt.setString(4, gbDate);

			pstmt.setString(5, Password);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public UserSql(int userId, String first_name, String last_Name, String gbDate, String Password) {
		this.userId = userId;
		this.first_name = first_name;
		this.last_Name = last_Name;
		this.gbDate = gbDate;
		this.Password = Password;
	}

}
