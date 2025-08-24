package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.JavaScriptUtility;

import java.time.Duration;

public class ButtonsPage extends BasePage {

    @FindBy(xpath = "//h1[contains(.,'Buttons')]")
    WebElement buttons;
    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickMeButton;
    @FindBy(id = "rightClickBtn")
    WebElement rightClickMeButton;
    @FindBy(xpath = "(//button[contains(.,'Click Me')])[3]")
    WebElement clickMeButton;
    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;
    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;
    @FindBy(id = "dynamicClickMessage")
    WebElement clickMeButtonMessage;

    private final JavaScriptUtility javaScriptUtility;

    public ButtonsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getDoubleButtonText() {
        return doubleClickMeButton.getText();
    }

    public String getRightButtonText() {
        return rightClickMeButton.getText();
    }

    public String getDynamicButtonText() {
        return clickMeButton.getText();
    }

    public String getButtonsText() {
        return buttons.getText();
    }

    public String getClickMeClickMessage() {
        return clickMeButtonMessage.getText();
    }

    public String getDoubleClickButtonBackGroundColor() {
        return doubleClickMeButton.getCssValue("background-color");
    }

    public String getDoubleClickButtonBorderColor() {
        return doubleClickMeButton.getCssValue("border-color");
    }

    public String getRightClickMeButtonBorderColor() {
        return rightClickMeButton.getCssValue("border-color");
    }

    public String getRightClickMeButtonBackGroundColor() {
        return rightClickMeButton.getCssValue("background-color");
    }

    public String getClickMeButtonBackGroundColor() {
        return clickMeButton.getCssValue("background-color");
    }

    public String getClickMeButtonBorderColor() {
        return clickMeButton.getCssValue("border-color");
    }

    public void doubleClickOnButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(doubleClickMeButton));

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickMeButton).perform();
    }

    public String getDoubleClickMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(doubleClickMeButton));

        javaScriptUtility.scrollToElementJS(doubleClickMessage);
        return doubleClickMessage.getText();
    }

    public String getRightClickMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(rightClickMessage));

        javaScriptUtility.scrollToElementJS(rightClickMessage);
        return rightClickMessage.getText();
    }

    public void rightClickOnButton() {
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickMeButton).perform();
    }

    public void clickOnClickMeButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(clickMeButton));

        javaScriptUtility.scrollToElementJS(clickMeButton);
        clickMeButton.click();
    }
}
