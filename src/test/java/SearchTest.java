import Components.SearchComponent;
import PageObjects.CreatePage;
import PageObjects.HomePage;
import PageObjects.SearchedPage;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Clock;

import static org.testng.Assert.assertTrue;

public class SearchTest extends TestBase {
    Clock clock = Clock.systemUTC();
    Clock baseClock = Clock.systemDefaultZone();


    @Test
    private void searchSometjongTest() throws AWTException {
        CreatePage createPage = (CreatePage) new CreatePage().get();
        SearchComponent searchComponent = new SearchComponent(clock,10,driver);
        searchComponent.searchSomething();
        assertTrue(new SearchedPage().getCurrentUrl().contains("hello"),"search error");
    }
}
