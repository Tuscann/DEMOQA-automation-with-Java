package demoqa.pages.alerts;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.JavaScriptUtility;

import java.util.List;

public class AlertsPage extends BasePage {

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

    private final JavaScriptUtility javaScriptUtility;

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
        confirmationAlertButton.click();
    }

    public void clickPromptAlertButton() {
        promptAlertButton.click();
    }

    public boolean verifyNoAlertResult() {
        return promptResult.isEmpty();
    }

    public void clickConfirmationTimeAlertButton() {
        javaScriptUtility.scrollToElementJS(confirmationTimeAlertButton);
        confirmationTimeAlertButton.click();
    }

    public String getFirstButtonBackGroundColor() {
        return informationAlertButton.getCssValue("background-color");
    }

    public String getSecondButtonBackGroundColor() {
        return confirmationAlertButton.getCssValue("background-color");
    }

    public String getThirdButtonBackGroundColor() {
        return confirmationTimeAlertButton.getCssValue("background-color");
    }

    public String getFourthButtonBackGroundColor() {
        return promptAlertButton.getCssValue("background-color");
    }


    public String getFirstButtonText() {
        return informationAlertButton.getText();
    }

    public String getSecondButtonText() {
        return confirmationAlertButton.getText();
    }

    public String getThirdButtonText() {
        return confirmationTimeAlertButton.getText();
    }

    public String getFourButtonText() {
        return promptAlertButton.getText();
    }
}
