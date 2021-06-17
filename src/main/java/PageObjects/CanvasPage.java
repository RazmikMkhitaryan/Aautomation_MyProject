package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CanvasPage extends BasePage {
    @FindBy(css = "[data-test='canvas-container'] .konvajs-content")
    private WebElement canvas;

    @FindBy(id = "context-menu")
    private WebElement contexMenu;


    public CanvasPage() {
        open(getUrl());
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        isDisplayed(canvas);
    }


    public CanvasPage init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/create/editor?templateSize=insta_story";
    }


    public CanvasPage rightClick() {
        init();
        Actions action = new Actions(driver);
        action.contextClick(canvas).perform();
        return this;
    }


    public boolean menuIsDisplayed(){
        return isDisplayed(contexMenu);
    }

}
