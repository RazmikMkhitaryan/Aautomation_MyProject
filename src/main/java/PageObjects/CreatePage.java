package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.DriverHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CreatePage extends BasePage {
    private WebDriver driver = DriverHelper.get().getDriver();

    @FindBy(css = "[data-test='headerNavigation-navigationListItem-Products']")
    private WebElement products;
    @FindBy(css = "[href='/photo-editing-tools']")
    private WebElement seeAll;

    @FindBy(css = "[accept='image/jpeg, image/png, image/gif']")
    private WebElement uploadButton;

    @FindBy(css = "[data-test='insta-story']")
    private WebElement instagramStory;

    @FindBy(css = "[class*='customSizeContainer']")
    private List<WebElement> editorItems;

    @FindBy(id = "background-category")
    private WebElement fitIconItem;


    public CreatePage() {
        open(getUrl());
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        isDisplayed(instagramStory);
    }

    public CreatePage init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    public String getUrl() {
        return BasePage.BASE_URL + "/create";
    }

    public void openCreatePage() {
        open(getUrl());
    }

    public void uploadphoto() {
        type(uploadButton, "/Users/razmkhitaryan/Desktop/lessons/image.png");
    }

    public void uploatImages() {
        List<String> images = new ArrayList<>();
        images.add(System.getProperty("user.dir") + File.separator + "src/main/resources/image.jpeg");
        images.add(System.getProperty("user.dir") + File.separator + "src/main/resources/image2.jpeg");
        images.add(System.getProperty("user.dir") + File.separator + "src/main/resources/image3.jpeg");
        type(uploadButton, images.get(0) + "\n" + images.get(1) + "\n" + images.get(2));

    }

    public void goToProducts() {
        Actions actions = new Actions(driver);
        actions.moveToElement(products).build().perform();
        init();
        //WaitHelper.getInstance().waitForElementDisplay(seeAll);
        click(seeAll);
    }

    public void uploatImage() {
        type(uploadButton, System.getProperty("user.dir") + File.separator + "src/main/resources/image.jpeg");
    }

    public void clickInstagramStory() {
//        Helpers.WaitHelper.getInstance().waitForElementToBeDisplayed(instagramStory);
        Actions actions = new Actions(driver);
        actions.moveToElement(instagramStory).click().build().perform();
    }

    public int getItemsCount() {
        // Helpers.WaitHelper.getInstance().waitForElementDisplay(editorItems.get(0));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return editorItems.size();

    }

    public void clickFitIcon() {
        init();
        //WaitHelper.getInstance().waitForElementDisplay(fitIconItem);
        click(fitIconItem);
    }
}

