package view;

import java.util.ArrayList;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import presenter.ContactsPresenter;

@Route("contacts")

public class ContactsView extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	ArrayList<String> contactsInfo = new ArrayList<>();
	
	public ContactsView() {
		ContactsPresenter contactPresenter = new ContactsPresenter();

		contactsInfo = contactPresenter.getContactsInfo();

		// (name,surName,phone,street,houseNum,city);
		add(new Text("Contact infos"));
//		add(new Text("test Should Be here"));

		for (String Information : contactsInfo) {
			add(new Text("jonnes"));
			add(new Text(Information));
		}

	}

}
