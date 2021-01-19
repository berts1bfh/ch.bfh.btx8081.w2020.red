package view;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.PWA;

@Route("main")
@RouteAlias("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class MainView extends VerticalLayout implements HasComponents, RouterLayout{
    private TextField displayUsername = new TextField(); 
 
    public MainView() {
	
	displayUsername.setReadOnly(true);
	add(displayUsername);

	HorizontalLayout viewLayout = new HorizontalLayout();
	VerticalLayout buttonLayout  = new VerticalLayout();

	buttonLayout.getStyle().set("border", "1px solid #94949E");
	buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
	buttonLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH);
	buttonLayout.setPadding(false);
	buttonLayout.setMargin(true);
	buttonLayout.setSpacing(false);
		
	Button buttonOpenDiary = new Button("Diary", VaadinIcon.BOOK.create());
	buttonOpenDiary.addClickListener(e-> {
	    buttonOpenDiary.getUI().ifPresent(ui -> ui.navigate("diary"));
	    buttonOpenDiary.setIconAfterText(false);
	});

	Button buttonOpenInstructions = new Button("Instructions", VaadinIcon.ANCHOR.create());
	buttonOpenInstructions.addClickListener(e-> {
	    buttonOpenInstructions.getUI().ifPresent(ui -> ui.navigate("instruction"));
	});

	Button buttonOpenEmergency = new Button("Emergency", VaadinIcon.EXCLAMATION_CIRCLE.create());
	buttonOpenEmergency.addClickListener(e-> {
	    buttonOpenEmergency.getUI().ifPresent(ui -> ui.navigate("emergency"));
	});
	
	Button buttonOpenContacts = new Button("Contacts", VaadinIcon.USERS.create());
	buttonOpenContacts.addClickListener(e-> {
	    buttonOpenContacts.getUI().ifPresent(ui -> ui.navigate("contacts"));
	});

	buttonOpenDiary.setIconAfterText(true);
	buttonOpenInstructions.setIconAfterText(true);
	buttonOpenEmergency.setIconAfterText(true);
	buttonOpenContacts.setIconAfterText(true);
	
	buttonLayout.add(buttonOpenDiary,buttonOpenInstructions,buttonOpenContacts,buttonOpenEmergency);
	viewLayout.add(buttonLayout);
	add(viewLayout);
    }
}
