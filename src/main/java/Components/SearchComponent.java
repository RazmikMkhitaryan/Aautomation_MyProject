package Components;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Clock;

public class SearchComponent extends ComponentBase {
    @FindBy(css = ".createSearchSection-0-2-581")
    private WebElement searchComponent;

    @FindBy(css = "[data-test='search-input']")
    private WebElement search;


    public SearchComponent(Clock clock, int timeOutInSeconds, WebDriver driver) {
        super(clock, timeOutInSeconds, driver);
        PageFactory.initElements(driver, this);
    }

    public SearchComponent init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        isDisplayed(searchComponent);
    }


    public void searchSomething() throws AWTException {

        super.type(search, "hello"+ Keys.ENTER) ;


    }

}
