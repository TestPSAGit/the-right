/*
 * Creation : 8 avr. 2019
 */
package Peugeot;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utilities.InitialiseDrivers;

public class HPCompESTest {
    static WebDriver driver;
    HomePageComponentsAP hp = new HomePageComponentsAP();
    static ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/TestReport.html");
    ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://E562418:Lm133499@webstore.peugeot.es/Inicio");
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
        assert (hp.CheckTextUnderTitlePresent(driver).equals("Compra tu nuevo PEUGEOT cerca de ti y al MEJOR PRECIO"));
    }

    @Test(priority = 8)

    public void GotToHomePageWhenClickingOnThePeugeotLogo() {
        assert (hp.CheckClickOnHeaderPeugeotLogo(driver).contains("https://webstore.peugeot.es/Inicio"));
    }

    @Test(priority = 11)

    public void TheFacebookIconeIsPresent() {
        assert (hp.CheckTheFacebookIconePresence(driver) == true);
    }

    @Test(priority = 14)

    public void GotFacebookPageWhenClickingTheFacebookIcone() {
        assert (hp.CheckClickOnFacebookIcone(driver).equals("https://www.facebook.com/PeugeotEspana/"));

    }

    @Test(priority = 16)

    public void TheUserGeneralConditionsTextIsPresent() {
        assert (hp.CheckTheUserGeneralConditionsTextPresence(driver, "//a[contains(text(),'Condiciones generales de uso.')]") == true);
    }

    @Test(priority = 18)

    public void TheCookiesTextIsPresent() {
        assert (hp.CheckTheCookiestextPresence(driver) == true);
    }

    @Test(priority = 19)

    public void GotTheUserGeneralConditionsPage() {
        assert (hp.CheckClickOnUserGeneralConditions(driver, "//a[contains(text(),'Condiciones generales de uso.')]"))
                .contains("https://webstore.peugeot.es/TemplatesHTML/MentionsPages/es-ES/mention_v6.htm");

    }

    @Test(priority = 21)

    public void GotTheCookiesPopUp() {
        assert (hp.CheckClickOnCookies(driver) == true);
    }

    // @Test(priority = 23)

    public void GotTheRightUrlWhenClickingOnCarConfiguratorLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Configurez votre véhicule')]");
        assert (Result[0].contains("www.peugeot.fr/gamme/presentation-de-la-gamme.html"));
        assert (Result[1] != "true");
    }

    @Test(priority = 24)

    public void GotTheRightUrlWhenClickingOnProfessionalCarsLink() {

        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Vehículos para profesionales')]");
        assert (Result[0].contains("https://empresas.peugeot.es/inicio.html"));
        assert (Result[1] != "true");

    }

    // @Test(priority = 25)

    public void GotTheRightUrlWhenClickingOnCarAccessoriesLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Accessoires Peugeot')]");
        assert (Result[0].contains("accessoires.peugeot.fr/fr-FR/accessoires"));
        assert (Result[1] != "true");

    }

    @Test(priority = 26)

    public void GotTheRightUrlWhenClickingOnUsedCarsLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Vehículos de ocasión')]");
        assert (Result[0].contains("www.ocasion.peugeot.es"));
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
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Puntos de venta')]");
        assert (Result[0].contains("www.peugeot.es/red-comercial.html"));
        assert (Result[1] != "true");

    }

    @AfterSuite

    public void AfterTest() {
        HomePageComponentsAP.SwitchToCurrentUrl(driver);
        driver.close();

    }

}
