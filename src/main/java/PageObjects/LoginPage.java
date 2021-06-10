package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static setup.DriverSetup.getDriver;

public class LoginPage extends BasePage {
    private By usernameFieldLocation = By.name("username");
    private By passwordFieldLocation = By.name("password");
    private By loginButtonLocation = By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']");
    private By signInButtonLocation = By.cssSelector("[class='pa-uiLib-authentication-btn primary pa-uiLib-authentication-signIn']");
    private By avatarImageLocation = By.cssSelector("[class='pa-uiLib-headerProfileInfo-profileInfo']");
    private By instagramIcon = By.cssSelector("[class='socialSizeDescription-0-2-722']");
    private By instagramRatio = By.cssSelector("[class='pwCreateDesignContainer-0-2-719']");


    public LoginPage() {
        driver.get("https://picsartstage2.com");

    }

    public void clickLoginButton() {
        click(find(loginButtonLocation));
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameFieldLocation));
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
        WebElement avatarIcon = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated((avatarImageLocation)));
        return find(avatarImageLocation).isDisplayed();

    }

    public boolean isUserLoggedIn() {
        WebElement avatarIcon = new WebDriverWait(driver, 40)
                .until(ExpectedConditions.visibilityOfElementLocated((avatarImageLocation)));
        return avatarIcon.isDisplayed();
    }


    @Override
    public String getUrl() {
        return BasePage.BASE_URL;
    }


    public void clickInstagram() {
        new WebDriverWait(getDriver(), 20)
                .until(ExpectedConditions.visibilityOfElementLocated((instagramRatio)));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(find(instagramIcon)).click().build().perform();
    }


}
