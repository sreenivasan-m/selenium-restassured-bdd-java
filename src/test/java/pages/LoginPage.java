package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(xpath = "//*[@id='login']/button")
    private WebElement btnLogin;

    public LoginPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void setUsername(String user) {
        txtUsername.sendKeys(user);
    }

    public void setPassword(String pass) {
        txtPassword.sendKeys(pass);
    }

    public void clickLogin() {
        btnLogin.click();
    }
}
