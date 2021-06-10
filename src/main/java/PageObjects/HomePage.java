package PageObjects;

import Helpers.WaitHelper;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By createButton = By.cssSelector("[data-test='headerNavigation-navigationListItem-Create']");

    public void clickOnCreateButton(){
        WaitHelper.getInstance().waitForElementDisplay(createButton);
        click(createButton);
    }

    @Override
    public String getUrl() {
        return BasePage.BASE_URL;
    }
}
