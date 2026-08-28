package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {

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