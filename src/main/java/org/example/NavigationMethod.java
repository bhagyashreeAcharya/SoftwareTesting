package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethod {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com/");
        driver.navigate().to("https://gmail.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }
}
