package view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.grid.FooterRow;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.grid.editor.Editor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.router.Route;

import model.InstructionModel;
import presenter.InstructionMgmtPresenter;


import java.util.*;


@Route("InstructionMgmtView")
public class InstructionMgmtView  extends VerticalLayout implements InstructionMgmtViewInterface {

    InstructionMgmtPresenter presenter;
    private ArrayList<InstructionModel> instructions;

    public InstructionMgmtView() {

	presenter = new InstructionMgmtPresenter(this);
	presenter.setInstructions();

	Div validationStatus = new Div();
	validationStatus.getStyle().set("color", "Red");
	validationStatus.setId("validation");
	add(validationStatus);
	
	Grid<InstructionModel> grid = new Grid<>();
	grid.setItems(instructions);
	Grid.Column<InstructionModel> titelColumn = grid.addColumn(InstructionModel::getTitle).setHeader("Titel");
	Grid.Column<InstructionModel> textColumn = grid.addColumn(InstructionModel::getText).setHeader("Text");

	Button addButton = new Button("Add Item", event -> {
	    InstructionModel newModel = new InstructionModel(99999, "X", "Y");
	    presenter.addNewModel(newModel);
	    instructions.add(newModel);
	    grid.getDataProvider().refreshAll();
	});

	Button removeButton = new Button("Remove last", event -> {
	    InstructionModel lastModel = instructions.get(instructions.size() -1);
	    presenter.deleteModel(lastModel);
	    instructions.remove(instructions.size() - 1);
	    grid.getDataProvider().refreshAll();
	});

	FooterRow footerRow = grid.appendFooterRow();
	footerRow.getCell(titelColumn).setComponent(addButton);
	footerRow.getCell(textColumn).setComponent(removeButton);

	add(grid,addButton,removeButton);

	Binder<InstructionModel> binder = new Binder<>(InstructionModel.class);
	Editor<InstructionModel> editor = grid.getEditor();
	editor.setBinder(binder);
	editor.setBuffered(true);

	TextField titleField = new TextField();
	binder.forField(titleField)
	.withValidator(new StringLengthValidator("Title length must be between 1 and 10.", 1, 10))
	.withStatusLabel(validationStatus).bind("title");
	titelColumn.setEditorComponent(titleField);

	TextField textField = new TextField();
	binder.forField(textField)
	.withValidator(new StringLengthValidator("Text length must be between 1 and 300.", 1, 300))
	.withStatusLabel(validationStatus).bind("text");
	textColumn.setEditorComponent(textField);


	Collection<Button> editButtons = Collections
		.newSetFromMap(new WeakHashMap<>());

	Column<InstructionModel> editorColumn = grid.addComponentColumn(instruction -> {
	    Button edit = new Button("Edit");
	    edit.addClassName("edit");
	    edit.addClickListener(e -> {
		editor.editItem(instruction);
		titleField.focus();
	    });
	    edit.setEnabled(!editor.isOpen());
	    editButtons.add(edit);
	    return edit;
	});

	editor.addOpenListener(e -> editButtons.stream()
		.forEach(button -> button.setEnabled(!editor.isOpen())));
	editor.addCloseListener(e -> editButtons.stream()
		.forEach(button -> button.setEnabled(!editor.isOpen())));

	Button save = new Button("Save", e -> editor.save());
	save.addClassName("save");

	Button cancel = new Button("Exit", e -> editor.cancel());
	cancel.addClassName("cancel");

	grid.getElement().addEventListener("keyup", event -> editor.cancel())
	.setFilter("event.key === 'Escape' || event.key === 'Esc'");

	Div buttons = new Div(save, cancel);
	editorColumn.setEditorComponent(buttons);

	Label message = new Label("-");

	editor.addSaveListener(
		event -> 
		{message.setText(event.getItem().toString() + ", "
			+ event.getItem().toString());
		presenter.updateModel();
		}
		);

	Button back = new Button("Back", VaadinIcon.LEVEL_LEFT.create());
	back.addClickListener(e -> {
	    back.getUI().ifPresent(ui -> ui.navigate("instruction"));
	}
		);
	add(back);

    }
    @Override
    public void setInstructions(ArrayList<InstructionModel> instructionList) {
	this.instructions = instructionList;
    }

    @Override
    public ArrayList<InstructionModel> getInstructions() {
	return this.instructions;
    }
}




