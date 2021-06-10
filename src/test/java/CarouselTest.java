import PageObjects.GoldPage;
import org.testng.annotations.Test;

public class CarouselTest extends TestBase {
    @Test
    public void swipeCarousel() {
        GoldPage goldPage = new GoldPage();
        goldPage.swipeCarousel();
    }
}
