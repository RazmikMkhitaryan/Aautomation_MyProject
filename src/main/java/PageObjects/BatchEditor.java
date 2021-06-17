package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BatchEditor extends BasePage {
    @FindBy(css = "[class='toolbarItem-0-2-115']")
    private By download;

    public BatchEditor() {
        open(getUrl());
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        isDisplayed(download);
    }

    public BatchEditor init() {
        PageFactory.initElements(driver, this);
        return this;
    }


    @Override
    public String getUrl() {
        return BasePage.BASE_URL + "/create/batch";
    }

    public void downloadImages() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        changeTab(1);
        init();
       // WaitHelper.getInstance().waitForElementDisplay(download);
        click(download);
    }
}