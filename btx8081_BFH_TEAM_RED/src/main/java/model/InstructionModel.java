package model;

import java.sql.*;

public class InstructionModel {

	private int id;
	private String title;
	private String text;

	public Connection connection = DbConnection.connect();
	
	public InstructionModel(int id, String title, String text) {
		this.id = id;
		this.title = title;
		this.text = text;
	}
	
	public void saveToDB() {
		String sql = "INSERT INTO instruktionen(inst_id,instruktion,inst_titel) VALUES(?,?,?)";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, id);
			pstmt.setString(2, text);
			pstmt.setString(3, title);

			pstmt.executeUpdate();

			connection.commit();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getFromDB() {
		try {
			Statement instruction_text = connection.createStatement();
			ResultSet rs = instruction_text.executeQuery("SELECT * FROM instruktionen"); // in case of multiple users,
			// complete the query
			connection.setAutoCommit(false); // accordingly

			while (rs.next()) {

				int inst_ID = rs.getInt("inst_id");
				String instruction = rs.getString("instruktion");
				String titel = rs.getString("inst_Titel");

				// print instruction table
				System.out.println("ID: " + inst_ID);
				System.out.println("Titel: " + titel);
				System.out.println("instruction: " + instruction);

				// instruction_text.close();

			}
			connection.commit();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateInDB() {
		try {
			Statement instruction_text = connection.createStatement();

			String sql = "update instruktionen set instruktion = " + text
					+ " where inst_id =" + id + ";"; // Kein Update für Titel?
			instruction_text.executeUpdate(sql);
			connection.setAutoCommit(false);

			ResultSet rs = instruction_text.executeQuery("SELECT * FROM instruktionen"
					+ " where inst_id =" + id + ";");
			int inst_ID = rs.getInt("inst_id");
			String instruction = rs.getString("instruktion");
			String titel = rs.getString("inst_Titel");

			// print instruction table
			System.out.println("ID: " + inst_ID);
			System.out.println("Titel: " + titel);
			System.out.println("instruction: " + instruction);

			// instruction_text.close();
			connection.commit();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteFromDB() {
		try {
			Statement instruction_text = connection.createStatement();

			String sql = "DELETE from INSTRUKTIONEN WHERE inst_id=" + id + ";";
			instruction_text.executeUpdate(sql);

			ResultSet rs = instruction_text.executeQuery("SELECT * FROM instruktionen");

			while (rs.next()) {

				int inst_ID = rs.getInt("inst_id");
				String instruction = rs.getString("instruktion");
				String titel = rs.getString("inst_Titel");

				// print instruction table
				System.out.println("ID: " + inst_ID);
				System.out.println("Titel: " + titel);
				System.out.println("instruction: " + instruction);

			}
			connection.commit();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		id = 0;
		text = null;
		title = null;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "instructionModel [instructionTitle=" + title + ", instructionText=" + text + "]";
	}
}
