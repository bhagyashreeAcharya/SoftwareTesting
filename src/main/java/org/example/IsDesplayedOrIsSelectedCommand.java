package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDesplayedOrIsSelectedCommand {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver" , "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

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
