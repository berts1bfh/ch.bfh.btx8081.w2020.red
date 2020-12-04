package view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;



@Route("instruction")
public class InstructionView  extends VerticalLayout{
    
    
    public InstructionView() {


	//TODO: InstructionModel model = new InstructionModel();
	InstructionViewImpl view = new InstructionViewImpl();

	//TODO: new InstructionPresenter(model, view);

	add(view); 
    }

}
