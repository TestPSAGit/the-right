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

public class LeadsTestProd {
    static WebDriver driver;
    public String[][] TestData;

    @BeforeMethod

    public void BeforeTest() throws IOException {
        driver = InitialiseDrivers.InitialiseChromDriver();
        TestData = Utilities.ReadExcelFile.GetTestData("C:\\Users\\E562418\\git\\PSAWSCS\\WebCarStore\\TestData\\testData.xlsx", 0);
    }

    @Test(priority = 1)
    public void Litetest() {

        driver.get(
                "http://E562418:Fh133499@fr.store.peugeot.inetpsa.com/Recherche-par-critere?lat=48.856614&lng=2.3522219000000177&LocationL=Paris%2C%20France&etd=0&mbd=1PIAS0000030;");

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        ElementMethodes.CloseCokies(driver);

        System.out.println("This is the page url>>>>>>> Home >>>>>>" + driver.getCurrentUrl());
        WaitS.waitForLoad(driver);
        driver.findElement(By.xpath("//img[@class='Peugeot_lion']")).click();
        WaitS.waitForLoad(driver);
        WaitS.Wait(2000);
        System.out.println("This is the page url" + driver.getCurrentUrl());
        WaitS.Wait(1000);
        ElementMethodes.CloseCokies(driver);
        WaitS.waitForLoad(driver);
        // driver.findElement(By.name("model")).getText();
        driver.findElement(By.name("model")).click();
        WaitS.Wait(3000);
        new Select(driver.findElement(By.name("model"))).selectByIndex(4);
        WaitS.Wait(3000);
        driver.findElement(By.id("region")).sendKeys("Paris");
        WaitS.Wait(3000);
        driver.findElement(By.id("region")).sendKeys(Keys.ENTER);
        WaitS.Wait(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-large btn-full btn-primary btn-double submit bound']")).submit();

        WaitS.Wait(2000);
        WaitS.waitForLoad(driver);
        System.out.println("This is the page url*****************************  " + driver.getCurrentUrl());
        System.out.println("////////////////////////////////////////////////////////////////////////////");
        driver.close();

    }

    // @Test(priority = 2)
    public void TheLeadHAvebeenSubmittedForPeugeotSpain() {

        driver.get("http://es.store.peugeot.inetpsa.com/HOME");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);
        driver.findElement(By.name("model")).click();
        WaitS.Wait(1000);
        new Select(driver.findElement(By.name("model"))).selectByIndex(4);
        WaitS.Wait(1000);
        driver.findElement(By.id("region")).sendKeys("Madrid");
        WaitS.Wait(2000);
        driver.findElement(By.id("region")).sendKeys(Keys.ENTER);
        WaitS.Wait(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-large btn-full btn-primary btn-double submit bound']")).submit();
        WaitS.Wait(3000);
        WaitS.waitForLoad(driver);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")));

        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")).click();
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//button[@id='BtContacterPDV']")));

        driver.findElement(By.xpath("//button[@id='BtContacterPDV']")).click();
        LeadsAP.FillContactFormSpain(driver, TestData, 4);
        LeadsAP.ClickSubmitButton(driver);
        assert (LeadsAP.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    // @Test(priority = 3)
    public void TheLeadHAvebeenSubmittedForPeugeotItaly() {

        driver.get("http://it.store.peugeot.inetpsa.com/HOME");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);
        driver.findElement(By.name("model")).click();
        WaitS.Wait(1000);
        new Select(driver.findElement(By.name("model"))).selectByIndex(4);
        WaitS.Wait(1000);
        driver.findElement(By.id("region")).sendKeys("Roma");
        WaitS.Wait(1000);
        driver.findElement(By.id("region")).sendKeys(Keys.ENTER);
        WaitS.Wait(1000);
        driver.findElement(By.xpath("//button[@class='btn btn-large btn-full btn-primary btn-double submit bound']")).submit();
        WaitS.Wait(3000);
        WaitS.waitForLoad(driver);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")));

        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")).click();
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//button[@id='BtContacterPDV']")));

        driver.findElement(By.xpath("//button[@id='BtContacterPDV']")).click();
        LeadsAP.FillContactFormItaly(driver, TestData, 6);
        LeadsAP.ClickSubmitButton(driver);
        assert (LeadsAP.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    // @Test(priority = 4)
    public void TheLeadHAvebeenSubmittedForPeugeotBelgiumFR() {

        driver.get("http://be.store.peugeot.inetpsa.com/fr/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        ElementMethodes.CloseCokies(driver);
        driver.findElement(By.name("model")).click();
        WaitS.Wait(1000);
        new Select(driver.findElement(By.name("model"))).selectByIndex(4);
        driver.findElement(By.xpath("//button[@class='btn btn-large btn-full btn-primary btn-double submit bound']")).submit();
        WaitS.Wait(3000);
        WaitS.waitForLoad(driver);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")));

        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")).click();
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//button[@id='BtContacterPDV']")));

        driver.findElement(By.xpath("//button[@id='BtContacterPDV']")).click();
        LeadsAP.FillContactFormBelgiumFR(driver, TestData, 8);
        LeadsAP.ClickSubmitButton(driver);
        assert (LeadsAP.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    // @Test(priority = 5)
    public void TheLeadHAvebeenSubmittedForPeugeotBelgiumNL() {

        driver.get("http://be.store.peugeot.inetpsa.com/nl/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        ElementMethodes.CloseCokies(driver);
        driver.findElement(By.name("model")).click();
        WaitS.Wait(1000);
        new Select(driver.findElement(By.name("model"))).selectByIndex(4);
        driver.findElement(By.xpath("//button[@class='btn btn-large btn-full btn-primary btn-double submit bound']")).submit();
        WaitS.Wait(3000);
        WaitS.waitForLoad(driver);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")));

        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")).click();
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//button[@id='BtContacterPDV']")));

        driver.findElement(By.xpath("//button[@id='BtContacterPDV']")).click();
        LeadsAP.FillContactFormBelgiumNL(driver, TestData, 10);
        LeadsAP.ClickSubmitButton(driver);
        assert (LeadsAP.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

    // @Test(priority = 6)
    public void TheLeadHAvebeenSubmittedForPeugeotPortugal() {

        driver.get("http://pt.store.peugeot.inetpsa.com/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();
        ElementMethodes.CloseCokies(driver);
        driver.findElement(By.name("model")).click();
        WaitS.Wait(1000);
        new Select(driver.findElement(By.name("model"))).selectByIndex(4);
        WaitS.Wait(1000);
        driver.findElement(By.id("region")).sendKeys("Porto");
        WaitS.Wait(1000);
        driver.findElement(By.id("region")).sendKeys(Keys.ENTER);
        WaitS.Wait(1000);
        driver.findElement(By.xpath("//button[@class='btn btn-large btn-full btn-primary btn-double submit bound']")).submit();
        WaitS.Wait(3000);
        WaitS.waitForLoad(driver);
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")));

        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-double detail-link clickDetail']")).click();
        WaitS.WaitForElementToBeClickable(driver, driver.findElement(By.xpath("//button[@id='BtContacterPDV']")));

        driver.findElement(By.xpath("//button[@id='BtContacterPDV']")).click();
        LeadsAP.FillContactFormPortugal(driver, TestData, 12);
        LeadsAP.ClickSubmitButton(driver);
        assert (LeadsAP.GetTheConfirmationMessage(driver) == true);
        driver.close();

    }

}
