package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class PrintWindowHandle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/browser-windows");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Get the main window handle
        String mainWindow = driver.getWindowHandle();

        try {
            // Wait for the button and click it
            WebElement tabBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("tabButton")));
            Thread.sleep(1000); // allow ad to shift if needed
            tabBtn.click(); // opens a new tab
            Thread.sleep(1000); // allow tab to fully open
        } catch (Exception e) {
            System.out.println("Click failed: " + e.getMessage());
        }

        // Get all window handles (main + any new ones)
        Set<String> handles = driver.getWindowHandles();

        System.out.println("Window handles:");
        for (String handle : handles) {
            driver.switchTo().window(handle);

            if (handle.equals(mainWindow)) {
                System.out.println("MAIN WINDOW");
            } else {
                System.out.println("CHILD WINDOW");
            }

            System.out.println("Handle: " + handle);
            System.out.println("Title: " + driver.getTitle());
            System.out.println("-------------------");
        }

        // Switch back to main window at the end
        driver.switchTo().window(mainWindow);
        System.out.println("✅ Switched back to MAIN window.");

        driver.quit();
    }
}
