/*
 * Creation : 28 mai 2019
 */
package Peugeot;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.InitialiseDrivers;

public class ProductPageFrTest {
    static WebDriver driver;
    static Date DeliveryDate;
    static Date currentDate;
    static int[] OffersNum;
    static int[] OffersNum1;
    static int Error;

    public void InitialiseUrl(String URL) {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get(URL);
        driver.manage().deleteAllCookies();
        Dimension d = new Dimension(1382, 744);

        // Resize the current window to the given dimension
        driver.manage().window().maximize();

        System.out.println("toto");
        try {
            driver.findElement(By.className("psac_noselect")).click();
        } catch (NoSuchElementException e) {
            // System.out.println("Impossible to click the pop-up. Reason");
        }

        ProductPage.ClickOnCarDetails(driver);

    }

    @Test(dataProvider = "UrlsProvider", priority = 0)
    public void OpenBrowse(String URL) {
        InitialiseUrl(URL);

    }

    @Test(dataProvider = "UrlsProvider", priority = 1)
    public void ThePriceInTheProductPageIsEqualToThePriceInThePopoup(String URL) {
        System.out.println("momo");
        int PTTCPP = ProductPage.GetTheTTCPriceFromTheProductPage(driver);
        System.out.println("The price from the first" + PTTCPP);
        ProductPage.ClickOnPriceDetails(driver);
        System.out.println(driver.findElement(By
                .xpath("//div[@class='tingle-modal-box__content']//div[@class='order-bar-desc'][contains(text(),'308 Style PureTech 110 S&S BVM6')]"))
                .getText());

        // int PTTCPP = ProductPageAC.GetTheTTCPriceFromTheProductPage(driver);
        // System.out.println("The price from the first" + PTTCPP);
        int PTTCHO = ProductPage.GetTheTTCHOptionPriceFromThePopUp(driver);
        System.out.println("the second" + PTTCHO);
        int PTTCPO = ProductPage.GetTheTTCPriceFromThePopUp(driver);
        System.out.println("The third" + PTTCPO);
        ProductPage.ClosePriceDetailsPopUp(driver);

        assert (PTTCPP == PTTCPO);

    }

    @Test(dataProvider = "UrlsProvider", priority = 2)
    public void ThePricebeforeOptionsIsLowerThanTheTTCPrice(String URL) {

        ProductPage.ClickOnPriceDetails(driver);
        int PTTCHO = ProductPage.GetTheTTCHOptionPriceFromThePopUp(driver);
        int PTTCAO = ProductPage.GetTheTTCPriceFromThePopUp(driver);

        ProductPage.ClosePriceDetailsPopUp(driver);

        assert (PTTCHO < PTTCAO);

    }

    @Test(dataProvider = "UrlsProvider", priority = 3)
    public void ThePopupPriceDetailsCanBeOpened(String URL) {

        ProductPage.ClickOnPriceDetails(driver);
        assert (ProductPage.GetThePopupPriceDetailsTitle(driver) == true);
        ProductPage.ClosePriceDetailsPopUp(driver);

    }

    @Test(dataProvider = "UrlsProvider", priority = 4)
    public void ThePopupPriceDetailsCanBeClosed(String URL) {
        ProductPage.ClickOnPriceDetails(driver);
        assert (ProductPage.ThePopupPriceDetailsCloseCrossIsClickable(driver) == true);
        ProductPage.ClosePriceDetailsPopUp(driver);

    }

    @Test(dataProvider = "UrlsProvider", priority = 5)

    public void ThePriceEstimationCanBeOpened(String URL) {

        ProductPage.OpenEstimation(driver);
        assert (ProductPage.GetTheEstmationPopupTitle(driver) == true);
        ProductPage.CloseEstimation(driver);

    }

    @Test(dataProvider = "UrlsProvider", priority = 6)
    public void ThePriceEstimationCanBeClosed(String URL) {

        ProductPage.OpenEstimation(driver);
        assert (ProductPage.ThePopupEstimationCloseCrossIsClickable(driver) == true);
        ProductPage.CloseEstimation(driver);

    }

    @Test(dataProvider = "UrlsProvider", priority = 7)
    public void The360ViewIsDisplayed(String URL) {

        ((JavascriptExecutor) driver).executeScript("scroll(0,250);");
        ProductPage.ClickOn360View(driver);
        assert (ProductPage.The360viewIsVisible(driver) == true);

    }

    @Test(dataProvider = "UrlsProvider", priority = 8)
    public void TheExternalImageIsDisplayed(String URL) {
        ((JavascriptExecutor) driver).executeScript("scroll(0,250);");
        ProductPage.ClickOnExternalView(driver);
        assert (ProductPage.TheExternalImageIsVisible(driver) == true);

    }

    @Test(dataProvider = "UrlsProvider", priority = 9)
    public void TheInternalImageIsDisplayed(String URL) {

        ((JavascriptExecutor) driver).executeScript("scroll(0,250);");
        ProductPage.ClickOnInternalView(driver);
        assert (ProductPage.TheInternalImageIsVisible(driver) == true);

    }

    @DataProvider(name = "UrlsProvider")
    public Object[][] UrlsTobeTested1() {

        Object[][] URLS = new Object[][] { {
                "http://fr.store.peugeot.inetpsa.com/Recherche-par-critere?lat=48.856614&lng=2.3522219000000177&LocationL=Paris%2C%20France&etd=0&mbd=1PT9S0000030" } };
        return URLS;

    }

    @AfterSuite

    public void AfterTest() {

        // driver.quit();
    }
}
