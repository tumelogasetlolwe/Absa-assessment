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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddUser_Approach_2 extends DriverInstance {

    final static Logger logger = Logger.getLogger(AddUser_Approach_2.class);


    public static ExtentTest test;
    String screenshotPath;
    String[] stringShotName;

    @Test()
    @Parameters({"FirstName", "LastName", "UserName", "Password", "Role", "Email", "Cell"})
    public void tc_002_addUser_DataFromTestNgXml(String FirstName, String LastName, String UserName, String Password, String Role, String Email, String Cell) {
        test = extent.startTest("=== Approach 2 : Store Data In TestNg.xml == ");
        logger.info("Approach 2 : Store Data In TestNg.xml");
        AddUserPage addUserPage = new AddUserPage(driver);

        if (addUserPage.isUserListTablePresentOnThePage("userListTable_xpath")) {
            screenshotPath = Screenshots.captureScreenShots(driver, Constant.IMAGE_1);
            stringShotName = screenshotPath.split("/");
            test.log(LogStatus.INFO, "Web Table Screen" + test.addScreenCapture(Constant.TAKE_SCREEN_SHOT + stringShotName[4]));
            test.log(LogStatus.PASS, "We are on User List Table");

        }
        addUserPage.clickAddUserLink("add_user_xpath");
        screenshotPath = Screenshots.captureScreenShots(driver, Constant.IMAGE_2);
        stringShotName = screenshotPath.split("/");
        test.log(LogStatus.INFO.INFO, "Navigate to Add User Screen");

        addUserPage.passValues("firstName_xpath", FirstName);
        test.log(LogStatus.INFO.INFO, "FirstName " + FirstName);

        addUserPage.passValues("lastName_xpath", LastName);

        addUserPage.passValues("userName_xpath", UserName);

        addUserPage.passValues("password_xpath", Password);

        addUserPage.clickAddUserLink("company_bbb_xpath");

        Select ddn = new Select(driver.findElement(By.xpath("//td[@class='ng-scope']//select")));
        ddn.selectByVisibleText(Role);


        addUserPage.passValues("email_xpath", Email);

        addUserPage.passValues("mobile_phone", Cell);

        screenshotPath = Screenshots.captureScreenShots(driver, Constant.IMAGE_3);
        stringShotName = screenshotPath.split("/");
        test.log(LogStatus.INFO, "We are on Add User List Screen" + test.addScreenCapture(Constant.TAKE_SCREEN_SHOT + stringShotName[4]));

        addUserPage.clickAddUserLink("save_button_xpath");

        addUserPage.sleep(10);
        screenshotPath = Screenshots.captureScreenShots(driver, Constant.IMAGE_4);
        stringShotName = screenshotPath.split("/");
        test.log(LogStatus.PASS, "Back To User List Table" + test.addScreenCapture(Constant.TAKE_SCREEN_SHOT + stringShotName[4]));
    }

    @AfterMethod
    public void reportEnd() {
        extent.flush();


    }


}
