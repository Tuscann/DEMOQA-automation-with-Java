package demoqa.pages.Interactions;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InteractionsPage extends BasePage {
    private final By sortable = By.xpath("//li[@id='item-0']/span[text()='Sortable']");
    private final By selectable = By.xpath("//li[@id='item-1']/span[text()='Selectable']");
    private final By resizable = By.xpath("//li[@id='item-2']/span[text()='Resizable']");
    private final By droppable = By.xpath("//li[@id='item-3']/span[text()='Droppable']");
    private final By draggable = By.xpath("//li[@id='item-4']/span[text()='Dragabble']");
    private final By text = By.xpath("(//div[contains(.,'Please select an item from left to start practice.')])[5]");

    public InteractionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickSortable() {
        click(sortable);
    }

    public void clickSelectable() {
        click(selectable);
    }

    public void clickResizable() {
        click(resizable);
    }

    public void clickDroppable() {
        click(droppable);
    }

    public void clickDraggable() {
        click(draggable);
    }

    public String getMainText() {
        return find(text).getText();
    }
}
