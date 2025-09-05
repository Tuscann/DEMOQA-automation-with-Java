package demoqa.pages.alerts;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.JavaScriptUtility;

import java.util.List;

public class AlertsPage extends BasePage {

    private final JavaScriptUtility javaScriptUtility;
    @FindBy(id = "alertButton")
    WebElement informationAlertButton;
    @FindBy(id = "confirmButton")
    WebElement confirmationAlertButton;
    @FindBy(id = "timerAlertButton")
    WebElement confirmationTimeAlertButton;
    @FindBy(id = "promtButton")
    WebElement promptAlertButton;
    @FindBy(id = "confirmResult")
    WebElement confirmationResult;
    @FindBy(id = "promptResult")
    List<WebElement> promptResult;
    @FindBy(xpath = "//h1[contains(.,'Alerts')]")
    WebElement alertHeaderTitle;
    @FindBy(xpath = "//span[contains(.,'Click Button to see alert')]")
    WebElement alertFirstTitle;
    @FindBy(xpath = "//span[contains(.,'On button click, alert will appear after 5 seconds')]")
    WebElement alertSecondTitle;
    @FindBy(xpath = "//span[contains(.,'On button click, confirm box will appear')]")
    WebElement alertThirdTitle;
    @FindBy(xpath = "//span[contains(.,'On button click, prompt box will appear')]")
    WebElement alertFourthTitle;

    public AlertsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getAlertsHeaderText() {
        return alertHeaderTitle.getText();
    }

    public String getFirstAlertTitle() {
        return alertFirstTitle.getText();
    }

    public String getSecondAlertTitle() {
        return alertSecondTitle.getText();
    }

    public String getThirdAlertTitle() {
        return alertThirdTitle.getText();
    }

    public String getFourthAlertTitle() {
        return alertFourthTitle.getText();
    }

    public String getPromptAlertResult() {
        return promptResult.getFirst().getText();
    }

    public String getConfirmationResult() {
        return confirmationResult.getText();
    }

    public void clickInformationAlertButton() {
        informationAlertButton.click();
    }

    public void clickConfirmationAlertButton() {
        //  javaScriptUtility.scrollToElementJS(confirmationAlertButton);
        confirmationAlertButton.click();
    }

    public void clickPromptAlertButton() {
        //    javaScriptUtility.scrollToElementJS(promptAlertButton);
        promptAlertButton.click();
    }

    public boolean verifyNoAlertResult() {
        return promptResult.isEmpty();
    }

    public void clickConfirmationTimeAlertButton() {
        //   javaScriptUtility.scrollToElementJS(confirmationTimeAlertButton);
        confirmationTimeAlertButton.click();
    }

    public String getFirstClickMeButtonBackGroundColor() {
        return informationAlertButton.getCssValue("background-color");
    }

    public String getSecondClickMeButtonBackGroundColor() {
        return confirmationAlertButton.getCssValue("background-color");
    }

    public String getThirdClickMeButtonBackGroundColor() {
        return confirmationTimeAlertButton.getCssValue("background-color");
    }

    public String getFourthClickMeButtonBackGroundColor() {
        return promptAlertButton.getCssValue("background-color");
    }

    public String getFirstClickMeButtonText() {
        return informationAlertButton.getText();
    }

    public String getSecondClickMeButtonText() {
        return confirmationAlertButton.getText();
    }

    public String getThirdClickMeButtonText() {
        return confirmationTimeAlertButton.getText();
    }

    public String getFourClickButtonText() {
        return promptAlertButton.getText();
    }

    public String getConfirmationResultBackgroundColor() {
        return confirmationResult.getCssValue("color");
    }

    public String getPromptResultBackgroundColor() {
        return promptResult.getFirst().getCssValue("color");
    }
}
