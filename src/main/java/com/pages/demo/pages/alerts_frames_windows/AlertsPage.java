package com.pages.demo.pages.alerts_frames_windows;

import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class AlertsPage extends Alerts_Frames_WindowsPage {

    private final By informationAlertButton = By.id("alertButton");
    private final By confirmationAlertButton = By.id("confirmButton");
    private final By confirmationTimeAlertButton = By.id("timerAlertButton");
    private final By confirmationResult = By.id("confirmResult");
    private final By promptAlertButton = By.id("promtButton");
    private final By promptResult = By.id("promptResult");

    public String getPromptAlertResult() {
        return find(promptResult).getText();
    }

    public void clickPromptAlertButton() {
        click(promptAlertButton);
    }

    public void clickConfirmationTimeAlertButton() {
        scrollToElementJS(confirmationTimeAlertButton);
        click(confirmationTimeAlertButton);
    }

    public void clickInformationAlertButton() {
        click(informationAlertButton);
    }

    public void clickConfirmationAlertButton() {
        click(confirmationAlertButton);
    }

    public String getConfirmationResult() {
        return find(confirmationResult).getText();
    }
}
