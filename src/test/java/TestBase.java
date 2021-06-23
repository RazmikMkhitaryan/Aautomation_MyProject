import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import setup.DriverHelper;

import java.io.IOException;


public class TestBase {
    protected WebDriver driver = DriverHelper.get().getDriver();


    @AfterMethod(alwaysRun = true)
    public void tearDown() throws IOException {
        DriverHelper.get().quitDriver();
    }
}
