package view.instruction;

import java.util.ArrayList;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import view.InstructionViewInterface;

/**
 * InstructionViewImpl manages Implementation of InstructionViewInterface
 */
public class InstructionViewImpl extends VerticalLayout implements InstructionViewInterface {

    Accordion accordion = new Accordion();
    ArrayList<ArrayList<String>> instructionList = new ArrayList<ArrayList<String>>();

    public InstructionViewImpl() {
    }

	/**
	 * Adds panels according to entries in instructionList
	 */
	public void addPanels() {
    	String instructionTitle ="";
		String instructionText ="";
		for (int i = 0; i<instructionList.size(); i++ ) {
	    
	    	for (int j =0 ; j<instructionList.get(i).size(); j++) {
				instructionTitle=instructionList.get(i).get(0);
				instructionText=instructionList.get(i).get(j);
	    	}
	    
	    	accordion.add(instructionTitle, new Span(instructionText))
	    	.addThemeVariants(DetailsVariant.SMALL);
	    	this.add(accordion);
		}
    }

	/**
	 * Sets the current instructionList and adds the panels
	 * @param instructionList ArrayList<ArrayList<String>> of instruction entries
	 */
	@Override
    public void setInstructions(ArrayList<ArrayList<String>> instructionList) {
		if (instructionList.size() > 0) {
			this.instructionList = instructionList;
			addPanels();
		} else {
			//TODO: test else leer
			accordion.add("keine Einträge", new Span("keine Einträge"))
					.addThemeVariants(DetailsVariant.SMALL);
			add(accordion);
		}
    }
}


