package PageObjects;

import Helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static setup.DriverSetup.getDriver;

public class UserPage extends BasePage {
    private By imagesGrid = By.cssSelector("[data-page-source='user_profile']");
    private By likeButton = By.cssSelector("[class*='c-like-button like']");
    private By challenges = By.linkText("Challenges");
    private By discovery = By.cssSelector("[data-test='headerNavigation-navigationListItem-Discover']");
    private By gridItems = By.cssSelector("[class*='card card']");
    private By button = By.cssSelector(".c-get-the-app-popup.js-prevent-default-event.primary-big-btn");
    private By qrCode = By.id("qrcode");


    @Override
    public String getUrl() {
        return BasePage.BASE_URL + "/u/joonieedits";
    }

    public void openUserPage() {
        open(getUrl());
    }

    public void openFirtsImage() {
        WaitHelper.getInstance().waitForElementDisplay(imagesGrid);
        List<WebElement> all = findAll(imagesGrid);
        click(all.get(0));
    }


    public boolean like() {
        WaitHelper.getInstance().waitForElementDisplay(likeButton);
        if (find(likeButton).getAttribute("class").contains("active")) {
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
        WaitHelper.getInstance().waitForElementDisplay(discovery);
        WebElement element = getDriver().findElement(discovery);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).build().perform();
    }

    public void clickOnChallanges() {
        WaitHelper.getInstance().waitForBeClickable(challenges);
        click(challenges);
    }

    public void selectChallenge() {
        WaitHelper.getInstance().waitForElementDisplay(gridItems);
        List<WebElement> element = getDriver().findElements(gridItems);

        click(element.get(element.size() - 1));
    }

    public void clickOnButton() {
        WaitHelper.getInstance().waitForElementDisplay(button);
        click(button);
    }

    public boolean isVisibleQrCode() {
        if (find(qrCode).isDisplayed()) {
            return true;
        }
        return false;
    }

}
