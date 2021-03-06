package PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;
import setup.DriverHelper;

import java.util.ArrayList;
import java.util.List;


public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    private static final Logger LOGGER = Logger.getLogger(BasePage.class);
    protected WebDriver driver;
    public static final String BASE_URL = "http://picsartstage2.com";
//    {
//        String url = System.getProperty("selenium.url", "http://picsartstage2.com");
//
//    }

    public BasePage() {

        this.driver = DriverHelper.get().getDriver();
    }

    public abstract String getUrl();

    public void open(String url) {
        LOGGER.info("OPening url->" + url);
        driver.get(url);
    }

    public WebElement find(By location) {
        LOGGER.info("Finding  element->" + location.toString());

        return driver.findElement(location);
    }
//    public WebElement find(WebElement element) {
//        LOGGER.info("Finding  element->" + element.toString());
//
//        return driver.findElement((By) element);
//    }

    public void type(By location, String text) {
        LOGGER.info("Typing element->" + text);
        find(location).sendKeys(text);
    }

    public void type(WebElement element, String text) {
        LOGGER.info("Typing element->" + text);
        element.sendKeys(text);
    }

    public void click(By location) {
        LOGGER.info("clicking on element" + location.toString());
        click(find(location));
    }

    public void click(WebElement element) {
        element.click();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayed(By location) {
        try {
            return find(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isClickable(WebElement element){
      return   isClickable(element);
    }

    public void changeTab(int tabIndex) {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(tabIndex));

    }

    public List<WebElement> findAll(By location) {
        return driver.findElements(location);
    }


}
