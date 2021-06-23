package PageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserPage extends BasePage {
    @FindBy(css = "[data-page-source='user_profile'")
    private List<WebElement> imagesGrid;

    @FindBy(css = "[class*='c-like-button like']")
    private WebElement likeButton;
    @FindBy(linkText = "Challenges")
    private WebElement challenges;
    @FindBy(css = "[data-test='headerNavigation-navigationListItem-Discover']")
    private WebElement discovery;

    //@FindBy(css = "[class*='card card']")
    @FindBy(css = "[class='card card-big']")
    private WebElement gridItems;
    @FindBy(css = ".c-get-the-app-popup.js-prevent-default-event.primary-big-btn")
    private WebElement button;
    @FindBy(id = "qrcode")
    private WebElement qrCode;

    public UserPage() {
        open(getUrl());
        PageFactory.initElements(driver, this);
    }

    public void init() {
        PageFactory.initElements(driver, this);

    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        isDisplayed(likeButton);
    }

    @Override
    public String getUrl() {
        return BasePage.BASE_URL + "/u/joonieedits";
    }

    public void openUserPage() {
        open(getUrl());
    }

    public void openFirtsImage() {
        List<WebElement> all = imagesGrid;
        click(all.get(0));
    }


    public boolean like() {
        init();
        if ((likeButton).getAttribute("class").contains("active")) {
            System.out.println("Image was liked before ------ i did unlike ");
        } else {
            System.out.println("I like this photo");
        }
        try {
            click(likeButton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void goToDiscovery() {
        init();
        Actions actions = new Actions(driver);
        actions.moveToElement(discovery).build().perform();
    }

    public void clickOnChallanges() {
        init();
        click(challenges);
    }



}
