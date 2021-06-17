package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.DriverHelper;

public class HomePage extends BasePage {
    @FindBy(css = "[data-test='headerNavigation-navigationListItem-Create']")
    private WebElement createButton;

    public void clickOnCreateButton() {
        click(createButton);
    }


    public HomePage() {
        open(getUrl());
        PageFactory.initElements(DriverHelper.get().driver, this);
    }

    public void init() {
        PageFactory.initElements(driver, this);

    }

    @Override
    public String getUrl() {
        return BasePage.BASE_URL;
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        isDisplayed(createButton);
    }
}
