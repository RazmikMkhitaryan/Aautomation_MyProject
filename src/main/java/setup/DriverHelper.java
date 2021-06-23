package setup;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverHelper {
    public static DriverHelper get() {
        DriverHelper driverHelper = new DriverHelper();
        return driverHelper;
    }

    private DriverHelper() {
    }

    private static final String BROWSER = System.getProperty("selenium.browser", "remote");
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driverThread.get() == null) {
            switch (BROWSER) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver",
                            "src/test/resources/chromedriver");
                     driver = new ChromeDriver();
                    driverThread.set(driver);
                    break;

                case "firefox":
                    System.setProperty("webdriver.gecko.driver",
                            "./src/main/resources/geckodriver");
                    driver = new FirefoxDriver();
                    driverThread.set(driver);
                    break;

                case "remote":
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName("chrome");
                    try {
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities );
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    driverThread.set(driver);
                    break;
                case "safari":
                     driver= new SafariDriver();
                     driverThread.set(driver);
                     driver.manage().window().maximize();
                     break;
            }
        }
        return driverThread.get();
    }

    public void quitDriver() {
        getDriver().quit();
        driverThread.remove();
    }
}
