import Helpers.ApiHelper;
import PageObjects.ImageBrowserPage;
import PageObjects.LoginPage;
import com.google.gson.JsonObject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import setup.DriverHelper;

import java.io.IOException;

import static org.testng.Assert.assertTrue;


public class HashtagTest extends TestBase {
    private String key;
    private String imageId;
    private WebDriver driver = DriverHelper.get().getDriver();


    @BeforeMethod
    public void setup() throws IOException, InterruptedException {
        JsonObject user = ApiHelper.createUser();
        key = user.get("response").getAsJsonObject().get("key").getAsString();
        LoginPage loginPage = new LoginPage();

        Cookie cookie = new Cookie("user_key", key);
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        JsonObject photo = ApiHelper.uploadPhoto(key);
        imageId = photo.get("id").getAsString();
        System.out.println("User's user_key is -> " + key);
    }

    /**
     * after test the created user deleted,  EXTRA task successfully done )))
     */
    @AfterMethod
    public void tearDown() throws IOException {
        ApiHelper.deleteUser(key);
        driver.navigate().refresh();
    }

    /**
     * This test is about adding hashtag in added image
     */
    @Test
    public void addHashtag() throws IOException, InterruptedException {
        ApiHelper.addHashtag(key, imageId, ImageBrowserPage.HASHTAG);
        ImageBrowserPage imageBrowserPage = new ImageBrowserPage(imageId);
        assertTrue(imageBrowserPage.isHashtagAdded(), "hashtag was not added");
    }
}
