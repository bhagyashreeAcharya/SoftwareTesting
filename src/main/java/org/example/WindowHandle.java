package org.example;
/*Window handle is the unique identifier which holds the address of all windows .Each brower
has a unique window handle
> It is alpha-numeric value
 > By this handle we can find out which browser window is currently open
 >getWindowHandle() : This method returns the window handle of the current window
 >getWidnowHanles() ; This method returns the window handles of all the current windows opened in the brower
 Return type is : Set<String>
 >switchTo().window(): This method is used to switch to another window handle or name



 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.naukri.com/");

        String mainWindow = driver.getWindowHandle();
        System.out.println("Main window Hanlde : " +  mainWindow);

        // Click the button that opens a new window
//        driver.findElement(By.linkText("Remote")).click();
//
//        // Optional wait to give the new window time to open
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace(); // or handle it as needed
//        }
        Set<String> Handles = driver.getWindowHandles();
        for(String handle:Handles){
            if (!mainWindow.equals(handle)){
                driver.switchTo().window(handle);

                System.out.println(driver.switchTo().window(handle).getTitle());
                driver.close();
            }

        }

        // Switch back to the main window after closing all popups
        driver.switchTo().window(mainWindow);

// Initialize wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// 1. Type character by character to trigger suggestions
        WebElement input = driver.findElement(By.xpath("//input[@placeholder='Enter skills / designations / companies']"));
        String skill = "Software Tester";
        try {
            for (char ch : skill.toCharArray()) {
                input.sendKeys(String.valueOf(ch));
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Typing interrupted: " + e.getMessage());
        }

// 2. Close the *Install App* ad popup (specific to that big one near the bottom)
        // 2. Close the Install App popup that shows during typing
        try {
            Thread.sleep(1500); // give it time to appear
            WebElement popupClose = driver.findElement(By.className("cross-icon"));
            if (popupClose.isDisplayed()) {
                popupClose.click();
                System.out.println("Closed Install App popup.");
            }
        } catch (Exception e) {
            System.out.println("No Install App popup appeared.");
        }

        // 2.5 Close the cookie banner if it's visible
        try {
            WebElement cookieBannerBtn = driver.findElement(By.cssSelector(".acceptance-btn-text"));
            if (cookieBannerBtn.isDisplayed()) {
                cookieBannerBtn.click();
                System.out.println("Closed cookie banner.");
            }
        } catch (Exception e) {
            System.out.println("No cookie banner appeared.");
        }



// 3. Try clicking the first suggestion
//        try {
//            input.click(); // re-focus if needed
//            Thread.sleep(1500); // allow suggestions to load
//            WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//ul[contains(@class,'suggestor')]/li[2]")));
//            suggestion.click();
//            System.out.println("Clicked first suggestion.");
//        } catch (Exception e) {
//            System.out.println("Suggestion not found or not clickable: " + e.getMessage());
//        }

        // 3. Use arrow key to highlight suggestion, then press enter (keyboard flow)
        try {
            input.click(); // refocus input just in case
            Thread.sleep(1000); // slight delay for suggestions to render
            input.sendKeys(Keys.ARROW_DOWN); // highlight first suggestion
            input.sendKeys(Keys.ENTER); // select the highlighted suggestion
            System.out.println("Selected suggestion using arrow + enter.");
        } catch (Exception e) {
            System.out.println("Suggestion selection via keys failed: " + e.getMessage());
        }

// 4. Click Search
        try {
            WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("qsbSubmit")));
            searchBtn.click();
            System.out.println("Search button clicked.");
        } catch (Exception e) {
            System.out.println("Search button issue: " + e.getMessage());
        }

    }
}
