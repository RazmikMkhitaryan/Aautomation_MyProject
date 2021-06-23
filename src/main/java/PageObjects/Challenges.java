package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Challenges extends BasePage {
    @FindBy(css = "[class='card card-big']")
    private WebElement gridItems;
    @FindBy(css = ".c-get-the-app-popup.js-prevent-default-event.primary-big-btn")
    private WebElement button;
    @FindBy(id = "qrcode")
    private WebElement qrCode;

    public Challenges() {
        open(getUrl());
        PageFactory.initElements(driver, this);
    }


    @Override
    public String getUrl() {
        return BASE_URL + "/challenges";
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        isDisplayed(gridItems);
    }
    public void selectChallenge() {
        click(gridItems);
    }

    public void clickOnButton() {

        click(button);
    }

    public boolean isVisibleQrCode() {
        if (qrCode.isDisplayed()) {
            return true;
        }
        return false;
    }
}
