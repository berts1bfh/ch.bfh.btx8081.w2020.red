package view;

import model.InstructionModel;

import java.util.ArrayList;

public interface InstructionMgmtViewInterface {

    public void setInstructions(ArrayList<InstructionModel> instructionList);

    public ArrayList<InstructionModel> getInstructions();
}
