package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class ButtonsPage extends BasePage {
    private final By buttons = By.xpath("//h1[contains(.,'Buttons')]");
    private final By doubleClickButton = By.id("doubleClickBtn");
    private final By rightClickButton = By.id("rightClickBtn");
    private final By clickMeButton = By.xpath("(//button[contains(.,'Click Me')])[3]");

    private final By doubleClickMessage = By.id("doubleClickMessage");
    private final By rightClickMessage = By.id("rightClickMessage");
    private final By clickMeButtonMessage = By.id("dynamicClickMessage");

    public String getDoubleButtonText() {
        return find(doubleClickButton).getText();
    }

    public String getRightButtonText() {
        return find(rightClickButton).getText();
    }

    public String getDynamicButtonText() {
        return find(clickMeButton).getText();
    }

    public String getButtonsText() {
        return find(buttons).getText();
    }

    public String getClickMeClickMessage() {
        return find(clickMeButtonMessage).getText();
    }

    public void doubleClickOnButton() {
        delay(100); //TODO
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(doubleClickButton)).perform();
    }

    public String getDoubleClickMessage() {
        scrollToElementJS(doubleClickMessage);
        return find(doubleClickMessage).getText();
    }

    public String getRightClickMessage() {
        scrollToElementJS(rightClickMessage);
        return find(rightClickMessage).getText();
    }

    public void rightClickOnButton() {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(rightClickButton)).perform();
    }

    public void clickOnClickMeButton() {
        scrollToElementJS(clickMeButton);
        click(clickMeButton);
    }
}
