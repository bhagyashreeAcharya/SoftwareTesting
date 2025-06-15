//PageLoad Timeout - Sets the amount of time to wait for page-load to complete before throwing a Timeout Exception
//Syntax : driver.manage().timeouts().pageLoadTimeout(30, Timeunit.SECONDS)
//Asynchronus Scipt : it allows user to comminicate with the page when script loads in the background and it runs immediately when ready
//SetScript timeout - Sets the amount of the time to wait for an asynchronus script to finish execution before throuwing an error
//Syntax : driver.manage().timeouts().setScriptTimeout(1, TimeUnit.Seconds);

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PageAndScriptLoadTimeout {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver" , "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

//        Here we will add page load timeouts

        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10));

        if (driver.findElement(By.name("newsletter")).isDisplayed()){
            if (!driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).isSelected()){
                driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
                System.out.println("Yes selected");
            }
        }

        if (driver.findElement(By.name("agree")).isEnabled()){
            driver.findElement(By.name("agree")).click();
            System.out.println("Condition agree");
        }
    }
}
