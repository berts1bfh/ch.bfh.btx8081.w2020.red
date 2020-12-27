package model;

import java.sql.*;
import java.util.ArrayList;

/**
 * InstructionModel contains and loads Instructions
 */
public class InstructionModel {

	private int id;
	private String title;
	private String text;

	public static Connection connection = DbConnection.connect();
	
	public InstructionModel(int id, String title, String text) {
		this.id = id;
		this.title = title;
		this.text = text;
	}

	/**
	 * Returns InstructionModel for each instruction found in DB
	 * @return ArrayList<InstructionModel> of all instructions in DB
	 */
	public static ArrayList<InstructionModel> getInstructionsFromDB() {
		ArrayList<InstructionModel> models = new ArrayList<>();
		try {
			connection = DbConnection.connect();
			Statement instruction_text = connection.createStatement();
			ResultSet rs = instruction_text.executeQuery("SELECT * FROM instruktionen"); // in case of multiple users,
			// complete the query
			connection.setAutoCommit(false); // accordingly

			while (rs.next()) {

				int inst_ID = rs.getInt("inst_id");
				String instruction = rs.getString("instruktion");
				String inst_titel = rs.getString("inst_Titel");
				models.add(new InstructionModel(inst_ID, inst_titel, instruction));

				// print instruction table
				System.out.println("ID: " + inst_ID);
				System.out.println("Titel: " + inst_titel);
				System.out.println("instruction: " + instruction);

				// instruction_text.close();

			}
			connection.commit();
			// connection.close(); with Singleton pattern: Single close on leaving / ending?
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return models;
	}

	/**
	 * Saves instruction to DB
	 */
	public void saveToDB() {
		// TODO: Inst_id should be auto-increment!
		String sql = "INSERT INTO instruktionen(inst_id,instruktion,inst_titel) VALUES(?,?,?)";
		try {
			connection = DbConnection.connect();
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

	/**
	 * Loads / gets the data for instruction with id from the DB
	 */
	public void getFromDB() {
		try {
			connection = DbConnection.connect();
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

	/**
	 * Updates entry for current instruction in the DB
	 */
	public void updateInDB() {
		try {
			connection = DbConnection.connect();
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
			// connection.close(); not with DbConnection singleton pattern

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteFromDB() {
		try {
			connection = DbConnection.connect();
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
		return "InstructionModel [id=" + id + ", title=" + title + ", text=" + text + "]";
	}
}
