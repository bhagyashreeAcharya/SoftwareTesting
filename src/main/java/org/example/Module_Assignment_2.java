/* Problem statement :
>Create a Selenium to automate the account registration page
>Verify confirmation message on the page match the expected text
>pate url = https://tutorialsninja.com/demo/index.php?route=account/register
>Expected text - Congratulations! Your new account has been successfully created!

>Approach
>1Create a new Selenium script
Use sendKeys method to enter text into fields for Your Personal Details section
Use sendKeys method to enter text into fields for Your Password section
Use click method to select Subscribe radio button
Use click method to select Privacy Policy check box
Use click method to click on Continue button
Use getText method to get the actual text on the confirmation page
Use if else statement to compare the expected vs. actual text
*
*
* */


package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Module_Assignment_2 {
    public static void main(String[] args) {

        String xpath_Newsletter = "(//input[@name='newsletter'])[1]";
        String name_Agree = "agree";
        String xpath_Continue = "//input[@value='Continue']";
        String xpath_Text = "//div[@id='content']//p";


        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        driver.manage().window().maximize();

            driver.findElement(By.id("input-firstname")).click();
            driver.findElement(By.id("input-firstname")).sendKeys("Bhagyashree");
            driver.findElement(By.id("input-lastname")).click();
            driver.findElement(By.id("input-lastname")).sendKeys("Acharya");
            driver.findElement(By.id("input-email")).click();
            driver.findElement(By.id("input-email")).sendKeys("bhag195naid@test.com");
            driver.findElement(By.id("input-telephone")).click();
            driver.findElement(By.id("input-telephone")).sendKeys("8208925071");
            driver.findElement(By.id("input-password")).click();
            driver.findElement(By.id("input-password")).clear();
            driver.findElement(By.id("input-password")).sendKeys("tmC3yMpbXW6@NW");
            driver.findElement(By.id("input-confirm")).click();
            driver.findElement(By.id("input-confirm")).clear();
            driver.findElement(By.id("input-confirm")).sendKeys("tmC3yMpbXW6@NW");

            if(driver.findElement(By.name("newsletter")).isDisplayed()){
                if(!driver.findElement(By.xpath(xpath_Newsletter)).isSelected()){
                    driver.findElement(By.xpath(xpath_Newsletter)).click();
                    System.out.println("Yes Selected");
                }
            }

            if(driver.findElement(By.name(name_Agree)).isEnabled()){
                driver.findElement(By.name(name_Agree)).click();
                System.out.println("Condition Agree");
            }

            driver.findElement(By.xpath(xpath_Continue)).click();

//  Now lets just store the string of message and compare with if else

        String actual_text = driver.findElement(By.xpath(xpath_Text)).getText();

        if(actual_text.equals("Congratulations! Your new account has been successfully created!")){
            System.out.println("Expected text matches with actual text");
        }else {
            System.out.println("Text Does not match");
        }
    }
}
