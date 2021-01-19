package presenter;

import java.util.ArrayList;
import model.Contact;
import model.ContactsModel;

public class ContactsPresenter {

	private ArrayList<Contact> contacts;
	public ContactsModel contactModel = new ContactsModel();

	public ContactsPresenter() {

		contacts = contactModel.getContactsFromDB();

	}

//	Take the information in the contacts array and transfer the info from all contacts to an array of strings.
	public ArrayList<String> getContactsInfo() {

		ArrayList<String> contactInfos = new ArrayList<>();

		for (Contact Contact : contacts) {
			contactInfos.add(Contact.getId());
			contactInfos.add(Contact.getName());
			contactInfos.add(Contact.getSurname());
			contactInfos.add(Contact.getPhoneNum());
			contactInfos.add(Contact.getHouseNum());
			contactInfos.add(Contact.getStreet());
			contactInfos.add(Contact.getCity());

		}
		return contactInfos;
	}

//	return a array the contacts objects
	public ArrayList<Contact> getContactsObj() {
		return contacts;

	}

//	pass the contact object to the contact model
	public void editDbContact(Contact contact) {
		contactModel.saveContact(contact.getId(), contact.getName(), contact.getSurname(), contact.getPhoneNum(),
				contact.getHouseNum(), contact.getStreet(), contact.getCity());
	}

}
