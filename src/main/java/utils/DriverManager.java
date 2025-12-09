package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Initialize ThreadLocal WebDriver
    public static void setDriver() {

        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        driver.set(new ChromeDriver());
    }

    // Return thread-safe WebDriver instance
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Quit driver safely
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
