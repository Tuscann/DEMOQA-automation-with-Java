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

    private final By alert1Title = By.xpath("//h1[contains(.,'Alerts')]");
    private final By alert2Title = By.xpath("//span[contains(.,'Click Button to see alert')]");
    private final By alert3Title = By.xpath("//span[contains(.,'On button click, alert will appear after 5 seconds')]");
    private final By alert4Title = By.xpath("//span[contains(.,'On button click, confirm box will appear')]");
    private final By alert5Title = By.xpath("//span[contains(.,'On button click, prompt box will appear')]");

    public String getFirstText() {
        return find(alert1Title).getText();
    }

    public String getSecondText() {
        return find(alert2Title).getText();
    }

    public String getThirdText() {
        return find(alert3Title).getText();
    }

    public String getFourthText() {
        return find(alert4Title).getText();
    }

    public String getFiveText() {
        return find(alert5Title).getText();
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
