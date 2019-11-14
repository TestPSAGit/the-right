/*
 * Creation : 8 avr. 2019
 */
package Peugeot;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilities.InitialiseDrivers;

public class HPCompPtTest {
    static WebDriver driver;
    HomePageComponentsAP hp = new HomePageComponentsAP();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://E562418:Lm133499@webstore.peugeot.it/HOME");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        hp.CloseCokies(driver);
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
        assert (hp.CheckTextUnderTitlePresent(driver).equals("ACQUISTA LA TUA VETTURA PEUGEOT NUOVA O A KM ZERO VICINO A TE A PREZZI CONVENIENTI"));
    }

    @Test(priority = 8)

    public void GotToHomePageWhenClickingOnThePeugeotLogo() {
        assert (hp.CheckClickOnHeaderPeugeotLogo(driver).contains("https://webstore.peugeot.it/HOME"));
    }

    @Test(priority = 10)

    public void TheTwiterIconeIsPresent() {
        assert (hp.CheckTheTwiterIconePresence(driver) == true);
    }

    @Test(priority = 11)

    public void TheFacebookIconeIsPresent() {
        assert (hp.CheckTheFacebookIconePresence(driver) == true);
    }

    @Test(priority = 12)

    public void TheYoutubeIconeIsPresent() {
        assert (hp.CheckTheYoutubeIconePresence(driver) == true);
    }

    @Test(priority = 13)
    public void GotTwiterPageWhenClickingTheTwiterIcone() {
        assert (hp.CheckClickOnTwiterIcone(driver).equals("https://twitter.com/peugeotitalia"));
    }

    @Test(priority = 14)

    public void GotFacebookPageWhenClickingTheFacebookIcone() {
        assert (hp.CheckClickOnFacebookIcone(driver).equals("https://www.facebook.com/peugeotitalia/"));

    }

    @Test(priority = 15)
    public void GotYoutubePageWhenClickingTheyoutubeIcone() {
        assert (hp.CheckClickOnYoutubeIcone(driver).equals("https://www.youtube.com/user/peugeotitalia"));

    }

    @Test(priority = 16)

    public void TheUserGeneralConditionsTextIsPresent() {
        assert (hp.CheckTheUserGeneralConditionsTextPresence(driver, "//a[contains(text(),'Condizioni generali')]") == true);
    }

    @Test(priority = 18)

    public void TheCookiesTextIsPresent() {
        assert (hp.CheckTheCookiestextPresence(driver) == true);
    }

    @Test(priority = 19)

    public void GotTheGeneralInformationPage() {
        assert (hp.CheckClickOnUserGeneralConditions(driver, "//a[contains(text(),'Condizioni generali')]"))
                .contains("webstore.peugeot.it/MentionsPages/it-IT/mention.htm");

    }

    @Test(priority = 21)

    public void GotTheCookiesPopUp() {
        assert (hp.CheckClickOnCookies(driver) == true);
    }

    @Test(priority = 23)

    public void GotTheRightUrlWhenClickingOnCarConfiguratorLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Configura la tua Peugeot')]");
        assert (Result[0].contains("www.peugeot.it/gamma/gamma-modelli.html"));
        assert (Result[1] != "true");
    }

    @Test(priority = 24)

    public void GotTheRightUrlWhenClickingOnProfessionalCarsLink() {

        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Gamma professional Peugeot')]");
        assert (Result[0].contains("professional.peugeot.it/peugeot-auto-italia.html"));
        assert (Result[1] != "true");

    }

    @Test(priority = 25)

    public void GotTheRightUrlWhenClickingOnCarAccessoriesLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Peugeot accessori')]");
        assert (Result[0].contains("www.peugeot.it/post-vendita/ricambi-e-accessori/accessori-peugeot.html"));
        assert (Result[1] != "true");

    }

    @Test(priority = 26)

    public void GotTheRightUrlWhenClickingOnUsedCarsLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Usato Peugeot')]");
        assert (Result[0].contains("www.peugeotoccasioni.it/trova-veicoli-usati"));
        assert (Result[1] != "true");

    }

    // @Test(priority = 27)

    public void GotTheRightUrlWhenClickingOnWebsotrePaimentLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Le paiement sur Webstore')]");
        assert (Result[0].contains("www.peugeotwebstore.com/FAQ#Paiement"));
        assert (Result[1] != "true");

    }

    // @Test(priority = 27)

    public void GotTheRightUrlWhenClickingOnTheOrderStepsLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Les étapes de mon achat')]");
        assert (Result[0].contains("www.peugeotwebstore.com/FAQ#Commande"));
        assert (Result[1] != "true");

    }

    // @Test(priority = 28)

    public void GotTheRightUrlWhenClickingOnTheDelieveryStepsLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Modalités de livraison')]");
        assert (Result[0].contains("www.peugeotwebstore.com/FAQ#LivraisonContactConcessionnaire"));
        assert (Result[1] != "true");

    }

    // @Test(priority = 29)

    public void GotTheRightUrlWhenClickingOnTheFAQLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'FAQ')]");
        assert (Result[0].contains("www.peugeotwebstore.com/FAQ"));

    }

    @Test(priority = 30)

    public void GotTheRightUrlWhenClickingOnTheDealersLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'La nostra rete')]");
        assert (Result[0].contains("www.peugeot.it/la-nostra-rete.html"));
        assert (Result[1] != "true");

    }

    @AfterSuite

    public void AfterTest() {
        HomePageComponentsAP.SwitchToCurrentUrl(driver);
        driver.close();

    }

}
