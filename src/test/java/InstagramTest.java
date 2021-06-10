import PageObjects.CreatePage;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static setup.DriverSetup.getDriver;

public class InstagramTest extends TestBase {
    @Test
    public void clickInstagram() throws InterruptedException {

        CreatePage createPage = new CreatePage();
        createPage.clickInstagramStory();
        getDriver().manage().addCookie(new Cookie("we-editor-first-open", "true"));
        getDriver().manage().addCookie(new Cookie("OptanonAlertBoxClosed", "some_value"));
        getDriver().navigate().refresh();
        createPage.changeTab(1);
        createPage = createPage.init();
        createPage.clickFitIcon();
        createPage = createPage.init();

        assertEquals(createPage.getItemsCount(), 28, "Items count in editor was not correct!");
    }
}
