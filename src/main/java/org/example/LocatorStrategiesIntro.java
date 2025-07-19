/**
 > In Selenium, By class provides a mechanism which is used to locate elements within a HTML document
 >
 ID Locator : By.d is the most commont locator and preferred way to locate any element on the webpage
 - ID is supposed to be the unique for every element in a web page
 - If selenium is unable to find any element with the ID a NOSuchElement Exception is returned
 Syntax : driver.findElement(By.id("username");

 * Name Locator : After ID , Name is considered to be the next best choice for locating any element
  on HTML page
 > Drawback : Name is not unique like id and we can have duplicate element with same name
 > If there are multiple elements with same name , webdriver will select the first matching element
 > If selenium is unable to find any element with the Name , a NoSuchElement execption is returned
Syntax : driver.findElement(By.name("Login"));

 * LinkText Locator :
 > Able to locate web elements by using the hyperlink texts
 >Only applicable for elements with the anchor tags (<a>)
 >If multiple links have the same text, Webdriver will select the first matching elemnet
 >If selenium is ubale to find any element with the link text it NoSuchElement exception is returned
 Syntax : driver.findElement(By.linkText("Register");

 * partiallinkText locator :
 > It is able to locate web element by using the partial hyperlink texts
 Link TextName = "Login Page"
 partial Link Text Value = "Login"
 > Only applicable for the elements with anchor tags (<a></a>)
 >If multiple links have the same partial text , Webdriver will select the first matching element
 >If selenium is unable to find any element with the partial link text it  will return exception
 NoSuchElement

* By TagName Locator :
 >Tag name is a part of DOM structure where every element on a page is defined via tags like input
 ,div, button, anchor tag
 >Each tag has multiple attributes like ID, Name , Value , Class
 >Tag Name locator is used to find an element by using the tag name
 > If multiple element have the same tag name, it will return all the element and store in a list
 >If a Selenium is unable to find any element with the tag name, a NoSuchElement Exception is returned
 > Syntax : List < WebElement> buttons = driver.findElements(By.tagName("button"));

 * By ClassName locator
 > WebDriver can locate element on a web page using theire class name
 > Multiple elements can have the same class name
 > If multiple elements have the same class name, WebDriver will select the first matching element
 > If Selenium is unable to fine any element with the class name, a NoSuchElement Exception is returned
 Syntax :
 Driver.fineElement(By.className("btn-primary"));

 * By Xpath
 > Before understanding xpath we need to understand what is xml xml stands for Extensible Markup language
 >XML is designed for storing and transferring data hence it is different from html
 >XML wraps data within tags
 > XML is used to carry data while HTML is used to display data
 >HTML tags are predefined for example body tag header tags etc . On the other hand XML tags you can
 defined based on your logic
 > XML is extesible which means for example if you have used the old version of XML with 
 certain number of tags and now you want to create newer version then older version will still be 
 accessible hence XML can be extended
 *> NOW COMING TO XPATH :
 > XPATH stands for XML path
 >XPath can be used to navigate through elements and attributes in a XML document
 >XPath contains a library of standard functions
 > XPath is a W3C (world wide web consotium ) recommondation
 > XPath is used to define the parts of an XML document like element, attributes , text and document
 nodes
 >XPath provides powerfull path expression to select node, or list of nodes in XML documents
 >If WebDriver is not able to find element using other locators , XPath can be used
 > It is usefull to find dynamic web element
 > Syntax : Xpath = //tagName[@Attribute = "Value"]
 // for showing current node
 tagName for any element such as button , <p> </p> etc
 Attribute like class , id etc

 


 **/


package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.List;

public class LocatorStrategiesIntro {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

//        Let's use By.id locator
        driver.findElement(By.id("input-firstname")).sendKeys("Bhagyashree");
        driver.findElement(By.id("input-lastname")).sendKeys("Acharya");
        driver.findElement(By.id("input-email")).sendKeys("bhaghu-1@text.com");
        driver.findElement(By.id("input-telephone")).sendKeys("111-222-3333");


//        lets use Name locator
        driver.findElement(By.name("password")).sendKeys("password12@123");
        driver.findElement(By.name("confirm")).sendKeys("password12@123");

//        lets use linkText locator
        driver.findElement(By.linkText("login page")).click();
        if(driver.findElement(By.linkText("Login")).isDisplayed()){
            System.out.println(" The Login text is desplayed");
        }else {
            System.out.println("Login link is not displayed");
        }
        driver.navigate().back();

        //        lets use PartiallinkText locator
        driver.findElement(By.partialLinkText("login")).click();
        if(driver.findElement(By.partialLinkText("Log")).isDisplayed()){
            System.out.println(" The Login text is displayed");
        }else {
            System.out.println("Login link is not displayed");
        }

        driver.navigate().back();

//        Now lets use the tagName locator

     List<WebElement> buttons =  driver.findElements(By.tagName("button"));
        buttons.forEach(btn -> System.out.println(btn.getText()));

//        Now lets use the className locator List example
//        List<WebElement> Details = driver.findElements(By.className("list-inline"));
//        Details.forEach(dtls -> System.out.println(dtls.getText()));

//    Now lets use the className locater with string example

        String OneExample = driver.findElement(By.className("dropdown-toggle")).getText();
        System.out.println("Class first eleement is" + OneExample);
    }




}
