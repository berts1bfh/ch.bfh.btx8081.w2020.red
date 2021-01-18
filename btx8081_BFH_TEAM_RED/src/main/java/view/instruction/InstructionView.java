package view.instruction;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import presenter.InstructionPresenter;

/**
 * InstructionView manages view of Instructions
 */
@Route("instruction")
public class InstructionView  extends VerticalLayout{

    Span viewTitle = new Span("Instruktionen");
    InstructionPresenter presenter;

    public InstructionView() {
	InstructionViewImpl view = new InstructionViewImpl();
	presenter = new InstructionPresenter(view);
	view.setInstructions(presenter.getInstructions());

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

	Button back = new Button("Back", VaadinIcon.LEVEL_LEFT.create());
	back.addClickListener(e -> {
	    back.getUI().ifPresent(ui -> ui.navigate("main"));
	}
		);
	add(back);
    }
}
