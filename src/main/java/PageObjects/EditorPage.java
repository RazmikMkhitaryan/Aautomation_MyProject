package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.DriverHelper;


public class EditorPage extends BasePage {

    @FindBy(id = "download-button")
    private WebElement exportButton;
    @FindBy(css = "[data-test='downloaded-button']")
    private WebElement download;
    @FindBy(linkText = "Download")
    private WebElement downloadButton;
    @FindBy(css = ".canvasContainer-0-2-1042")
    private WebElement canvas;

    public EditorPage() {

        PageFactory.initElements(DriverHelper.get().getDriver(), this);

    }

    public EditorPage init() {
        PageFactory.initElements(DriverHelper.get().getDriver(), this);

        return this;
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        isClickable(exportButton);
        isDisplayed(canvas);
    }


    @Override
    public String getUrl() {
        return BasePage.BASE_URL + "/create/editor";
    }

    public void clickOnDownload() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        init();
        try {
            click(exportButton);
            init();
            click(download);

        } catch (Exception e) {
            init();
            click(downloadButton);
            init();
            click(download);
        }


    }


}
