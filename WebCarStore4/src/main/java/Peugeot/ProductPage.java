/*
 * Creation : 28 mai 2019
 */
package Peugeot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.WaitS;

public class ProductPage {

    static void ClickOnCarDetails(WebDriver driver) {
        // WebElement WE = driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']"));
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")));
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")).click();
    }

    static void ClickOnPriceDetails(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//div[@id='link-details']")));
        driver.findElement(By.xpath("//div[@id='link-details']")).click();
        WaitS.Wait(2000);
    }

    static void ClosePriceDetailsPopUp(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//span[@class='tingle-modal__closeIcon']")));
        driver.findElement(By.xpath("//span[@class='tingle-modal__closeIcon']")).click();
        WaitS.Wait(2000);
    }

    static int GetTheTTCHOptionPriceFromThePopUp(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, driver
                .findElement(By.xpath("//div[@class='tingle-modal-box__content']//div[@class='big-text table-cell amount expendable-highlight']")));
        String[] Price;
        Price = driver
                .findElement(By.xpath("//div[@class='tingle-modal-box__content']//div[@class='big-text table-cell amount expendable-highlight']"))
                .getText().split(" ");
        return Integer.parseInt(Price[0] + Price[1]);
    }

    static int GetTheTTCPriceFromThePopUp(WebDriver driver) {
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath(
                "//div[@class='tingle-modal-box__content']//div[@class='table-cell big-text bonus-remise amount expendable-highlight-total']")));
        String[] Price;
        Price = driver.findElement(By
                .xpath("//div[@class='tingle-modal-box__content']//div[@class='table-cell big-text bonus-remise amount expendable-highlight-total']"))
                .getText().split(" ");
        return Integer.parseInt(Price[0] + Price[1]);
    }

    static int GetTheTTCPriceFromTheProductPage(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//div[@class='price-val']")));
        String[] Price;
        Price = driver.findElement(By.xpath("//div[@class='price-val']")).getText().split(" ");
        // System.err.println(Price[0] + Price[1]);
        return Integer.parseInt(Price[0] + Price[1]);
    }

    static Boolean GetThePopupPriceDetailsTitle(WebDriver driver) {
        WaitS.Wait(2000);
        WaitS.WaitForElementToBeVisible(driver,
                driver.findElement(By.xpath("//div[@class='tingle-modal-box__content']//div[@class='order-bar-infos']//div[1]")));
        WaitS.Wait(2000);
        return driver.findElement(By.xpath("//div[@class='tingle-modal-box__content']//div[@class='order-bar-infos']//div[1]")).isDisplayed();
    }

    static Boolean ThePopupPriceDetailsCloseCrossIsClickable(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//span[@class='tingle-modal__closeIcon']")));
        return driver.findElement(By.xpath("//span[@class='tingle-modal__closeIcon']")).isEnabled();
    }

    static Boolean GetTheEstmationPopupTitle(WebDriver driver) {
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//div[@class='title-immat']")));
        return driver.findElement(By.xpath("//div[@class='title-immat']")).isDisplayed();
    }

    static Boolean ThePopupEstimationCloseCrossIsClickable(WebDriver driver) {
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//button[@class='close']")));
        return driver.findElement(By.xpath("//button[@class='close']")).isEnabled();
    }

    static void OpenEstimation(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.id("widgetView")));
        driver.findElement(By.id("widgetView")).click();
        WaitS.Wait(1000);
    }

    static void CloseEstimation(WebDriver driver) {

        WaitS.Wait(2000);
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//button[@class='close']")));
        driver.findElement(By.xpath("//button[@class='close']")).click();
        WaitS.Wait(2000);
    }

    static void ClickOnExternalView(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//li[@id='external-view']")));
        driver.findElement(By.xpath("//li[@id='external-view']")).click();
    }

    static void ClickOnInternalView(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//li[@id='internal-view']")));
        driver.findElement(By.xpath("//li[@id='internal-view']")).click();
    }

    static void ClickOn360View(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//li[@id='internal-view-360']")));
        driver.findElement(By.xpath("//li[@id='internal-view-360']")).click();
    }

    static boolean TheExternalImageIsVisible(WebDriver driver) {
        WaitS.WaitForElementToBeVisible(driver,
                driver.findElement(By.xpath("//section[@id='external_view_slider']//div[@class='slick-slide slick-current slick-active']//img")));
        return driver.findElement(By.xpath("//section[@id='external_view_slider']//div[@class='slick-slide slick-current slick-active']//img"))
                .isDisplayed();
    }

    static boolean TheInternalImageIsVisible(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//section[@id='internal_view_slider']//img")));
        return driver.findElement(By.xpath("//section[@id='internal_view_slider']//img")).isDisplayed();
    }

    static boolean The360viewIsVisible(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//section[@id='internal_view_360_slider']//canvas")));
        return driver.findElement(By.xpath("//section[@id='internal_view_360_slider']//canvas")).isDisplayed();
    }

}
