package view;

import java.util.ArrayList;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import model.Contact;
import presenter.ContactsPresenter;

@Route("emergency")

public class buttonView extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	ArrayList<Contact> contactObjs = new ArrayList<>();
	public ContactsPresenter contactPresenter = new ContactsPresenter();

	String contact1 = contactPresenter.getContactsInfo().get(1) + " " + contactPresenter.getContactsInfo().get(2);
	String contact2 = contactPresenter.getContactsInfo().get(8) + " " + contactPresenter.getContactsInfo().get(9);
	String contact3 = contactPresenter.getContactsInfo().get(15) + " " + contactPresenter.getContactsInfo().get(16);

	public void calling() throws InterruptedException {
		Notification notification1 = new Notification("Calling " + contact1 + ". Please hold...", 7000);
//	Notification notification2 = new Notification("Calling "+contact2+". Please hold...", 7000);
//	Notification notification3 = new Notification("Calling "+contact3+". Please hold...", 7000);

		notification1.setPosition(Position.MIDDLE);
		notification1.open();
//	notification2.setPosition(Position.MIDDLE);
//	notification2.open();
//	notification3.setPosition(Position.MIDDLE);
//	notification3.open();

	}

	public VerticalLayout showEmergencyContacts() {

		contactObjs = contactPresenter.getContactsObj();

		VerticalLayout layout = new VerticalLayout();

		// Info order in the array (name,surName,phone,street,houseNum,city);

		for (Contact Contact : contactObjs) {
			Label name = new Label("Contact name: " + Contact.getName() + " " + Contact.getSurname());
			layout.add(name);
			layout.getStyle().set("border", "3px solid #94949E");

		}
		return layout;

	}

	
	public buttonView() {

		Image image = new Image("https://medicalalertsystemshq.com/wp-content/uploads/2019/09/red-panic-button.png",
				"Button image");

		image.addClickListener(e -> {
			try {
				calling();
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
		});

		
//		back button
		Button back = new Button("Back", VaadinIcon.LEVEL_LEFT.create());
		back.addClickListener(e -> {
			back.getUI().ifPresent(ui -> ui.navigate("main"));

		});
		add(image, showEmergencyContacts(),back);

	}

}
