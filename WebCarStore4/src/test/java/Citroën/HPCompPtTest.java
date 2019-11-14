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

public class HPCompPtTest {
    static WebDriver driver;
    HomePageComponentsAC hp = new HomePageComponentsAC();
    static ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/TestReport.html");
    ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://E562418:Lm133499@carstore.citroen.it/Home");
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

        assert (hp.CheckTextUnderTitlePresent(driver).equals("ACQUISTA LA TUA VETTURA CITROËN VICINO A TE A PREZZI CONVENIENTI"));
    }

    @Test(priority = 5)

    public void GotToHomePageWhenClickingOnTheCitënLogo() {
        assert (hp.CheckClickOnHeaderCitoënLogo(driver).contains("carstore.citroen.it/Home"));
    }

    @Test(priority = 6)

    public void TheFacebookIconeIsPresent() {
        assert (hp.CheckTheFacebookIconePresence(driver) == true);
    }

    @Test(priority = 7)

    public void GotFacebookPageWhenClickingTheFacebookIcone() {
        assert (hp.CheckClickOnFacebookIcone(driver).equals("https://www.facebook.com/Citroen.Italia"));

    }

    @Test(priority = 8)

    public void TheTwiterIconeIsPresent() {
        assert (hp.CheckTheTwiterIconePresence(driver) == true);
    }

    @Test(priority = 9)
    public void GotTwiterPageWhenClickingTheTwiterIcone() {
        assert (hp.CheckClickOnTwiterIcone(driver).equals("https://twitter.com/CitroenItalia"));
    }

    @Test(priority = 10)

    public void TheUserGeneralConditionsTextIsPresent() {
        assert (hp.CheckTheUserGeneralConditionsTextPresence(driver, "//a[contains(text(),'Condizioni generali')]") == true);
    }

    @Test(priority = 11)

    public void GotTheUserGeneralConditionsPDF() {
        assert (hp.CheckClickOnUserGeneralConditions(driver, "//a[contains(text(),'Condizioni generali')]"))
                .contains("https://carstore.citroen.it/Informazioni-legali");

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

    public void TheYoutubeIconeIsPresent() {
        assert (hp.CheckTheYoutubeIconePresence(driver) == true);
    }

    @Test(priority = 15)
    public void GotYoutubePageWhenClickingTheyoutubeIcone() {
        assert (hp.CheckClickOnYoutubeIcone(driver).equals("https://www.youtube.com/user/citroenit"));

    }

    @Test(priority = 16)

    public void GotTheRightUrlWhenClickingOnCarConfiguratorLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Configura la tua auto')]");
        assert (Result[0].contains("www.citroen.it/configuratore.html?"));
        assert (Result[1] != "true");
    }

    @Test(priority = 17)

    public void GotTheRightUrlWhenClickingOnCarAccessoriesLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Citroën Accessori')]");
        assert (Result[0].contains("accessories.citroen.com/Showroom/it-IT/accessori?"));
        assert (Result[1] != "true");

    }

    @Test(priority = 18)

    public void GotTheRightUrlWhenClickingOnUsedCarsLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),\"Veicoli d'occasione\")]");
        assert (Result[0].contains("www.citroenselect.it/trova-veicoli-usati?"));
        assert (Result[1] != "true");

    }

    @Test(priority = 19)

    public void GotTheRightUrlWhenClickingOnWebsotrePaimentLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Le paiement sur Carstore')]");
        assert (Result[0].contains("fr.store.citroen.inetpsa.com/FAQ#Paiement"));
        assert (Result[1] != "true");

    }

    @Test(priority = 20)

    public void GotTheRightUrlWhenClickingOnTheDealersLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Trova un punto vendita')]");
        assert (Result[0].contains("www.citroenselect.it/trova-veicoli-usati?"));
        assert (Result[1] != "true");

    }

    @AfterSuite

    public void AfterTest() {
        HomePageComponentsAC.SwitchToCurrentUrl(driver);
        driver.close();

    }
}
