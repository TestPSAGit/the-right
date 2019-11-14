/*
 * Creation : 24 avr. 2019
 */
package Utilities;

import java.time.LocalDate;
import java.util.Date;

import org.openqa.selenium.WebDriver;

public class DateManagement {
    static Date dDate;

    public static Date FormatDateSplited(String Date) {

        String[] DateSplited = Date.split(" ");

        if (DateSplited[1].equals("janvier") || DateSplited[1].equals("JANVIER")) {
            DateSplited[1] = "01";
        } else if (DateSplited[1].equals("février") || DateSplited[1].equals("FEVRIER")) {
            DateSplited[1] = "02";
        } else if (DateSplited[1].equals("mars") || DateSplited[1].equals("MARS")) {
            DateSplited[1] = "03";
        } else if (DateSplited[1].equals("avril") || DateSplited[1].equals("AVRIL")) {
            DateSplited[1] = "04";
        } else if (DateSplited[1].equals("mai") || DateSplited[1].equals("MAI")) {
            DateSplited[1] = "05";
        } else if (DateSplited[1].equals("juin") || DateSplited[1].equals("JUIN")) {
            DateSplited[1] = "06";
        } else if (DateSplited[1].equals("juillet") || DateSplited[1].equals("JUILLET")) {
            DateSplited[1] = "07";
        } else if (DateSplited[1].equals("août") || DateSplited[1].equals("AOUT")) {
            DateSplited[1] = "08";
        } else if (DateSplited[1].equals("septembre") || DateSplited[1].equals("SEPTEMBRE")) {
            DateSplited[1] = "09";
        } else if (DateSplited[1].equals("octobre") || DateSplited[1].equals("OCTOBRE")) {
            DateSplited[1] = "10";
        } else if (DateSplited[1].equals("novembre") || DateSplited[1].equals("NOVEMBRE")) {
            DateSplited[1] = "11";
        } else if (DateSplited[1].equals("décembre") || DateSplited[1].equals("DECEMBRE")) {
            DateSplited[1] = "12";
        }

        if (DateSplited[0].equals("1")) {
            DateSplited[0] = "01";
        } else if (DateSplited[0].equals("2")) {
            DateSplited[0] = "02";
        } else if (DateSplited[0].equals("3")) {
            DateSplited[0] = "03";
        } else if (DateSplited[0].equals("4")) {
            DateSplited[0] = "04";
        } else if (DateSplited[0].equals("5")) {
            DateSplited[0] = "05";
        } else if (DateSplited[0].equals("6")) {
            DateSplited[0] = "06";
        } else if (DateSplited[0].equals("7")) {
            DateSplited[0] = "07";
        } else if (DateSplited[0].equals("8")) {
            DateSplited[0] = "08";
        } else if (DateSplited[0].equals("9")) {
            DateSplited[0] = "09";
        }

        String DileveryDate = DateSplited[2] + "-" + DateSplited[1] + "-" + DateSplited[0];

        LocalDate date = LocalDate.parse(DileveryDate);

        return java.sql.Date.valueOf(date);

    }

    public static Date GetCurrentDate() {

        LocalDate localDate = LocalDate.now();
        return java.sql.Date.valueOf(localDate);

    }

    public static void SwitchDriverToCurrentPage(WebDriver driver) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

}
