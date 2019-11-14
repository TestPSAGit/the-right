/*
 * Creation : 17 avr. 2019
 */
package Peugeot;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.InitialiseDrivers;

public class TestFunctions {
    static WebDriver driver;
    static Date DeliveryDate;
    static Date currentDate;

    @BeforeMethod
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get(
                "http://fr.store.peugeot.inetpsa.com/Recherche-par-critere?lat=48.856614&lng=2.3522219000000177&LocationL=Paris%2C%20France&etd=0");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.className("psac_noselect")).click();

    }

    @Test

    public void Thedels() {
        ResultPageAP.OpenTheModelsMenu(driver);
        ResultPageAP.SelectaModelFromTheModelsList(driver, 5);
        // WaitS.WaitForElementToBeVisible(driver, "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/label[1]/i[1]");
        String[] Energies = ResultPageAP.GetTheEnergiesList(driver);

        for (int i = 1; i >= Energies.length; i++) {
            // ResultPageAC.ClickOnOneEnergy(driver, Energies[i]);
            ResultPageAP.GetOffersNumber(driver);

        }

    }

}
// label[contains(text(),'ion, 5 portes')]
// label[contains(text(),'iOn, 5 portes')]
