/*
 * Creation : 14 mai 2019
 */
package Peugeot;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReport {

    @Test
    public void loginTest() {

        System.out.println("Login Test to amazon");
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/TestReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        ExtentTest logger = extent.createTest("loginTest");
        logger.log(Status.INFO, "Login To Amazon");
        logger.log(Status.PASS, "Login To Google");
        extent.flush();

    }

}
