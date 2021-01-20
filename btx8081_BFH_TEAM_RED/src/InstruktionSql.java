import java.sql.*;

public class InstruktionSql {

	public Connection con = DbConnection.connect();

	private int instID;
	private String instText;
	private String instTitel;

	public void insertInstruktion() {

		String sql = "INSERT INTO instruktionen(inst_id,instruktion,inst_titel) VALUES(?,?,?)";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, instID);
			pstmt.setString(2, instText);
			pstmt.setString(3, instTitel);

			pstmt.executeUpdate();

			// pstmt.close();
			// con.commit();
			// con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void showInstruction() {
		try {

			Statement instruction_text = con.createStatement();
			ResultSet rs = instruction_text.executeQuery("SELECT * FROM instruktionen"); // in case of multiple users,
																							// complete the query
			con.setAutoCommit(false); // accordingly

			while (rs.next()) {

				int inst_ID = rs.getInt("inst_id");
				String instruction = rs.getString("instruktion");
				String titel = rs.getString("inst_Titel");

			}
			con.commit();
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void editInstruction(int ID, String newText) {

		try {

			Statement instruction_text = con.createStatement();

			String sql = "update instruktionen set instruktion = " + newText + " where inst_id =" + ID + ";";
			instruction_text.executeUpdate(sql);
			con.setAutoCommit(false);

			ResultSet rs = instruction_text.executeQuery("SELECT * FROM instruktionen where inst_id =" + ID + ";");
			int inst_ID = rs.getInt("inst_id");
			String instruction = rs.getString("instruktion");
			String titel = rs.getString("inst_Titel");

			// print instruction table
			System.out.println("ID: " + inst_ID);
			System.out.println("Titel: " + titel);
			System.out.println("instruction: " + instruction);

			// instruction_text.close();
			con.commit();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteInstruction(int ID) {
		try {
			Statement instruction_text = con.createStatement();

			String sql = "DELETE from INSTRUKTIONEN WHERE inst_id=" + ID + ";";
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
			con.commit();
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public int getInstID() {
		return instID;
	}

	public void setInstID(int instID) {
		this.instID = instID;
	}

	public String getInstText() {
		return instText;
	}

	public void setInstText(String instText) {
		this.instText = instText;
	}

	public String getInstTitel() {
		return instTitel;
	}

	public void setInstTitel(String instTitel) {
		this.instTitel = instTitel;
	}

	public InstruktionSql(int instID, String instText, String instTitel) {

		this.instID = instID;
		this.instText = instText;
		this.instTitel = instTitel;

	}

	public InstruktionSql() {

	}
}
