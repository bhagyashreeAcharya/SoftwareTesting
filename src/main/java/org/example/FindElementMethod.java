/*
>We use this method to find webelement this is most important method
>WebElement - Web element is simply HTML elememnt within a HTML document. The HTML element contains
a start tag and content between both tags
>Webdriver APIs provide different ways to identify these elements such as ID, Xpath, Name etc thiesee are alson
known as "LOCATOR"
> IF this LOCATOR is unique then it will find the respective element. However, if the multiple elemnts using
same Locator then is will returns the only first matching element
>It is advisable to use Name and id as these are most of the time unique identifiers
>findElement(): This method is used to find an element on the webpage.
>Syntax : WebElement element = driver.findElement(By.name("button"));
*
*/

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementMethod {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        WebElement element = driver.findElement(By.name("btnK"));
        if(element.isEnabled()){
            System.out.println("Element is enables");
        }else {
            System.out.println("Element is not enable");
        }
    }
}
