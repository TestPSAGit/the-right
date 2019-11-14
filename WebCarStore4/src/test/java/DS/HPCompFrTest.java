/*
 * Creation : 20 mai 2019
 */
package DS;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import DS.HomePageComponentsDS;
import Utilities.InitialiseDrivers;

public class HPCompFrTest {
    static WebDriver driver;
    HomePageComponentsDS hp = new HomePageComponentsDS();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("http://E562418:Lm133499@fr.store.ds.inetpsa.com/accueil");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        hp.CloseCokies(driver);
        // driver.findElement(By.className("psac_noselect")).click();

    }

    @Test(priority = 1)

    public void ThePageTitleisCorrect() {

        assert (hp.CheckTitlePresent(driver).equals("ONLINE STORE"));
    }

    @Test(priority = 1)

    public void ThePageTitleBrandisCorrect() {

        assert (hp.CheckTitleBrandPresent(driver).equals("DS"));
    }

    @Test(priority = 2)

    public void ThePeugeotLogoIsDisplayed() {
        assert (hp.CheckLogoPresent(driver) == true);
    }

    @Test(priority = 3)

    public void TheTextUnderThePageTitleIsCorrect() {

        assert (hp.CheckTextUnderTitlePresent(driver).equals("Achat de voitures DS neuves et de faible kilométrage près de chez vous"));
    }

    @Test(priority = 4)

    public void GotToHomePageWhenClickingOnTheCitënLogo() {
        assert (hp.CheckClickOnHeaderDSLogo(driver).contains("fr.store.ds.inetpsa.com/accueil"));
    }

    @Test(priority = 6)

    public void TheFacebookIconeIsPresent() {
        assert (hp.CheckTheFacebookIconePresence(driver) == true);
    }

    @Test(priority = 7)

    public void GotFacebookPageWhenClickingTheFacebookIcone() {
        assert (hp.CheckClickOnFacebookIcone(driver).equals("https://www.facebook.com/DSFranceOfficiel/?brand_redir=251470375047890"));

    }

    @Test(priority = 8)

    public void TheUserGeneralConditionsTextIsPresent() {
        assert (hp.CheckTheUserGeneralConditionsTextPresence(driver, "//a[contains(text(),\"Conditions Générales d'Utilisation\")]") == true);
    }

    @Test(priority = 9)

    public void TheCookiesTextIsPresent() {
        assert (hp.CheckTheCookiestextPresence(driver) == true);
    }

    @Test(priority = 10)

    public void GotTheUserGeneralConditionsPDF() {
        assert (hp.CheckClickOnUserGeneralConditions(driver, "//a[contains(text(),\"Conditions Générales d'Utilisation\")]"))
                .contains("CGU_DS_ONLINE_STORE.pdf");

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
        assert (hp.CheckClickOnTwiterIcone(driver).equals("https://twitter.com/DS_fr"));
    }

    @Test(priority = 20)
    public void GotYoutubePageWhenClickingTheyoutubeIcone() {
        assert (hp.CheckClickOnYoutubeIcone(driver).equals("https://www.youtube.com/user/dsfranceofficiel"));

    }

    @Test(priority = 21)

    public void TheSellGeneralConditionsTextIsPresent() {
        assert (hp.CheckThesellGeneralConditionsTextPresence(driver, "//a[contains(text(),'Conditions Générales de Vente')]") == true);
    }

    @Test(priority = 22)

    public void GotTheSellGeneralConditionsPDF() {
        assert (hp.CheckClickOnsellGeneralConditions(driver, "//a[contains(text(),'Conditions Générales de Vente')]")
                .contains("CGV_DS_ONLINE_STORE.pdf"));
    }

    @Test(priority = 23)

    public void GotTheRightUrlWhenClickingOnCarConfiguratorLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Configurez votre véhicule')]");
        assert (Result[0].contains("www.dsautomobiles.fr/ds-store/configurateur.html"));
        assert (Result[1] != "true");
    }

    @Test(priority = 24)

    public void GotTheRightUrlWhenClickingOnProfessionalCarsLink() {

        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'DS Professionnel')]");
        assert (Result[0].contains("www.dsautomobiles.fr/ds-professionnel/modeles-ds-professionnel.html?"));
        assert (Result[1] != "true");

    }

    @Test(priority = 25)

    public void GotTheRightUrlWhenClickingOnCarAccessoriesLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Accessoires DS')]");
        assert (Result[0].contains("www.dsautomobiles.fr/ds-store/ds-accessoires.html"));
        assert (Result[1] != "true");

    }

    @Test(priority = 26)

    public void GotTheRightUrlWhenClickingOnUsedCarsLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Découvrez les offres DS')]");
        assert (Result[0].contains("www.dsautomobiles.fr/ds-store/offres-ds.html"));
        assert (Result[1] != "true");

    }

    @Test(priority = 27)

    public void GotTheRightUrlWhenClickingOnWebsotrePaimentLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Le paiement sur DS ONLINE STORE')]");
        assert (Result[0].contains("fr.store.ds.inetpsa.com/FAQ#Paiement"));
        assert (Result[1] != "true");

    }

    @Test(priority = 27)

    public void GotTheRightUrlWhenClickingOnTheOrderStepsLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Les étapes de mon achat')]");
        assert (Result[0].contains("fr.store.ds.inetpsa.com/FAQ#Commande"));
        assert (Result[1] != "true");

    }

    @Test(priority = 28)

    public void GotTheRightUrlWhenClickingOnTheDelieveryStepsLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Modalités de livraison')]");
        assert (Result[0].contains("fr.store.ds.inetpsa.com/FAQ#LivraisonContactConcessionnaire"));
        assert (Result[1] != "true");

    }

    @Test(priority = 29)

    public void GotTheRightUrlWhenClickingOnTheFAQLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'FAQ')]");
        assert (Result[0].contains("fr.store.ds.inetpsa.com/FAQ"));

    }

    @Test(priority = 30)

    public void GotTheRightUrlWhenClickingOnTheDealersLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Points de vente')]");
        assert (Result[0].contains("fr.store.ds.inetpsa.com/liste-points-de-vente"));
        assert (Result[1] != "true");

    }

    @AfterSuite

    public void AfterTest() {
        HomePageComponentsDS.SwitchToCurrentUrl(driver);
        driver.close();

    }
}
