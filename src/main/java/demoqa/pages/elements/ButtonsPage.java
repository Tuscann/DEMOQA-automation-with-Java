package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class ButtonsPage extends BasePage {
    private final By buttons = By.xpath("//h1[contains(.,'Buttons')]");
    private final By doubleClickMeButton = By.id("doubleClickBtn");
    private final By rightClickMeButton = By.id("rightClickBtn");
    private final By clickMeButton = By.xpath("(//button[contains(.,'Click Me')])[3]");

    private final By doubleClickMessage = By.id("doubleClickMessage");
    private final By rightClickMessage = By.id("rightClickMessage");
    private final By clickMeButtonMessage = By.id("dynamicClickMessage");

    public String getDoubleButtonText() {
        return find(doubleClickMeButton).getText();
    }

    public String getRightButtonText() {
        return find(rightClickMeButton).getText();
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

    public String getDoubleClickButtonBackGroundColor() {
        return find(doubleClickMeButton).getCssValue("background-color");
    }

    public String getDoubleClickButtonBorderColor() {
        return find(doubleClickMeButton).getCssValue("border-color");
    }

    public String getRightClickMeButtonBorderColor() {
        return find(rightClickMeButton).getCssValue("border-color");
    }

    public String getRightClickMeButtonBackGroundColor() {
        return find(rightClickMeButton).getCssValue("background-color");
    }

    public String getClickMeButtonBackGroundColor() {
        return find(clickMeButton).getCssValue("background-color");
    }

    public String getClickMeButtonBorderColor() {
        return find(clickMeButton).getCssValue("border-color");
    }

    public void doubleClickOnButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(doubleClickMeButton)));

        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(doubleClickMeButton)).perform();
    }

    public String getDoubleClickMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(doubleClickMeButton)));

        scrollToElementJS(doubleClickMessage);
        return find(doubleClickMessage).getText();
    }

    public String getRightClickMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(rightClickMessage)));

        scrollToElementJS(rightClickMessage);
        return find(rightClickMessage).getText();
    }

    public void rightClickOnButton() {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(rightClickMeButton)).perform();
    }

    public void clickOnClickMeButton() {
        scrollToElementJS(clickMeButton);
        click(clickMeButton);
    }
}
