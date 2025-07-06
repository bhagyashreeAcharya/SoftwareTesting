//maximize : this method will maximize the current window of browser
//Fullscreen : this method will chang the current window for fullscreen
//getPosition : this method will get the position of the current window
//setPosition : this method will set the position of the current window
//setSize : this method is used to resize the window to custom dimension


package org.example;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowCommands {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com/");

//        Now we will use all the command of windows
//        driver.manage().window().maximize();
//        driver.manage().window().fullscreen();

//        Point point = driver.manage().window().getPosition();
//        System.out.println(point.x);
//        System.out.println(point.y);
//
//        Point point1 = new Point(300,600);
//        driver.manage().window().setPosition(point1);
//
        Dimension dimension = new Dimension(300 , 500);
        driver.manage().window().setSize(dimension);
    }
}
