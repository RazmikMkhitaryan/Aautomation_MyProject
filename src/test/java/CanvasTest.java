import PageObjects.CanvasPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CanvasTest extends TestBase {
    @Test
    public void rightClick() throws InterruptedException {
        CanvasPage canvasPage = new CanvasPage();
        Thread.sleep(4000);
        canvasPage.rightClick();
        assertTrue(canvasPage.menuIsDisplayed(), "menu is not showing");
    }
}
