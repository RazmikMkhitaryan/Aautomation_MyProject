import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import setup.DriverHelper;

import java.io.IOException;


public class TestBase {
    WebDriver driver = DriverHelper.get().getDriver();

//    @AfterMethod
//    public void tearDown() throws IOException {
//        DriverHelper.get().quitDriver(driver);
//    }
}
