/*
 * Creation : 19 mars 2019
 */
package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitS {

    static WebDriverWait wait;

    public static void Wait(int Dur) {
        try {
            Thread.sleep(Dur);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

    public static void WaitForElementToBeVisible(WebDriver driver, WebElement WE) {
        wait = new WebDriverWait(driver, 20000);
        wait.until(ExpectedConditions.visibilityOf(WE));

    }

    public static void WaitForElementToBeClickable(WebDriver driver, WebElement WE) {
        wait = new WebDriverWait(driver, 20000);
        wait.until(ExpectedConditions.visibilityOf(WE));
        wait.until(ExpectedConditions.elementToBeClickable(WE));

    }

    public static void waitForLoad(WebDriver driver) {

        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, 20000);
        wait.until(pageLoadCondition);
    }
}
