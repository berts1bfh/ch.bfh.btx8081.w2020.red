package view;

import java.util.ArrayList;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import model.Contact;
import presenter.ContactsPresenter;

@Route("contacts")

public class ContactsView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	ArrayList<Contact> contactObjs = new ArrayList<>();
	public int index = 1;
	public ContactsPresenter contactPresenter = new ContactsPresenter();

	public void showContacts() {

//		Info order in the array (name,surName,phone,street,houseNum,city);
		for (Contact Contact : contactObjs) {
			VerticalLayout layout = new VerticalLayout();

			Label name = new Label("Name: " + Contact.getName() + " " + Contact.getSurname());
			Label phone = new Label("Phone Number: " + Contact.getPhoneNum());
			Label address = new Label("Address: " + Contact.getStreet() + ", number " + Contact.getHouseNum() + ", "
					+ Contact.getCity() + ".");

			Button edit = new Button("Edit", VaadinIcon.USERS.create());
			edit.addClickListener(e -> {

				editContact(index, contactPresenter);

			});

			layout.add(name, phone, address, edit);
			layout.getStyle().set("border", "3px solid #94949E");

			this.add(layout);
		}

	}

	private void clearCanvas() {
		this.removeAll();
	}

	public void editContact(int id, ContactsPresenter presenter) {

		clearCanvas();

		VerticalLayout layout = new VerticalLayout();

		TextField name_ = new TextField();
		TextField surname = new TextField();
		TextField phoneNum = new TextField();
		TextField street = new TextField();
		TextField houseNum = new TextField();
		TextField city = new TextField();
		
//		Set placeholders ( text inside the textfields)
		name_.setPlaceholder(contactObjs.get(1).getName());
		surname.setPlaceholder(contactObjs.get(1).getSurname());
		phoneNum.setPlaceholder(contactObjs.get(1).getPhoneNum());
		street.setPlaceholder(contactObjs.get(1).getStreet());
		houseNum.setPlaceholder(contactObjs.get(1).getHouseNum());
		city.setPlaceholder(contactObjs.get(1).getCity());
		
		
		Button save = new Button("Save", VaadinIcon.USERS.create());
		save.addClickListener(e -> {
			
			Contact editedContact = new Contact(name_.getValue(), surname.getValue(), phoneNum.getValue(), street.getValue(), houseNum.getValue(), city.getValue());
			presenter.editDbContact(editedContact);
			clearCanvas();
			showContacts();
			getUI().ifPresent(ui -> UI.getCurrent().getPage().reload());

		});

		layout.add(name_, surname, phoneNum, street, houseNum, city);
		layout.getStyle().set("border", "3px solid #94949E");

		Button back = new Button("Back", VaadinIcon.LEVEL_LEFT.create());
		back.addClickListener(e -> {
			clearCanvas();
			showContacts();
			getUI().ifPresent(ui -> UI.getCurrent().getPage().reload());
			
		});
		
		this.add(layout, save, back);

	}

	public ContactsView() {

		contactObjs = contactPresenter.getContactsObj();

//		back button
		Button back = new Button("Back", VaadinIcon.LEVEL_LEFT.create());
		back.addClickListener(e -> {
			back.getUI().ifPresent(ui -> ui.navigate("main"));
			
		});

		add(new Text("Contact infos"));

//		showContacts(contactsInfo,this);
		showContacts();

		add(back);

	}

}
