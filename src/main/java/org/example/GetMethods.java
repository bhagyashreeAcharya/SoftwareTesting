package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver" ,"src/test/resources/Drivers/chromedriver.exe" );
        WebDriver Driver = new ChromeDriver();

        Driver.get("https://google.com");

       String title = Driver.getTitle();
       String url = Driver.getCurrentUrl();
       String source = Driver.getPageSource();

        System.out.println(title + " " + url + " " + source);

        Driver.quit();

//        let use string method to catch some words from source

        if (source.contains("en-IN")){
            System.out.println("The source contains about content");
        }
        else {
            System.out.println("The source does not contain content language en");
        }


    }
}
