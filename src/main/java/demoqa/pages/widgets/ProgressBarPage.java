package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ProgressBarPage extends BasePage {
    private final By progressBarText = By.xpath("//div[contains(@class, 'mb-3')]");
    private final By startStopButton = By.id("startStopButton");
    private final By resetButton = By.id("resetButton");
    private final By progressBarCurrent = By.xpath("//div[@role='progressbar']");
    private final By header = By.xpath("//h1[@class='text-center'][contains(.,'Progress Bar')]");

    public String getHeaderText() {
        return find(header).getText();
    }

    public String getProgressBarText() {
        return find(progressBarText).getText();
    }

    public String getStartStopButtonText() {
        return find(startStopButton).getText();
    }

    public String getResetButtonText() {
        return find(resetButton).getText();
    }

    public Integer getValueProgressBar() {
        return Integer.parseInt(driver.findElement(progressBarCurrent).getDomAttribute("aria-valuenow"));
    }

    private String getProgressBarValue() {
        try {
            return driver.findElement(progressBarCurrent).getDomAttribute("aria-valuenow");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return null; // Return null if the element is not found
        }
    }

    public String getColorProgressBar() {
        return driver.findElement(progressBarCurrent).getCssValue("background-color");
    }

    public String getValueOfProgressBarOnValue100() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
        wait.until(ExpectedConditions.attributeToBe(progressBarCurrent, "aria-valuenow", "100"));

        return driver.findElement(progressBarCurrent).getDomAttribute("aria-valuenow");
    }

    public void clickStartButton() {
        find(startStopButton).click();
    }

    public void clickResetButton() {
        find(resetButton).click();
    }

    public void clickStopButton() {
        find(startStopButton).click();
    }

    public void stopProgressBarOnValue(int targetValue) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String currentValueStr = getProgressBarValue();
                if (currentValueStr == null || currentValueStr.isEmpty()) {
                    return false;
                }
                try {
                    int currentValue = Integer.parseInt(currentValueStr);

                    if (currentValue >= targetValue) { // Click only when the target is reached or exceeded
                        find(startStopButton).click();
                        return true; // Return true to stop waiting after click
                    }
                    return false; // Continue waiting
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        });
    }
}
