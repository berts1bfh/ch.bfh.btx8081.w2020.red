package view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import model.CalculatorModel;
import presenter.CalculatorPresenter;

@Route("calculator")
public class CalculatorView extends VerticalLayout {

    public CalculatorView() {

	CalculatorModel model = new CalculatorModel();
	CalculatorViewImpl view = new CalculatorViewImpl();

	new CalculatorPresenter(model, view);

	add(view); 
    }
}
