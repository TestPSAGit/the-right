/*
 * Creation : 24 avr. 2019
 */
package Peugeot;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DateManagement;
import Utilities.ElementMethodes;
import Utilities.InitialiseDrivers;
import Utilities.WaitS;

public class ResultPageTestLight {
    static WebDriver driver;
    static Date DeliveryDate;
    static Date currentDate;
    static int[] OffersNum;
    static int[] OffersNum1;
    static int Error;

    /*
     * @BeforeMethod(dataProvider="UrlsProvider") public void BeforeTest() {
     * 
     * driver = InitialiseDrivers.InitialiseChromDriver(); driver.get(
     * "http://fr.store.peugeot.inetpsa.com/Recherche-par-critere?lat=48.856614&lng=2.3522219000000177&LocationL=Paris%2C%20France&etd=0");
     * driver.manage().deleteAllCookies(); driver.manage().window().maximize(); driver.findElement(By.className("psac_noselect")).click();
     * 
     * }
     */

    public void InitialiseUrl(String URL) {

        driver = InitialiseDrivers.InitialiseChromDriver();
        driver.get(URL);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ElementMethodes.CloseCokies(driver);

    }

    // @Test(priority = 1, dataProvider = "UrlsProvider1")
    public void CheckThatThedeliveryDateisGreaterThanTodaysDate(String URL) {
        InitialiseUrl(URL);
        String[] Models = ResultPageAP.GetTheModelsListElements(driver);

        OffersNum = new int[Models.length];
        OffersNum[0] = 0;
        Error = 0;
        // ResultPageAC.OpenTheModelsMenu(driver);
        currentDate = DateManagement.GetCurrentDate();

        for (int i = 1; i <= 4; i++) {
            ResultPageAP.OpenTheModelsMenu(driver);

            if (i == 1) {
                ResultPageAP.SelectaModelFromTheModelsList(driver, i);
            } else {
                ResultPageAP.SelectaModelFromTheModelsList(driver, i - 1);
                ResultPageAP.OpenTheModelsMenu(driver);
                ResultPageAP.SelectaModelFromTheModelsList(driver, i);
            }

            WaitS.Wait(2000);
            int OffersNum = ResultPageAP.GetOffersNumber(driver);
            DeliveryDate = ResultPageAP.GetDeliveryDateByIndex(driver, 3);
            long diff = DeliveryDate.getTime() - currentDate.getTime();
            long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            if (days < 0) {
                Error++;
                System.err.println(Models[i]);
            }

        }

        driver.close();
        assert (Error == 0);

    }

    // @Test(priority = 2, dataProvider = "UrlsProvider")
    public void CheckThatTheNumberOfOfferschangesWhenChangingGearBox(String URL) {
        InitialiseUrl(URL);
        String[] GearBoxs = ResultPageAP.GetTheGearBoxListElements(driver);

        // System.out.println(GearBoxs[1]);

        OffersNum = new int[GearBoxs.length];
        OffersNum[0] = 0;
        Error = 0;
        // ResultPageAC.OpenTheModelsMenu(driver); currentDate =
        DateManagement.GetCurrentDate();

        for (int i = 1; i < 4; i++)

        {
            ResultPageAP.OpenTheGearBoxMenu(driver);
            WaitS.Wait(2000);

            if (i == 1) {
                ResultPageAP.SelectaGearBoxFromTheGearBoxsList(driver, i);
            } else {
                ResultPageAP.SelectaGearBoxFromTheGearBoxsList(driver, i - 1);
                ResultPageAP.OpenTheGearBoxMenu(driver);
                ResultPageAP.SelectaGearBoxFromTheGearBoxsList(driver, i);
            }

            WaitS.Wait(3000);
            OffersNum[i] = ResultPageAP.GetOffersNumber(driver);

            if (OffersNum[i] == OffersNum[i - 1]) {
                Error++;
                System.err.println(GearBoxs[i]);
            }

        }

        driver.close();
        assert (Error == 0);

    }

    @Test(priority = 3, dataProvider = "UrlsProvider4")
    public void CheckThatTheNumberOfOfferschangesWhenChangingEngine(String URL) {
        InitialiseUrl(URL);
        String[] Engines = ResultPageAP.GetTheEngineListElements(driver);
        OffersNum = new int[Engines.length];
        OffersNum[0] = 0;
        Error = 0;
        DateManagement.GetCurrentDate();
        for (int i = 1; i < 4; i++) {
            ResultPageAP.OpenTheEngineMenu(driver);
            if (i == 1) {
                ResultPageAP.SelectaEngineFromTheEngineList(driver, i);
            } else {
                ResultPageAP.SelectaEngineFromTheEngineList(driver, i - 1);
                ResultPageAP.OpenTheEngineMenu(driver);
                ResultPageAP.SelectaEngineFromTheEngineList(driver, i);
            }

            WaitS.Wait(2000);
            OffersNum[i] = ResultPageAP.GetOffersNumber(driver);

            if (OffersNum[i] == OffersNum[i - 1] && OffersNum[i] > 5) {
                Error++;
                System.err.println(URL + " **************************** " + Engines[i - 1]);
            }

        }
        driver.close();
        assert (Error == 0);

    }

    // @Test(priority = 4, dataProvider = "UrlsProvider")

    public void CheckThatTheNumberOfOfferschangesWhenChangingFinition(String URL) {
        InitialiseUrl(URL);

        String[] Finitions = ResultPageAP.GetTheFinitionListElements(driver);

        OffersNum = new int[Finitions.length];
        OffersNum[0] = 0;
        Error = 0;

        for (int i = 1; i < 4; i++) {
            ResultPageAP.OpenTheFinitionMenu(driver);
            if (i == 1) {
                ResultPageAP.SelectaFinitionFromTheFinitionList(driver, i);
            } else {
                ResultPageAP.SelectaFinitionFromTheFinitionList(driver, i - 1);
                ResultPageAP.OpenTheFinitionMenu(driver);
                ResultPageAP.SelectaFinitionFromTheFinitionList(driver, i);
            }
            WaitS.Wait(3000);
            OffersNum[i] = ResultPageAP.GetOffersNumber(driver);
            if (OffersNum[i] == OffersNum[i - 1] && OffersNum[i] > 5) {
                Error++;
                System.err.println(Finitions[i]);
            }
        }

        driver.close();
        assert (Error == 0);

    }

    // @Test(priority = 5, dataProvider = "UrlsProvider")
    public void CheckThatTheNumberOfOfferschangesWhenChangingTheColor(String URL) {
        InitialiseUrl(URL);
        String[] Colors = ResultPageAP.GetTheColorListElements(driver);
        System.err.println(Colors[0]);
        OffersNum = new int[Colors.length + 1];
        OffersNum[0] = 0;
        Error = 0;
        // ResultPageAC.OpenTheModelsMenu(driver); currentDate =
        DateManagement.GetCurrentDate();

        for (int i = 1; i <= Colors.length; i++)

        {

            if (i == 1) {
                ResultPageAP.SelectaColorFromTheColorList(driver, i);
            } else {
                ResultPageAP.SelectaColorFromTheColorList(driver, i - 1);
                WaitS.Wait(2000);
                ResultPageAP.SelectaColorFromTheColorList(driver, i);
            }

            WaitS.Wait(2000);
            OffersNum[i] = ResultPageAP.GetOffersNumber(driver);

            if (OffersNum[i] == OffersNum[i - 1]) {
                Error++;
                System.err.println(Colors[i]);
            }

        }

        driver.close();
        assert (Error == 0);

    }

    // @Test(priority = 6, dataProvider = "UrlsProvider")
    public void TheNumberOfOffersISGreaterWhenAddingAModel(String URL) {
        InitialiseUrl(URL);
        String[] Models = ResultPageAP.GetTheModelsListElements(driver);

        OffersNum1 = new int[Models.length + 1];
        OffersNum1[0] = 0;
        Error = 0;

        // ResultPageAC.OpenTheModelsMenu(driver);

        for (int i = 1; i <= 6; i++) {

            ResultPageAP.OpenTheModelsMenu(driver);

            ResultPageAP.SelectaModelFromTheModelsList(driver, i);
            OffersNum1[i] = ResultPageAP.GetOffersNumber(driver);

            if (OffersNum1[i] <= OffersNum1[i - 1]) {

                System.err.println(Models[i - 1].toLowerCase());
                Error++;
            }

        }
        driver.close();
        assert (Error == 0);
    }

    // @Test(priority = 7, dataProvider = "UrlsProvider")
    public void TheNumberOfOffersIsLowerWhenChangingThePriceSlider(String URL) {
        InitialiseUrl(URL);
        ResultPageAP.OpenTheModelsMenu(driver);
        ResultPageAP.SelectaModelFromTheModelsList(driver, 1);
        ResultPageAP.OpenTheModelsMenu(driver);
        ResultPageAP.SelectaModelFromTheModelsList(driver, 2);
        ResultPageAP.OpenTheModelsMenu(driver);
        ResultPageAP.SelectaModelFromTheModelsList(driver, 3);
        WaitS.Wait(2000);
        int Offers1 = ResultPageAP.GetOffersNumber(driver);
        ResultPageAP.MovePriceSliderToLowerValue(driver);
        int Offers2 = ResultPageAP.GetOffersNumber(driver);
        driver.close();
        assert (Offers1 > Offers2);

    }

    // @Test(priority = 8, dataProvider = "UrlsProvider")

    public void TheNumberOfOffersIsCorrectWhenChangingTheEnergy(String URL) {
        InitialiseUrl(URL);
        Error = 0;
        String[] Models = ResultPageAP.GetTheModelsListElements(driver);
        for (int i = 0; i < 6; i++) {
            ResultPageAP.OpenTheModelsMenu(driver);
            ResultPageAP.SelectaModelFromTheModelsList(driver, i + 1);

            String[] Energies = ResultPageAP.GetTheEnergiesList(driver);
            OffersNum = new int[Energies.length];

            OffersNum[0] = ResultPageAP.GetOffersNumber(driver);
            if (Energies.length == 3) {

                ResultPageAP.ClickOnOneEnergy(driver, 1, 1);
                OffersNum[1] = ResultPageAP.GetOffersNumber(driver);
                if (OffersNum[1] > OffersNum[0]) {
                    Error++;
                    System.err.println(Models[i] + " / " + Energies[1]);
                }
                ResultPageAP.ClickOnOneEnergy(driver, 1, 1);
                ResultPageAP.ClickOnOneEnergy(driver, 2, 1);
                OffersNum[2] = ResultPageAP.GetOffersNumber(driver);
                if (OffersNum[2] != OffersNum[0] - OffersNum[1]) {
                    Error++;
                    System.err.println(Models[i] + " / " + Energies[2] + "/" + OffersNum[2]);
                }
            }

            if (Energies.length == 4) {

                ResultPageAP.ClickOnOneEnergy(driver, 1, 1);
                OffersNum[1] = ResultPageAP.GetOffersNumber(driver);
                if (OffersNum[1] > OffersNum[0]) {

                    Error++;
                    System.err.println(Models[i] + " / " + Energies[1]);
                }

                ResultPageAP.ClickOnOneEnergy(driver, 1, 1);
                ResultPageAP.ClickOnOneEnergy(driver, 2, 1);
                OffersNum[2] = ResultPageAP.GetOffersNumber(driver);

                if (OffersNum[2] > OffersNum[0]) {
                    Error++;
                    System.err.println(Models[i] + " / " + Energies[2]);
                }

                ResultPageAP.ClickOnOneEnergy(driver, 2, 1);
                ResultPageAP.ClickOnOneEnergy(driver, 1, 2);
                OffersNum[3] = ResultPageAP.GetOffersNumber(driver);

                if (OffersNum[3] != OffersNum[0] - OffersNum[1] - OffersNum[2]) {
                    Error++;
                    System.err.println(Models[i] + " / " + Energies[3]);
                }

            }
            ResultPageAP.OpenTheModelsMenu(driver);
            ResultPageAP.SelectaModelFromTheModelsList(driver, i + 1);
        }
        driver.close();
        assert (Error == 0);
    }

    // @DataProvider(name = "UrlsProvider1")
    public Object[][] UrlsTobeTested() {

        Object[][] URLS = new Object[][] {

                { "http://fr.store.peugeot.inetpsa.com/Recherche-par-critere?lat=48.856614&lng=2.3522219000000177&LocationL=Paris%2C%20France&etd=0" } };
        return URLS;
    }

    @DataProvider(name = "UrlsProvider")
    public Object[][] UrlsTobeTestd2() {

        Object[][] URLS = new Object[][] { {
                "http://fr.store.peugeot.inetpsa.com/Recherche-par-critere?lat=48.856614&lng=2.3522219000000177&LocationL=Paris%2C%20France&etd=0" },
                { "http://es.store.peugeot.inetpsa.com/Busqueda-por-criterio?lat=40.4167754&lng=-3.7037901999999576&LocationL=Madrid%2C%20Espa%C3%B1a&etd=0" },
                { "http://it.store.peugeot.inetpsa.com/Cerca-per-categorie?lat=45.7805759&lng=12.837399199999936&LocationL=30026%20Portogruaro%20VE%2C%20Italia&etd=0" } };
        return URLS;
    }

    @DataProvider(name = "UrlsProvider3")
    public Object[][] UrlsTobeTested3() {

        Object[][] URLS = new Object[][] { {
                "http://es.store.peugeot.inetpsa.com/Busqueda-por-criterio?lat=40.4167754&lng=-3.7037901999999576&LocationL=Madrid%2C%20Espa%C3%B1a&etd=0" } };
        return URLS;
    }

    @DataProvider(name = "UrlsProvider4")
    public Object[][] UrlsTobeTested4() {

        Object[][] URLS = new Object[][] { { " http://be.store.peugeot.inetpsa.com/fr/Recherche-par-critere?mbd=1PT9S0000049;1PT9S0000005;" } };
        return URLS;
    }

}
