package presenter;

import view.InstructionMgmtViewInterface;
import view.InstructionViewInterface;

import java.util.ArrayList;

import model.InstructionModel;

public class InstructionMgmtPresenter {

    private ArrayList<InstructionModel> models;
    InstructionMgmtViewInterface view;

    /**
     * Handles InstructionModel and InstructionMgmtView
     * @param view InstructionViewInterface
     */
    public InstructionMgmtPresenter(InstructionMgmtViewInterface view) {
        this.models = InstructionModel.getInstructionsFromDB();
	    this.view = view;
    }

    /**
     * Returns instruction data as an ArrayList from InstructionModel
     * @return ArrayList<> of instructions
     */
    private ArrayList<InstructionModel> getInstructions() {
        return models;
    }

    /**
     * Sets instructions from InstructionModel on InstructionView
     */
    public void setInstructions() {
	    view.setInstructions(getInstructions());
    }

    /**
     * Updates InstructionModel based on changes in view
     */
    public void updateModel() {
        for (InstructionModel model : view.getInstructions()) {
            model.updateInDB();
        }
    }

    /**
     * Updates a specific InstructionModel based on id
     * @param id id of model to be updated
     */
    public void updateModel(int id) { // TODO: Use model list from presenter only
        InstructionModel modelToUpdate = models.get(id);
        InstructionModel modelFromView = view.getInstructions().get(id);
        modelToUpdate.setTitle(modelFromView.getTitle());
        modelToUpdate.setText(modelFromView.getText());
        modelToUpdate.updateInDB();
    }

}
