/*
 * Creation : 18 juin 2019
 */
package Peugeot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.DateManagement;
import Utilities.WaitS;

public class testvcg {
    static WebDriver driver;

    @BeforeMethod
    public void BeforeTest() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\E562418\\Desktop\\PSA Selenium Project\\ChromeDriver\\chromedriver.exe");

        driver = new ChromeDriver(capabilities);

        driver.get("https://clicstore.peugeot.com/authentification?from=%2Fwelcome");
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.id("cphPageHome__ctl0_tbUser")).sendKeys("Bonnafous");
        driver.findElement(By.id("cphPageHome__ctl0_tbPassword")).sendKeys("ABONNAFOUS");
        WaitS.Wait(1000);
        driver.findElement(By.id("cphPageHome__ctl0_btnValidate")).click();
        WaitS.Wait(1000);
        driver.findElement(By.id("Btn_AP")).click();
        WaitS.Wait(1000);
        driver.findElement(By.xpath("//a[@class='link_store BtnPostData']")).click();
        WaitS.Wait(2000);
        DateManagement.SwitchDriverToCurrentPage(driver);
        // driver.findElement(By.xpath("//select[@name='model']")).click();
        WaitS.Wait(1000);
        WaitS.WaitForElementToBeVisible(driver, driver.findElement(By.xpath("//select[@name='model']")));
        new Select(driver.findElement(By.xpath("//select[@name='model']"))).selectByIndex(1);
        WaitS.Wait(1000);
        driver.findElement(By.xpath("//button[@class='btn btn-large btn-full btn-primary btn-double submit bound']")).click();
        WaitS.Wait(2000);

        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[2]/p[1]/a[1]/span[1]/strong[1]")).click();
        WaitS.Wait(2000);
        driver.findElement(By.xpath("//button[@id='btnOrder4']")).click();
        WaitS.Wait(1000);

        WebElement Loca = driver.findElement(By.id("CPVille"));
        Loca.sendKeys("Paris");
        WaitS.Wait(1000);
        Loca.sendKeys(Keys.ARROW_DOWN);
        WaitS.Wait(1000);
        Loca.sendKeys(Keys.ENTER);

        WebElement CH = driver.findElement(By.id("LV"));
        CH.click();
        WaitS.Wait(1000);
        CH.sendKeys(Keys.ARROW_DOWN);
        WaitS.Wait(1000);
        CH.sendKeys(Keys.ARROW_DOWN);
        WaitS.Wait(1000);
        Loca.sendKeys(Keys.ENTER);

        new Select(driver.findElement(By.xpath("//div[@class='tingle-modal-box__content']//select[@id='LV']"))).selectByIndex(1);
        driver.findElement(By.xpath("//div[@class='tingle-modal-box__content']//button[@id='btnCTA']")).click();
    }

    @Test

    public void Testvcg() {
        assert (1 == 1);

    }

}
