package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Firstscript {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver" , "src/test/resources/Drivers/chromedriver.exe") ;
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        String title = driver.getTitle();
       if (title.equals("Google")){
            System.out.println("Title is correct");
        }
        else {
            System.out.println("Title is incorrect");
        }

        driver.quit();

        }
    }

