package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Objects;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class ProgressBarPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class, 'mb-3')]")
    private WebElement progressBarText;
    
    @FindBy(id = "startStopButton")
    private WebElement startStopButton;
    
    @FindBy(id = "resetButton")
    private WebElement resetButton;
    
    @FindBy(xpath = "//div[@role='progressbar']")
    private WebElement progressBarCurrent;
    
    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Progress Bar')]")
    private WebElement header;
    public ProgressBarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getHeaderText() {
        return header.getText();
    }
    
    public String getProgressBarText() {
        return progressBarText.getText();
    }
    
    public String getStartStopButtonText() {
        return startStopButton.getText();
    }
    
    public String getResetButtonText() {
        return resetButton.getText();
    }
    
    public Integer getValueProgressBar() {
        return Integer.parseInt(Objects.requireNonNull(progressBarCurrent.getDomAttribute("aria-valuenow")));
    }
    
    private String getProgressBarValue() {
        try {
            return progressBarCurrent.getDomAttribute("aria-valuenow");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return null;
        }
    }
    
    public String getColorProgressBar() {
        return progressBarCurrent.getCssValue("background-color");
    }
    
    public String getValueOfProgressBarOnValue100() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.attributeToBe(progressBarCurrent, "aria-valuenow", "100"));
        return progressBarCurrent.getDomAttribute("aria-valuenow");
    }
    
    public void clickStartButton() {
        scrollToElementJS(progressBarText);
        startStopButton.click();
    }
    
    public void clickResetButton() {
        resetButton.click();
    }
    
    public void clickStopButton() {
        startStopButton.click();
    }

    public void stopProgressBarOnValue2(int targetValue) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(10))
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
                        startStopButton.click();
                        return true; // Return true to stop waiting after click
                    }
                    return false; // Continue waiting
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        });
    }

    public int stopProgressBarOnValue(int targetValue) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(10))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        int x = 0;

        wait.until(new ExpectedCondition<Integer>() {
            public Integer apply(WebDriver driver) {
                String currentValueStr = getProgressBarValue();
                if (currentValueStr == null || currentValueStr.isEmpty()) {
                    return x;
                }
                try {
                    int currentValue = Integer.parseInt(currentValueStr);

                    if (currentValue >= targetValue) { // Click only when the target is reached or exceeded
                        startStopButton.click();
                        return currentValue; // Return true to stop waiting after click
                    } else {
                        return x; // Continue waiting
                    }

                } catch (NumberFormatException e) {
                    return x;
                }
            }
        });
        return x;
    }
}
