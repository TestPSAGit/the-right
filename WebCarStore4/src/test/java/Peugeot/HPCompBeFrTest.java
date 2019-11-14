/*
 * Creation : 8 avr. 2019
 */
package Peugeot;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilities.InitialiseDrivers;

public class HPCompBeFrTest {
    static WebDriver driver;
    HomePageComponentsAP hp = new HomePageComponentsAP();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("http://E562418:Lm133499@be.store.peugeot.inetpsa.com/fr/Accueil");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // driver.findElement(By.className("psac_noselect")).click();

    }

    // @TestFunctions(priority = 1)

    public void ThePageTitleisCorrect() {
        assert (hp.CheckTitlePresent(driver).equals("WEBSTORE"));
    }

    @Test(priority = 2)

    public void ThePeugeotLogoIsDisplayed() {
        assert (hp.CheckLogoPresent(driver) == true);
    }

    @Test(priority = 7)

    public void TheTextUnderThePageTitleIsCorrect() {
        assert (hp.CheckTextUnderTitlePresent(driver).equals("RECHERCHE ET ACHAT DE VÉHICULES NEUFS PEUGEOT DISPONIBLES IMMÉDIATEMENT"));
    }

    @Test(priority = 8)

    public void GotToHomePageWhenClickingOnThePeugeotLogo() {
        assert (hp.CheckClickOnHeaderPeugeotLogo(driver).contains("http://be.store.peugeot.inetpsa.com/fr/Accueil"));
    }

    @Test(priority = 11)

    public void TheFacebookIconeIsPresent() {
        assert (hp.CheckTheFacebookIconePresence(driver) == true);
    }

    @Test(priority = 12)

    public void TheYoutubeIconeIsPresent() {
        assert (hp.CheckTheYoutubeIconePresence(driver) == true);
    }

    @Test(priority = 14)

    public void GotFacebookPageWhenClickingTheFacebookIcone() {
        assert (hp.CheckClickOnFacebookIcone(driver).equals("https://www.facebook.com/PeugeotBelux/"));

    }

    @Test(priority = 15)
    public void GotYoutubePageWhenClickingTheyoutubeIcone() {
        assert (hp.CheckClickOnYoutubeIcone(driver).equals("https://www.youtube.com/user/PeugeotBelux"));

    }

    @Test(priority = 16)

    public void TheUserGeneralConditionsTextIsPresent() {
        assert (hp.CheckTheUserGeneralConditionsTextPresence(driver, "//a[contains(text(),\"Conditions générales d'utilisation\")]") == true);
    }

    @Test(priority = 18)

    public void TheCookiesTextIsPresent() {
        assert (hp.CheckTheCookiestextPresence(driver) == true);
    }

    @Test(priority = 19)

    public void GotTheUserGeneralConditionsPage() {
        assert (hp.CheckClickOnUserGeneralConditions(driver, "//a[contains(text(),\"Conditions générales d'utilisation\")]"))
                .contains("https://webstore.peugeot.be/MentionsPages/fr-BE/mention.htm");

    }

    @Test(priority = 21)

    public void GotTheCookiesPopUp() {
        assert (hp.CheckClickOnCookies(driver) == true);
    }

    @Test(priority = 23)

    public void GotTheRightUrlWhenClickingOnCarConfiguratorLink() {

        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Configurez votre véhicule')]");
        assert (Result[0].contains("www.peugeot.be/fr/gamme/nos-modeles.html"));
        assert (Result[1] != "true");
    }

    @Test(priority = 25)

    public void GotTheRightUrlWhenClickingOnCarAccessoriesLink() {

        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Peugeot Accessoires')]");
        assert (Result[0].contains("accessoires.peugeot.be/fr-BE/accessoires"));
        assert (Result[1] != "true");

    }

    @Test(priority = 26)

    public void GotTheRightUrlWhenClickingOnUsedCarsLink() {

        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),\"Véhicules d'occasion Peugeot\")]");
        assert (Result[0].contains("peugeot-occasionsdulion.be/frbe/accueil"));
        assert (Result[1] != "true");

    }

    @Test(priority = 30)

    public void GotTheRightUrlWhenClickingOnTheDealersLink() {

        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Points de vente')]");
        assert (Result[0].contains("www.peugeot.be/fr/points-de-vente.html"));
        assert (Result[1] != "true");

    }

    @AfterSuite

    public void AfterTest() {
        HomePageComponentsAP.SwitchToCurrentUrl(driver);
        driver.close();

    }

}
