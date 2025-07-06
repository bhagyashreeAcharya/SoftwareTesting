package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class PrintWindowHandleWithJs {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/browser-windows");

        // Click on 'New Tab' using JavaScript to bypass ad iframe issue
        WebElement tabBtn = driver.findElement(By.id("tabButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabBtn);

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Window handles:");
        for (String handle : windowHandles) {
            System.out.println(handle);
        }

        driver.quit();
    }
}
