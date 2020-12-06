package view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.editor.Editor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.router.Route;
import model.User;


@Route("InstructionMgmtView")
public class InstructionMgmtView  extends VerticalLayout{//implements InstructionViewInterface{
    //TODO : 2D-Array nicht brauchen hier: passt konzeptionell hier nicht, nicht so wie in InstructionView
    //ArrayList<ArrayList<String>> localInstructionList;
    // ArrayList<ArrayList<String>> instructionList = new  ArrayList<ArrayList<String>>(localInstructionList);

    //TODO: alle User mit Instruktionen-Klasse ersetzen, welche die Instruktionen hat.


    public InstructionMgmtView() {

	//TODO: Hardcodierte Test löschen
	List<User> userList = new ArrayList<>();
	userList.add(new User("Hansi" , "Leimbauer"));
	userList.add(new User("Emanuel", "Rund"));

	//Tabelle mit Spalten.  
	//https://vaadin.com/docs/flow/components/tutorial-flow-grid.html
	Grid<User> grid = new Grid<>();
	grid.setItems(userList);
	Grid.Column<User> titelColumn = grid.addColumn(User::toString).setHeader("Instruktion Titel");
	Grid.Column<User> textColumn = grid.addColumn(User::toString).setHeader("Instruktion Text");

	add(grid);



	/*
	 * https://vaadin.com/components/vaadin-grid/java-examples
	 * ist fast gleiches wie oben, aber nur Rest ab Binder<User> binder = new Binder<>(User.class); übernommem: 
	Grid<Person> grid = new Grid<>();
	List<Person> persons = getItems();
	grid.setItems(persons);
	Grid.Column<Person> firstNameColumn = grid.addColumn(Person::getFirstName).setHeader("First Name");
	Grid.Column<Person> ageColumn = grid.addColumn(Person::getAge).setHeader("Age");

	 */
	Binder<User> binder = new Binder<>(User.class);
	Editor<User> editor = grid.getEditor();
	editor.setBinder(binder);
	editor.setBuffered(true);

	Div validationStatus = new Div();
	validationStatus.setId("validation");

	/*
	 // TODO Wie kann ich Textfeld öffnen zur Bearbeitung von Instruktionen?
	 * Hier wird wohl der Textfield zur Änderung der Instruktion gemacht. 
	  //Probleme:  Bean Handler User Exception?
	TextField firstNameField = new TextField();
	binder.forField(firstNameField)
	        .withValidator(new StringLengthValidator("First name length must be between 3 and 50.", 3, 50))
	        .withStatusLabel(validationStatus).bind("firstName");
	titelColumn.setEditorComponent(firstNameField);
	 */
	/*
	TextField ageField = new TextField();
	binder.forField(ageField)
	        .withConverter(
	                new StringToIntegerConverter("Age must be a number."))
	        .withStatusLabel(validationStatus).bind("age");
	textColumn.setEditorComponent(ageField);
	 */

	Collection<Button> editButtons = Collections
		.newSetFromMap(new WeakHashMap<>());

	Grid.Column<User> editorColumn = grid.addComponentColumn(person -> {
	    Button edit = new Button("Edit");
	    edit.addClassName("edit");
	    edit.addClickListener(e -> {
		editor.editItem(person);
		//  firstNameField.focus();
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

	//try and error: wegen message
	Label message = new Label("-");

	editor.addSaveListener(
		event -> message.setText(event.getItem().toString() + ", "
			+ event.getItem().toString()));
	add(validationStatus, grid);

    }
}




