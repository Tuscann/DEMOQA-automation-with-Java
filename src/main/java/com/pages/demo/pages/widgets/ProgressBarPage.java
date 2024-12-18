package com.pages.demo.pages.widgets;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.WaitUtility.fluentWaitUntilVisible;

public class ProgressBarPage extends BasePage {
    private final By progressBarText = By.xpath("//div[contains(@class, 'mb-3')]");
    private final By startStopButton = By.id("startStopButton");
    private final By progressBarCurrent = By.xpath("//div[@role='progressbar']");
    private final By header = By.xpath("//h1[@class='text-center'][contains(.,'Progress Bar')]");


    public void clickStartButtonAfter3seconds() throws InterruptedException {
        fluentWaitUntilVisible(3, startStopButton);
        find(startStopButton).click();
    }

    public void clickStartButton() {
        find(startStopButton).click();
    }

    public String getValueProgressBar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
        wait.until(ExpectedConditions.attributeToBe(progressBarCurrent, "aria-valuenow", "100"));

        return driver.findElement(progressBarCurrent).getDomAttribute("aria-valuenow");
    }

    public String getHeaderText() {
        return find(header).getText();
    }

    public String getProgressBarText() {
        return find(progressBarText).getText();
    }

    public String getStartStopButtonText() {
        return find(startStopButton).getText();
    }

    public void stopOnValeProgressBar(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
        wait.until(ExpectedConditions.attributeToBe(progressBarCurrent, "aria-valuenow", expectedText));
        find(startStopButton).click();

    }
}
