package view;

import java.util.ArrayList;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;



public class InstructionViewImpl extends VerticalLayout {
    Accordion accordion = new Accordion();
    ArrayList<ArrayList<String>> tupelFromDB = new ArrayList<ArrayList<String>>();


    public InstructionViewImpl() {

	//hartcodierte test einträge
	ArrayList<String> eintrag1 = new ArrayList<String>();
	eintrag1.add("this should be title1");
	eintrag1.add("this should be text1");
	ArrayList<String> eintrag2 = new ArrayList<String>();
	eintrag2.add("this should be title2");
	eintrag2.add("this should be text2");
	
	tupelFromDB.add(eintrag1);
	tupelFromDB.add(eintrag2);
	
	
	
	if (tupelFromDB.size() > 0) {
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
	for (int i = 0; i<tupelFromDB.size(); i++ ) { 
	    
	    for (int j =0 ; j<tupelFromDB.get(i).size(); j++) {
		instructionTitle=tupelFromDB.get(i).get(0);
		instructionText=tupelFromDB.get(i).get(j);
	    } 
	    
	    accordion.add(instructionTitle, new Span(instructionText))
	    .addThemeVariants(DetailsVariant.SMALL);
	    this.add(accordion);         
	}
    }
}


