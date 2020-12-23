package view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.grid.editor.Editor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.router.Route;

import model.InstructionModel;


import java.util.*;


@Route("InstructionMgmtView")
public class InstructionMgmtView  extends VerticalLayout{//implements InstructionViewInterface{

    public InstructionMgmtView() {

	
	//Diese 3 Zeilen gemacht für Test.
	ArrayList<InstructionModel> instructionsTestList = new ArrayList<>();
	instructionsTestList.add(new InstructionModel(1, "title1", "text1"));
	instructionsTestList.add(new InstructionModel(1, "title2", "text2"));

	//https://vaadin.com/components/vaadin-grid/java-examples 
	Grid<InstructionModel> grid = new Grid<>();
	List<InstructionModel> instructions = instructionsTestList;  //getItems(); <--------- musste hardcoden. Wäre getItems() vom Interface?
	grid.setItems(instructions);
	Grid.Column<InstructionModel> titelColumn = grid.addColumn(InstructionModel::getTitle).setHeader("Titel");
	Grid.Column<InstructionModel> textColumn = grid.addColumn(InstructionModel::getText).setHeader("Text");

	add(grid);

	//Data Binder ist Teil von Vaadin API, damit kann ich Java Objekte nutzen. Diese Objekte sollte wir z.B via JDBC bekommen . 
	Binder<InstructionModel> binder = new Binder<>(InstructionModel.class);
	Editor<InstructionModel> editor = grid.getEditor();
	editor.setBinder(binder);
	editor.setBuffered(true);

	Div validationStatus = new Div();
	validationStatus.setId("validation");


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

	Button cancel = new Button("Cancel", e -> editor.cancel());
	cancel.addClassName("cancel");

	// Add a keypress listener that listens for an escape key up event.
	// Note! some browsers return key as Escape and some as Esc
	grid.getElement().addEventListener("keyup", event -> editor.cancel())
	.setFilter("event.key === 'Escape' || event.key === 'Esc'");

	Div buttons = new Div(save, cancel);
	editorColumn.setEditorComponent(buttons);

	Label message = new Label("-");

	editor.addSaveListener(
		event -> message.setText(event.getItem().toString() + ", "
			+ event.getItem().toString()));
	add(validationStatus, grid);
    }
}




