package PageObjects;

public class SearchedPage extends BasePage {


    @Override
    public String getUrl() {
        return BASE_URL + "/create/search?q=hello";
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl().toString();
    }
}
