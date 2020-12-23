package presenter;

import view.InstructionViewInterface;

import java.util.ArrayList;
import java.util.List;

import model.InstructionModel;

public class InstructionMgmtPresenter {

    // InstructionModel model;
    InstructionViewInterface view;

    /**
     * Handles InstructionModel and InstructionMgmtView
     * @param view InstructionViewInterface
     */
    public InstructionMgmtPresenter(InstructionViewInterface view) {
	this.view = view;
    }

    /**
     * Returns instruction data as an ArrayList from InstructionModel
     * @return ArrayList<> of instructions
     */
    private ArrayList<ArrayList<String>> getInstructions() {
	// get from model, return
	return new ArrayList<>();
    }

    /**
     * Sets instructions from InstructionModel on InstructionView
     */
    public void setInstructions() {
	ArrayList<ArrayList<String>> instructions = getInstructions();
	view.setInstructions(instructions);
    }

    /**
     * Updates InstructionModel based on changes in view
     */
    public void updateModel() {
	// TODO: Implement onClick ?
    }


}
