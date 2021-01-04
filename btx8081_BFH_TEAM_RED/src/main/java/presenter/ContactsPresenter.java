package presenter;

import java.util.ArrayList;

import model.Contact;
import model.ContactsModel;

public class ContactsPresenter {

	public ArrayList<Contact> contacts;

	public ContactsPresenter() {
		
		ContactsModel cmodel = new ContactsModel();
		contacts = cmodel.getContactsFromDB();

	}

//	Take the information in the contacts array and tranSfer the info from all contacts to an array of strings.
	public ArrayList<String> getContactsInfo() {

		ArrayList<String> contactInfos = new ArrayList<>();

		for (Contact Contact : contacts) {
			contactInfos.add(Contact.getName());
			contactInfos.add(Contact.getSurname());
			contactInfos.add(Contact.getPhoneNum());
			contactInfos.add(Contact.getHouseNum());
			contactInfos.add(Contact.getStreet());
			contactInfos.add(Contact.getCity());

		}
		return contactInfos;
	}

}