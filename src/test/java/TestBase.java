import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import setup.DriverSetup;

import java.io.IOException;

import static setup.DriverSetup.getDriver;

public class TestBase {

    @AfterMethod
    public void tearDown() throws IOException {
        DriverSetup.quit();
    }
}
