package PageObjects;

import org.openqa.selenium.By;

public class ImageBrowserPage extends BasePage {
    public static final String HASHTAG = "idid";
    private By photoHashtag = By.cssSelector("[href='/hashtag/"+HASHTAG+"']");

    public ImageBrowserPage() {
    }

    public ImageBrowserPage(String imageID) {
        open(BasePage.BASE_URL + "/i/" + imageID);
    }

    @Override
    public String getUrl() {
        return null;
    }

    public  boolean isHashtagAdded(){
            return isDisplayed(photoHashtag);
    }

}