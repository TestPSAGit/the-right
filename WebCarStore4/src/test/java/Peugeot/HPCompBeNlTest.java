/*
 * Creation : 8 avr. 2019
 */
package Peugeot;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilities.InitialiseDrivers;

public class HPCompBeNlTest {
    static WebDriver driver;
    HomePageComponentsAP hp = new HomePageComponentsAP();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("http://E562418:Lm133499@be.store.peugeot.inetpsa.com/nl/Home");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        hp.CloseCokies(driver);

    }

    @Test(priority = 1)

    public void ThePageTitleisCorrect() {
        assert (hp.CheckTitlePresent(driver).equals("WEBSTORE"));
    }

    @Test(priority = 2)

    public void ThePeugeotLogoIsDisplayed() {
        assert (hp.CheckLogoPresent(driver) == true);
    }

    @Test(priority = 3)

    public void TheTextUnderThePageTitleIsCorrect() {
        assert (hp.CheckTextUnderTitlePresent(driver).equals("JE NIEUWE PEUGEOT ONMIDDELIJK LEVERBAAR UIT VOORRAAD"));
    }

    @Test(priority = 4)

    public void GotToHomePageWhenClickingOnThePeugeotLogo() {
        assert (hp.CheckClickOnHeaderPeugeotLogo(driver).contains("http://be.store.peugeot.inetpsa.com/nl/Home"));
    }

    @Test(priority = 5)

    public void TheYoutubeIconeIsPresent() {
        assert (hp.CheckTheYoutubeIconePresence(driver) == true);
    }

    @Test(priority = 6)
    public void GotYoutubePageWhenClickingTheyoutubeIcone() {
        assert (hp.CheckClickOnYoutubeIcone(driver).equals("https://www.youtube.com/user/PeugeotBelux"));

    }

    @Test(priority = 7)

    public void TheUserGeneralConditionsTextIsPresent() {
        assert (hp.CheckTheUserGeneralConditionsTextPresence(driver, "//a[contains(text(),'Algemene gebruiksvoorwaarden')]") == true);
    }

    @Test(priority = 8)

    public void GotTheUserGeneralConditionsPage() {
        assert (hp.CheckClickOnUserGeneralConditions(driver, "//a[contains(text(),'Algemene gebruiksvoorwaarden')]"))
                .contains("https://webstore.peugeot.be/MentionsPages/nl-BE/mention.htm");

    }

    @Test(priority = 23)

    public void GotTheRightUrlWhenClickingOnCarConfiguratorLink() {

        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Configureer je wagen')]");
        assert (Result[0].contains("www.peugeot.be/nl/gamma/onze-modellen.html"));
        assert (Result[1] != "true");
    }

    @Test(priority = 25)

    public void GotTheRightUrlWhenClickingOnCarAccessoriesLink() {

        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Peugeot Accessoires')]");
        assert (Result[0].contains("accessoires.peugeot.be/nl-BE/accessoires"));
        assert (Result[1] != "true");

    }

    @Test(priority = 26)

    public void GotTheRightUrlWhenClickingOnUsedCarsLink() {

        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Peugeot occasiewagens')]");
        assert (Result[0].contains("peugeot-occasionsdulion.be/nlbe/home"));
        assert (Result[1] != "true");

    }

    @Test(priority = 29)

    public void GotTheRightUrlWhenClickingOnTheFAQLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'FAQ')]");
        assert (Result[0].contains("XXX"));

    }

    @Test(priority = 30)

    public void GotTheRightUrlWhenClickingOnTheDealersLink() {

        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Verkooppunten')]");
        assert (Result[0].contains("www.peugeot.be/nl/verkooppunten.html"));
        assert (Result[1] != "true");

    }

    @AfterSuite

    public void AfterTest() {
        HomePageComponentsAP.SwitchToCurrentUrl(driver);
        driver.close();

    }

}
