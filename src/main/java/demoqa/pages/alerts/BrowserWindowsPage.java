package demoqa.pages.alerts;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserWindowsPage extends BasePage {

    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Browser Windows')]")
    WebElement header;
    @FindBy(id = "tabButton")
    WebElement newTabButton;
    @FindBy(id = "windowButton")
    WebElement newWindowButton;
    @FindBy(id = "messageWindowButton")
    WebElement newWindowMessageButton;

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickNewTabButton() {
        newTabButton.click();
    }

    public void clickNewWindowButton() {
        newWindowButton.click();
    }

    public void clickNewWindowMessageButton() {
        newWindowMessageButton.click();
    }

    public String getNewTabUrl() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return driver.getCurrentUrl();
    }

    public String getNewWindowUrl() {

        String originalWindow = driver.getWindowHandle();

        String actualWindowUrl = "";
        Set<String> allWindows = driver.getWindowHandles();
        for (String currentWindowHandle : allWindows) {
            if (!currentWindowHandle.equals(originalWindow)) {
                driver.switchTo().window(currentWindowHandle);
                actualWindowUrl = driver.getCurrentUrl();
                break;
            }
        }
        return actualWindowUrl;
    }

    public String getBrowserMessage() {
        String originalWindow = driver.getWindowHandle();
        String expectedMessage = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";

        try {
            // Wait for the new window to appear
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Get all window handles
        Set<String> allWindows = driver.getWindowHandles();
        String newWindow = null;

        // Find the new window handle
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                newWindow = window;
                break;
            }
        }

        // If no new window was found, return empty string
        if (newWindow == null) {
            return "";
        }

        try {
            // Switch to the new window
            driver.switchTo().window(newWindow);

            // Wait for the text to be present in the body
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
            String message = body.getText().trim();

            // If we found the message, return it
            if (message.equals(expectedMessage)) {
                return message;
            }
            return "";
        } catch (Exception e) {
            // If anything goes wrong (window closed, etc), return empty string
            return "";
        } finally {
            try {
                // Always try to switch back to the original window
                driver.switchTo().window(originalWindow);
            } catch (Exception e) {
                // If we can't switch back, the test will fail anyway
            }
        }
    }

    public String getNewTabText() {
        return newTabButton.getText();
    }

    public String getNewWindowText() {
        return newWindowButton.getText();
    }

    public String getNewWindowMessageText() {
        return newWindowMessageButton.getText();
    }

    public String getBrowserWindowsText() {
        return header.getText();
    }
}
