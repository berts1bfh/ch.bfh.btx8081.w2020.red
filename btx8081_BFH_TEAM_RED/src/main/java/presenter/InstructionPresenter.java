package presenter;

import view.InstructionView;
import view.InstructionViewInterface;

import java.util.ArrayList;

/**
 * Gets data from InstructionModel and sets instructions for InstructionView
 */
public class InstructionPresenter {

    // InstructionModel model;
    InstructionViewInterface view;

    /**
     * Handles InstructionView and InstructionModel data
     * @param view InstructionViewInterface
     */
    public InstructionPresenter(InstructionViewInterface view) {
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
}
