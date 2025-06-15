//Wait() : Causes current thread to wait until it is awakened , typically by being notified or interrupted , or until a certain amount of real time has elasped
//Syntax : wait(30) ;
//Difference between explicit and emplic and this wait method is that implecit explicit are dynamic and this one is static which means
// even if conditions are satisfied
// are done on page it will still wait to complete 30 seconds
//Disadvantage of using this method is that it will increase your script execution time because we are waiting whole time which was given
//thread.sleep() : This method will stop the execution of the script for specified duration irrepective of whether the condition are statisifed such as they found element or not
//both the wait and thread.sleep are simmilar the only difference is that wait

package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitAndThreadMethod {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com/");
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().to("https://gmail.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }
}
