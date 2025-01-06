package demoqa.pages.alerts;

import demoqa.base.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class AlertsPage extends BasePage {

    private final By informationAlertButton = By.id("alertButton");
    private final By confirmationAlertButton = By.id("confirmButton");
    private final By confirmationTimeAlertButton = By.id("timerAlertButton");
    private final By promptAlertButton = By.id("promtButton");

    private final By confirmationResult = By.id("confirmResult");
    private final By promptResult = By.id("promptResult");

    private final By alertHeaderTitle = By.xpath("//h1[contains(.,'Alerts')]");
    private final By alertFirstTitle = By.xpath("//span[contains(.,'Click Button to see alert')]");
    private final By alertSecondTitle = By.xpath("//span[contains(.,'On button click, alert will appear after 5 seconds')]");
    private final By alertThirdTitle = By.xpath("//span[contains(.,'On button click, confirm box will appear')]");
    private final By alertFourTitle = By.xpath("//span[contains(.,'On button click, prompt box will appear')]");

    public String getHeaderText() {
        return find(alertHeaderTitle).getText();
    }

    public String getFirstText() {
        return find(alertFirstTitle).getText();
    }

    public String getSecondText() {
        return find(alertSecondTitle).getText();
    }

    public String getThirdText() {
        return find(alertThirdTitle).getText();
    }

    public String getFourthText() {
        return find(alertFourTitle).getText();
    }

    public String getPromptAlertResult() {
        return find(promptResult).getText();
    }

    public String getConfirmationResult() {
        return find(confirmationResult).getText();
    }

    public void clickInformationAlertButton() {
        click(informationAlertButton);
    }

    public void clickConfirmationAlertButton() {
        click(confirmationAlertButton);
    }

    public void clickPromptAlertButton() {
        click(promptAlertButton);
    }

    public boolean verifyNoAlertResult() {
        return driver.findElements(promptResult).isEmpty();
    }

    public void clickConfirmationTimeAlertButton() {
        scrollToElementJS(confirmationTimeAlertButton);
        click(confirmationTimeAlertButton);
    }
}
