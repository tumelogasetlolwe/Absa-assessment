package org.dog.breed.utils;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import org.dog.breed.contactClass.Constant;

import java.io.File;
import java.util.Date;


public class ExtentManager {
    private static ExtentReports extent;


    public static ExtentReports getInstance() {


        if (extent == null) {
            Date d = new Date();
            String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
/*
             String fileName = "reports.html";
*/

            extent = new ExtentReports(Constant.REPORT_PATH + fileName, true, DisplayOrder.NEWEST_FIRST);


            // extent.loadConfig(ResourceManager.getInstance().getResource("ReportsConfig.xml"));
            String reportFilename=Constant.REPORT_FILE_NAME_PATH;
            //extent.loadConfig(ResourceManager.getInstance().getResource("ReportsConfig.xml"));
            extent.loadConfig(new File(reportFilename));
            // optional
            extent.addSystemInfo("Selenium Version", "3.4.0").addSystemInfo(
                    "Environment", "QA");
        }
        return extent;
    }
}


