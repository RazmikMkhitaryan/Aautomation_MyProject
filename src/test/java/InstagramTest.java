import PageObjects.CreatePage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import setup.DriverHelper;

import static org.testng.Assert.assertEquals;


public class InstagramTest extends TestBase {
    private WebDriver driver = DriverHelper.get().getDriver();

    @Test
    public void clickInstagram() throws InterruptedException {

        CreatePage createPage = new CreatePage();
        createPage.clickInstagramStory();
        driver.manage().addCookie(new Cookie("we-editor-first-open", "true"));
        driver.manage().addCookie(new Cookie("OptanonAlertBoxClosed", "some_value"));
        driver.navigate().refresh();
        createPage.changeTab(1);
        createPage = createPage.init();
        createPage.clickFitIcon();
        createPage = createPage.init();

        assertEquals(createPage.getItemsCount(), 28, "Items count in editor was not correct!");
    }
}
