/* Alert is the message or notification box which appear on the screen that notifies the user about some information

*Selenium provides the following methods to handle alerts :
> swithTo().alert().accept() :  this method is used to click on OK button of the alert
>switchTo().alert().dismiss() : this method is used to click on CANCEL button
>switch().alert().getText() : this method is used to capture alert message
>switch().alert().sendKeys() : This method is used to send data to the alert box
*
* */

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToCommand {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

//        Now we will use switchto command
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//        driver.switchTo().alert().accept();

//        lets print the text
        String message = driver.switchTo().alert().getText();
        System.out.println("The alert message is :" + message);
        driver.switchTo().alert().accept();

//        now lets cancle the alert
//        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//        driver.switchTo().alert().dismiss();

//        Now lets just send some text
//        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
//        driver.switchTo().alert().sendKeys("Hello testers!");
//        driver.switchTo().alert().accept();



    }
}
