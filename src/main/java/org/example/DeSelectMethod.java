package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DeSelectMethod {
//    deselect method only works with multiple select HTML element
public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");

//    Now we will ask system to select multiple options
  WebElement element =  driver.findElement(By.name("FromLB"));

  Select select = new Select(element);
  select.selectByIndex(0);
  select.selectByValue("Russia");
  select.selectByVisibleText("France");

//  Now we will deselect method

    select.deselectByIndex(2);
    select.deselectByValue("USA");
    select.deselectAll();

}
}
