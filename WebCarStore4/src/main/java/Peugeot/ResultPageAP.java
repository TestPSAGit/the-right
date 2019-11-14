/*
 * Creation : 29 mars 2019
 */
package Peugeot;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.DateManagement;
import Utilities.WaitS;

public class ResultPageAP {

    static String[] Pages;
    static WebDriver driver;

    static String[] modelsList;
    static String[] energyList;

    static int GetOffersNumber(WebDriver driver) {

        String[] Offers = driver.findElement(By.className("title")).getText().split(" ");
        return Integer.parseInt(Offers[0]);

    }

    static boolean GetTTheoffersTitleVisibility(WebDriver driver) {

        return driver.findElement(By.className("stock__title")).isDisplayed();

    }

    static String GetTTheoffersTitleText(WebDriver driver) {

        return driver.findElement(By.className("stock__title")).getText();

    }

    static int GetTTheNumberOfOffers(WebDriver driver) {

        String[] Title = driver.findElement(By.className("stock__title")).getText().split(" ");
        return Integer.parseInt(Title[0]);

    }

    static Date GetDeliveryDateByIndex(WebDriver driver, int Index) {

        String[] Date = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[" + Index + "]/div[1]")).getText().split(" ");

        String DileveryDate = Date[4] + " " + Date[5] + " " + Date[6];
        return DateManagement.FormatDateSplited(DileveryDate);

    }

    static boolean IsTheDateVisible(WebDriver driver, int Index) {

        return driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[" + Index + "]/div[1]/p[1]")).isDisplayed();

    }

    static String[] GetTheModelsListElements(WebDriver driver) {
        driver.findElement(By.xpath("//form[@id='filter-form']/div[1]/div[1]/div[1]/button[1]")).click();

        WaitS.Wait(2000);
        List<WebElement> List = driver.findElements(By.xpath("//div[@class='btn-group open']//ul[@class='multiselect-container dropdown-menu']"));
        String Models = List.get(0).getText();
        String ModelsList[] = Models.split("\n");
        driver.findElement(By.xpath("//form[@id='filter-form']/div[1]/div[1]/div[1]/button[1]")).click();
        return ModelsList;

    }

    static String[] GetTheGearBoxListElements(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div[5]/div/div")).click();

        WaitS.Wait(2000);
        List<WebElement> List = driver.findElements(By.xpath("//div[@class='btn-group open']"));
        String Models = List.get(0).getText();
        String ModelsList[] = Models.split("\n");
        driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div[5]/div/div")).click();
        return ModelsList;

    }

    static String[] GetTheEngineListElements(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div[6]/div/div")).click();
        WaitS.Wait(2000);
        List<WebElement> List = driver.findElements(By.xpath("//div[@class='btn-group open']//ul[@class='multiselect-container dropdown-menu']"));
        String Models = List.get(0).getText();
        String ModelsList[] = Models.split("\n");
        driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div[6]/div/div")).click();
        return ModelsList;

    }

    static String[] GetTheMenuElements(WebDriver driver) {

        List<WebElement> List = driver.findElements(By.xpath("//form[@id='filter-form']"));

        String[] MenuList = new String[100];
        MenuList[0] = List.get(0).getText();

        return MenuList;

    }

    static String[] GetTheFinitionListElements(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div[7]/div/div")).click();
        WaitS.Wait(2000);
        List<WebElement> List = driver.findElements(By.xpath("//div[@class='btn-group open']//ul[@class='multiselect-container dropdown-menu']"));
        String Models = List.get(0).getText();
        String ModelsList[] = Models.split("\n");
        driver.findElement(By.xpath("//*[@id=\"filter-form\"]/div[7]/div/div")).click();
        return ModelsList;

    }

    static String[] GetTheColorListElements(WebDriver driver) {

        List<WebElement> elementsRoot = driver.findElements(By.xpath("//div[@class='control-group color-choice']/div"));

        System.out.println("///////////");

        System.out.println(elementsRoot.get(0).getText());

        // WaitS.WaitForElementToBeVisible(driver, "//*[@id=\"filter-form\"]/div[8]/div/div");
        List<WebElement> List = driver.findElements(By.xpath("//div[@class='control-group color-choice']/div"));
        String Color = List.get(0).getText();

        String ColorList[] = Color.split("\n");

        System.err.println(Color);
        return ColorList;

    }

    static void SelectaModelFromTheModelsList(WebDriver driver, int i) {
        driver.findElement(By.xpath("//div[@class='btn-group open']//ul[@class='multiselect-container dropdown-menu']/li[" + i + "]")).click();
        WaitS.Wait(1000);

    }

    static void SelectaGearBoxFromTheGearBoxsList(WebDriver driver, int i) {
        driver.findElement(By.xpath("//div[@class='btn-group open']//ul[@class='multiselect-container dropdown-menu']/li[" + i + "]")).click();
        WaitS.Wait(1000);

    }

    static void SelectaEngineFromTheEngineList(WebDriver driver, int i) {
        driver.findElement(By.xpath("//div[@class='btn-group open']//ul[@class='multiselect-container dropdown-menu']/li[" + i + "]")).click();
        WaitS.Wait(1000);

    }

    static void SelectaFinitionFromTheFinitionList(WebDriver driver, int i) {

        driver.findElement(By.xpath("//div[@class='btn-group open']//ul[@class='multiselect-container dropdown-menu']/li[" + i + "]")).click();
        WaitS.Wait(1000);

    }

    static void SelectaColorFromTheColorList(WebDriver driver, int i) {
        driver.findElement(By.xpath("//div[@class='control-group color-choice']/div/label[" + i + "]")).click();
        WaitS.Wait(1000);

    }

    static void MovePriceSliderToLowerValue(WebDriver driver) {
        WebElement PriceSlider = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/a[2]/div[1]"));
        Actions action = new Actions(driver);
        action.clickAndHold(PriceSlider);
        action.moveByOffset(-100, 0);
        action.release();
        action.build().perform();
        WaitS.Wait(1000);
    }

    static void OpenTheModelsMenu(WebDriver driver) {
        driver.findElement(By.xpath("//form[@id='filter-form']/div[1]/div[1]/div[1]/button[1]")).click();
        WaitS.Wait(2000);

    }

    static void OpenTheGearBoxMenu(WebDriver driver) {
        driver.findElement(By.xpath("//form[@id='filter-form']/div[5]/div[1]/div[1]/button[1]")).click();
        WaitS.Wait(2000);

    }

    static void OpenTheEngineMenu(WebDriver driver) {
        driver.findElement(By.xpath("//form[@id='filter-form']/div[6]/div[1]/div[1]/button[1]")).click();
        WaitS.Wait(2000);
    }

    static void OpenTheFinitionMenu(WebDriver driver) {
        driver.findElement(By.xpath("//form[@id='filter-form']/div[7]/div[1]/div[1]/button[1]")).click();
        WaitS.Wait(2000);
    }

    static String[] GetTheEnergiesList(WebDriver driver) {

        List<WebElement> List = driver.findElements(By.xpath("//div[@class='control-group appeared']"));
        String Energy = List.get(0).getText();
        String EnergyList[] = Energy.split("\n");
        return EnergyList;

    }

    static void ClickOnOneEnergy(WebDriver driver, int Label, int div) {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[" + div + "]/label[" + Label + "]")).click();
        WaitS.Wait(2000);
    }

}
