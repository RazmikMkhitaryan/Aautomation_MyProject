package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.DriverHelper;

public class ImageBrowserPage extends BasePage {
    public static final String HASHTAG = "idid";
    @FindBy(css = "[href='/hashtag/\"+HASHTAG+\"']")
    private By photoHashtag ;

    public ImageBrowserPage() {
       // open(getUrl());
        PageFactory.initElements(DriverHelper.get().driver, this);
    }

    public void init() {
        PageFactory.initElements(driver, this);

    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        isDisplayed(photoHashtag);
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