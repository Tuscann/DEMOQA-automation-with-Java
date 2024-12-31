package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public String getValueProgressBar() {
        return driver.findElement(progressBarCurrent).getDomAttribute("aria-valuenow");
    }

    public void clickStartButton() {
        find(startStopButton).click();
    }

    public void waitForProgressBarValue(int targetValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String currentValueStr = getProgressBarValue();
                if (currentValueStr == null || currentValueStr.isEmpty()) {
                    return false; // Handle cases where the element or attribute isn't present yet
                }
                try {
                    int currentValue = Integer.parseInt(currentValueStr);

                    if (currentValue == targetValue) {
                        find(startStopButton).click();
                    }
                    return currentValue == targetValue;
                } catch (NumberFormatException e) {
                    return false; // Handle cases where the attribute is not a number
                }
            }
        });
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

    public String getValueProgressBarAfter5seconds() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout as needed
        wait.until(ExpectedConditions.attributeToBe(progressBarCurrent, "aria-valuenow", "100"));

        return driver.findElement(progressBarCurrent).getDomAttribute("aria-valuenow");
    }
}
