package Components;

import PageObjects.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import setup.DriverHelper;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

public abstract class ComponentBase<T extends SlowLoadableComponent<T>> extends SlowLoadableComponent<T> {

    private static final Logger LOGGER = Logger.getLogger(BasePage.class);
    protected WebDriver driver;

    public ComponentBase(Clock clock, int timeOutInSeconds) {
        super(clock, timeOutInSeconds);
        this.driver = DriverHelper.get().getDriver();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement find(By location) {
        LOGGER.info("Finding  element->" + location.toString());

        return driver.findElement(location);
    }

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


    public boolean isDisplayed(By location) {
        try {
            return find(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void changeTab(int tabIndex) {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(tabIndex));

    }

    public List<WebElement> findAll(By location) {
        return driver.findElements(location);
    }


}
