package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;


public class AllProductsPage extends BasePage{

    private By allProductsInPageOne1 = By.cssSelector("[class='GridList__column___4RviC']");

    @FindBy(css = "[class='GridList__column___4RviC']")
    private WebElement allProductsInPageOne;
    @FindBy(css = "[data-test='invitation-templates']")
    private WebElement invitationTamplate;
    @FindBy(css = "[data-test='page-next-arrow']")
    private WebElement nextPageButton;
    @FindBy(css = "[class ='Pagination__controlInput___2rZXA']")
    private WebElement pagesNumber;


    public AllProductsPage() {
        open(getUrl());
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    public AllProductsPage init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    public String getUrl() {
        return BasePage.BASE_URL + "/photo-editing-tools";
    }

//    public void openAllProducts() {
//        open(getUrl());
//    }

    public void scrollToElement() {
        init();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",nextPageButton);

    }

    public boolean isElelemtVisible() {
        return isDisplayed(invitationTamplate);
    }

    public int allPageProducts() {
        List<WebElement> all = findAll(allProductsInPageOne1);
        return all.size();
    }

    public int goToNextPage(int pageCount) {
        init();
        click(nextPageButton);
        return 1;

    }

    public void goToNextPage() {
        init();
        click(nextPageButton);


    }

    public int numberOfPage() {
        init();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(pagesNumber.getText());
    }

}
