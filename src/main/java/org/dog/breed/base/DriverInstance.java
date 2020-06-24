package org.dog.breed.base;


import com.relevantcodes.extentreports.ExtentReports;
import org.apache.log4j.Logger;
import org.dog.breed.utility.Utility;
import org.dog.breed.utils.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverInstance {

    public ExtentReports extent =  ExtentManager.getInstance();

    final static Logger logger = Logger.getLogger(DriverInstance.class);



    public WebDriver driver;


    @BeforeMethod
    public void initiateDriverInstance() {
        try {
            if (Utility.fetchWebDetails("bowserName").equalsIgnoreCase("Chrome")) {
                logger.info("Brower selected is  : " + "chrome");

                System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

                driver = new ChromeDriver();

            }
            driver.get(Utility.fetchWebDetails("applicationURL"));
            driver.manage().window().maximize();

            Thread.sleep(3000);
        } catch (Exception e) {
            logger.error("This is error : " + e);
        }

    }

  @AfterMethod
    public void closeDriverInstance() throws Exception {

        Thread.sleep(5000);
        driver.close();
    }
}
