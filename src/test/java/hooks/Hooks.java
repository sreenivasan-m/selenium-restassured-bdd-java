package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("=== Starting Scenario ===");
        DriverManager.setDriver();
    }

    @After
    public void tearDown() {
        System.out.println("=== Ending Scenario ===");
        DriverManager.quitDriver();
    }
}
