/*
 * Creation : 1 avr. 2019
 */
package DS;

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
        // driver = InitialiseDrivers.InitialiseChromDriver();
        TestData = Utilities.ReadExcelFile.GetTestData("C:\\Users\\E562418\\git\\PSAWSCS\\WebCarStore\\TestData\\testData.xlsx", 1);
    }

    @Test(priority = 1)
    public void TheLeadHAvebeenSubmittedForDSFrance() {

        driver.get("http:fr.store.ds.inetpsa.com");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")));
        driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")).click();

        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//div[@id='my-modal-carselector']//li[3]")));
        driver.findElement(By.xpath("//div[@id='my-modal-carselector']//li[3]")).click();

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double citroen-validate-button hidden-tablet hidden-phone']")));
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double citroen-validate-button hidden-tablet hidden-phone']")).click();

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.id("postalcode")));
        driver.findElement(By.id("postalcode")).sendKeys("Paris");
        driver.findElement(By.id("postalcode")).sendKeys(Keys.ENTER);

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
        LeadsDS.FillContactFormFrance(driver, TestData, 2);
        LeadsDS.ClickSubmitButton(driver);
        assert (LeadsDS.GetTheConfirmationMessage(driver) == true);
        driver.close();
    }

    @Test(priority = 2)
    public void TheLeadwithEstimationHavebeenSubmittedForDSFrance() {

        driver.get("https://es.store.ds.inetpsa.com");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")));
        driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")).click();

        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//div[@id='my-modal-carselector']//li[3]")));
        driver.findElement(By.xpath("//div[@id='my-modal-carselector']//li[3]")).click();

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double citroen-validate-button hidden-tablet hidden-phone']")));
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double citroen-validate-button hidden-tablet hidden-phone']")).click();

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.id("postalcode")));
        driver.findElement(By.id("postalcode")).sendKeys("Paris");
        driver.findElement(By.id("postalcode")).sendKeys(Keys.ENTER);

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
        LeadsDS.FillContactFormFrance(driver, TestData, 2);
        LeadsDS.ClickSubmitButton(driver);
        assert (LeadsDS.GetTheConfirmationMessage(driver) == true);
        driver.close();
    }

    @Test(priority = 2)
    public void TheLeadHAvebeenSubmittedForDSSpain() {

        driver.get("http://es.store.ds.inetpsa.com");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")));
        driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")).click();

        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//div[@id='my-modal-carselector']//li[1]")));
        driver.findElement(By.xpath("//div[@id='my-modal-carselector']//li[1]")).click();

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double citroen-validate-button hidden-tablet hidden-phone']")));
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double citroen-validate-button hidden-tablet hidden-phone']")).click();

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.id("postalcode")));
        driver.findElement(By.id("postalcode")).sendKeys("Madrid");
        driver.findElement(By.id("postalcode")).sendKeys(Keys.ENTER);

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

        LeadsDS.FillContactFormSpain(driver, TestData, 4);
        LeadsDS.ClickSubmitButton(driver);
        assert (LeadsDS.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 3)
    public void TheLeadHAvebeenSubmittedForDSItaly() {

        driver.get("https://dsonlinestore.dsautomobiles.it");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")));
        driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")).click();

        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//div[@id='my-modal-carselector']//li[1]")));
        driver.findElement(By.xpath("//div[@id='my-modal-carselector']//li[1]")).click();

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double citroen-validate-button hidden-tablet hidden-phone']")));
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double citroen-validate-button hidden-tablet hidden-phone']")).click();

        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.id("postalcode")));
        driver.findElement(By.id("postalcode")).sendKeys("Roma");
        driver.findElement(By.id("postalcode")).sendKeys(Keys.ENTER);
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
        LeadsDS.FillContactFormItaly(driver, TestData, 6);
        LeadsDS.ClickSubmitButton(driver);
        assert (LeadsDS.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 4)
    public void TheLeadHAvebeenSubmittedForDSBelgiumFR() {

        driver.get("https://dsonlinestore.dsautomobiles.be/fr/");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")));
        driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//div[@id='my-modal-carselector']//li[1]")));
        driver.findElement(By.xpath("//div[@id='my-modal-carselector']//li[1]")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double citroen-validate-button hidden-tablet hidden-phone']")));
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double citroen-validate-button hidden-tablet hidden-phone']")).click();
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
        LeadsDS.FillContactFormBelgiumFR(driver, TestData, 8);

        LeadsDS.ClickSubmitButton(driver);
        assert (LeadsDS.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    @Test(priority = 5)
    public void TheLeadHAvebeenSubmittedForDSBelgiumNL() {

        driver.get("https://dsonlinestore.dsautomobiles.be/nl/");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);

        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")));
        driver.findElement(By.xpath("//form[@id='form-models']//a[@class='btn btn-add see-gamut default']")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//div[@id='my-modal-carselector']//li[1]")));
        driver.findElement(By.xpath("//div[@id='my-modal-carselector']//li[1]")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeClickable(driver,
                driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double citroen-validate-button hidden-tablet hidden-phone']")));
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double citroen-validate-button hidden-tablet hidden-phone']")).click();
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
        LeadsDS.FillContactFormBelgiumNL(driver, TestData, 10);
        LeadsDS.ClickSubmitButton(driver);
        assert (LeadsDS.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

}
