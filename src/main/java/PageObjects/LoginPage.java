package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.DriverHelper;


public class LoginPage extends BasePage {
    @FindBy(name = "username")
    private WebElement usernameFieldLocation;
    @FindBy(name = "password")
    private WebElement passwordFieldLocation;
    @FindBy(css = "[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']")
    private WebElement loginButtonLocation;
    @FindBy(css = "[class='pa-uiLib-authentication-btn primary pa-uiLib-authentication-signIn']")
    private WebElement signInButtonLocation;
    @FindBy(css = "[class='pa-uiLib-headerProfileInfo-profileInfo']")
    private WebElement avatarImageLocation;
    @FindBy(css = "[class='socialSizeDescription-0-2-722']")
    private WebElement instagramIcon;

    @FindBy(css = "[class='pwCreateDesignContainer-0-2-719']")
    private WebElement instagramRatio;

    public LoginPage() {
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
        isDisplayed(usernameFieldLocation);
    }

    public void clickLoginButton() {
        click(loginButtonLocation);
//        new WebDriverWait(driver, 20)
//                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameFieldLocation));
    }

    public void typeUsername(String username) {
        type(usernameFieldLocation, username);
    }

    public void typePassword(String password) {
        type(passwordFieldLocation, password);
    }


    public void clickSignInButton() {
        click(signInButtonLocation);

    }

    public boolean isAvatarDisplayed() {

        return isDisplayed(avatarImageLocation);

    }

    public boolean isUserLoggedIn() {
        return isDisplayed(avatarImageLocation);
    }


    public void clickInstagram() {

        Actions actions = new Actions(driver);
        actions.moveToElement(instagramIcon).click().build().perform();
    }


}
