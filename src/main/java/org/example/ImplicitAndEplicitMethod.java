//Both method implicit and explicit are used to avoid synchornisation error
// Implicit Method : WebDriver waits for a certain duration of time until all elemnts on the page are loaded
//Explicit Method : WebDriver waits for specific element on the page until the given condition is satisfied
//Note :Error after using explicit // Chrome was showing a password breach popup after login, causing click to fail when used
/// / Used --incognito mode to disable saved passwords and avoid the popup.
/// / This fixed ElementNotInteractableException during explicit wait.

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ImplicitAndEplicitMethod {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver" , "src/test/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--user-data-dir=D:/selenium-profile");
        options.addArguments("--incognito");

//        options.setExperimentalOption("prefs", new java.util.HashMap<>() {{
//            put("credentials_enable_service", false);
//            put("profile.password_manager_enabled", false);
//        }});

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");

//        We will write implicit method after geting to load webpage

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

//       We will explicitly wait before clicking product
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='item_4_title_link']")));

       driver.findElement(By.xpath("//a[@id='item_4_title_link']")).click();



    }
}
