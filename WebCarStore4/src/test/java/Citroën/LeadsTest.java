/*
 * Creation : 1 avr. 2019
 */
package Citroën;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.ElementMethodes;
import Utilities.InitialiseDrivers;
import Utilities.WaitS;

public class LeadsTest {
    static WebDriver driver;
    public String[][] TestData;

    @BeforeMethod
    public void BeforeTest() throws IOException {
        driver = InitialiseDrivers.InitialiseChromDriver();
        TestData = Utilities.ReadExcelFile.GetTestData("C:\\Users\\E562418\\git\\PSAWSCS\\WebCarStore\\TestData\\testData.xlsx", 2);

    }

    @Test(priority = 1)
    public void TheLeadHAvebeenSubmittedForCitroënFrance() {

        driver.get("http://E562418:Lm133499@fr.store.citroen.inetpsa.com");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")));
        driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//div[@id='tabs-1']//li[6]")));
        driver.findElement(By.xpath("//div[@id='tabs-1']//li[6]")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-blue btn-double citroen-validate-button hidden-tablet hidden-phone']")));
        WaitS.Wait(1000);
        driver.findElement(By.xpath("//a[@class='btn btn-blue btn-double citroen-validate-button hidden-tablet hidden-phone']")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.id("postalcode")));
        WaitS.Wait(1000);
        driver.findElement(By.id("postalcode")).sendKeys("Paris");
        WaitS.Wait(1000);
        driver.findElement(By.id("postalcode")).sendKeys(Keys.ENTER);
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//button[@class='btn btn-orange btn-double btn-full']")));
        driver.findElement(By.xpath("//form[@id='form-models']//button[@class='btn btn-orange btn-double btn-full']")).click();
        WaitS.Wait(3000);
        WaitS.waitForLoad(driver);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-lavender-grey btn-double btn-details linkProductPage']")));
        driver.findElement(By.xpath("//a[@class='btn btn-lavender-grey btn-double btn-details linkProductPage']")).click();
        WaitS.waitForLoad(driver);

        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//button[@id='BtContacterPDV2']")));
        driver.findElement(By.xpath("//button[@id='BtContacterPDV2']")).click();
        WaitS.waitForLoad(driver);

        LeadsAC.FillContactFormFrance(driver, TestData, 2);
        LeadsAC.ClickSubmitButton(driver);
        WaitS.Wait(3000);
        assert (LeadsAC.GetTheConfirmationMessage(driver) == true);
        driver.close();
    }

    @Test(priority = 2)
    public void TheLeadHAvebeenSubmittedForCitroënSpain() {

        driver.get("https://E562418:Lm133499@carstore.citroen.es/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")));
        driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//div[@id='tabs-1']//li[6]")));
        driver.findElement(By.xpath("//div[@id='tabs-1']//li[6]")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-blue btn-double citroen-validate-button hidden-tablet hidden-phone']")));
        driver.findElement(By.xpath("//a[@class='btn btn-blue btn-double citroen-validate-button hidden-tablet hidden-phone']")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.id("postalcode")));
        driver.findElement(By.id("postalcode")).sendKeys("Madrid");
        WaitS.Wait(1000);
        driver.findElement(By.id("postalcode")).sendKeys(Keys.ENTER);
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//button[@class='btn btn-orange btn-double btn-full']")));
        driver.findElement(By.xpath("//form[@id='form-models']//button[@class='btn btn-orange btn-double btn-full']")).click();
        WaitS.Wait(3000);
        WaitS.waitForLoad(driver);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-lavender-grey btn-double btn-details linkProductPage']")));
        driver.findElement(By.xpath("//a[@class='btn btn-lavender-grey btn-double btn-details linkProductPage']")).click();
        WaitS.waitForLoad(driver);

        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//button[@id='BtContacterPDV']")));
        driver.findElement(By.xpath("//button[@id='BtContacterPDV']")).click();
        WaitS.Wait(10000);
        WaitS.waitForLoad(driver);
        LeadsAC.FillContactFormSpain(driver, TestData, 4);
        LeadsAC.ClickSubmitButton(driver);
        WaitS.Wait(2000);
        assert (LeadsAC.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 3)
    public void TheLeadHAvebeenSubmittedForCitroënItaly() {

        driver.get("http://E562418:Lm133499@it.store.citroen.inetpsa.com/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")));
        driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//div[@id='tabs-1']//li[6]")));
        driver.findElement(By.xpath("//div[@id='tabs-1']//li[6]")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-blue btn-double citroen-validate-button hidden-tablet hidden-phone']")));
        driver.findElement(By.xpath("//a[@class='btn btn-blue btn-double citroen-validate-button hidden-tablet hidden-phone']")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.id("postalcode")));
        driver.findElement(By.id("postalcode")).sendKeys("Roma");
        WaitS.Wait(1000);
        driver.findElement(By.id("postalcode")).sendKeys(Keys.ENTER);
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//button[@class='btn btn-orange btn-double btn-full']")));
        driver.findElement(By.xpath("//form[@id='form-models']//button[@class='btn btn-orange btn-double btn-full']")).click();
        WaitS.Wait(3000);
        WaitS.waitForLoad(driver);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-lavender-grey btn-double btn-details linkProductPage']")));
        driver.findElement(By.xpath("//a[@class='btn btn-lavender-grey btn-double btn-details linkProductPage']")).click();
        WaitS.waitForLoad(driver);

        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//button[@id='BtContacterPDV']")));
        driver.findElement(By.xpath("//button[@id='BtContacterPDV']")).click();
        WaitS.waitForLoad(driver);
        LeadsAC.FillContactFormItaly(driver, TestData, 6);
        LeadsAC.ClickSubmitButton(driver);
        WaitS.Wait(4000);
        assert (LeadsAC.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 4)
    public void TheLeadHAvebeenSubmittedForCitroënBelgiumFR() {

        driver.get("http://E562418:Lm133499@be.store.citroen.inetpsa.com/fr/");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")));
        driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//div[@id='tabs-1']//li[6]")));
        driver.findElement(By.xpath("//div[@id='tabs-1']//li[6]")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-blue btn-double citroen-validate-button hidden-tablet hidden-phone']")));
        driver.findElement(By.xpath("//a[@class='btn btn-blue btn-double citroen-validate-button hidden-tablet hidden-phone']")).click();
        WaitS.Wait(1000);

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//button[@class='btn btn-orange btn-double btn-full']")));
        driver.findElement(By.xpath("//form[@id='form-models']//button[@class='btn btn-orange btn-double btn-full']")).click();
        WaitS.Wait(3000);
        WaitS.waitForLoad(driver);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-lavender-grey btn-double btn-details linkProductPage']")));
        driver.findElement(By.xpath("//a[@class='btn btn-lavender-grey btn-double btn-details linkProductPage']")).click();
        WaitS.waitForLoad(driver);

        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//button[@id='BtContacterPDV']")));
        driver.findElement(By.xpath("//button[@id='BtContacterPDV']")).click();
        WaitS.waitForLoad(driver);
        LeadsAC.FillContactFormBelgiumFR(driver, TestData, 8);
        LeadsAC.ClickSubmitButton(driver);
        WaitS.Wait(4000);
        assert (LeadsAC.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 5)
    public void TheLeadHAvebeenSubmittedForCitroënBelgiumNL() {

        driver.get("http://E562418:Lm133499@be.store.citroen.inetpsa.com/nl/");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")));
        driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//div[@id='tabs-1']//li[6]")));
        driver.findElement(By.xpath("//div[@id='tabs-1']//li[6]")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-blue btn-double citroen-validate-button hidden-tablet hidden-phone']")));
        driver.findElement(By.xpath("//a[@class='btn btn-blue btn-double citroen-validate-button hidden-tablet hidden-phone']")).click();
        WaitS.Wait(1000);

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//button[@class='btn btn-orange btn-double btn-full']")));
        driver.findElement(By.xpath("//form[@id='form-models']//button[@class='btn btn-orange btn-double btn-full']")).click();
        WaitS.Wait(3000);
        WaitS.waitForLoad(driver);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-lavender-grey btn-double btn-details linkProductPage']")));
        driver.findElement(By.xpath("//a[@class='btn btn-lavender-grey btn-double btn-details linkProductPage']")).click();
        WaitS.waitForLoad(driver);

        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//button[@id='BtContacterPDV']")));
        driver.findElement(By.xpath("//button[@id='BtContacterPDV']")).click();
        WaitS.waitForLoad(driver);
        LeadsAC.FillContactFormBelgiumNL(driver, TestData, 10);
        LeadsAC.ClickSubmitButton(driver);
        WaitS.Wait(4000);
        assert (LeadsAC.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 6)
    public void TheLeadHAvebeenSubmittedForPortugal() {

        driver.get("http://E562418:Lm133499@pt.store.citroen.inetpsa.com");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")));
        driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//div[@id='tabs-1']//li[6]")));
        driver.findElement(By.xpath("//div[@id='tabs-1']//li[6]")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-blue btn-double citroen-validate-button hidden-tablet hidden-phone']")));
        driver.findElement(By.xpath("//a[@class='btn btn-blue btn-double citroen-validate-button hidden-tablet hidden-phone']")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.id("postalcode")));
        WaitS.Wait(1000);
        driver.findElement(By.id("postalcode")).sendKeys("Porto");
        WaitS.Wait(1000);
        driver.findElement(By.id("postalcode")).sendKeys(Keys.ENTER);
        WaitS.Wait(1000);

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//button[@class='btn btn-orange btn-double btn-full']")));
        driver.findElement(By.xpath("//form[@id='form-models']//button[@class='btn btn-orange btn-double btn-full']")).click();
        WaitS.Wait(3000);
        WaitS.waitForLoad(driver);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-lavender-grey btn-double btn-details linkProductPage']")));
        driver.findElement(By.xpath("//a[@class='btn btn-lavender-grey btn-double btn-details linkProductPage']")).click();
        WaitS.waitForLoad(driver);

        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//button[@id='BtContacterPDV']")));
        driver.findElement(By.xpath("//button[@id='BtContacterPDV']")).click();
        WaitS.waitForLoad(driver);
        LeadsAC.FillContactFormPortugal(driver, TestData, 12);
        LeadsAC.ClickSubmitButton(driver);
        WaitS.Wait(4000);
        assert (LeadsAC.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }
}
