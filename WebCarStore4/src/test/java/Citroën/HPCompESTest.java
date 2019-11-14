/*
 * Creation : 20 mai 2019
 */
package Citroën;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Citroën.HomePageComponentsAC;
import Utilities.InitialiseDrivers;

public class HPCompESTest {
    static WebDriver driver;
    HomePageComponentsAC hp = new HomePageComponentsAC();
    static ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/TestReport.html");
    ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://E562418:Id133499@carstore.citroen.es/Home");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        hp.CloseCokies(driver);
        // driver.findElement(By.className("psac_noselect")).click();
        extent.attachReporter(reporter);

    }

    @Test(priority = 1)

    public void ThePageTitleisCorrect() {

        assert (hp.CheckTitlePresent(driver).equals("CARSTORE"));
    }

    @Test(priority = 2)

    public void ThePageTitleBrandisCorrect() {

        assert (hp.CheckTitleBrandPresent(driver).equals("CITROËN"));
    }

    @Test(priority = 3)

    public void ThePeugeotLogoIsDisplayed() {
        assert (hp.CheckLogoPresent(driver) == true);
    }

    @Test(priority = 4)

    public void TheTextUnderThePageTitleIsCorrect() {

        assert (hp.CheckTextUnderTitlePresent(driver).equals("Compre su coche nuevo CITROËN / DS cerca casa y al MEJOR PRECIO"));
    }

    @Test(priority = 5)

    public void GotToHomePageWhenClickingOnTheCitënLogo() {
        assert (hp.CheckClickOnHeaderCitoënLogo(driver).contains("carstore.citroen.es/Home"));
    }

    @Test(priority = 6)

    public void TheFacebookIconeIsPresent() {
        assert (hp.CheckTheFacebookIconePresence(driver) == true);
    }

    @Test(priority = 7)

    public void GotFacebookPageWhenClickingTheFacebookIcone() {
        assert (hp.CheckClickOnFacebookIcone(driver).equals("https://www.facebook.com/Citroen.Espagna"));

    }

    @Test(priority = 8)

    public void TheTwiterIconeIsPresent() {
        assert (hp.CheckTheTwiterIconePresence(driver) == true);
    }

    @Test(priority = 9)
    public void GotTwiterPageWhenClickingTheTwiterIcone() {
        assert (hp.CheckClickOnTwiterIcone(driver).equals("https://twitter.com/CitroenEspana"));
    }

    @Test(priority = 10)

    public void TheUserGeneralConditionsTextIsPresent() {
        assert (hp.CheckTheUserGeneralConditionsTextPresence(driver, "//a[contains(text(),'Condiciones generales de uso')]") == true);
    }

    @Test(priority = 11)

    public void GotTheUserGeneralConditionsPDF() {
        assert (hp.CheckClickOnUserGeneralConditions(driver, "//a[contains(text(),'Condiciones generales de uso')]"))
                .contains("https://carstore.citroen.es/nota-legal");

    }

    @Test(priority = 12)

    public void GotTheCookiesPopUp() {
        assert (hp.CheckClickOnCookies(driver) == true);

    }

    @Test(priority = 13)

    public void TheCookiesTextIsPresent() {
        assert (hp.CheckTheCookiestextPresence(driver) == true);
    }

    @Test(priority = 14)

    public void GotTheRightUrlWhenClickingOnCarConfiguratorLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, " //a[contains(text(),'Configurador Citroën')]");
        assert (Result[0].contains("www.citroen.es/vehiculos/citroen.html"));
        assert (Result[1] != "true");
    }

    @Test(priority = 15)

    public void GotTheRightUrlWhenClickingOnProfessionalCarsLink() {

        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Vehículos para profesionales')]");
        assert (Result[0].contains("carstore.citroen.es/profesional/Home?"));
        assert (Result[1] != "true");

    }

    @Test(priority = 16)

    public void GotTheRightUrlWhenClickingPricingLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Tasación Citroën')]");
        assert (Result[0].contains("www.tasacion.citroen.es/?"));
        assert (Result[1] != "true");

    }

    @Test(priority = 17)

    public void GotTheRightUrlWhenClickingOnUsedCarsLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Vehículos de ocasión')]");
        assert (Result[0].contains("www.citroenselect.es/?"));
        assert (Result[1] != "true");

    }

    @Test(priority = 18)

    public void GotTheRightUrlWhenClickingOnTheDealersLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Puntos de venta')]");
        assert (Result[0].contains("www.citroenselect.es"));
        assert (Result[1] != "true");

    }

    @AfterSuite

    public void AfterTest() {
        HomePageComponentsAC.SwitchToCurrentUrl(driver);
        driver.close();

    }
}
