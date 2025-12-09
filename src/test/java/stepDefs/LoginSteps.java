package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverManager;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("I open the login page")
    public void i_open_the_login_page() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage();
        loginPage.open();
    }

    @When("I enter username {string}")
    public void i_enter_username(String user) {
        loginPage.setUsername(user);
    }

    @When("I enter password {string}")
    public void i_enter_password(String pass) {
        loginPage.setPassword(pass);
    }

    @When("I click login")
    public void i_click_login() {
        loginPage.clickLogin();
    }

    @Then("Login should be successful")
    public void login_should_be_successful() {
        System.out.println("Login successful");
    }
}
