/*
 * Creation : 4 juin 2019
 */
package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementMethodes {
    static WebDriver driver;

    public static void ClickOnXpath(WebElement WE) {
        WaitS.WaitForElementToBeVisible(driver, WE);
        WaitS.WaitForElementToBeClickable(driver, WE);
        WE.click();
    }

    public static void ClickOnByXpath(String Xpath) {
        WebElement WE = driver.findElement(By.xpath(Xpath));
        WaitS.WaitForElementToBeVisible(driver, WE);
        WaitS.WaitForElementToBeClickable(driver, WE);
        WE.click();
    }

    public static void CloseCokies(WebDriver driver) {
        try {

            driver.findElement(By.className("psac_noselect")).click();
        } catch (ElementNotInteractableException ex) {

        }

        catch (NoSuchElementException e) {

        }
    }

    public static void SwitchToCurrentUrl(WebDriver driver) {

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

    }

}
