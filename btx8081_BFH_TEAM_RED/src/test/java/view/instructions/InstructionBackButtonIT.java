package view.instructions;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.testbench.TestBenchTestCase;

/**
 * @author Denis Moser, BFH, 21.01.2021
 *  * The goal of this testclass is to test within Chrome the "Back-Buttons" in the UI from InstructionMgmtView to InstructionVie to MainView
 * To execute the Tests with Junit, a few requirments have to be met:
 * 1: A valid Licence for Vaadin Testbench is needed (see: https://vaadin.com/docs/v8/testbench/setup/testbench-license.html);
 * 2: The current driver for the Browser (here Chromedriver)
 * 3: Start the Maven-Build before testing.
 */
public class InstructionBackButtonIT extends TestBenchTestCase{

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
     * Tests if Back-Button leads to designated page "instruction".
     */
    @Test
    public void testBackButton() {
	ButtonElement button = $(ButtonElement.class).last();
	button.click();

	String url = driver.getCurrentUrl();
	Assert.assertTrue(url="http://localhost:8080/instruction", true);
    }

    /**
     * Tests if Back-Button leads to designated page "MainView".
     */
    @Test
    public void testBackButton2() {
	ButtonElement button = $(ButtonElement.class).last();
	button.click();
	String url = driver.getCurrentUrl();
	Assert.assertTrue(url="http://localhost:8080/", true);
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
