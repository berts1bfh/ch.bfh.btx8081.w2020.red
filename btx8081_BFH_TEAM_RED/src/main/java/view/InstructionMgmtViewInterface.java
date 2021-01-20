package view;

import model.InstructionModel;

import java.util.ArrayList;

/**
 * Interface for InstructionMgmtView
 * TODO: Probably should use same naming conventions as InstructionView & InstructionViewImp
 */
public interface InstructionMgmtViewInterface {

    /**
     * Sets the instruction list for view
     * @param instructionList list of instructions for view
     */
    void setInstructions(ArrayList<InstructionModel> instructionList);

    /**
     * Returns the instruction list from the view
     * @return ArrayList<InstructionModel> list of instructions from view
     */
    ArrayList<InstructionModel> getInstructions();
}
