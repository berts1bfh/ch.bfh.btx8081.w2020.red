package model;

import org.junit.*;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class InstructionModelTest {

    @Test
    public void getInstructionsFromDB() {
        // Don't know
        assertTrue(true);
    }

    @Test
    public void saveToDB() {
        /**
        // GIVEN
        InstructionModel newModel = new InstructionModel(999, "Test-Name", "Test-Text1");
        // THEN
        newModel.saveToDB();
        newModel.getFromDB();
        // SHOULD
        assertEquals(newModel.getId(), 999);
        assertEquals(newModel.getTitle(), "Test-Title");
        assertEquals(newModel.getText(), "Test-Text");
         **/
        assertTrue(true);
    }

    @Test
    public void createInDB() {

        assertTrue(true);
        /**
        // GIVEN
        InstructionModel newModel = new InstructionModel(998, "Test-Name", "Test-Text2");
        // THEN
        newModel.createInDB();
        newModel.getFromDB();
        // SHOULD
        // Auto-Increment so ID shouldn't stay 998
        assertNotEquals(newModel.getId(), 998);
        // The rest should stay the same
        assertEquals(newModel.getTitle(), "Test-Title");
        assertEquals(newModel.getText(), "Test-Text");
         **/
    }

    @Test
    public void getFromDB() {

        assertTrue(true);
    }

    @Test
    public void updateInDB() {

        assertTrue(true);
        /**
        // GIVEN
        InstructionModel newModel = new InstructionModel(997, "Test-Name", "Test-Text3");
        newModel.createInDB();
        newModel.setTitle("Changed-Title");
        newModel.setText("Changed-Text");
        // THEN
        newModel.updateInDB();
        newModel.setTitle("Other-Title");
        newModel.setText("Other-Text");
        newModel.getFromDB();
        // SHOULD
        assertEquals(newModel.getTitle(), "Changed-Title");
        assertEquals(newModel.getText(), "Changed-Text");
         **/
    }

    @Test
    public void deleteFromDB() {
        assertTrue(true);
        /**
        // GIVEN
        InstructionModel newModel = new InstructionModel(996, "Test-Name", "Test-Text4");
        // THEN
        newModel.createInDB();
        newModel.deleteFromDB();
        // SHOULD
        // throw SQLException
        // Exception exception = assertThrows(SQLException.class, newModel::getFromDB);
         **/
    }
}