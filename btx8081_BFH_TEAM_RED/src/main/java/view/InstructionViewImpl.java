package view;

import java.util.ArrayList;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;



public class InstructionViewImpl extends VerticalLayout implements InstructionViewInterface {
    Accordion accordion = new Accordion();
    ArrayList<ArrayList<String>> instructionList = new ArrayList<ArrayList<String>>();


    public InstructionViewImpl() {

	//hartcodierte Test:
	/*
	ArrayList<String> eintrag1 = new ArrayList<String>();
	eintrag1.add("this should be title1");
	eintrag1.add("this should be text1");
	ArrayList<String> eintrag2 = new ArrayList<String>();
	eintrag2.add("this should be title2");
	eintrag2.add("this should be text2");
	tupelFromDB.add(eintrag1);
	tupelFromDB.add(eintrag2);
	*/
	
	
	if (instructionList.size() > 0) {
	    addPanels();
	}else {
	   //TODO: test else leer
	    accordion.add("keine Einträge", new Span("keine Einträge"))
	    .addThemeVariants(DetailsVariant.SMALL);
	    add(accordion);
	}
    }

    
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


    @Override
    public void setInstructions(ArrayList<ArrayList<String>> instructionList) {
	// TODO Auto-generated method stub
	
    }
}


