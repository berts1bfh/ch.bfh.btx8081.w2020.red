package view;

import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;


/**
 * The main view contains a button and a click listener.
 */
@Route("main")
@RouteAlias("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")

public class MainView extends VerticalLayout implements HasComponents, RouterLayout{

    public MainView() {
	
	//Menu Darstellung
	VerticalLayout menu = new VerticalLayout();
	menu.add(new RouterLink("calulator", CalculatorView.class));
	Anchor anchorWiki = new Anchor("https://wikipedia.com", "Wikipedia");
	menu.add(anchorWiki);
	add(menu);
	
	//Button Darstellung
	Button buttonOpenCalculator = new Button("Open Calculator");
	buttonOpenCalculator.addClickListener(e-> {
	    buttonOpenCalculator.getUI().ifPresent(ui -> ui.navigate("calculator"));
	});
	add(buttonOpenCalculator);

	Button buttonOpenDiary = new Button("Open Diary");
	buttonOpenCalculator.addClickListener(e-> {
	    buttonOpenCalculator.getUI().ifPresent(ui -> ui.navigate("diary"));
	});
	add(buttonOpenDiary);

	Button buttonOpenInstructions = new Button("Open Instruction");
	buttonOpenCalculator.addClickListener(e-> {
	    buttonOpenCalculator.getUI().ifPresent(ui -> ui.navigate("instruction"));
	});
	add(buttonOpenInstructions);
	
	Button buttonOpenEmergency = new Button("Open Emergency");
	buttonOpenCalculator.addClickListener(e-> {
	    buttonOpenCalculator.getUI().ifPresent(ui -> ui.navigate("emergency"));
	});
	add(buttonOpenEmergency);




    }
}
