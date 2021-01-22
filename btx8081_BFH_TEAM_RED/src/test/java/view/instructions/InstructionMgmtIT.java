package view.instructions;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.grid.testbench.GridElement;
import com.vaadin.flow.component.html.testbench.DivElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.testbench.TestBenchTestCase;


/**
 * @author Denis Moser, BFH, 21.01.2021
 * The goal of this testclass is to test within Chrome the UI of InstructionMgmtView
 * To execute the Tests with Junit, a few requirments have to be met:
 * 1: A valid Licence for Vaadin Testbench is needed (see: https://vaadin.com/docs/v8/testbench/setup/testbench-license.html).
 * 2: The current driver for the Browser (here Chromedriver), please insert the path to your driver in setup().
 * 3: Make sure the application is Running (Start Maven Build jetty:run)
 */
public class InstructionMgmtIT extends TestBenchTestCase{

    /**
     * Sets up Test with Google Chrome. Before Use, please set path to Chromedriver.
     * @throws Exception
     */
    @Before 
    public void setup() throws Exception {
	System.setProperty("webdriver.chrome.driver","C:/Users/Denis/Desktop/Chromedriver/88.0.4324.96/chromedriver.exe");

	setDriver(new ChromeDriver());
	getDriver().get("http://localhost:8080/InstructionMgmtView");
    }



    /**
     * Tests if click on Add-Button adds a new Row, 
     * by comparing indices of lastVisibleRowIndex(before and after).
     * @throws Exception 
     */
    @Test
    public void testAddButton() {
	int countInitialLastRow = 0;
	int countFinalLastRow = 0;

	countInitialLastRow= $(GridElement.class).last().getLastVisibleRowIndex();

	List<ButtonElement> buttonlist= $(ButtonElement.class).all();
	int positionOfAddItem = buttonlist.size();
	ButtonElement button = $(ButtonElement.class).get(positionOfAddItem-3);
	button.click();

	countFinalLastRow =$(GridElement.class).last().getLastVisibleRowIndex();
	countInitialLastRow++;
	assertEquals(countInitialLastRow, countFinalLastRow);   

    }

    /**
     * Tests if click on Remove-Button deletes the last Row, 
     * by comparing indices of lastVisibleRowIndex(before and after).
     * Adds and removes a row.
     * @throws Exception 
     */
    @Test
    public void testRemoveButton() {
	int countInitialLastRow = 0;
	int countFinalLastRow = 0;
	System.out.println("before add: "+ $(GridElement.class).last().getLastVisibleRowIndex());

	List<ButtonElement> buttonlist= $(ButtonElement.class).all();
	int positionOfAddItem = buttonlist.size();
	ButtonElement buttonAdd = $(ButtonElement.class).get(positionOfAddItem-3);
	buttonAdd.click();
	System.out.println("after add: "+ $(GridElement.class).last().getLastVisibleRowIndex());

	countInitialLastRow= $(GridElement.class).last().getLastVisibleRowIndex();

	System.out.println("before remove: "+ $(GridElement.class).last().getLastVisibleRowIndex());
	List<ButtonElement> buttonlist2= $(ButtonElement.class).all();
	int positionOfRemove = buttonlist2.size();
	ButtonElement buttonRemove = $(ButtonElement.class).get(positionOfRemove-2);
	buttonRemove.click();

	System.out.println("after remove: "+ $(GridElement.class).last().getLastVisibleRowIndex());
	countFinalLastRow =$(GridElement.class).last().getLastVisibleRowIndex();

	assertEquals(countInitialLastRow, countFinalLastRow);   

    }

    /**
     * Tests if input for titles which are longer than 10 are not valid.
     * @throws Exception 
     */
    @Test
    public void testInputValidation() {
	List<ButtonElement> buttonlist= $(ButtonElement.class).all();
	int positionOfAddItem = buttonlist.size();
	ButtonElement addButton = $(ButtonElement.class).get(positionOfAddItem-3);
	addButton.click();


	ButtonElement button = $(ButtonElement.class).first();
	button.click();


	GridElement table = $(GridElement.class).first();
	table.getCell(0, 0).click();
	$(TextFieldElement.class).first().sendKeys("This sentence is Longer than 10 Characters");
	$(ButtonElement.class).first().click();

	DivElement div = $(DivElement.class).last();
	Assert.assertEquals("Title length must be between 1 and 10.", div.getText());

    }

    /**
     * Closes Browser.
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception{
	getDriver().quit();
    }

}
