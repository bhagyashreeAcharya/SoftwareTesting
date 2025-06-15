package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment2 {

    public static void main(String[] args) {
    System.setProperty("webdriver.gecko.driver" , "src/test/resources/Drivers/geckodriver.exe") ;
    WebDriver FDriver = new FirefoxDriver();

    FDriver.get("https://gmail.com");
        FDriver.manage().window().maximize();
        String Title = FDriver.getTitle();

    if (Title.equals("Gmail")){
        System.out.println("Title is correct");
    }
    else {
        System.out.println("Title is incorrect");
    }


 FDriver.quit();

    }
}
