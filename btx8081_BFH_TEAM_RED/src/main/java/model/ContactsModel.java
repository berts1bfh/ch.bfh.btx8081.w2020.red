package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ContactsModel {
	
	public static Connection connection = DbConnection.connect();
	
	public void saveContact(int id,String name, String surname, String phone_num,String house_num, String street, String city) {
		
		try {
			

//			Statement instruction_text = connection.createStatement();
			connection.setAutoCommit(false);
		
//			String sql = "UPDATE contacts SET Name = ? , "
//	                + "Surname = ? "
//	                + "Phone_Num = ? "
//	                + "House_Num = ? "
//	                + "Street = ? "
//	                + "City = ? "
//	                + "WHERE ID = 1";
			
//			String sql = "UPDATE contacts SET Name = 'Sherlock2', Surname = 'Homes2', Phone_Num ='333 333 333', House_Num ='211b', Street ='Backer Street', City='London2' where ID = 1;";	
//			
//			PreparedStatement pstmt = connection.prepareStatement(sql);
//			
//			pstmt.setString(1, name);
//            pstmt.setString(2, surname);
//            pstmt.setString(3, phone_num);
//            pstmt.setString(4, house_num);
//            pstmt.setString(5, street);
//            pstmt.setString(6, city);
//            pstmt.setInt(7, 1); //change here the 1 for the id later after testing

			PreparedStatement pstmt = connection.prepareStatement("UPDATE contacts SET Name = '"+name+"', Surname = '"+surname+"', Phone_Num ='"+phone_num+"', House_Num ='"+house_num+"', Street ='"+street+"', City='"+city+"' where ID = 1;");
			
            pstmt.executeUpdate();
			
			connection.commit();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
//Create a array of Contacts that will be delivered to the Contact presenter.
	public ArrayList<Contact> getContactsFromDB() {

		ArrayList<Contact> contactsList = new ArrayList<>();

		try {
			connection = DbConnection.connect();
			Statement contactsInfo = connection.createStatement();
			ResultSet rs = contactsInfo.executeQuery("SELECT * FROM contacts");

			connection.setAutoCommit(false); // accordingly

			while (rs.next()) {
				Contact contact = new Contact();
				
				contact.setId(rs.getInt("ID"));
				contact.setName(rs.getString("Name"));
				contact.setSurname(rs.getString("Surname"));
				contact.setPhoneNum(rs.getString("Phone_Num"));
				contact.setHouseNum(rs.getString("House_Num"));
				contact.setStreet(rs.getString("Street"));
				contact.setCity(rs.getString("City"));

				contactsList.add(contact);

			}
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactsList;
	}
	
	
	public void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
