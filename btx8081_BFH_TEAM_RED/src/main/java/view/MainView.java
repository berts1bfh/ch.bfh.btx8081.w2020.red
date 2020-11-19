package view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import model.CalculatorModel;
import presenter.CalculatorPresenter;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")

public class MainView extends VerticalLayout {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainView() {
        
    	// Create the model and the Vaadin view implementation
    	CalculatorModel model = new CalculatorModel();
    	CalculatorViewImpl view = new CalculatorViewImpl();
    	// The presenter connects the model and view
    	new CalculatorPresenter(model, view);
    	// The view implementation is a Vaadin component
    	add(view); 
    	
    	
 
    	
    	
    }
}
