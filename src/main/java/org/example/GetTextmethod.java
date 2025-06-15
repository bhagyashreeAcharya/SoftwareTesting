package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextmethod {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com");

//    we will login to select text

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);

//        Now after login we will select text Product

        String text = driver.findElement(By.xpath("(//span[@class='title'])")).getText();
            if (text.equals("Products")){
                System.out.println("Text is matching");
            }
            else {
                System.out.println("Text not matching");
            }


  String tag = driver.findElement(By.id("item_4_img_link")).getTagName();
            if (tag.equals("a")){
                System.out.println("tag is correct");
            }
            else {
                System.out.println("Tag is incorrect");
            }


    }
}
