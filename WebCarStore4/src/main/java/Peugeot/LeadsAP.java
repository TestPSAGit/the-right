/*
 * Creation : 1 avr. 2019
 */
package Peugeot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadsAP {

    static void FillContactFormFrance(WebDriver driver, String[][] Data, int i) {
        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/p[1]/label[1]/span")).click();
        driver.findElement(By.id("txtLastname")).sendKeys(Data[i][1]);
        driver.findElement(By.id("txtFirstname")).sendKeys(Data[i][2]);
        driver.findElement(By.id("txtEmail")).sendKeys(Data[i][3]);
        driver.findElement(By.id("txtPhone")).sendKeys(Data[i][4]);
        driver.findElement(By.id("txtComments")).sendKeys(Data[i][5]);
    }

    static void FillContactFormSpain(WebDriver driver, String[][] Data, int i) {
        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/p[1]/label[1]/span")).click();
        driver.findElement(By.id("txtLastname")).sendKeys(Data[i][1]);
        driver.findElement(By.id("txtFirstname")).sendKeys(Data[i][2]);
        driver.findElement(By.id("txtPostalCode")).sendKeys(Data[i][6]);
        driver.findElement(By.id("txtEmail")).sendKeys(Data[i][3]);
        driver.findElement(By.id("txtPhone")).sendKeys(Data[i][4]);
        driver.findElement(By.id("txtComments")).sendKeys("Data[i][5]");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='SI'])[1]/following::span[1]")).click();
    }

    static void FillContactFormItaly(WebDriver driver, String[][] Data, int i) {
        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/p[1]/label[1]/span")).click();
        driver.findElement(By.id("txtLastname")).sendKeys(Data[i][1]);
        driver.findElement(By.id("txtFirstname")).sendKeys(Data[i][2]);
        driver.findElement(By.id("txtPostalCode")).sendKeys(Data[i][6]);
        driver.findElement(By.id("txtCity")).sendKeys(Data[i][7]);
        driver.findElement(By.id("txtEmail")).sendKeys(Data[i][3]);
        driver.findElement(By.id("txtPhone")).sendKeys(Data[i][4]);
        driver.findElement(By.id("txtComments")).sendKeys(Data[i][5]);
        driver.findElement(By.xpath("//p[7]//label[2]//span[1]")).click();
        driver.findElement(By.xpath("//p[8]//label[3]//span[1]")).click();

    }

    static void FillContactFormBelgiumFR(WebDriver driver, String[][] Data, int i) {
        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/p[1]/label[1]/span")).click();
        driver.findElement(By.id("txtLastname")).sendKeys(Data[i][1]);
        driver.findElement(By.id("txtFirstname")).sendKeys(Data[i][2]);
        driver.findElement(By.id("txtCity")).sendKeys(Data[i][7]);
        driver.findElement(By.id("txtEmail")).sendKeys(Data[i][3]);
        driver.findElement(By.id("txtPhone")).sendKeys(Data[i][4]);
        driver.findElement(By.id("txtComments")).sendKeys(Data[i][5]);
        WebElement Loca = driver.findElement(By.name("address"));
        Loca.sendKeys("Bruxelles");
        Loca.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-chevron']")));
        driver.findElement(By.xpath("//i[@class='icon-chevron']")).click();
        driver.findElement(By.id("0000047884")).click();
        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/div[9]/p[1]/label/span")).click();

    }

    static void FillContactFormBelgiumNL(WebDriver driver, String[][] Data, int i) {

        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/p[1]/label[1]/span")).click();
        driver.findElement(By.id("txtLastname")).sendKeys(Data[i][1]);
        driver.findElement(By.id("txtFirstname")).sendKeys(Data[i][2]);
        driver.findElement(By.id("txtCity")).sendKeys(Data[i][7]);
        driver.findElement(By.id("txtEmail")).sendKeys(Data[i][3]);
        driver.findElement(By.id("txtPhone")).sendKeys(Data[i][4]);
        driver.findElement(By.id("txtComments")).sendKeys(Data[i][5]);
        WebElement Loca = driver.findElement(By.name("address"));
        Loca.sendKeys("Bruxelles");
        Loca.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-chevron']")));
        driver.findElement(By.xpath("//i[@class='icon-chevron']")).click();
        driver.findElement(By.id("0000047884")).click();
        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/div[9]/p[1]/label/span")).click();

    }

    static void FillContactFormPortugal(WebDriver driver, String[][] Data, int i) {
        driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div/div/div[1]/p[1]/label[1]/span")).click();
        driver.findElement(By.id("txtLastname")).sendKeys(Data[i][1]);
        driver.findElement(By.id("txtFirstname")).sendKeys(Data[i][2]);
        driver.findElement(By.id("tbContactAddress1")).sendKeys(Data[i][8]);
        driver.findElement(By.id("txtPostalCode")).sendKeys(Data[i][6]);
        driver.findElement(By.id("txtCity")).sendKeys(Data[i][7]);
        driver.findElement(By.id("txtEmail")).sendKeys(Data[i][3]);
        driver.findElement(By.id("txtPhone")).sendKeys(Data[i][4]);
        driver.findElement(By.id("txtComments")).sendKeys(Data[i][5]);

    }

    public static void ClickSubmitButton(WebDriver driver) {
        driver.findElement(By.id("lnkBtnValidate")).click();
    }

    static boolean GetTheConfirmationMessage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='title']")));
        boolean message = driver.findElement(By.xpath("//p[@class='title']")).isDisplayed();
        return message;

    }
}
