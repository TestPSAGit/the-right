/*
 * Creation : 29 mars 2019
 */
package Citroën;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.WaitS;

public class ResultPageAC {

    static String[] Pages;
    static WebDriver driver;

    static String[] modelsList;
    static String[] energyList;

    static Boolean ChecktheDeleveryDatePresence(WebDriver driver) {
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.className("delay")));
        return driver.findElement(By.className("delay")).isDisplayed();
    }

    static Boolean ChecktheOffersNumberPresence(WebDriver driver) {
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.className("count")));
        return driver.findElement(By.className("count")).isDisplayed();
    }

    static Boolean ChecktheModelsListPresence(WebDriver driver) {
        WaitS.WaitForElementToBeVisible(driver,
                driver.findElement(By.xpath("//div[contains(@class,'control-group retailer-choice')]//div[contains(@class,'dropdown-list')]")));
        return driver.findElement(By.xpath("//div[contains(@class,'control-group retailer-choice')]//div[contains(@class,'dropdown-list')]"))
                .isDisplayed();
    }

    static Boolean CheckthepresenceofelementsontheModelsList(WebDriver driver) {
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.id("select-place-holder")));
        driver.findElement(By.id("select-place-holder")).click();
        WaitS.WaitForElementToBeVisible(driver,
                driver.findElement(By.xpath("//ul[@class='car-list-item dropdown-menu select-box noScroll']//li[1]")));
        return driver.findElement(By.xpath("//ul[@class='car-list-item dropdown-menu select-box noScroll']//li[1]")).isDisplayed();
        // driver.findElement(By.xpath("//div[contains(@class,'control-group retailer-choice')]//div[contains(@class,'dropdown-list')]")).click();
    }

    static Boolean ChecktheLocalityPresence(WebDriver driver) {
        WaitS.WaitForElementToBeVisible(driver,
                driver.findElement(By.xpath("//form[@id='Form-Filter-panel']//div[contains(@class,'geolocation-box controls')]")));
        return driver.findElement(By.xpath("//form[@id='Form-Filter-panel']//div[contains(@class,'geolocation-box controls')]")).isDisplayed();
    }

    static Boolean ChecktheDistanceCtaPresence(WebDriver driver) {
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//div[@class='control-group distance']//div[@class='controls']")));
        return driver.findElement(By.xpath("//div[@class='control-group distance']//div[@class='controls']")).isDisplayed();
    }

    static Boolean ChecktheBudgetCtaPresence(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//label[contains(text(),'udget')]")));
        return driver.findElement(By.xpath("//label[contains(text(),'udget')]")).isDisplayed();
    }

    static Boolean ChecktheEnergyCtaPresence(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//div[@class='control-group energy-filter']")));
        return driver.findElement(By.xpath("//div[@class='control-group energy-filter']")).isDisplayed();
    }

    static Boolean ChecktheTrasmissionCtaPresence(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver,
                driver.findElement(By.xpath("//form[@id='Form-Filter-panel']//div[contains(@class,'control-group transmission-filter')]")));
        return driver.findElement(By.xpath("//form[@id='Form-Filter-panel']//div[contains(@class,'control-group transmission-filter')]"))
                .isDisplayed();
    }

    static Boolean ChecktheEngineCtaPresence(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver,
                driver.findElement(By.xpath("//form[@id='Form-Filter-panel']//div[contains(@class,'control-group engine-filter')]")));
        return driver.findElement(By.xpath("//form[@id='Form-Filter-panel']//div[contains(@class,'control-group engine-filter')]")).isDisplayed();
    }

    static Boolean ChecktheFinitionCtaPresence(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver,
                driver.findElement(By.xpath("//form[@id='Form-Filter-panel']//div[contains(@class,'control-group grade-filter')]")));
        return driver.findElement(By.xpath("//form[@id='Form-Filter-panel']//div[contains(@class,'control-group grade-filter')]")).isDisplayed();
    }

    static Boolean ChecktheColorCtaPresence(WebDriver driver) {

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//label[@class='color']")));
        WaitS.Wait(2000);
        return driver.findElement(By.xpath("//label[@class='color']")).isDisplayed();
    }

}
