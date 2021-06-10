import PageObjects.GoldPage;
import org.testng.annotations.Test;

public class CarouselTest {
    @Test
    public void swipeCarousel() {
        GoldPage goldPage = new GoldPage();
        goldPage.swipeCarousel();
    }
}
