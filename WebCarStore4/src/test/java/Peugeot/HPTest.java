/*
 * Creation : 28 mars 2019
 */
package Peugeot;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.InitialiseDrivers;
import Utilities.WaitS;

public class HPTest {
    static WebDriver driver;
    HomePageComponentsAP hp = new HomePageComponentsAP();

    public void InitialiseUrl(String URL) {
        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get(URL);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        hp.CloseCokies(driver);
        // driver.findElement(By.className("psac_noselect")).click();
    }

    @Test(dataProvider = "UrlsProvider")
    public void ThePriceChangesWhenModelChange(String URL) {
        InitialiseUrl(URL);
        String[] modelsList = HomePageAP.GetModelsList(driver);
        int[] Range = new int[modelsList.length];
        int error = 0;
        Range[0] = 4000000;
        for (int i = 1; i < modelsList.length; i++) {
            HomePageAP.SelectaModelByIndex(driver, i);
            WaitS.Wait(1000);
            Range[i] = HomePageAP.GetThePriceRange(driver);
            if (Range[i] == Range[i - 1] && Range[i] != 0) {
                System.err.println("--------->  " + modelsList[i] + " : " + URL);
                error++;
            }
        }
        assert (error == 0);
        driver.close();
    }

    @Test(dataProvider = "UrlsProvider")
    public void TheNumberOfofferschangeWhenChosingAModelAndLocation(String URL) {
        InitialiseUrl(URL);
        String[] modelsList = HomePageAP.GetModelsList(driver);
        int[] Offers = new int[100];
        int Error = 0;
        Offers[0] = 0;
        HomePageAP.EnterTheLocation(driver, "Madrid");
        for (int i = 1; i < modelsList.length; i++) {
            HomePageAP.SelectaModelByIndex(driver, i);
            WaitS.Wait(1000);
            String[] subModelsList = HomePageAP.GetSubModelsList(driver);
            for (int j = 1; j < subModelsList.length; j++) {
                if (subModelsList.length > 2) {
                    HomePageAP.SelectaSubModelByIndex(driver, j);
                    WaitS.Wait(2000);
                }
                Offers[j] = HomePageAP.GetTheOffersNum(driver);
                if (Offers[j] == Offers[j - 1] && Offers[j - 1] != 1 && Offers[j - 1] > 5) {
                    System.err.println("------------>  " + modelsList[i] + "" + subModelsList[j] + " : " + URL);
                    Error++;
                }
            }
        }
        assert (Error == 0);
        driver.close();
    }

    @DataProvider(name = "UrlsProvider")
    public Object[][] UrlsTobeTested() {

        Object[][] URLS = new Object[][] { { "https://E562418:Lm133499@webstore.peugeot.it/HOME" },
                { "https://E562418:Lm133499@webstore.peugeot.es/Inicio" }, { "https://E562418:Lm133499@www.peugeotwebstore.com/Accueil" },
                { "http://E562418:Lm133499@de.store.peugeot.inetpsa.com/Startseite" } };

        return URLS;
    }

}
