package view;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;



@Route("instruction")
public class InstructionView  extends VerticalLayout{
    
    Span viewTitle = new Span("Instruktionen");

    public InstructionView() {
	
	
	InstructionViewImpl view = new InstructionViewImpl();
	//TODO: InstructionModel model = new InstructionModel(); //fehlt noch Model
	
	//TODO: new InstructionPresenter(model, view); // fehlt noch Model

	VerticalLayout v1 = new VerticalLayout();
	VerticalLayout v2 = new VerticalLayout();
	
	v2.getStyle().set("border", "1px solid #94949E");
	v2.add(view); 
	v1.add(viewTitle);
	v1.add(v2); 
	add(v1);
	
	Button buttonOpenInstructionMgmtView = new Button("bearbeiten", VaadinIcon.EDIT.create());
	buttonOpenInstructionMgmtView.addClickListener(e-> {
	    buttonOpenInstructionMgmtView.getUI().ifPresent(ui -> ui.navigate("InstructionMgmtView"));
	    buttonOpenInstructionMgmtView.setIconAfterText(false);
	});
	add(buttonOpenInstructionMgmtView);
	
    }

}
