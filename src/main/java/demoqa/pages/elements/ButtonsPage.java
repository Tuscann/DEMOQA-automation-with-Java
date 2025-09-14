package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public ButtonsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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

    public String getDoubleClickMessage() {
        return doubleClickMessage.getText();
    }

    public String getRightClickMessage() {
        return rightClickMessage.getText();
    }

    public void clickOnClickMeButton() {
        clickMeButton.click();
    }

    public void clickOnButtonDoubleClickMe() {
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickMeButton).perform();
    }

    public void clickOnButtonRightClickMe() {
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickMeButton).perform();
    }
}
