package demoqa.pages.interactions;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class InteractionsPage extends BasePage {
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

    public InteractionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickSortable() {
        scrollToElementJS(sortable);
        sortable.click();
    }

    public void clickSelectable() {
        scrollToElementJS(selectable);
        selectable.click();
    }

    public void clickResizable() {
        scrollToElementJS(resizable);
        resizable.click();
    }

    public void clickDroppable() {
        scrollToElementJS(droppable);
        droppable.click();
    }

    public void clickDraggable() {
        scrollToElementJS(draggable);
        draggable.click();
    }

    public String getMainText() {
        return text.getText();
    }
}
