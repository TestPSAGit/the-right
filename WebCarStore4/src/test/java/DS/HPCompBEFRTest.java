/*
 * Creation : 20 mai 2019
 */
package DS;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import DS.HomePageComponentsDS;
import Utilities.InitialiseDrivers;

public class HPCompBEFRTest {
    static WebDriver driver;
    HomePageComponentsDS hp = new HomePageComponentsDS();
    static ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/TestReport.html");
    ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public void BeforeTest() {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get("https://E562418:Lm133499@dsonlinestore.dsautomobiles.it/Home");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        hp.CloseCokies(driver);
        // driver.findElement(By.className("psac_noselect")).click();
        extent.attachReporter(reporter);

    }

    @Test(priority = 0)

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

        assert (hp.CheckTextUnderTitlePresent(driver).equals("TROVA LA TUA NUOVA DS"));
    }

    @Test(priority = 4)

    public void GotToHomePageWhenClickingOnTheCitënLogo() {
        assert (hp.CheckClickOnHeaderDSLogo(driver).contains("https://dsonlinestore.dsautomobiles.it/Home"));
    }

    @Test(priority = 5)

    public void TheFacebookIconeIsPresent() {
        assert (hp.CheckTheFacebookIconePresence(driver) == true);
    }

    @Test(priority = 6)

    public void GotFacebookPageWhenClickingTheFacebookIcone() {
        assert (hp.CheckClickOnFacebookIcone(driver).equals("https://www.facebook.com/DSItalyOfficiel/?brand_redir=1446161125660820"));

    }

    @Test(priority = 7)

    public void TheUserGeneralConditionsTextIsPresent() {
        assert (hp.CheckTheUserGeneralConditionsTextPresence(driver, "//a[contains(text(),'Termini e condizioni generali')]") == true);
    }

    @Test(priority = 8)

    public void TheCookiesTextIsPresent() {
        assert (hp.CheckTheCookiestextPresence(driver) == true);
    }

    @Test(priority = 9)

    public void GotTheUserGeneralConditionsURLRight() {
        assert (hp.CheckClickOnUserGeneralConditions(driver, "//a[contains(text(),'Termini e condizioni generali')]"))
                .contains("http://it.store.ds.inetpsa.com/TemplatesHTML/MentionsPages/it-IT/mention_global_fs.htm");

    }

    @Test(priority = 10)

    public void GotTheUserGeneralConditionsPage() {
        assert (hp.CheckClickOnUserGeneralConditionsPageTitle(driver, "//a[contains(text(),'Termini e condizioni generali')]"))
                .contains("Termini e condizioni generali");

    }

    @Test(priority = 11)

    public void GotTheCookiesPopUp() {
        assert (hp.CheckClickOnCookies(driver) == true);

    }

    @Test(priority = 12)

    public void TheTwiterIconeIsPresent() {
        assert (hp.CheckTheTwiterIconePresence(driver) == true);
    }

    @Test(priority = 13)

    public void TheYoutubeIconeIsPresent() {
        assert (hp.CheckTheYoutubeIconePresence(driver) == true);
    }

    @Test(priority = 14)
    public void GotTwiterPageWhenClickingTheTwiterIcone() {
        assert (hp.CheckClickOnTwiterIcone(driver).equals("https://twitter.com/dsitalia"));
    }

    @Test(priority = 15)
    public void GotYoutubePageWhenClickingTheyoutubeIcone() {
        assert (hp.CheckClickOnYoutubeIcone(driver).equals("https://www.youtube.com/user/DSItaliaOfficial/"));

    }

    @Test(priority = 16)

    public void GotTheRightUrlWhenClickingOnCarConfiguratorLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Configura la tua nuova DS')]");
        assert (Result[0].contains("www.dsautomobiles.it/la-tua-ds/configuratore.html?"));
        assert (Result[1] != "true");
    }

    @Test(priority = 17)

    public void GotTheRightUrlWhenClickingOnTheDealersLink() {
        String[] Result = hp.GettheUrlwhenClckingOnAlink(driver, "//a[contains(text(),'Trova un punto vendita')]");
        assert (Result[0].contains("www.dsautomobiles.it/scopri-la-rete-ds-automobiles/trova-il-tuo-punto-vendita.html"));
        assert (Result[1] != "true");

    }

    @AfterSuite

    public void AfterTest() {
        HomePageComponentsDS.SwitchToCurrentUrl(driver);
        driver.close();

    }
}
