import PageObjects.BatchEditor;
import PageObjects.CreatePage;
import PageObjects.EditorPage;
import PageObjects.UserPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import setup.DriverHelper;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class EditorScreenTest extends TestBase {
    private WebDriver driver = DriverHelper.get().getDriver();

    /**
     * this test is liking user's image , if it was liked method did unlike and print in log
     */

    @Test
    public void likeImage() {
        UserPage userPage = new UserPage();
        userPage.openUserPage();
        login();
        userPage.openFirtsImage();
        assertTrue(userPage.like(), "Image not found");
    }

    /**
     * this test is doing upload and download 1 photo, download folder is in project resources/downloads
     */
    @Test
    public void uploadImageAndDownload() {
        CreatePage createPage = new CreatePage();
        createPage.openCreatePage();
        createPage.uploatImage();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EditorPage editorPage = (EditorPage) new EditorPage().get();
        editorPage.clickOnDownload();

    }

    /**
     * this test is doing upload and download 3 photo , download folder is in project resources/downloads
     */

    @Test
    public void uploadImages_And_Download() {
        CreatePage createPage = new CreatePage();
        createPage.openCreatePage();
        createPage.uploatImages();

        BatchEditor batchEditor = new BatchEditor();
        batchEditor.downloadImages();

    }


    public void login() {
        driver.manage().addCookie(new Cookie("user_key", "f783a943-e4c0-4b5d-93e6-e838aebb54c2"));
        driver.manage().addCookie(new Cookie("sid", "s%3A6wvimOnDxU4w6K0q-QS8ARWvpMUIk-Bf.XUYEwXpzY2FYeqQKf%2F4WrFvC0tz0NkRiKR8OuJcf8OQ"));
        driver.manage().addCookie(new Cookie("we-editor-first-open", "true"));
        driver.manage().addCookie(new Cookie("OptanonAlertBoxClosed", "some_value"));
        driver.navigate().refresh();
    }

}
