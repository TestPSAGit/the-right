/*
 * Creation : 28 mars 2019
 */
package Peugeot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Utilities.WaitS;

public class HomePageAP {
    static String[] modelsList;
    static String[] subModelsList;

    static String[] GetModelsList(WebDriver driver) {
        int count = new Select(driver.findElement(By.name("model"))).getOptions().size();
        modelsList = new String[count];
        for (int j = 1; j < count; j++) {
            modelsList[j] = new Select(driver.findElement(By.name("model"))).getOptions().get(j).getText();
        }
        return modelsList;
    }

    static void SelectaModelByIndex(WebDriver driver, int i) {
        new Select(driver.findElement(By.name("model"))).selectByIndex(i);
    }

    static void SelectaSubModelByIndex(WebDriver driver, int i) {
        new Select(driver.findElement(By.name("submodel"))).selectByIndex(i);
    }

    static int GetThePriceRange(WebDriver driver) {
        WebElement Slider = driver.findElement(By.id("price"));
        String Min = Slider.getAttribute("data-slider-min").toString();
        String Max = Slider.getAttribute("data-slider-max").toString();
        int Range = Integer.parseInt(Max) - Integer.parseInt(Min);
        return Range;
    }

    static String[] GetSubModelsList(WebDriver driver) {
        int count = new Select(driver.findElement(By.name("submodel"))).getOptions().size();
        subModelsList = new String[count];
        for (int j = 1; j < count; j++) {
            subModelsList[j] = new Select(driver.findElement(By.name("submodel"))).getOptions().get(j).getText();
        }
        return subModelsList;
    }

    static int GetTheOffersNum(WebDriver driver) {
        String OffersNumber = driver.findElement(By.id("model-choice-counter")).getText();
        int Number;
        if (OffersNumber.equals("")) {
            Number = 1;
        } else {
            Number = Integer.parseInt(OffersNumber);
        }
        return Number;
    }

    static void MoveRegionSliderToMax(WebDriver driver) {
        WebElement DistanceSlider = driver.findElement(
                By.xpath("//*[@id=\"ctl00_cphPage_ctl00_divContainer\"]/div[2]/div/form/fieldset[2]/div/div/table/tbody/tr/td[2]/div/a"));
        Actions action = new Actions(driver);
        action.clickAndHold(DistanceSlider);
        action.moveByOffset(300, 0);
        action.release();
        action.build().perform();
        WaitS.Wait(1000);
    }

    static void EnterTheLocation(WebDriver driver, String Loc) {
        WebElement Loca = driver.findElement(By.id("region"));
        // Loca.sendKeys(Keys.CONTROL + "a");
        Loca.sendKeys(Loc);
        WaitS.Wait(1000);
        Loca.sendKeys(Keys.ENTER);
        WaitS.Wait(1000);
    }

    static void ClickOnTheOffersButton(WebDriver driver) {
        driver.findElement(By.id("default")).submit();
    }

}
