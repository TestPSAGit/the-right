/*
 * Creation : 1 avr. 2019
 */
package Peugeot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.ElementMethodes;
import Utilities.InitialiseDrivers;
import Utilities.WaitS;

public class LeadsTestWithEstimationPreProd {
    static WebDriver driver;
    public String[][] TestData;
    int EstimationPP;
    int EstimationWidget;
    int EstimationCP;
    String DatedimatriculationPP;
    String DatedimatriculationPC;
    String NumImmatriculationPP;
    String NumImmatriculationPC;
    String MarquePP;
    String MarquePC;

    @BeforeMethod

    public void BeforeTest() throws IOException {
        driver = InitialiseDrivers.InitialiseChromDriver();
        TestData = Utilities.ReadExcelFile.GetTestData("C:\\Users\\E562418\\git\\PSAWSCS\\WebCarStore\\TestData\\testData.xlsx", 0);
    }

    @Test(priority = 1)
    public void TheEstimationIswriteOnthecontactFormforPeugeotFrance() {

        driver.get("http://fr.store.peugeot.preprod.inetpsa.com/Accueil");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        ElementMethodes.CloseCokies(driver);
        driver.findElement(By.name("model")).click();
        WaitS.Wait(2000);
        new Select(driver.findElement(By.name("model"))).selectByIndex(8);
        WaitS.Wait(2000);
        driver.findElement(By.id("region")).sendKeys("Paris");
        WaitS.Wait(2000);
        driver.findElement(By.id("region")).sendKeys(Keys.ENTER);
        WaitS.Wait(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-large btn-full btn-primary btn-double submit bound']")).submit();
        WaitS.Wait(3000);
        WaitS.waitForLoad(driver);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")));
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")).click();
        ElementMethodes.SwitchToCurrentUrl(driver);
        // ElementMethodes.ClickOnXpath(driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")));
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//button[@id='widgetView']")));
        driver.findElement(By.xpath("//button[@id='widgetView']")).click();
        WaitS.Wait(2000);
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//input[@id='enter-vrm']")));
        driver.findElement(By.xpath("//input[@id='enter-vrm']")).sendKeys("de122HG");
        // driver.findElement(By.id("region")).sendKeys(Keys.ENTER);
        ElementMethodes.SwitchToCurrentUrl(driver);
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//input[@id='overallMileage']")));
        driver.findElement(By.xpath("//input[@id='overallMileage']")).sendKeys("100000");
        // driver.findElement(By.id("region")).sendKeys(Keys.ENTER);
        ElementMethodes.SwitchToCurrentUrl(driver);
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//div[@class='col-sm-9']//button[@id='button-init-immat']")));
        driver.findElement(By.xpath("//div[@class='col-sm-9']//button[@id='button-init-immat']")).click();
        WaitS.Wait(3000);
        ElementMethodes.SwitchToCurrentUrl(driver);

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//p[contains(text(),\"Date d'immatriculation :\")]")));
        DatedimatriculationPP = driver.findElement(By.xpath("//p[contains(text(),\"Date d'immatriculation :\")]")).getText();

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//p[contains(text(),\"Numéro d'immatriculation :\")]")));
        NumImmatriculationPP = driver.findElement(By.xpath("//p[contains(text(),\"Numéro d'immatriculation :\")]")).getText();

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//p[contains(text(),'Marque :')]")));
        MarquePP = driver.findElement(By.xpath("//p[contains(text(),'Marque :')]")).getText();

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//div[@id='version_chosen']")));
        driver.findElement(By.xpath("//div[@id='version_chosen']")).click();
        WaitS.Wait(2000);
        driver.findElement(By.xpath("//li[contains(text(),'1.2 LEV 75 DYNAMIQUE')]")).click();
        ElementMethodes.SwitchToCurrentUrl(driver);
        driver.findElement(By.xpath("//button[@id='button-version']")).click();
        WaitS.Wait(5000);
        ElementMethodes.SwitchToCurrentUrl(driver);

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//p[@class='reprise-ferme-value']")));
        String EstimationReprise[] = driver.findElement(By.xpath("//p[@class='reprise-ferme-value']")).getText().split(" ");
        EstimationWidget = Integer.parseInt(EstimationReprise[0]);

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//button[@id='add_to_cart_estimate']")));
        driver.findElement(By.xpath("//button[@id='add_to_cart_estimate']")).click();

        WaitS.Wait(10000);

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//span[@class='Estimation-value']")));
        String EstimationReprisePP[] = driver.findElement(By.xpath("//span[@class='Estimation-value']")).getText().split(" ");
        if (EstimationReprisePP.length == 3) {
            EstimationPP = Integer.parseInt(EstimationReprisePP[0] + EstimationReprisePP[1]);
        } else {
            EstimationPP = Integer.parseInt(EstimationReprisePP[0]);
        }

        WaitS.Wait(2000);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//button[@id='BtContacterPDV2']")));
        // ElementMethodes.ClickOnXpath(driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")));
        driver.findElement(By.xpath("//button[@id='BtContacterPDV2']")).click();

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//span[@class='Estimation-value']")));
        String EstimationRepriseCP[] = driver.findElement(By.xpath("//span[@class='Estimation-value']")).getText().split(" ");
        if (EstimationRepriseCP.length == 3) {
            EstimationCP = Integer.parseInt(EstimationRepriseCP[0] + EstimationRepriseCP[1]);
        } else {
            EstimationCP = Integer.parseInt(EstimationRepriseCP[0]);
        }

        EstimationCP = Integer.parseInt(EstimationRepriseCP[0]);
        System.out.println(EstimationCP);
        System.out.println(EstimationPP);

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//div[contains(text(),'Date de mise en circulation')]")));
        DatedimatriculationPC = driver.findElement(By.xpath("//div[contains(text(),'Date de mise en circulation')]")).getText();

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//div[@class='modal-matricule-text']")));
        NumImmatriculationPC = driver.findElement(By.xpath("//div[@class='modal-matricule-text']")).getText();

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//div[contains(text(),'Marque')]")));
        MarquePC = driver.findElement(By.xpath("//div[contains(text(),'Marque')]")).getText();

        assert (EstimationCP == EstimationPP);

    }

    // @Test(priority = 2)
    public void TheLeadwithestimationHAvebeenSubmittedForPeugeotFrance() {

        driver.get("http://fr.store.peugeot.inetpsa.com/Accueil");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        ElementMethodes.CloseCokies(driver);
        driver.findElement(By.name("model")).click();
        WaitS.Wait(2000);
        new Select(driver.findElement(By.name("model"))).selectByIndex(4);
        WaitS.Wait(2000);
        driver.findElement(By.id("region")).sendKeys("Paris");
        WaitS.Wait(2000);
        driver.findElement(By.id("region")).sendKeys(Keys.ENTER);
        WaitS.Wait(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-large btn-full btn-primary btn-double submit bound']")).submit();
        WaitS.Wait(3000);
        WaitS.waitForLoad(driver);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")));
        // ElementMethodes.ClickOnXpath(driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")));
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")).click();
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//button[@id='BtContacterPDV2']")));
        // ElementMethodes.ClickOnXpath(driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")));
        driver.findElement(By.xpath("//button[@id='BtContacterPDV2']")).click();

        LeadsAP.FillContactFormFrance(driver, TestData, 2);
        LeadsAP.ClickSubmitButton(driver);
        assert (LeadsAP.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

}
