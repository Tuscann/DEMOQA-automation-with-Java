package demoqa.pages.interactions;

import demoqa.base.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class ResizablePage extends BasePage {
    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Resizable')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='text'][contains(.,'Resizable box, starting at 200x200. Min size is 150x150, max is 500x300.')]")
    private WebElement resizableBoxWithRestrictionText;

    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Resizable')]")
    private WebElement resizable;

    @FindBy(id = "resizableBoxWithRestriction")
    private WebElement resizableBoxWithRestriction;

    @FindBy(id = "resizable")
    private WebElement resizableWithoutRestriction;

    @FindBy(xpath = "(//span[contains(@class,'react-resizable-handle react-resizable-handle-se')])[1]")
    private WebElement resizeHandle;

    @FindBy(xpath = "(//span[contains(@class,'react-resizable-handle react-resizable-handle-se')])[2]")
    private WebElement resizeHandle2;

    public ResizablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageTitleText() {
        return pageTitle.getText();
    }

    public String getResizableBoxWithRestrictionText() {
        return resizableBoxWithRestrictionText.getText();
    }

    public String getResizableText() {
        return resizable.getText();
    }

    public void changeSize(int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizeHandle)
                .moveByOffset(xOffset, yOffset)
                .release()
                .perform();
    }

    public String getNewSizeBox() {
        Dimension initialSize = resizableBoxWithRestriction.getSize();
        return initialSize.toString();
    }

    public String getNewSizeBox2() {
        Dimension initialSize = resizableWithoutRestriction.getSize();
        return initialSize.toString();
    }

    public void changeSizeWithoutLimitations(int xOffset, int yOffset) {
        scrollToElementJS(resizeHandle2);
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizeHandle2)
                .moveByOffset(xOffset, yOffset)
                .release()
                .perform();
    }

    public boolean isResizeHandleVisible() {
        try {
            return resizeHandle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isResizeHandle2Visible() {
        try {
            return resizeHandle2.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}