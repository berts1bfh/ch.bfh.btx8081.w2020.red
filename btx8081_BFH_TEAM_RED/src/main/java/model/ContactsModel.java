package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ContactsModel {

	public static Connection connection = DbConnection.connect();

	public void saveContact(String id, String name, String surname, String phone_num, String house_num, String street,
			String city) {

		try {

			connection.setAutoCommit(false);

			PreparedStatement pstmt = connection.prepareStatement("UPDATE contacts SET Name = '" + name
					+ "', Surname = '" + surname + "'," + " Phone_Num ='" + phone_num + "', House_Num ='" + house_num
					+ "', Street ='" + street + "', City='" + city + "' where ID = '" + id + "';");

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

				contact.setId(rs.getString("ID"));
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

			e.printStackTrace();
		}

	}

}
