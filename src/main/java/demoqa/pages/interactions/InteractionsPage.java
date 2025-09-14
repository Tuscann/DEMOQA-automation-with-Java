package demoqa.pages.interactions;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.JavaScriptUtility;

public class InteractionsPage extends BasePage {
    private final JavaScriptUtility javaScriptUtility;
    @FindBy(xpath = "//li[@id='item-0']/span[text()='Sortable']")
    private WebElement sortable;
    @FindBy(xpath = "//li[@id='item-1']/span[text()='Selectable']")
    private WebElement selectable;
    @FindBy(xpath = "//li[@id='item-2']/span[text()='Resizable']")
    private WebElement resizable;
    @FindBy(xpath = "//li[@id='item-3']/span[text()='Droppable']")
    private WebElement droppable;
    @FindBy(xpath = "//li[@id='item-4']/span[text()='Dragabble']")
    private WebElement draggable;
    @FindBy(xpath = "(//div[contains(.,'Please select an item from left to start practice.')])[5]")
    private WebElement text;
    @FindBy(xpath = "//div[@class='header-text'][contains(.,'Interactions')]")
    private WebElement interactionsHeader;
    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement frames;

    public InteractionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getMainText() {
        return text.getText();
    }

    public boolean verifySortableIsVisible() {
        return sortable.isDisplayed();
    }

    public void clickSortable() {
        javaScriptUtility.scrollToElementJS(sortable);
        sortable.click();
    }

    public void clickSelectable() {
        javaScriptUtility.scrollToElementJS(selectable);
        selectable.click();
    }

    public void clickResizable() {
        javaScriptUtility.scrollToElementJS(resizable);
        resizable.click();
    }

    public void clickDroppable() {
        javaScriptUtility.scrollToElementJS(droppable);
        droppable.click();
    }

    public void clickInteractions() {
        javaScriptUtility.scrollToElementJS(interactionsHeader);
        interactionsHeader.click();
    }

    public boolean verifyFramesIsNotVisible() {
        try {
            frames.isDisplayed();
            return false;  // If we get here, the element is visible
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return true;  // Element is not visible
        }
    }

    public void clickDraggable() {
        javaScriptUtility.scrollToElementJS(draggable);
        draggable.click();
    }
}
