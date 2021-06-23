import PageObjects.Challenges;
import PageObjects.UserPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.DriverHelper;

import static org.testng.Assert.assertTrue;


public class ChallengeTest extends TestBase {


//    @BeforeTest
//    public void login() {
//        UserPage userPage = new UserPage();
//        Cookie cookie = new Cookie("user_key", "f783a943-e4c0-4b5d-93e6-e838aebb54c2");
//        driver.manage().addCookie(cookie);
//        Cookie cookie1 = new Cookie("OptanonAlertBoxClosed", "2021-05-18T12:44:14.761Z");
//        Cookie cookie2 = new Cookie("sid", "s%3AI36uAQJT__bIABI0QvCJxLVbp4_8-mAc.aOdJeBj4%2FMfWClp46mgI6zHep0Dhi8rvCSk6nFpgf5k");
//        driver.manage().addCookie(cookie1);
//        driver.manage().addCookie(cookie2);
//        driver.navigate().refresh();
//
//    }


    @Test
    public void qrCodeVisibility() {
        Challenges challenges = new Challenges();
        challenges.selectChallenge();
        challenges.clickOnButton();
        assertTrue(challenges.isVisibleQrCode(), "Qr code is not shown");


    }

}
