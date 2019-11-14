/*
 * Creation : 1 avr. 2019
 */
package DS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadsDS {

    public static void FillContactFormFrance(WebDriver driver, String[][] Data, int i) {
        driver.findElement(By.xpath("//label[2]//span[1]")).click();
        driver.findElement(By.id("txtLastname")).sendKeys(Data[i][1]);
        driver.findElement(By.id("txtFirstname")).sendKeys(Data[i][2]);
        driver.findElement(By.id("txtPostalCode")).sendKeys(Data[i][6]);
        driver.findElement(By.id("txtCity")).sendKeys(Data[i][7]);
        driver.findElement(By.id("txtEmail")).sendKeys(Data[i][3]);
        driver.findElement(By.id("txtPhone")).sendKeys(Data[i][4]);
        driver.findElement(By.id("txtComments")).sendKeys(Data[i][5]);
    }

    static void FillContactFormSpain(WebDriver driver, String[][] Data, int i) {
        driver.findElement(By.xpath("//label[2]//span[1]")).click();
        driver.findElement(By.id("txtLastname")).sendKeys(Data[i][1]);
        driver.findElement(By.id("txtFirstname")).sendKeys(Data[i][2]);
        driver.findElement(By.id("txtPostalCode")).sendKeys(Data[i][6]);
        driver.findElement(By.id("txtEmail")).sendKeys(Data[i][3]);
        driver.findElement(By.id("txtPhone")).sendKeys(Data[i][4]);
        driver.findElement(By.id("txtComments")).sendKeys(Data[i][5]);

    }

    static void FillContactFormItaly(WebDriver driver, String[][] Data, int i) {
        driver.findElement(By.xpath("//p[1]//label[2]//span[1]")).click();
        driver.findElement(By.id("txtLastname")).sendKeys(Data[i][1]);
        driver.findElement(By.id("txtFirstname")).sendKeys(Data[i][2]);
        driver.findElement(By.id("txtPostalCode")).sendKeys(Data[i][6]);
        driver.findElement(By.id("txtCity")).sendKeys(Data[i][7]);
        driver.findElement(By.id("txtEmail")).sendKeys(Data[i][3]);
        driver.findElement(By.id("txtPhone")).sendKeys(Data[i][4]);
        driver.findElement(By.id("txtComments")).sendKeys(Data[i][5]);
        driver.findElement(By.xpath("//p[7]//label[1]//span[1]")).click();
        driver.findElement(By.xpath("//p[@class='form-line control-group radiobutton-list no-bg']//label[3]//span[1]")).click();
    }

    static void FillContactFormBelgiumFR(WebDriver driver, String[][] Data, int i) {
        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/p[1]/label[1]/span")).click();
        driver.findElement(By.id("txtLastname")).sendKeys(Data[i][1]);
        driver.findElement(By.id("txtFirstname")).sendKeys(Data[i][2]);
        driver.findElement(By.id("txtCity")).sendKeys(Data[i][7]);
        driver.findElement(By.id("txtEmail")).sendKeys(Data[i][3]);
        driver.findElement(By.id("txtComments")).sendKeys(Data[i][5]);
        WebElement Loca = driver.findElement(By.name("address"));
        Loca.sendKeys(Data[i][7]);
        Loca.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-chevron']")));
        driver.findElement(By.xpath("//i[@class='icon-chevron']")).click();
        driver.findElement(By.id("0000051009")).click();
        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/div[9]/p[1]/label/span")).click();

    }

    static void FillContactFormBelgiumNL(WebDriver driver, String[][] Data, int i) {
        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/p[1]/label[1]/span")).click();
        driver.findElement(By.id("txtLastname")).sendKeys(Data[i][1]);
        driver.findElement(By.id("txtFirstname")).sendKeys(Data[i][2]);
        driver.findElement(By.id("txtCity")).sendKeys(Data[i][7]);
        driver.findElement(By.id("txtEmail")).sendKeys(Data[i][3]);
        driver.findElement(By.id("txtComments")).sendKeys(Data[i][5]);
        WebElement Loca = driver.findElement(By.name("address"));
        Loca.sendKeys(Data[i][7]);
        Loca.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-chevron']")));
        driver.findElement(By.xpath("//i[@class='icon-chevron']")).click();
        driver.findElement(By.id("0000051009")).click();
        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/div[9]/p[1]/label/span")).click();

    }

    static void FillContactFormSwidzerland(WebDriver driver) {
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/form[1]/div[1]/div[1]/div[1]/p[1]/label[2]/span[1]")).click();
        driver.findElement(By.id("txtLastname")).sendKeys("test");
        driver.findElement(By.id("txtFirstname")).sendKeys("test");
        driver.findElement(By.id("tbContactAddress1")).sendKeys("11 test");
        driver.findElement(By.id("txtPostalCode")).sendKeys("2344");
        driver.findElement(By.id("txtCity")).sendKeys("test");
        driver.findElement(By.id("txtEmail")).sendKeys("psaleadstest@gmail.com");
        driver.findElement(By.id("txtPhone")).sendKeys("0666666666");
        driver.findElement(By.id("txtComments")).sendKeys("this is a test for Swidzerland");
    }

    static void ClickSubmitButton(WebDriver driver) {
        driver.findElement(By.id("lnkBtnValidate")).click();
    }

    static boolean GetTheConfirmationMessage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='title']")));
        boolean message = driver.findElement(By.xpath("//p[@class='title']")).isDisplayed();
        return message;

    }
}
