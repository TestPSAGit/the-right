/*
 * Creation : 2 oct. 2019
 */
package Citroën;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ElementMethodes;
import Utilities.InitialiseDrivers;
import Utilities.WaitS;

public class ResultPageTest {
    static WebDriver driver;

    public void InitialiseUrl(String URL) {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get(URL);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);
        WaitS.waitForLoad(driver);
        WaitS.Wait(5000);
    }

    @Test(priority = 1, dataProvider = "UrlsProvider2")
    public void CheckThatTheOffersCTAisPresent(String URL) {
        InitialiseUrl(URL);

        assert (ResultPageAC.ChecktheOffersNumberPresence(driver) == true);

    }

    @Test(priority = 2, dataProvider = "UrlsProvider2")
    public void CheckThatTheModelsCTAisPresent(String URL) {
        // InitialiseUrl(URL);

        assert (ResultPageAC.ChecktheModelsListPresence(driver) == true);

    }

    @Test(priority = 3, dataProvider = "UrlsProvider2")
    public void CheckThatTheModelsarePresentInTheModelsCTA(String URL) {
        // InitialiseUrl(URL);

        assert (ResultPageAC.CheckthepresenceofelementsontheModelsList(driver) == true);
        // driver.close();

    }

    @Test(priority = 4, dataProvider = "UrlsProvider2")
    public void CheckThatTheBudjetCTAisPresent(String URL) {
        // InitialiseUrl(URL);

        assert (ResultPageAC.ChecktheBudgetCtaPresence(driver) == true);
        // driver.close();

    }

    // @Test(priority = 5, dataProvider = "UrlsProvider")
    public void CheckThatTheDistanceCTAisPresent(String URL) {

        InitialiseUrl(URL);

        assert (ResultPageAC.ChecktheDistanceCtaPresence(driver) == true);
        // driver.close();

    }

    // @Test(priority = 6, dataProvider = "UrlsProvider1")
    public void CheckThatTheDeleveryDateCTAisPresent(String URL) {

        InitialiseUrl(URL);

        assert (ResultPageAC.ChecktheDeleveryDatePresence(driver) == true);
        // driver.close();

    }

    // @Test(priority = 7, dataProvider = "UrlsProvider1")
    public void CheckThatTheLocalityCTAisPresent(String URL) {

        // InitialiseUrl(URL);
        assert (ResultPageAC.ChecktheLocalityPresence(driver) == true);
        // driver.close();

    }

    @Test(priority = 5, dataProvider = "UrlsProvider2")
    public void CheckThatTheEnergyCTAisPresent(String URL) {

        // InitialiseUrl(URL);
        assert (ResultPageAC.ChecktheEnergyCtaPresence(driver) == true);
        // driver.close();

    }

    @Test(priority = 6, dataProvider = "UrlsProvider2")
    public void CheckThatTheTransmissionCTAisPresent(String URL) {

        // InitialiseUrl(URL);
        assert (ResultPageAC.ChecktheTrasmissionCtaPresence(driver) == true);
        // driver.close();

    }

    @Test(priority = 7, dataProvider = "UrlsProvider2")
    public void CheckThatTheEngineCTAisPresent(String URL) {

        // InitialiseUrl(URL);
        assert (ResultPageAC.ChecktheEngineCtaPresence(driver) == true);
        // driver.close();

    }

    @Test(priority = 8, dataProvider = "UrlsProvider2")
    public void CheckThatTheFinitionCTAisPresent(String URL) {

        // InitialiseUrl(URL);
        assert (ResultPageAC.ChecktheFinitionCtaPresence(driver) == true);
        // driver.close();

    }

    @Test(priority = 9, dataProvider = "UrlsProvider2")
    public void CheckThatTheColorCTAisPresent(String URL) {

        // InitialiseUrl(URL);
        assert (ResultPageAC.ChecktheColorCtaPresence(driver) == true);
        // driver.close();

    }

    // @AfterSuite

    public void AfterTest() {

        driver.close();

    }

    /*
     * @DataProvider(name = "UrlsProvider") public Object[][] UrlsTobeTested() {
     * 
     * Object[][] URLS = new Object[][] {
     * 
     * { "http://fr.store.citroen.inetpsa.com/Resultat?lat=48.85661400000001&lng=2.3522219000000177&Cit=Paris&screenWidth=1519&mbd=" }, {
     * "http://es.store.citroen.inetpsa.com/Resultados?lat=40.4167754&lng=-3.7037901999999576&Cit=Madrid&screenWidth=1349&mbd=" }, {
     * "http://it.store.citroen.inetpsa.com/Ricerca?lat=41.90278349999999&lng=12.496365500000024&Cit=Rome%2C%20RM&screenWidth=1519&mbd=" }, {
     * "http://de.store.citroen.inetpsa.com/resultat?lat=52.2253083&lng=8.940218500000015&Cit=Porta%20Westfalica&screenWidth=1519&mbd=" }, {
     * "http://pt.store.citroen.inetpsa.com/Resultado?lat=41.1579438&lng=-8.629105299999992&Cit=Porto&screenWidth=1519&mbd=" }, }; return URLS; }
     * 
     * @DataProvider(name = "UrlsProvider1") public Object[][] UrlsTobeTested1() {
     * 
     * Object[][] URLS = new Object[][] {
     * 
     * { "http://fr.store.citroen.inetpsa.com/Resultat?lat=48.85661400000001&lng=2.3522219000000177&Cit=Paris&screenWidth=1519&mbd=" } }; return URLS;
     * }
     */

    @DataProvider(name = "UrlsProvider2")
    public Object[][] UrlsTobeTested2() {

        Object[][] URLS = new Object[][] {

                { "http://fr.store.citroen.inetpsa.com/Resultat?lat=48.85661400000001&lng=2.3522219000000177&Cit=Paris&screenWidth=1519&mbd=" },

                { "http://es.store.citroen.inetpsa.com/Resultados?lat=40.4167754&lng=-3.7037901999999576&Cit=Madrid&screenWidth=1349&mbd=" },
                { "http://it.store.citroen.inetpsa.com/Ricerca?lat=41.90278349999999&lng=12.496365500000024&Cit=Rome%2C%20RM&screenWidth=1519&mbd=" },
                { "http://de.store.citroen.inetpsa.com/resultat?lat=52.2253083&lng=8.940218500000015&Cit=Porta%20Westfalica&screenWidth=1519&mbd=" },
                { "http://pt.store.citroen.inetpsa.com/Resultado?lat=41.1579438&lng=-8.629105299999992&Cit=Porto&screenWidth=1519&mbd=" },
                { "http://be.store.citroen.inetpsa.com/fr/Resultat?screenWidth=1519&mbd=" },
                { "http://be.store.citroen.inetpsa.com/nl/Resultaat?screenWidth=1519&mbd=" } };
        return URLS;
    }
}
