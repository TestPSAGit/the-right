/*
 * Creation : 8 avr. 2019
 */
package Peugeot;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilities.InitialiseDrivers;

public class HPCompFrTest {
    static WebDriver driver;
    HomePageComponentsAP hp = new HomePageComponentsAP();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://www.peugeotwebstore.com/Accueil");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        hp.CloseCokies(driver);

    }

    @Test(priority = 1)

    public void ThePageTitleisCorrect() {

        assert (hp.CheckTitlePresent(driver).equals("PEUGEOT WEBSTORE"));
    }

    @Test(priority = 2)

    public void ThePeugeotLogoIsDisplayed() {
        assert (hp.CheckLogoPresent(driver) == true);
    }

    @Test(priority = 3)

    public void TheTextUnderThePageTitleIsCorrect() {

        assert (hp.CheckTextUnderTitlePresent(driver).equals("RECHERCHE ET ACHAT DE VÉHICULES NEUFS PEUGEOT DISPONIBLES IMMÉDIATEMENT"));
    }

    @Test(priority = 4)

    public void GotToHomePageWhenClickingOnThePeugeotLogo() {
        assert (hp.CheckClickOnHeaderPeugeotLogo(driver).contains("https://www.peugeotwebstore.com/Accueil"));
    }

    @Test(priority = 6)

    public void TheFacebookIconeIsPresent() {
        assert (hp.CheckTheFacebookIconePresence(driver) == true);
    }

    @Test(priority = 7)

    public void GotFacebookPageWhenClickingTheFacebookIcone() {
        assert (hp.CheckClickOnFacebookIcone(driver).equals("https://www.facebook.com/PeugeotFrance/?fref=ts"));

    }

    @Test(priority = 8)

    public void TheUserGeneralConditionsTextIsPresent() {
        assert (hp.CheckTheUserGeneralConditionsTextPresence(driver, "//a[contains(text(),\"Conditions générales d'utilisation\")]") == true);
    }

    @Test(priority = 9)

    public void TheCookiesTextIsPresent() {
        assert (hp.CheckTheCookiestextPresence(driver) == true);
    }

    @Test(priority = 10)

    public void GotTheUserGeneralConditionsPDF() {
        assert (hp.CheckClickOnUserGeneralConditions(driver, "//a[contains(text(),\"Conditions générales d'utilisation\")]"))
                .contains("CGU_PEUGEOT_WEBSTORE.pdf");

    }

    @Test(priority = 11)

    public void GotTheCookiesPopUp() {
        assert (hp.CheckClickOnCookies(driver) == true);

    }

    @Test(priority = 12)

    public void TheMySaveIconIsDisplayed() {
        assert (hp.CheckLogoMysavePresent(driver) == true);
    }

    @Test(priority = 13)

    public void TheMySaveTextIsDisplayed() {
        assert (hp.CheckTextMysavePresent(driver, "//span[contains(text(),'MES SAUVEGARDES')]").equals("MES SAUVEGARDES"));
    }

    @Test(priority = 14)

    public void TheNeedHelpIconeIsDisplayed() {
        assert (hp.CheckLogoMysavePresent(driver) == true);
    }

    @Test(priority = 15)

    public void TheNeedHelpTextIsDisplayed() {
        assert (hp.CheckTextBesoinDaidePresent(driver).equals("BESOIN D'AIDE"));
    }

    @Test(priority = 16)

    public void GotAPopupWhenClickingOnNeedHelpBotton() {
        assert (hp.CheckClickOnNeedHelpLogo(driver) == true);
    }

    @Test(priority = 17)

    public void TheTwiterIconeIsPresent() {
        assert (hp.CheckTheTwiterIconePresence(driver) == true);
    }

    @Test(priority = 18)

    public void TheYoutubeIconeIsPresent() {
        assert (hp.CheckTheYoutubeIconePresence(driver) == true);
    }

    @Test(priority = 19)
    public void GotTwiterPageWhenClickingTheTwiterIcone() {
        assert (hp.CheckClickOnTwiterIcone(driver).equals("https://twitter.com/PeugeotFR"));
    }

    @Test(priority = 20)
    public void GotYoutubePageWhenClickingTheyoutubeIcone() {
        assert (hp.CheckClickOnYoutubeIcone(driver).equals("https://www.youtube.com/user/AutoPeugeotFrance"));

    }

    @Test(priority = 21)

    public void TheSellGeneralConditionsTextIsPresent() {
        assert (hp.CheckThesellGeneralConditionsTextPresence(driver, "//a[contains(text(),'Conditions générales de vente')]") == true);
    }

    @Test(priority = 22)

    public void GotTheSellGeneralConditionsPDF() {
        assert (hp.CheckClickOnsellGeneralConditions(driver, "//a[contains(text(),'Conditions générales de vente')]")
                .contains("CGV_PEUGEOT_WEBSTORE.pdf"));
    }

    @Test(priority = 23)

    public void GotTheRightUrlWhenClickingOnCarConfiguratorLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Configurez votre véhicule')]");
        assert (Result[0].contains("www.peugeot.fr/gamme/presentation-de-la-gamme.html"));
        assert (Result[1] != "true");
    }

    @Test(priority = 24)

    public void GotTheRightUrlWhenClickingOnProfessionalCarsLink() {

        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Nos véhicules professionnels')]");
        assert (Result[0].contains("www.peugeotwebstore.com/pro/Accueil"));
        assert (Result[1] != "true");

    }

    @Test(priority = 25)

    public void GotTheRightUrlWhenClickingOnCarAccessoriesLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Accessoires Peugeot')]");
        assert (Result[0].contains("accessoires.peugeot.fr/fr-FR/accessoires"));
        assert (Result[1] != "true");

    }

    @Test(priority = 26)

    public void GotTheRightUrlWhenClickingOnUsedCarsLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),\"Véhicules d'occasion\")]");
        assert (Result[0].contains("www.occasionsdulion.com"));
        assert (Result[1] != "true");

    }

    @Test(priority = 27)

    public void GotTheRightUrlWhenClickingOnWebsotrePaimentLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Le paiement sur Webstore')]");
        assert (Result[0].contains("www.peugeotwebstore.com/FAQ#Paiement"));
        assert (Result[1] != "true");

    }

    @Test(priority = 27)

    public void GotTheRightUrlWhenClickingOnTheOrderStepsLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Les étapes de mon achat')]");
        assert (Result[0].contains("www.peugeotwebstore.com/FAQ#Commande"));
        assert (Result[1] != "true");

    }

    @Test(priority = 28)

    public void GotTheRightUrlWhenClickingOnTheDelieveryStepsLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Modalités de livraison')]");
        assert (Result[0].contains("www.peugeotwebstore.com/FAQ#LivraisonContactConcessionnaire"));
        assert (Result[1] != "true");

    }

    @Test(priority = 29)

    public void GotTheRightUrlWhenClickingOnTheFAQLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'FAQ')]");
        assert (Result[0].contains("www.peugeotwebstore.com/FAQ"));

    }

    @Test(priority = 30)

    public void GotTheRightUrlWhenClickingOnTheDealersLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Points de vente')]");
        assert (Result[0].contains("www.peugeot.fr/points-de-vente.html"));
        assert (Result[1] != "true");

    }

    @AfterSuite

    public void AfterTest() {
        HomePageComponentsAP.SwitchToCurrentUrl(driver);
        driver.close();

    }

}
