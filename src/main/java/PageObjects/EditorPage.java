package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EditorPage extends BasePage {

    @FindBy(css = "[id='download-button']")
    private By exportButton;
    @FindBy(css = "[data-test='downloaded-button']")
    private By download;
    @FindBy(linkText = "Download")
    private By downloadButton;


    public EditorPage() {
        open(getUrl());
        PageFactory.initElements(driver, this);

    }

    public EditorPage init() {
        PageFactory.initElements(driver, this);

        return this;
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }


    @Override
    public String getUrl() {
        return BasePage.BASE_URL + "/create/editor";
    }

    public void clickOnDownload() {
        init();
        try {
            // Helpers.WaitHelper.getInstance().waitForElementDisplay(exportButton);
            click(exportButton);
            //  Helpers.WaitHelper.getInstance().waitForElementDisplay(download);
            init();
            click(download);

        } catch (Exception e) {
            init();
            // WaitHelper.getInstance().waitForElementDisplay(downloadButton);
            click(downloadButton);
            //  WaitHelper.getInstance().waitForElementDisplay(download);
            init();
            click(download);
        }


    }


}
