package view;

import java.util.ArrayList;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import model.Contact;
import presenter.ContactsPresenter;

@Route("contacts")

public class ContactsView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	ArrayList<Contact> contactObjs = new ArrayList<>();
	public ContactsPresenter contactPresenter = new ContactsPresenter();
	int index = 1;

	public void showContacts() {

//		Info order in the array (name,surName,phone,street,houseNum,city);
		for (Contact Contact : contactObjs) {
			VerticalLayout layout = new VerticalLayout();

//			using TextField as a #Marker that will be used as Db ID in the edit/saving process
			TextField ContactNumber = new TextField();
			ContactNumber.setValue(String.valueOf(index));

			Label name = new Label("Name: " + Contact.getName() + " " + Contact.getSurname());
			Label phone = new Label("Phone Number: " + Contact.getPhoneNum());
			Label address = new Label("Address: " + Contact.getStreet() + ", number " + Contact.getHouseNum() + ", "
					+ Contact.getCity() + ".");

			System.out.println(ContactNumber.getValue());

			Button edit = new Button("Edit ", VaadinIcon.USERS.create());
			edit.addClickListener(e -> {

				
				editContact(ContactNumber.getValue(), contactPresenter);

			});

			layout.add(name, phone, address, edit);
			layout.getStyle().set("border", "3px solid #94949E");

			this.add(layout);
			index++;

		}

	}

	private void clearCanvas() {
		this.removeAll();
	}

	public void editContact(String id, ContactsPresenter presenter) {

		int ArrayIndex = Integer.parseInt(id) - 1;
		clearCanvas();

		VerticalLayout layout = new VerticalLayout();

		TextField name_ = new TextField("Name", contactObjs.get(ArrayIndex).getName());
		TextField surname = new TextField("Surname", contactObjs.get(ArrayIndex).getSurname());
		TextField phoneNum = new TextField("Phone", contactObjs.get(ArrayIndex).getPhoneNum());
		TextField street = new TextField("Street", contactObjs.get(ArrayIndex).getStreet());
		TextField houseNum = new TextField("Home number", contactObjs.get(ArrayIndex).getHouseNum());
		TextField city = new TextField("City", contactObjs.get(ArrayIndex).getCity());

		Button save = new Button("Save", VaadinIcon.USERS.create());
		save.addClickListener(e -> {

			Contact editedContact = new Contact(id, name_.getValue(), surname.getValue(), phoneNum.getValue(),
					street.getValue(), houseNum.getValue(), city.getValue());
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

		HorizontalLayout buttons = new HorizontalLayout();
		buttons.add(save,back);
		this.add(layout, buttons);

	}

	public ContactsView() {

		contactObjs = contactPresenter.getContactsObj();

//		back button
		Button back = new Button("Back", VaadinIcon.LEVEL_LEFT.create());
		back.addClickListener(e -> {
			back.getUI().ifPresent(ui -> ui.navigate("main"));

		});

		add(new Text("Contact Information"));

//		showContacts(contactsInfo,this);
		showContacts();

		add(back);

	}

}
