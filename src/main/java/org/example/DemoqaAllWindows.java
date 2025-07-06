package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class DemoqaAllWindows {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/browser-windows");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String mainHandle = driver.getWindowHandle();

        List<String> buttonIds = List.of("tabButton", "windowButton", "messageWindowButton");

        for (String id : buttonIds) {
            try {
                WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
                Thread.sleep(1000); // let scroll settle
                btn.click();
                Thread.sleep(1500); // let new tab/window open
            } catch (Exception e) {
                System.out.println("❌ Couldn't click button: " + id + " | Reason: " + e.getMessage());
            }
        }

        // Handle and close child windows
        Set<String> handles = driver.getWindowHandles();
        System.out.println("🪟 All Window Handles:");

        for (String handle : handles) {
            if (!handle.equals(mainHandle)) {
                try {
                    driver.switchTo().window(handle);
                    System.out.println("🪟 CHILD WINDOW");
                    System.out.println("Handle: " + handle);

                    try {
                        String title = driver.getTitle();
                        System.out.println("Title: " + (title.isEmpty() ? "(No Title)" : title));
                    } catch (Exception e) {
                        System.out.println("⚠️ Could not fetch title (probably a raw text popup)");
                    }

                    System.out.println("-----------------------");

                    try {
                        driver.close();
                        System.out.println("✅ Closed window: " + handle);
                    } catch (Exception e) {
                        System.out.println("❌ Normal close failed for: " + handle + ". Trying JS workaround...");

                        try {
                            ((JavascriptExecutor) driver).executeScript("window.close();");
                            System.out.println("✅ JS close attempted.");
                        } catch (Exception jsEx) {
                            System.out.println("❌ JS close also failed for: " + handle);
                        }
                    }

                } catch (Exception e) {
                    System.out.println("❌ Couldn't switch to or process window: " + handle + " | Reason: " + e.getMessage());
                }
            } else {
                System.out.println("👉 MAIN WINDOW");
                System.out.println("Handle: " + handle);
                System.out.println("Title: " + driver.getTitle());
                System.out.println("-----------------------");
            }
        }

        // Switch back to main window and quit
        driver.switchTo().window(mainHandle);
        System.out.println("✅ Back to MAIN window.");
        driver.quit();
    }
}
