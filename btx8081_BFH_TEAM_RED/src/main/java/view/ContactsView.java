package view;

import java.util.ArrayList;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import model.Contact;
import presenter.ContactsPresenter;

@Route("contacts")

public class ContactsView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	
	ArrayList<Contact> contactObjs = new ArrayList<>();
	

	
	public void showContacts(ArrayList<Contact> contacts, VerticalLayout vlayout) {
	
	
		for (Contact Contact : contacts) {
		VerticalLayout layout =new VerticalLayout();
		
		Label name = new Label("Name: "+ Contact.getName()+" "+ Contact.getSurname());
		Label phone = new Label("Phone Number: "+ Contact.getPhoneNum());
		Label address = new Label("Address: "+ Contact.getStreet()+", number "+Contact.getHouseNum()+", "+Contact.getCity()+".");
		
		Button edit = new Button("Edit", VaadinIcon.USERS.create());
		edit.addClickListener(e-> {
		    edit.getUI().ifPresent(ui -> ui.navigate("edit"));
		});
		
		
		layout.add(name,phone,address, edit);
		layout.getStyle().set("border", "3px solid #94949E");
		
		vlayout.add(layout);
		}
		
		
	
		
	}
	
	
	
	public ContactsView() {
		
		ContactsPresenter contactPresenter = new ContactsPresenter();
		contactObjs = contactPresenter.getContactsObj();

		// (name,surName,phone,street,houseNum,city);
		add(new Text("Contact infos"));

//		showContacts(contactsInfo,this);
		showContacts(contactObjs,this);
		
	}

}
