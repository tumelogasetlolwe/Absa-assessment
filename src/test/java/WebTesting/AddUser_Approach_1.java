package WebTesting;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.dog.breed.base.DriverInstance;
import org.dog.breed.contactClass.Constant;
import org.dog.breed.pages.AddUserPage;
import org.dog.breed.utils.Screenshots;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class AddUser_Approach_1 extends DriverInstance {

    final static Logger logger = Logger.getLogger(AddUser_Approach_1.class);


    public static ExtentTest test;
    String screenshotPath;
    String[] stringShotName;

    @Test(dataProvider = "data", dataProviderClass = DataProvider.class)
    public void integrationTest(Map<String, String> map) {


        test = extent.startTest("=== Approach 1 : Store Data In Collection API == ");
        logger.info("Approach 1 : Store Data In Collection API ==");
        AddUserPage addUserPage = new AddUserPage(driver);

        if (addUserPage.isUserListTablePresentOnThePage("userListTable_xpath")) {
            screenshotPath = Screenshots.captureScreenShots(driver, Constant.IMAGE_1);
            stringShotName = screenshotPath.split("/");
            test.log(LogStatus.INFO, "Web Table Screen" + test.addScreenCapture(Constant.TAKE_SCREEN_SHOT + stringShotName[4]));
            test.log(LogStatus.PASS, "We are on User List Table");

        }
        addUserPage.clickAddUserLink("add_user_xpath");
        test.log(LogStatus.INFO.INFO, "Navigate to Add User Screen");


        addUserPage.passValues("firstName_xpath", map.get("FirstName"));
        addUserPage.passValues("lastName_xpath", map.get("LastName"));

        addUserPage.passValues("userName_xpath", map.get("User Name"));

        addUserPage.passValues("password_xpath", map.get("Password"));

        addUserPage.clickAddUserLink("company_aaa_xpath");

        String role = map.get("Role").trim();
        Select ddn = new Select(driver.findElement(By.xpath("//td[@class='ng-scope']//select")));
        ddn.selectByVisibleText(role);


        addUserPage.passValues("email_xpath", map.get("Email"));

        addUserPage.passValues("mobile_phone", map.get("Cell").replace(".", ""));

        screenshotPath = Screenshots.captureScreenShots(driver, Constant.IMAGE_2);
        stringShotName = screenshotPath.split("/");
        test.log(LogStatus.INFO, "We are on Add User List Screen" + test.addScreenCapture(Constant.TAKE_SCREEN_SHOT + stringShotName[4]));


        addUserPage.clickAddUserLink("save_button_xpath");

        addUserPage.sleep(10);
        screenshotPath = Screenshots.captureScreenShots(driver, Constant.IMAGE_3);
        stringShotName = screenshotPath.split("/");
        test.log(LogStatus.PASS, "Back To User List Table" + test.addScreenCapture(Constant.TAKE_SCREEN_SHOT + stringShotName[4]));
    }


    @AfterMethod
    public void reportEnd() {
        extent.flush();


    }


}
