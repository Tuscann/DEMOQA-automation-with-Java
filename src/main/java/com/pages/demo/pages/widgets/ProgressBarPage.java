package com.pages.demo.pages.widgets;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

import java.time.Duration;

import static utilities.WaitUtility.fluentWaitUntilVisible;

public class ProgressBarPage extends BasePage {
    private final By progressBarText = By.xpath("//div[contains(@class, 'mb-3')]");
    private final By startStopButton = By.id("startStopButton");
    private final By progressBarCurrent = By.xpath("//div[@role='progressbar']");

    public void clickStartButtonAfter3seconds() throws InterruptedException {
        fluentWaitUntilVisible(3, startStopButton);
        find(startStopButton).click();
    }

    public void clickStartButton() {
        find(startStopButton).click();
    }

    public String getValueProgressBar() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return find(progressBarCurrent).getAttribute("aria-valuenow");
    }
}
