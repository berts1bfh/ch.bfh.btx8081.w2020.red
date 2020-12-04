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
	
	
	//TODO: InstructionModel model = new InstructionModel();
	InstructionViewImpl view = new InstructionViewImpl();
	
	//TODO: new InstructionPresenter(model, view);

	VerticalLayout v1 = new VerticalLayout();
	VerticalLayout v2 = new VerticalLayout();
	
	v2.getStyle().set("border", "1px solid #94949E");
	v2.add(view); 
	v1.add(viewTitle);
	v1.add(v2); 
	add(v1);
	
	Button buttonOpenInstrictionAddView = new Button("bearbeiten", VaadinIcon.EDIT.create());
	buttonOpenInstrictionAddView.addClickListener(e-> {
	    buttonOpenInstrictionAddView.getUI().ifPresent(ui -> ui.navigate("InstructionMgmtView"));
	    buttonOpenInstrictionAddView.setIconAfterText(false);
	});
	add(buttonOpenInstrictionAddView);
	
    }

}
