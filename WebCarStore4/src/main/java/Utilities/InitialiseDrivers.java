/*
 * Creation : 28 mars 2019
 */
package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InitialiseDrivers {

    static WebDriver driver;

    public static WebDriver InitialiseChromDriver() {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--incognito");
        // options.addArguments("--headless");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\E562418\\git\\PSAWSCS\\WebCarStore\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver(capabilities);

        return driver;
    }

    public static WebDriver InitialiseFirefoxDriver() {

        System.setProperty("webdriver.gecko.driver", "\\Drivers\\geckodriver.exe");

        driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver InitialiseIEDriver() {
        System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");

        driver = new InternetExplorerDriver();
        return driver;
    }
}
