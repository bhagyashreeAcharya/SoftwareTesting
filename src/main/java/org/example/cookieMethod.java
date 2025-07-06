/*
>getCookies() : this method returns list of all cookies
>  getCookieNamed() : This method returns specific cookie according to name
>addCookie() : This method help us to add a custom cookie to the current browser context
>deleteAllCookies() : Deletes all cookies
>deleteCookie() : delete specific cookie
>deleteCookieNamed(): delete specific cookie accoriding to name
*
* */


package org.example;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class cookieMethod {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

//        Lets print all cookies
        /*Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);*/

//        Lets get cookie by name
      /*  Cookie curr = driver.manage().getCookieNamed("currency");
        System.out.println(curr);*/

//        Lets add cookie

        Cookie customCookie = new Cookie("user","tester");
        driver.manage().addCookie(customCookie);

//        delete cookie
        System.out.println(driver.manage().getCookieNamed("user"));
        driver.manage().deleteCookieNamed("user");
        driver.manage().deleteCookieNamed("currency");

        Set<Cookie> cookies1 = driver.manage().getCookies();
        System.out.println(cookies1);

    }

}
