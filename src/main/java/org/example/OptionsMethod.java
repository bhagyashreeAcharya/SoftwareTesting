package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OptionsMethod {

// Select class providess the following methods to get options of a dropdown
//    getOptions() : this method returns the list of all options associated with the Select tag
//    getFirstSelectedOption() : this method returns the first selected option associated with Select tag
//    getAllSelectedOptions() : This method returns all selected options associated with the Select tag. It will be only applicable for multiselcte dropdown

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");

//        lets store element of select tag and then create select object
        WebElement element = driver.findElement(By.name("FromLB"));
        Select select = new Select(element);

//        lets select few options
        select.selectByIndex(0);
        select.selectByIndex(1);
        select.selectByIndex(3);
        select.selectByIndex(5);

//        lets get the list of all available options from scroll down

        List<WebElement> options = select.getOptions();
//        lets use for each element to print all the options

        for(WebElement e : options){
            System.out.println(e.getText());
        }

//        lets select first element
        WebElement firstOption = select.getFirstSelectedOption();
        System.out.println("first selected option is :  " + firstOption.getText());

//        lets list all selected options
        List<WebElement> SelectedOptions = select.getAllSelectedOptions();

        for (WebElement e: SelectedOptions){
            System.out.println(e.getText());
        }


    }
}
